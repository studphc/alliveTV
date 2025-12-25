package p000;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class g42 {
    @DoNotInline
    /* renamed from: a */
    public static PendingIntent m4916a(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getForegroundService(context, i, intent, i2);
    }
}
