package p000;

import android.app.Notification;
import android.app.Service;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ch2 {
    @DoNotInline
    /* renamed from: a */
    public static void m2234a(Service service, int i, Notification notification, int i2) {
        if (i2 != 0 && i2 != -1) {
            service.startForeground(i, notification, i2 & 255);
        } else {
            service.startForeground(i, notification, i2);
        }
    }
}
