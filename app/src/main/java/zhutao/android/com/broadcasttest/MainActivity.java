package zhutao.android.com.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NetworkConnectChangedReceiver networkConnectChangedReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkNetworkStatus();
        getMessage();
        init();
    }

    private MyDymReceiver dymReceiver = new MyDymReceiver();
    private void init() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("aaaaa");
        registerReceiver(dymReceiver, filter);
    }
    public void msg(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button3:
                Intent intentFileter = new Intent("com.ybs.send.demo_ybs_broadcastreceiver");
                intentFileter.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intentFileter);
                break;
            case R.id.button2:
                Intent intent2 = new Intent("aaaaa");
                sendBroadcast(intent2);
                break;
        }
    }

    //监听网络状态
    private void checkNetworkStatus() {
        networkConnectChangedReceiver = new NetworkConnectChangedReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkConnectChangedReceiver, filter);
    }

    private void getMessage() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(BroadcastSend.MESSAGE);
        registerReceiver(testReceiver, filter);
    }

    private BroadcastReceiver testReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainActivity.this, "接受到广播", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onDestroy() {
        unregisterReceiver(networkConnectChangedReceiver);
        unregisterReceiver(testReceiver);
        unregisterReceiver(dymReceiver);
        super.onDestroy();
    }
}
