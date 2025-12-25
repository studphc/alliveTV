package p000;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.C0945w;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class md0 extends AbstractC1143e2 implements ud0 {

    /* renamed from: f */
    public final Multimap f22895f;

    /* renamed from: g */
    public final Predicate f22896g;

    public md0(Multimap multimap, Predicate predicate) {
        this.f22895f = (Multimap) Preconditions.checkNotNull(multimap);
        this.f22896g = (Predicate) Preconditions.checkNotNull(predicate);
    }

    /* renamed from: i */
    public static Collection m6135i(Collection collection, Predicate predicate) {
        if (collection instanceof Set) {
            return Sets.filter((Set) collection, predicate);
        }
        return Collections2.filter(collection, predicate);
    }

    @Override // p000.ud0
    /* renamed from: a */
    public Multimap mo6136a() {
        return this.f22895f;
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: b */
    public final Map mo3947b() {
        return new kd0(this);
    }

    @Override // p000.ud0
    /* renamed from: c */
    public final Predicate mo6137c() {
        return this.f22896g;
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        entries().clear();
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        if (asMap().get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: d */
    public Collection mo3948d() {
        return m6135i(this.f22895f.entries(), this.f22896g);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: e */
    public final Set mo3949e() {
        return asMap().keySet();
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: f */
    public final Multiset mo3950f() {
        return new C0945w(this);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: g */
    public final Collection mo3951g() {
        return new C0578c2(this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection get(Object obj) {
        return m6135i(this.f22895f.get(obj), new ld0(this, obj));
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: h */
    public final Iterator mo3952h() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: j */
    public final boolean m6138j(Predicate predicate) {
        Iterator it = this.f22895f.asMap().entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Collection m6135i = m6135i((Collection) entry.getValue(), new ld0(this, key));
            if (!m6135i.isEmpty() && predicate.apply(Maps.immutableEntry(key, m6135i))) {
                if (m6135i.size() == ((Collection) entry.getValue()).size()) {
                    it.remove();
                } else {
                    m6135i.clear();
                }
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection removeAll(Object obj) {
        Object emptyList;
        Collection collection = (Collection) asMap().remove(obj);
        if (this.f22895f instanceof SetMultimap) {
            emptyList = Collections.emptySet();
        } else {
            emptyList = Collections.emptyList();
        }
        return (Collection) MoreObjects.firstNonNull(collection, emptyList);
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        return entries().size();
    }
}
