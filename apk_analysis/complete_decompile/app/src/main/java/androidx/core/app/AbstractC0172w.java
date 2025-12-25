package androidx.core.app;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.w */
/* loaded from: classes.dex */
public abstract class AbstractC0172w {
    @DoNotInline
    /* renamed from: a */
    public static Notification.MessagingStyle m792a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
        return messagingStyle.addHistoricMessage(message);
    }
}
