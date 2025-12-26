package kotlin.contracts;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(version = "1.3")
@ContractsDsl
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5569d2 = {"Lkotlin/contracts/InvocationKind;", "", "AT_MOST_ONCE", "AT_LEAST_ONCE", "EXACTLY_ONCE", "UNKNOWN", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalContracts
/* loaded from: classes2.dex */
public final class InvocationKind {

    @ContractsDsl
    public static final InvocationKind AT_LEAST_ONCE;

    @ContractsDsl
    public static final InvocationKind AT_MOST_ONCE;

    @ContractsDsl
    public static final InvocationKind EXACTLY_ONCE;

    @ContractsDsl
    public static final InvocationKind UNKNOWN;

    /* renamed from: a */
    public static final /* synthetic */ InvocationKind[] f21069a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, kotlin.contracts.InvocationKind] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlin.contracts.InvocationKind] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, kotlin.contracts.InvocationKind] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, kotlin.contracts.InvocationKind] */
    static {
        ?? r4 = new Enum("AT_MOST_ONCE", 0);
        AT_MOST_ONCE = r4;
        ?? r5 = new Enum("AT_LEAST_ONCE", 1);
        AT_LEAST_ONCE = r5;
        ?? r6 = new Enum("EXACTLY_ONCE", 2);
        EXACTLY_ONCE = r6;
        ?? r7 = new Enum("UNKNOWN", 3);
        UNKNOWN = r7;
        f21069a = new InvocationKind[]{r4, r5, r6, r7};
    }

    public static InvocationKind valueOf(String str) {
        return (InvocationKind) Enum.valueOf(InvocationKind.class, str);
    }

    public static InvocationKind[] values() {
        return (InvocationKind[]) f21069a.clone();
    }
}
