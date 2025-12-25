package p000;

import android.location.Location;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class wc1 {
    @DoNotInline
    /* renamed from: a */
    public static void m8023a(Location location) {
        location.removeBearingAccuracy();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m8024b(Location location) {
        location.removeSpeedAccuracy();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m8025c(Location location) {
        location.removeVerticalAccuracy();
    }
}
