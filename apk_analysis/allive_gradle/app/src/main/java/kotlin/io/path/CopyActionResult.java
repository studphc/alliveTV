package kotlin.io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(version = "1.8")
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlin/io/path/CopyActionResult;", "", "CONTINUE", "SKIP_SUBTREE", "TERMINATE", "kotlin-stdlib-jdk7"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalPathApi
/* loaded from: classes2.dex */
public final class CopyActionResult {
    public static final CopyActionResult CONTINUE;
    public static final CopyActionResult SKIP_SUBTREE;
    public static final CopyActionResult TERMINATE;

    /* renamed from: a */
    public static final /* synthetic */ CopyActionResult[] f21139a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, kotlin.io.path.CopyActionResult] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, kotlin.io.path.CopyActionResult] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlin.io.path.CopyActionResult] */
    static {
        ?? r3 = new Enum("CONTINUE", 0);
        CONTINUE = r3;
        ?? r4 = new Enum("SKIP_SUBTREE", 1);
        SKIP_SUBTREE = r4;
        ?? r5 = new Enum("TERMINATE", 2);
        TERMINATE = r5;
        f21139a = new CopyActionResult[]{r3, r4, r5};
    }

    public static CopyActionResult valueOf(String str) {
        return (CopyActionResult) Enum.valueOf(CopyActionResult.class, str);
    }

    public static CopyActionResult[] values() {
        return (CopyActionResult[]) f21139a.clone();
    }
}
