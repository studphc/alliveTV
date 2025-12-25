package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;

/* renamed from: ew */
/* loaded from: classes.dex */
public abstract class AbstractC1173ew {
    @DoNotInline
    /* renamed from: a */
    public static Intent m4760a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
    }
}
