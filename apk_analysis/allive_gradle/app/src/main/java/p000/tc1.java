package p000;

import android.location.Location;
import androidx.annotation.DoNotInline;
import androidx.core.location.LocationCompat;

/* loaded from: classes.dex */
public abstract class tc1 {
    @DoNotInline
    /* renamed from: a */
    public static float m7478a(Location location) {
        return location.getBearingAccuracyDegrees();
    }

    @DoNotInline
    /* renamed from: b */
    public static float m7479b(Location location) {
        return location.getSpeedAccuracyMetersPerSecond();
    }

    @DoNotInline
    /* renamed from: c */
    public static float m7480c(Location location) {
        return location.getVerticalAccuracyMeters();
    }

    @DoNotInline
    /* renamed from: d */
    public static boolean m7481d(Location location) {
        return location.hasBearingAccuracy();
    }

    @DoNotInline
    /* renamed from: e */
    public static boolean m7482e(Location location) {
        return location.hasSpeedAccuracy();
    }

    @DoNotInline
    /* renamed from: f */
    public static boolean m7483f(Location location) {
        return location.hasVerticalAccuracy();
    }

    @DoNotInline
    /* renamed from: g */
    public static void m7484g(Location location) {
        try {
            LocationCompat.m858b().setByte(location, (byte) (LocationCompat.m858b().getByte(location) & (~LocationCompat.m859c())));
        } catch (IllegalAccessException e) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e);
            throw illegalAccessError;
        } catch (NoSuchFieldException e2) {
            NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
            noSuchFieldError.initCause(e2);
            throw noSuchFieldError;
        }
    }

    @DoNotInline
    /* renamed from: h */
    public static void m7485h(Location location) {
        try {
            LocationCompat.m858b().setByte(location, (byte) (LocationCompat.m858b().getByte(location) & (~LocationCompat.m860d())));
        } catch (IllegalAccessException e) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e);
            throw illegalAccessError;
        } catch (NoSuchFieldException e2) {
            NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
            noSuchFieldError.initCause(e2);
            throw noSuchFieldError;
        }
    }

    @DoNotInline
    /* renamed from: i */
    public static void m7486i(Location location) {
        try {
            LocationCompat.m858b().setByte(location, (byte) (LocationCompat.m858b().getByte(location) & (~LocationCompat.m861e())));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e);
            throw illegalAccessError;
        }
    }

    @DoNotInline
    /* renamed from: j */
    public static void m7487j(Location location, float f) {
        location.setBearingAccuracyDegrees(f);
    }

    @DoNotInline
    /* renamed from: k */
    public static void m7488k(Location location, float f) {
        location.setSpeedAccuracyMetersPerSecond(f);
    }

    @DoNotInline
    /* renamed from: l */
    public static void m7489l(Location location, float f) {
        location.setVerticalAccuracyMeters(f);
    }
}
