package p000;

import android.media.session.MediaSessionManager;
import androidx.media.MediaSessionManager;

/* loaded from: classes.dex */
public class dm1 extends cm1 {
    @Override // android.support.v4.media.session.C0060p, android.support.v4.media.session.InterfaceC0058n
    /* renamed from: d */
    public final MediaSessionManager.RemoteUserInfo mo133d() {
        MediaSessionManager.RemoteUserInfo currentControllerInfo;
        currentControllerInfo = this.f433a.getCurrentControllerInfo();
        return new MediaSessionManager.RemoteUserInfo(currentControllerInfo);
    }

    @Override // android.support.v4.media.session.C0060p, android.support.v4.media.session.InterfaceC0058n
    /* renamed from: c */
    public final void mo132c(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
    }
}
