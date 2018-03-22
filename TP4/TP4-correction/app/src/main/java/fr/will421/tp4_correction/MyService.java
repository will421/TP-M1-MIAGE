package fr.will421.tp4_correction;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyService extends IntentService {
    
    // It is better to have long action name, it avoid other app to subscribe to it by error
    public static String ACTION_DONE = "fr.will421.tp4_correction.MyService.ACTION_DONE";
    
    public MyService() {
        super("MyService");
    }
    
    @Override
    protected void onHandleIntent(Intent workIntent) {
        //faire la génération dans la classe Application serait aussi une bonne idée
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://yesno.wtf/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        YesNoService service = retrofit.create(YesNoService.class);
    
    
        Intent localIntent =
                new Intent(ACTION_DONE);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
        
        
    }
    
}
