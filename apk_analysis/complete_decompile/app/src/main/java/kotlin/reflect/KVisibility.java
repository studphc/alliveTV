package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(version = "1.1")
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5569d2 = {"Lkotlin/reflect/KVisibility;", "", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class KVisibility {
    public static final KVisibility INTERNAL;
    public static final KVisibility PRIVATE;
    public static final KVisibility PROTECTED;
    public static final KVisibility PUBLIC;

    /* renamed from: a */
    public static final /* synthetic */ KVisibility[] f21249a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.reflect.KVisibility, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.reflect.KVisibility, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlin.reflect.KVisibility, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlin.reflect.KVisibility, java.lang.Enum] */
    static {
        ?? r4 = new Enum("PUBLIC", 0);
        PUBLIC = r4;
        ?? r5 = new Enum("PROTECTED", 1);
        PROTECTED = r5;
        ?? r6 = new Enum("INTERNAL", 2);
        INTERNAL = r6;
        ?? r7 = new Enum("PRIVATE", 3);
        PRIVATE = r7;
        f21249a = new KVisibility[]{r4, r5, r6, r7};
    }

    public static KVisibility valueOf(String str) {
        return (KVisibility) Enum.valueOf(KVisibility.class, str);
    }

    public static KVisibility[] values() {
        return (KVisibility[]) f21249a.clone();
    }
}
