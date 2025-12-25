package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;
import p000.iq1;
import p000.p63;
import p000.rv2;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    @Beta
    /* loaded from: classes.dex */
    public class StandardElementSet extends iq1 {
        public StandardElementSet() {
        }

        @Override // p000.iq1
        /* renamed from: d */
        public final Multiset mo3860d() {
            return ForwardingMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new rv2(ForwardingMultiset.this.entrySet().iterator());
        }
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e, int i) {
        return delegate().add(e, i);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        return delegate().count(obj);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Multiset<E> delegate();

    @Override // com.google.common.collect.Multiset
    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    @Override // com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@CheckForNull Object obj) {
        if (obj != this && !delegate().equals(obj)) {
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i) {
        return delegate().remove(obj, i);
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        return delegate().setCount(e, i);
    }

    public boolean standardAdd(E e) {
        add(e, 1);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.m4060a(this, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public void standardClear() {
        Iterators.m4034b(entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardContains(@CheckForNull Object obj) {
        if (count(obj) > 0) {
            return true;
        }
        return false;
    }

    @Beta
    public int standardCount(@CheckForNull Object obj) {
        for (Multiset.Entry<E> entry : entrySet()) {
            if (Objects.equal(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(@CheckForNull Object obj) {
        return Multisets.m4061b(this, obj);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return Multisets.m4062c(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemove(@CheckForNull Object obj) {
        if (remove(obj, 1) > 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemoveAll(Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return elementSet().removeAll(collection);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRetainAll(Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return elementSet().retainAll(collection);
    }

    public boolean standardSetCount(E e, int i, int i2) {
        return Multisets.m4064e(this, e, i, i2);
    }

    public int standardSize() {
        return Multisets.m4063d(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public String standardToString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        return delegate().setCount(e, i, i2);
    }

    public int standardSetCount(E e, int i) {
        p63.m6869m(i, "count");
        int count = count(e);
        int i2 = i - count;
        if (i2 > 0) {
            add(e, i2);
        } else if (i2 < 0) {
            remove(e, -i2);
        }
        return count;
    }
}
