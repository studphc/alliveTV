package p000;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q51 extends FluentIterable {

    /* renamed from: b */
    public final Iterable f25456b;

    public q51(Iterable iterable) {
        this.f25456b = iterable;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return Iterators.unmodifiableIterator(this.f25456b.iterator());
    }

    @Override // com.google.common.collect.FluentIterable
    public final String toString() {
        return this.f25456b.toString();
    }
}
