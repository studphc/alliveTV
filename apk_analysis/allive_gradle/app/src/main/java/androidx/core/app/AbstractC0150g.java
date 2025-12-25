package androidx.core.app;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.g */
/* loaded from: classes.dex */
public abstract class AbstractC0150g {
    @DoNotInline
    /* renamed from: a */
    public static boolean m732a(Notification.Action action) {
        return action.isAuthenticationRequired();
    }
}
