package p000;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class vd1 extends AtomicLong implements sd1 {
    @Override // p000.sd1
    /* renamed from: a */
    public final void mo7360a() {
        getAndIncrement();
    }

    @Override // p000.sd1
    /* renamed from: b */
    public final long mo7361b() {
        return get();
    }

    @Override // p000.sd1
    /* renamed from: c */
    public final void mo7362c(long j) {
        getAndAdd(j);
    }
}
