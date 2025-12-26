package androidx.core.app;

import android.app.Notification;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.d0 */
/* loaded from: classes.dex */
public abstract class AbstractC0145d0 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Action.Builder m725a(Notification.Action.Builder builder, boolean z) {
        return builder.setAllowGeneratedReplies(z);
    }
}
