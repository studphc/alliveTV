package p000;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Bundle;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class wr1 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m8072a(RemoteInput remoteInput) {
        return remoteInput.getAllowFreeFormInput();
    }

    @DoNotInline
    /* renamed from: b */
    public static CharSequence[] m8073b(RemoteInput remoteInput) {
        return remoteInput.getChoices();
    }

    @DoNotInline
    /* renamed from: c */
    public static Bundle m8074c(Notification.Action action) {
        return action.getExtras();
    }

    @DoNotInline
    /* renamed from: d */
    public static Bundle m8075d(RemoteInput remoteInput) {
        return remoteInput.getExtras();
    }

    @DoNotInline
    /* renamed from: e */
    public static String m8076e(Notification notification) {
        return notification.getGroup();
    }

    @DoNotInline
    /* renamed from: f */
    public static CharSequence m8077f(RemoteInput remoteInput) {
        return remoteInput.getLabel();
    }

    @DoNotInline
    /* renamed from: g */
    public static RemoteInput[] m8078g(Notification.Action action) {
        return action.getRemoteInputs();
    }

    @DoNotInline
    /* renamed from: h */
    public static String m8079h(RemoteInput remoteInput) {
        return remoteInput.getResultKey();
    }

    @DoNotInline
    /* renamed from: i */
    public static String m8080i(Notification notification) {
        return notification.getSortKey();
    }
}
