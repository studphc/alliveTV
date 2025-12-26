package p000;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: r1 */
/* loaded from: classes.dex */
public final class C1745r1 extends C1493l implements ListIterator {

    /* renamed from: e */
    public final /* synthetic */ C1782s1 f25832e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1745r1(C1782s1 c1782s1) {
        super(c1782s1);
        this.f25832e = c1782s1;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        C1782s1 c1782s1 = this.f25832e;
        boolean isEmpty = c1782s1.isEmpty();
        m7162b().add(obj);
        c1782s1.f26203f.f28032g++;
        if (isEmpty) {
            c1782s1.m6947a();
        }
    }

    /* renamed from: b */
    public final ListIterator m7162b() {
        m5803a();
        return (ListIterator) ((Iterator) this.f22261b);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return m7162b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return m7162b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return m7162b().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return m7162b().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        m7162b().set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1745r1(C1782s1 c1782s1, int i) {
        super(c1782s1, ((List) c1782s1.f25401b).listIterator(i));
        this.f25832e = c1782s1;
    }
}
