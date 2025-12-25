package p000;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* renamed from: s1 */
/* loaded from: classes.dex */
public class C1782s1 extends C1708q1 implements List {

    /* renamed from: f */
    public final /* synthetic */ AbstractC1930w1 f26203f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1782s1(AbstractC1930w1 abstractC1930w1, Object obj, List list, C1708q1 c1708q1) {
        super(abstractC1930w1, obj, list, c1708q1);
        this.f26203f = abstractC1930w1;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        m6948b();
        boolean isEmpty = this.f25401b.isEmpty();
        ((List) this.f25401b).add(i, obj);
        this.f26203f.f28032g++;
        if (isEmpty) {
            m6947a();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.f25401b).addAll(i, collection);
        if (addAll) {
            this.f26203f.f28032g += this.f25401b.size() - size;
            if (size == 0) {
                m6947a();
            }
        }
        return addAll;
    }

    @Override // java.util.List
    public final Object get(int i) {
        m6948b();
        return ((List) this.f25401b).get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        m6948b();
        return ((List) this.f25401b).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        m6948b();
        return ((List) this.f25401b).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        m6948b();
        return new C1745r1(this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        m6948b();
        Object remove = ((List) this.f25401b).remove(i);
        AbstractC1930w1 abstractC1930w1 = this.f26203f;
        abstractC1930w1.f28032g--;
        m6949c();
        return remove;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        m6948b();
        return ((List) this.f25401b).set(i, obj);
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        m6948b();
        List subList = ((List) this.f25401b).subList(i, i2);
        C1708q1 c1708q1 = this.f25402c;
        if (c1708q1 == null) {
            c1708q1 = this;
        }
        return this.f26203f.m7964r(this.f25400a, subList, c1708q1);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        m6948b();
        return new C1745r1(this, i);
    }
}
