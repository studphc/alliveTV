package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.LinkedListMultimap;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b91 implements ListIterator {

    /* renamed from: a */
    public final Object f7932a;

    /* renamed from: b */
    public int f7933b;

    /* renamed from: c */
    public z81 f7934c;

    /* renamed from: d */
    public z81 f7935d;

    /* renamed from: e */
    public z81 f7936e;

    /* renamed from: f */
    public final /* synthetic */ LinkedListMultimap f7937f;

    public b91(LinkedListMultimap linkedListMultimap, Object obj) {
        this.f7937f = linkedListMultimap;
        this.f7932a = obj;
        y81 y81Var = (y81) linkedListMultimap.f14727h.get(obj);
        this.f7934c = y81Var == null ? null : y81Var.f28863a;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        this.f7936e = this.f7937f.m4039j(this.f7932a, obj, this.f7934c);
        this.f7933b++;
        this.f7935d = null;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        if (this.f7934c != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f7936e != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        z81 z81Var = this.f7934c;
        if (z81Var != null) {
            this.f7935d = z81Var;
            this.f7936e = z81Var;
            this.f7934c = z81Var.f29273e;
            this.f7933b++;
            return z81Var.f29270b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f7933b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        z81 z81Var = this.f7936e;
        if (z81Var != null) {
            this.f7935d = z81Var;
            this.f7934c = z81Var;
            this.f7936e = z81Var.f29274f;
            this.f7933b--;
            return z81Var.f29270b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f7933b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        boolean z;
        if (this.f7935d != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
        z81 z81Var = this.f7935d;
        if (z81Var != this.f7934c) {
            this.f7936e = z81Var.f29274f;
            this.f7933b--;
        } else {
            this.f7934c = z81Var.f29273e;
        }
        LinkedListMultimap.m4038i(this.f7937f, z81Var);
        this.f7935d = null;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        boolean z;
        if (this.f7935d != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.f7935d.f29270b = obj;
    }

    public b91(LinkedListMultimap linkedListMultimap, Object obj, int i) {
        this.f7937f = linkedListMultimap;
        y81 y81Var = (y81) linkedListMultimap.f14727h.get(obj);
        int i2 = y81Var == null ? 0 : y81Var.f28865c;
        Preconditions.checkPositionIndex(i, i2);
        if (i >= i2 / 2) {
            this.f7936e = y81Var == null ? null : y81Var.f28864b;
            this.f7933b = i2;
            while (true) {
                int i3 = i + 1;
                if (i >= i2) {
                    break;
                }
                previous();
                i = i3;
            }
        } else {
            this.f7934c = y81Var == null ? null : y81Var.f28863a;
            while (true) {
                int i4 = i - 1;
                if (i <= 0) {
                    break;
                }
                next();
                i = i4;
            }
        }
        this.f7932a = obj;
        this.f7935d = null;
    }
}
