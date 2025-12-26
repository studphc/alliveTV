package p000;

import com.google.common.base.Predicate;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class hy2 implements Predicate {

    /* renamed from: a */
    public static final fy2 f18217a;

    /* renamed from: b */
    public static final gy2 f18218b;

    /* renamed from: c */
    public static final /* synthetic */ hy2[] f18219c;

    static {
        fy2 fy2Var = new fy2();
        f18217a = fy2Var;
        gy2 gy2Var = new gy2();
        f18218b = gy2Var;
        f18219c = new hy2[]{fy2Var, gy2Var};
    }

    public static hy2 valueOf(String str) {
        return (hy2) Enum.valueOf(hy2.class, str);
    }

    public static hy2[] values() {
        return (hy2[]) f18219c.clone();
    }
}
