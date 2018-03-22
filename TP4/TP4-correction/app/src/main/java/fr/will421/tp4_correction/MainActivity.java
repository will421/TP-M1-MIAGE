package fr.will421.tp4_correction;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    
    private static int NOTIFICATION_ID=  1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //we have only one action in the filter, so we do not need to check it
    
                Intent githubIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra(MyService.EXTRA_IMAGE)));
                PendingIntent githubPendingIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, githubIntent, 0);
    
                final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(android.R.drawable.sym_def_app_icon)
                        .setContentTitle("Answer")
                        .setContentText(intent.getStringExtra(MyService.EXTRA_ANSWER))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .addAction(android.R.drawable.ic_menu_compass, "See gif",
                                githubPendingIntent);
                
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
            }
        };
    
    
        IntentFilter myServiceIntentFilter = new IntentFilter(
                MyService.ACTION_DONE);
    
        LocalBroadcastManager.getInstance(this).registerReceiver(
                receiver,
                myServiceIntentFilter);
    
        final Intent serviceIntent = new Intent(this, MyService.class);
    
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(serviceIntent);
            }
        });
    }
}
