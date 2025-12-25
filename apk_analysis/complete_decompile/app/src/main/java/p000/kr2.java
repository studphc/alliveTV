package p000;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.List;

/* loaded from: classes.dex */
public final class kr2 extends mr2 implements ListMultimap {
    private static final long serialVersionUID = 0;

    @Override // p000.mr2
    /* renamed from: e */
    public final Multimap mo5783e() {
        return (ListMultimap) ((Multimap) this.f25272a);
    }

    @Override // p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List get(Object obj) {
        jr2 m8333C;
        synchronized (this.f25273b) {
            m8333C = yy2.m8333C(((ListMultimap) ((Multimap) this.f25272a)).get((ListMultimap) obj), this.f25273b);
        }
        return m8333C;
    }

    @Override // p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List removeAll(Object obj) {
        List removeAll;
        synchronized (this.f25273b) {
            removeAll = ((ListMultimap) ((Multimap) this.f25272a)).removeAll(obj);
        }
        return removeAll;
    }

    @Override // p000.mr2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List replaceValues(Object obj, Iterable iterable) {
        List replaceValues;
        synchronized (this.f25273b) {
            replaceValues = ((ListMultimap) ((Multimap) this.f25272a)).replaceValues((ListMultimap) obj, iterable);
        }
        return replaceValues;
    }
}
