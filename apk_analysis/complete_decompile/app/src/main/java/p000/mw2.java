package p000;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import java.util.Map;

/* loaded from: classes.dex */
public final class mw2 extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ int f23143c;

    /* renamed from: d */
    public AbstractC1814sx f23144d;

    /* renamed from: e */
    public final /* synthetic */ PeekingIterator f23145e;

    /* renamed from: f */
    public final /* synthetic */ nw2 f23146f;

    public /* synthetic */ mw2(nw2 nw2Var, AbstractC1814sx abstractC1814sx, PeekingIterator peekingIterator, int i) {
        this.f23143c = i;
        this.f23146f = nw2Var;
        this.f23145e = peekingIterator;
        this.f23144d = abstractC1814sx;
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Range range;
        switch (this.f23143c) {
            case 0:
                if (!this.f23146f.f23518c.f14748b.mo6741h(this.f23144d)) {
                    AbstractC1814sx abstractC1814sx = this.f23144d;
                    C1666ox c1666ox = C1666ox.f24940b;
                    if (abstractC1814sx != c1666ox) {
                        PeekingIterator peekingIterator = this.f23145e;
                        if (peekingIterator.hasNext()) {
                            Range range2 = (Range) peekingIterator.next();
                            range = new Range(this.f23144d, range2.f14747a);
                            this.f23144d = range2.f14748b;
                        } else {
                            range = new Range(this.f23144d, c1666ox);
                            this.f23144d = c1666ox;
                        }
                        return Maps.immutableEntry(range.f14747a, range);
                    }
                }
                return (Map.Entry) endOfData();
            default:
                AbstractC1814sx abstractC1814sx2 = this.f23144d;
                C1740qx c1740qx = C1740qx.f25786b;
                if (abstractC1814sx2 == c1740qx) {
                    return (Map.Entry) endOfData();
                }
                PeekingIterator peekingIterator2 = this.f23145e;
                boolean hasNext = peekingIterator2.hasNext();
                nw2 nw2Var = this.f23146f;
                if (hasNext) {
                    Range range3 = (Range) peekingIterator2.next();
                    Range range4 = new Range(range3.f14748b, this.f23144d);
                    this.f23144d = range3.f14747a;
                    AbstractC1814sx abstractC1814sx3 = nw2Var.f23518c.f14747a;
                    AbstractC1814sx abstractC1814sx4 = range4.f14747a;
                    if (abstractC1814sx3.mo6741h(abstractC1814sx4)) {
                        return Maps.immutableEntry(abstractC1814sx4, range4);
                    }
                } else if (nw2Var.f23518c.f14747a.mo6741h(c1740qx)) {
                    Range range5 = new Range(c1740qx, this.f23144d);
                    this.f23144d = c1740qx;
                    return Maps.immutableEntry(c1740qx, range5);
                }
                return (Map.Entry) endOfData();
        }
    }
}
