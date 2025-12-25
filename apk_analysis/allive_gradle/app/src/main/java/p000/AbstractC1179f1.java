package p000;

import com.google.common.collect.ListMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: f1 */
/* loaded from: classes.dex */
public abstract class AbstractC1179f1 extends AbstractC1930w1 implements ListMultimap {
    private static final long serialVersionUID = 6588350623831699109L;

    @Override // p000.AbstractC1930w1
    /* renamed from: m */
    public final Collection mo3m() {
        return Collections.emptyList();
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: o */
    public final Collection mo4o(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: q */
    public final Collection mo5q(Collection collection, Object obj) {
        return m7964r(obj, (List) collection, null);
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public List get(Object obj) {
        return (List) super.get(obj);
    }

    @Override // p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public List removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public List replaceValues(Object obj, Iterable iterable) {
        return (List) super.replaceValues(obj, iterable);
    }
}
