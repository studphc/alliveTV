package p000;

import com.google.common.base.Equivalence;
import com.google.common.cache.C0839d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class ub1 {

    /* renamed from: a */
    public static final rb1 f27185a;

    /* renamed from: b */
    public static final sb1 f27186b;

    /* renamed from: c */
    public static final tb1 f27187c;

    /* renamed from: d */
    public static final /* synthetic */ ub1[] f27188d;

    static {
        rb1 rb1Var = new rb1();
        f27185a = rb1Var;
        sb1 sb1Var = new sb1();
        f27186b = sb1Var;
        tb1 tb1Var = new tb1();
        f27187c = tb1Var;
        f27188d = new ub1[]{rb1Var, sb1Var, tb1Var};
    }

    public static ub1 valueOf(String str) {
        return (ub1) Enum.valueOf(ub1.class, str);
    }

    public static ub1[] values() {
        return (ub1[]) f27188d.clone();
    }

    /* renamed from: a */
    public abstract Equivalence mo7264a();

    /* renamed from: b */
    public abstract zb1 mo7265b(C0839d c0839d, j92 j92Var, Object obj, int i);
}
