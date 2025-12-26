package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.HandlerWrapper;
import java.util.ArrayList;

/* renamed from: com.google.android.exoplayer2.util.e */
/* loaded from: classes.dex */
public final class C0740e implements HandlerWrapper {

    /* renamed from: b */
    public static final ArrayList f12791b = new ArrayList(50);

    /* renamed from: a */
    public final Handler f12792a;

    public C0740e(Handler handler) {
        this.f12792a = handler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0739d m3053a() {
        C0739d c0739d;
        ArrayList arrayList = f12791b;
        synchronized (arrayList) {
            try {
                if (arrayList.isEmpty()) {
                    c0739d = new Object();
                } else {
                    c0739d = (C0739d) arrayList.remove(arrayList.size() - 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0739d;
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final Looper getLooper() {
        return this.f12792a.getLooper();
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final boolean hasMessages(int i) {
        return this.f12792a.hasMessages(i);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final HandlerWrapper.Message obtainMessage(int i) {
        C0739d m3053a = m3053a();
        m3053a.f12789a = this.f12792a.obtainMessage(i);
        m3053a.f12790b = this;
        return m3053a;
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final boolean post(Runnable runnable) {
        return this.f12792a.post(runnable);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final boolean postAtFrontOfQueue(Runnable runnable) {
        return this.f12792a.postAtFrontOfQueue(runnable);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final boolean postDelayed(Runnable runnable, long j) {
        return this.f12792a.postDelayed(runnable, j);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final void removeCallbacksAndMessages(Object obj) {
        this.f12792a.removeCallbacksAndMessages(obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final void removeMessages(int i) {
        this.f12792a.removeMessages(i);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final boolean sendEmptyMessage(int i) {
        return this.f12792a.sendEmptyMessage(i);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final boolean sendEmptyMessageAtTime(int i, long j) {
        return this.f12792a.sendEmptyMessageAtTime(i, j);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final boolean sendEmptyMessageDelayed(int i, int i2) {
        return this.f12792a.sendEmptyMessageDelayed(i, i2);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final boolean sendMessageAtFrontOfQueue(HandlerWrapper.Message message) {
        C0739d c0739d = (C0739d) message;
        boolean sendMessageAtFrontOfQueue = this.f12792a.sendMessageAtFrontOfQueue((Message) Assertions.checkNotNull(c0739d.f12789a));
        c0739d.m3052a();
        return sendMessageAtFrontOfQueue;
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final HandlerWrapper.Message obtainMessage(int i, Object obj) {
        C0739d m3053a = m3053a();
        m3053a.f12789a = this.f12792a.obtainMessage(i, obj);
        m3053a.f12790b = this;
        return m3053a;
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final HandlerWrapper.Message obtainMessage(int i, int i2, int i3) {
        C0739d m3053a = m3053a();
        m3053a.f12789a = this.f12792a.obtainMessage(i, i2, i3);
        m3053a.f12790b = this;
        return m3053a;
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public final HandlerWrapper.Message obtainMessage(int i, int i2, int i3, Object obj) {
        C0739d m3053a = m3053a();
        m3053a.f12789a = this.f12792a.obtainMessage(i, i2, i3, obj);
        m3053a.f12790b = this;
        return m3053a;
    }
}
