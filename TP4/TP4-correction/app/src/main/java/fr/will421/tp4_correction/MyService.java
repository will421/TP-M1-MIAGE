package fr.will421.tp4_correction;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyService extends IntentService {
    
    public MyService() {
        super("MyService");
    }
    
    @Override
    protected void onHandleIntent(Intent workIntent) {
        try {
            Thread.sleep(2000);
            Log.d("MyService","Executing...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    
    }
    
}
