package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {

    /* renamed from: b */
    public static final PorterDuff.Mode f1147b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    public static AppCompatDrawableManager f1148c;

    /* renamed from: a */
    public ResourceManagerInternal f1149a;

    /* renamed from: a */
    public static void m240a(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuff.Mode mode2 = ResourceManagerInternal.f1336h;
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = tintInfo.mHasTintList;
            if (!z && !tintInfo.mHasTintMode) {
                drawable.clearColorFilter();
            } else {
                PorterDuffColorFilter porterDuffColorFilter = null;
                if (z) {
                    colorStateList = tintInfo.mTintList;
                } else {
                    colorStateList = null;
                }
                if (tintInfo.mHasTintMode) {
                    mode = tintInfo.mTintMode;
                } else {
                    mode = ResourceManagerInternal.f1336h;
                }
                if (colorStateList != null && mode != null) {
                    porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            try {
                if (f1148c == null) {
                    preload();
                }
                appCompatDrawableManager = f1148c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (f1148c == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                f1148c = appCompatDrawableManager;
                appCompatDrawableManager.f1149a = ResourceManagerInternal.get();
                f1148c.f1149a.setHooks(new C0097f());
            }
        }
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return this.f1149a.getDrawable(context, i);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        this.f1149a.onConfigurationChanged(context);
    }
}
