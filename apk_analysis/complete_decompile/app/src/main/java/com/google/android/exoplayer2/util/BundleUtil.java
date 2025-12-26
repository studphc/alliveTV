package com.google.android.exoplayer2.util;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class BundleUtil {

    /* renamed from: a */
    public static Method f12667a;

    /* renamed from: b */
    public static Method f12668b;

    @Nullable
    public static IBinder getBinder(Bundle bundle, @Nullable String str) {
        if (Util.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        Method method = f12667a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f12667a = method2;
                method2.setAccessible(true);
                method = f12667a;
            } catch (NoSuchMethodException e) {
                Log.m3026i("BundleUtil", "Failed to retrieve getIBinder method", e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            Log.m3026i("BundleUtil", "Failed to invoke getIBinder via reflection", e2);
            return null;
        }
    }

    public static void putBinder(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (Util.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
            return;
        }
        Method method = f12668b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                f12668b = method2;
                method2.setAccessible(true);
                method = f12668b;
            } catch (NoSuchMethodException e) {
                Log.m3026i("BundleUtil", "Failed to retrieve putIBinder method", e);
                return;
            }
        }
        try {
            method.invoke(bundle, str, iBinder);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            Log.m3026i("BundleUtil", "Failed to invoke putIBinder via reflection", e2);
        }
    }
}
