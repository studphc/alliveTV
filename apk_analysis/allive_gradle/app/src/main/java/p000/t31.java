package p000;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;

/* loaded from: classes.dex */
public final class t31 extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ int f26679c;

    /* renamed from: d */
    public final UnmodifiableIterator f26680d;

    /* renamed from: e */
    public UnmodifiableIterator f26681e;

    /* renamed from: f */
    public final /* synthetic */ u31 f26682f;

    public t31(u31 u31Var, int i) {
        this.f26679c = i;
        switch (i) {
            case 1:
                this.f26682f = u31Var;
                this.f26680d = u31Var.f27082g.f14692a.reverse().iterator();
                this.f26681e = z51.f29250d;
                return;
            default:
                this.f26682f = u31Var;
                this.f26680d = u31Var.f27082g.f14692a.iterator();
                this.f26681e = z51.f29250d;
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        switch (this.f26679c) {
            case 0:
                while (!this.f26681e.hasNext()) {
                    UnmodifiableIterator unmodifiableIterator = this.f26680d;
                    if (unmodifiableIterator.hasNext()) {
                        this.f26681e = ContiguousSet.create((Range) unmodifiableIterator.next(), this.f26682f.f27080e).iterator();
                    } else {
                        return (Comparable) endOfData();
                    }
                }
                return (Comparable) this.f26681e.next();
            default:
                while (!this.f26681e.hasNext()) {
                    UnmodifiableIterator unmodifiableIterator2 = this.f26680d;
                    if (unmodifiableIterator2.hasNext()) {
                        this.f26681e = ContiguousSet.create((Range) unmodifiableIterator2.next(), this.f26682f.f27080e).descendingIterator();
                    } else {
                        return (Comparable) endOfData();
                    }
                }
                return (Comparable) this.f26681e.next();
        }
    }
}
