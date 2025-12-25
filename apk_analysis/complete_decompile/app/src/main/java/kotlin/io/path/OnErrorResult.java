package kotlin.io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(version = "1.8")
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, m5569d2 = {"Lkotlin/io/path/OnErrorResult;", "", "SKIP_SUBTREE", "TERMINATE", "kotlin-stdlib-jdk7"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalPathApi
/* loaded from: classes2.dex */
public final class OnErrorResult {
    public static final OnErrorResult SKIP_SUBTREE;
    public static final OnErrorResult TERMINATE;

    /* renamed from: a */
    public static final /* synthetic */ OnErrorResult[] f21149a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, kotlin.io.path.OnErrorResult] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, kotlin.io.path.OnErrorResult] */
    static {
        ?? r2 = new Enum("SKIP_SUBTREE", 0);
        SKIP_SUBTREE = r2;
        ?? r3 = new Enum("TERMINATE", 1);
        TERMINATE = r3;
        f21149a = new OnErrorResult[]{r2, r3};
    }

    public static OnErrorResult valueOf(String str) {
        return (OnErrorResult) Enum.valueOf(OnErrorResult.class, str);
    }

    public static OnErrorResult[] values() {
        return (OnErrorResult[]) f21149a.clone();
    }
}
