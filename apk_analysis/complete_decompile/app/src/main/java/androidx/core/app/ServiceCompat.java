package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.bh2;
import p000.ch2;
import p000.dh2;

/* loaded from: classes.dex */
public final class ServiceCompat {
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface StopForegroundFlags {
    }

    public static void startForeground(@NonNull Service service, int i, @NonNull Notification notification, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 34) {
            dh2.m4585a(service, i, notification, i2);
        } else if (i3 >= 29) {
            ch2.m2234a(service, i, notification, i2);
        } else {
            service.startForeground(i, notification);
        }
    }

    public static void stopForeground(@NonNull Service service, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            bh2.m2099a(service, i);
            return;
        }
        boolean z = true;
        if ((i & 1) == 0) {
            z = false;
        }
        service.stopForeground(z);
    }
}
