package p000;

import com.google.common.util.concurrent.AbstractC1022u;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: h7 */
/* loaded from: classes2.dex */
public final class C1259h7 extends p63 {

    /* renamed from: f */
    public final AtomicReferenceFieldUpdater f17958f;

    /* renamed from: g */
    public final AtomicIntegerFieldUpdater f17959g;

    public C1259h7(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        this.f17958f = atomicReferenceFieldUpdater;
        this.f17959g = atomicIntegerFieldUpdater;
    }

    @Override // p000.p63
    /* renamed from: v */
    public final void mo5038v(AbstractC1022u abstractC1022u, Set set) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f17958f;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractC1022u, null, set)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(abstractC1022u) == null);
    }

    @Override // p000.p63
    /* renamed from: y */
    public final int mo5039y(AbstractC1022u abstractC1022u) {
        return this.f17959g.decrementAndGet(abstractC1022u);
    }
}
