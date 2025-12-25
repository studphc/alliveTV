package p000;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class dq1 extends eq1 implements ListMultimap {
    private static final long serialVersionUID = 0;

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
    public final Multimap delegate() {
        return (ListMultimap) this.f16945a;
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Collection replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return (ListMultimap) this.f16945a;
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List get(Object obj) {
        return Collections.unmodifiableList(((ListMultimap) this.f16945a).get((ListMultimap) obj));
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final List replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }
}
