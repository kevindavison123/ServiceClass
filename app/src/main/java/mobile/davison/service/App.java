package mobile.davison.service;

import android.app.Application;
import android.content.Context;



/**
 * Created by Kevin on 10/28/2015.
 * This is made to set and get the context for the Activities to Async Tasks to show Toasts and progress Dialogs etc.
 */
public class App extends Application {
    private static Context context;

    public static Context getContext()
    {
        return App.context;
    }

    public static void setContext(Context context)
    {
        App.context = context;
    }
}
