package p000;

import android.location.Location;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class xc1 {
    @DoNotInline
    /* renamed from: a */
    public static float m8155a(Location location) {
        return location.getMslAltitudeAccuracyMeters();
    }

    @DoNotInline
    /* renamed from: b */
    public static double m8156b(Location location) {
        return location.getMslAltitudeMeters();
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m8157c(Location location) {
        return location.hasMslAltitude();
    }

    @DoNotInline
    /* renamed from: d */
    public static boolean m8158d(Location location) {
        return location.hasMslAltitudeAccuracy();
    }

    @DoNotInline
    /* renamed from: e */
    public static void m8159e(Location location) {
        location.removeMslAltitude();
    }

    @DoNotInline
    /* renamed from: f */
    public static void m8160f(Location location) {
        location.removeMslAltitudeAccuracy();
    }

    @DoNotInline
    /* renamed from: g */
    public static void m8161g(Location location, float f) {
        location.setMslAltitudeAccuracyMeters(f);
    }

    @DoNotInline
    /* renamed from: h */
    public static void m8162h(Location location, double d) {
        location.setMslAltitudeMeters(d);
    }
}
