package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import p000.C2042z2;

/* renamed from: com.google.common.util.concurrent.i */
/* loaded from: classes2.dex */
public final class RunnableC0998i implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2042z2 f15395a;

    public RunnableC0998i(C2042z2 c2042z2) {
        this.f15395a = c2042z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2042z2 c2042z2 = this.f15395a;
        try {
            c2042z2.f29223r.lock();
            try {
                if (c2042z2.state() != Service.State.STOPPING) {
                    return;
                }
                c2042z2.f29225t.shutDown();
                c2042z2.f29223r.unlock();
                c2042z2.notifyStopped();
            } finally {
                c2042z2.f29223r.unlock();
            }
        } catch (Throwable th) {
            c2042z2.notifyFailed(th);
        }
    }
}
