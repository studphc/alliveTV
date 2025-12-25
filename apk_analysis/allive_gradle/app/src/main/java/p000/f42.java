package p000;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class f42 {
    @DoNotInline
    /* renamed from: a */
    public static void m4769a(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) {
        pendingIntent.send(context, i, intent, onFinished, handler, str, bundle);
    }
}
