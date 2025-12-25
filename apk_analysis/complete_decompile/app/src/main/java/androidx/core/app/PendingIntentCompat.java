package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;
import p000.f42;
import p000.g42;
import p000.i42;

/* loaded from: classes.dex */
public final class PendingIntentCompat {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    /* renamed from: a */
    public static int m707a(int i, boolean z) {
        int i2;
        if (z) {
            if (Build.VERSION.SDK_INT >= 31) {
                i2 = 33554432;
            } else {
                return i;
            }
        } else {
            i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        }
        return i | i2;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i2, @Nullable Bundle bundle, boolean z) {
        return PendingIntent.getActivities(context, i, intentArr, m707a(i2, z), bundle);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i, @NonNull Intent intent, int i2, boolean z) {
        return PendingIntent.getActivity(context, i, intent, m707a(i2, z));
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context context, int i, @NonNull Intent intent, int i2, boolean z) {
        return PendingIntent.getBroadcast(context, i, intent, m707a(i2, z));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context context, int i, @NonNull Intent intent, int i2, boolean z) {
        return g42.m4916a(context, i, intent, m707a(i2, z));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context context, int i, @NonNull Intent intent, int i2, boolean z) {
        return PendingIntent.getService(context, i, intent, m707a(i2, z));
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, int i, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) {
        final i42 i42Var = new i42(onFinished);
        try {
            pendingIntent.send(i, i42Var.f18283b == null ? null : new PendingIntent.OnFinished() { // from class: h42
                @Override // android.app.PendingIntent.OnFinished
                public final void onSendFinished(PendingIntent pendingIntent2, Intent intent, int i2, String str, Bundle bundle) {
                    i42 i42Var2 = i42.this;
                    i42Var2.getClass();
                    boolean z = false;
                    while (true) {
                        try {
                            i42Var2.f18282a.await();
                            break;
                        } catch (InterruptedException unused) {
                            z = true;
                        } catch (Throwable th) {
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    PendingIntent.OnFinished onFinished2 = i42Var2.f18283b;
                    if (onFinished2 != null) {
                        onFinished2.onSendFinished(pendingIntent2, intent, i2, str, bundle);
                        i42Var2.f18283b = null;
                    }
                }
            }, handler);
            i42Var.f18284c = true;
            i42Var.close();
        } catch (Throwable th) {
            try {
                i42Var.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i2, boolean z) {
        return PendingIntent.getActivities(context, i, intentArr, m707a(i2, z));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i, @NonNull Intent intent, int i2, @Nullable Bundle bundle, boolean z) {
        return PendingIntent.getActivity(context, i, intent, m707a(i2, z), bundle);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @NonNull @SuppressLint({"ContextFirst"}) Context context, int i, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) {
        send(pendingIntent, context, i, intent, onFinished, handler, null, null);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @NonNull @SuppressLint({"ContextFirst"}) Context context, int i, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            f42.m4769a(pendingIntent, context, i, intent, onFinished, handler, str, bundle);
            countDownLatch.countDown();
        } catch (Throwable th) {
            try {
                countDownLatch.countDown();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
