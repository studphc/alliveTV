package androidx.core.app;

import android.app.Notification;
import android.net.Uri;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.y */
/* loaded from: classes.dex */
public abstract class AbstractC0174y {
    @DoNotInline
    /* renamed from: a */
    public static Notification.MessagingStyle.Message m795a(CharSequence charSequence, long j, CharSequence charSequence2) {
        return new Notification.MessagingStyle.Message(charSequence, j, charSequence2);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.MessagingStyle.Message m796b(Notification.MessagingStyle.Message message, String str, Uri uri) {
        return message.setData(str, uri);
    }
}
