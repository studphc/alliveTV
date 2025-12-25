package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PersistableBundle;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;
import p000.AbstractC1608o3;
import p000.C1117dc;
import p000.C1190fc;
import p000.C1227gc;
import p000.C1264hc;
import p000.C1682pc;
import p000.HandlerC1714q7;
import p000.RunnableC0006a5;

/* renamed from: com.google.android.exoplayer2.mediacodec.a */
/* loaded from: classes.dex */
public final class C0676a implements MediaCodecAdapter {

    /* renamed from: a */
    public final MediaCodec f10729a;

    /* renamed from: b */
    public final C1264hc f10730b;

    /* renamed from: c */
    public final C1227gc f10731c;

    /* renamed from: d */
    public final boolean f10732d;

    /* renamed from: e */
    public boolean f10733e;

    /* renamed from: f */
    public int f10734f = 0;

    public C0676a(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z) {
        this.f10729a = mediaCodec;
        this.f10730b = new C1264hc(handlerThread);
        this.f10731c = new C1227gc(mediaCodec, handlerThread2);
        this.f10732d = z;
    }

    /* renamed from: a */
    public static void m2667a(C0676a c0676a, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        boolean z;
        C1264hc c1264hc = c0676a.f10730b;
        if (c1264hc.f18006c == null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        HandlerThread handlerThread = c1264hc.f18005b;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        MediaCodec mediaCodec = c0676a.f10729a;
        mediaCodec.setCallback(c1264hc, handler);
        c1264hc.f18006c = handler;
        TraceUtil.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, mediaCrypto, i);
        TraceUtil.endSection();
        C1227gc c1227gc = c0676a.f10731c;
        if (!c1227gc.f17643f) {
            HandlerThread handlerThread2 = c1227gc.f17639b;
            handlerThread2.start();
            c1227gc.f17640c = new HandlerC1714q7(c1227gc, handlerThread2.getLooper(), 1);
            c1227gc.f17643f = true;
        }
        TraceUtil.beginSection("startCodec");
        mediaCodec.start();
        TraceUtil.endSection();
        c0676a.f10734f = 1;
    }

