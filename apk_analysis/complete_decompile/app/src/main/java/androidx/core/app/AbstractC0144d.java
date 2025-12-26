package androidx.core.app;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.d */
/* loaded from: classes.dex */
public abstract class AbstractC0144d {
    @DoNotInline
    /* renamed from: a */
    public static boolean m724a(Notification.Action action) {
        return action.getAllowGeneratedReplies();
    }
}
