package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class qh2 extends ForwardingSortedSet implements NavigableSet, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final NavigableSet f25590a;

    /* renamed from: b */
    public final SortedSet f25591b;

    /* renamed from: c */
    public transient qh2 f25592c;

    public qh2(NavigableSet navigableSet) {
        this.f25590a = (NavigableSet) Preconditions.checkNotNull(navigableSet);
        this.f25591b = Collections.unmodifiableSortedSet(navigableSet);
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return this.f25590a.ceiling(obj);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f25591b;
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return Iterators.unmodifiableIterator(this.f25590a.descendingIterator());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        qh2 qh2Var = this.f25592c;
        if (qh2Var == null) {
            qh2 qh2Var2 = new qh2(this.f25590a.descendingSet());
            this.f25592c = qh2Var2;
            qh2Var2.f25592c = this;
            return qh2Var2;
        }
        return qh2Var;
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return this.f25590a.floor(obj);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        return Sets.unmodifiableNavigableSet(this.f25590a.headSet(obj, z));
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return this.f25590a.higher(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return this.f25590a.lower(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return Sets.unmodifiableNavigableSet(this.f25590a.subSet(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        return Sets.unmodifiableNavigableSet(this.f25590a.tailSet(obj, z));
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        return this.f25591b;
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Set delegate() {
        return this.f25591b;
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final SortedSet delegate() {
        return this.f25591b;
    }
}
