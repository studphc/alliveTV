package p000;

import com.google.common.collect.AbstractIterator;
import java.util.BitSet;

/* loaded from: classes.dex */
public final class hh2 extends AbstractIterator {

    /* renamed from: c */
    public int f18059c = -1;

    /* renamed from: d */
    public final /* synthetic */ x70 f18060d;

    public hh2(x70 x70Var) {
        this.f18060d = x70Var;
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        x70 x70Var = this.f18060d;
        int nextSetBit = ((BitSet) x70Var.f28453b).nextSetBit(this.f18059c + 1);
        this.f18059c = nextSetBit;
        if (nextSetBit == -1) {
            return endOfData();
        }
        return ((ih2) ((C0566bq) x70Var.f28454c).f8125e).f18415b.keySet().asList().get(this.f18059c);
    }
}
