package kotlin.annotation;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, m5569d2 = {"Lkotlin/annotation/AnnotationTarget;", "", "CLASS", "ANNOTATION_CLASS", "TYPE_PARAMETER", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPE", "EXPRESSION", "FILE", "TYPEALIAS", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class AnnotationTarget {
    public static final AnnotationTarget ANNOTATION_CLASS;
    public static final AnnotationTarget CLASS;
    public static final AnnotationTarget CONSTRUCTOR;
    public static final AnnotationTarget EXPRESSION;
    public static final AnnotationTarget FIELD;
    public static final AnnotationTarget FILE;
    public static final AnnotationTarget FUNCTION;
    public static final AnnotationTarget LOCAL_VARIABLE;
    public static final AnnotationTarget PROPERTY;
    public static final AnnotationTarget PROPERTY_GETTER;
    public static final AnnotationTarget PROPERTY_SETTER;
    public static final AnnotationTarget TYPE;

    @SinceKotlin(version = "1.1")
    public static final AnnotationTarget TYPEALIAS;
    public static final AnnotationTarget TYPE_PARAMETER;
    public static final AnnotationTarget VALUE_PARAMETER;

    /* renamed from: a */
    public static final /* synthetic */ AnnotationTarget[] f20952a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, kotlin.annotation.AnnotationTarget] */
    static {
        ?? r15 = new Enum("CLASS", 0);
        CLASS = r15;
        ?? r0 = new Enum("ANNOTATION_CLASS", 1);
        ANNOTATION_CLASS = r0;
        ?? r14 = new Enum("TYPE_PARAMETER", 2);
        TYPE_PARAMETER = r14;
        ?? r13 = new Enum("PROPERTY", 3);
        PROPERTY = r13;
        ?? r12 = new Enum("FIELD", 4);
        FIELD = r12;
        ?? r11 = new Enum("LOCAL_VARIABLE", 5);
        LOCAL_VARIABLE = r11;
        ?? r10 = new Enum("VALUE_PARAMETER", 6);
        VALUE_PARAMETER = r10;
        ?? r9 = new Enum("CONSTRUCTOR", 7);
        CONSTRUCTOR = r9;
        ?? r8 = new Enum("FUNCTION", 8);
        FUNCTION = r8;
        ?? r7 = new Enum("PROPERTY_GETTER", 9);
        PROPERTY_GETTER = r7;
        ?? r6 = new Enum("PROPERTY_SETTER", 10);
        PROPERTY_SETTER = r6;
        ?? r5 = new Enum("TYPE", 11);
        TYPE = r5;
        ?? r4 = new Enum("EXPRESSION", 12);
        EXPRESSION = r4;
        ?? r3 = new Enum("FILE", 13);
        FILE = r3;
        ?? r2 = new Enum("TYPEALIAS", 14);
        TYPEALIAS = r2;
        f20952a = new AnnotationTarget[]{r15, r0, r14, r13, r12, r11, r10, r9, r8, r7, r6, r5, r4, r3, r2};
    }

    public static AnnotationTarget valueOf(String str) {
        return (AnnotationTarget) Enum.valueOf(AnnotationTarget.class, str);
    }

    public static AnnotationTarget[] values() {
        return (AnnotationTarget[]) f20952a.clone();
    }
}
