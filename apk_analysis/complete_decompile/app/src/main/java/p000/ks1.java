package p000;

import android.app.Notification;
import android.app.Person;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ks1 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Builder m5785a(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Action.Builder m5786b(Notification.Action.Builder builder, int i) {
        return builder.setSemanticAction(i);
    }
}
