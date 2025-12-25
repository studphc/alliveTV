package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(version = "1.1")
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlin/reflect/KVariance;", "", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class KVariance {

    /* renamed from: IN */
    public static final KVariance f21247IN;
    public static final KVariance INVARIANT;
    public static final KVariance OUT;

    /* renamed from: a */
    public static final /* synthetic */ KVariance[] f21248a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, kotlin.reflect.KVariance] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, kotlin.reflect.KVariance] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlin.reflect.KVariance] */
    static {
        ?? r3 = new Enum("INVARIANT", 0);
        INVARIANT = r3;
        ?? r4 = new Enum("IN", 1);
        f21247IN = r4;
        ?? r5 = new Enum("OUT", 2);
        OUT = r5;
        f21248a = new KVariance[]{r3, r4, r5};
    }

    public static KVariance valueOf(String str) {
        return (KVariance) Enum.valueOf(KVariance.class, str);
    }

    public static KVariance[] values() {
        return (KVariance[]) f21248a.clone();
    }
}
