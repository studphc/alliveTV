package p000;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.Queue;

/* loaded from: classes.dex */
public final class ps0 extends FluentIterable {

    /* renamed from: b */
    public final /* synthetic */ int f25276b;

    /* renamed from: c */
    public final /* synthetic */ Object f25277c;

    public /* synthetic */ ps0(int i, Object obj) {
        this.f25276b = i;
        this.f25277c = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f25276b) {
            case 0:
                return ((Iterable) this.f25277c).iterator();
            case 1:
                return Iterators.concat(Iterators.transform(((Iterable) this.f25277c).iterator(), new n82(4)));
            case 2:
                return Iterators.cycle((Iterable) this.f25277c);
            case 3:
                Iterable iterable = (Iterable) this.f25277c;
                if (iterable instanceof Queue) {
                    return new C0528ap((Queue) iterable);
                }
                return Iterators.consumingIterator(iterable.iterator());
            default:
                return Iterators.concat(new C1505lb(((Iterable[]) this.f25277c).length, 2, this));
        }
    }

    @Override // com.google.common.collect.FluentIterable
    public String toString() {
        switch (this.f25276b) {
            case 2:
                return String.valueOf(((Iterable) this.f25277c).toString()).concat(" (cycled)");
            case 3:
                return "Iterables.consumingIterable(...)";
            default:
                return super.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ps0(Iterable iterable, Iterable iterable2) {
        super(iterable);
        this.f25276b = 0;
        this.f25277c = iterable2;
    }
}
