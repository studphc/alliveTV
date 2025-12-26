package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@Beta
@GwtCompatible
/* loaded from: classes.dex */
public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final ArrayDeque f14635a;

    /* renamed from: b */
    public final int f14636b;

    public EvictingQueue(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "maxSize (%s) must >= 0", i);
        this.f14635a = new ArrayDeque(i);
        this.f14636b = i;
    }

    public static <E> EvictingQueue<E> create(int i) {
        return new EvictingQueue<>(i);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e) {
        Preconditions.checkNotNull(e);
        int i = this.f14636b;
        if (i == 0) {
            return true;
        }
        int size = size();
        ArrayDeque arrayDeque = this.f14635a;
        if (size == i) {
            arrayDeque.remove();
        }
        arrayDeque.add(e);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        int i = this.f14636b;
        if (size >= i) {
            clear();
            return Iterables.addAll(this, Iterables.skip(collection, size - i));
        }
        return standardAddAll(collection);
    }

    @Override // com.google.common.collect.ForwardingQueue, java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e) {
        return add(e);
    }

    public int remainingCapacity() {
        return this.f14636b - size();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray() {
        return super.toArray();
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Queue<E> delegate() {
        return this.f14635a;
    }
}
