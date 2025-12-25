package p000;

import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: b3 */
/* loaded from: classes.dex */
public abstract class AbstractC0543b3 extends AbstractC0004a3 implements SortedSetMultimap {
    private static final long serialVersionUID = 430848587173315748L;

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1
    /* renamed from: m */
    public final Collection mo3m() {
        SortedSet mo2006i = mo2006i();
        if (mo2006i instanceof NavigableSet) {
            return Sets.unmodifiableNavigableSet((NavigableSet) mo2006i);
        }
        return Collections.unmodifiableSortedSet(mo2006i);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1
    /* renamed from: o */
    public final Collection mo4o(Collection collection) {
        if (collection instanceof NavigableSet) {
            return Sets.unmodifiableNavigableSet((NavigableSet) collection);
        }
        return Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1
    /* renamed from: q */
    public final Collection mo5q(Collection collection, Object obj) {
        if (collection instanceof NavigableSet) {
            return new C1819t1(this, obj, (NavigableSet) collection, null);
        }
        return new C1893v1(this, obj, (SortedSet) collection, null);
    }

    @Override // p000.AbstractC0004a3
    /* renamed from: s */
    public final Set mo3m() {
        SortedSet mo2006i = mo2006i();
        if (mo2006i instanceof NavigableSet) {
            return Sets.unmodifiableNavigableSet((NavigableSet) mo2006i);
        }
        return Collections.unmodifiableSortedSet(mo2006i);
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public abstract SortedSet mo2006i();

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public SortedSet get(Object obj) {
        return (SortedSet) super.get(obj);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public SortedSet removeAll(Object obj) {
        return (SortedSet) super.removeAll(obj);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1, p000.AbstractC1143e2, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public SortedSet replaceValues(Object obj, Iterable iterable) {
        return (SortedSet) super.replaceValues(obj, iterable);
    }
}
