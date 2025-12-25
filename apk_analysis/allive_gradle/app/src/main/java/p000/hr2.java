package p000;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* loaded from: classes.dex */
public final class hr2 extends qr2 implements Deque {
    private static final long serialVersionUID = 0;

    @Override // java.util.Deque
    public final void addFirst(Object obj) {
        synchronized (this.f25273b) {
            ((Deque) super.mo4086e()).addFirst(obj);
        }
    }

    @Override // java.util.Deque
    public final void addLast(Object obj) {
        synchronized (this.f25273b) {
            ((Deque) super.mo4086e()).addLast(obj);
        }
    }

    @Override // java.util.Deque
    public final Iterator descendingIterator() {
        Iterator descendingIterator;
        synchronized (this.f25273b) {
            descendingIterator = ((Deque) super.mo4086e()).descendingIterator();
        }
        return descendingIterator;
    }

    @Override // p000.qr2, p000.gr2
    /* renamed from: e */
    public final Collection mo4086e() {
        return (Deque) super.mo4086e();
    }

    @Override // p000.qr2
    /* renamed from: f */
    public final Queue mo4086e() {
        return (Deque) super.mo4086e();
    }

    @Override // java.util.Deque
    public final Object getFirst() {
        Object first;
        synchronized (this.f25273b) {
            first = ((Deque) super.mo4086e()).getFirst();
        }
        return first;
    }

    @Override // java.util.Deque
    public final Object getLast() {
        Object last;
        synchronized (this.f25273b) {
            last = ((Deque) super.mo4086e()).getLast();
        }
        return last;
    }

    @Override // java.util.Deque
    public final boolean offerFirst(Object obj) {
        boolean offerFirst;
        synchronized (this.f25273b) {
            offerFirst = ((Deque) super.mo4086e()).offerFirst(obj);
        }
        return offerFirst;
    }

    @Override // java.util.Deque
    public final boolean offerLast(Object obj) {
        boolean offerLast;
        synchronized (this.f25273b) {
            offerLast = ((Deque) super.mo4086e()).offerLast(obj);
        }
        return offerLast;
    }

    @Override // java.util.Deque
    public final Object peekFirst() {
        Object peekFirst;
        synchronized (this.f25273b) {
            peekFirst = ((Deque) super.mo4086e()).peekFirst();
        }
        return peekFirst;
    }

    @Override // java.util.Deque
    public final Object peekLast() {
        Object peekLast;
        synchronized (this.f25273b) {
            peekLast = ((Deque) super.mo4086e()).peekLast();
        }
        return peekLast;
    }

    @Override // java.util.Deque
    public final Object pollFirst() {
        Object pollFirst;
        synchronized (this.f25273b) {
            pollFirst = ((Deque) super.mo4086e()).pollFirst();
        }
        return pollFirst;
    }

    @Override // java.util.Deque
    public final Object pollLast() {
        Object pollLast;
        synchronized (this.f25273b) {
            pollLast = ((Deque) super.mo4086e()).pollLast();
        }
        return pollLast;
    }

    @Override // java.util.Deque
    public final Object pop() {
        Object pop;
        synchronized (this.f25273b) {
            pop = ((Deque) super.mo4086e()).pop();
        }
        return pop;
    }

    @Override // java.util.Deque
    public final void push(Object obj) {
        synchronized (this.f25273b) {
            ((Deque) super.mo4086e()).push(obj);
        }
    }

    @Override // java.util.Deque
    public final Object removeFirst() {
        Object removeFirst;
        synchronized (this.f25273b) {
            removeFirst = ((Deque) super.mo4086e()).removeFirst();
        }
        return removeFirst;
    }

    @Override // java.util.Deque
    public final boolean removeFirstOccurrence(Object obj) {
        boolean removeFirstOccurrence;
        synchronized (this.f25273b) {
            removeFirstOccurrence = ((Deque) super.mo4086e()).removeFirstOccurrence(obj);
        }
        return removeFirstOccurrence;
    }

    @Override // java.util.Deque
    public final Object removeLast() {
        Object removeLast;
        synchronized (this.f25273b) {
            removeLast = ((Deque) super.mo4086e()).removeLast();
        }
        return removeLast;
    }

    @Override // java.util.Deque
    public final boolean removeLastOccurrence(Object obj) {
        boolean removeLastOccurrence;
        synchronized (this.f25273b) {
            removeLastOccurrence = ((Deque) super.mo4086e()).removeLastOccurrence(obj);
        }
        return removeLastOccurrence;
    }
}
