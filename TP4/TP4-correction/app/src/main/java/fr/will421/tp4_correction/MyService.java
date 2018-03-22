package fr.will421.tp4_correction;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyService extends IntentService {
    
    // It is better to have long action name, it avoid other app to subscribe to it by error
    public static String ACTION_DONE = "fr.will421.tp4_correction.MyService.ACTION_DONE";
    public static String EXTRA_ANSWER = "fr.will421.tp4_correction.MyService.EXTRA_ANSWER";
    public static String EXTRA_IMAGE = "fr.will421.tp4_correction.MyService.EXTRA_IMAGE";
    
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
        service.getAnswer().enqueue(new Callback<YesNoAnswer>() {
            @Override
            public void onResponse(Call<YesNoAnswer> call, Response<YesNoAnswer> response) {
                if(response.isSuccessful()){
                    YesNoAnswer answser = response.body();
    
    
                    Intent localIntent =
                            new Intent(ACTION_DONE);
                    // we could also do it by giving it the whole "YesNoAnswser" object. But he have to implement Parcelable or Serializable
                    // http://www.vogella.com/tutorials/AndroidParcelable/article.html
                    localIntent.putExtra(EXTRA_ANSWER,answser.getAnswer());
                    localIntent.putExtra(EXTRA_IMAGE,answser.getImage());
                    
                    LocalBroadcastManager.getInstance(MyService.this).sendBroadcast(localIntent);
                } else {
                    // error response, no access to resource ?
                    Log.e("MyService","Error response :"+response.message());
                }
            }
    
            @Override
            public void onFailure(Call<YesNoAnswer> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.e("MyService","Failure",t);
            }
        });
    }
    
}
