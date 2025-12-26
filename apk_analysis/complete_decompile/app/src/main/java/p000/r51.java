package p000;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class r51 extends UnmodifiableIterator {

    /* renamed from: a */
    public final /* synthetic */ int f25872a = 1;

    /* renamed from: b */
    public final Object f25873b;

    public r51(Enumeration enumeration) {
        this.f25873b = enumeration;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f25872a) {
            case 0:
                return ((Enumeration) this.f25873b).hasMoreElements();
            default:
                return !((PriorityQueue) this.f25873b).isEmpty();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f25872a) {
            case 0:
                return ((Enumeration) this.f25873b).nextElement();
            default:
                PriorityQueue priorityQueue = (PriorityQueue) this.f25873b;
                PeekingIterator peekingIterator = (PeekingIterator) priorityQueue.remove();
                Object next = peekingIterator.next();
                if (peekingIterator.hasNext()) {
                    priorityQueue.add(peekingIterator);
                }
                return next;
        }
    }

    public r51(Iterable iterable, Comparator comparator) {
        this.f25873b = new PriorityQueue(2, new C1808sr(comparator, 2));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Iterator it2 = (Iterator) it.next();
            if (it2.hasNext()) {
                ((PriorityQueue) this.f25873b).add(Iterators.peekingIterator(it2));
            }
        }
    }
}
