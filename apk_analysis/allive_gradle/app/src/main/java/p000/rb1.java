package p000;

import com.google.common.base.Equivalence;
import com.google.common.cache.C0839d;

/* loaded from: classes.dex */
public enum rb1 extends ub1 {
    public rb1() {
        super("STRONG", 0);
    }

    @Override // p000.ub1
    /* renamed from: a */
    public final Equivalence mo7264a() {
        return Equivalence.equals();
    }

    @Override // p000.ub1
    /* renamed from: b */
    public final zb1 mo7265b(C0839d c0839d, j92 j92Var, Object obj, int i) {
        if (i == 1) {
            return new yb1(obj);
        }
        return new fc1(i, obj);
    }
}
