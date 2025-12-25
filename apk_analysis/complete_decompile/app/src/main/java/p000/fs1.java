package p000;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Bundle;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class fs1 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Builder m4830a(Notification.Builder builder, Notification.Action action) {
        return builder.addAction(action);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Action.Builder m4831b(Notification.Action.Builder builder, Bundle bundle) {
        return builder.addExtras(bundle);
    }

    @DoNotInline
    /* renamed from: c */
    public static Notification.Action.Builder m4832c(Notification.Action.Builder builder, RemoteInput remoteInput) {
        return builder.addRemoteInput(remoteInput);
    }

    @DoNotInline
    /* renamed from: d */
    public static Notification.Action m4833d(Notification.Action.Builder builder) {
        return builder.build();
    }

    @DoNotInline
    /* renamed from: e */
    public static Notification.Action.Builder m4834e(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(i, charSequence, pendingIntent);
    }

    @DoNotInline
    /* renamed from: f */
    public static String m4835f(Notification notification) {
        return notification.getGroup();
    }

    @DoNotInline
    /* renamed from: g */
    public static Notification.Builder m4836g(Notification.Builder builder, String str) {
        return builder.setGroup(str);
    }

    @DoNotInline
    /* renamed from: h */
    public static Notification.Builder m4837h(Notification.Builder builder, boolean z) {
        return builder.setGroupSummary(z);
    }

    @DoNotInline
    /* renamed from: i */
    public static Notification.Builder m4838i(Notification.Builder builder, boolean z) {
        return builder.setLocalOnly(z);
    }

    @DoNotInline
    /* renamed from: j */
    public static Notification.Builder m4839j(Notification.Builder builder, String str) {
        return builder.setSortKey(str);
    }
}
