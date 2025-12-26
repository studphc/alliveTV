package p000;

import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class y51 extends UnmodifiableIterator {

    /* renamed from: a */
    public boolean f28844a;

    /* renamed from: b */
    public final /* synthetic */ Object f28845b;

    public y51(Object obj) {
        this.f28845b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f28844a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f28844a) {
            this.f28844a = true;
            return this.f28845b;
        }
        throw new NoSuchElementException();
    }
}
