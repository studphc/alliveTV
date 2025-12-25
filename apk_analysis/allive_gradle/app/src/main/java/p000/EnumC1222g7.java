package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: g7 */
/* loaded from: classes2.dex */
public final class EnumC1222g7 {

    /* renamed from: a */
    public static final EnumC1222g7 f17564a;

    /* renamed from: b */
    public static final EnumC1222g7 f17565b;

    /* renamed from: c */
    public static final /* synthetic */ EnumC1222g7[] f17566c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [g7, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v1, types: [g7, java.lang.Enum] */
    static {
        ?? r2 = new Enum("OUTPUT_FUTURE_DONE", 0);
        f17564a = r2;
        ?? r3 = new Enum("ALL_INPUT_FUTURES_PROCESSED", 1);
        f17565b = r3;
        f17566c = new EnumC1222g7[]{r2, r3};
    }

    public static EnumC1222g7 valueOf(String str) {
        return (EnumC1222g7) Enum.valueOf(EnumC1222g7.class, str);
    }

    public static EnumC1222g7[] values() {
        return (EnumC1222g7[]) f17566c.clone();
    }
}
