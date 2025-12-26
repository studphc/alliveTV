package p000;

import android.location.LocationManager;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class cd1 {
    @DoNotInline
    /* renamed from: a */
    public static String m2226a(LocationManager locationManager) {
        return locationManager.getGnssHardwareModelName();
    }

    @DoNotInline
    /* renamed from: b */
    public static int m2227b(LocationManager locationManager) {
        return locationManager.getGnssYearOfHardware();
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m2228c(LocationManager locationManager) {
        return locationManager.isLocationEnabled();
    }
}
