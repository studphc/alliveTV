package p000;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: t2 */
/* loaded from: classes.dex */
public final class C1820t2 extends o63 {

    /* renamed from: u */
    public final AtomicReferenceFieldUpdater f26668u;

    /* renamed from: v */
    public final AtomicReferenceFieldUpdater f26669v;

    /* renamed from: w */
    public final AtomicReferenceFieldUpdater f26670w;

    /* renamed from: x */
    public final AtomicReferenceFieldUpdater f26671x;

    /* renamed from: y */
    public final AtomicReferenceFieldUpdater f26672y;

    public C1820t2(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f26668u = atomicReferenceFieldUpdater;
        this.f26669v = atomicReferenceFieldUpdater2;
        this.f26670w = atomicReferenceFieldUpdater3;
        this.f26671x = atomicReferenceFieldUpdater4;
        this.f26672y = atomicReferenceFieldUpdater5;
    }

    @Override // p000.o63
    /* renamed from: d */
    public final boolean mo6480d(AbstractResolvableFuture abstractResolvableFuture, C1783s2 c1783s2, C1783s2 c1783s22) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f26671x;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, c1783s2, c1783s22)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == c1783s2);
        return false;
    }

    @Override // p000.o63
    /* renamed from: e */
    public final boolean mo6481e(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f26672y;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == obj);
        return false;
    }

    @Override // p000.o63
    /* renamed from: f */
    public final boolean mo6482f(AbstractResolvableFuture abstractResolvableFuture, C1931w2 c1931w2, C1931w2 c1931w22) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f26670w;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, c1931w2, c1931w22)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == c1931w2);
        return false;
    }

    @Override // p000.o63
    /* renamed from: y */
    public final void mo6483y(C1931w2 c1931w2, C1931w2 c1931w22) {
        this.f26669v.lazySet(c1931w2, c1931w22);
    }

    @Override // p000.o63
    /* renamed from: z */
    public final void mo6484z(C1931w2 c1931w2, Thread thread) {
        this.f26668u.lazySet(c1931w2, thread);
    }
}
