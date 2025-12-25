package p000;

import java.util.concurrent.CountDownLatch;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;

/* loaded from: classes2.dex */
public final class gs2 extends Task {

    /* renamed from: e */
    public final CountDownLatch f17825e;

    public gs2() {
        super(AbstractC1726qj.m7061q(new StringBuilder(), _UtilJvmKt.okHttpName, " awaitIdle"), false);
        this.f17825e = new CountDownLatch(1);
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        this.f17825e.countDown();
        return -1L;
    }
}
