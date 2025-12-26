package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class kp1 {

    /* renamed from: a */
    public static final kp1 f22135a;

    /* renamed from: b */
    public static final kp1 f22136b;

    /* renamed from: c */
    public static final kp1 f22137c;

    /* renamed from: d */
    public static final kp1 f22138d;

    /* renamed from: e */
    public static final /* synthetic */ kp1[] f22139e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, kp1] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kp1] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, kp1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, kp1] */
    static {
        ?? r4 = new Enum("UNDEFINED", 0);
        f22135a = r4;
        ?? r5 = new Enum("SETUP", 1);
        f22136b = r5;
        ?? r6 = new Enum("MOVING", 2);
        f22137c = r6;
        ?? r7 = new Enum("FINISHED", 3);
        f22138d = r7;
        f22139e = new kp1[]{r4, r5, r6, r7};
    }

    public static kp1 valueOf(String str) {
        return (kp1) Enum.valueOf(kp1.class, str);
    }

    public static kp1[] values() {
        return (kp1[]) f22139e.clone();
    }
}
