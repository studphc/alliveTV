package kotlin.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(version = "1.2")
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlin/internal/RequireKotlinVersionKind;", "", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RequireKotlinVersionKind {
    public static final RequireKotlinVersionKind API_VERSION;
    public static final RequireKotlinVersionKind COMPILER_VERSION;
    public static final RequireKotlinVersionKind LANGUAGE_VERSION;

    /* renamed from: a */
    public static final /* synthetic */ RequireKotlinVersionKind[] f21102a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, kotlin.internal.RequireKotlinVersionKind] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, kotlin.internal.RequireKotlinVersionKind] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlin.internal.RequireKotlinVersionKind] */
    static {
        ?? r3 = new Enum("LANGUAGE_VERSION", 0);
        LANGUAGE_VERSION = r3;
        ?? r4 = new Enum("COMPILER_VERSION", 1);
        COMPILER_VERSION = r4;
        ?? r5 = new Enum("API_VERSION", 2);
        API_VERSION = r5;
        f21102a = new RequireKotlinVersionKind[]{r3, r4, r5};
    }

    public static RequireKotlinVersionKind valueOf(String str) {
        return (RequireKotlinVersionKind) Enum.valueOf(RequireKotlinVersionKind.class, str);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[]) f21102a.clone();
    }
}
