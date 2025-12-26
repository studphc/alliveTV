package p000;

import java.util.Comparator;
import java.util.SortedSet;

/* renamed from: v1 */
/* loaded from: classes.dex */
public class C1893v1 extends C1708q1 implements SortedSet {

    /* renamed from: f */
    public final /* synthetic */ AbstractC1930w1 f27615f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1893v1(AbstractC1930w1 abstractC1930w1, Object obj, SortedSet sortedSet, C1708q1 c1708q1) {
        super(abstractC1930w1, obj, sortedSet, c1708q1);
        this.f27615f = abstractC1930w1;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return mo7430d().comparator();
    }

    /* renamed from: d */
    public SortedSet mo7430d() {
        return (SortedSet) this.f25401b;
    }

    @Override // java.util.SortedSet
    public final Object first() {
        m6948b();
        return mo7430d().first();
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        m6948b();
        SortedSet headSet = mo7430d().headSet(obj);
        C1708q1 c1708q1 = this.f25402c;
        if (c1708q1 == null) {
            c1708q1 = this;
        }
        return new C1893v1(this.f27615f, this.f25400a, headSet, c1708q1);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        m6948b();
        return mo7430d().last();
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        m6948b();
        SortedSet subSet = mo7430d().subSet(obj, obj2);
        C1708q1 c1708q1 = this.f25402c;
        if (c1708q1 == null) {
            c1708q1 = this;
        }
        return new C1893v1(this.f27615f, this.f25400a, subSet, c1708q1);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        m6948b();
        SortedSet tailSet = mo7430d().tailSet(obj);
        C1708q1 c1708q1 = this.f25402c;
        if (c1708q1 == null) {
            c1708q1 = this;
        }
        return new C1893v1(this.f27615f, this.f25400a, tailSet, c1708q1);
    }
}
