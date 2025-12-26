package p000;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;

/* loaded from: classes.dex */
public final class lh2 extends nh2 implements NavigableSet {
    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return Iterables.find(((NavigableSet) this.f29458a).tailSet(obj, true), this.f29459b, null);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return Iterators.filter(((NavigableSet) this.f29458a).descendingIterator(), this.f29459b);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return Sets.filter(((NavigableSet) this.f29458a).descendingSet(), this.f29459b);
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return Iterators.find(((NavigableSet) this.f29458a).headSet(obj, true).descendingIterator(), this.f29459b, null);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        return Sets.filter(((NavigableSet) this.f29458a).headSet(obj, z), this.f29459b);
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return Iterables.find(((NavigableSet) this.f29458a).tailSet(obj, false), this.f29459b, null);
    }

    @Override // p000.nh2, java.util.SortedSet
    public final Object last() {
        return Iterators.find(((NavigableSet) this.f29458a).descendingIterator(), this.f29459b);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return Iterators.find(((NavigableSet) this.f29458a).headSet(obj, false).descendingIterator(), this.f29459b, null);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return Iterables.m4031a((NavigableSet) this.f29458a, this.f29459b);
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return Iterables.m4031a(((NavigableSet) this.f29458a).descendingSet(), this.f29459b);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return Sets.filter(((NavigableSet) this.f29458a).subSet(obj, z, obj2, z2), this.f29459b);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        return Sets.filter(((NavigableSet) this.f29458a).tailSet(obj, z), this.f29459b);
    }
}
