package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class na0 {

    /* renamed from: a */
    public static final na0 f23309a;

    /* renamed from: b */
    public static final na0 f23310b;

    /* renamed from: c */
    public static final na0 f23311c;

    /* renamed from: d */
    public static final /* synthetic */ na0[] f23312d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, na0] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, na0] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, na0] */
    static {
        ?? r3 = new Enum("NOT_RUN", 0);
        f23309a = r3;
        ?? r4 = new Enum("CANCELLED", 1);
        f23310b = r4;
        ?? r5 = new Enum("STARTED", 2);
        f23311c = r5;
        f23312d = new na0[]{r3, r4, r5};
    }

    public static na0 valueOf(String str) {
        return (na0) Enum.valueOf(na0.class, str);
    }

    public static na0[] values() {
        return (na0[]) f23312d.clone();
    }
}
