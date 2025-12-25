package p000;

import android.app.Notification;
import android.content.Context;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class js1 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Builder m5451a(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Builder m5452b(Notification.Builder builder, int i) {
        return builder.setBadgeIconType(i);
    }

    @DoNotInline
    /* renamed from: c */
    public static Notification.Builder m5453c(Notification.Builder builder, boolean z) {
        return builder.setColorized(z);
    }

    @DoNotInline
    /* renamed from: d */
    public static Notification.Builder m5454d(Notification.Builder builder, int i) {
        return builder.setGroupAlertBehavior(i);
    }

    @DoNotInline
    /* renamed from: e */
    public static Notification.Builder m5455e(Notification.Builder builder, CharSequence charSequence) {
        return builder.setSettingsText(charSequence);
    }

    @DoNotInline
    /* renamed from: f */
    public static Notification.Builder m5456f(Notification.Builder builder, String str) {
        return builder.setShortcutId(str);
    }

    @DoNotInline
    /* renamed from: g */
    public static Notification.Builder m5457g(Notification.Builder builder, long j) {
        return builder.setTimeoutAfter(j);
    }
}
