package p000;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class da2 {
    @DoNotInline
    /* renamed from: a */
    public static RemoteAction m4559a(Icon icon, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        return new RemoteAction(icon, charSequence, charSequence2, pendingIntent);
    }

    @DoNotInline
    /* renamed from: b */
    public static PendingIntent m4560b(RemoteAction remoteAction) {
        return remoteAction.getActionIntent();
    }

    @DoNotInline
    /* renamed from: c */
    public static CharSequence m4561c(RemoteAction remoteAction) {
        return remoteAction.getContentDescription();
    }

    @DoNotInline
    /* renamed from: d */
    public static Icon m4562d(RemoteAction remoteAction) {
        return remoteAction.getIcon();
    }

    @DoNotInline
    /* renamed from: e */
    public static CharSequence m4563e(RemoteAction remoteAction) {
        return remoteAction.getTitle();
    }

    @DoNotInline
    /* renamed from: f */
    public static boolean m4564f(RemoteAction remoteAction) {
        return remoteAction.isEnabled();
    }

    @DoNotInline
    /* renamed from: g */
    public static void m4565g(RemoteAction remoteAction, boolean z) {
        remoteAction.setEnabled(z);
    }
}
