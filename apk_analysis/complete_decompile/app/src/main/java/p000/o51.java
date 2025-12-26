package p000;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class o51 extends FluentIterable {

    /* renamed from: b */
    public final /* synthetic */ int f23607b;

    /* renamed from: c */
    public final /* synthetic */ Iterable f23608c;

    /* renamed from: d */
    public final /* synthetic */ Object f23609d;

    public /* synthetic */ o51(Iterable iterable, int i, Object obj) {
        this.f23607b = i;
        this.f23608c = iterable;
        this.f23609d = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f23607b) {
            case 0:
                return Iterators.filter(this.f23608c.iterator(), (Predicate) this.f23609d);
            case 1:
                return Iterators.transform(this.f23608c.iterator(), (Function) this.f23609d);
            default:
                return Iterators.mergeSorted(Iterables.transform(this.f23608c, new n82(4)), (Comparator) this.f23609d);
        }
    }
}
