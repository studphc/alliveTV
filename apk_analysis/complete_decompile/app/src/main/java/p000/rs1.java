package p000;

import android.app.NotificationManager;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class rs1 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m7298a(NotificationManager notificationManager) {
        return notificationManager.areNotificationsEnabled();
    }

    @DoNotInline
    /* renamed from: b */
    public static int m7299b(NotificationManager notificationManager) {
        return notificationManager.getImportance();
    }
}
