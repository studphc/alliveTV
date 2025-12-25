package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;

/* loaded from: classes.dex */
public final class y50 implements AudioRendererEventListener {
    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioCodecError(Exception exc) {
        AbstractC1191fd.m4794a(this, exc);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioDecoderInitialized(String str, long j, long j2) {
        AbstractC1191fd.m4795b(this, str, j, j2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioDecoderReleased(String str) {
        AbstractC1191fd.m4796c(this, str);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioDisabled(DecoderCounters decoderCounters) {
        AbstractC1191fd.m4797d(this, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioEnabled(DecoderCounters decoderCounters) {
        AbstractC1191fd.m4798e(this, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioInputFormatChanged(Format format) {
        AbstractC1191fd.m4799f(this, format);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioPositionAdvancing(long j) {
        AbstractC1191fd.m4801h(this, j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioSinkError(Exception exc) {
        AbstractC1191fd.m4802i(this, exc);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioUnderrun(int i, long j, long j2) {
        AbstractC1191fd.m4803j(this, i, j, j2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
        AbstractC1191fd.m4804k(this, z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final /* synthetic */ void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AbstractC1191fd.m4800g(this, format, decoderReuseEvaluation);
    }
}
