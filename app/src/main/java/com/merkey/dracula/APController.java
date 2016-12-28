package com.merkey.dracula;

/**
 * Created by Emad Yehya on 12/28/2016.
 */


/*
 * Class logic is as follows: start and stop control whether it is doing stuff or not. Based on
 * whether the drone is active or not. DOES NOT HAVE TO BE DETERMINED BY THIS CLASS (this class has
 * no web interactions).
 *
 * On start, does the detect + transmit / restart algorithm based on constants. These have to be
 * tweaked to make preformance better. For now, TODO(ghazi): add them as settings in the options
 * so we don't have reinstall the app on every phone when testing. use the constants I provide.
 *
 * Should continuously read all input and find the min index (ie timer with very low tick time or
 * set it up so that everytime a new signal is detected/lost a function gets called. Second option
 * is much prefferable, but you can go with either for now).
 *
 * Should follow the cycles AFTER spotting a DrAcuLA Signal.
 *
 * Handles all sending and recieving of the signal. The functionality of the phone as an AP should
 * never leave this phone. TODO(ghazi): This class has to have extensive unit tests
 * (do only for this class if you must, but do it for this one).
 *
 * Is a singleton to avoid you messing up and declaring two or more and completely crashing the app
 * without realizing what went wrong -- you're welcome :).
 */
public class APController {
    private static APController _instance = null;
    protected APController() {}
    public static APController getInstance(){
        if(_instance == null){
            _instance = new APController();
        }
        return _instance;
    }

    int index_ = -1;

    // Called when drone is detected to be in flight. Will handle all logic.
    public void start() {

    }

    // Called when drone is detected to have stopped flight. Handles all stopping of timers and
    // reseting of variables.
    public void stop() {


        index_ = -1;
    }

    public int index() {
        return index_;
    }
}
