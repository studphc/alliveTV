package p000;

import android.app.NotificationChannelGroup;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ur1 {
    @DoNotInline
    /* renamed from: a */
    public static String m7762a(NotificationChannelGroup notificationChannelGroup) {
        return notificationChannelGroup.getDescription();
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m7763b(NotificationChannelGroup notificationChannelGroup) {
        return notificationChannelGroup.isBlocked();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m7764c(NotificationChannelGroup notificationChannelGroup, String str) {
        notificationChannelGroup.setDescription(str);
    }
}
