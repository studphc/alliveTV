package p000;

import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public class fq1 extends eq1 implements SetMultimap {
    private static final long serialVersionUID = 0;

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Collection removeAll(Object obj) {
        removeAll(obj);
        throw null;
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        replaceValues(obj, iterable);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set, qd0] */
    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public final Set entries() {
        return new qd0(Collections.unmodifiableSet(delegate().entries()));
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set get(Object obj) {
        return Collections.unmodifiableSet(delegate().get((SetMultimap) obj));
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.eq1, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
    public SetMultimap delegate() {
        return (SetMultimap) this.f16945a;
    }
}
