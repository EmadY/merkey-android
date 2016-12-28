package com.merkey.dracula;

import android.os.AsyncTask;
import android.os.Handler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Emad Yehya on 12/28/2016.
 */

public class GetRequest extends AsyncTask<URLData,String,ArrayList<String> > {
    //constructor requries a cookie Manager to maintain state
    //takes URLData, runs GET requests on all of them with the BASE provided
    //returns ArrayList<String>, with each line of data on a different index
    //different URL data are seperated with the string: 'IAmEmadDelim'

    final String BASE = Manager.getInstance().BACKEND_URL_BASE;
    CookieManager cj = new CookieManager();
    Runnable runnable;

    public GetRequest(CookieManager CJ, Runnable r){
        CookieHandler.setDefault(CJ);
        cj = CJ; runnable = r;
    }
    @Override
    protected ArrayList<String> doInBackground(URLData... gURL) {
        ArrayList<String> ret = new ArrayList<>();
        URL sURL = gURL[0].getURL(BASE);
        try {
            HttpURLConnection cnx = (HttpURLConnection) sURL.openConnection();
            InputStream in = new BufferedInputStream(cnx.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder result = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                ret.add(line);
            }
            cnx.disconnect();
        } catch (IOException e) {

        } catch (NullPointerException e) {

        }
        return ret;
    }

    @Override
    protected void onPostExecute(ArrayList<String> result) {
        if(runnable != null) {
            if(result.size() == 0){
                result.add("099");
                result.add("This is a weird error. Please try reconnecting at another time.");
            }
            Manager.getInstance().web_results = result;
            new Handler().post(runnable);
        }
    }
}