package p000;

import android.app.RemoteAction;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class ea2 {
    @DoNotInline
    /* renamed from: a */
    public static void m4683a(RemoteAction remoteAction, boolean z) {
        remoteAction.setShouldShowIcon(z);
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m4684b(RemoteAction remoteAction) {
        return remoteAction.shouldShowIcon();
    }
}
