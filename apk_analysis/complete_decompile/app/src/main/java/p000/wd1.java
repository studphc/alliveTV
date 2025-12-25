package p000;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class wd1 extends AtomicLong implements td1 {
    @Override // p000.td1
    /* renamed from: a */
    public final void mo78a() {
        getAndIncrement();
    }

    @Override // p000.td1
    /* renamed from: b */
    public final long mo79b() {
        return get();
    }

    @Override // p000.td1
    /* renamed from: c */
    public final void mo80c(long j) {
        getAndAdd(j);
    }
}
