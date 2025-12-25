package androidx.core.app;

import android.app.Notification;
import android.graphics.drawable.Icon;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.m */
/* loaded from: classes.dex */
public abstract class AbstractC0160m {
    @DoNotInline
    /* renamed from: a */
    public static Icon m753a(Notification notification) {
        return notification.getLargeIcon();
    }

    @DoNotInline
    /* renamed from: b */
    public static Icon m754b(Notification notification) {
        return notification.getSmallIcon();
    }
}
