package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class pd0 extends ForwardingList {

    /* renamed from: a */
    public final Object f25126a;

    public pd0(Object obj) {
        this.f25126a = obj;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        add(0, obj);
        throw null;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        addAll(0, collection);
        throw null;
    }

    @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.ForwardingList, java.util.List
    public final void add(int i, Object obj) {
        Preconditions.checkPositionIndex(i, 0);
        String valueOf = String.valueOf(this.f25126a);
        throw new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf.length() + 32, "Key does not satisfy predicate: ", valueOf));
    }

    @Override // com.google.common.collect.ForwardingList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkPositionIndex(i, 0);
        String valueOf = String.valueOf(this.f25126a);
        throw new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf.length() + 32, "Key does not satisfy predicate: ", valueOf));
    }

    @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final List delegate() {
        return Collections.emptyList();
    }
}
