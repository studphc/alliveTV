package p000;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class ih1 extends AbstractMap {

    /* renamed from: a */
    public transient Set f18411a;

    /* renamed from: b */
    public transient Set f18412b;

    /* renamed from: c */
    public transient Collection f18413c;

    /* renamed from: a */
    public abstract Set mo4593a();

    /* renamed from: c */
    public Set mo5238c() {
        return new zg1(this);
    }

    /* renamed from: e */
    public Collection mo4594e() {
        return new hh1(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f18411a;
        if (set == null) {
            Set mo4593a = mo4593a();
            this.f18411a = mo4593a;
            return mo4593a;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set keySet() {
        Set set = this.f18412b;
        if (set == null) {
            Set mo5238c = mo5238c();
            this.f18412b = mo5238c;
            return mo5238c;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.f18413c;
        if (collection == null) {
            Collection mo4594e = mo4594e();
            this.f18413c = mo4594e;
            return mo4594e;
        }
        return collection;
    }
}
