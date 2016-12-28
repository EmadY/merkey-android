package com.merkey.dracula;

import android.util.Log;

import java.io.File;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Emad Yehya on 12/28/2016.
 */

public class URLData {
    //class that creates a URL with params for GET/POST requests

    private List<String> arg_name = new ArrayList<String>();
    private List<String> arg_val = new ArrayList<String>();
    private String path;
    public URLData(String p){path = p;}
    public void addParams(String n, String v){
        arg_name.add(n);
        arg_val.add(v);
    }

    public URL getURL(String base){
        URL ret = null;
        String urlStr = base + path + "?" + getParams();
        try {
            ret = new URL(urlStr);
        } catch (MalformedURLException e){
            Log.e("CAUGHT_ERR", "malformed in getURL in URLData Class");
        }
        return ret;
    }

    public URL getPureURL(String base){
        URL ret = null;
        String urlStr = base + path;
        try {
            ret = new URL(urlStr);
        } catch (MalformedURLException e){
            Log.e("CAUGHT_ERR", "malformed in getURL in URLData Class");
        }
        return ret;
    }

    public String getParams(){
        String ret = "";
        if(arg_name.size() != 0){
            for(int i = 0; i < arg_name.size(); i++){
                try {
                    ret += URLEncoder.encode(arg_name.get(i).toString(), "UTF-8") + "=" + URLEncoder.encode(arg_val.get(i).toString(), "UTF-8");
                } catch(Exception e){

                }
                if(i != arg_name.size()-1){
                    ret += "&";
                }
            }
        }

        return ret;
    }

    //TPD
    public ArrayList<String> execute(boolean isPost, Runnable r){
        ArrayList<String> ret = new ArrayList<String>();
        CookieManager cj = Manager.getInstance().cj;
        try{
            if(isPost){
                new PostRequest(cj, r).execute(this);
            } else {
                new GetRequest(cj, r).execute(this);
            }
        } catch(Exception e){
            ret.add("099");
            ret.add("This is a weird error. Please try reconnecting at another time.");
        }
        if(ret.size() == 0) {
            ret.add("044");
            ret.add("Server did not respond. Please try reconnecting at another time.");
        }
        return  ret;
    }

    public ArrayList<String> execute(boolean isPost, CookieManager cj, Runnable r){
        ArrayList<String> ret = new ArrayList<String>();
        try{
            if(isPost){
                new PostRequest(cj, r).execute(this);
            } else {
                new GetRequest(cj, r).execute(this);
            }
        } catch(Exception e) {
            ret.add("099");
            ret.add("This is a weird error. Please try reconnecting at another time.");
        }
        if(ret.size() == 0) {
            ret.add("044");
            ret.add("Server did not respond. Please try reconnecting at another time.");
        }
        return  ret;
    }

}