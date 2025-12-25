package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class xz2 extends AbstractC1218g3 {

    /* renamed from: b */
    public transient SoftReference f28777b;

    @Override // p000.mr1
    /* renamed from: a */
    public final Set mo6243a() {
        Object obj;
        SoftReference softReference = this.f28777b;
        if (softReference == null) {
            obj = null;
        } else {
            obj = softReference.get();
        }
        Multiset multiset = (Multiset) obj;
        if (multiset == null) {
            multiset = HashMultiset.create(this.f17536a.values());
            this.f28777b = new SoftReference(multiset);
        }
        return Collections.unmodifiableSet(multiset.elementSet());
    }

    @Override // p000.AbstractC1218g3, p000.mr1
    /* renamed from: d */
    public final Object mo4904d(Object obj, boolean z) {
        if (!z) {
            return mo4908h(obj);
        }
        return null;
    }

    @Override // p000.AbstractC1218g3, p000.mr1
    /* renamed from: h */
    public final Object mo4908h(Object obj) {
        Object obj2;
        Object mo4908h = super.mo4908h(obj);
        SoftReference softReference = this.f28777b;
        if (softReference == null) {
            obj2 = null;
        } else {
            obj2 = softReference.get();
        }
        Multiset multiset = (Multiset) obj2;
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(mo4908h));
        }
        return mo4908h;
    }

    @Override // p000.AbstractC1218g3, p000.mr1
    /* renamed from: j */
    public final void mo4910j(Object obj, Object obj2) {
        Object obj3;
        super.mo4910j(obj, obj2);
        SoftReference softReference = this.f28777b;
        if (softReference == null) {
            obj3 = null;
        } else {
            obj3 = softReference.get();
        }
        Multiset multiset = (Multiset) obj3;
        if (multiset != null) {
            Preconditions.checkState(multiset.add(obj2));
        }
    }

    @Override // p000.mr1
    /* renamed from: k */
    public final Set mo6050k(Object obj) {
        return new l40(this, this.f17536a, obj, obj, 1);
    }

    @Override // p000.AbstractC1218g3, p000.mr1
    /* renamed from: l */
    public final void mo4911l(Object obj, Object obj2, boolean z) {
        if (!z) {
            mo4910j(obj, obj2);
        }
    }
}
