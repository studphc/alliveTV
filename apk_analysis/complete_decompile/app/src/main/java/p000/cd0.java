package p000;

import com.google.common.base.Predicate;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class cd0 implements Predicate {

    /* renamed from: a */
    public static final ad0 f8335a;

    /* renamed from: b */
    public static final bd0 f8336b;

    /* renamed from: c */
    public static final /* synthetic */ cd0[] f8337c;

    static {
        ad0 ad0Var = new ad0();
        f8335a = ad0Var;
        bd0 bd0Var = new bd0();
        f8336b = bd0Var;
        f8337c = new cd0[]{ad0Var, bd0Var};
    }

    public static cd0 valueOf(String str) {
        return (cd0) Enum.valueOf(cd0.class, str);
    }

    public static cd0[] values() {
        return (cd0[]) f8337c.clone();
    }
}
