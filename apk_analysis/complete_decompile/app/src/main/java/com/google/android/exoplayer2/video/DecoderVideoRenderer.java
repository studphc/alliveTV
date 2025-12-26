package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import p000.s60;

/* loaded from: classes.dex */
public abstract class DecoderVideoRenderer extends BaseRenderer {

    /* renamed from: A */
    public VideoDecoderOutputBufferRenderer f12794A;

    /* renamed from: B */
    public VideoFrameMetadataListener f12795B;

    /* renamed from: C */
    public DrmSession f12796C;

    /* renamed from: D */
    public DrmSession f12797D;

    /* renamed from: E */
    public int f12798E;

    /* renamed from: F */
    public boolean f12799F;

    /* renamed from: G */
    public boolean f12800G;

    /* renamed from: H */
    public boolean f12801H;

    /* renamed from: I */
    public boolean f12802I;

    /* renamed from: J */
    public long f12803J;

    /* renamed from: K */
    public long f12804K;

    /* renamed from: L */
    public boolean f12805L;

    /* renamed from: M */
    public boolean f12806M;

    /* renamed from: N */
    public boolean f12807N;

    /* renamed from: O */
    public VideoSize f12808O;

    /* renamed from: P */
    public long f12809P;

    /* renamed from: Q */
    public int f12810Q;

    /* renamed from: R */
    public int f12811R;

    /* renamed from: S */
    public int f12812S;

    /* renamed from: T */
    public long f12813T;

    /* renamed from: U */
    public long f12814U;
    protected DecoderCounters decoderCounters;

    /* renamed from: n */
    public final long f12815n;

    /* renamed from: o */
    public final int f12816o;

    /* renamed from: p */
    public final VideoRendererEventListener.EventDispatcher f12817p;

    /* renamed from: q */
    public final TimedValueQueue f12818q;

    /* renamed from: r */
    public final DecoderInputBuffer f12819r;

    /* renamed from: s */
    public Format f12820s;

    /* renamed from: t */
    public Format f12821t;

    /* renamed from: u */
    public Decoder f12822u;

    /* renamed from: v */
    public DecoderInputBuffer f12823v;

    /* renamed from: w */
    public VideoDecoderOutputBuffer f12824w;

    /* renamed from: x */
    public int f12825x;

    /* renamed from: y */
    public Object f12826y;

    /* renamed from: z */
    public Surface f12827z;

    public DecoderVideoRenderer(long j, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i) {
        super(2);
        this.f12815n = j;
        this.f12816o = i;
        this.f12804K = C0643C.TIME_UNSET;
        this.f12808O = null;
        this.f12818q = new TimedValueQueue();
        this.f12819r = DecoderInputBuffer.newNoDataInstance();
        this.f12817p = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.f12798E = 0;
        this.f12825x = -1;
    }

