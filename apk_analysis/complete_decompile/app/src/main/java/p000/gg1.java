package p000;

import com.google.common.collect.ForwardingSortedSet;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class gg1 extends ForwardingSortedSet {

    /* renamed from: a */
    public final /* synthetic */ SortedSet f17688a;

    public gg1(SortedSet sortedSet) {
        this.f17688a = sortedSet;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f17688a;
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

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        return this.f17688a;
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Set delegate() {
        return this.f17688a;
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final SortedSet delegate() {
        return this.f17688a;
    }
}
