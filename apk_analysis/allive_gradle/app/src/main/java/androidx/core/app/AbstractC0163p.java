package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.p */
/* loaded from: classes.dex */
public abstract class AbstractC0163p {
    @DoNotInline
    /* renamed from: a */
    public static Parcelable m761a(Icon icon) {
        return icon;
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Action.Builder m762b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(icon, charSequence, pendingIntent);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m763c(Notification.Builder builder, Icon icon) {
        builder.setLargeIcon(icon);
    }
}
