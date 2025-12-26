package androidx.core.app;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.o */
/* loaded from: classes.dex */
public abstract class AbstractC0162o {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Builder m759a(Notification.Builder builder, String str) {
        return builder.addPerson(str);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Builder m760b(Notification.Builder builder, String str) {
        return builder.setCategory(str);
    }
}
