package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: rj */
/* loaded from: classes.dex */
public final class EnumC1763rj {

    /* renamed from: a */
    public static final EnumC1763rj f25988a;

    /* renamed from: b */
    public static final EnumC1763rj f25989b;

    /* renamed from: c */
    public static final EnumC1763rj f25990c;

    /* renamed from: d */
    public static final EnumC1763rj f25991d;

    /* renamed from: e */
    public static final /* synthetic */ EnumC1763rj[] f25992e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, rj] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, rj] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, rj] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, rj] */
    static {
        ?? r4 = new Enum("UNKNOWN", 0);
        f25988a = r4;
        ?? r5 = new Enum("TRUE", 1);
        f25989b = r5;
        ?? r6 = new Enum("FALSE", 2);
        f25990c = r6;
        ?? r7 = new Enum("NULL", 3);
        f25991d = r7;
        f25992e = new EnumC1763rj[]{r4, r5, r6, r7};
    }

    public static EnumC1763rj valueOf(String str) {
        return (EnumC1763rj) Enum.valueOf(EnumC1763rj.class, str);
    }

    public static EnumC1763rj[] values() {
        return (EnumC1763rj[]) f25992e.clone();
    }
}
