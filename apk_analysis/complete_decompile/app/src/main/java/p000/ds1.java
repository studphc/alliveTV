package p000;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.LocusId;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ds1 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m4608a(Notification notification) {
        return notification.getAllowSystemGeneratedContextualActions();
    }

    @DoNotInline
    /* renamed from: b */
    public static Notification.BubbleMetadata m4609b(Notification notification) {
        return notification.getBubbleMetadata();
    }

    @DoNotInline
    /* renamed from: c */
    public static int m4610c(RemoteInput remoteInput) {
        return remoteInput.getEditChoicesBeforeSending();
    }

    @DoNotInline
    /* renamed from: d */
    public static LocusId m4611d(Notification notification) {
        return notification.getLocusId();
    }

    @DoNotInline
    /* renamed from: e */
    public static boolean m4612e(Notification.Action action) {
        return action.isContextual();
    }
}
