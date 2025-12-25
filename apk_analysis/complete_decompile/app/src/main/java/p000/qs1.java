package p000;

import android.app.NotificationManager;
import android.service.notification.StatusBarNotification;
import androidx.annotation.DoNotInline;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class qs1 {
    @DoNotInline
    /* renamed from: a */
    public static List<StatusBarNotification> m7145a(NotificationManager notificationManager) {
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        if (activeNotifications == null) {
            return new ArrayList();
        }
        return Arrays.asList(activeNotifications);
    }

    @DoNotInline
    /* renamed from: b */
    public static int m7146b(NotificationManager notificationManager) {
        return notificationManager.getCurrentInterruptionFilter();
    }
}
