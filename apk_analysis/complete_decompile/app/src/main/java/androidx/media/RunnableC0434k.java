package androidx.media;

import android.os.Bundle;
import androidx.media.MediaSessionManager;

/* renamed from: androidx.media.k */
/* loaded from: classes.dex */
public final class RunnableC0434k implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaSessionManager.RemoteUserInfo f6709a;

    /* renamed from: b */
    public final /* synthetic */ String f6710b;

    /* renamed from: c */
    public final /* synthetic */ Bundle f6711c;

    /* renamed from: d */
    public final /* synthetic */ C0438o f6712d;

    public RunnableC0434k(C0438o c0438o, MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
        this.f6712d = c0438o;
        this.f6709a = remoteUserInfo;
        this.f6710b = str;
        this.f6711c = bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int i = 0;
        while (true) {
            C0438o c0438o = this.f6712d;
            if (i < c0438o.f6717d.f6662d.getF1755c()) {
                C0431h c0431h = (C0431h) c0438o.f6717d.f6662d.valueAt(i);
                if (c0431h.f6702d.equals(this.f6709a)) {
                    c0438o.m1561c(c0431h, this.f6710b, this.f6711c);
                }
                i++;
            } else {
                return;
            }
        }
    }
}
