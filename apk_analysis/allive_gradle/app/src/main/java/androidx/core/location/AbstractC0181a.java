package androidx.core.location;

import android.location.GnssMeasurementsEvent$Callback;
import android.location.GnssStatus$Callback;
import android.location.LocationManager;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import p000.gd1;

/* renamed from: androidx.core.location.a */
/* loaded from: classes.dex */
public abstract class AbstractC0181a {
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @DoNotInline
    /* renamed from: a */
    public static boolean m868a(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        return locationManager.registerGnssMeasurementsCallback(gnssMeasurementsEvent$Callback);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @DoNotInline
    /* renamed from: b */
    public static boolean m869b(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback, @NonNull Handler handler) {
        return locationManager.registerGnssMeasurementsCallback(gnssMeasurementsEvent$Callback, handler);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @DoNotInline
    /* renamed from: c */
    public static boolean m870c(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
        boolean z;
        boolean z2;
        boolean z3;
        if (handler != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        SimpleArrayMap simpleArrayMap = gd1.f17651a;
        synchronized (simpleArrayMap) {
            try {
                C0185e c0185e = (C0185e) simpleArrayMap.get(callback);
                if (c0185e == null) {
                    c0185e = new C0185e(callback);
                } else {
                    c0185e.f3702b = null;
                }
                if (executor != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2, "invalid null executor");
                if (c0185e.f3702b == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3);
                c0185e.f3702b = executor;
                if (!locationManager.registerGnssStatusCallback(c0185e, handler)) {
                    return false;
                }
                simpleArrayMap.put(callback, c0185e);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @DoNotInline
    /* renamed from: d */
    public static void m871d(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        locationManager.unregisterGnssMeasurementsCallback(gnssMeasurementsEvent$Callback);
    }

    @DoNotInline
    /* renamed from: e */
    public static void m872e(LocationManager locationManager, Object obj) {
        if (obj instanceof C0185e) {
            ((C0185e) obj).f3702b = null;
        }
        locationManager.unregisterGnssStatusCallback((GnssStatus$Callback) obj);
    }
}
