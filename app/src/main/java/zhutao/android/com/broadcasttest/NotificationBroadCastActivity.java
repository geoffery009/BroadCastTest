package zhutao.android.com.broadcasttest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

/**
 * Created by Administrator on 2017/7/27.
 */

public class NotificationBroadCastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            public NotificationManager mNotifyManager;

            @Override
            public void onClick(View view) {
                mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NotificationBroadCastActivity.this);
                Intent intent = new Intent();
                intent.setAction(BroadcastSend.MESSAGE);
                PendingIntent pi = PendingIntent.getBroadcast(NotificationBroadCastActivity.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentText("点击")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("消息")
                        .setContentIntent(pi);
                mNotifyManager.notify(2, mBuilder.build());
                NotificationBroadCastActivity.this.finish();
            }
        });
    }
}
