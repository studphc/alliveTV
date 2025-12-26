package p000;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import androidx.annotation.DoNotInline;
import java.util.List;

/* loaded from: classes.dex */
public abstract class tr1 {
    @DoNotInline
    /* renamed from: a */
    public static NotificationChannelGroup m7505a(String str, CharSequence charSequence) {
        return new NotificationChannelGroup(str, charSequence);
    }

    @DoNotInline
    /* renamed from: b */
    public static List<NotificationChannel> m7506b(NotificationChannelGroup notificationChannelGroup) {
        return notificationChannelGroup.getChannels();
    }

    @DoNotInline
    /* renamed from: c */
    public static String m7507c(NotificationChannel notificationChannel) {
        return notificationChannel.getGroup();
    }

    @DoNotInline
    /* renamed from: d */
    public static String m7508d(NotificationChannelGroup notificationChannelGroup) {
        return notificationChannelGroup.getId();
    }

    @DoNotInline
    /* renamed from: e */
    public static CharSequence m7509e(NotificationChannelGroup notificationChannelGroup) {
        return notificationChannelGroup.getName();
    }
}
