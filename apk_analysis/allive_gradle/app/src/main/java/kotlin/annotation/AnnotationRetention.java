package kotlin.annotation;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlin/annotation/AnnotationRetention;", "", "SOURCE", "BINARY", "RUNTIME", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class AnnotationRetention {
    public static final AnnotationRetention BINARY;
    public static final AnnotationRetention RUNTIME;
    public static final AnnotationRetention SOURCE;

    /* renamed from: a */
    public static final /* synthetic */ AnnotationRetention[] f20951a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, kotlin.annotation.AnnotationRetention] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, kotlin.annotation.AnnotationRetention] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, kotlin.annotation.AnnotationRetention] */
    static {
        ?? r3 = new Enum("SOURCE", 0);
        SOURCE = r3;
        ?? r4 = new Enum("BINARY", 1);
        BINARY = r4;
        ?? r5 = new Enum("RUNTIME", 2);
        RUNTIME = r5;
        f20951a = new AnnotationRetention[]{r3, r4, r5};
    }

    public static AnnotationRetention valueOf(String str) {
        return (AnnotationRetention) Enum.valueOf(AnnotationRetention.class, str);
    }

    public static AnnotationRetention[] values() {
        return (AnnotationRetention[]) f20951a.clone();
    }
}
