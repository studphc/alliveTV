package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;

/* loaded from: classes.dex */
public final class x50 implements VideoRendererEventListener {
    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onDroppedFrames(int i, long j) {
        k23.m5484a(this, i, j);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onRenderedFirstFrame(Object obj, long j) {
        k23.m5485b(this, obj, j);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoCodecError(Exception exc) {
        k23.m5486c(this, exc);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoDecoderInitialized(String str, long j, long j2) {
        k23.m5487d(this, str, j, j2);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoDecoderReleased(String str) {
        k23.m5488e(this, str);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoDisabled(DecoderCounters decoderCounters) {
        k23.m5489f(this, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoEnabled(DecoderCounters decoderCounters) {
        k23.m5490g(this, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoFrameProcessingOffset(long j, int i) {
        k23.m5491h(this, j, i);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoInputFormatChanged(Format format) {
        k23.m5492i(this, format);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
        k23.m5494k(this, videoSize);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final /* synthetic */ void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        k23.m5493j(this, format, decoderReuseEvaluation);
    }
}
