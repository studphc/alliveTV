package p000;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class us1 {
    @DoNotInline
    /* renamed from: a */
    public static NotificationChannel m7765a(NotificationManager notificationManager, String str, String str2) {
        return notificationManager.getNotificationChannel(str, str2);
    }

    @DoNotInline
    /* renamed from: b */
    public static String m7766b(NotificationChannel notificationChannel) {
        return notificationChannel.getParentChannelId();
    }
}
