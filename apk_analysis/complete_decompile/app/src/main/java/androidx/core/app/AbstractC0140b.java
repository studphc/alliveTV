package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.app.b */
/* loaded from: classes.dex */
public abstract class AbstractC0140b {
    @DoNotInline
    /* renamed from: a */
    public static Bundle m715a(Notification.Action action) {
        return action.getExtras();
    }

    @DoNotInline
    /* renamed from: b */
    public static android.app.RemoteInput[] m716b(Notification.Action action) {
        return action.getRemoteInputs();
    }
}
