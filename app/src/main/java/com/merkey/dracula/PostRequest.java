package com.merkey.dracula;

import android.os.AsyncTask;
import android.os.Handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.util.ArrayList;

/**
 * Created by Emad Yehya on 12/28/2016.
 */

public class PostRequest extends AsyncTask<URLData, String, ArrayList<String>> {

    final String BASE = Manager.getInstance().BACKEND_URL_BASE;
    CookieManager cj = new CookieManager();
    Runnable runnable;

    public PostRequest(CookieManager CJ, Runnable r){
        CookieHandler.setDefault(CJ);
        cj = CJ; runnable = r;
    }

    @Override
    protected ArrayList<String> doInBackground(URLData... URLd) {
        ArrayList<String> ret = new ArrayList<>();

        try{
            HttpURLConnection conn = (HttpURLConnection) URLd[0].getPureURL(BASE).openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setFixedLengthStreamingMode(
                    URLd[0].getParams().getBytes().length);
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(URLd[0].getParams());
            out.close();
            int responseCode=conn.getResponseCode();
            String line;
            BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line=br.readLine()) != null) {
                ret.add(line.trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Manager.getInstance().cj = cj;

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
