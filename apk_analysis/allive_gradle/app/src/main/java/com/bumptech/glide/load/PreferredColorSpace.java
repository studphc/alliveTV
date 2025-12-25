package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class PreferredColorSpace {
    public static final PreferredColorSpace DISPLAY_P3;
    public static final PreferredColorSpace SRGB;

    /* renamed from: a */
    public static final /* synthetic */ PreferredColorSpace[] f8633a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, com.bumptech.glide.load.PreferredColorSpace] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, com.bumptech.glide.load.PreferredColorSpace] */
    static {
        ?? r2 = new Enum("SRGB", 0);
        SRGB = r2;
        ?? r3 = new Enum("DISPLAY_P3", 1);
        DISPLAY_P3 = r3;
        f8633a = new PreferredColorSpace[]{r2, r3};
    }

    public static PreferredColorSpace valueOf(String str) {
        return (PreferredColorSpace) Enum.valueOf(PreferredColorSpace.class, str);
    }

    public static PreferredColorSpace[] values() {
        return (PreferredColorSpace[]) f8633a.clone();
    }
}
