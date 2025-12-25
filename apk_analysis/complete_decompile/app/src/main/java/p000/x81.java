package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Sets;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class x81 implements Iterator {

    /* renamed from: a */
    public final HashSet f28471a;

    /* renamed from: b */
    public z81 f28472b;

    /* renamed from: c */
    public z81 f28473c;

    /* renamed from: d */
    public int f28474d;

    /* renamed from: e */
    public final /* synthetic */ LinkedListMultimap f28475e;

    public x81(LinkedListMultimap linkedListMultimap) {
        this.f28475e = linkedListMultimap;
        this.f28471a = Sets.newHashSetWithExpectedSize(linkedListMultimap.keySet().size());
        this.f28472b = linkedListMultimap.f14725f;
        this.f28474d = linkedListMultimap.f14729j;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f28475e.f14729j == this.f28474d) {
            if (this.f28472b != null) {
                return true;
            }
            return false;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final Object next() {
        z81 z81Var;
        if (this.f28475e.f14729j == this.f28474d) {
            z81 z81Var2 = this.f28472b;
            if (z81Var2 != null) {
                this.f28473c = z81Var2;
                Object obj = z81Var2.f29269a;
                HashSet hashSet = this.f28471a;
                hashSet.add(obj);
                do {
                    z81Var = this.f28472b.f29271c;
                    this.f28472b = z81Var;
                    if (z81Var == null) {
                        break;
                    }
                } while (!hashSet.add(z81Var.f29269a));
                return this.f28473c.f29269a;
            }
            throw new NoSuchElementException();
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z;
        LinkedListMultimap linkedListMultimap = this.f28475e;
        if (linkedListMultimap.f14729j == this.f28474d) {
            if (this.f28473c != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "no calls to next() since the last call to remove()");
            Object obj = this.f28473c.f29269a;
            linkedListMultimap.getClass();
            Iterators.m4034b(new b91(linkedListMultimap, obj));
            this.f28473c = null;
            this.f28474d = linkedListMultimap.f14729j;
            return;
        }
        throw new ConcurrentModificationException();
    }
}
