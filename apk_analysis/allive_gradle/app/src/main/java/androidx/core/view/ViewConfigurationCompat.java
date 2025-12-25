package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;
import java.util.Objects;
import p000.f33;
import p000.g33;
import p000.h33;

/* loaded from: classes.dex */
public final class ViewConfigurationCompat {

    /* renamed from: a */
    public static final Method f3918a;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f3918a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", null);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    /* renamed from: a */
    public static float m914a(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f3918a) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, null)).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return RecyclerView.f7068F0;
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f33.m4766a(viewConfiguration);
        }
        return m914a(viewConfiguration, context);
    }

    public static int getScaledHoverSlop(@NonNull ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT >= 28) {
            return g33.m4913a(viewConfiguration);
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int getScaledMaximumFlingVelocity(@NonNull Context context, @NonNull ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        boolean z;
        int i4;
        int dimensionPixelSize;
        if (Build.VERSION.SDK_INT >= 34) {
            return h33.m5034a(viewConfiguration, i, i2, i3);
        }
        InputDevice device = InputDevice.getDevice(i);
        if (device != null && device.getMotionRange(i2, i3) != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        if (i3 == 4194304 && i2 == 26) {
            i4 = resources.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android");
        } else {
            i4 = -1;
        }
        Objects.requireNonNull(viewConfiguration);
        if (i4 != -1) {
            if (i4 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i4)) < 0) {
                return Integer.MIN_VALUE;
            }
            return dimensionPixelSize;
        }
        return viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public static int getScaledMinimumFlingVelocity(@NonNull Context context, @NonNull ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        boolean z;
        int i4;
        int dimensionPixelSize;
        if (Build.VERSION.SDK_INT >= 34) {
            return h33.m5035b(viewConfiguration, i, i2, i3);
        }
        InputDevice device = InputDevice.getDevice(i);
        if (device != null && device.getMotionRange(i2, i3) != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        if (i3 == 4194304 && i2 == 26) {
            i4 = resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android");
        } else {
            i4 = -1;
        }
        Objects.requireNonNull(viewConfiguration);
        if (i4 != -1) {
            if (i4 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i4)) < 0) {
                return Integer.MAX_VALUE;
            }
            return dimensionPixelSize;
        }
        return viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f33.m4767b(viewConfiguration);
        }
        return m914a(viewConfiguration, context);
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return g33.m4914b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        if (identifier != 0 && resources.getBoolean(identifier)) {
            return true;
        }
        return false;
    }
}
