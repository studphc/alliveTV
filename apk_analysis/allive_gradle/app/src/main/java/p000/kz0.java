package p000;

import com.google.common.cache.ConcurrentMapC0840e;
import com.google.common.collect.HashBiMap;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class kz0 extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ int f22252a = 1;

    /* renamed from: b */
    public final AbstractMap f22253b;

    public kz0(HashBiMap hashBiMap) {
        this.f22253b = hashBiMap;
    }

    /* renamed from: a */
    public abstract Object mo5027a(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f22252a) {
            case 0:
                ((HashBiMap) this.f22253b).clear();
                return;
            default:
                ((ConcurrentMapC0840e) this.f22253b).clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        switch (this.f22252a) {
            case 1:
                return ((ConcurrentMapC0840e) this.f22253b).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new jz0(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f22252a) {
            case 0:
                return ((HashBiMap) this.f22253b).f14644c;
            default:
                return ((ConcurrentMapC0840e) this.f22253b).size();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        switch (this.f22252a) {
            case 1:
                return ConcurrentMapC0840e.m3821a(this).toArray();
            default:
                return super.toArray();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        switch (this.f22252a) {
            case 1:
                return ConcurrentMapC0840e.m3821a(this).toArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }

    public kz0(ConcurrentMapC0840e concurrentMapC0840e) {
        this.f22253b = concurrentMapC0840e;
    }
}
