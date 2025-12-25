package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class rd0 extends AbstractC1143e2 implements ud0 {

    /* renamed from: f */
    public final Multimap f25933f;

    /* renamed from: g */
    public final Predicate f25934g;

    public rd0(Multimap multimap, Predicate predicate) {
        this.f25933f = (Multimap) Preconditions.checkNotNull(multimap);
        this.f25934g = (Predicate) Preconditions.checkNotNull(predicate);
    }

    /* renamed from: a */
    public Multimap mo6136a() {
        return this.f25933f;
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: b */
    public final Map mo3947b() {
        return Maps.filterKeys(this.f25933f.asMap(), this.f25934g);
    }

    @Override // p000.ud0
    /* renamed from: c */
    public final Predicate mo6137c() {
        return Predicates.compose(this.f25934g, ng1.f23353a);
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        if (this.f25933f.containsKey(obj)) {
            return this.f25934g.apply(obj);
        }
        return false;
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: d */
    public Collection mo3948d() {
        return new qd0(this);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: e */
    public final Set mo3949e() {
        return Sets.filter(this.f25933f.keySet(), this.f25934g);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: f */
    public final Multiset mo3950f() {
        return Multisets.filter(this.f25933f.keys(), this.f25934g);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: g */
    public final Collection mo3951g() {
        return new C0578c2(this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection get(Object obj) {
        boolean apply = this.f25934g.apply(obj);
        Multimap multimap = this.f25933f;
        if (apply) {
            return multimap.get(obj);
        }
        if (multimap instanceof SetMultimap) {
            return new C1669p(obj);
        }
        return new pd0(obj);
    }

    @Override // p000.AbstractC1143e2
    /* renamed from: h */
    public final Iterator mo3952h() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection removeAll(Object obj) {
        boolean containsKey = containsKey(obj);
        Multimap multimap = this.f25933f;
        if (containsKey) {
            return multimap.removeAll(obj);
        }
        if (multimap instanceof SetMultimap) {
            return Collections.emptySet();
        }
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        Iterator it = asMap().values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Collection) it.next()).size();
        }
        return i;
    }
}
