package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.InvocationTargetException;
import p000.n60;
import p000.o60;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DrawableUtils {

    /* renamed from: a */
    public static final int[] f1250a = {R.attr.state_checked};

    /* renamed from: b */
    public static final int[] f1251b = new int[0];
    public static final Rect INSETS_NONE = new Rect();

    /* renamed from: a */
    public static void m247a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29 && i < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state != null && state.length != 0) {
                drawable.setState(f1251b);
            } else {
                drawable.setState(f1250a);
            }
            drawable.setState(state);
        }
    }

    @Deprecated
    public static boolean canSafelyMutateDrawable(@NonNull Drawable drawable) {
        return true;
    }

    @NonNull
    public static Rect getOpticalBounds(@NonNull Drawable drawable) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            Insets m6444a = o60.m6444a(drawable);
            i = m6444a.left;
            i2 = m6444a.top;
            i3 = m6444a.right;
            i4 = m6444a.bottom;
            return new Rect(i, i2, i3, i4);
        }
        Drawable unwrap = DrawableCompat.unwrap(drawable);
        if (i5 < 29) {
            if (n60.f23240a) {
                try {
                    Object invoke = n60.f23241b.invoke(unwrap, null);
                    if (invoke != null) {
                        return new Rect(n60.f23242c.getInt(invoke), n60.f23243d.getInt(invoke), n60.f23244e.getInt(invoke), n60.f23245f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
        } else {
            boolean z = n60.f23240a;
        }
        return INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
