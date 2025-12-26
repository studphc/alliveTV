package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class nx0 {

    /* renamed from: a */
    public static final nx0 f23520a;

    /* renamed from: b */
    public static final /* synthetic */ nx0[] f23521b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, nx0] */
    static {
        ?? r1 = new Enum("EDGE_EXISTS", 0);
        f23520a = r1;
        f23521b = new nx0[]{r1};
    }

    public static nx0 valueOf(String str) {
        return (nx0) Enum.valueOf(nx0.class, str);
    }

    public static nx0[] values() {
        return (nx0[]) f23521b.clone();
    }
}
