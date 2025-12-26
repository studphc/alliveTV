package p000;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes.dex */
public final /* synthetic */ class l23 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f22308a = 0;

    /* renamed from: b */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f22309b;

    /* renamed from: c */
    public final /* synthetic */ long f22310c;

    /* renamed from: d */
    public final /* synthetic */ int f22311d;

    public /* synthetic */ l23(VideoRendererEventListener.EventDispatcher eventDispatcher, int i, long j) {
        this.f22309b = eventDispatcher;
        this.f22311d = i;
        this.f22310c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f22308a) {
            case 0:
                ((VideoRendererEventListener) Util.castNonNull(this.f22309b.f12890b)).onDroppedFrames(this.f22311d, this.f22310c);
                return;
            default:
                ((VideoRendererEventListener) Util.castNonNull(this.f22309b.f12890b)).onVideoFrameProcessingOffset(this.f22310c, this.f22311d);
                return;
        }
    }

    public /* synthetic */ l23(VideoRendererEventListener.EventDispatcher eventDispatcher, long j, int i) {
        this.f22309b = eventDispatcher;
        this.f22310c = j;
        this.f22311d = i;
    }
}
