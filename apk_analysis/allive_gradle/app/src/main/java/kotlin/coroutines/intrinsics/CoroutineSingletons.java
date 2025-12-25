package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlin/coroutines/intrinsics/CoroutineSingletons;", "", "COROUTINE_SUSPENDED", "UNDECIDED", "RESUMED", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@PublishedApi
/* loaded from: classes2.dex */
public final class CoroutineSingletons {
    public static final CoroutineSingletons COROUTINE_SUSPENDED;
    public static final CoroutineSingletons RESUMED;
    public static final CoroutineSingletons UNDECIDED;

    /* renamed from: a */
    public static final /* synthetic */ CoroutineSingletons[] f21081a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, kotlin.coroutines.intrinsics.CoroutineSingletons] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, kotlin.coroutines.intrinsics.CoroutineSingletons] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlin.coroutines.intrinsics.CoroutineSingletons] */
    static {
        ?? r3 = new Enum("COROUTINE_SUSPENDED", 0);
        COROUTINE_SUSPENDED = r3;
        ?? r4 = new Enum("UNDECIDED", 1);
        UNDECIDED = r4;
        ?? r5 = new Enum("RESUMED", 2);
        RESUMED = r5;
        f21081a = new CoroutineSingletons[]{r3, r4, r5};
    }

    public static CoroutineSingletons valueOf(String str) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, str);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[]) f21081a.clone();
    }
}
