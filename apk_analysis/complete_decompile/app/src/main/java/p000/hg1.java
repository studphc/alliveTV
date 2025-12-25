package p000;

import com.google.common.collect.ForwardingNavigableSet;
import java.util.Collection;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class hg1 extends ForwardingNavigableSet {

    /* renamed from: a */
    public final /* synthetic */ NavigableSet f18055a;

    public hg1(NavigableSet navigableSet) {
        this.f18055a = navigableSet;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f18055a;
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return new hg1(super.descendingSet());
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return new gg1(super.headSet(obj));
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new gg1(super.subSet(obj, obj2));
    }

    @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new gg1(super.tailSet(obj));
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        return this.f18055a;
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Set delegate() {
        return this.f18055a;
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        return new hg1(super.headSet(obj, z));
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return new hg1(super.subSet(obj, z, obj2, z2));
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        return new hg1(super.tailSet(obj, z));
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final SortedSet delegate() {
        return this.f18055a;
    }

    @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final NavigableSet delegate() {
        return this.f18055a;
    }
}
