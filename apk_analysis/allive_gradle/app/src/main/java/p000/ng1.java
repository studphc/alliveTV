package p000;

import com.google.common.base.Function;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class ng1 implements Function {

    /* renamed from: a */
    public static final lg1 f23353a;

    /* renamed from: b */
    public static final mg1 f23354b;

    /* renamed from: c */
    public static final /* synthetic */ ng1[] f23355c;

    static {
        lg1 lg1Var = new lg1();
        f23353a = lg1Var;
        mg1 mg1Var = new mg1();
        f23354b = mg1Var;
        f23355c = new ng1[]{lg1Var, mg1Var};
    }

    public static ng1 valueOf(String str) {
        return (ng1) Enum.valueOf(ng1.class, str);
    }

    public static ng1[] values() {
        return (ng1[]) f23355c.clone();
    }
}
