package p000;

import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ts1 {
    @DoNotInline
    /* renamed from: a */
    public static NotificationChannelGroup m7511a(NotificationManager notificationManager, String str) {
        return notificationManager.getNotificationChannelGroup(str);
    }
}
