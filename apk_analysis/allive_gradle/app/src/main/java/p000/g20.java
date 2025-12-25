package p000;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Maps;
import java.util.Map;

/* loaded from: classes.dex */
public final class g20 extends AbstractIterator {

    /* renamed from: c */
    public int f17528c = -1;

    /* renamed from: d */
    public final int f17529d;

    /* renamed from: e */
    public final /* synthetic */ h20 f17530e;

    public g20(h20 h20Var) {
        this.f17530e = h20Var;
        this.f17529d = h20Var.mo4656l().size();
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        int i = this.f17528c;
        while (true) {
            this.f17528c = i + 1;
            int i2 = this.f17528c;
            if (i2 < this.f17529d) {
                h20 h20Var = this.f17530e;
                Object mo4655k = h20Var.mo4655k(i2);
                if (mo4655k != null) {
                    return Maps.immutableEntry(h20Var.mo4656l().keySet().asList().get(this.f17528c), mo4655k);
                }
                i = this.f17528c;
            } else {
                return (Map.Entry) endOfData();
            }
        }
    }
}
