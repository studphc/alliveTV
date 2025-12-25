package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.c0 */
/* loaded from: classes.dex */
public abstract class AbstractC0143c0 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Action.Builder m723a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(icon, charSequence, pendingIntent);
    }
}
