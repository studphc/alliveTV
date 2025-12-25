package p000;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class n51 extends FluentIterable {

    /* renamed from: b */
    public final /* synthetic */ int f23233b;

    /* renamed from: c */
    public final /* synthetic */ Iterable f23234c;

    /* renamed from: d */
    public final /* synthetic */ int f23235d;

    public /* synthetic */ n51(Iterable iterable, int i, int i2) {
        this.f23233b = i2;
        this.f23234c = iterable;
        this.f23235d = i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f23233b) {
            case 0:
                return Iterators.partition(this.f23234c.iterator(), this.f23235d);
            case 1:
                return Iterators.paddedPartition(this.f23234c.iterator(), this.f23235d);
            case 2:
                Iterable iterable = this.f23234c;
                boolean z = iterable instanceof List;
                int i = this.f23235d;
                if (z) {
                    List list = (List) iterable;
                    return list.subList(Math.min(list.size(), i), list.size()).iterator();
                }
                Iterator it = iterable.iterator();
                Iterators.advance(it, i);
                return new p51(it);
            default:
                return Iterators.limit(this.f23234c.iterator(), this.f23235d);
        }
    }
}
