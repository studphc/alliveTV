package p000;

import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public final class nd0 extends md0 implements vd0 {
    @Override // p000.md0, p000.ud0
    /* renamed from: a */
    public final Multimap mo6136a() {
        return (SetMultimap) this.f22895f;
    }

    @Override // p000.md0, p000.AbstractC1143e2
    /* renamed from: d */
    public final Collection mo3948d() {
        return Sets.filter(((SetMultimap) this.f22895f).entries(), this.f22896g);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection entries() {
        return (Set) super.entries();
    }

    @Override // p000.md0, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection get(Object obj) {
        return (Set) super.get(obj);
    }

    @Override // p000.md0, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection replaceValues(Object obj, Iterable iterable) {
        return (Set) super.replaceValues(obj, iterable);
    }

    @Override // p000.md0, p000.ud0
    /* renamed from: a */
    public final SetMultimap mo6136a() {
        return (SetMultimap) this.f22895f;
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set entries() {
        return (Set) super.entries();
    }

    @Override // p000.md0, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set get(Object obj) {
        return (Set) super.get(obj);
    }

    @Override // p000.md0, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set replaceValues(Object obj, Iterable iterable) {
        return (Set) super.replaceValues(obj, iterable);
    }
}
