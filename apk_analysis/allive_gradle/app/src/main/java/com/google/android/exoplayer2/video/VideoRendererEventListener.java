package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import p000.RunnableC0547b7;
import p000.RunnableC1265hd;
import p000.l23;
import p000.n23;
import p000.wg2;

/* loaded from: classes.dex */
public interface VideoRendererEventListener {

    /* loaded from: classes.dex */
    public static final class EventDispatcher {

        /* renamed from: a */
        public final Handler f12889a;

        /* renamed from: b */
        public final VideoRendererEventListener f12890b;

        public EventDispatcher(@Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener) {
            Handler handler2;
            if (videoRendererEventListener != null) {
                handler2 = (Handler) Assertions.checkNotNull(handler);
            } else {
                handler2 = null;
            }
            this.f12889a = handler2;
            this.f12890b = videoRendererEventListener;
        }

        public void decoderInitialized(String str, long j, long j2) {
            Handler handler = this.f12889a;
            if (handler != null) {
                handler.post(new RunnableC1265hd(this, str, j, j2, 1));
            }
        }

        public void decoderReleased(String str) {
            Handler handler = this.f12889a;
            if (handler != null) {
                handler.post(new wg2(4, this, str));
            }
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler = this.f12889a;
            if (handler != null) {
                handler.post(new n23(this, decoderCounters, 0));
            }
        }

        public void droppedFrames(int i, long j) {
            Handler handler = this.f12889a;
            if (handler != null) {
                handler.post(new l23(this, i, j));
            }
        }

        public void enabled(DecoderCounters decoderCounters) {
            Handler handler = this.f12889a;
            if (handler != null) {
                handler.post(new n23(this, decoderCounters, 1));
            }
        }

        public void inputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f12889a;
            if (handler != null) {
                handler.post(new RunnableC0547b7(this, format, decoderReuseEvaluation, 12));
            }
        }

        public void renderedFirstFrame(final Object obj) {
            Handler handler = this.f12889a;
            if (handler != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                handler.post(new Runnable() { // from class: m23
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.castNonNull(VideoRendererEventListener.EventDispatcher.this.f12890b)).onRenderedFirstFrame(obj, elapsedRealtime);
                    }
                });
            }
        }

        public void reportVideoFrameProcessingOffset(long j, int i) {
            Handler handler = this.f12889a;
            if (handler != null) {
                handler.post(new l23(this, j, i));
            }
        }

        public void videoCodecError(Exception exc) {
            Handler handler = this.f12889a;
            if (handler != null) {
                handler.post(new wg2(5, this, exc));
            }
        }

        public void videoSizeChanged(VideoSize videoSize) {
            Handler handler = this.f12889a;
            if (handler != null) {
                handler.post(new wg2(3, this, videoSize));
            }
        }
    }

    void onDroppedFrames(int i, long j);

    void onRenderedFirstFrame(Object obj, long j);

    void onVideoCodecError(Exception exc);

    void onVideoDecoderInitialized(String str, long j, long j2);

    void onVideoDecoderReleased(String str);

    void onVideoDisabled(DecoderCounters decoderCounters);

    void onVideoEnabled(DecoderCounters decoderCounters);

    void onVideoFrameProcessingOffset(long j, int i);

    @Deprecated
    void onVideoInputFormatChanged(Format format);

    void onVideoInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void onVideoSizeChanged(VideoSize videoSize);
}
