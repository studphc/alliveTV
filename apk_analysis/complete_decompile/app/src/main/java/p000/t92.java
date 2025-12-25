package p000;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.Range;

/* loaded from: classes.dex */
public final class t92 extends AbstractSequentialIterator {

    /* renamed from: b */
    public final /* synthetic */ int f26729b;

    /* renamed from: c */
    public final Comparable f26730c;

    /* renamed from: d */
    public final /* synthetic */ w92 f26731d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t92(w92 w92Var, Comparable comparable, int i) {
        super(comparable);
        this.f26729b = i;
        switch (i) {
            case 1:
                this.f26731d = w92Var;
                super(comparable);
                this.f26730c = w92Var.first();
                return;
            default:
                this.f26731d = w92Var;
                this.f26730c = w92Var.last();
                return;
        }
    }

    @Override // com.google.common.collect.AbstractSequentialIterator
    public final Object computeNext(Object obj) {
        w92 w92Var = this.f26731d;
        Comparable comparable = this.f26730c;
        switch (this.f26729b) {
            case 0:
                Comparable comparable2 = (Comparable) obj;
                if (comparable != null) {
                    Range range = Range.f14746c;
                    if (comparable2.compareTo(comparable) == 0) {
                        return null;
                    }
                }
                return w92Var.f14625e.next(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                if (comparable != null) {
                    Range range2 = Range.f14746c;
                    if (comparable3.compareTo(comparable) == 0) {
                        return null;
                    }
                }
                return w92Var.f14625e.previous(comparable3);
        }
    }
}
