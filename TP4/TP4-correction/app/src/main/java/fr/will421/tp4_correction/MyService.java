package fr.will421.tp4_correction;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class MyService extends IntentService {
    
    // It is better to have long action name, it avoid other app to subscribe to it by error
    public static String ACTION_DONE = "fr.will421.tp4_correction.MyService.ACTION_DONE";
    
    public MyService() {
        super("MyService");
    }
    
    @Override
    protected void onHandleIntent(Intent workIntent) {
        try {
            Thread.sleep(2000);
            Intent localIntent =
                    new Intent(ACTION_DONE);
            LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    
    }
    
}
