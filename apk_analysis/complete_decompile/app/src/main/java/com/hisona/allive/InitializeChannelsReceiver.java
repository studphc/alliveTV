package com.hisona.allive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes2.dex */
public class InitializeChannelsReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.e("InitializeChannelsReceiver", "onReceive(): " + intent);
    }
}
