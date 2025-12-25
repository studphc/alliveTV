package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class DecodeFormat {
    public static final DecodeFormat DEFAULT;
    public static final DecodeFormat PREFER_ARGB_8888;
    public static final DecodeFormat PREFER_RGB_565;

    /* renamed from: a */
    public static final /* synthetic */ DecodeFormat[] f8622a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bumptech.glide.load.DecodeFormat, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bumptech.glide.load.DecodeFormat, java.lang.Enum] */
    static {
        ?? r2 = new Enum("PREFER_ARGB_8888", 0);
        PREFER_ARGB_8888 = r2;
        ?? r3 = new Enum("PREFER_RGB_565", 1);
        PREFER_RGB_565 = r3;
        f8622a = new DecodeFormat[]{r2, r3};
        DEFAULT = r2;
    }

    public static DecodeFormat valueOf(String str) {
        return (DecodeFormat) Enum.valueOf(DecodeFormat.class, str);
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) f8622a.clone();
    }
}
