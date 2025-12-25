package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;

/* renamed from: androidx.core.app.b0 */
/* loaded from: classes.dex */
public abstract class AbstractC0141b0 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Action.Builder m717a(Notification.Action.Builder builder, Bundle bundle) {
        return builder.addExtras(bundle);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Action.Builder m718b(Notification.Action.Builder builder, android.app.RemoteInput remoteInput) {
        return builder.addRemoteInput(remoteInput);
    }

    @DoNotInline
    /* renamed from: c */
    public static Notification.Action m719c(Notification.Action.Builder builder) {
        return builder.build();
    }

    @DoNotInline
    /* renamed from: d */
    public static Notification.Action.Builder m720d(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(i, charSequence, pendingIntent);
    }

    @DoNotInline
    /* renamed from: e */
    public static NotificationCompat.Action m721e(ArrayList<Parcelable> arrayList, int i) {
        return NotificationCompat.m694a((Notification.Action) arrayList.get(i));
    }
}
