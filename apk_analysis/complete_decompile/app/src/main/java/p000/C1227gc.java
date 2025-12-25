package p000;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: gc */
/* loaded from: classes.dex */
public final class C1227gc {

    /* renamed from: g */
    public static final ArrayDeque f17636g = new ArrayDeque();

    /* renamed from: h */
    public static final Object f17637h = new Object();

    /* renamed from: a */
    public final MediaCodec f17638a;

    /* renamed from: b */
    public final HandlerThread f17639b;

    /* renamed from: c */
    public HandlerC1714q7 f17640c;

    /* renamed from: d */
    public final AtomicReference f17641d;

    /* renamed from: e */
    public final ConditionVariable f17642e;

    /* renamed from: f */
    public boolean f17643f;

    public C1227gc(MediaCodec mediaCodec, HandlerThread handlerThread) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this.f17638a = mediaCodec;
        this.f17639b = handlerThread;
        this.f17642e = conditionVariable;
        this.f17641d = new AtomicReference();
    }

    /* renamed from: b */
    public static C1190fc m4933b() {
        ArrayDeque arrayDeque = f17636g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new C1190fc();
                }
                return (C1190fc) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    public static void m4934c(C1190fc c1190fc) {
        ArrayDeque arrayDeque = f17636g;
        synchronized (arrayDeque) {
            arrayDeque.add(c1190fc);
        }
    }

    /* renamed from: a */
    public final void m4935a() {
        if (this.f17643f) {
            try {
                ((Handler) Assertions.checkNotNull(this.f17640c)).removeCallbacksAndMessages(null);
                ConditionVariable conditionVariable = this.f17642e;
                conditionVariable.close();
                ((Handler) Assertions.checkNotNull(this.f17640c)).obtainMessage(2).sendToTarget();
                conditionVariable.block();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }
}
