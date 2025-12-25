package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import p000.tc1;
import p000.uc1;
import p000.vc1;
import p000.wc1;
import p000.xc1;

/* loaded from: classes.dex */
public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";

    /* renamed from: a */
    public static Method f3672a;

    /* renamed from: b */
    public static Field f3673b;

    /* renamed from: c */
    public static Integer f3674c;

    /* renamed from: d */
    public static Integer f3675d;

    /* renamed from: e */
    public static Integer f3676e;

    /* renamed from: a */
    public static boolean m857a(Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null && extras.containsKey(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static Field m858b() {
        if (f3673b == null) {
            Field declaredField = Location.class.getDeclaredField("mFieldsMask");
            f3673b = declaredField;
            declaredField.setAccessible(true);
        }
        return f3673b;
    }

    /* renamed from: c */
    public static int m859c() {
        if (f3675d == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f3675d = Integer.valueOf(declaredField.getInt(null));
        }
        return f3675d.intValue();
    }

    /* renamed from: d */
    public static int m860d() {
        if (f3674c == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f3674c = Integer.valueOf(declaredField.getInt(null));
        }
        return f3674c.intValue();
    }

    /* renamed from: e */
    public static int m861e() {
        if (f3676e == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f3676e = Integer.valueOf(declaredField.getInt(null));
        }
        return f3676e.intValue();
    }

    /* renamed from: f */
    public static Bundle m862f(Location location) {
        Bundle extras = location.getExtras();
        if (extras == null) {
            location.setExtras(new Bundle());
            return location.getExtras();
        }
        return extras;
    }

    /* renamed from: g */
    public static Method m863g() {
        if (f3672a == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            f3672a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f3672a;
    }

    public static float getBearingAccuracyDegrees(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return tc1.m7478a(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return RecyclerView.f7068F0;
        }
        return extras.getFloat(EXTRA_BEARING_ACCURACY, RecyclerView.f7068F0);
    }

    public static long getElapsedRealtimeMillis(@NonNull Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    public static long getElapsedRealtimeNanos(@NonNull Location location) {
        return location.getElapsedRealtimeNanos();
    }

    @FloatRange(from = 0.0d)
    public static float getMslAltitudeAccuracyMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return xc1.m8155a(location);
        }
        return m862f(location).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return xc1.m8156b(location);
        }
        return m862f(location).getDouble(EXTRA_MSL_ALTITUDE);
    }

    public static float getSpeedAccuracyMetersPerSecond(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return tc1.m7479b(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return RecyclerView.f7068F0;
        }
        return extras.getFloat(EXTRA_SPEED_ACCURACY, RecyclerView.f7068F0);
    }

    public static float getVerticalAccuracyMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return tc1.m7480c(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return RecyclerView.f7068F0;
        }
        return extras.getFloat(EXTRA_VERTICAL_ACCURACY, RecyclerView.f7068F0);
    }

    /* renamed from: h */
    public static void m864h(Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(str);
            if (extras.isEmpty()) {
                location.setExtras(null);
            }
        }
    }

    public static boolean hasBearingAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return tc1.m7481d(location);
        }
        return m857a(location, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return xc1.m8157c(location);
        }
        return m857a(location, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return xc1.m8158d(location);
        }
        return m857a(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return tc1.m7482e(location);
        }
        return m857a(location, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return tc1.m7483f(location);
        }
        return m857a(location, EXTRA_VERTICAL_ACCURACY);
    }

    public static boolean isMock(@NonNull Location location) {
        return location.isFromMockProvider();
    }

    public static void removeBearingAccuracy(@NonNull Location location) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            wc1.m8023a(location);
            return;
        }
        if (i >= 29) {
            vc1.m7904a(location);
            return;
        }
        if (i >= 28) {
            uc1.m7698a(location);
        } else if (i >= 26) {
            tc1.m7484g(location);
        } else {
            m864h(location, EXTRA_BEARING_ACCURACY);
        }
    }

    public static void removeMslAltitude(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            xc1.m8159e(location);
        } else {
            m864h(location, EXTRA_MSL_ALTITUDE);
        }
    }

    public static void removeMslAltitudeAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            xc1.m8160f(location);
        } else {
            m864h(location, EXTRA_MSL_ALTITUDE_ACCURACY);
        }
    }

    public static void removeSpeedAccuracy(@NonNull Location location) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            wc1.m8024b(location);
            return;
        }
        if (i >= 29) {
            vc1.m7905b(location);
            return;
        }
        if (i >= 28) {
            uc1.m7699b(location);
        } else if (i >= 26) {
            tc1.m7485h(location);
        } else {
            m864h(location, EXTRA_SPEED_ACCURACY);
        }
    }

    public static void removeVerticalAccuracy(@NonNull Location location) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            wc1.m8025c(location);
            return;
        }
        if (i >= 29) {
            vc1.m7906c(location);
            return;
        }
        if (i >= 28) {
            uc1.m7700c(location);
        } else if (i >= 26) {
            tc1.m7486i(location);
        } else {
            m864h(location, EXTRA_VERTICAL_ACCURACY);
        }
    }

    public static void setBearingAccuracyDegrees(@NonNull Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            tc1.m7487j(location, f);
        } else {
            m862f(location).putFloat(EXTRA_BEARING_ACCURACY, f);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void setMock(@NonNull Location location, boolean z) {
        try {
            m863g().invoke(location, Boolean.valueOf(z));
        } catch (IllegalAccessException e) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e);
            throw illegalAccessError;
        } catch (NoSuchMethodException e2) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e2);
            throw noSuchMethodError;
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static void setMslAltitudeAccuracyMeters(@NonNull Location location, @FloatRange(from = 0.0d) float f) {
        if (Build.VERSION.SDK_INT >= 34) {
            xc1.m8161g(location, f);
        } else {
            m862f(location).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, f);
        }
    }

    public static void setMslAltitudeMeters(@NonNull Location location, double d) {
        if (Build.VERSION.SDK_INT >= 34) {
            xc1.m8162h(location, d);
        } else {
            m862f(location).putDouble(EXTRA_MSL_ALTITUDE, d);
        }
    }

    public static void setSpeedAccuracyMetersPerSecond(@NonNull Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            tc1.m7488k(location, f);
        } else {
            m862f(location).putFloat(EXTRA_SPEED_ACCURACY, f);
        }
    }

    public static void setVerticalAccuracyMeters(@NonNull Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            tc1.m7489l(location, f);
        } else {
            m862f(location).putFloat(EXTRA_VERTICAL_ACCURACY, f);
        }
    }
}
