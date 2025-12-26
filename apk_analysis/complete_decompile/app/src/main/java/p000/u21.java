package p000;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class u21 extends UnmodifiableIterator {

    /* renamed from: a */
    public final /* synthetic */ int f27073a;

    /* renamed from: b */
    public final UnmodifiableIterator f27074b;

    public /* synthetic */ u21(UnmodifiableIterator unmodifiableIterator, int i) {
        this.f27073a = i;
        this.f27074b = unmodifiableIterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f27073a) {
            case 0:
                return this.f27074b.hasNext();
            case 1:
                return this.f27074b.hasNext();
            default:
                return this.f27074b.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f27073a) {
            case 0:
                return ((Map.Entry) this.f27074b.next()).getKey();
            case 1:
                return new x21((Map.Entry) this.f27074b.next(), 0);
            default:
                return ((Map.Entry) this.f27074b.next()).getValue();
        }
    }

    public u21(f31 f31Var) {
        this.f27073a = 2;
        this.f27074b = f31Var.f17115b.entrySet().iterator();
    }
}