    /* renamed from: a */
    public final boolean m3054a(long j, long j2) {
        boolean z;
        boolean z2;
        if (this.f12824w == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.f12822u.dequeueOutputBuffer();
            this.f12824w = videoDecoderOutputBuffer;
            if (videoDecoderOutputBuffer == null) {
                return false;
            }
            DecoderCounters decoderCounters = this.decoderCounters;
            int i = decoderCounters.skippedOutputBufferCount;
            int i2 = videoDecoderOutputBuffer.skippedOutputBufferCount;
            decoderCounters.skippedOutputBufferCount = i + i2;
            this.f12812S -= i2;
        }
        if (this.f12824w.isEndOfStream()) {
            if (this.f12798E == 2) {
                releaseDecoder();
                m3056c();
            } else {
                this.f12824w.release();
                this.f12824w = null;
                this.f12807N = true;
            }
            return false;
        }
        if (this.f12803J == C0643C.TIME_UNSET) {
            this.f12803J = j;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.f12824w;
        long j3 = videoDecoderOutputBuffer2.timeUs;
        long j4 = j3 - j;
        if (this.f12825x != -1) {
            long j5 = j3 - this.f12814U;
            Format format = (Format) this.f12818q.pollFloor(j5);
            if (format != null) {
                this.f12821t = format;
            }
            long elapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.f12813T;
            if (getState() == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f12802I ? this.f12800G : !z2 && !this.f12801H) {
                if (!z2 || !shouldForceRenderOutputBuffer(j4, elapsedRealtime)) {
                    if (z2 && j != this.f12803J && (!shouldDropBuffersToKeyframe(j4, j2) || !maybeDropBuffersToKeyframe(j))) {
                        if (shouldDropOutputBuffer(j4, j2)) {
                            dropOutputBuffer(this.f12824w);
                        } else if (j4 < 30000) {
                            renderOutputBuffer(this.f12824w, j5, this.f12821t);
                        }
                        z = true;
                    }
                    z = false;
                }
            }
            renderOutputBuffer(this.f12824w, j5, this.f12821t);
            z = true;
        } else {
            if (j4 < -30000) {
                skipOutputBuffer(videoDecoderOutputBuffer2);
                z = true;
            }
            z = false;
        }
        if (z) {
            onProcessedOutputBuffer(this.f12824w.timeUs);
            this.f12824w = null;
        }
        return z;
    }

    /* renamed from: b */
    public final boolean m3055b() {
        Decoder decoder = this.f12822u;
        if (decoder == null || this.f12798E == 2 || this.f12806M) {
            return false;
        }
        if (this.f12823v == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) decoder.dequeueInputBuffer();
            this.f12823v = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.f12798E == 1) {
            this.f12823v.setFlags(4);
            this.f12822u.queueInputBuffer(this.f12823v);
            this.f12823v = null;
            this.f12798E = 2;
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        int readSource = readSource(formatHolder, this.f12823v, 0);
        if (readSource != -5) {
            if (readSource != -4) {
                if (readSource == -3) {
                    return false;
                }
                throw new IllegalStateException();
            }
            if (this.f12823v.isEndOfStream()) {
                this.f12806M = true;
                this.f12822u.queueInputBuffer(this.f12823v);
                this.f12823v = null;
                return false;
            }
            if (this.f12805L) {
                this.f12818q.add(this.f12823v.timeUs, this.f12820s);
                this.f12805L = false;
            }
            this.f12823v.flip();
            DecoderInputBuffer decoderInputBuffer2 = this.f12823v;
            decoderInputBuffer2.format = this.f12820s;
            onQueueInputBuffer(decoderInputBuffer2);
            this.f12822u.queueInputBuffer(this.f12823v);
            this.f12812S++;
            this.f12799F = true;
            this.decoderCounters.queuedInputBufferCount++;
            this.f12823v = null;
            return true;
        }
        onInputFormatChanged(formatHolder);
        return true;
    }

    /* renamed from: c */
    public final void m3056c() {
        CryptoConfig cryptoConfig;
        if (this.f12822u != null) {
            return;
        }
        DrmSession drmSession = this.f12797D;
        s60.m7333b(this.f12796C, drmSession);
        this.f12796C = drmSession;
        if (drmSession != null) {
            cryptoConfig = drmSession.getCryptoConfig();
            if (cryptoConfig == null && this.f12796C.getError() == null) {
                return;
            }
        } else {
            cryptoConfig = null;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f12822u = createDecoder(this.f12820s, cryptoConfig);
            setDecoderOutputMode(this.f12825x);
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f12817p.decoderInitialized(this.f12822u.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (DecoderException e) {
            Log.m3024e("DecoderVideoRenderer", "Video codec error", e);
            this.f12817p.videoCodecError(e);
            throw createRendererException(e, this.f12820s, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
        } catch (OutOfMemoryError e2) {
            throw createRendererException(e2, this.f12820s, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
        }
    }

    public DecoderReuseEvaluation canReuseDecoder(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    public abstract Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> createDecoder(Format format, @Nullable CryptoConfig cryptoConfig);

    public void dropOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        updateDroppedBufferCounters(0, 1);
        videoDecoderOutputBuffer.release();
    }

    @CallSuper
    public void flushDecoder() {
        this.f12812S = 0;
        if (this.f12798E != 0) {
            releaseDecoder();
            m3056c();
            return;
        }
        this.f12823v = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.f12824w;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.f12824w = null;
        }
        this.f12822u.flush();
        this.f12799F = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) {
        if (i == 1) {
            setOutput(obj);
        } else if (i == 7) {
            this.f12795B = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.f12807N;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.f12820s != null && ((isSourceReady() || this.f12824w != null) && (this.f12800G || this.f12825x == -1))) {
            this.f12804K = C0643C.TIME_UNSET;
            return true;
        }
        if (this.f12804K == C0643C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f12804K) {
            return true;
        }
        this.f12804K = C0643C.TIME_UNSET;
        return false;
    }

    public boolean maybeDropBuffersToKeyframe(long j) {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(skipSource, this.f12812S);
        flushDecoder();
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.f12817p;
        this.f12820s = null;
        this.f12808O = null;
        this.f12800G = false;
        try {
            s60.m7333b(this.f12797D, null);
            this.f12797D = null;
            releaseDecoder();
        } finally {
            eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.decoderCounters = decoderCounters;
        this.f12817p.enabled(decoderCounters);
        this.f12801H = z2;
        this.f12802I = false;
    }

    @CallSuper
    public void onInputFormatChanged(FormatHolder formatHolder) {
        DecoderReuseEvaluation canReuseDecoder;
        this.f12805L = true;
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        DrmSession drmSession = formatHolder.drmSession;
        s60.m7333b(this.f12797D, drmSession);
        this.f12797D = drmSession;
        Format format2 = this.f12820s;
        this.f12820s = format;
        Decoder decoder = this.f12822u;
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.f12817p;
        if (decoder == null) {
            m3056c();
            eventDispatcher.inputFormatChanged(this.f12820s, null);
            return;
        }
        if (drmSession != this.f12796C) {
            canReuseDecoder = new DecoderReuseEvaluation(decoder.getName(), format2, format, 0, 128);
        } else {
            canReuseDecoder = canReuseDecoder(decoder.getName(), format2, format);
        }
        if (canReuseDecoder.result == 0) {
            if (this.f12799F) {
                this.f12798E = 1;
            } else {
                releaseDecoder();
                m3056c();
            }
        }
        eventDispatcher.inputFormatChanged(this.f12820s, canReuseDecoder);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.f12806M = false;
        this.f12807N = false;
        this.f12800G = false;
        long j2 = C0643C.TIME_UNSET;
        this.f12803J = C0643C.TIME_UNSET;
        this.f12811R = 0;
        if (this.f12822u != null) {
            flushDecoder();
        }
        if (z) {
            long j3 = this.f12815n;
            if (j3 > 0) {
                j2 = SystemClock.elapsedRealtime() + j3;
            }
            this.f12804K = j2;
        } else {
            this.f12804K = C0643C.TIME_UNSET;
        }
        this.f12818q.clear();
    }

    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        this.f12812S--;
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        this.f12810Q = 0;
        this.f12809P = SystemClock.elapsedRealtime();
        this.f12813T = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.f12804K = C0643C.TIME_UNSET;
        if (this.f12810Q > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f12817p.droppedFrames(this.f12810Q, elapsedRealtime - this.f12809P);
            this.f12810Q = 0;
            this.f12809P = elapsedRealtime;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.f12814U = j2;
        super.onStreamChanged(formatArr, j, j2);
    }

    @CallSuper
    public void releaseDecoder() {
        this.f12823v = null;
        this.f12824w = null;
        this.f12798E = 0;
        this.f12799F = false;
        this.f12812S = 0;
        Decoder decoder = this.f12822u;
        if (decoder != null) {
            this.decoderCounters.decoderReleaseCount++;
            decoder.release();
            this.f12817p.decoderReleased(this.f12822u.getName());
            this.f12822u = null;
        }
        s60.m7333b(this.f12796C, null);
        this.f12796C = null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        if (this.f12807N) {
            return;
        }
        if (this.f12820s == null) {
            FormatHolder formatHolder = getFormatHolder();
            DecoderInputBuffer decoderInputBuffer = this.f12819r;
            decoderInputBuffer.clear();
            int readSource = readSource(formatHolder, decoderInputBuffer, 2);
            if (readSource == -5) {
                onInputFormatChanged(formatHolder);
            } else {
                if (readSource == -4) {
                    Assertions.checkState(decoderInputBuffer.isEndOfStream());
                    this.f12806M = true;
                    this.f12807N = true;
                    return;
                }
                return;
            }
        }
        m3056c();
        if (this.f12822u != null) {
            try {
                TraceUtil.beginSection("drainAndFeed");
                do {
                } while (m3054a(j, j2));
                do {
                } while (m3055b());
                TraceUtil.endSection();
                this.decoderCounters.ensureUpdated();
            } catch (DecoderException e) {
                Log.m3024e("DecoderVideoRenderer", "Video codec error", e);
                this.f12817p.videoCodecError(e);
                throw createRendererException(e, this.f12820s, PlaybackException.ERROR_CODE_DECODING_FAILED);
            }
        }
    }

    public void renderOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j, Format format) {
        boolean z;
        boolean z2;
        VideoFrameMetadataListener videoFrameMetadataListener = this.f12795B;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, System.nanoTime(), format, null);
        }
        this.f12813T = Util.msToUs(SystemClock.elapsedRealtime() * 1000);
        int i = videoDecoderOutputBuffer.mode;
        if (i == 1 && this.f12827z != null) {
            z = true;
        } else {
            z = false;
        }
        if (i == 0 && this.f12794A != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && !z) {
            dropOutputBuffer(videoDecoderOutputBuffer);
            return;
        }
        int i2 = videoDecoderOutputBuffer.width;
        int i3 = videoDecoderOutputBuffer.height;
        VideoSize videoSize = this.f12808O;
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.f12817p;
        if (videoSize == null || videoSize.width != i2 || videoSize.height != i3) {
            VideoSize videoSize2 = new VideoSize(i2, i3);
            this.f12808O = videoSize2;
            eventDispatcher.videoSizeChanged(videoSize2);
        }
        if (z2) {
            this.f12794A.setOutputBuffer(videoDecoderOutputBuffer);
        } else {
            renderOutputBufferToSurface(videoDecoderOutputBuffer, this.f12827z);
        }
        this.f12811R = 0;
        this.decoderCounters.renderedOutputBufferCount++;
        this.f12802I = true;
        if (!this.f12800G) {
            this.f12800G = true;
            eventDispatcher.renderedFirstFrame(this.f12826y);
        }
    }

    public abstract void renderOutputBufferToSurface(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface);

    public abstract void setDecoderOutputMode(int i);

    public final void setOutput(@Nullable Object obj) {
        long j;
        if (obj instanceof Surface) {
            this.f12827z = (Surface) obj;
            this.f12794A = null;
            this.f12825x = 1;
        } else if (obj instanceof VideoDecoderOutputBufferRenderer) {
            this.f12827z = null;
            this.f12794A = (VideoDecoderOutputBufferRenderer) obj;
            this.f12825x = 0;
        } else {
            this.f12827z = null;
            this.f12794A = null;
            this.f12825x = -1;
            obj = null;
        }
        Object obj2 = this.f12826y;
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.f12817p;
        if (obj2 != obj) {
            this.f12826y = obj;
            if (obj != null) {
                if (this.f12822u != null) {
                    setDecoderOutputMode(this.f12825x);
                }
                VideoSize videoSize = this.f12808O;
                if (videoSize != null) {
                    eventDispatcher.videoSizeChanged(videoSize);
                }
                this.f12800G = false;
                if (getState() == 2) {
                    long j2 = this.f12815n;
                    if (j2 > 0) {
                        j = SystemClock.elapsedRealtime() + j2;
                    } else {
                        j = C0643C.TIME_UNSET;
                    }
                    this.f12804K = j;
                    return;
                }
                return;
            }
            this.f12808O = null;
            this.f12800G = false;
            return;
        }
        if (obj != null) {
            VideoSize videoSize2 = this.f12808O;
            if (videoSize2 != null) {
                eventDispatcher.videoSizeChanged(videoSize2);
            }
            if (this.f12800G) {
                eventDispatcher.renderedFirstFrame(this.f12826y);
            }
        }
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2) {
        return j < -500000;
    }

    public boolean shouldDropOutputBuffer(long j, long j2) {
        return j < -30000;
    }

    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return j < -30000 && j2 > 100000;
    }

    public void skipOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        videoDecoderOutputBuffer.release();
    }

    public void updateDroppedBufferCounters(int i, int i2) {
        int i3;
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedInputBufferCount += i;
        int i4 = i + i2;
        decoderCounters.droppedBufferCount += i4;
        this.f12810Q += i4;
        int i5 = this.f12811R + i4;
        this.f12811R = i5;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i5, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i6 = this.f12816o;
        if (i6 > 0 && (i3 = this.f12810Q) >= i6 && i3 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f12817p.droppedFrames(this.f12810Q, elapsedRealtime - this.f12809P);
            this.f12810Q = 0;
            this.f12809P = elapsedRealtime;
        }
    }
}
