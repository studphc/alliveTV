package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

/* renamed from: com.google.common.collect.f */
/* loaded from: classes.dex */
public abstract class AbstractC0866f extends AbstractC0856d implements SortedMultiset {

    /* renamed from: c */
    public final Comparator f14814c;

    /* renamed from: d */
    public transient C0861e f14815d;

    public AbstractC0866f() {
        this(Ordering.natural());
    }

    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: a */
    public final Set mo3837a() {
        return new AbstractC0952x2(this);
    }

    public SortedMultiset descendingMultiset() {
        C0861e c0861e = this.f14815d;
        if (c0861e == null) {
            C0861e c0861e2 = new C0861e(this);
            this.f14815d = c0861e2;
            return c0861e2;
        }
        return c0861e;
    }

    public Multiset.Entry firstEntry() {
        C0905m3 c0905m3 = new C0905m3((TreeMultiset) this);
        if (c0905m3.hasNext()) {
            return (Multiset.Entry) c0905m3.next();
        }
        return null;
    }

    public Multiset.Entry lastEntry() {
        C0910n3 c0910n3 = new C0910n3((TreeMultiset) this);
        if (c0910n3.hasNext()) {
            return (Multiset.Entry) c0910n3.next();
        }
        return null;
    }

    public Multiset.Entry pollFirstEntry() {
        C0905m3 c0905m3 = new C0905m3((TreeMultiset) this);
        if (c0905m3.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) c0905m3.next();
            Multiset.Entry immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
            c0905m3.remove();
            return immutableEntry;
        }
        return null;
    }

    public Multiset.Entry pollLastEntry() {
        C0910n3 c0910n3 = new C0910n3((TreeMultiset) this);
        if (c0910n3.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) c0910n3.next();
            Multiset.Entry immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
            c0910n3.remove();
            return immutableEntry;
        }
        return null;
    }

    public SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return tailMultiset(obj, boundType).headMultiset(obj2, boundType2);
    }

    public AbstractC0866f(Comparator comparator) {
        this.f14814c = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.google.common.collect.AbstractC0856d, com.google.common.collect.Multiset
    public NavigableSet elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
