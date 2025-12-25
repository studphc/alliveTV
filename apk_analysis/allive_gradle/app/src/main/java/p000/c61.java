package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.PeekingIterator;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c61 implements PeekingIterator {

    /* renamed from: a */
    public final Iterator f8271a;

    /* renamed from: b */
    public boolean f8272b;

    /* renamed from: c */
    public Object f8273c;

    public c61(Iterator it) {
        this.f8271a = (Iterator) Preconditions.checkNotNull(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f8272b && !this.f8271a.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
    public final Object next() {
        if (!this.f8272b) {
            return this.f8271a.next();
        }
        Object obj = this.f8273c;
        this.f8272b = false;
        this.f8273c = null;
        return obj;
    }

    @Override // com.google.common.collect.PeekingIterator
    public final Object peek() {
        if (!this.f8272b) {
            this.f8273c = this.f8271a.next();
            this.f8272b = true;
        }
        return this.f8273c;
    }

    @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
    public final void remove() {
        Preconditions.checkState(!this.f8272b, "Can't remove after you've peeked at next");
        this.f8271a.remove();
    }
}
