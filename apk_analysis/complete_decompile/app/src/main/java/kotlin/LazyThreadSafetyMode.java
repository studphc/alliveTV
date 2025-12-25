package kotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlin/LazyThreadSafetyMode;", "", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class LazyThreadSafetyMode {
    public static final LazyThreadSafetyMode NONE;
    public static final LazyThreadSafetyMode PUBLICATION;
    public static final LazyThreadSafetyMode SYNCHRONIZED;

    /* renamed from: a */
    public static final /* synthetic */ LazyThreadSafetyMode[] f20933a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.LazyThreadSafetyMode, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.LazyThreadSafetyMode, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.LazyThreadSafetyMode, java.lang.Enum] */
    static {
        ?? r3 = new Enum("SYNCHRONIZED", 0);
        SYNCHRONIZED = r3;
        ?? r4 = new Enum("PUBLICATION", 1);
        PUBLICATION = r4;
        ?? r5 = new Enum("NONE", 2);
        NONE = r5;
        f20933a = new LazyThreadSafetyMode[]{r3, r4, r5};
    }

    public static LazyThreadSafetyMode valueOf(String str) {
        return (LazyThreadSafetyMode) Enum.valueOf(LazyThreadSafetyMode.class, str);
    }

    public static LazyThreadSafetyMode[] values() {
        return (LazyThreadSafetyMode[]) f20933a.clone();
    }
}
