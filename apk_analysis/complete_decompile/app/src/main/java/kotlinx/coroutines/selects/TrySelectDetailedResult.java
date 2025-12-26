package kotlinx.coroutines.selects;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5569d2 = {"Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "SUCCESSFUL", "REREGISTER", "CANCELLED", "ALREADY_SELECTED", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class TrySelectDetailedResult {
    public static final TrySelectDetailedResult ALREADY_SELECTED;
    public static final TrySelectDetailedResult CANCELLED;
    public static final TrySelectDetailedResult REREGISTER;
    public static final TrySelectDetailedResult SUCCESSFUL;

    /* renamed from: a */
    public static final /* synthetic */ TrySelectDetailedResult[] f22107a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, kotlinx.coroutines.selects.TrySelectDetailedResult] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlinx.coroutines.selects.TrySelectDetailedResult] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, kotlinx.coroutines.selects.TrySelectDetailedResult] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, kotlinx.coroutines.selects.TrySelectDetailedResult] */
    static {
        ?? r4 = new Enum("SUCCESSFUL", 0);
        SUCCESSFUL = r4;
        ?? r5 = new Enum("REREGISTER", 1);
        REREGISTER = r5;
        ?? r6 = new Enum("CANCELLED", 2);
        CANCELLED = r6;
        ?? r7 = new Enum("ALREADY_SELECTED", 3);
        ALREADY_SELECTED = r7;
        f22107a = new TrySelectDetailedResult[]{r4, r5, r6, r7};
    }

    public static TrySelectDetailedResult valueOf(String str) {
        return (TrySelectDetailedResult) Enum.valueOf(TrySelectDetailedResult.class, str);
    }

    public static TrySelectDetailedResult[] values() {
        return (TrySelectDetailedResult[]) f22107a.clone();
    }
}
