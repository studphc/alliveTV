package p000;

import com.google.common.collect.Iterators;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class px0 extends d41 {

    /* renamed from: d */
    public final /* synthetic */ int f25329d = 1;

    /* renamed from: e */
    public final /* synthetic */ Object f25330e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px0(fn2 fn2Var, Object obj, mx0 mx0Var) {
        super(fn2Var, obj);
        this.f25330e = mx0Var;
    }

    @Override // p000.d41, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f25329d) {
            case 0:
                return Iterators.transform(((qx0) this.f25330e).f25787a.incidentEdges(this.f16241b).iterator(), new C1291i2(3, this));
            default:
                return ((mx0) this.f25330e).mo4185g(this.f16241b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px0(qx0 qx0Var, qx0 qx0Var2, Object obj) {
        super(qx0Var2, obj);
        this.f25330e = qx0Var;
    }
}
