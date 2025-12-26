package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class me3 {

    /* renamed from: a */
    public static final me3 f22917a;

    /* renamed from: b */
    public static final me3 f22918b;

    /* renamed from: c */
    public static final /* synthetic */ me3[] f22919c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, me3] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, me3] */
    static {
        ?? r4 = new Enum("CONSENT", 0);
        f22917a = r4;
        Enum r5 = new Enum("LEGITIMATE_INTEREST", 1);
        Enum r6 = new Enum("FLEXIBLE_CONSENT", 2);
        ?? r7 = new Enum("FLEXIBLE_LEGITIMATE_INTEREST", 3);
        f22918b = r7;
        f22919c = new me3[]{r4, r5, r6, r7};
    }

    public static me3[] values() {
        return (me3[]) f22919c.clone();
    }
}
