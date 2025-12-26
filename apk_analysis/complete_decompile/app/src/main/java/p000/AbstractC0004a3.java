package p000;

import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/* renamed from: a3 */
/* loaded from: classes.dex */
public abstract class AbstractC0004a3 extends AbstractC1930w1 implements SetMultimap {
    private static final long serialVersionUID = 7431625294878419160L;

    @Override // p000.AbstractC1930w1
    /* renamed from: o */
    public Collection mo4o(Collection collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: q */
    public Collection mo5q(Collection collection, Object obj) {
        return new C1856u1(this, obj, (Set) collection);
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Set mo3m() {
        return Collections.emptySet();
    }

    @Override // p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set entries() {
        return (Set) super.entries();
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set get(Object obj) {
        return (Set) super.get(obj);
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Set replaceValues(Object obj, Iterable iterable) {
        return (Set) super.replaceValues(obj, iterable);
    }
}
