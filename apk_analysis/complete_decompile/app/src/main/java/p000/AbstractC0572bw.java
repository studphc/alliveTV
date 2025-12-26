package p000;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/* renamed from: bw */
/* loaded from: classes.dex */
public abstract class AbstractC0572bw {
    @DoNotInline
    /* renamed from: a */
    public static Intent m2172a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if ((i & 4) != 0 && str == null) {
            return context.registerReceiver(broadcastReceiver, intentFilter, ContextCompat.m799a(context), handler);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i & 1);
    }

    @DoNotInline
    /* renamed from: b */
    public static ComponentName m2173b(Context context, Intent intent) {
        return context.startForegroundService(intent);
    }
}
