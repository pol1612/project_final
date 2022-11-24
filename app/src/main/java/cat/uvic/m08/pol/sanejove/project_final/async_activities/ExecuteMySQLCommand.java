package cat.uvic.m08.pol.sanejove.project_final.async_activities;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import cat.uvic.m08.pol.sanejove.project_final.singletone.AppSingleton;

public class ExecuteMySQLCommand extends AsyncTask<Object,Void,String> {
    private AppSingleton caller;
    @Override
    protected String doInBackground(Object... params) {
        System.out.println("started doInBackground");
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String pizzaOrdersJsonStr = null;
        caller=(AppSingleton) params[1];
        try{

            URL url=new URL((String) params[0]);
            urlConnection=(HttpURLConnection) url.openConnection();
            if(urlConnection==null){
                System.out.println("url connection null");
            }
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }
            pizzaOrdersJsonStr = buffer.toString();
            System.out.println("pizzaOrdersJsonStr: "+pizzaOrdersJsonStr);
            return pizzaOrdersJsonStr;
        }catch (IOException e){
            Log.e("PlaceholderFragment", "Error ", e);
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(urlConnection!=null){
                urlConnection.disconnect();
            }if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s!=null){
            AppSingleton.getInstance().setJsonDataFromMySQLDataBase(s);
            System.out.println("setted jsonDataFromMySQLDataBase");
        }
        System.out.println("not setted jsonDataFromMySQLDataBase");


    }
}
