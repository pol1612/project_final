package cat.uvic.m08.pol.sanejove.project_final.singletone;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cat.uvic.m08.pol.sanejove.project_final.adapter.PizzaOrderAdapter;
import cat.uvic.m08.pol.sanejove.project_final.entities.PizzaOrder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class AppSingleton extends AppCompatActivity {



    private ArrayList<PizzaOrder> pizzaOrderArrayList;
    private int currentPosition;
    private PizzaOrder pizzaOrder;
    private PizzaOrderAdapter pizzaOrderAdapter;
    private Context appContext;
    private String jsonData;

    private static class SingletonInstance {
        private static AppSingleton INSTANCE = new AppSingleton();
    }

    public static AppSingleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

    private AppSingleton() {
        //Constructor Singleton
        pizzaOrder=new PizzaOrder();
    }

    public  void setPizzOrderArrayToMySQLDataBase(){
        new FetchPizzaOrdersData().execute();
        System.out.println("jsonData from table in database in server: \n"+jsonData);

        jsonData="[]";
        Type userListType = new TypeToken<ArrayList<PizzaOrder>>(){}.getType();
        pizzaOrderArrayList = new Gson().fromJson(jsonData, userListType);

    }
    public void updatePizzaOrderArrayListItem(){
        pizzaOrderArrayList.set(currentPosition,pizzaOrder);


    }
    public void deleteFromPizzaOrderArrayListItem(){
        pizzaOrderArrayList.remove(currentPosition);


    }
    public void saveToPizzaOrderArrayListItem(){
        pizzaOrderArrayList.add(pizzaOrder);

    }
    public void writeListToJSONFile(){
        String jsonData=new Gson().toJson(pizzaOrderArrayList);
        writeToInternalFile("arrayListData.json",jsonData);

    }
    public ArrayList<PizzaOrder> getPizzaOrderArrayList() { return pizzaOrderArrayList; }

    public void setPizzaOrderArrayList(ArrayList<PizzaOrder> pizzaOrderArrayList) {
        this.pizzaOrderArrayList = pizzaOrderArrayList;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public PizzaOrder getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    public PizzaOrderAdapter getPizzaOrderAdapter() {
        return pizzaOrderAdapter;
    }

    public void setPizzaOrderAdapter(PizzaOrderAdapter pizzaOrderAdapter) {
        this.pizzaOrderAdapter = pizzaOrderAdapter;
    }
    public void writeToInternalFile(String fileName, String content){
        File path=appContext.getFilesDir();
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(new File(path,fileName));
            fileOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String readFromInternalFile(String fileName){
        File path=appContext.getFilesDir();
        File fileToReadFrom=new File(path,fileName);
        byte[] content=new byte[(int) fileToReadFrom.length()];
        try{
            FileInputStream fileInputStream=new FileInputStream(fileToReadFrom);
            fileInputStream.read(content);
            return new String(content);
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }
    private boolean internalFileExists(String fileName) {
        File path=appContext.getFilesDir();
        File file=new File(path,fileName);
        return file.exists();
    }

    public Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context appContext) {
        this.appContext = appContext;
    }

    private class FetchPizzaOrdersData extends AsyncTask<Void,Void,String> {
        private String sql;
        public FetchPizzaOrdersData(){
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
            jsonData=s;
            System.out.println("setted jsonData");
        }
    }

}