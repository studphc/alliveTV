package androidx.core.app;

import android.app.Notification;
import android.graphics.drawable.Icon;
import androidx.annotation.RequiresApi;

/* renamed from: androidx.core.app.i */
/* loaded from: classes.dex */
public abstract class AbstractC0154i {
    @RequiresApi(31)
    /* renamed from: a */
    public static void m737a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
        bigPictureStyle.bigPicture(icon);
    }

    @RequiresApi(31)
    /* renamed from: b */
    public static void m738b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
        bigPictureStyle.setContentDescription(charSequence);
    }

    @RequiresApi(31)
    /* renamed from: c */
    public static void m739c(Notification.BigPictureStyle bigPictureStyle, boolean z) {
        bigPictureStyle.showBigPictureWhenCollapsed(z);
    }
}
