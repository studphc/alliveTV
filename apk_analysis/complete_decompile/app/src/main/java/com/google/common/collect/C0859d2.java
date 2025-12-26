package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import p000.p63;

/* renamed from: com.google.common.collect.d2 */
/* loaded from: classes.dex */
public final class C0859d2 implements Iterator {

    /* renamed from: a */
    public final Multiset f14799a;

    /* renamed from: b */
    public final Iterator f14800b;

    /* renamed from: c */
    public Multiset.Entry f14801c;

    /* renamed from: d */
    public int f14802d;

    /* renamed from: e */
    public int f14803e;

    /* renamed from: f */
    public boolean f14804f;

    public C0859d2(Multiset multiset, Iterator it) {
        this.f14799a = multiset;
        this.f14800b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f14802d <= 0 && !this.f14800b.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            if (this.f14802d == 0) {
                Multiset.Entry entry = (Multiset.Entry) this.f14800b.next();
                this.f14801c = entry;
                int count = entry.getCount();
                this.f14802d = count;
                this.f14803e = count;
            }
            this.f14802d--;
            this.f14804f = true;
            Multiset.Entry entry2 = this.f14801c;
            Objects.requireNonNull(entry2);
            return entry2.getElement();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        p63.m6876t(this.f14804f);
        if (this.f14803e == 1) {
            this.f14800b.remove();
        } else {
            Multiset.Entry entry = this.f14801c;
            Objects.requireNonNull(entry);
            this.f14799a.remove(entry.getElement());
        }
        this.f14803e--;
        this.f14804f = false;
    }
}
