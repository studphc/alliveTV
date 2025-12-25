package p000;

import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* loaded from: classes.dex */
public final class tq1 implements ListIterator, KMutableListIterator {

    /* renamed from: a */
    public final Object f26937a;

    /* renamed from: b */
    public int f26938b;

    public tq1(int i, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f26937a = list;
        this.f26938b = i - 1;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i = this.f26938b + 1;
        this.f26938b = i;
        this.f26937a.add(i, obj);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        if (this.f26938b < this.f26937a.size() - 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f26938b >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i = this.f26938b + 1;
        this.f26938b = i;
        return this.f26937a.get(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f26938b + 1;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List, java.lang.Object] */
    @Override // java.util.ListIterator
    public final Object previous() {
        int i = this.f26938b;
        this.f26938b = i - 1;
        return this.f26937a.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f26938b;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        this.f26937a.remove(this.f26938b);
        this.f26938b--;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, java.lang.Object] */
    @Override // java.util.ListIterator
    public final void set(Object obj) {
        this.f26937a.set(this.f26938b, obj);
    }
}
