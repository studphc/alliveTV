package p000;

import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.SntpClient;

/* loaded from: classes.dex */
public final class al2 implements Loader.Loadable {
    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() {
        synchronized (SntpClient.f12757a) {
            Object obj = SntpClient.f12758b;
            synchronized (obj) {
                if (SntpClient.f12759c) {
                    return;
                }
                long m3039a = SntpClient.m3039a();
                synchronized (obj) {
                    SntpClient.f12760d = m3039a;
                    SntpClient.f12759c = true;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
    }
}
