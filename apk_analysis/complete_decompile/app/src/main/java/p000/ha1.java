package p000;

import com.google.common.base.Preconditions;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class ha1 implements ListIterator {

    /* renamed from: a */
    public boolean f17994a;

    /* renamed from: b */
    public final /* synthetic */ ListIterator f17995b;

    /* renamed from: c */
    public final /* synthetic */ ia1 f17996c;

    public ha1(ia1 ia1Var, ListIterator listIterator) {
        this.f17996c = ia1Var;
        this.f17995b = listIterator;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        ListIterator listIterator = this.f17995b;
        listIterator.add(obj);
        listIterator.previous();
        this.f17994a = false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f17995b.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f17995b.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        ListIterator listIterator = this.f17995b;
        if (listIterator.hasPrevious()) {
            this.f17994a = true;
            return listIterator.previous();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f17996c.m5205a(this.f17995b.nextIndex());
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        ListIterator listIterator = this.f17995b;
        if (listIterator.hasNext()) {
            this.f17994a = true;
            return listIterator.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return nextIndex() - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        p63.m6876t(this.f17994a);
        this.f17995b.remove();
        this.f17994a = false;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        Preconditions.checkState(this.f17994a);
        this.f17995b.set(obj);
    }
}
