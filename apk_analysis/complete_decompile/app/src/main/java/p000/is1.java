package p000;

import android.app.Notification;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class is1 {
    @DoNotInline
    /* renamed from: a */
    public static Notification.Action.Builder m5362a(Notification.Action.Builder builder, boolean z) {
        return builder.setAllowGeneratedReplies(z);
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.Builder m5363b(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomBigContentView(remoteViews);
    }

    @DoNotInline
    /* renamed from: c */
    public static Notification.Builder m5364c(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomContentView(remoteViews);
    }

    @DoNotInline
    /* renamed from: d */
    public static Notification.Builder m5365d(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomHeadsUpContentView(remoteViews);
    }

    @DoNotInline
    /* renamed from: e */
    public static Notification.Builder m5366e(Notification.Builder builder, CharSequence[] charSequenceArr) {
        return builder.setRemoteInputHistory(charSequenceArr);
    }
}
