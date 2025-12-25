package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.decoder.SimpleDecoderOutputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import p000.qa2;
import p000.s60;

/* loaded from: classes.dex */
public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException>> extends BaseRenderer implements MediaClock {

    /* renamed from: A */
    public DrmSession f9661A;

    /* renamed from: B */
    public int f9662B;

    /* renamed from: C */
    public boolean f9663C;

    /* renamed from: D */
    public boolean f9664D;

    /* renamed from: E */
    public long f9665E;

    /* renamed from: F */
    public boolean f9666F;

    /* renamed from: G */
    public boolean f9667G;

    /* renamed from: H */
    public boolean f9668H;

    /* renamed from: I */
    public boolean f9669I;

    /* renamed from: n */
    public final AudioRendererEventListener.EventDispatcher f9670n;

    /* renamed from: o */
    public final AudioSink f9671o;

    /* renamed from: p */
    public final DecoderInputBuffer f9672p;

    /* renamed from: q */
    public DecoderCounters f9673q;

    /* renamed from: r */
    public Format f9674r;

    /* renamed from: s */
    public int f9675s;

    /* renamed from: t */
    public int f9676t;

    /* renamed from: u */
    public boolean f9677u;

    /* renamed from: v */
    public boolean f9678v;

    /* renamed from: w */
    public Decoder f9679w;

    /* renamed from: x */
    public DecoderInputBuffer f9680x;

    /* renamed from: y */
    public SimpleDecoderOutputBuffer f9681y;

    /* renamed from: z */
    public DrmSession f9682z;

    public DecoderAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final boolean m2447a() {
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.f9681y;
        AudioSink audioSink = this.f9671o;
        if (simpleDecoderOutputBuffer == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer2 = (SimpleDecoderOutputBuffer) this.f9679w.dequeueOutputBuffer();
            this.f9681y = simpleDecoderOutputBuffer2;
            if (simpleDecoderOutputBuffer2 == null) {
                return false;
            }
            int i = simpleDecoderOutputBuffer2.skippedOutputBufferCount;
            if (i > 0) {
                this.f9673q.skippedOutputBufferCount += i;
                audioSink.handleDiscontinuity();
            }
            if (this.f9681y.isFirstSample()) {
                audioSink.handleDiscontinuity();
            }
        }
        if (this.f9681y.isEndOfStream()) {
            if (this.f9662B == 2) {
                m2451e();
                m2449c();
                this.f9664D = true;
            } else {
                this.f9681y.release();
                this.f9681y = null;
                try {
                    this.f9669I = true;
                    audioSink.playToEndOfStream();
                } catch (AudioSink.WriteException e) {
                    throw createRendererException(e, e.format, e.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
                }
            }
            return false;
        }
        if (this.f9664D) {
            audioSink.configure(getOutputFormat(this.f9679w).buildUpon().setEncoderDelay(this.f9675s).setEncoderPadding(this.f9676t).build(), 0, null);
            this.f9664D = false;
        }
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer3 = this.f9681y;
        if (!audioSink.handleBuffer(simpleDecoderOutputBuffer3.data, simpleDecoderOutputBuffer3.timeUs, 1)) {
            return false;
        }
        this.f9673q.renderedOutputBufferCount++;
        this.f9681y.release();
        this.f9681y = null;
        return true;
    }

    /* renamed from: b */
    public final boolean m2448b() {
        Decoder decoder = this.f9679w;
        if (decoder == null || this.f9662B == 2 || this.f9668H) {
            return false;
        }
        if (this.f9680x == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) decoder.dequeueInputBuffer();
            this.f9680x = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.f9662B == 1) {
            this.f9680x.setFlags(4);
            this.f9679w.queueInputBuffer(this.f9680x);
            this.f9680x = null;
            this.f9662B = 2;
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        int readSource = readSource(formatHolder, this.f9680x, 0);
        if (readSource != -5) {
            if (readSource != -4) {
                if (readSource == -3) {
                    return false;
                }
                throw new IllegalStateException();
            }
            if (this.f9680x.isEndOfStream()) {
                this.f9668H = true;
                this.f9679w.queueInputBuffer(this.f9680x);
                this.f9680x = null;
                return false;
            }
            if (!this.f9678v) {
                this.f9678v = true;
                this.f9680x.addFlag(C0643C.BUFFER_FLAG_FIRST_SAMPLE);
            }
            this.f9680x.flip();
            DecoderInputBuffer decoderInputBuffer2 = this.f9680x;
            decoderInputBuffer2.format = this.f9674r;
            onQueueInputBuffer(decoderInputBuffer2);
            this.f9679w.queueInputBuffer(this.f9680x);
            this.f9663C = true;
            this.f9673q.queuedInputBufferCount++;
            this.f9680x = null;
            return true;
        }
        m2450d(formatHolder);
        return true;
    }

    /* renamed from: c */
    public final void m2449c() {
        CryptoConfig cryptoConfig;
        if (this.f9679w != null) {
            return;
        }
        DrmSession drmSession = this.f9661A;
        s60.m7333b(this.f9682z, drmSession);
        this.f9682z = drmSession;
        if (drmSession != null) {
            cryptoConfig = drmSession.getCryptoConfig();
            if (cryptoConfig == null && this.f9682z.getError() == null) {
                return;
            }
        } else {
            cryptoConfig = null;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            TraceUtil.beginSection("createAudioDecoder");
            this.f9679w = createDecoder(this.f9674r, cryptoConfig);
            TraceUtil.endSection();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f9670n.decoderInitialized(this.f9679w.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            this.f9673q.decoderInitCount++;
        } catch (DecoderException e) {
            Log.m3024e("DecoderAudioRenderer", "Audio codec error", e);
            this.f9670n.audioCodecError(e);
            throw createRendererException(e, this.f9674r, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
        } catch (OutOfMemoryError e2) {
            throw createRendererException(e2, this.f9674r, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
        }
    }

    public DecoderReuseEvaluation canReuseDecoder(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    public abstract T createDecoder(Format format, @Nullable CryptoConfig cryptoConfig);

    /* renamed from: d */
    public final void m2450d(FormatHolder formatHolder) {
        DecoderReuseEvaluation canReuseDecoder;
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        DrmSession drmSession = formatHolder.drmSession;
        s60.m7333b(this.f9661A, drmSession);
        this.f9661A = drmSession;
        Format format2 = this.f9674r;
        this.f9674r = format;
        this.f9675s = format.encoderDelay;
        this.f9676t = format.encoderPadding;
        Decoder decoder = this.f9679w;
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.f9670n;
        if (decoder == null) {
            m2449c();
            eventDispatcher.inputFormatChanged(this.f9674r, null);
            return;
        }
        if (drmSession != this.f9682z) {
            canReuseDecoder = new DecoderReuseEvaluation(decoder.getName(), format2, format, 0, 128);
        } else {
            canReuseDecoder = canReuseDecoder(decoder.getName(), format2, format);
        }
        if (canReuseDecoder.result == 0) {
            if (this.f9663C) {
                this.f9662B = 1;
            } else {
                m2451e();
                m2449c();
                this.f9664D = true;
            }
        }
        eventDispatcher.inputFormatChanged(this.f9674r, canReuseDecoder);
    }

    /* renamed from: e */
    public final void m2451e() {
        this.f9680x = null;
        this.f9681y = null;
        this.f9662B = 0;
        this.f9663C = false;
        Decoder decoder = this.f9679w;
        if (decoder != null) {
            this.f9673q.decoderReleaseCount++;
            decoder.release();
            this.f9670n.decoderReleased(this.f9679w.getName());
            this.f9679w = null;
        }
        s60.m7333b(this.f9682z, null);
        this.f9682z = null;
    }

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean z) {
        this.f9677u = z;
    }

    /* renamed from: f */
    public final void m2452f() {
        long currentPositionUs = this.f9671o.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.f9667G) {
                currentPositionUs = Math.max(this.f9665E, currentPositionUs);
            }
            this.f9665E = currentPositionUs;
            this.f9667G = false;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    @Nullable
    public MediaClock getMediaClock() {
        return this;
    }

    public abstract Format getOutputFormat(T t);

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.f9671o.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            m2452f();
        }
        return this.f9665E;
    }

    public final int getSinkFormatSupport(Format format) {
        return this.f9671o.getFormatSupport(format);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) {
        AudioSink audioSink = this.f9671o;
        if (i != 2) {
            if (i != 3) {
                if (i != 6) {
                    if (i != 9) {
                        if (i != 10) {
                            super.handleMessage(i, obj);
                            return;
                        } else {
                            audioSink.setAudioSessionId(((Integer) obj).intValue());
                            return;
                        }
                    }
                    audioSink.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
                    return;
                }
                audioSink.setAuxEffectInfo((AuxEffectInfo) obj);
                return;
            }
            audioSink.setAudioAttributes((AudioAttributes) obj);
            return;
        }
        audioSink.setVolume(((Float) obj).floatValue());
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        if (this.f9669I && this.f9671o.isEnded()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (!this.f9671o.hasPendingData() && (this.f9674r == null || (!isSourceReady() && this.f9681y == null))) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.f9670n;
        this.f9674r = null;
        this.f9664D = true;
        try {
            s60.m7333b(this.f9661A, null);
            this.f9661A = null;
            m2451e();
            this.f9671o.reset();
        } finally {
            eventDispatcher.disabled(this.f9673q);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.f9673q = decoderCounters;
        this.f9670n.enabled(decoderCounters);
        boolean z3 = getConfiguration().tunneling;
        AudioSink audioSink = this.f9671o;
        if (z3) {
            audioSink.enableTunnelingV21();
        } else {
            audioSink.disableTunneling();
        }
        audioSink.setPlayerId(getPlayerId());
    }

    @CallSuper
    public void onPositionDiscontinuity() {
        this.f9667G = true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        boolean z2 = this.f9677u;
        AudioSink audioSink = this.f9671o;
        if (z2) {
            audioSink.experimentalFlushWithoutAudioTrackRelease();
        } else {
            audioSink.flush();
        }
        this.f9665E = j;
        this.f9666F = true;
        this.f9667G = true;
        this.f9668H = false;
        this.f9669I = false;
        if (this.f9679w != null) {
            if (this.f9662B != 0) {
                m2451e();
                m2449c();
                return;
            }
            this.f9680x = null;
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.f9681y;
            if (simpleDecoderOutputBuffer != null) {
                simpleDecoderOutputBuffer.release();
                this.f9681y = null;
            }
            this.f9679w.flush();
            this.f9663C = false;
        }
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.f9666F && !decoderInputBuffer.isDecodeOnly()) {
            if (Math.abs(decoderInputBuffer.timeUs - this.f9665E) > 500000) {
                this.f9665E = decoderInputBuffer.timeUs;
            }
            this.f9666F = false;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        this.f9671o.play();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        m2452f();
        this.f9671o.pause();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        super.onStreamChanged(formatArr, j, j2);
        this.f9678v = false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        boolean z = this.f9669I;
        AudioSink audioSink = this.f9671o;
        if (z) {
            try {
                audioSink.playToEndOfStream();
                return;
            } catch (AudioSink.WriteException e) {
                throw createRendererException(e, e.format, e.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
            }
        }
        if (this.f9674r == null) {
            FormatHolder formatHolder = getFormatHolder();
            DecoderInputBuffer decoderInputBuffer = this.f9672p;
            decoderInputBuffer.clear();
            int readSource = readSource(formatHolder, decoderInputBuffer, 2);
            if (readSource == -5) {
                m2450d(formatHolder);
            } else {
                if (readSource == -4) {
                    Assertions.checkState(decoderInputBuffer.isEndOfStream());
                    this.f9668H = true;
                    try {
                        this.f9669I = true;
                        audioSink.playToEndOfStream();
                        return;
                    } catch (AudioSink.WriteException e2) {
                        throw createRendererException(e2, null, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
                    }
                }
                return;
            }
        }
        m2449c();
        if (this.f9679w != null) {
            try {
                TraceUtil.beginSection("drainAndFeed");
                do {
                } while (m2447a());
                do {
                } while (m2448b());
                TraceUtil.endSection();
                this.f9673q.ensureUpdated();
            } catch (AudioSink.ConfigurationException e3) {
                throw createRendererException(e3, e3.format, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
            } catch (AudioSink.InitializationException e4) {
                throw createRendererException(e4, e4.format, e4.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
            } catch (AudioSink.WriteException e5) {
                throw createRendererException(e5, e5.format, e5.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
            } catch (DecoderException e6) {
                Log.m3024e("DecoderAudioRenderer", "Audio codec error", e6);
                this.f9670n.audioCodecError(e6);
                throw createRendererException(e6, this.f9674r, PlaybackException.ERROR_CODE_DECODING_FAILED);
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.f9671o.setPlaybackParameters(playbackParameters);
    }

    public final boolean sinkSupportsFormat(Format format) {
        return this.f9671o.supportsFormat(format);
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) {
        int i = 0;
        if (!MimeTypes.isAudio(format.sampleMimeType)) {
            return qa2.m7011a(0);
        }
        int supportsFormatInternal = supportsFormatInternal(format);
        if (supportsFormatInternal <= 2) {
            return qa2.m7011a(supportsFormatInternal);
        }
        if (Util.SDK_INT >= 21) {
            i = 32;
        }
        return qa2.m7012b(supportsFormatInternal, 8, i);
    }

    public abstract int supportsFormatInternal(Format format);

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, null, audioProcessorArr);
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, new DefaultAudioSink.Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessors(audioProcessorArr).build());
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1);
        this.f9670n = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.f9671o = audioSink;
        audioSink.setListener(new C0648b(this));
        this.f9672p = DecoderInputBuffer.newNoDataInstance();
        this.f9662B = 0;
        this.f9664D = true;
    }
}
