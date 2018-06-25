package zhutao.android.com.broadcasttest;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2017/7/10.
 */

public class BroadcastSend {
    public static final String MESSAGE = "message";

    public static void send(Context context) {
        Intent intent = new Intent();
        intent.setAction(MESSAGE);
        context.sendBroadcast(intent);
    }
}
