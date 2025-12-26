package p000;

import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* renamed from: t1 */
/* loaded from: classes.dex */
public final class C1819t1 extends C1893v1 implements NavigableSet {

    /* renamed from: g */
    public final /* synthetic */ AbstractC1930w1 f26655g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1819t1(AbstractC1930w1 abstractC1930w1, Object obj, NavigableSet navigableSet, C1708q1 c1708q1) {
        super(abstractC1930w1, obj, navigableSet, c1708q1);
        this.f26655g = abstractC1930w1;
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return mo7430d().ceiling(obj);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return new C1493l(this, mo7430d().descendingIterator());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return m7432f(mo7430d().descendingSet());
    }

    @Override // p000.C1893v1
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final NavigableSet mo7430d() {
        return (NavigableSet) ((SortedSet) this.f25401b);
    }

    /* renamed from: f */
    public final C1819t1 m7432f(NavigableSet navigableSet) {
        C1708q1 c1708q1 = this.f25402c;
        if (c1708q1 == null) {
            c1708q1 = this;
        }
        return new C1819t1(this.f26655g, this.f25400a, navigableSet, c1708q1);
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return mo7430d().floor(obj);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        return m7432f(mo7430d().headSet(obj, z));
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return mo7430d().higher(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return mo7430d().lower(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return Iterators.m4035c(iterator());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return Iterators.m4035c(descendingIterator());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return m7432f(mo7430d().subSet(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        return m7432f(mo7430d().tailSet(obj, z));
    }
}
