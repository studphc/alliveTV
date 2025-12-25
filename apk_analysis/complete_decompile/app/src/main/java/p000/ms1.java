package p000;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ms1 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Action.Builder m6246a(Notification.Action.Builder builder, boolean z) {
        return builder.setAuthenticationRequired(z);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Builder m6247b(Notification.Builder builder, int i) {
        return builder.setForegroundServiceBehavior(i);
    }
}
