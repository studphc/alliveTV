package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: vp */
/* loaded from: classes2.dex */
public final class EnumC1917vp {

    /* renamed from: a */
    public static final EnumC1917vp f27904a;

    /* renamed from: b */
    public static final EnumC1917vp f27905b;

    /* renamed from: c */
    public static final EnumC1917vp f27906c;

    /* renamed from: d */
    public static final EnumC1917vp f27907d;

    /* renamed from: e */
    public static final EnumC1917vp f27908e;

    /* renamed from: f */
    public static final EnumC1917vp f27909f;

    /* renamed from: g */
    public static final /* synthetic */ EnumC1917vp[] f27910g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, vp] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, vp] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Enum, vp] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, vp] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, vp] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, vp] */
    static {
        ?? r6 = new Enum("OPEN", 0);
        f27904a = r6;
        ?? r7 = new Enum("SUBSUMED", 1);
        f27905b = r7;
        ?? r8 = new Enum("WILL_CLOSE", 2);
        f27906c = r8;
        ?? r9 = new Enum("CLOSING", 3);
        f27907d = r9;
        ?? r10 = new Enum("CLOSED", 4);
        f27908e = r10;
        ?? r11 = new Enum("WILL_CREATE_VALUE_AND_CLOSER", 5);
        f27909f = r11;
        f27910g = new EnumC1917vp[]{r6, r7, r8, r9, r10, r11};
    }

    public static EnumC1917vp valueOf(String str) {
        return (EnumC1917vp) Enum.valueOf(EnumC1917vp.class, str);
    }

    public static EnumC1917vp[] values() {
        return (EnumC1917vp[]) f27910g.clone();
    }
}
