package androidx.core.app;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.v */
/* loaded from: classes.dex */
public abstract class AbstractC0171v {
    @DoNotInline
    /* renamed from: a */
    public static Notification.MessagingStyle m789a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
        return messagingStyle.addMessage(message);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.MessagingStyle m790b(CharSequence charSequence) {
        return new Notification.MessagingStyle(charSequence);
    }

    @DoNotInline
    /* renamed from: c */
    public static Notification.MessagingStyle m791c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
        return messagingStyle.setConversationTitle(charSequence);
    }
}
