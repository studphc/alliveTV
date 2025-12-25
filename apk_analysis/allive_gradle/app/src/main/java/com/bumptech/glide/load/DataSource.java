package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class DataSource {
    public static final DataSource DATA_DISK_CACHE;
    public static final DataSource LOCAL;
    public static final DataSource MEMORY_CACHE;
    public static final DataSource REMOTE;
    public static final DataSource RESOURCE_DISK_CACHE;

    /* renamed from: a */
    public static final /* synthetic */ DataSource[] f8621a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Enum, com.bumptech.glide.load.DataSource] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, com.bumptech.glide.load.DataSource] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, com.bumptech.glide.load.DataSource] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, com.bumptech.glide.load.DataSource] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, com.bumptech.glide.load.DataSource] */
    static {
        ?? r5 = new Enum("LOCAL", 0);
        LOCAL = r5;
        ?? r6 = new Enum("REMOTE", 1);
        REMOTE = r6;
        ?? r7 = new Enum("DATA_DISK_CACHE", 2);
        DATA_DISK_CACHE = r7;
        ?? r8 = new Enum("RESOURCE_DISK_CACHE", 3);
        RESOURCE_DISK_CACHE = r8;
        ?? r9 = new Enum("MEMORY_CACHE", 4);
        MEMORY_CACHE = r9;
        f8621a = new DataSource[]{r5, r6, r7, r8, r9};
    }

    public static DataSource valueOf(String str) {
        return (DataSource) Enum.valueOf(DataSource.class, str);
    }

    public static DataSource[] values() {
        return (DataSource[]) f8621a.clone();
    }
}
