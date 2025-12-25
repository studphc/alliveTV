package p000;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;

/* renamed from: hc */
/* loaded from: classes.dex */
public final class C1264hc extends MediaCodec.Callback {

    /* renamed from: b */
    public final HandlerThread f18005b;

    /* renamed from: c */
    public Handler f18006c;

    /* renamed from: h */
    public MediaFormat f18011h;

    /* renamed from: i */
    public MediaFormat f18012i;

    /* renamed from: j */
    public MediaCodec.CodecException f18013j;

    /* renamed from: k */
    public long f18014k;

    /* renamed from: l */
    public boolean f18015l;

    /* renamed from: m */
    public IllegalStateException f18016m;

    /* renamed from: a */
    public final Object f18004a = new Object();

    /* renamed from: d */
    public final C1682pc f18007d = new C1682pc();

    /* renamed from: e */
    public final C1682pc f18008e = new C1682pc();

    /* renamed from: f */
    public final ArrayDeque f18009f = new ArrayDeque();

    /* renamed from: g */
    public final ArrayDeque f18010g = new ArrayDeque();

    public C1264hc(HandlerThread handlerThread) {
        this.f18005b = handlerThread;
    }

    /* renamed from: a */
    public final void m5050a() {
        ArrayDeque arrayDeque = this.f18010g;
        if (!arrayDeque.isEmpty()) {
            this.f18012i = (MediaFormat) arrayDeque.getLast();
        }
        C1682pc c1682pc = this.f18007d;
        c1682pc.f25112a = 0;
        c1682pc.f25113b = -1;
        c1682pc.f25114c = 0;
        C1682pc c1682pc2 = this.f18008e;
        c1682pc2.f25112a = 0;
        c1682pc2.f25113b = -1;
        c1682pc2.f25114c = 0;
        this.f18009f.clear();
        arrayDeque.clear();
        this.f18013j = null;
    }

    /* renamed from: b */
    public final void m5051b(IllegalStateException illegalStateException) {
        synchronized (this.f18004a) {
            this.f18016m = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f18004a) {
            this.f18013j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.f18004a) {
            this.f18007d.m6905d(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f18004a) {
            try {
                MediaFormat mediaFormat = this.f18012i;
                if (mediaFormat != null) {
                    this.f18008e.m6905d(-2);
                    this.f18010g.add(mediaFormat);
                    this.f18012i = null;
                }
                this.f18008e.m6905d(i);
                this.f18009f.add(bufferInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f18004a) {
            this.f18008e.m6905d(-2);
            this.f18010g.add(mediaFormat);
            this.f18012i = null;
        }
    }
}
