package androidx.core.app;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.x */
/* loaded from: classes.dex */
public abstract class AbstractC0173x {
    @DoNotInline
    /* renamed from: a */
    public static Notification.MessagingStyle m793a(android.app.Person person) {
        return new Notification.MessagingStyle(person);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.MessagingStyle m794b(Notification.MessagingStyle messagingStyle, boolean z) {
        return messagingStyle.setGroupConversation(z);
    }
}
