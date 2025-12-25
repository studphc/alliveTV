package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: a */
    public Object f14611a;

    public AbstractSequentialIterator(@CheckForNull T t) {
        this.f14611a = t;
    }

    @CheckForNull
    public abstract T computeNext(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f14611a != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t = (T) this.f14611a;
        if (t != null) {
            this.f14611a = computeNext(t);
            return t;
        }
        throw new NoSuchElementException();
    }
}
