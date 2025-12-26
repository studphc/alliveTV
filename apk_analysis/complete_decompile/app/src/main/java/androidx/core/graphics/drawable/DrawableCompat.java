package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.xmlpull.v1.XmlPullParser;
import p000.j60;
import p000.k60;

/* loaded from: classes.dex */
public final class DrawableCompat {
    public static void applyTheme(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        j60.m5394a(drawable, theme);
    }

    public static boolean canApplyTheme(@NonNull Drawable drawable) {
        return j60.m5395b(drawable);
    }

    public static void clearColorFilter(@NonNull Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int getAlpha(@NonNull Drawable drawable) {
        return drawable.getAlpha();
    }

    @Nullable
    public static ColorFilter getColorFilter(@NonNull Drawable drawable) {
        return j60.m5396c(drawable);
    }

    public static int getLayoutDirection(@NonNull Drawable drawable) {
        return k60.m5501a(drawable);
    }

    public static void inflate(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        j60.m5397d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean isAutoMirrored(@NonNull Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void setAutoMirrored(@NonNull Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static void setHotspot(@NonNull Drawable drawable, float f, float f2) {
        j60.m5398e(drawable, f, f2);
    }

    public static void setHotspotBounds(@NonNull Drawable drawable, int i, int i2, int i3, int i4) {
        j60.m5399f(drawable, i, i2, i3, i4);
    }

    public static boolean setLayoutDirection(@NonNull Drawable drawable, int i) {
        return k60.m5502b(drawable, i);
    }

    public static void setTint(@NonNull Drawable drawable, @ColorInt int i) {
        j60.m5400g(drawable, i);
    }

    public static void setTintList(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        j60.m5401h(drawable, colorStateList);
    }

    public static void setTintMode(@NonNull Drawable drawable, @Nullable PorterDuff.Mode mode) {
        j60.m5402i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(@NonNull Drawable drawable) {
        if (drawable instanceof WrappedDrawable) {
            return (T) ((WrappedDrawable) drawable).getWrappedDrawable();
        }
        return drawable;
    }

    @NonNull
    public static Drawable wrap(@NonNull Drawable drawable) {
        return drawable;
    }
}
