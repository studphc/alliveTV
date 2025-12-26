package androidx.core.app;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.e0 */
/* loaded from: classes.dex */
public abstract class AbstractC0147e0 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Action.Builder m727a(Notification.Action.Builder builder, boolean z) {
        return builder.setAuthenticationRequired(z);
    }
}
