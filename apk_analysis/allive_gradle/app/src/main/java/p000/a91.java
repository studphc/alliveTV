package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.LinkedListMultimap;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a91 implements ListIterator {

    /* renamed from: a */
    public int f91a;

    /* renamed from: b */
    public z81 f92b;

    /* renamed from: c */
    public z81 f93c;

    /* renamed from: d */
    public z81 f94d;

    /* renamed from: e */
    public int f95e;

    /* renamed from: f */
    public final /* synthetic */ LinkedListMultimap f96f;

    public a91(LinkedListMultimap linkedListMultimap, int i) {
        this.f96f = linkedListMultimap;
        this.f95e = linkedListMultimap.f14729j;
        int size = linkedListMultimap.size();
        Preconditions.checkPositionIndex(i, size);
        if (i >= size / 2) {
            this.f94d = linkedListMultimap.f14726g;
            this.f91a = size;
            while (true) {
                int i2 = i + 1;
                if (i >= size) {
                    break;
                }
                m42a();
                z81 z81Var = this.f94d;
                if (z81Var != null) {
                    this.f93c = z81Var;
                    this.f92b = z81Var;
                    this.f94d = z81Var.f29272d;
                    this.f91a--;
                    i = i2;
                } else {
                    throw new NoSuchElementException();
                }
            }
        } else {
            this.f92b = linkedListMultimap.f14725f;
            while (true) {
                int i3 = i - 1;
                if (i <= 0) {
                    break;
                }
                m42a();
                z81 z81Var2 = this.f92b;
                if (z81Var2 != null) {
                    this.f93c = z81Var2;
                    this.f94d = z81Var2;
                    this.f92b = z81Var2.f29271c;
                    this.f91a++;
                    i = i3;
                } else {
                    throw new NoSuchElementException();
                }
            }
        }
        this.f93c = null;
    }

    /* renamed from: a */
    public final void m42a() {
        if (this.f96f.f14729j == this.f95e) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        m42a();
        if (this.f92b != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        m42a();
        if (this.f94d != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        m42a();
        z81 z81Var = this.f92b;
        if (z81Var != null) {
            this.f93c = z81Var;
            this.f94d = z81Var;
            this.f92b = z81Var.f29271c;
            this.f91a++;
            return z81Var;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f91a;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        m42a();
        z81 z81Var = this.f94d;
        if (z81Var != null) {
            this.f93c = z81Var;
            this.f92b = z81Var;
            this.f94d = z81Var.f29272d;
            this.f91a--;
            return z81Var;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f91a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        boolean z;
        m42a();
        if (this.f93c != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
        z81 z81Var = this.f93c;
        if (z81Var != this.f92b) {
            this.f94d = z81Var.f29272d;
            this.f91a--;
        } else {
            this.f92b = z81Var.f29271c;
        }
        LinkedListMultimap linkedListMultimap = this.f96f;
        LinkedListMultimap.m4038i(linkedListMultimap, z81Var);
        this.f93c = null;
        this.f95e = linkedListMultimap.f14729j;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
