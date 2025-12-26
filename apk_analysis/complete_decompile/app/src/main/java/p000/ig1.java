package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.C0855c3;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ig1 extends ih1 {

    /* renamed from: d */
    public final /* synthetic */ int f18403d = 1;

    /* renamed from: e */
    public final Object f18404e;

    /* renamed from: f */
    public final Object f18405f;

    public ig1(C0855c3 c0855c3, Object obj) {
        this.f18405f = c0855c3;
        this.f18404e = Preconditions.checkNotNull(obj);
    }

    @Override // p000.ih1
    /* renamed from: a */
    public final Set mo4593a() {
        switch (this.f18403d) {
            case 0:
                return new C1290i1(this, 2);
            default:
                return new v81(1, this);
        }
    }

    @Override // p000.ih1
    /* renamed from: c */
    public final Set mo5238c() {
        switch (this.f18403d) {
            case 0:
                return new C1811su(mo2233f(), 1);
            default:
                return new C1375k1(this, 3);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        switch (this.f18403d) {
            case 0:
                mo2233f().clear();
                return;
            default:
                super.clear();
                return;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        switch (this.f18403d) {
            case 0:
                return mo2233f().contains(obj);
            default:
                return ((C0855c3) this.f18405f).contains(obj, this.f18404e);
        }
    }

    @Override // p000.ih1
    /* renamed from: e */
    public final Collection mo4594e() {
        switch (this.f18403d) {
            case 0:
                return Collections2.transform((Set) this.f18404e, (Function) this.f18405f);
            default:
                return new jd0(this, 1);
        }
    }

    /* renamed from: f */
    public Set mo2233f() {
        return (Set) this.f18404e;
    }

    /* renamed from: g */
    public boolean m5239g(Predicate predicate) {
        Iterator it = ((C0855c3) this.f18405f).f14788c.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map map = (Map) entry.getValue();
            Object obj = this.f18404e;
            Object obj2 = map.get(obj);
            if (obj2 != null && predicate.apply(Maps.immutableEntry(entry.getKey(), obj2))) {
                map.remove(obj);
                if (map.isEmpty()) {
                    it.remove();
                }
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        switch (this.f18403d) {
            case 0:
                if (Collections2.m3836c(mo2233f(), obj)) {
                    return ((Function) this.f18405f).apply(obj);
                }
                return null;
            default:
                return ((C0855c3) this.f18405f).get(obj, this.f18404e);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        switch (this.f18403d) {
            case 1:
                return ((C0855c3) this.f18405f).put(obj, this.f18404e, obj2);
            default:
                return super.put(obj, obj2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        switch (this.f18403d) {
            case 0:
                if (mo2233f().remove(obj)) {
                    return ((Function) this.f18405f).apply(obj);
                }
                return null;
            default:
                return ((C0855c3) this.f18405f).remove(obj, this.f18404e);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        switch (this.f18403d) {
            case 0:
                return mo2233f().size();
            default:
                return super.size();
        }
    }

    public ig1(Set set, Function function) {
        this.f18404e = (Set) Preconditions.checkNotNull(set);
        this.f18405f = (Function) Preconditions.checkNotNull(function);
    }
}
