package fr.will421.tp4_correction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    
    private static int NOTIFICATION_ID=  1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
//        Intent githubIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com"));
//        PendingIntent githubPendingIntent =
//                PendingIntent.getActivity(this, 0, githubIntent, 0);
//
//        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
//                .setSmallIcon(android.R.drawable.sym_def_app_icon)
//                .setContentTitle("Hello world")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .addAction(android.R.drawable.ic_menu_compass, "Go to github",
//                        githubPendingIntent);
    
        final Intent serviceIntent = new Intent(this, MyService.class);
    
    
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
//                notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
                startService(serviceIntent);
            }
        });
    }
}
