package com.google.common.collect;

import com.google.common.collect.ForwardingNavigableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: com.google.common.collect.x */
/* loaded from: classes.dex */
public final class C0949x implements Iterator {

    /* renamed from: a */
    public Map.Entry f14986a = null;

    /* renamed from: b */
    public Map.Entry f14987b;

    /* renamed from: c */
    public final /* synthetic */ ForwardingNavigableMap.StandardDescendingMap f14988c;

    public C0949x(ForwardingNavigableMap.StandardDescendingMap standardDescendingMap) {
        this.f14988c = standardDescendingMap;
        this.f14987b = ForwardingNavigableMap.this.lastEntry();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f14987b != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = this.f14987b;
        if (entry != null) {
            this.f14986a = entry;
            this.f14987b = ForwardingNavigableMap.this.lowerEntry(entry.getKey());
            return entry;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        Map.Entry entry = this.f14986a;
        if (entry != null) {
            ForwardingNavigableMap.this.remove(entry.getKey());
            this.f14986a = null;
            return;
        }
        throw new IllegalStateException("no calls to next() since the last call to remove()");
    }
}
