package p000;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class es1 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m4754a(Notification.Action action) {
        return action.isAuthenticationRequired();
    }
}
