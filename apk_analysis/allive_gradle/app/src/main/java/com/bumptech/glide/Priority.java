package com.bumptech.glide;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Priority {
    public static final Priority HIGH;
    public static final Priority IMMEDIATE;
    public static final Priority LOW;
    public static final Priority NORMAL;

    /* renamed from: a */
    public static final /* synthetic */ Priority[] f8505a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, com.bumptech.glide.Priority] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, com.bumptech.glide.Priority] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, com.bumptech.glide.Priority] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, com.bumptech.glide.Priority] */
    static {
        ?? r4 = new Enum("IMMEDIATE", 0);
        IMMEDIATE = r4;
        ?? r5 = new Enum("HIGH", 1);
        HIGH = r5;
        ?? r6 = new Enum("NORMAL", 2);
        NORMAL = r6;
        ?? r7 = new Enum("LOW", 3);
        LOW = r7;
        f8505a = new Priority[]{r4, r5, r6, r7};
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) f8505a.clone();
    }
}
