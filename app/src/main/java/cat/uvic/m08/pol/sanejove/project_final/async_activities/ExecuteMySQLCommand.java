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

public class ExecuteMySQLCommand extends AsyncTask<Void,Void,String> {
    private String sql;
    public ExecuteMySQLCommand(){
        super();
    }
    @Override
    protected String doInBackground(Void... voids) {
        System.out.println("started doInBackground");
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String pizzaOrdersJsonStr = null;
        String sql="SELECT * FROM Pizza_Order;";
        try{

            URL url=new URL("https://puntjif.com/teknos/gateway.php?sql="+sql);
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
        if(!s.isEmpty()){
            AppSingleton.getInstance().setJsonDataFromMySQLDataBase(s);
            System.out.println("setted jsonDataFromMySQLDataBase");
        }


    }
}
