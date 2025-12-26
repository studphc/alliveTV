package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.LinkedHashMultimap;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/* renamed from: l */
/* loaded from: classes.dex */
public class C1493l implements Iterator {

    /* renamed from: a */
    public final /* synthetic */ int f22260a;

    /* renamed from: b */
    public Object f22261b;

    /* renamed from: c */
    public Object f22262c;

    /* renamed from: d */
    public final /* synthetic */ Object f22263d;

    public /* synthetic */ C1493l(Object obj, Iterator it, int i) {
        this.f22260a = i;
        this.f22263d = obj;
        this.f22261b = it;
    }

    /* renamed from: a */
    public void m5803a() {
        C1708q1 c1708q1 = (C1708q1) this.f22263d;
        c1708q1.m6948b();
        if (c1708q1.f25401b == ((Collection) this.f22262c)) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f22260a) {
            case 0:
                return ((Iterator) this.f22261b).hasNext();
            case 1:
                return ((Iterator) this.f22261b).hasNext();
            case 2:
                return ((Iterator) this.f22261b).hasNext();
            case 3:
                m5803a();
                return ((Iterator) this.f22261b).hasNext();
            default:
                if (((p81) this.f22262c) != ((LinkedHashMultimap) this.f22263d).f14724i) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f22260a) {
            case 0:
                Map.Entry entry = (Map.Entry) ((Iterator) this.f22261b).next();
                this.f22262c = entry;
                return new C1530m((AbstractC1706q) this.f22263d, entry);
            case 1:
                Map.Entry entry2 = (Map.Entry) ((Iterator) this.f22261b).next();
                this.f22262c = (Collection) entry2.getValue();
                return ((C1338j1) this.f22263d).m5383f(entry2);
            case 2:
                Map.Entry entry3 = (Map.Entry) ((Iterator) this.f22261b).next();
                this.f22262c = entry3;
                return entry3.getKey();
            case 3:
                m5803a();
                return ((Iterator) this.f22261b).next();
            default:
                if (hasNext()) {
                    p81 p81Var = (p81) this.f22262c;
                    this.f22261b = p81Var;
                    p81 p81Var2 = p81Var.f25066h;
                    Objects.requireNonNull(p81Var2);
                    this.f22262c = p81Var2;
                    return p81Var;
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        boolean z2;
        boolean z3;
        switch (this.f22260a) {
            case 0:
                Map.Entry entry = (Map.Entry) this.f22262c;
                if (entry != null) {
                    Object value = entry.getValue();
                    ((Iterator) this.f22261b).remove();
                    ((AbstractC1706q) this.f22263d).f25353b.f25352a.remove(value);
                    this.f22262c = null;
                    return;
                }
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            case 1:
                if (((Collection) this.f22262c) != null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z, "no calls to next() since the last call to remove()");
                ((Iterator) this.f22261b).remove();
                ((C1338j1) this.f22263d).f20337e.f28032g -= ((Collection) this.f22262c).size();
                ((Collection) this.f22262c).clear();
                this.f22262c = null;
                return;
            case 2:
                if (((Map.Entry) this.f22262c) != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkState(z2, "no calls to next() since the last call to remove()");
                Collection collection = (Collection) ((Map.Entry) this.f22262c).getValue();
                ((Iterator) this.f22261b).remove();
                ((AbstractC1930w1) ((C1375k1) this.f22263d).f20714c).f28032g -= collection.size();
                collection.clear();
                this.f22262c = null;
                return;
            case 3:
                ((Iterator) this.f22261b).remove();
                C1708q1 c1708q1 = (C1708q1) this.f22263d;
                AbstractC1930w1 abstractC1930w1 = c1708q1.f25404e;
                abstractC1930w1.f28032g--;
                c1708q1.m6949c();
                return;
            default:
                if (((p81) this.f22261b) != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
                p81 p81Var = (p81) this.f22261b;
                ((LinkedHashMultimap) this.f22263d).remove(p81Var.f20725a, p81Var.f20726b);
                this.f22261b = null;
                return;
        }
    }

    public C1493l(C1708q1 c1708q1) {
        Object it;
        this.f22260a = 3;
        this.f22263d = c1708q1;
        Collection collection = c1708q1.f25401b;
        this.f22262c = collection;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.f22261b = it;
    }

    public C1493l(C1708q1 c1708q1, Iterator it) {
        this.f22260a = 3;
        this.f22263d = c1708q1;
        this.f22262c = c1708q1.f25401b;
        this.f22261b = it;
    }

    public C1493l(LinkedHashMultimap linkedHashMultimap) {
        this.f22260a = 4;
        this.f22263d = linkedHashMultimap;
        p81 p81Var = linkedHashMultimap.f14724i.f25066h;
        Objects.requireNonNull(p81Var);
        this.f22262c = p81Var;
    }

    public C1493l(C1338j1 c1338j1) {
        this.f22260a = 1;
        this.f22263d = c1338j1;
        this.f22261b = c1338j1.f20336d.entrySet().iterator();
    }
}
