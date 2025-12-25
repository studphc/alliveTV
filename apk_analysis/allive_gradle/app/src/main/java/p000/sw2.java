package p000;

import com.google.common.collect.Iterables;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class sw2 extends UnmodifiableIterator implements PeekingIterator {

    /* renamed from: a */
    public final ArrayDeque f26607a;

    /* renamed from: b */
    public final /* synthetic */ TreeTraverser f26608b;

    public sw2(TreeTraverser treeTraverser, Object obj) {
        this.f26608b = treeTraverser;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f26607a = arrayDeque;
        arrayDeque.add(obj);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f26607a.isEmpty();
    }

    @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
    public final Object next() {
        ArrayDeque arrayDeque = this.f26607a;
        Object remove = arrayDeque.remove();
        Iterables.addAll(arrayDeque, this.f26608b.children(remove));
        return remove;
    }

    @Override // com.google.common.collect.PeekingIterator
    public final Object peek() {
        return this.f26607a.element();
    }
}
