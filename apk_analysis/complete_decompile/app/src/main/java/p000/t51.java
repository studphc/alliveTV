package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class t51 extends UnmodifiableIterator {

    /* renamed from: a */
    public final /* synthetic */ int f26697a;

    /* renamed from: b */
    public final /* synthetic */ Iterator f26698b;

    public /* synthetic */ t51(Iterator it, int i) {
        this.f26697a = i;
        this.f26698b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f26697a) {
            case 0:
                return this.f26698b.hasNext();
            case 1:
                return this.f26698b.hasNext();
            default:
                return this.f26698b.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f26697a) {
            case 0:
                return this.f26698b.next();
            case 1:
                Iterator it = this.f26698b;
                Object next = it.next();
                it.remove();
                return next;
            default:
                Map.Entry entry = (Map.Entry) this.f26698b.next();
                Preconditions.checkNotNull(entry);
                return new x21(entry, 1);
        }
    }

    public String toString() {
        switch (this.f26697a) {
            case 1:
                return "Iterators.consumingIterator(...)";
            default:
                return super.toString();
        }
    }
}
