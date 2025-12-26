package p000;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.upstream.C0733a;
import com.google.android.exoplayer2.util.Util;

/* renamed from: gd */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1228gd implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f17646a;

    /* renamed from: b */
    public final /* synthetic */ int f17647b;

    /* renamed from: c */
    public final /* synthetic */ long f17648c;

    /* renamed from: d */
    public final /* synthetic */ long f17649d;

    /* renamed from: e */
    public final /* synthetic */ Object f17650e;

    public /* synthetic */ RunnableC1228gd(Object obj, int i, long j, long j2, int i2) {
        this.f17646a = i2;
        this.f17650e = obj;
        this.f17647b = i;
        this.f17648c = j;
        this.f17649d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17646a) {
            case 0:
                ((AudioRendererEventListener) Util.castNonNull(((AudioRendererEventListener.EventDispatcher) this.f17650e).f9655b)).onAudioUnderrun(this.f17647b, this.f17648c, this.f17649d);
                return;
            default:
                ((C0733a) this.f17650e).f12567b.onBandwidthSample(this.f17647b, this.f17648c, this.f17649d);
                return;
        }
    }
}
