package p000;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: l0 */
/* loaded from: classes2.dex */
public final class C1494l0 extends yy2 {

    /* renamed from: p */
    public final AtomicReferenceFieldUpdater f22264p;

    /* renamed from: q */
    public final AtomicReferenceFieldUpdater f22265q;

    /* renamed from: r */
    public final AtomicReferenceFieldUpdater f22266r;

    /* renamed from: s */
    public final AtomicReferenceFieldUpdater f22267s;

    /* renamed from: t */
    public final AtomicReferenceFieldUpdater f22268t;

    public C1494l0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f22264p = atomicReferenceFieldUpdater;
        this.f22265q = atomicReferenceFieldUpdater2;
        this.f22266r = atomicReferenceFieldUpdater3;
        this.f22267s = atomicReferenceFieldUpdater4;
        this.f22268t = atomicReferenceFieldUpdater5;
    }

    @Override // p000.yy2
    /* renamed from: H */
    public final void mo5804H(C1892v0 c1892v0, C1892v0 c1892v02) {
        this.f22265q.lazySet(c1892v0, c1892v02);
    }

    @Override // p000.yy2
    /* renamed from: I */
    public final void mo5805I(C1892v0 c1892v0, Thread thread) {
        this.f22264p.lazySet(c1892v0, thread);
    }

    @Override // p000.yy2
    /* renamed from: i */
    public final boolean mo5806i(AbstractFuture abstractFuture, C1374k0 c1374k0, C1374k0 c1374k02) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f22267s;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, c1374k0, c1374k02)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractFuture) == c1374k0);
        return false;
    }

    @Override // p000.yy2
    /* renamed from: j */
    public final boolean mo5807j(AbstractFuture abstractFuture, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f22268t;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractFuture) == obj);
        return false;
    }

    @Override // p000.yy2
    /* renamed from: k */
    public final boolean mo5808k(AbstractFuture abstractFuture, C1892v0 c1892v0, C1892v0 c1892v02) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f22266r;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, c1892v0, c1892v02)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractFuture) == c1892v0);
        return false;
    }

    @Override // p000.yy2
    /* renamed from: o */
    public final C1374k0 mo5809o(AbstractFuture abstractFuture) {
        return (C1374k0) this.f22267s.getAndSet(abstractFuture, C1374k0.f20701d);
    }

    @Override // p000.yy2
    /* renamed from: p */
    public final C1892v0 mo5810p(AbstractFuture abstractFuture) {
        return (C1892v0) this.f22266r.getAndSet(abstractFuture, C1892v0.f27559c);
    }
}
