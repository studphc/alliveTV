package org.checkerframework.framework.qual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class LiteralKind {
    public static final LiteralKind ALL;
    public static final LiteralKind BOOLEAN;
    public static final LiteralKind CHAR;
    public static final LiteralKind DOUBLE;
    public static final LiteralKind FLOAT;
    public static final LiteralKind INT;
    public static final LiteralKind LONG;
    public static final LiteralKind NULL;
    public static final LiteralKind PRIMITIVE;
    public static final LiteralKind STRING;

    /* renamed from: a */
    public static final /* synthetic */ LiteralKind[] f24888a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r12v1, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r13v1, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r14v1, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r15v1, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v2, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r5v2, types: [org.checkerframework.framework.qual.LiteralKind, java.lang.Enum] */
    static {
        ?? r10 = new Enum("NULL", 0);
        NULL = r10;
        ?? r11 = new Enum("INT", 1);
        INT = r11;
        ?? r12 = new Enum("LONG", 2);
        LONG = r12;
        ?? r13 = new Enum("FLOAT", 3);
        FLOAT = r13;
        ?? r14 = new Enum("DOUBLE", 4);
        DOUBLE = r14;
        ?? r15 = new Enum("BOOLEAN", 5);
        BOOLEAN = r15;
        ?? r5 = new Enum("CHAR", 6);
        CHAR = r5;
        ?? r4 = new Enum("STRING", 7);
        STRING = r4;
        ?? r3 = new Enum("ALL", 8);
        ALL = r3;
        ?? r2 = new Enum("PRIMITIVE", 9);
        PRIMITIVE = r2;
        f24888a = new LiteralKind[]{r10, r11, r12, r13, r14, r15, r5, r4, r3, r2};
    }

    public static List<LiteralKind> allLiteralKinds() {
        ArrayList arrayList = new ArrayList(Arrays.asList(values()));
        arrayList.remove(ALL);
        arrayList.remove(PRIMITIVE);
        return arrayList;
    }

    public static List<LiteralKind> primitiveLiteralKinds() {
        return Arrays.asList(INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR);
    }

    public static LiteralKind valueOf(String str) {
        return (LiteralKind) Enum.valueOf(LiteralKind.class, str);
    }

    public static LiteralKind[] values() {
        return (LiteralKind[]) f24888a.clone();
    }
}
