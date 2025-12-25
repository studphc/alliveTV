package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

/* loaded from: classes.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy CENTER_OUTSIDE;
    public static final DownsampleStrategy DEFAULT;
    public static final DownsampleStrategy NONE;
    public static final Option<DownsampleStrategy> OPTION;

    /* renamed from: a */
    public static final boolean f8867a;
    public static final DownsampleStrategy AT_LEAST = new DownsampleStrategy();
    public static final DownsampleStrategy AT_MOST = new DownsampleStrategy();
    public static final DownsampleStrategy FIT_CENTER = new DownsampleStrategy();
    public static final DownsampleStrategy CENTER_INSIDE = new DownsampleStrategy();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class SampleSizeRounding {
        public static final SampleSizeRounding MEMORY;
        public static final SampleSizeRounding QUALITY;

        /* renamed from: a */
        public static final /* synthetic */ SampleSizeRounding[] f8868a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r3v1, types: [com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding, java.lang.Enum] */
        static {
            ?? r2 = new Enum("MEMORY", 0);
            MEMORY = r2;
            ?? r3 = new Enum("QUALITY", 1);
            QUALITY = r3;
            f8868a = new SampleSizeRounding[]{r2, r3};
        }

        public static SampleSizeRounding valueOf(String str) {
            return (SampleSizeRounding) Enum.valueOf(SampleSizeRounding.class, str);
        }

        public static SampleSizeRounding[] values() {
            return (SampleSizeRounding[]) f8868a.clone();
        }
    }

    static {
        DownsampleStrategy downsampleStrategy = new DownsampleStrategy();
        CENTER_OUTSIDE = downsampleStrategy;
        NONE = new DownsampleStrategy();
        DEFAULT = downsampleStrategy;
        OPTION = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy);
        f8867a = true;
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4);

    public abstract float getScaleFactor(int i, int i2, int i3, int i4);
}
