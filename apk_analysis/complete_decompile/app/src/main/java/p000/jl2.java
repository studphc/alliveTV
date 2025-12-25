package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class jl2 {

    /* renamed from: a */
    public static final gl2 f20540a;

    /* renamed from: b */
    public static final hl2 f20541b;

    /* renamed from: c */
    public static final /* synthetic */ jl2[] f20542c;

    static {
        gl2 gl2Var = new gl2();
        f20540a = gl2Var;
        hl2 hl2Var = new hl2();
        f20541b = hl2Var;
        f20542c = new jl2[]{gl2Var, hl2Var, new jl2() { // from class: il2
            @Override // p000.jl2
            /* renamed from: a */
            public final int mo4955a(int i) {
                return ~i;
            }
        }};
    }

    public static jl2 valueOf(String str) {
        return (jl2) Enum.valueOf(jl2.class, str);
    }

    public static jl2[] values() {
        return (jl2[]) f20542c.clone();
    }

    /* renamed from: a */
    public abstract int mo4955a(int i);
}
