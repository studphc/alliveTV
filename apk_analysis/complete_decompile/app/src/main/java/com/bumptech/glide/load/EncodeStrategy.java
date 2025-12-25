package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class EncodeStrategy {
    public static final EncodeStrategy NONE;
    public static final EncodeStrategy SOURCE;
    public static final EncodeStrategy TRANSFORMED;

    /* renamed from: a */
    public static final /* synthetic */ EncodeStrategy[] f8623a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, com.bumptech.glide.load.EncodeStrategy] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, com.bumptech.glide.load.EncodeStrategy] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, com.bumptech.glide.load.EncodeStrategy] */
    static {
        ?? r3 = new Enum("SOURCE", 0);
        SOURCE = r3;
        ?? r4 = new Enum("TRANSFORMED", 1);
        TRANSFORMED = r4;
        ?? r5 = new Enum("NONE", 2);
        NONE = r5;
        f8623a = new EncodeStrategy[]{r3, r4, r5};
    }

    public static EncodeStrategy valueOf(String str) {
        return (EncodeStrategy) Enum.valueOf(EncodeStrategy.class, str);
    }

    public static EncodeStrategy[] values() {
        return (EncodeStrategy[]) f8623a.clone();
    }
}
