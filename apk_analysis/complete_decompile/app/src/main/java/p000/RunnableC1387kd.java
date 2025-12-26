package p000;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Util;

/* renamed from: kd */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1387kd implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f20820a;

    /* renamed from: b */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f20821b;

    /* renamed from: c */
    public final /* synthetic */ DecoderCounters f20822c;

    public /* synthetic */ RunnableC1387kd(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters, int i) {
        this.f20820a = i;
        this.f20821b = eventDispatcher;
        this.f20822c = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f20820a) {
            case 0:
                ((AudioRendererEventListener) Util.castNonNull(this.f20821b.f9655b)).onAudioEnabled(this.f20822c);
                return;
            default:
                AudioRendererEventListener.EventDispatcher eventDispatcher = this.f20821b;
                eventDispatcher.getClass();
                DecoderCounters decoderCounters = this.f20822c;
                decoderCounters.ensureUpdated();
                ((AudioRendererEventListener) Util.castNonNull(eventDispatcher.f9655b)).onAudioDisabled(decoderCounters);
                return;
        }
    }
}
