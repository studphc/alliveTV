package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.AbstractC0216l;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes.dex */
public abstract class w23 {
    @DoNotInline
    /* renamed from: a */
    public static void m7967a(@NonNull WindowInsets windowInsets, @NonNull View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    @DoNotInline
    /* renamed from: b */
    public static WindowInsetsCompat m7968b(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
        }
        rect.setEmpty();
        return windowInsetsCompat;
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m7969c(@NonNull View view, float f, float f2, boolean z) {
        return view.dispatchNestedFling(f, f2, z);
    }

    @DoNotInline
    /* renamed from: d */
    public static boolean m7970d(@NonNull View view, float f, float f2) {
        return view.dispatchNestedPreFling(f, f2);
    }

    @DoNotInline
    /* renamed from: e */
    public static boolean m7971e(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @DoNotInline
    /* renamed from: f */
    public static boolean m7972f(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @DoNotInline
    /* renamed from: g */
    public static ColorStateList m7973g(View view) {
        return view.getBackgroundTintList();
    }

    @DoNotInline
    /* renamed from: h */
    public static PorterDuff.Mode m7974h(View view) {
        return view.getBackgroundTintMode();
    }

    @DoNotInline
    /* renamed from: i */
    public static float m7975i(View view) {
        return view.getElevation();
    }

    @Nullable
    @DoNotInline
    /* renamed from: j */
    public static WindowInsetsCompat m7976j(@NonNull View view) {
        if (!AbstractC0216l.f4002d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = AbstractC0216l.f3999a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) AbstractC0216l.f4000b.get(obj);
            Rect rect2 = (Rect) AbstractC0216l.f4001c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            WindowInsetsCompat build = new WindowInsetsCompat.Builder().setStableInsets(Insets.m829of(rect)).setSystemWindowInsets(Insets.m829of(rect2)).build();
            build.f3941a.mo990t(build);
            build.f3941a.mo980d(view.getRootView());
            return build;
        } catch (IllegalAccessException e) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            return null;
        }
    }

    @DoNotInline
    /* renamed from: k */
    public static String m7977k(View view) {
        return view.getTransitionName();
    }

    @DoNotInline
    /* renamed from: l */
    public static float m7978l(View view) {
        return view.getTranslationZ();
    }

    @DoNotInline
    /* renamed from: m */
    public static float m7979m(@NonNull View view) {
        return view.getZ();
    }

    @DoNotInline
    /* renamed from: n */
    public static boolean m7980n(View view) {
        return view.hasNestedScrollingParent();
    }

    @DoNotInline
    /* renamed from: o */
    public static boolean m7981o(View view) {
        return view.isImportantForAccessibility();
    }

    @DoNotInline
    /* renamed from: p */
    public static boolean m7982p(View view) {
        return view.isNestedScrollingEnabled();
    }

    @DoNotInline
    /* renamed from: q */
    public static void m7983q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    @DoNotInline
    /* renamed from: r */
    public static void m7984r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    @DoNotInline
    /* renamed from: s */
    public static void m7985s(View view, float f) {
        view.setElevation(f);
    }

    @DoNotInline
    /* renamed from: t */
    public static void m7986t(View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    @DoNotInline
    /* renamed from: u */
    public static void m7987u(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
        }
        if (onApplyWindowInsetsListener == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new v23(view, onApplyWindowInsetsListener));
        }
    }

    @DoNotInline
    /* renamed from: v */
    public static void m7988v(View view, String str) {
        view.setTransitionName(str);
    }

    @DoNotInline
    /* renamed from: w */
    public static void m7989w(View view, float f) {
        view.setTranslationZ(f);
    }

    @DoNotInline
    /* renamed from: x */
    public static void m7990x(@NonNull View view, float f) {
        view.setZ(f);
    }

    @DoNotInline
    /* renamed from: y */
    public static boolean m7991y(View view, int i) {
        return view.startNestedScroll(i);
    }

    @DoNotInline
    /* renamed from: z */
    public static void m7992z(View view) {
        view.stopNestedScroll();
    }
}
