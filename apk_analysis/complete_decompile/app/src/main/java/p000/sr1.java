package p000;

import android.app.NotificationChannel;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class sr1 {
    @DoNotInline
    /* renamed from: a */
    public static String m7397a(NotificationChannel notificationChannel) {
        return notificationChannel.getConversationId();
    }

    @DoNotInline
    /* renamed from: b */
    public static String m7398b(NotificationChannel notificationChannel) {
        return notificationChannel.getParentChannelId();
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m7399c(NotificationChannel notificationChannel) {
        return notificationChannel.isImportantConversation();
    }

    @DoNotInline
    /* renamed from: d */
    public static void m7400d(NotificationChannel notificationChannel, String str, String str2) {
        notificationChannel.setConversationId(str, str2);
    }
}
