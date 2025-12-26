package p000;

import com.google.common.base.Equivalence;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class if1 {

    /* renamed from: a */
    public static final gf1 f18394a;

    /* renamed from: b */
    public static final hf1 f18395b;

    /* renamed from: c */
    public static final /* synthetic */ if1[] f18396c;

    static {
        gf1 gf1Var = new gf1();
        f18394a = gf1Var;
        hf1 hf1Var = new hf1();
        f18395b = hf1Var;
        f18396c = new if1[]{gf1Var, hf1Var};
    }

    public static if1 valueOf(String str) {
        return (if1) Enum.valueOf(if1.class, str);
    }

    public static if1[] values() {
        return (if1[]) f18396c.clone();
    }

    /* renamed from: a */
    public abstract Equivalence mo4950a();
}
