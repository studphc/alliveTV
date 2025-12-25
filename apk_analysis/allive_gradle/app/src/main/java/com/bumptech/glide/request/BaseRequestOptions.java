package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {

    /* renamed from: a */
    public int f9008a;

    /* renamed from: e */
    public Drawable f9012e;

    /* renamed from: f */
    public int f9013f;

    /* renamed from: g */
    public Drawable f9014g;

    /* renamed from: h */
    public int f9015h;

    /* renamed from: m */
    public boolean f9020m;

    /* renamed from: o */
    public Drawable f9022o;

    /* renamed from: p */
    public int f9023p;

    /* renamed from: t */
    public boolean f9027t;

    /* renamed from: u */
    public Resources.Theme f9028u;

    /* renamed from: v */
    public boolean f9029v;

    /* renamed from: w */
    public boolean f9030w;

    /* renamed from: x */
    public boolean f9031x;

    /* renamed from: z */
    public boolean f9033z;

    /* renamed from: b */
    public float f9009b = 1.0f;

    /* renamed from: c */
    public DiskCacheStrategy f9010c = DiskCacheStrategy.AUTOMATIC;

    /* renamed from: d */
    public Priority f9011d = Priority.NORMAL;

    /* renamed from: i */
    public boolean f9016i = true;

    /* renamed from: j */
    public int f9017j = -1;

    /* renamed from: k */
    public int f9018k = -1;

    /* renamed from: l */
    public Key f9019l = EmptySignature.obtain();

    /* renamed from: n */
    public boolean f9021n = true;

    /* renamed from: q */
    public Options f9024q = new Options();

    /* renamed from: r */
    public CachedHashCodeArrayMap f9025r = new CachedHashCodeArrayMap();

    /* renamed from: s */
    public Class f9026s = Object.class;

    /* renamed from: y */
    public boolean f9032y = true;

    /* renamed from: a */
    public static boolean m2379a(int i, int i2) {
        return (i & i2) != 0;
    }

    @NonNull
    @CheckResult
    public T apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        if (this.f9029v) {
            return (T) mo8485clone().apply(baseRequestOptions);
        }
        if (m2379a(baseRequestOptions.f9008a, 2)) {
            this.f9009b = baseRequestOptions.f9009b;
        }
        if (m2379a(baseRequestOptions.f9008a, 262144)) {
            this.f9030w = baseRequestOptions.f9030w;
        }
        if (m2379a(baseRequestOptions.f9008a, 1048576)) {
            this.f9033z = baseRequestOptions.f9033z;
        }
        if (m2379a(baseRequestOptions.f9008a, 4)) {
            this.f9010c = baseRequestOptions.f9010c;
        }
        if (m2379a(baseRequestOptions.f9008a, 8)) {
            this.f9011d = baseRequestOptions.f9011d;
        }
        if (m2379a(baseRequestOptions.f9008a, 16)) {
            this.f9012e = baseRequestOptions.f9012e;
            this.f9013f = 0;
            this.f9008a &= -33;
        }
        if (m2379a(baseRequestOptions.f9008a, 32)) {
            this.f9013f = baseRequestOptions.f9013f;
            this.f9012e = null;
            this.f9008a &= -17;
        }
        if (m2379a(baseRequestOptions.f9008a, 64)) {
            this.f9014g = baseRequestOptions.f9014g;
            this.f9015h = 0;
            this.f9008a &= -129;
        }
        if (m2379a(baseRequestOptions.f9008a, 128)) {
            this.f9015h = baseRequestOptions.f9015h;
            this.f9014g = null;
            this.f9008a &= -65;
        }
        if (m2379a(baseRequestOptions.f9008a, 256)) {
            this.f9016i = baseRequestOptions.f9016i;
        }
        if (m2379a(baseRequestOptions.f9008a, 512)) {
            this.f9018k = baseRequestOptions.f9018k;
            this.f9017j = baseRequestOptions.f9017j;
        }
        if (m2379a(baseRequestOptions.f9008a, 1024)) {
            this.f9019l = baseRequestOptions.f9019l;
        }
        if (m2379a(baseRequestOptions.f9008a, 4096)) {
            this.f9026s = baseRequestOptions.f9026s;
        }
        if (m2379a(baseRequestOptions.f9008a, 8192)) {
            this.f9022o = baseRequestOptions.f9022o;
            this.f9023p = 0;
            this.f9008a &= -16385;
        }
        if (m2379a(baseRequestOptions.f9008a, 16384)) {
            this.f9023p = baseRequestOptions.f9023p;
            this.f9022o = null;
            this.f9008a &= -8193;
        }
        if (m2379a(baseRequestOptions.f9008a, 32768)) {
            this.f9028u = baseRequestOptions.f9028u;
        }
        if (m2379a(baseRequestOptions.f9008a, 65536)) {
            this.f9021n = baseRequestOptions.f9021n;
        }
        if (m2379a(baseRequestOptions.f9008a, 131072)) {
            this.f9020m = baseRequestOptions.f9020m;
        }
        if (m2379a(baseRequestOptions.f9008a, 2048)) {
            this.f9025r.putAll((Map) baseRequestOptions.f9025r);
            this.f9032y = baseRequestOptions.f9032y;
        }
        if (m2379a(baseRequestOptions.f9008a, 524288)) {
            this.f9031x = baseRequestOptions.f9031x;
        }
        if (!this.f9021n) {
            this.f9025r.clear();
            int i = this.f9008a;
            this.f9020m = false;
            this.f9008a = i & (-133121);
            this.f9032y = true;
        }
        this.f9008a |= baseRequestOptions.f9008a;
        this.f9024q.putAll(baseRequestOptions.f9024q);
        return selfOrThrowIfLocked();
    }

    @NonNull
    public T autoClone() {
        if (this.f9027t && !this.f9029v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f9029v = true;
        return lock();
    }

    /* renamed from: b */
    public final BaseRequestOptions m2380b(DownsampleStrategy downsampleStrategy, BitmapTransformation bitmapTransformation) {
        if (this.f9029v) {
            return mo8485clone().m2380b(downsampleStrategy, bitmapTransformation);
        }
        downsample(downsampleStrategy);
        return m2382d(bitmapTransformation, false);
    }

    /* renamed from: c */
    public final BaseRequestOptions m2381c(DownsampleStrategy downsampleStrategy, BitmapTransformation bitmapTransformation, boolean z) {
        BaseRequestOptions m2380b;
        if (z) {
            m2380b = m2383e(downsampleStrategy, bitmapTransformation);
        } else {
            m2380b = m2380b(downsampleStrategy, bitmapTransformation);
        }
        m2380b.f9032y = true;
        return m2380b;
    }

    @NonNull
    @CheckResult
    public T centerCrop() {
        return (T) m2383e(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public T centerInside() {
        return (T) m2381c(DownsampleStrategy.CENTER_INSIDE, new CenterInside(), true);
    }

    @NonNull
    @CheckResult
    public T circleCrop() {
        return (T) m2383e(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    /* renamed from: d */
    public final BaseRequestOptions m2382d(Transformation transformation, boolean z) {
        if (this.f9029v) {
            return mo8485clone().m2382d(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        m2384f(Bitmap.class, transformation, z);
        m2384f(Drawable.class, drawableTransformation, z);
        m2384f(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
        m2384f(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T decode(@NonNull Class<?> cls) {
        if (this.f9029v) {
            return (T) mo8485clone().decode(cls);
        }
        this.f9026s = (Class) Preconditions.checkNotNull(cls);
        this.f9008a |= 4096;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T disallowHardwareConfig() {
        return set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public T diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (this.f9029v) {
            return (T) mo8485clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.f9010c = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
        this.f9008a |= 4;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T dontAnimate() {
        return set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
    }

    @NonNull
    @CheckResult
    public T dontTransform() {
        if (this.f9029v) {
            return (T) mo8485clone().dontTransform();
        }
        this.f9025r.clear();
        int i = this.f9008a;
        this.f9020m = false;
        this.f9021n = false;
        this.f9008a = (i & (-133121)) | 65536;
        this.f9032y = true;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy));
    }

    /* renamed from: e */
    public final BaseRequestOptions m2383e(DownsampleStrategy downsampleStrategy, BitmapTransformation bitmapTransformation) {
        if (this.f9029v) {
            return mo8485clone().m2383e(downsampleStrategy, bitmapTransformation);
        }
        downsample(downsampleStrategy);
        return transform(bitmapTransformation);
    }

    @NonNull
    @CheckResult
    public T encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat));
    }

    @NonNull
    @CheckResult
    public T encodeQuality(@IntRange(from = 0, m153to = 100) int i) {
        return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        if (Float.compare(baseRequestOptions.f9009b, this.f9009b) != 0 || this.f9013f != baseRequestOptions.f9013f || !Util.bothNullOrEqual(this.f9012e, baseRequestOptions.f9012e) || this.f9015h != baseRequestOptions.f9015h || !Util.bothNullOrEqual(this.f9014g, baseRequestOptions.f9014g) || this.f9023p != baseRequestOptions.f9023p || !Util.bothNullOrEqual(this.f9022o, baseRequestOptions.f9022o) || this.f9016i != baseRequestOptions.f9016i || this.f9017j != baseRequestOptions.f9017j || this.f9018k != baseRequestOptions.f9018k || this.f9020m != baseRequestOptions.f9020m || this.f9021n != baseRequestOptions.f9021n || this.f9030w != baseRequestOptions.f9030w || this.f9031x != baseRequestOptions.f9031x || !this.f9010c.equals(baseRequestOptions.f9010c) || this.f9011d != baseRequestOptions.f9011d || !this.f9024q.equals(baseRequestOptions.f9024q) || !this.f9025r.equals(baseRequestOptions.f9025r) || !this.f9026s.equals(baseRequestOptions.f9026s) || !Util.bothNullOrEqual(this.f9019l, baseRequestOptions.f9019l) || !Util.bothNullOrEqual(this.f9028u, baseRequestOptions.f9028u)) {
            return false;
        }
        return true;
    }

    @NonNull
    @CheckResult
    public T error(@Nullable Drawable drawable) {
        if (this.f9029v) {
            return (T) mo8485clone().error(drawable);
        }
        this.f9012e = drawable;
        int i = this.f9008a | 16;
        this.f9013f = 0;
        this.f9008a = i & (-33);
        return selfOrThrowIfLocked();
    }

    /* renamed from: f */
    public final BaseRequestOptions m2384f(Class cls, Transformation transformation, boolean z) {
        if (this.f9029v) {
            return mo8485clone().m2384f(cls, transformation, z);
        }
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(transformation);
        this.f9025r.put(cls, transformation);
        int i = this.f9008a;
        this.f9021n = true;
        this.f9008a = 67584 | i;
        this.f9032y = false;
        if (z) {
            this.f9008a = i | 198656;
            this.f9020m = true;
        }
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T fallback(@Nullable Drawable drawable) {
        if (this.f9029v) {
            return (T) mo8485clone().fallback(drawable);
        }
        this.f9022o = drawable;
        int i = this.f9008a | 8192;
        this.f9023p = 0;
        this.f9008a = i & (-16385);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T fitCenter() {
        return (T) m2381c(DownsampleStrategy.FIT_CENTER, new FitCenter(), true);
    }

    @NonNull
    @CheckResult
    public T format(@NonNull DecodeFormat decodeFormat) {
        Preconditions.checkNotNull(decodeFormat);
        return (T) set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
    }

    @NonNull
    @CheckResult
    public T frame(@IntRange(from = 0) long j) {
        return set(VideoDecoder.TARGET_FRAME, Long.valueOf(j));
    }

    @NonNull
    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.f9010c;
    }

    public final int getErrorId() {
        return this.f9013f;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        return this.f9012e;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        return this.f9022o;
    }

    public final int getFallbackId() {
        return this.f9023p;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.f9031x;
    }

    @NonNull
    public final Options getOptions() {
        return this.f9024q;
    }

    public final int getOverrideHeight() {
        return this.f9017j;
    }

    public final int getOverrideWidth() {
        return this.f9018k;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        return this.f9014g;
    }

    public final int getPlaceholderId() {
        return this.f9015h;
    }

    @NonNull
    public final Priority getPriority() {
        return this.f9011d;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        return this.f9026s;
    }

    @NonNull
    public final Key getSignature() {
        return this.f9019l;
    }

    public final float getSizeMultiplier() {
        return this.f9009b;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        return this.f9028u;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.f9025r;
    }

    public final boolean getUseAnimationPool() {
        return this.f9033z;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.f9030w;
    }

    public int hashCode() {
        return Util.hashCode(this.f9028u, Util.hashCode(this.f9019l, Util.hashCode(this.f9026s, Util.hashCode(this.f9025r, Util.hashCode(this.f9024q, Util.hashCode(this.f9011d, Util.hashCode(this.f9010c, Util.hashCode(this.f9031x, Util.hashCode(this.f9030w, Util.hashCode(this.f9021n, Util.hashCode(this.f9020m, Util.hashCode(this.f9018k, Util.hashCode(this.f9017j, Util.hashCode(this.f9016i, Util.hashCode(this.f9022o, Util.hashCode(this.f9023p, Util.hashCode(this.f9014g, Util.hashCode(this.f9015h, Util.hashCode(this.f9012e, Util.hashCode(this.f9013f, Util.hashCode(this.f9009b)))))))))))))))))))));
    }

    public final boolean isAutoCloneEnabled() {
        return this.f9029v;
    }

    public final boolean isDiskCacheStrategySet() {
        return m2379a(this.f9008a, 4);
    }

    public final boolean isLocked() {
        return this.f9027t;
    }

    public final boolean isMemoryCacheable() {
        return this.f9016i;
    }

    public final boolean isPrioritySet() {
        return m2379a(this.f9008a, 8);
    }

    public final boolean isSkipMemoryCacheSet() {
        return m2379a(this.f9008a, 256);
    }

    public final boolean isTransformationAllowed() {
        return this.f9021n;
    }

    public final boolean isTransformationRequired() {
        return this.f9020m;
    }

    public final boolean isTransformationSet() {
        return m2379a(this.f9008a, 2048);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.f9018k, this.f9017j);
    }

    @NonNull
    public T lock() {
        this.f9027t = true;
        return this;
    }

    @NonNull
    @CheckResult
    public T onlyRetrieveFromCache(boolean z) {
        if (this.f9029v) {
            return (T) mo8485clone().onlyRetrieveFromCache(z);
        }
        this.f9031x = z;
        this.f9008a |= 524288;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T optionalCenterCrop() {
        return (T) m2380b(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @NonNull
    @CheckResult
    public T optionalCenterInside() {
        return (T) m2381c(DownsampleStrategy.CENTER_INSIDE, new CenterInside(), false);
    }

    @NonNull
    @CheckResult
    public T optionalCircleCrop() {
        return (T) m2380b(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    @NonNull
    @CheckResult
    public T optionalFitCenter() {
        return (T) m2381c(DownsampleStrategy.FIT_CENTER, new FitCenter(), false);
    }

    @NonNull
    @CheckResult
    public T optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (T) m2382d(transformation, false);
    }

    @NonNull
    @CheckResult
    public T override(int i, int i2) {
        if (this.f9029v) {
            return (T) mo8485clone().override(i, i2);
        }
        this.f9018k = i;
        this.f9017j = i2;
        this.f9008a |= 512;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T placeholder(@Nullable Drawable drawable) {
        if (this.f9029v) {
            return (T) mo8485clone().placeholder(drawable);
        }
        this.f9014g = drawable;
        int i = this.f9008a | 64;
        this.f9015h = 0;
        this.f9008a = i & (-129);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T priority(@NonNull Priority priority) {
        if (this.f9029v) {
            return (T) mo8485clone().priority(priority);
        }
        this.f9011d = (Priority) Preconditions.checkNotNull(priority);
        this.f9008a |= 8;
        return selfOrThrowIfLocked();
    }

    @NonNull
    public final T selfOrThrowIfLocked() {
        if (!this.f9027t) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    @NonNull
    @CheckResult
    public <Y> T set(@NonNull Option<Y> option, @NonNull Y y) {
        if (this.f9029v) {
            return (T) mo8485clone().set(option, y);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(y);
        this.f9024q.set(option, y);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T signature(@NonNull Key key) {
        if (this.f9029v) {
            return (T) mo8485clone().signature(key);
        }
        this.f9019l = (Key) Preconditions.checkNotNull(key);
        this.f9008a |= 1024;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T sizeMultiplier(@FloatRange(from = 0.0d, m152to = 1.0d) float f) {
        if (this.f9029v) {
            return (T) mo8485clone().sizeMultiplier(f);
        }
        if (f >= RecyclerView.f7068F0 && f <= 1.0f) {
            this.f9009b = f;
            this.f9008a |= 2;
            return selfOrThrowIfLocked();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    public T skipMemoryCache(boolean z) {
        if (this.f9029v) {
            return (T) mo8485clone().skipMemoryCache(true);
        }
        this.f9016i = !z;
        this.f9008a |= 256;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T theme(@Nullable Resources.Theme theme) {
        if (this.f9029v) {
            return (T) mo8485clone().theme(theme);
        }
        this.f9028u = theme;
        this.f9008a |= 32768;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T timeout(@IntRange(from = 0) int i) {
        return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i));
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap> transformation) {
        return (T) m2382d(transformation, true);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (T) m2382d(new MultiTransformation(transformationArr), true);
    }

    @NonNull
    @CheckResult
    public T useAnimationPool(boolean z) {
        if (this.f9029v) {
            return (T) mo8485clone().useAnimationPool(z);
        }
        this.f9033z = z;
        this.f9008a |= 1048576;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T useUnlimitedSourceGeneratorsPool(boolean z) {
        if (this.f9029v) {
            return (T) mo8485clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.f9030w = z;
        this.f9008a |= 262144;
        return selfOrThrowIfLocked();
    }

    @Override // 
    @CheckResult
    /* renamed from: clone */
    public T mo8485clone() {
        try {
            T t = (T) super.clone();
            Options options = new Options();
            t.f9024q = options;
            options.putAll(this.f9024q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.f9025r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll((Map) this.f9025r);
            t.f9027t = false;
            t.f9029v = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    @CheckResult
    public <Y> T optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (T) m2384f(cls, transformation, false);
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return (T) m2382d(new MultiTransformation(transformationArr), true);
        }
        if (transformationArr.length == 1) {
            return transform(transformationArr[0]);
        }
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T override(int i) {
        return override(i, i);
    }

    @NonNull
    @CheckResult
    public <Y> T transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (T) m2384f(cls, transformation, true);
    }

    @NonNull
    @CheckResult
    public T error(@DrawableRes int i) {
        if (this.f9029v) {
            return (T) mo8485clone().error(i);
        }
        this.f9013f = i;
        int i2 = this.f9008a | 32;
        this.f9012e = null;
        this.f9008a = i2 & (-17);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T fallback(@DrawableRes int i) {
        if (this.f9029v) {
            return (T) mo8485clone().fallback(i);
        }
        this.f9023p = i;
        int i2 = this.f9008a | 16384;
        this.f9022o = null;
        this.f9008a = i2 & (-8193);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T placeholder(@DrawableRes int i) {
        if (this.f9029v) {
            return (T) mo8485clone().placeholder(i);
        }
        this.f9015h = i;
        int i2 = this.f9008a | 128;
        this.f9014g = null;
        this.f9008a = i2 & (-65);
        return selfOrThrowIfLocked();
    }
}
