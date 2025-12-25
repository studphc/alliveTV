package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class k53 {

    /* renamed from: a */
    public static final k53 f20753a;

    /* renamed from: b */
    public static final k53 f20754b;

    /* renamed from: c */
    public static final /* synthetic */ k53[] f20755c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, k53] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, k53] */
    static {
        ?? r4 = new Enum("NONE", 0);
        f20753a = r4;
        Enum r5 = new Enum("START", 1);
        Enum r6 = new Enum("END", 2);
        ?? r7 = new Enum("CENTER", 3);
        f20754b = r7;
        f20755c = new k53[]{r4, r5, r6, r7};
    }

    public static k53 valueOf(String str) {
        return (k53) Enum.valueOf(k53.class, str);
    }

    public static k53[] values() {
        return (k53[]) f20755c.clone();
    }
}
