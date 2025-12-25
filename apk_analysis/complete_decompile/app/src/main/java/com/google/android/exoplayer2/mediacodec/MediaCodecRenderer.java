package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.FrameworkCryptoConfig;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import p000.C1121dg;
import p000.C1624oj;
import p000.s60;

/* loaded from: classes.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    protected static final float CODEC_OPERATING_RATE_UNSET = -1.0f;

    /* renamed from: E0 */
    public static final byte[] f10653E0 = {0, 0, 1, 103, 66, -64, Ascii.f14468VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.f14464SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.f14455CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.f14458FS, 49, -61, 39, 93, 120};

    /* renamed from: A */
    public final long[] f10654A;

    /* renamed from: A0 */
    public ExoPlaybackException f10655A0;

    /* renamed from: B */
    public Format f10656B;

    /* renamed from: B0 */
    public long f10657B0;

    /* renamed from: C */
    public Format f10658C;

    /* renamed from: C0 */
    public long f10659C0;

    /* renamed from: D */
    public DrmSession f10660D;

    /* renamed from: D0 */
    public int f10661D0;

    /* renamed from: E */
    public DrmSession f10662E;

    /* renamed from: F */
    public MediaCrypto f10663F;

    /* renamed from: G */
    public boolean f10664G;

    /* renamed from: H */
    public long f10665H;

    /* renamed from: I */
    public float f10666I;

    /* renamed from: J */
    public float f10667J;

    /* renamed from: K */
    public MediaCodecAdapter f10668K;

    /* renamed from: L */
    public Format f10669L;

    /* renamed from: M */
    public MediaFormat f10670M;

    /* renamed from: N */
    public boolean f10671N;

    /* renamed from: O */
    public float f10672O;

    /* renamed from: P */
    public ArrayDeque f10673P;

    /* renamed from: Q */
    public DecoderInitializationException f10674Q;

    /* renamed from: R */
    public MediaCodecInfo f10675R;

    /* renamed from: S */
    public int f10676S;

    /* renamed from: T */
    public boolean f10677T;

    /* renamed from: U */
    public boolean f10678U;

    /* renamed from: V */
    public boolean f10679V;

    /* renamed from: W */
    public boolean f10680W;

    /* renamed from: X */
    public boolean f10681X;

    /* renamed from: Y */
    public boolean f10682Y;

    /* renamed from: Z */
    public boolean f10683Z;

    /* renamed from: a0 */
    public boolean f10684a0;

    /* renamed from: b0 */
    public boolean f10685b0;

    /* renamed from: c0 */
    public boolean f10686c0;

    /* renamed from: d0 */
    public C1624oj f10687d0;
    protected DecoderCounters decoderCounters;

    /* renamed from: e0 */
    public long f10688e0;

    /* renamed from: f0 */
    public int f10689f0;

    /* renamed from: g0 */
    public int f10690g0;

    /* renamed from: h0 */
    public ByteBuffer f10691h0;

    /* renamed from: i0 */
    public boolean f10692i0;

    /* renamed from: j0 */
    public boolean f10693j0;

    /* renamed from: k0 */
    public boolean f10694k0;

    /* renamed from: l0 */
    public boolean f10695l0;

    /* renamed from: m0 */
    public boolean f10696m0;

    /* renamed from: n */
    public final MediaCodecAdapter.Factory f10697n;

    /* renamed from: n0 */
    public boolean f10698n0;

    /* renamed from: o */
    public final MediaCodecSelector f10699o;

    /* renamed from: o0 */
    public int f10700o0;

    /* renamed from: p */
    public final boolean f10701p;

    /* renamed from: p0 */
    public int f10702p0;

    /* renamed from: q */
    public final float f10703q;

    /* renamed from: q0 */
    public int f10704q0;

    /* renamed from: r */
    public final DecoderInputBuffer f10705r;

    /* renamed from: r0 */
    public boolean f10706r0;

    /* renamed from: s */
    public final DecoderInputBuffer f10707s;

    /* renamed from: s0 */
    public boolean f10708s0;

    /* renamed from: t */
    public final DecoderInputBuffer f10709t;

    /* renamed from: t0 */
    public boolean f10710t0;

    /* renamed from: u */
    public final C1121dg f10711u;

    /* renamed from: u0 */
    public long f10712u0;

    /* renamed from: v */
    public final TimedValueQueue f10713v;

    /* renamed from: v0 */
    public long f10714v0;

    /* renamed from: w */
    public final ArrayList f10715w;

    /* renamed from: w0 */
    public boolean f10716w0;

    /* renamed from: x */
    public final MediaCodec.BufferInfo f10717x;

    /* renamed from: x0 */
    public boolean f10718x0;

    /* renamed from: y */
    public final long[] f10719y;

    /* renamed from: y0 */
    public boolean f10720y0;

    /* renamed from: z */
    public final long[] f10721z;

    /* renamed from: z0 */
    public boolean f10722z0;

    /* JADX WARN: Type inference failed for: r2v6, types: [dg, com.google.android.exoplayer2.decoder.DecoderInputBuffer] */
    public MediaCodecRenderer(int i, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z, float f) {
        super(i);
        this.f10697n = factory;
        this.f10699o = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector);
        this.f10701p = z;
        this.f10703q = f;
        this.f10705r = DecoderInputBuffer.newNoDataInstance();
        this.f10707s = new DecoderInputBuffer(0);
        this.f10709t = new DecoderInputBuffer(2);
        ?? decoderInputBuffer = new DecoderInputBuffer(2);
        decoderInputBuffer.f16366f = 32;
        this.f10711u = decoderInputBuffer;
        this.f10713v = new TimedValueQueue();
        this.f10715w = new ArrayList();
        this.f10717x = new MediaCodec.BufferInfo();
        this.f10666I = 1.0f;
        this.f10667J = 1.0f;
        this.f10665H = C0643C.TIME_UNSET;
        this.f10719y = new long[10];
        this.f10721z = new long[10];
        this.f10654A = new long[10];
        this.f10657B0 = C0643C.TIME_UNSET;
        this.f10659C0 = C0643C.TIME_UNSET;
        decoderInputBuffer.ensureSpaceForWrite(0);
        decoderInputBuffer.data.order(ByteOrder.nativeOrder());
        this.f10672O = -1.0f;
        this.f10676S = 0;
        this.f10700o0 = 0;
        this.f10689f0 = -1;
        this.f10690g0 = -1;
        this.f10688e0 = C0643C.TIME_UNSET;
        this.f10712u0 = C0643C.TIME_UNSET;
        this.f10714v0 = C0643C.TIME_UNSET;
        this.f10702p0 = 0;
        this.f10704q0 = 0;
    }

    public static boolean supportsFormatDrm(Format format) {
        int i = format.cryptoType;
        if (i != 0 && i != 2) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* renamed from: a */
    public final boolean m2646a(long j, long j2) {
        boolean z;
        boolean z2;
        C1121dg c1121dg;
        Assertions.checkState(!this.f10718x0);
        C1121dg c1121dg2 = this.f10711u;
        int i = c1121dg2.f16365e;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (processOutputBuffer(j, j2, null, c1121dg2.data, this.f10690g0, 0, i, c1121dg2.timeUs, c1121dg2.isDecodeOnly(), c1121dg2.isEndOfStream(), this.f10658C)) {
                c1121dg = c1121dg2;
                onProcessedOutputBuffer(c1121dg.f16364d);
                c1121dg.clear();
                z2 = 0;
            } else {
                return false;
            }
        } else {
            z2 = 0;
            c1121dg = c1121dg2;
        }
        if (this.f10716w0) {
            this.f10718x0 = true;
            return z2;
        }
        boolean z3 = this.f10695l0;
        DecoderInputBuffer decoderInputBuffer = this.f10709t;
        if (z3) {
            Assertions.checkState(c1121dg.m4579b(decoderInputBuffer));
            this.f10695l0 = z2;
        }
        if (this.f10696m0) {
            if (c1121dg.f16365e > 0) {
                return true;
            }
            m2647b();
            this.f10696m0 = z2;
            maybeInitCodecOrBypass();
            if (!this.f10694k0) {
                return z2;
            }
        }
        Assertions.checkState(!this.f10716w0);
        FormatHolder formatHolder = getFormatHolder();
        decoderInputBuffer.clear();
        while (true) {
            decoderInputBuffer.clear();
            int readSource = readSource(formatHolder, decoderInputBuffer, z2);
            if (readSource != -5) {
                if (readSource != -4) {
                    if (readSource != -3) {
                        throw new IllegalStateException();
                    }
                } else {
                    if (decoderInputBuffer.isEndOfStream()) {
                        this.f10716w0 = true;
                        break;
                    }
                    if (this.f10720y0) {
                        Format format = (Format) Assertions.checkNotNull(this.f10656B);
                        this.f10658C = format;
                        onOutputFormatChanged(format, null);
                        this.f10720y0 = z2;
                    }
                    decoderInputBuffer.flip();
                    if (!c1121dg.m4579b(decoderInputBuffer)) {
                        this.f10695l0 = true;
                        break;
                    }
                }
            } else {
                onInputFormatChanged(formatHolder);
                break;
            }
        }
        if (c1121dg.f16365e > 0) {
            c1121dg.flip();
        }
        if (c1121dg.f16365e > 0 || this.f10716w0 || this.f10696m0) {
            return true;
        }
        return z2;
    }

    /* renamed from: b */
    public final void m2647b() {
        this.f10696m0 = false;
        this.f10711u.clear();
        this.f10709t.clear();
        this.f10695l0 = false;
        this.f10694k0 = false;
    }

    /* renamed from: c */
    public final void m2648c() {
        if (this.f10706r0) {
            this.f10702p0 = 1;
            this.f10704q0 = 3;
        } else {
            releaseCodec();
            maybeInitCodecOrBypass();
        }
    }

    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, 0, 1);
    }

    public MediaCodecDecoderException createDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    /* renamed from: d */
    public final boolean m2649d() {
        if (this.f10706r0) {
            this.f10702p0 = 1;
            if (!this.f10678U && !this.f10680W) {
                this.f10704q0 = 2;
            } else {
                this.f10704q0 = 3;
                return false;
            }
        } else {
            m2661p();
        }
        return true;
    }

    /* renamed from: e */
    public final boolean m2650e(long j, long j2) {
        boolean z;
        boolean z2;
        boolean z3;
        MediaCodec.BufferInfo bufferInfo;
        boolean processOutputBuffer;
        boolean z4;
        int dequeueOutputBufferIndex;
        boolean z5;
        boolean z6;
        if (this.f10690g0 >= 0) {
            z = true;
        } else {
            z = false;
        }
        MediaCodec.BufferInfo bufferInfo2 = this.f10717x;
        if (!z) {
            if (this.f10681X && this.f10708s0) {
                try {
                    dequeueOutputBufferIndex = this.f10668K.dequeueOutputBufferIndex(bufferInfo2);
                } catch (IllegalStateException unused) {
                    m2657l();
                    if (this.f10718x0) {
                        releaseCodec();
                    }
                    return false;
                }
            } else {
                dequeueOutputBufferIndex = this.f10668K.dequeueOutputBufferIndex(bufferInfo2);
            }
            if (dequeueOutputBufferIndex < 0) {
                if (dequeueOutputBufferIndex == -2) {
                    this.f10710t0 = true;
                    MediaFormat outputFormat = this.f10668K.getOutputFormat();
                    if (this.f10676S != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                        this.f10685b0 = true;
                    } else {
                        if (this.f10683Z) {
                            outputFormat.setInteger("channel-count", 1);
                        }
                        this.f10670M = outputFormat;
                        this.f10671N = true;
                    }
                    return true;
                }
                if (this.f10686c0 && (this.f10716w0 || this.f10702p0 == 2)) {
                    m2657l();
                }
                return false;
            }
            if (this.f10685b0) {
                this.f10685b0 = false;
                this.f10668K.releaseOutputBuffer(dequeueOutputBufferIndex, false);
                return true;
            }
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                m2657l();
                return false;
            }
            this.f10690g0 = dequeueOutputBufferIndex;
            ByteBuffer outputBuffer = this.f10668K.getOutputBuffer(dequeueOutputBufferIndex);
            this.f10691h0 = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(bufferInfo2.offset);
                this.f10691h0.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.f10682Y && bufferInfo2.presentationTimeUs == 0 && (bufferInfo2.flags & 4) != 0) {
                long j3 = this.f10712u0;
                if (j3 != C0643C.TIME_UNSET) {
                    bufferInfo2.presentationTimeUs = j3;
                }
            }
            long j4 = bufferInfo2.presentationTimeUs;
            ArrayList arrayList = this.f10715w;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (((Long) arrayList.get(i)).longValue() == j4) {
                        arrayList.remove(i);
                        z5 = true;
                        break;
                    }
                    i++;
                } else {
                    z5 = false;
                    break;
                }
            }
            this.f10692i0 = z5;
            long j5 = this.f10714v0;
            long j6 = bufferInfo2.presentationTimeUs;
            if (j5 == j6) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f10693j0 = z6;
            updateOutputFormatForTime(j6);
        }
        if (this.f10681X && this.f10708s0) {
            try {
                z2 = true;
                z3 = false;
            } catch (IllegalStateException unused2) {
                z3 = false;
            }
            try {
                processOutputBuffer = processOutputBuffer(j, j2, this.f10668K, this.f10691h0, this.f10690g0, bufferInfo2.flags, 1, bufferInfo2.presentationTimeUs, this.f10692i0, this.f10693j0, this.f10658C);
                bufferInfo = bufferInfo2;
            } catch (IllegalStateException unused3) {
                m2657l();
                if (this.f10718x0) {
                    releaseCodec();
                }
                return z3;
            }
        } else {
            z2 = true;
            z3 = false;
            bufferInfo = bufferInfo2;
            processOutputBuffer = processOutputBuffer(j, j2, this.f10668K, this.f10691h0, this.f10690g0, bufferInfo2.flags, 1, bufferInfo2.presentationTimeUs, this.f10692i0, this.f10693j0, this.f10658C);
        }
        if (processOutputBuffer) {
            onProcessedOutputBuffer(bufferInfo.presentationTimeUs);
            if ((bufferInfo.flags & 4) != 0) {
                z4 = z2;
            } else {
                z4 = z3;
            }
            this.f10690g0 = -1;
            this.f10691h0 = null;
            if (!z4) {
                return z2;
            }
            m2657l();
        }
        return z3;
    }

    /* renamed from: f */
    public final boolean m2651f() {
        int i;
        boolean z;
        long j;
        if (this.f10668K == null || (i = this.f10702p0) == 2 || this.f10716w0) {
            return false;
        }
        if (i == 0 && shouldReinitCodec()) {
            m2648c();
        }
        int i2 = this.f10689f0;
        DecoderInputBuffer decoderInputBuffer = this.f10707s;
        if (i2 < 0) {
            int dequeueInputBufferIndex = this.f10668K.dequeueInputBufferIndex();
            this.f10689f0 = dequeueInputBufferIndex;
            if (dequeueInputBufferIndex < 0) {
                return false;
            }
            decoderInputBuffer.data = this.f10668K.getInputBuffer(dequeueInputBufferIndex);
            decoderInputBuffer.clear();
        }
        if (this.f10702p0 == 1) {
            if (!this.f10686c0) {
                this.f10708s0 = true;
                this.f10668K.queueInputBuffer(this.f10689f0, 0, 0, 0L, 4);
                this.f10689f0 = -1;
                decoderInputBuffer.data = null;
            }
            this.f10702p0 = 2;
            return false;
        }
        if (this.f10684a0) {
            this.f10684a0 = false;
            decoderInputBuffer.data.put(f10653E0);
            this.f10668K.queueInputBuffer(this.f10689f0, 0, 38, 0L, 0);
            this.f10689f0 = -1;
            decoderInputBuffer.data = null;
            this.f10706r0 = true;
            return true;
        }
        if (this.f10700o0 == 1) {
            for (int i3 = 0; i3 < this.f10669L.initializationData.size(); i3++) {
                decoderInputBuffer.data.put(this.f10669L.initializationData.get(i3));
            }
            this.f10700o0 = 2;
        }
        int position = decoderInputBuffer.data.position();
        FormatHolder formatHolder = getFormatHolder();
        try {
            int readSource = readSource(formatHolder, decoderInputBuffer, 0);
            if (hasReadStreamToEnd()) {
                this.f10714v0 = this.f10712u0;
            }
            if (readSource == -3) {
                return false;
            }
            if (readSource == -5) {
                if (this.f10700o0 == 2) {
                    decoderInputBuffer.clear();
                    this.f10700o0 = 1;
                }
                onInputFormatChanged(formatHolder);
                return true;
            }
            if (decoderInputBuffer.isEndOfStream()) {
                if (this.f10700o0 == 2) {
                    decoderInputBuffer.clear();
                    this.f10700o0 = 1;
                }
                this.f10716w0 = true;
                if (!this.f10706r0) {
                    m2657l();
                    return false;
                }
                try {
                    if (!this.f10686c0) {
                        this.f10708s0 = true;
                        this.f10668K.queueInputBuffer(this.f10689f0, 0, 0, 0L, 4);
                        this.f10689f0 = -1;
                        decoderInputBuffer.data = null;
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw createRendererException(e, this.f10656B, Util.getErrorCodeForMediaDrmErrorCode(e.getErrorCode()));
                }
            }
            if (!this.f10706r0 && !decoderInputBuffer.isKeyFrame()) {
                decoderInputBuffer.clear();
                if (this.f10700o0 == 2) {
                    this.f10700o0 = 1;
                }
                return true;
            }
            boolean isEncrypted = decoderInputBuffer.isEncrypted();
            if (isEncrypted) {
                decoderInputBuffer.cryptoInfo.increaseClearDataFirstSubSampleBy(position);
            }
            if (this.f10677T && !isEncrypted) {
                NalUnitUtil.discardToSps(decoderInputBuffer.data);
                if (decoderInputBuffer.data.position() == 0) {
                    return true;
                }
                this.f10677T = false;
            }
            long j2 = decoderInputBuffer.timeUs;
            C1624oj c1624oj = this.f10687d0;
            if (c1624oj != null) {
                Format format = this.f10656B;
                if (c1624oj.f23819b == 0) {
                    c1624oj.f23818a = j2;
                }
                if (!c1624oj.f23820c) {
                    ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data);
                    int i4 = 0;
                    for (int i5 = 0; i5 < 4; i5++) {
                        i4 = (i4 << 8) | (byteBuffer.get(i5) & 255);
                    }
                    int parseMpegAudioFrameSampleCount = MpegAudioUtil.parseMpegAudioFrameSampleCount(i4);
                    if (parseMpegAudioFrameSampleCount == -1) {
                        c1624oj.f23820c = true;
                        c1624oj.f23819b = 0L;
                        c1624oj.f23818a = decoderInputBuffer.timeUs;
                        Log.m3027w("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
                        j2 = decoderInputBuffer.timeUs;
                    } else {
                        long max = Math.max(0L, ((c1624oj.f23819b - 529) * 1000000) / format.sampleRate) + c1624oj.f23818a;
                        c1624oj.f23819b += parseMpegAudioFrameSampleCount;
                        j2 = max;
                    }
                }
                long j3 = this.f10712u0;
                C1624oj c1624oj2 = this.f10687d0;
                Format format2 = this.f10656B;
                c1624oj2.getClass();
                z = isEncrypted;
                this.f10712u0 = Math.max(j3, Math.max(0L, ((c1624oj2.f23819b - 529) * 1000000) / format2.sampleRate) + c1624oj2.f23818a);
                j = j2;
            } else {
                z = isEncrypted;
                j = j2;
            }
            if (decoderInputBuffer.isDecodeOnly()) {
                this.f10715w.add(Long.valueOf(j));
            }
            if (this.f10720y0) {
                this.f10713v.add(j, this.f10656B);
                this.f10720y0 = false;
            }
            this.f10712u0 = Math.max(this.f10712u0, j);
            decoderInputBuffer.flip();
            if (decoderInputBuffer.hasSupplementalData()) {
                handleInputBufferSupplementalData(decoderInputBuffer);
            }
            onQueueInputBuffer(decoderInputBuffer);
            try {
                if (z) {
                    this.f10668K.queueSecureInputBuffer(this.f10689f0, 0, decoderInputBuffer.cryptoInfo, j, 0);
                } else {
                    this.f10668K.queueInputBuffer(this.f10689f0, 0, decoderInputBuffer.data.limit(), j, 0);
                }
                this.f10689f0 = -1;
                decoderInputBuffer.data = null;
                this.f10706r0 = true;
                this.f10700o0 = 0;
                this.decoderCounters.queuedInputBufferCount++;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw createRendererException(e2, this.f10656B, Util.getErrorCodeForMediaDrmErrorCode(e2.getErrorCode()));
            }
        } catch (DecoderInputBuffer.InsufficientCapacityException e3) {
            onCodecError(e3);
            m2658m(0);
            m2652g();
            return true;
        }
    }

    public final boolean flushOrReinitializeCodec() {
        boolean flushOrReleaseCodec = flushOrReleaseCodec();
        if (flushOrReleaseCodec) {
            maybeInitCodecOrBypass();
        }
        return flushOrReleaseCodec;
    }

    public boolean flushOrReleaseCodec() {
        boolean z;
        if (this.f10668K == null) {
            return false;
        }
        int i = this.f10704q0;
        if (i != 3 && !this.f10678U && ((!this.f10679V || this.f10710t0) && (!this.f10680W || !this.f10708s0))) {
            if (i == 2) {
                int i2 = Util.SDK_INT;
                if (i2 >= 23) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkState(z);
                if (i2 >= 23) {
                    try {
                        m2661p();
                    } catch (ExoPlaybackException e) {
                        Log.m3028w("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                        releaseCodec();
                        return true;
                    }
                }
            }
            m2652g();
            return false;
        }
        releaseCodec();
        return true;
    }

    /* renamed from: g */
    public final void m2652g() {
        try {
            this.f10668K.flush();
        } finally {
            resetCodecStateForFlush();
        }
    }

    @Nullable
    public final MediaCodecAdapter getCodec() {
        return this.f10668K;
    }

    @Nullable
    public final MediaCodecInfo getCodecInfo() {
        return this.f10675R;
    }

    public boolean getCodecNeedsEosPropagation() {
        return false;
    }

    public float getCodecOperatingRate() {
        return this.f10672O;
    }

    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        return -1.0f;
    }

    @Nullable
    public final MediaFormat getCodecOutputMediaFormat() {
        return this.f10670M;
    }

    public abstract List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z);

    public abstract MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, @Nullable MediaCrypto mediaCrypto, float f);

    public final long getOutputStreamOffsetUs() {
        return this.f10659C0;
    }

    public float getPlaybackSpeed() {
        return this.f10666I;
    }

    /* renamed from: h */
    public final List m2653h(boolean z) {
        Format format = this.f10656B;
        MediaCodecSelector mediaCodecSelector = this.f10699o;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, z);
        if (decoderInfos.isEmpty() && z) {
            decoderInfos = getDecoderInfos(mediaCodecSelector, this.f10656B, false);
            if (!decoderInfos.isEmpty()) {
                Log.m3027w("MediaCodecRenderer", "Drm session requires secure decoder for " + this.f10656B.sampleMimeType + ", but no secure decoder available. Trying to proceed with " + decoderInfos + ".");
            }
        }
        return decoderInfos;
    }

    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) {
    }

    /* renamed from: i */
    public final FrameworkCryptoConfig m2654i(DrmSession drmSession) {
        CryptoConfig cryptoConfig = drmSession.getCryptoConfig();
        if (cryptoConfig != null && !(cryptoConfig instanceof FrameworkCryptoConfig)) {
            throw createRendererException(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + cryptoConfig), this.f10656B, PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED);
        }
        return (FrameworkCryptoConfig) cryptoConfig;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.f10718x0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.f10656B != null && (isSourceReady() || this.f10690g0 >= 0 || (this.f10688e0 != C0643C.TIME_UNSET && SystemClock.elapsedRealtime() < this.f10688e0))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x014e, code lost:
    
        if ("stvm8".equals(r5) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x015e, code lost:
    
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r2) == false) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x022d  */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, oj] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2655j(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto) {
        float codecOperatingRateV23;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        String str;
        String str2 = mediaCodecInfo.name;
        int i2 = Util.SDK_INT;
        float f = -1.0f;
        if (i2 < 23) {
            codecOperatingRateV23 = -1.0f;
        } else {
            codecOperatingRateV23 = getCodecOperatingRateV23(this.f10667J, this.f10656B, getStreamFormats());
        }
        if (codecOperatingRateV23 > this.f10703q) {
            f = codecOperatingRateV23;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        MediaCodecAdapter.Configuration mediaCodecConfiguration = getMediaCodecConfiguration(mediaCodecInfo, this.f10656B, mediaCrypto, f);
        if (i2 >= 31) {
            AbstractC0677b.m2670a(mediaCodecConfiguration, getPlayerId());
        }
        try {
            TraceUtil.beginSection("createCodec:" + str2);
            this.f10668K = this.f10697n.createAdapter(mediaCodecConfiguration);
            TraceUtil.endSection();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f10675R = mediaCodecInfo;
            this.f10672O = f;
            this.f10669L = this.f10656B;
            if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str2)) {
                String str3 = Util.MODEL;
                if (str3.startsWith("SM-T585") || str3.startsWith("SM-A510") || str3.startsWith("SM-A520") || str3.startsWith("SM-J700")) {
                    i = 2;
                    this.f10676S = i;
                    Format format = this.f10669L;
                    if (i2 >= 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.f10677T = z;
                    if (i2 < 18 && ((i2 != 18 || (!"OMX.SEC.avc.dec".equals(str2) && !"OMX.SEC.avc.dec.secure".equals(str2))) && (i2 != 19 || !Util.MODEL.startsWith("SM-G800") || (!"OMX.Exynos.avc.dec".equals(str2) && !"OMX.Exynos.avc.dec.secure".equals(str2))))) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    this.f10678U = z2;
                    if (i2 != 29 && "c2.android.aac.decoder".equals(str2)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.f10679V = z3;
                    if (i2 <= 23 || !"OMX.google.vorbis.decoder".equals(str2)) {
                        if (i2 <= 19) {
                            String str4 = Util.DEVICE;
                            if (!"hb2000".equals(str4)) {
                            }
                            if (!"OMX.amlogic.avc.decoder.awesome".equals(str2)) {
                            }
                        }
                        z4 = false;
                        this.f10680W = z4;
                        if (i2 != 21 && "OMX.google.aac.decoder".equals(str2)) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        this.f10681X = z5;
                        if (i2 < 21 && "OMX.SEC.mp3.dec".equals(str2) && "samsung".equals(Util.MANUFACTURER)) {
                            str = Util.DEVICE;
                            if (!str.startsWith("baffin") || str.startsWith("grand") || str.startsWith("fortuna") || str.startsWith("gprimelte") || str.startsWith("j2y18lte") || str.startsWith("ms01")) {
                                z6 = true;
                                this.f10682Y = z6;
                                Format format2 = this.f10669L;
                                if (i2 > 18 && format2.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                this.f10683Z = z7;
                                String str5 = mediaCodecInfo.name;
                                if ((i2 > 25 && "OMX.rk.video_decoder.avc".equals(str5)) || ((i2 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str5)) || ((i2 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str5) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str5))) || (("Amazon".equals(Util.MANUFACTURER) && "AFTS".equals(Util.MODEL) && mediaCodecInfo.secure) || getCodecNeedsEosPropagation())))) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                this.f10686c0 = z8;
                                if (this.f10668K.needsReconfiguration()) {
                                    this.f10698n0 = true;
                                    this.f10700o0 = 1;
                                    if (this.f10676S != 0) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    this.f10684a0 = z9;
                                }
                                if ("c2.android.mp3.decoder".equals(mediaCodecInfo.name)) {
                                    this.f10687d0 = new Object();
                                }
                                if (getState() == 2) {
                                    this.f10688e0 = SystemClock.elapsedRealtime() + 1000;
                                }
                                this.decoderCounters.decoderInitCount++;
                                onCodecInitialized(str2, mediaCodecConfiguration, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                            }
                        }
                        z6 = false;
                        this.f10682Y = z6;
                        Format format22 = this.f10669L;
                        if (i2 > 18) {
                        }
                        z7 = false;
                        this.f10683Z = z7;
                        String str52 = mediaCodecInfo.name;
                        if (i2 > 25) {
                        }
                        z8 = false;
                        this.f10686c0 = z8;
                        if (this.f10668K.needsReconfiguration()) {
                        }
                        if ("c2.android.mp3.decoder".equals(mediaCodecInfo.name)) {
                        }
                        if (getState() == 2) {
                        }
                        this.decoderCounters.decoderInitCount++;
                        onCodecInitialized(str2, mediaCodecConfiguration, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    }
                    z4 = true;
                    this.f10680W = z4;
                    if (i2 != 21) {
                    }
                    z5 = false;
                    this.f10681X = z5;
                    if (i2 < 21) {
                        str = Util.DEVICE;
                        if (!str.startsWith("baffin")) {
                        }
                        z6 = true;
                        this.f10682Y = z6;
                        Format format222 = this.f10669L;
                        if (i2 > 18) {
                        }
                        z7 = false;
                        this.f10683Z = z7;
                        String str522 = mediaCodecInfo.name;
                        if (i2 > 25) {
                        }
                        z8 = false;
                        this.f10686c0 = z8;
                        if (this.f10668K.needsReconfiguration()) {
                        }
                        if ("c2.android.mp3.decoder".equals(mediaCodecInfo.name)) {
                        }
                        if (getState() == 2) {
                        }
                        this.decoderCounters.decoderInitCount++;
                        onCodecInitialized(str2, mediaCodecConfiguration, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    }
                    z6 = false;
                    this.f10682Y = z6;
                    Format format2222 = this.f10669L;
                    if (i2 > 18) {
                    }
                    z7 = false;
                    this.f10683Z = z7;
                    String str5222 = mediaCodecInfo.name;
                    if (i2 > 25) {
                    }
                    z8 = false;
                    this.f10686c0 = z8;
                    if (this.f10668K.needsReconfiguration()) {
                    }
                    if ("c2.android.mp3.decoder".equals(mediaCodecInfo.name)) {
                    }
                    if (getState() == 2) {
                    }
                    this.decoderCounters.decoderInitCount++;
                    onCodecInitialized(str2, mediaCodecConfiguration, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                }
            }
            if (i2 < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2))) {
                String str6 = Util.DEVICE;
                if ("flounder".equals(str6) || "flounder_lte".equals(str6) || "grouper".equals(str6) || "tilapia".equals(str6)) {
                    i = 1;
                    this.f10676S = i;
                    Format format3 = this.f10669L;
                    if (i2 >= 21) {
                    }
                    z = false;
                    this.f10677T = z;
                    if (i2 < 18) {
                    }
                    z2 = true;
                    this.f10678U = z2;
                    if (i2 != 29) {
                    }
                    z3 = false;
                    this.f10679V = z3;
                    if (i2 <= 23) {
                    }
                    if (i2 <= 19) {
                    }
                    z4 = false;
                    this.f10680W = z4;
                    if (i2 != 21) {
                    }
                    z5 = false;
                    this.f10681X = z5;
                    if (i2 < 21) {
                    }
                    z6 = false;
                    this.f10682Y = z6;
                    Format format22222 = this.f10669L;
                    if (i2 > 18) {
                    }
                    z7 = false;
                    this.f10683Z = z7;
                    String str52222 = mediaCodecInfo.name;
                    if (i2 > 25) {
                    }
                    z8 = false;
                    this.f10686c0 = z8;
                    if (this.f10668K.needsReconfiguration()) {
                    }
                    if ("c2.android.mp3.decoder".equals(mediaCodecInfo.name)) {
                    }
                    if (getState() == 2) {
                    }
                    this.decoderCounters.decoderInitCount++;
                    onCodecInitialized(str2, mediaCodecConfiguration, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                }
            }
            i = 0;
            this.f10676S = i;
            Format format32 = this.f10669L;
            if (i2 >= 21) {
            }
            z = false;
            this.f10677T = z;
            if (i2 < 18) {
            }
            z2 = true;
            this.f10678U = z2;
            if (i2 != 29) {
            }
            z3 = false;
            this.f10679V = z3;
            if (i2 <= 23) {
            }
            if (i2 <= 19) {
            }
            z4 = false;
            this.f10680W = z4;
            if (i2 != 21) {
            }
            z5 = false;
            this.f10681X = z5;
            if (i2 < 21) {
            }
            z6 = false;
            this.f10682Y = z6;
            Format format222222 = this.f10669L;
            if (i2 > 18) {
            }
            z7 = false;
            this.f10683Z = z7;
            String str522222 = mediaCodecInfo.name;
            if (i2 > 25) {
            }
            z8 = false;
            this.f10686c0 = z8;
            if (this.f10668K.needsReconfiguration()) {
            }
            if ("c2.android.mp3.decoder".equals(mediaCodecInfo.name)) {
            }
            if (getState() == 2) {
            }
            this.decoderCounters.decoderInitCount++;
            onCodecInitialized(str2, mediaCodecConfiguration, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th) {
            TraceUtil.endSection();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2656k(MediaCrypto mediaCrypto, boolean z) {
        DecoderInitializationException decoderInitializationException;
        if (this.f10673P == null) {
            try {
                List m2653h = m2653h(z);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.f10673P = arrayDeque;
                if (this.f10701p) {
                    arrayDeque.addAll(m2653h);
                } else if (!m2653h.isEmpty()) {
                    this.f10673P.add((MediaCodecInfo) m2653h.get(0));
                }
                this.f10674Q = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.f10656B, e, z, -49998);
            }
        }
        if (!this.f10673P.isEmpty()) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) this.f10673P.peekFirst();
            while (this.f10668K == null) {
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) this.f10673P.peekFirst();
                if (!shouldInitCodec(mediaCodecInfo2)) {
                    return;
                }
                try {
                    m2655j(mediaCodecInfo2, mediaCrypto);
                } catch (Exception e2) {
                    if (mediaCodecInfo2 == mediaCodecInfo) {
                        try {
                            Log.m3027w("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                            Thread.sleep(50L);
                            m2655j(mediaCodecInfo2, mediaCrypto);
                        } catch (Exception e3) {
                            Log.m3028w("MediaCodecRenderer", "Failed to initialize decoder: " + mediaCodecInfo2, e3);
                            this.f10673P.removeFirst();
                            DecoderInitializationException decoderInitializationException2 = new DecoderInitializationException(this.f10656B, e3, z, mediaCodecInfo2);
                            onCodecError(decoderInitializationException2);
                            decoderInitializationException = this.f10674Q;
                            if (decoderInitializationException != null) {
                                this.f10674Q = decoderInitializationException2;
                            } else {
                                this.f10674Q = new DecoderInitializationException(decoderInitializationException.getMessage(), decoderInitializationException.getCause(), decoderInitializationException.mimeType, decoderInitializationException.secureDecoderRequired, decoderInitializationException.codecInfo, decoderInitializationException.diagnosticInfo, decoderInitializationException2);
                            }
                            if (!this.f10673P.isEmpty()) {
                                throw this.f10674Q;
                            }
                        }
                    } else {
                        throw e2;
                        break;
                    }
                    Log.m3028w("MediaCodecRenderer", "Failed to initialize decoder: " + mediaCodecInfo2, e3);
                    this.f10673P.removeFirst();
                    DecoderInitializationException decoderInitializationException22 = new DecoderInitializationException(this.f10656B, e3, z, mediaCodecInfo2);
                    onCodecError(decoderInitializationException22);
                    decoderInitializationException = this.f10674Q;
                    if (decoderInitializationException != null) {
                    }
                    if (!this.f10673P.isEmpty()) {
                    }
                }
            }
            this.f10673P = null;
            return;
        }
        throw new DecoderInitializationException(this.f10656B, (Throwable) null, z, -49999);
    }

    /* renamed from: l */
    public final void m2657l() {
        int i = this.f10704q0;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    this.f10718x0 = true;
                    renderToEndOfStream();
                    return;
                } else {
                    releaseCodec();
                    maybeInitCodecOrBypass();
                    return;
                }
            }
            m2652g();
            m2661p();
            return;
        }
        m2652g();
    }

    /* renamed from: m */
    public final boolean m2658m(int i) {
        FormatHolder formatHolder = getFormatHolder();
        DecoderInputBuffer decoderInputBuffer = this.f10705r;
        decoderInputBuffer.clear();
        int readSource = readSource(formatHolder, decoderInputBuffer, i | 4);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (readSource == -4 && decoderInputBuffer.isEndOfStream()) {
            this.f10716w0 = true;
            m2657l();
            return false;
        }
        return false;
    }

    public final void maybeInitCodecOrBypass() {
        Format format;
        boolean z;
        if (this.f10668K == null && !this.f10694k0 && (format = this.f10656B) != null) {
            if (this.f10662E == null && shouldUseBypass(format)) {
                Format format2 = this.f10656B;
                m2647b();
                String str = format2.sampleMimeType;
                boolean equals = MimeTypes.AUDIO_AAC.equals(str);
                C1121dg c1121dg = this.f10711u;
                if (!equals && !MimeTypes.AUDIO_MPEG.equals(str) && !MimeTypes.AUDIO_OPUS.equals(str)) {
                    c1121dg.getClass();
                    Assertions.checkArgument(true);
                    c1121dg.f16366f = 1;
                } else {
                    c1121dg.getClass();
                    Assertions.checkArgument(true);
                    c1121dg.f16366f = 32;
                }
                this.f10694k0 = true;
                return;
            }
            m2659n(this.f10662E);
            String str2 = this.f10656B.sampleMimeType;
            DrmSession drmSession = this.f10660D;
            if (drmSession != null) {
                if (this.f10663F == null) {
                    FrameworkCryptoConfig m2654i = m2654i(drmSession);
                    if (m2654i == null) {
                        if (this.f10660D.getError() == null) {
                            return;
                        }
                    } else {
                        try {
                            MediaCrypto mediaCrypto = new MediaCrypto(m2654i.uuid, m2654i.sessionId);
                            this.f10663F = mediaCrypto;
                            if (!m2654i.forceAllowInsecureDecoderComponents && mediaCrypto.requiresSecureDecoderComponent(str2)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            this.f10664G = z;
                        } catch (MediaCryptoException e) {
                            throw createRendererException(e, this.f10656B, PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR);
                        }
                    }
                }
                if (FrameworkCryptoConfig.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                    int state = this.f10660D.getState();
                    if (state != 1) {
                        if (state != 4) {
                            return;
                        }
                    } else {
                        DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) Assertions.checkNotNull(this.f10660D.getError());
                        throw createRendererException(drmSessionException, this.f10656B, drmSessionException.errorCode);
                    }
                }
            }
            try {
                m2656k(this.f10663F, this.f10664G);
            } catch (DecoderInitializationException e2) {
                throw createRendererException(e2, this.f10656B, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
            }
        }
    }

    /* renamed from: n */
    public final void m2659n(DrmSession drmSession) {
        s60.m7333b(this.f10660D, drmSession);
        this.f10660D = drmSession;
    }

    /* renamed from: o */
    public final boolean m2660o(Format format) {
        if (Util.SDK_INT >= 23 && this.f10668K != null && this.f10704q0 != 3 && getState() != 0) {
            float codecOperatingRateV23 = getCodecOperatingRateV23(this.f10667J, format, getStreamFormats());
            float f = this.f10672O;
            if (f == codecOperatingRateV23) {
                return true;
            }
            if (codecOperatingRateV23 == -1.0f) {
                m2648c();
                return false;
            }
            if (f == -1.0f && codecOperatingRateV23 <= this.f10703q) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", codecOperatingRateV23);
            this.f10668K.setParameters(bundle);
            this.f10672O = codecOperatingRateV23;
        }
        return true;
    }

    public void onCodecError(Exception exc) {
    }

    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
    }

    public void onCodecReleased(String str) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.f10656B = null;
        this.f10657B0 = C0643C.TIME_UNSET;
        this.f10659C0 = C0643C.TIME_UNSET;
        this.f10661D0 = 0;
        flushOrReleaseCodec();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) {
        this.decoderCounters = new DecoderCounters();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
    
        if (r12 != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b2, code lost:
    
        if (m2649d() == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e5, code lost:
    
        if (m2649d() == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00f7, code lost:
    
        if (m2649d() == false) goto L60;
     */
    @Nullable
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) {
        boolean z;
        boolean z2;
        FrameworkCryptoConfig m2654i;
        boolean requiresSecureDecoder;
        boolean z3 = true;
        this.f10720y0 = true;
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        if (format.sampleMimeType != null) {
            DrmSession drmSession = formatHolder.drmSession;
            s60.m7333b(this.f10662E, drmSession);
            this.f10662E = drmSession;
            this.f10656B = format;
            if (this.f10694k0) {
                this.f10696m0 = true;
                return null;
            }
            MediaCodecAdapter mediaCodecAdapter = this.f10668K;
            if (mediaCodecAdapter == null) {
                this.f10673P = null;
                maybeInitCodecOrBypass();
                return null;
            }
            MediaCodecInfo mediaCodecInfo = this.f10675R;
            Format format2 = this.f10669L;
            DrmSession drmSession2 = this.f10660D;
            int i = 0;
            if (drmSession2 != drmSession) {
                if (drmSession != null && drmSession2 != null && Util.SDK_INT >= 23) {
                    UUID uuid = C0643C.PLAYREADY_UUID;
                    if (!uuid.equals(drmSession2.getSchemeUuid()) && !uuid.equals(drmSession.getSchemeUuid()) && (m2654i = m2654i(drmSession)) != null) {
                        if (m2654i.forceAllowInsecureDecoderComponents) {
                            requiresSecureDecoder = false;
                        } else {
                            requiresSecureDecoder = drmSession.requiresSecureDecoder(format.sampleMimeType);
                        }
                        if (!mediaCodecInfo.secure) {
                        }
                    }
                }
                m2648c();
                return new DecoderReuseEvaluation(mediaCodecInfo.name, format2, format, 0, 128);
            }
            if (this.f10662E != this.f10660D) {
                z = true;
            } else {
                z = false;
            }
            if (z && Util.SDK_INT < 23) {
                z2 = false;
            } else {
                z2 = true;
            }
            Assertions.checkState(z2);
            DecoderReuseEvaluation canReuseCodec = canReuseCodec(mediaCodecInfo, format2, format);
            int i2 = canReuseCodec.result;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            if (m2660o(format)) {
                                this.f10669L = format;
                                if (z) {
                                }
                            }
                            i = 16;
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        if (m2660o(format)) {
                            this.f10698n0 = true;
                            this.f10700o0 = 1;
                            int i3 = this.f10676S;
                            if (i3 != 2 && (i3 != 1 || format.width != format2.width || format.height != format2.height)) {
                                z3 = false;
                            }
                            this.f10684a0 = z3;
                            this.f10669L = format;
                            if (z) {
                            }
                        }
                        i = 16;
                    }
                } else {
                    if (m2660o(format)) {
                        this.f10669L = format;
                        if (!z) {
                            if (this.f10706r0) {
                                this.f10702p0 = 1;
                                if (!this.f10678U && !this.f10680W) {
                                    this.f10704q0 = 1;
                                } else {
                                    this.f10704q0 = 3;
                                    i = 2;
                                }
                            }
                        }
                    }
                    i = 16;
                }
            } else {
                m2648c();
            }
            if (canReuseCodec.result != 0 && (this.f10668K != mediaCodecAdapter || this.f10704q0 == 3)) {
                return new DecoderReuseEvaluation(mediaCodecInfo.name, format2, format, 0, i);
            }
            return canReuseCodec;
        }
        throw createRendererException(new IllegalArgumentException(), format, PlaybackException.ERROR_CODE_DECODING_FORMAT_UNSUPPORTED);
    }

    public void onOutputFormatChanged(Format format, @Nullable MediaFormat mediaFormat) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.f10716w0 = false;
        this.f10718x0 = false;
        this.f10722z0 = false;
        if (this.f10694k0) {
            this.f10711u.clear();
            this.f10709t.clear();
            this.f10695l0 = false;
        } else {
            flushOrReinitializeCodec();
        }
        TimedValueQueue timedValueQueue = this.f10713v;
        if (timedValueQueue.size() > 0) {
            this.f10720y0 = true;
        }
        timedValueQueue.clear();
        int i = this.f10661D0;
        if (i != 0) {
            int i2 = i - 1;
            this.f10659C0 = this.f10721z[i2];
            this.f10657B0 = this.f10719y[i2];
            this.f10661D0 = 0;
        }
    }

    @CallSuper
    public void onProcessedOutputBuffer(long j) {
        while (true) {
            int i = this.f10661D0;
            if (i != 0) {
                long[] jArr = this.f10654A;
                if (j >= jArr[0]) {
                    long[] jArr2 = this.f10719y;
                    this.f10657B0 = jArr2[0];
                    long[] jArr3 = this.f10721z;
                    this.f10659C0 = jArr3[0];
                    int i2 = i - 1;
                    this.f10661D0 = i2;
                    System.arraycopy(jArr2, 1, jArr2, 0, i2);
                    System.arraycopy(jArr3, 1, jArr3, 0, this.f10661D0);
                    System.arraycopy(jArr, 1, jArr, 0, this.f10661D0);
                    onProcessedStreamChange();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void onProcessedStreamChange() {
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        try {
            m2647b();
            releaseCodec();
        } finally {
            s60.m7333b(this.f10662E, null);
            this.f10662E = null;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        boolean z = true;
        if (this.f10659C0 == C0643C.TIME_UNSET) {
            if (this.f10657B0 != C0643C.TIME_UNSET) {
                z = false;
            }
            Assertions.checkState(z);
            this.f10657B0 = j;
            this.f10659C0 = j2;
            return;
        }
        int i = this.f10661D0;
        long[] jArr = this.f10721z;
        if (i == jArr.length) {
            Log.m3027w("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + jArr[this.f10661D0 - 1]);
        } else {
            this.f10661D0 = i + 1;
        }
        int i2 = this.f10661D0;
        this.f10719y[i2 - 1] = j;
        jArr[i2 - 1] = j2;
        this.f10654A[i2 - 1] = this.f10712u0;
    }

    /* renamed from: p */
    public final void m2661p() {
        try {
            this.f10663F.setMediaDrmSession(m2654i(this.f10662E).sessionId);
            m2659n(this.f10662E);
            this.f10702p0 = 0;
            this.f10704q0 = 0;
        } catch (MediaCryptoException e) {
            throw createRendererException(e, this.f10656B, PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR);
        }
    }

    public abstract boolean processOutputBuffer(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format);

    /* JADX WARN: Multi-variable type inference failed */
    public void releaseCodec() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.f10668K;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
                this.decoderCounters.decoderReleaseCount++;
                onCodecReleased(this.f10675R.name);
            }
            this.f10668K = null;
            try {
                MediaCrypto mediaCrypto = this.f10663F;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.f10668K = null;
            try {
                MediaCrypto mediaCrypto2 = this.f10663F;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006d A[LOOP:1: B:31:0x004b->B:40:0x006d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006e A[EDGE_INSN: B:41:0x006e->B:42:0x006e BREAK  A[LOOP:1: B:31:0x004b->B:40:0x006d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b A[LOOP:2: B:43:0x006e->B:52:0x008b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008c A[EDGE_INSN: B:53:0x008c->B:54:0x008c BREAK  A[LOOP:2: B:43:0x006e->B:52:0x008b], SYNTHETIC] */
    @Override // com.google.android.exoplayer2.Renderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void render(long j, long j2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.f10722z0) {
            this.f10722z0 = false;
            m2657l();
        }
        ExoPlaybackException exoPlaybackException = this.f10655A0;
        if (exoPlaybackException == null) {
            try {
                if (this.f10718x0) {
                    renderToEndOfStream();
                    return;
                }
                if (this.f10656B == null && !m2658m(2)) {
                    return;
                }
                maybeInitCodecOrBypass();
                if (this.f10694k0) {
                    TraceUtil.beginSection("bypassRender");
                    do {
                    } while (m2646a(j, j2));
                    TraceUtil.endSection();
                } else if (this.f10668K != null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    TraceUtil.beginSection("drainAndFeed");
                    while (m2650e(j, j2)) {
                        if (this.f10665H != C0643C.TIME_UNSET && SystemClock.elapsedRealtime() - elapsedRealtime >= this.f10665H) {
                            z3 = false;
                            if (z3) {
                                break;
                            }
                        }
                        z3 = true;
                        if (z3) {
                        }
                    }
                    while (m2651f()) {
                        if (this.f10665H != C0643C.TIME_UNSET && SystemClock.elapsedRealtime() - elapsedRealtime >= this.f10665H) {
                            z2 = false;
                            if (z2) {
                                break;
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                    }
                    TraceUtil.endSection();
                } else {
                    this.decoderCounters.skippedInputBufferCount += skipSource(j);
                    m2658m(1);
                }
                this.decoderCounters.ensureUpdated();
                return;
            } catch (IllegalStateException e) {
                int i = Util.SDK_INT;
                if (i < 21 || !(e instanceof MediaCodec.CodecException)) {
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
                        throw e;
                    }
                }
                onCodecError(e);
                if (i >= 21) {
                    if (e instanceof MediaCodec.CodecException) {
                        z = ((MediaCodec.CodecException) e).isRecoverable();
                    } else {
                        z = false;
                    }
                    if (z) {
                        z4 = true;
                    }
                }
                if (z4) {
                    releaseCodec();
                }
                throw createRendererException(createDecoderException(e, getCodecInfo()), this.f10656B, z4, PlaybackException.ERROR_CODE_DECODING_FAILED);
            }
        }
        this.f10655A0 = null;
        throw exoPlaybackException;
    }

    public void renderToEndOfStream() {
    }

    @CallSuper
    public void resetCodecStateForFlush() {
        this.f10689f0 = -1;
        this.f10707s.data = null;
        this.f10690g0 = -1;
        this.f10691h0 = null;
        this.f10688e0 = C0643C.TIME_UNSET;
        this.f10708s0 = false;
        this.f10706r0 = false;
        this.f10684a0 = false;
        this.f10685b0 = false;
        this.f10692i0 = false;
        this.f10693j0 = false;
        this.f10715w.clear();
        this.f10712u0 = C0643C.TIME_UNSET;
        this.f10714v0 = C0643C.TIME_UNSET;
        C1624oj c1624oj = this.f10687d0;
        if (c1624oj != null) {
            c1624oj.f23818a = 0L;
            c1624oj.f23819b = 0L;
            c1624oj.f23820c = false;
        }
        this.f10702p0 = 0;
        this.f10704q0 = 0;
        this.f10700o0 = this.f10698n0 ? 1 : 0;
    }

    @CallSuper
    public void resetCodecStateForRelease() {
        resetCodecStateForFlush();
        this.f10655A0 = null;
        this.f10687d0 = null;
        this.f10673P = null;
        this.f10675R = null;
        this.f10669L = null;
        this.f10670M = null;
        this.f10671N = false;
        this.f10710t0 = false;
        this.f10672O = -1.0f;
        this.f10676S = 0;
        this.f10677T = false;
        this.f10678U = false;
        this.f10679V = false;
        this.f10680W = false;
        this.f10681X = false;
        this.f10682Y = false;
        this.f10683Z = false;
        this.f10686c0 = false;
        this.f10698n0 = false;
        this.f10700o0 = 0;
        this.f10664G = false;
    }

    public final void setPendingOutputEndOfStream() {
        this.f10722z0 = true;
    }

    public final void setPendingPlaybackException(ExoPlaybackException exoPlaybackException) {
        this.f10655A0 = exoPlaybackException;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public void setPlaybackSpeed(float f, float f2) {
        this.f10666I = f;
        this.f10667J = f2;
        m2660o(this.f10669L);
    }

    public void setRenderTimeLimitMs(long j) {
        this.f10665H = j;
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    public boolean shouldReinitCodec() {
        return false;
    }

    public boolean shouldUseBypass(Format format) {
        return false;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) {
        try {
            return supportsFormat(this.f10699o, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw createRendererException(e, format, PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED);
        }
    }

    public abstract int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format);

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public final boolean updateCodecOperatingRate() {
        return m2660o(this.f10669L);
    }

    public final void updateOutputFormatForTime(long j) {
        TimedValueQueue timedValueQueue = this.f10713v;
        Format format = (Format) timedValueQueue.pollFloor(j);
        if (format == null && this.f10671N) {
            format = (Format) timedValueQueue.pollFirst();
        }
        if (format != null) {
            this.f10658C = format;
        } else if (!this.f10671N || this.f10658C == null) {
            return;
        }
        onOutputFormatChanged(this.f10658C, this.f10670M);
        this.f10671N = false;
    }

    /* loaded from: classes.dex */
    public static class DecoderInitializationException extends Exception {

        @Nullable
        public final MediaCodecInfo codecInfo;

        @Nullable
        public final String diagnosticInfo;

        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, @Nullable Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + format, th, format.sampleMimeType, z, null, "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i), null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DecoderInitializationException(Format format, @Nullable Throwable th, boolean z, MediaCodecInfo mediaCodecInfo) {
            this(r3, th, r5, z, mediaCodecInfo, r1, null);
            String str = "Decoder init failed: " + mediaCodecInfo.name + ", " + format;
            String str2 = format.sampleMimeType;
            String str3 = null;
            if (Util.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
                str3 = ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
        }

        public DecoderInitializationException(String str, Throwable th, String str2, boolean z, MediaCodecInfo mediaCodecInfo, String str3, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = mediaCodecInfo;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }
    }
}
