package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class ve1 {

    /* renamed from: a */
    public static final ve1 f27752a;

    /* renamed from: b */
    public static final /* synthetic */ ve1[] f27753b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [ve1, java.lang.Enum] */
    static {
        ?? r1 = new Enum("VALUE", 0);
        f27752a = r1;
        f27753b = new ve1[]{r1};
    }

    public static ve1 valueOf(String str) {
        return (ve1) Enum.valueOf(ve1.class, str);
    }

    public static ve1[] values() {
        return (ve1[]) f27753b.clone();
    }
}
