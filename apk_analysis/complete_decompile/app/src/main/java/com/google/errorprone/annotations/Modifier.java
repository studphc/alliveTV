package com.google.errorprone.annotations;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class Modifier {
    public static final Modifier ABSTRACT;
    public static final Modifier DEFAULT;
    public static final Modifier FINAL;
    public static final Modifier NATIVE;
    public static final Modifier PRIVATE;
    public static final Modifier PROTECTED;
    public static final Modifier PUBLIC;
    public static final Modifier STATIC;
    public static final Modifier STRICTFP;
    public static final Modifier SYNCHRONIZED;
    public static final Modifier TRANSIENT;
    public static final Modifier VOLATILE;

    /* renamed from: a */
    public static final /* synthetic */ Modifier[] f15450a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, com.google.errorprone.annotations.Modifier] */
    static {
        ?? r12 = new Enum("PUBLIC", 0);
        PUBLIC = r12;
        ?? r13 = new Enum("PROTECTED", 1);
        PROTECTED = r13;
        ?? r14 = new Enum("PRIVATE", 2);
        PRIVATE = r14;
        ?? r15 = new Enum("ABSTRACT", 3);
        ABSTRACT = r15;
        ?? r9 = new Enum("DEFAULT", 4);
        DEFAULT = r9;
        ?? r8 = new Enum("STATIC", 5);
        STATIC = r8;
        ?? r7 = new Enum("FINAL", 6);
        FINAL = r7;
        ?? r6 = new Enum("TRANSIENT", 7);
        TRANSIENT = r6;
        ?? r5 = new Enum("VOLATILE", 8);
        VOLATILE = r5;
        ?? r4 = new Enum("SYNCHRONIZED", 9);
        SYNCHRONIZED = r4;
        ?? r3 = new Enum("NATIVE", 10);
        NATIVE = r3;
        ?? r2 = new Enum("STRICTFP", 11);
        STRICTFP = r2;
        f15450a = new Modifier[]{r12, r13, r14, r15, r9, r8, r7, r6, r5, r4, r3, r2};
    }

    public static Modifier valueOf(String str) {
        return (Modifier) Enum.valueOf(Modifier.class, str);
    }

    public static Modifier[] values() {
        return (Modifier[]) f15450a.clone();
    }
}
