package androidx.core.app;

import android.app.Notification;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.q */
/* loaded from: classes.dex */
public abstract class AbstractC0164q {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Builder m764a(Notification.Builder builder, android.app.Person person) {
        return builder.addPerson(person);
    }

    @DoNotInline
    /* renamed from: b */
    public static Parcelable m765b(android.app.Person person) {
        return person;
    }
}
