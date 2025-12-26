package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: a */
    public int f14609a = 2;

    /* renamed from: b */
    public Object f14610b;

    @CheckForNull
    public abstract T computeNext();

    @CanIgnoreReturnValue
    @CheckForNull
    public final T endOfData() {
        this.f14609a = 3;
        return null;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        boolean z;
        if (this.f14609a != 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        int m7041F = AbstractC1726qj.m7041F(this.f14609a);
        if (m7041F == 0) {
            return true;
        }
        if (m7041F == 2) {
            return false;
        }
        this.f14609a = 4;
        this.f14610b = computeNext();
        if (this.f14609a == 3) {
            return false;
        }
        this.f14609a = 1;
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (hasNext()) {
            this.f14609a = 2;
            T t = (T) this.f14610b;
            this.f14610b = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final T peek() {
        if (hasNext()) {
            return (T) this.f14610b;
        }
        throw new NoSuchElementException();
    }
}
