package p000;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class od0 extends rd0 implements ListMultimap {
    @Override // p000.rd0, p000.ud0
    /* renamed from: a */
    public final Multimap mo6136a() {
        return (ListMultimap) this.f25933f;
    }

    @Override // p000.rd0, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection get(Object obj) {
        return (List) super.get(obj);
    }

    @Override // p000.rd0, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection replaceValues(Object obj, Iterable iterable) {
        return (List) super.replaceValues(obj, iterable);
    }

    @Override // p000.rd0, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List get(Object obj) {
        return (List) super.get(obj);
    }

    @Override // p000.rd0, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List replaceValues(Object obj, Iterable iterable) {
        return (List) super.replaceValues(obj, iterable);
    }
}
