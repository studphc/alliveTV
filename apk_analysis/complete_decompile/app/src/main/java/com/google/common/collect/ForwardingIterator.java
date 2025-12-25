package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
    @Override // com.google.common.collect.ForwardingObject
    public abstract Iterator<T> delegate();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return delegate().hasNext();
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public T next() {
        return delegate().next();
    }

    @Override // java.util.Iterator
    public void remove() {
        delegate().remove();
    }
}
