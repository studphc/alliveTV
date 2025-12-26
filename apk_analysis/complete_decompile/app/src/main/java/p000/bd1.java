package p000;

import android.annotation.SuppressLint;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.core.location.LocationListenerCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.core.location.LocationRequestCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class bd1 {

    /* renamed from: a */
    public static Class f7970a;

    /* renamed from: b */
    public static Method f7971b;

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @DoNotInline
    @SuppressLint({"BanUncheckedReflection"})
    /* renamed from: a */
    public static boolean m2085a(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, md1 md1Var) {
        try {
            if (f7970a == null) {
                f7970a = Class.forName("android.location.LocationRequest");
            }
            if (f7971b == null) {
                Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f7970a, LocationListener.class, Looper.class);
                f7971b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
            if (locationRequest != null) {
                synchronized (LocationManagerCompat.f3680d) {
                    f7971b.invoke(locationManager, locationRequest, md1Var, Looper.getMainLooper());
                    LocationManagerCompat.m867c(locationManager, md1Var);
                }
                return true;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
        }
        return false;
    }

    @DoNotInline
    @SuppressLint({"BanUncheckedReflection"})
    /* renamed from: b */
    public static boolean m2086b(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
        try {
            if (f7970a == null) {
                f7970a = Class.forName("android.location.LocationRequest");
            }
            if (f7971b == null) {
                Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f7970a, LocationListener.class, Looper.class);
                f7971b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
            if (locationRequest != null) {
                f7971b.invoke(locationManager, locationRequest, locationListenerCompat, looper);
                return true;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
        }
        return false;
    }
}
