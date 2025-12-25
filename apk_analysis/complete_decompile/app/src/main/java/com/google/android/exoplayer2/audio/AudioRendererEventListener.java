package com.google.android.exoplayer2.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import p000.RunnableC0547b7;
import p000.RunnableC0583c7;
import p000.RunnableC1228gd;
import p000.RunnableC1265hd;
import p000.RunnableC1302id;
import p000.RunnableC1387kd;
import p000.ge0;

/* loaded from: classes.dex */
public interface AudioRendererEventListener {

    /* loaded from: classes.dex */
    public static final class EventDispatcher {

        /* renamed from: a */
        public final Handler f9654a;

        /* renamed from: b */
        public final AudioRendererEventListener f9655b;

        public EventDispatcher(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
            Handler handler2;
            if (audioRendererEventListener != null) {
                handler2 = (Handler) Assertions.checkNotNull(handler);
            } else {
                handler2 = null;
            }
            this.f9654a = handler2;
            this.f9655b = audioRendererEventListener;
        }

        public void audioCodecError(Exception exc) {
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new RunnableC1302id(this, exc, 0));
            }
        }

        public void audioSinkError(Exception exc) {
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new RunnableC1302id(this, exc, 1));
            }
        }

        public void decoderInitialized(String str, long j, long j2) {
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new RunnableC1265hd(this, str, j, j2, 0));
            }
        }

        public void decoderReleased(String str) {
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new RunnableC0583c7(4, this, str));
            }
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new RunnableC1387kd(this, decoderCounters, 1));
            }
        }

        public void enabled(DecoderCounters decoderCounters) {
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new RunnableC1387kd(this, decoderCounters, 0));
            }
        }

        public void inputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new RunnableC0547b7(this, format, decoderReuseEvaluation, 1));
            }
        }

        public void positionAdvancing(final long j) {
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: jd
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.castNonNull(AudioRendererEventListener.EventDispatcher.this.f9655b)).onAudioPositionAdvancing(j);
                    }
                });
            }
        }

        public void skipSilenceEnabledChanged(boolean z) {
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new ge0(this, 2, z));
            }
        }

        public void underrun(int i, long j, long j2) {
            Handler handler = this.f9654a;
            if (handler != null) {
                handler.post(new RunnableC1228gd(this, i, j, j2, 0));
            }
        }
    }

    void onAudioCodecError(Exception exc);

    void onAudioDecoderInitialized(String str, long j, long j2);

    void onAudioDecoderReleased(String str);

    void onAudioDisabled(DecoderCounters decoderCounters);

    void onAudioEnabled(DecoderCounters decoderCounters);

    @Deprecated
    void onAudioInputFormatChanged(Format format);

    void onAudioInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void onAudioPositionAdvancing(long j);

    void onAudioSinkError(Exception exc);

    void onAudioUnderrun(int i, long j, long j2);

    void onSkipSilenceEnabledChanged(boolean z);
}
