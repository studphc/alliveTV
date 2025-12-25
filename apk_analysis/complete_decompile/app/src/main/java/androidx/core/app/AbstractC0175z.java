package androidx.core.app;

import android.app.Notification;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.z */
/* loaded from: classes.dex */
public abstract class AbstractC0175z {
    @DoNotInline
    /* renamed from: a */
    public static Parcelable m797a(android.app.Person person) {
        return person;
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.MessagingStyle.Message m798b(CharSequence charSequence, long j, android.app.Person person) {
        return new Notification.MessagingStyle.Message(charSequence, j, person);
    }
}
