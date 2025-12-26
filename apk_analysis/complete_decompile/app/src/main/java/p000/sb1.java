package p000;

import com.google.common.base.Equivalence;
import com.google.common.cache.C0839d;

/* loaded from: classes.dex */
public enum sb1 extends ub1 {
    public sb1() {
        super("SOFT", 1);
    }

    @Override // p000.ub1
    /* renamed from: a */
    public final Equivalence mo7264a() {
        return Equivalence.identity();
    }

    @Override // p000.ub1
    /* renamed from: b */
    public final zb1 mo7265b(C0839d c0839d, j92 j92Var, Object obj, int i) {
        if (i == 1) {
            return new qb1(c0839d.f14578i, obj, j92Var);
        }
        return new ec1(i, j92Var, obj, c0839d.f14578i);
    }
}
