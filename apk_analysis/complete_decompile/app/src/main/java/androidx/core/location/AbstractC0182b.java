package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Consumer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.Executor;
import p000.gd1;

/* renamed from: androidx.core.location.b */
/* loaded from: classes.dex */
public abstract class AbstractC0182b {

    /* renamed from: a */
    public static Class f3695a;

    /* renamed from: b */
    public static Method f3696b;

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @DoNotInline
    /* renamed from: a */
    public static void m873a(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull final Consumer<Location> consumer) {
        Objects.requireNonNull(consumer);
        locationManager.getCurrentLocation(str, cancellationSignal, executor, new java.util.function.Consumer() { // from class: dd1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Consumer.this.accept((Location) obj);
            }
        });
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @DoNotInline
    /* renamed from: b */
    public static boolean m874b(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
        SimpleArrayMap simpleArrayMap = gd1.f17651a;
        synchronized (simpleArrayMap) {
            try {
                C0183c c0183c = (C0183c) simpleArrayMap.get(callback);
                if (c0183c == null) {
                    c0183c = new C0183c(callback);
                }
                if (locationManager.registerGnssStatusCallback(executor, c0183c)) {
                    simpleArrayMap.put(callback, c0183c);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m875c(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                if (f3695a == null) {
                    f3695a = Class.forName("android.location.LocationRequest");
                }
                if (f3696b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f3695a, Executor.class, LocationListener.class);
                    f3696b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    f3696b.invoke(locationManager, locationRequest, executor, locationListenerCompat);
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
        }
        return false;
    }
}
