package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ThemeUtils {

    /* renamed from: a */
    public static final ThreadLocal f1479a = new ThreadLocal();

    /* renamed from: b */
    public static final int[] f1480b = {-16842910};

    /* renamed from: c */
    public static final int[] f1481c = {R.attr.state_focused};

    /* renamed from: d */
    public static final int[] f1482d = {R.attr.state_pressed};

    /* renamed from: e */
    public static final int[] f1483e = {R.attr.state_checked};

    /* renamed from: f */
    public static final int[] f1484f = new int[0];

    /* renamed from: g */
    public static final int[] f1485g = new int[1];

    public static void checkAppCompatTheme(@NonNull View view, @NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static ColorStateList createDisabledStateList(int i, int i2) {
        return new ColorStateList(new int[][]{f1480b, f1484f}, new int[]{i2, i});
    }

    public static int getDisabledThemeAttrColor(@NonNull Context context, int i) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(f1480b, themeAttrColorStateList.getDefaultColor());
        }
        ThreadLocal threadLocal = f1479a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f = typedValue.getFloat();
        return ColorUtils.setAlphaComponent(getThemeAttrColor(context, i), Math.round(Color.alpha(r4) * f));
    }

    public static int getThemeAttrColor(@NonNull Context context, int i) {
        int[] iArr = f1485g;
        iArr[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Nullable
    public static ColorStateList getThemeAttrColorStateList(@NonNull Context context, int i) {
        int[] iArr = f1485g;
        iArr[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
