package org.checkerframework.framework.qual;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class TypeUseLocation {
    public static final TypeUseLocation ALL;
    public static final TypeUseLocation CONSTRUCTOR_RESULT;
    public static final TypeUseLocation EXCEPTION_PARAMETER;
    public static final TypeUseLocation EXPLICIT_LOWER_BOUND;
    public static final TypeUseLocation EXPLICIT_UPPER_BOUND;
    public static final TypeUseLocation FIELD;
    public static final TypeUseLocation IMPLICIT_LOWER_BOUND;
    public static final TypeUseLocation IMPLICIT_UPPER_BOUND;
    public static final TypeUseLocation LOCAL_VARIABLE;
    public static final TypeUseLocation LOWER_BOUND;
    public static final TypeUseLocation OTHERWISE;
    public static final TypeUseLocation PARAMETER;
    public static final TypeUseLocation RECEIVER;
    public static final TypeUseLocation RESOURCE_VARIABLE;
    public static final TypeUseLocation RETURN;
    public static final TypeUseLocation UPPER_BOUND;

    /* renamed from: a */
    public static final /* synthetic */ TypeUseLocation[] f24890a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeUseLocation] */
    static {
        ?? r0 = new Enum("FIELD", 0);
        FIELD = r0;
        ?? r1 = new Enum("LOCAL_VARIABLE", 1);
        LOCAL_VARIABLE = r1;
        ?? r15 = new Enum("RESOURCE_VARIABLE", 2);
        RESOURCE_VARIABLE = r15;
        ?? r14 = new Enum("EXCEPTION_PARAMETER", 3);
        EXCEPTION_PARAMETER = r14;
        ?? r13 = new Enum("RECEIVER", 4);
        RECEIVER = r13;
        ?? r12 = new Enum("PARAMETER", 5);
        PARAMETER = r12;
        ?? r11 = new Enum("RETURN", 6);
        RETURN = r11;
        ?? r10 = new Enum("CONSTRUCTOR_RESULT", 7);
        CONSTRUCTOR_RESULT = r10;
        ?? r9 = new Enum("LOWER_BOUND", 8);
        LOWER_BOUND = r9;
        ?? r8 = new Enum("EXPLICIT_LOWER_BOUND", 9);
        EXPLICIT_LOWER_BOUND = r8;
        ?? r7 = new Enum("IMPLICIT_LOWER_BOUND", 10);
        IMPLICIT_LOWER_BOUND = r7;
        ?? r6 = new Enum("UPPER_BOUND", 11);
        UPPER_BOUND = r6;
        ?? r5 = new Enum("EXPLICIT_UPPER_BOUND", 12);
        EXPLICIT_UPPER_BOUND = r5;
        ?? r4 = new Enum("IMPLICIT_UPPER_BOUND", 13);
        IMPLICIT_UPPER_BOUND = r4;
        ?? r3 = new Enum("OTHERWISE", 14);
        OTHERWISE = r3;
        ?? r2 = new Enum("ALL", 15);
        ALL = r2;
        f24890a = new TypeUseLocation[]{r0, r1, r15, r14, r13, r12, r11, r10, r9, r8, r7, r6, r5, r4, r3, r2};
    }

    public static TypeUseLocation valueOf(String str) {
        return (TypeUseLocation) Enum.valueOf(TypeUseLocation.class, str);
    }

    public static TypeUseLocation[] values() {
        return (TypeUseLocation[]) f24890a.clone();
    }
}
