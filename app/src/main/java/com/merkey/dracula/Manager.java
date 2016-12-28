package com.merkey.dracula;

import java.net.CookieManager;
import java.util.ArrayList;

/**
 * Created by Emad Yehya on 12/27/2016.
 */

public class Manager {
    private static Manager _instance = null;
    protected Manager() { }
    public static Manager getInstance() {
        if(_instance == null) {
            _instance = new Manager();
        }
        return _instance;
    }

    //TODO(emad): fill these
    static final public String BACKEND_URL_BASE = "TBD";
    static final public String BACKEND_CHECK_REGISTERED = "TBD";
    static final public String BACKEND_REGISTER = "TBD";
    static final public String BACKEND_REQUEST_DRONE = "TBD";
    static final public String BACKEND_CHECK_DRONE_FLYING = "TBD";

    ArrayList<String> web_results;
    boolean web_request_in_progress = false;

    public CookieManager cj = new CookieManager();

}
