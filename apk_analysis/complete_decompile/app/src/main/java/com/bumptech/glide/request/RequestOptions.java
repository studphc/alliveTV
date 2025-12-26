package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* loaded from: classes.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {

    /* renamed from: A */
    public static RequestOptions f9050A;

    /* renamed from: B */
    public static RequestOptions f9051B;

    /* renamed from: C */
    public static RequestOptions f9052C;

    /* renamed from: D */
    public static RequestOptions f9053D;

    /* renamed from: E */
    public static RequestOptions f9054E;

    /* renamed from: F */
    public static RequestOptions f9055F;

    /* renamed from: G */
    public static RequestOptions f9056G;

    /* renamed from: H */
    public static RequestOptions f9057H;

    @NonNull
    @CheckResult
    public static RequestOptions bitmapTransform(@NonNull Transformation<Bitmap> transformation) {
        return new RequestOptions().transform(transformation);
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerCropTransform() {
        if (f9054E == null) {
            f9054E = new RequestOptions().centerCrop().autoClone();
        }
        return f9054E;
    }

    @NonNull
    @CheckResult
    public static RequestOptions centerInsideTransform() {
        if (f9053D == null) {
            f9053D = new RequestOptions().centerInside().autoClone();
        }
        return f9053D;
    }

    @NonNull
    @CheckResult
    public static RequestOptions circleCropTransform() {
        if (f9055F == null) {
            f9055F = new RequestOptions().circleCrop().autoClone();
        }
        return f9055F;
    }

    @NonNull
    @CheckResult
    public static RequestOptions decodeTypeOf(@NonNull Class<?> cls) {
        return new RequestOptions().decode(cls);
    }

    @NonNull
    @CheckResult
    public static RequestOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    @NonNull
    @CheckResult
    public static RequestOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        return new RequestOptions().downsample(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return new RequestOptions().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static RequestOptions encodeQualityOf(@IntRange(from = 0, m153to = 100) int i) {
        return new RequestOptions().encodeQuality(i);
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@Nullable Drawable drawable) {
        return new RequestOptions().error(drawable);
    }

    @NonNull
    @CheckResult
    public static RequestOptions fitCenterTransform() {
        if (f9052C == null) {
            f9052C = new RequestOptions().fitCenter().autoClone();
        }
        return f9052C;
    }

    @NonNull
    @CheckResult
    public static RequestOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        return new RequestOptions().format(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static RequestOptions frameOf(@IntRange(from = 0) long j) {
        return new RequestOptions().frame(j);
    }

    @NonNull
    @CheckResult
    public static RequestOptions noAnimation() {
        if (f9057H == null) {
            f9057H = new RequestOptions().dontAnimate().autoClone();
        }
        return f9057H;
    }

    @NonNull
    @CheckResult
    public static RequestOptions noTransformation() {
        if (f9056G == null) {
            f9056G = new RequestOptions().dontTransform().autoClone();
        }
        return f9056G;
    }

    @NonNull
    @CheckResult
    public static <T> RequestOptions option(@NonNull Option<T> option, @NonNull T t) {
        return new RequestOptions().set(option, t);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(int i, int i2) {
        return new RequestOptions().override(i, i2);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@Nullable Drawable drawable) {
        return new RequestOptions().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static RequestOptions priorityOf(@NonNull Priority priority) {
        return new RequestOptions().priority(priority);
    }

    @NonNull
    @CheckResult
    public static RequestOptions signatureOf(@NonNull Key key) {
        return new RequestOptions().signature(key);
    }

    @NonNull
    @CheckResult
    public static RequestOptions sizeMultiplierOf(@FloatRange(from = 0.0d, m152to = 1.0d) float f) {
        return new RequestOptions().sizeMultiplier(f);
    }

    @NonNull
    @CheckResult
    public static RequestOptions skipMemoryCacheOf(boolean z) {
        if (z) {
            if (f9050A == null) {
                f9050A = new RequestOptions().skipMemoryCache(true).autoClone();
            }
            return f9050A;
        }
        if (f9051B == null) {
            f9051B = new RequestOptions().skipMemoryCache(false).autoClone();
        }
        return f9051B;
    }

    @NonNull
    @CheckResult
    public static RequestOptions timeoutOf(@IntRange(from = 0) int i) {
        return new RequestOptions().timeout(i);
    }

    @NonNull
    @CheckResult
    public static RequestOptions errorOf(@DrawableRes int i) {
        return new RequestOptions().error(i);
    }

    @NonNull
    @CheckResult
    public static RequestOptions overrideOf(int i) {
        return overrideOf(i, i);
    }

    @NonNull
    @CheckResult
    public static RequestOptions placeholderOf(@DrawableRes int i) {
        return new RequestOptions().placeholder(i);
    }
}
