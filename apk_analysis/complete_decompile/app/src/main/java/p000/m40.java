package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class m40 extends AbstractC2039z {

    /* renamed from: d */
    public transient SoftReference f22786d;

    /* renamed from: e */
    public transient SoftReference f22787e;

    /* renamed from: m */
    public static Object m6049m(SoftReference softReference) {
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    @Override // p000.mr1
    /* renamed from: b */
    public final Set mo4902b() {
        Multiset multiset = (Multiset) m6049m(this.f22787e);
        if (multiset == null) {
            multiset = HashMultiset.create(this.f29204b.values());
            this.f22787e = new SoftReference(multiset);
        }
        return Collections.unmodifiableSet(multiset.elementSet());
    }

    @Override // p000.mr1
    /* renamed from: c */
    public final Set mo4903c() {
        Multiset multiset = (Multiset) m6049m(this.f22786d);
        if (multiset == null) {
            multiset = HashMultiset.create(this.f29203a.values());
            this.f22786d = new SoftReference(multiset);
        }
        return Collections.unmodifiableSet(multiset.elementSet());
    }

    @Override // p000.AbstractC2039z, p000.mr1
    /* renamed from: d */
    public final Object mo4904d(Object obj, boolean z) {
        Object mo4904d = super.mo4904d(obj, z);
        Multiset multiset = (Multiset) m6049m(this.f22786d);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(mo4904d));
        }
        return mo4904d;
    }

    @Override // p000.AbstractC2039z, p000.mr1
    /* renamed from: h */
    public final Object mo4908h(Object obj) {
        Object mo4908h = super.mo4908h(obj);
        Multiset multiset = (Multiset) m6049m(this.f22787e);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(mo4908h));
        }
        return mo4908h;
    }

    @Override // p000.AbstractC2039z, p000.mr1
    /* renamed from: j */
    public final void mo4910j(Object obj, Object obj2) {
        super.mo4910j(obj, obj2);
        Multiset multiset = (Multiset) m6049m(this.f22787e);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(obj2));
        }
    }

    @Override // p000.mr1
    /* renamed from: k */
    public final Set mo6050k(Object obj) {
        return new l40(this, this.f29204b, obj, obj, 0);
    }

    @Override // p000.AbstractC2039z, p000.mr1
    /* renamed from: l */
    public final void mo4911l(Object obj, Object obj2, boolean z) {
        super.mo4911l(obj, obj2, z);
        Multiset multiset = (Multiset) m6049m(this.f22786d);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(obj2));
        }
    }
}
