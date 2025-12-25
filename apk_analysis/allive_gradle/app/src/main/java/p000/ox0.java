package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ox0 {

    /* renamed from: a */
    public static final ox0 f24941a;

    /* renamed from: b */
    public static final ox0 f24942b;

    /* renamed from: c */
    public static final /* synthetic */ ox0[] f24943c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, ox0] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, ox0] */
    static {
        ?? r2 = new Enum("PENDING", 0);
        f24941a = r2;
        ?? r3 = new Enum("COMPLETE", 1);
        f24942b = r3;
        f24943c = new ox0[]{r2, r3};
    }

    public static ox0 valueOf(String str) {
        return (ox0) Enum.valueOf(ox0.class, str);
    }

    public static ox0[] values() {
        return (ox0[]) f24943c.clone();
    }
}
