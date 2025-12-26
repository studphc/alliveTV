package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000.h43;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ViewUtils {

    /* renamed from: a */
    public static boolean f1591a;

    /* renamed from: b */
    public static Method f1592b;

    /* renamed from: c */
    public static final boolean f1593c;

    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 27) {
            z = true;
        } else {
            z = false;
        }
        f1593c = z;
    }

    public static void computeFitSystemWindows(@NonNull View view, @NonNull Rect rect, @NonNull Rect rect2) {
        if (Build.VERSION.SDK_INT >= 29) {
            h43.m5036a(view, rect, rect2);
            return;
        }
        if (!f1591a) {
            f1591a = true;
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                f1592b = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    f1592b.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
        Method method = f1592b;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static boolean isLayoutRtl(View view) {
        if (view.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void makeOptionalFitsSystemWindows(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, null);
        } catch (IllegalAccessException e) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
    }
}
