package zhutao.android.com.broadcasttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void close(View view) {
        sendBroadcast();
        this.finish();
    }

    public void sendBroadcast() {
        BroadcastSend.send(this);
    }
}
