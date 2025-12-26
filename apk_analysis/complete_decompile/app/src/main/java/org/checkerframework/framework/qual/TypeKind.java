package org.checkerframework.framework.qual;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class TypeKind {
    public static final TypeKind ARRAY;
    public static final TypeKind BOOLEAN;
    public static final TypeKind BYTE;
    public static final TypeKind CHAR;
    public static final TypeKind DECLARED;
    public static final TypeKind DOUBLE;
    public static final TypeKind ERROR;
    public static final TypeKind EXECUTABLE;
    public static final TypeKind FLOAT;
    public static final TypeKind INT;
    public static final TypeKind INTERSECTION;
    public static final TypeKind LONG;
    public static final TypeKind NONE;
    public static final TypeKind NULL;
    public static final TypeKind OTHER;
    public static final TypeKind PACKAGE;
    public static final TypeKind SHORT;
    public static final TypeKind TYPEVAR;
    public static final TypeKind UNION;
    public static final TypeKind VOID;
    public static final TypeKind WILDCARD;

    /* renamed from: a */
    public static final /* synthetic */ TypeKind[] f24889a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, org.checkerframework.framework.qual.TypeKind] */
    static {
        ?? r5 = new Enum("BOOLEAN", 0);
        BOOLEAN = r5;
        ?? r6 = new Enum("BYTE", 1);
        BYTE = r6;
        ?? r4 = new Enum("SHORT", 2);
        SHORT = r4;
        ?? r3 = new Enum("INT", 3);
        INT = r3;
        ?? r2 = new Enum("LONG", 4);
        LONG = r2;
        ?? r1 = new Enum("CHAR", 5);
        CHAR = r1;
        ?? r0 = new Enum("FLOAT", 6);
        FLOAT = r0;
        ?? r15 = new Enum("DOUBLE", 7);
        DOUBLE = r15;
        ?? r14 = new Enum("VOID", 8);
        VOID = r14;
        ?? r13 = new Enum("NONE", 9);
        NONE = r13;
        ?? r12 = new Enum("NULL", 10);
        NULL = r12;
        ?? r11 = new Enum("ARRAY", 11);
        ARRAY = r11;
        ?? r10 = new Enum("DECLARED", 12);
        DECLARED = r10;
        ?? r9 = new Enum("ERROR", 13);
        ERROR = r9;
        ?? r8 = new Enum("TYPEVAR", 14);
        TYPEVAR = r8;
        ?? r7 = new Enum("WILDCARD", 15);
        WILDCARD = r7;
        ?? r82 = new Enum("PACKAGE", 16);
        PACKAGE = r82;
        ?? r72 = new Enum("EXECUTABLE", 17);
        EXECUTABLE = r72;
        ?? r83 = new Enum("OTHER", 18);
        OTHER = r83;
        ?? r73 = new Enum("UNION", 19);
        UNION = r73;
        ?? r84 = new Enum("INTERSECTION", 20);
        INTERSECTION = r84;
        f24889a = new TypeKind[]{r5, r6, r4, r3, r2, r1, r0, r15, r14, r13, r12, r11, r10, r9, r8, r7, r82, r72, r83, r73, r84};
    }

    public static TypeKind valueOf(String str) {
        return (TypeKind) Enum.valueOf(TypeKind.class, str);
    }

    public static TypeKind[] values() {
        return (TypeKind[]) f24889a.clone();
    }
}
