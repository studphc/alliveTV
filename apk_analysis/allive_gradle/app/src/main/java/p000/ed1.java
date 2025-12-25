package p000;

import android.location.GnssMeasurementsEvent$Callback;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class ed1 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m4688a(LocationManager locationManager, @NonNull String str) {
        return locationManager.hasProvider(str);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @DoNotInline
    /* renamed from: b */
    public static boolean m4689b(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        return locationManager.registerGnssMeasurementsCallback(executor, gnssMeasurementsEvent$Callback);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @DoNotInline
    /* renamed from: c */
    public static void m4690c(LocationManager locationManager, @NonNull String str, @NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationListener locationListener) {
        locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
    }
}
