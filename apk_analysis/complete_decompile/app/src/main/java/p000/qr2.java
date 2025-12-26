package p000;

import java.util.Collection;
import java.util.Queue;

/* loaded from: classes.dex */
public class qr2 extends gr2 implements Queue {
    private static final long serialVersionUID = 0;

    @Override // java.util.Queue
    public final Object element() {
        Object element;
        synchronized (this.f25273b) {
            element = mo4086e().element();
        }
        return element;
    }

    @Override // p000.gr2
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Queue mo4086e() {
        return (Queue) ((Collection) this.f25272a);
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        boolean offer;
        synchronized (this.f25273b) {
            offer = mo4086e().offer(obj);
        }
        return offer;
    }

    @Override // java.util.Queue
    public final Object peek() {
        Object peek;
        synchronized (this.f25273b) {
            peek = mo4086e().peek();
        }
        return peek;
    }

    @Override // java.util.Queue
    public final Object poll() {
        Object poll;
        synchronized (this.f25273b) {
            poll = mo4086e().poll();
        }
        return poll;
    }

    @Override // java.util.Queue
    public final Object remove() {
        Object remove;
        synchronized (this.f25273b) {
            remove = mo4086e().remove();
        }
        return remove;
    }
}
