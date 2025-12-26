package android.support.v4.media.session;

import android.os.Bundle;

/* renamed from: android.support.v4.media.session.i */
/* loaded from: classes.dex */
public final class C0053i extends C0052h {
    @Override // android.support.v4.media.session.C0052h, android.support.v4.media.session.InterfaceC0050f
    public final Bundle getSessionInfo() {
        Bundle sessionInfo;
        if (this.f427e == null) {
            sessionInfo = this.f423a.getSessionInfo();
            this.f427e = sessionInfo;
            Bundle unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(sessionInfo);
            this.f427e = unparcelWithClassLoader;
            if (unparcelWithClassLoader == null) {
                return Bundle.EMPTY;
            }
            return new Bundle(this.f427e);
        }
        return new Bundle(this.f427e);
    }
}
