package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.n */
/* loaded from: classes.dex */
public abstract class AbstractC0161n {
    @DoNotInline
    /* renamed from: a */
    public static RemoteViews m755a(Notification.Builder builder) {
        return builder.createHeadsUpContentView();
    }

    @DoNotInline
    /* renamed from: b */
    public static RemoteViews m756b(Notification.Builder builder) {
        return builder.createContentView();
    }

    @DoNotInline
    /* renamed from: c */
    public static RemoteViews m757c(Notification.Builder builder) {
        return builder.createHeadsUpContentView();
    }

    @DoNotInline
    /* renamed from: d */
    public static Notification.Builder m758d(Context context, Notification notification) {
        return Notification.Builder.recoverBuilder(context, notification);
    }
}
