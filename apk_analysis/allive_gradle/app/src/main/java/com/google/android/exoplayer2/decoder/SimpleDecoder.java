package com.google.android.exoplayer2.decoder;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;
import p000.ki2;

/* loaded from: classes.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {

    /* renamed from: a */
    public final ki2 f9923a;

    /* renamed from: b */
    public final Object f9924b = new Object();

    /* renamed from: c */
    public final ArrayDeque f9925c = new ArrayDeque();

    /* renamed from: d */
    public final ArrayDeque f9926d = new ArrayDeque();

    /* renamed from: e */
    public final DecoderInputBuffer[] f9927e;

    /* renamed from: f */
    public final DecoderOutputBuffer[] f9928f;

    /* renamed from: g */
    public int f9929g;

    /* renamed from: h */
    public int f9930h;

    /* renamed from: i */
    public DecoderInputBuffer f9931i;

    /* renamed from: j */
    public DecoderException f9932j;

    /* renamed from: k */
    public boolean f9933k;

    /* renamed from: l */
    public boolean f9934l;

    /* renamed from: m */
    public int f9935m;

    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.f9927e = iArr;
        this.f9929g = iArr.length;
        for (int i = 0; i < this.f9929g; i++) {
            this.f9927e[i] = createInputBuffer();
        }
        this.f9928f = oArr;
        this.f9930h = oArr.length;
        for (int i2 = 0; i2 < this.f9930h; i2++) {
            this.f9928f[i2] = createOutputBuffer();
        }
        ki2 ki2Var = new ki2(this);
        this.f9923a = ki2Var;
        ki2Var.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final boolean m2508a() {
        DecoderException createUnexpectedDecodeException;
        boolean z;
        synchronized (this.f9924b) {
            while (!this.f9934l) {
                try {
                    if (!this.f9925c.isEmpty() && this.f9930h > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                    this.f9924b.wait();
                } finally {
                }
            }
            if (this.f9934l) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f9925c.removeFirst();
            DecoderOutputBuffer[] decoderOutputBufferArr = this.f9928f;
            int i = this.f9930h - 1;
            this.f9930h = i;
            DecoderOutputBuffer decoderOutputBuffer = decoderOutputBufferArr[i];
            boolean z2 = this.f9933k;
            this.f9933k = false;
            if (decoderInputBuffer.isEndOfStream()) {
                decoderOutputBuffer.addFlag(4);
            } else {
                if (decoderInputBuffer.isDecodeOnly()) {
                    decoderOutputBuffer.addFlag(Integer.MIN_VALUE);
                }
                if (decoderInputBuffer.isFirstSample()) {
                    decoderOutputBuffer.addFlag(C0643C.BUFFER_FLAG_FIRST_SAMPLE);
                }
                try {
                    createUnexpectedDecodeException = decode(decoderInputBuffer, decoderOutputBuffer, z2);
                } catch (OutOfMemoryError e) {
                    createUnexpectedDecodeException = createUnexpectedDecodeException(e);
                } catch (RuntimeException e2) {
                    createUnexpectedDecodeException = createUnexpectedDecodeException(e2);
                }
                if (createUnexpectedDecodeException != null) {
                    synchronized (this.f9924b) {
                        this.f9932j = createUnexpectedDecodeException;
                    }
                    return false;
                }
            }
            synchronized (this.f9924b) {
                try {
                    if (this.f9933k) {
                        decoderOutputBuffer.release();
                    } else if (decoderOutputBuffer.isDecodeOnly()) {
                        this.f9935m++;
                        decoderOutputBuffer.release();
                    } else {
                        decoderOutputBuffer.skippedOutputBufferCount = this.f9935m;
                        this.f9935m = 0;
                        this.f9926d.addLast(decoderOutputBuffer);
                    }
                    decoderInputBuffer.clear();
                    int i2 = this.f9929g;
                    this.f9929g = i2 + 1;
                    this.f9927e[i2] = decoderInputBuffer;
                } finally {
                }
            }
            return true;
        }
    }

    public abstract I createInputBuffer();

    public abstract O createOutputBuffer();

    public abstract E createUnexpectedDecodeException(Throwable th);

    @Nullable
    public abstract E decode(I i, O o, boolean z);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void flush() {
        synchronized (this.f9924b) {
            try {
                this.f9933k = true;
                this.f9935m = 0;
                DecoderInputBuffer decoderInputBuffer = this.f9931i;
                if (decoderInputBuffer != null) {
                    decoderInputBuffer.clear();
                    int i = this.f9929g;
                    this.f9929g = i + 1;
                    this.f9927e[i] = decoderInputBuffer;
                    this.f9931i = null;
                }
                while (!this.f9925c.isEmpty()) {
                    DecoderInputBuffer decoderInputBuffer2 = (DecoderInputBuffer) this.f9925c.removeFirst();
                    decoderInputBuffer2.clear();
                    int i2 = this.f9929g;
                    this.f9929g = i2 + 1;
                    this.f9927e[i2] = decoderInputBuffer2;
                }
                while (!this.f9926d.isEmpty()) {
                    ((DecoderOutputBuffer) this.f9926d.removeFirst()).release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @CallSuper
    public void release() {
        synchronized (this.f9924b) {
            this.f9934l = true;
            this.f9924b.notify();
        }
        try {
            this.f9923a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @CallSuper
    public void releaseOutputBuffer(O o) {
        synchronized (this.f9924b) {
            o.clear();
            int i = this.f9930h;
            this.f9930h = i + 1;
            this.f9928f[i] = o;
            if (!this.f9925c.isEmpty() && this.f9930h > 0) {
                this.f9924b.notify();
            }
        }
    }

    public final void setInitialInputBufferSize(int i) {
        boolean z;
        int i2 = this.f9929g;
        DecoderInputBuffer[] decoderInputBufferArr = this.f9927e;
        if (i2 == decoderInputBufferArr.length) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        for (DecoderInputBuffer decoderInputBuffer : decoderInputBufferArr) {
            decoderInputBuffer.ensureSpaceForWrite(i);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public final I dequeueInputBuffer() {
        I i;
        synchronized (this.f9924b) {
            try {
                DecoderException decoderException = this.f9932j;
                if (decoderException == null) {
                    Assertions.checkState(this.f9931i == null);
                    int i2 = this.f9929g;
                    if (i2 == 0) {
                        i = null;
                    } else {
                        DecoderInputBuffer[] decoderInputBufferArr = this.f9927e;
                        int i3 = i2 - 1;
                        this.f9929g = i3;
                        i = (I) decoderInputBufferArr[i3];
                    }
                    this.f9931i = i;
                } else {
                    throw decoderException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public final O dequeueOutputBuffer() {
        synchronized (this.f9924b) {
            try {
                DecoderException decoderException = this.f9932j;
                if (decoderException == null) {
                    if (this.f9926d.isEmpty()) {
                        return null;
                    }
                    return (O) this.f9926d.removeFirst();
                }
                throw decoderException;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void queueInputBuffer(I i) {
        synchronized (this.f9924b) {
            try {
                DecoderException decoderException = this.f9932j;
                if (decoderException == null) {
                    Assertions.checkArgument(i == this.f9931i);
                    this.f9925c.addLast(i);
                    if (!this.f9925c.isEmpty() && this.f9930h > 0) {
                        this.f9924b.notify();
                    }
                    this.f9931i = null;
                } else {
                    throw decoderException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
