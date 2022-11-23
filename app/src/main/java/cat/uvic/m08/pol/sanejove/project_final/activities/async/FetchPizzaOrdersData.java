package cat.uvic.m08.pol.sanejove.project_final.activities.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;

public class FetchPizzaOrdersData extends AsyncTask<Void,Void,String> {
    private String sql;
    public FetchPizzaOrdersData(){
        super();
    }
    @Override
    protected String doInBackground(Void... voids) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String pizzaOrdersJsonStr = null;
        String sql="SELECT * FROM PIZZA_ORDER;";
        try{

            URL url=new URL("https://puntjif.com/teknos/gateway.php?sql="+sql);
            urlConnection=(HttpURLConnection) url.openConnection();
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
            System.out.println(pizzaOrdersJsonStr);
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

    }
}
