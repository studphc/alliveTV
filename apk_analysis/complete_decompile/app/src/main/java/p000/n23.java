package p000;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* loaded from: classes.dex */
public final /* synthetic */ class n23 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f23207a;

    /* renamed from: b */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f23208b;

    /* renamed from: c */
    public final /* synthetic */ DecoderCounters f23209c;

    public /* synthetic */ n23(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters, int i) {
        this.f23207a = i;
        this.f23208b = eventDispatcher;
        this.f23209c = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f23207a) {
            case 0:
                VideoRendererEventListener.EventDispatcher eventDispatcher = this.f23208b;
                eventDispatcher.getClass();
                DecoderCounters decoderCounters = this.f23209c;
                decoderCounters.ensureUpdated();
                ((VideoRendererEventListener) Util.castNonNull(eventDispatcher.f12890b)).onVideoDisabled(decoderCounters);
                return;
            default:
                ((VideoRendererEventListener) Util.castNonNull(this.f23208b.f12890b)).onVideoEnabled(this.f23209c);
                return;
        }
    }
}
