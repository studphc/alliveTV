package p000;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* renamed from: hd */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1265hd implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f18022a;

    /* renamed from: b */
    public final /* synthetic */ String f18023b;

    /* renamed from: c */
    public final /* synthetic */ long f18024c;

    /* renamed from: d */
    public final /* synthetic */ long f18025d;

    /* renamed from: e */
    public final /* synthetic */ Object f18026e;

    public /* synthetic */ RunnableC1265hd(Object obj, String str, long j, long j2, int i) {
        this.f18022a = i;
        this.f18026e = obj;
        this.f18023b = str;
        this.f18024c = j;
        this.f18025d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18022a) {
            case 0:
                ((AudioRendererEventListener) Util.castNonNull(((AudioRendererEventListener.EventDispatcher) this.f18026e).f9655b)).onAudioDecoderInitialized(this.f18023b, this.f18024c, this.f18025d);
                return;
            default:
                ((VideoRendererEventListener) Util.castNonNull(((VideoRendererEventListener.EventDispatcher) this.f18026e).f12890b)).onVideoDecoderInitialized(this.f18023b, this.f18024c, this.f18025d);
                return;
        }
    }
}
