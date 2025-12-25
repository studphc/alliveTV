package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class kd0 extends ih1 {

    /* renamed from: d */
    public final /* synthetic */ int f20823d = 1;

    /* renamed from: e */
    public final Multimap f20824e;

    public kd0(md0 md0Var) {
        this.f20824e = md0Var;
    }

    @Override // p000.ih1
    /* renamed from: a */
    public final Set mo4593a() {
        switch (this.f20823d) {
            case 0:
                return new C1290i1(this, 1);
            default:
                return new C1290i1(this, 5);
        }
    }

    @Override // p000.ih1
    /* renamed from: c */
    public Set mo5238c() {
        switch (this.f20823d) {
            case 0:
                return new C1375k1(this, 1);
            default:
                return super.mo5238c();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        switch (this.f20823d) {
            case 0:
                ((md0) this.f20824e).clear();
                return;
            default:
                this.f20824e.clear();
                return;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        switch (this.f20823d) {
            case 0:
                if (m5520f(obj) != null) {
                    return true;
                }
                return false;
            default:
                return this.f20824e.containsKey(obj);
        }
    }

    @Override // p000.ih1
    /* renamed from: e */
    public Collection mo4594e() {
        switch (this.f20823d) {
            case 0:
                return new jd0(this, 0);
            default:
                return super.mo4594e();
        }
    }

    /* renamed from: f */
    public Collection m5520f(Object obj) {
        md0 md0Var = (md0) this.f20824e;
        Collection collection = (Collection) md0Var.f22895f.asMap().get(obj);
        if (collection == null) {
            return null;
        }
        Collection m6135i = md0.m6135i(collection, new ld0(md0Var, obj));
        if (m6135i.isEmpty()) {
            return null;
        }
        return m6135i;
    }

    /* renamed from: g */
    public Collection m5521g(Object obj) {
        md0 md0Var = (md0) this.f20824e;
        Collection collection = (Collection) md0Var.f22895f.asMap().get(obj);
        if (collection == null) {
            return null;
        }
        ArrayList newArrayList = Lists.newArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (md0Var.f22896g.apply(Maps.immutableEntry(obj, next))) {
                it.remove();
                newArrayList.add(next);
            }
        }
        if (newArrayList.isEmpty()) {
            return null;
        }
        if (md0Var.f22895f instanceof SetMultimap) {
            return Collections.unmodifiableSet(Sets.newLinkedHashSet(newArrayList));
        }
        return Collections.unmodifiableList(newArrayList);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        switch (this.f20823d) {
            case 0:
                return m5520f(obj);
            default:
                Multimap multimap = this.f20824e;
                if (multimap.containsKey(obj)) {
                    return multimap.get(obj);
                }
                return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        switch (this.f20823d) {
            case 1:
                return this.f20824e.isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // p000.ih1, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set keySet() {
        switch (this.f20823d) {
            case 1:
                return this.f20824e.keySet();
            default:
                return super.keySet();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        switch (this.f20823d) {
            case 0:
                return m5521g(obj);
            default:
                Multimap multimap = this.f20824e;
                if (multimap.containsKey(obj)) {
                    return multimap.removeAll(obj);
                }
                return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        switch (this.f20823d) {
            case 1:
                return this.f20824e.keySet().size();
            default:
                return super.size();
        }
    }

    public kd0(AbstractC1143e2 abstractC1143e2) {
        this.f20824e = (Multimap) Preconditions.checkNotNull(abstractC1143e2);
    }
}