    /* renamed from: b */
    public static String m2668b(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    /* renamed from: c */
    public final void m2669c() {
        if (this.f10732d) {
            try {
                C1227gc c1227gc = this.f10731c;
                ConditionVariable conditionVariable = c1227gc.f17642e;
                conditionVariable.close();
                ((Handler) Assertions.checkNotNull(c1227gc.f17640c)).obtainMessage(2).sendToTarget();
                conditionVariable.block();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[Catch: all -> 0x001c, DONT_GENERATE, TryCatch #0 {all -> 0x001c, blocks: (B:4:0x0005, B:6:0x000f, B:12:0x001a, B:16:0x001e, B:18:0x0023, B:20:0x0027, B:25:0x0036, B:26:0x0032, B:28:0x0038, B:29:0x003a, B:30:0x003b, B:31:0x003d), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001e A[Catch: all -> 0x001c, TryCatch #0 {all -> 0x001c, blocks: (B:4:0x0005, B:6:0x000f, B:12:0x001a, B:16:0x001e, B:18:0x0023, B:20:0x0027, B:25:0x0036, B:26:0x0032, B:28:0x0038, B:29:0x003a, B:30:0x003b, B:31:0x003d), top: B:3:0x0005 }] */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int dequeueInputBufferIndex() {
        boolean z;
        int i;
        C1264hc c1264hc = this.f10730b;
        synchronized (c1264hc.f18004a) {
            try {
                boolean z2 = true;
                if (c1264hc.f18014k <= 0 && !c1264hc.f18015l) {
                    z = false;
                    i = -1;
                    if (z) {
                        IllegalStateException illegalStateException = c1264hc.f18016m;
                        if (illegalStateException == null) {
                            MediaCodec.CodecException codecException = c1264hc.f18013j;
                            if (codecException == null) {
                                C1682pc c1682pc = c1264hc.f18007d;
                                if (c1682pc.f25114c != 0) {
                                    z2 = false;
                                }
                                if (!z2) {
                                    i = c1682pc.m6906e();
                                }
                            } else {
                                c1264hc.f18013j = null;
                                throw codecException;
                            }
                        } else {
                            c1264hc.f18016m = null;
                            throw illegalStateException;
                        }
                    }
                }
                z = true;
                i = -1;
                if (z) {
                }
            } finally {
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[Catch: all -> 0x001c, DONT_GENERATE, TryCatch #0 {all -> 0x001c, blocks: (B:4:0x0005, B:6:0x000f, B:12:0x001a, B:16:0x001e, B:18:0x0023, B:20:0x0027, B:24:0x0031, B:26:0x0033, B:28:0x0039, B:29:0x0060, B:32:0x0056, B:34:0x0062, B:35:0x0064, B:36:0x0065, B:37:0x0067), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001e A[Catch: all -> 0x001c, TryCatch #0 {all -> 0x001c, blocks: (B:4:0x0005, B:6:0x000f, B:12:0x001a, B:16:0x001e, B:18:0x0023, B:20:0x0027, B:24:0x0031, B:26:0x0033, B:28:0x0039, B:29:0x0060, B:32:0x0056, B:34:0x0062, B:35:0x0064, B:36:0x0065, B:37:0x0067), top: B:3:0x0005 }] */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        boolean z;
        int i;
        C1264hc c1264hc = this.f10730b;
        synchronized (c1264hc.f18004a) {
            try {
                boolean z2 = true;
                if (c1264hc.f18014k <= 0 && !c1264hc.f18015l) {
                    z = false;
                    i = -1;
                    if (z) {
                        IllegalStateException illegalStateException = c1264hc.f18016m;
                        if (illegalStateException == null) {
                            MediaCodec.CodecException codecException = c1264hc.f18013j;
                            if (codecException == null) {
                                C1682pc c1682pc = c1264hc.f18008e;
                                if (c1682pc.f25114c != 0) {
                                    z2 = false;
                                }
                                if (!z2) {
                                    i = c1682pc.m6906e();
                                    if (i >= 0) {
                                        Assertions.checkStateNotNull(c1264hc.f18011h);
                                        MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) c1264hc.f18009f.remove();
                                        bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                                    } else if (i == -2) {
                                        c1264hc.f18011h = (MediaFormat) c1264hc.f18010g.remove();
                                    }
                                }
                            } else {
                                c1264hc.f18013j = null;
                                throw codecException;
                            }
                        } else {
                            c1264hc.f18016m = null;
                            throw illegalStateException;
                        }
                    }
                }
                z = true;
                i = -1;
                if (z) {
                }
            } finally {
            }
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void flush() {
        this.f10731c.m4935a();
        this.f10729a.flush();
        C1264hc c1264hc = this.f10730b;
        synchronized (c1264hc.f18004a) {
            c1264hc.f18014k++;
            ((Handler) Util.castNonNull(c1264hc.f18006c)).post(new RunnableC0006a5(1, c1264hc));
        }
        this.f10729a.start();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final ByteBuffer getInputBuffer(int i) {
        return this.f10729a.getInputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final PersistableBundle getMetrics() {
        PersistableBundle metrics;
        m2669c();
        metrics = this.f10729a.getMetrics();
        return metrics;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final ByteBuffer getOutputBuffer(int i) {
        return this.f10729a.getOutputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        C1264hc c1264hc = this.f10730b;
        synchronized (c1264hc.f18004a) {
            try {
                mediaFormat = c1264hc.f18011h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final boolean needsReconfiguration() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        C1227gc c1227gc = this.f10731c;
        RuntimeException runtimeException = (RuntimeException) c1227gc.f17641d.getAndSet(null);
        if (runtimeException == null) {
            C1190fc m4933b = C1227gc.m4933b();
            m4933b.f17203a = i;
            m4933b.f17204b = i2;
            m4933b.f17205c = i3;
            m4933b.f17207e = j;
            m4933b.f17208f = i4;
            ((Handler) Util.castNonNull(c1227gc.f17640c)).obtainMessage(0, m4933b).sendToTarget();
            return;
        }
        throw runtimeException;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        C1227gc c1227gc = this.f10731c;
        RuntimeException runtimeException = (RuntimeException) c1227gc.f17641d.getAndSet(null);
        if (runtimeException == null) {
            C1190fc m4933b = C1227gc.m4933b();
            m4933b.f17203a = i;
            m4933b.f17204b = i2;
            m4933b.f17205c = 0;
            m4933b.f17207e = j;
            m4933b.f17208f = i3;
            int i4 = cryptoInfo.numSubSamples;
            MediaCodec.CryptoInfo cryptoInfo2 = m4933b.f17206d;
            cryptoInfo2.numSubSamples = i4;
            int[] iArr = cryptoInfo.numBytesOfClearData;
            int[] iArr2 = cryptoInfo2.numBytesOfClearData;
            if (iArr != null) {
                if (iArr2 != null && iArr2.length >= iArr.length) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                } else {
                    iArr2 = Arrays.copyOf(iArr, iArr.length);
                }
            }
            cryptoInfo2.numBytesOfClearData = iArr2;
            int[] iArr3 = cryptoInfo.numBytesOfEncryptedData;
            int[] iArr4 = cryptoInfo2.numBytesOfEncryptedData;
            if (iArr3 != null) {
                if (iArr4 != null && iArr4.length >= iArr3.length) {
                    System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
                } else {
                    iArr4 = Arrays.copyOf(iArr3, iArr3.length);
                }
            }
            cryptoInfo2.numBytesOfEncryptedData = iArr4;
            byte[] bArr = cryptoInfo.key;
            byte[] bArr2 = cryptoInfo2.key;
            if (bArr != null) {
                if (bArr2 != null && bArr2.length >= bArr.length) {
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                } else {
                    bArr2 = Arrays.copyOf(bArr, bArr.length);
                }
            }
            cryptoInfo2.key = (byte[]) Assertions.checkNotNull(bArr2);
            byte[] bArr3 = cryptoInfo.f9920iv;
            byte[] bArr4 = cryptoInfo2.iv;
            if (bArr3 != null) {
                if (bArr4 != null && bArr4.length >= bArr3.length) {
                    System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                } else {
                    bArr4 = Arrays.copyOf(bArr3, bArr3.length);
                }
            }
            cryptoInfo2.iv = (byte[]) Assertions.checkNotNull(bArr4);
            cryptoInfo2.mode = cryptoInfo.mode;
            if (Util.SDK_INT >= 24) {
                AbstractC1608o3.m6429q();
                cryptoInfo2.setPattern(AbstractC1608o3.m6418f(cryptoInfo.encryptedBlocks, cryptoInfo.clearBlocks));
            }
            ((Handler) Util.castNonNull(c1227gc.f17640c)).obtainMessage(1, m4933b).sendToTarget();
            return;
        }
        throw runtimeException;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void release() {
        try {
            if (this.f10734f == 1) {
                C1227gc c1227gc = this.f10731c;
                if (c1227gc.f17643f) {
                    c1227gc.m4935a();
                    c1227gc.f17639b.quit();
                }
                c1227gc.f17643f = false;
                C1264hc c1264hc = this.f10730b;
                synchronized (c1264hc.f18004a) {
                    c1264hc.f18015l = true;
                    c1264hc.f18005b.quit();
                    c1264hc.m5050a();
                }
            }
            this.f10734f = 2;
            if (!this.f10733e) {
                this.f10729a.release();
                this.f10733e = true;
            }
        } catch (Throwable th) {
            if (!this.f10733e) {
                this.f10729a.release();
                this.f10733e = true;
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void releaseOutputBuffer(int i, boolean z) {
        this.f10729a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void setOnFrameRenderedListener(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        m2669c();
        this.f10729a.setOnFrameRenderedListener(new C1117dc(this, onFrameRenderedListener, 0), handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void setOutputSurface(Surface surface) {
        m2669c();
        this.f10729a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void setParameters(Bundle bundle) {
        m2669c();
        this.f10729a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void setVideoScalingMode(int i) {
        m2669c();
        this.f10729a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public final void releaseOutputBuffer(int i, long j) {
        this.f10729a.releaseOutputBuffer(i, j);
    }
}
