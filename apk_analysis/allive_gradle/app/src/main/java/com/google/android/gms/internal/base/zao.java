package com.google.android.gms.internal.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* loaded from: classes.dex */
public final class zao extends ContextCompat {
    @Nullable
    @ResultIgnorabilityUnspecified
    @Deprecated
    public static Intent zaa(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i;
        Intent registerReceiver;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            if (i2 >= 33) {
                i = 2;
            } else {
                i = 0;
            }
            registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, i);
            return registerReceiver;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
