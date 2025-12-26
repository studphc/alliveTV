package p000;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import androidx.annotation.DoNotInline;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ss1 {
    @DoNotInline
    /* renamed from: a */
    public static void m7402a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m7403b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
        notificationManager.createNotificationChannelGroup(notificationChannelGroup);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m7404c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
        notificationManager.createNotificationChannelGroups(list);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m7405d(NotificationManager notificationManager, List<NotificationChannel> list) {
        notificationManager.createNotificationChannels(list);
    }

    @DoNotInline
    /* renamed from: e */
    public static void m7406e(NotificationManager notificationManager, String str) {
        notificationManager.deleteNotificationChannel(str);
    }

    @DoNotInline
    /* renamed from: f */
    public static void m7407f(NotificationManager notificationManager, String str) {
        notificationManager.deleteNotificationChannelGroup(str);
    }

    @DoNotInline
    /* renamed from: g */
    public static String m7408g(NotificationChannel notificationChannel) {
        return notificationChannel.getId();
    }

    @DoNotInline
    /* renamed from: h */
    public static String m7409h(NotificationChannelGroup notificationChannelGroup) {
        return notificationChannelGroup.getId();
    }

    @DoNotInline
    /* renamed from: i */
    public static NotificationChannel m7410i(NotificationManager notificationManager, String str) {
        return notificationManager.getNotificationChannel(str);
    }

    @DoNotInline
    /* renamed from: j */
    public static List<NotificationChannelGroup> m7411j(NotificationManager notificationManager) {
        return notificationManager.getNotificationChannelGroups();
    }

    @DoNotInline
    /* renamed from: k */
    public static List<NotificationChannel> m7412k(NotificationManager notificationManager) {
        return notificationManager.getNotificationChannels();
    }
}
