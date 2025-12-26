package p000;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class hs1 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Action.Builder m5127a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(icon, charSequence, pendingIntent);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Builder m5128b(Notification.Builder builder, Icon icon) {
        return builder.setLargeIcon(icon);
    }

    @DoNotInline
    /* renamed from: c */
    public static Notification.Builder m5129c(Notification.Builder builder, Object obj) {
        return builder.setSmallIcon((Icon) obj);
    }
}
