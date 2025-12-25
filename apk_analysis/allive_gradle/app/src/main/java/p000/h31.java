package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class h31 extends UnmodifiableIterator {

    /* renamed from: a */
    public final /* synthetic */ int f17937a;

    /* renamed from: b */
    public final Object f17938b;

    /* renamed from: c */
    public Object f17939c;

    public h31(C1251h c1251h, Iterator it) {
        this.f17937a = 1;
        this.f17939c = c1251h;
        this.f17938b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f17937a) {
            case 0:
                if (!((UnmodifiableIterator) this.f17939c).hasNext() && !((UnmodifiableIterator) this.f17938b).hasNext()) {
                    return false;
                }
                return true;
            case 1:
                return ((Iterator) this.f17938b).hasNext();
            default:
                return !((ArrayDeque) this.f17938b).isEmpty();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f17937a) {
            case 0:
                if (!((UnmodifiableIterator) this.f17939c).hasNext()) {
                    this.f17939c = ((ImmutableCollection) ((UnmodifiableIterator) this.f17938b).next()).iterator();
                }
                return ((UnmodifiableIterator) this.f17939c).next();
            case 1:
                Map.Entry entry = (Map.Entry) ((Iterator) this.f17938b).next();
                ((ue1) ((C1251h) this.f17939c).f17896b).f27240b = entry;
                return entry.getKey();
            default:
                ArrayDeque arrayDeque = (ArrayDeque) this.f17938b;
                Iterator it = (Iterator) arrayDeque.getLast();
                Object checkNotNull = Preconditions.checkNotNull(it.next());
                if (!it.hasNext()) {
                    arrayDeque.removeLast();
                }
                Iterator it2 = ((TreeTraverser) this.f17939c).children(checkNotNull).iterator();
                if (it2.hasNext()) {
                    arrayDeque.addLast(it2);
                }
                return checkNotNull;
        }
    }

    public h31(TreeTraverser treeTraverser, Object obj) {
        this.f17937a = 2;
        this.f17939c = treeTraverser;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f17938b = arrayDeque;
        arrayDeque.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(obj)));
    }

    public h31(ImmutableMultimap immutableMultimap) {
        this.f17937a = 0;
        this.f17938b = immutableMultimap.f14675f.values().iterator();
        this.f17939c = z51.f29250d;
    }
}
