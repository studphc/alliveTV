package kotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlin/DeprecationLevel;", "", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DeprecationLevel {
    public static final DeprecationLevel ERROR;
    public static final DeprecationLevel HIDDEN;
    public static final DeprecationLevel WARNING;

    /* renamed from: a */
    public static final /* synthetic */ DeprecationLevel[] f20927a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, kotlin.DeprecationLevel] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, kotlin.DeprecationLevel] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlin.DeprecationLevel] */
    static {
        ?? r3 = new Enum("WARNING", 0);
        WARNING = r3;
        ?? r4 = new Enum("ERROR", 1);
        ERROR = r4;
        ?? r5 = new Enum("HIDDEN", 2);
        HIDDEN = r5;
        f20927a = new DeprecationLevel[]{r3, r4, r5};
    }

    public static DeprecationLevel valueOf(String str) {
        return (DeprecationLevel) Enum.valueOf(DeprecationLevel.class, str);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[]) f20927a.clone();
    }
}
