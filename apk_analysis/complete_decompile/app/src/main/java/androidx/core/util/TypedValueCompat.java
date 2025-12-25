package androidx.core.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.ky2;
import p000.ye0;

/* loaded from: classes.dex */
public class TypedValueCompat {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ComplexDimensionUnit {
    }

    public static float deriveDimension(int i, float f, @NonNull DisplayMetrics displayMetrics) {
        float f2;
        float f3;
        if (Build.VERSION.SDK_INT >= 34) {
            return ky2.m5802a(i, f, displayMetrics);
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                float f4 = displayMetrics.xdpi;
                                if (f4 == RecyclerView.f7068F0) {
                                    return RecyclerView.f7068F0;
                                }
                                f2 = f / f4;
                                f3 = 0.03937008f;
                            } else {
                                throw new IllegalArgumentException(ye0.m8291k(i, "Invalid unitToConvertTo "));
                            }
                        } else {
                            float f5 = displayMetrics.xdpi;
                            if (f5 == RecyclerView.f7068F0) {
                                return RecyclerView.f7068F0;
                            }
                            return f / f5;
                        }
                    } else {
                        float f6 = displayMetrics.xdpi;
                        if (f6 == RecyclerView.f7068F0) {
                            return RecyclerView.f7068F0;
                        }
                        f2 = f / f6;
                        f3 = 0.013888889f;
                    }
                    return f2 / f3;
                }
                float f7 = displayMetrics.scaledDensity;
                if (f7 == RecyclerView.f7068F0) {
                    return RecyclerView.f7068F0;
                }
                return f / f7;
            }
            float f8 = displayMetrics.density;
            if (f8 == RecyclerView.f7068F0) {
                return RecyclerView.f7068F0;
            }
            return f / f8;
        }
        return f;
    }

    public static float dpToPx(float f, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f, displayMetrics);
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i) {
        return i & 15;
    }

    public static float pxToDp(float f, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(1, f, displayMetrics);
    }

    public static float pxToSp(float f, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(2, f, displayMetrics);
    }

    public static float spToPx(float f, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f, displayMetrics);
    }
}
