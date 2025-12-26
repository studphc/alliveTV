package p000;

import android.location.Location;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class vc1 {
    @DoNotInline
    /* renamed from: a */
    public static void m7904a(Location location) {
        if (!location.hasBearingAccuracy()) {
            return;
        }
        double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
        uc1.m7698a(location);
        location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m7905b(Location location) {
        if (!location.hasSpeedAccuracy()) {
            return;
        }
        double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
        uc1.m7699b(location);
        location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m7906c(Location location) {
        if (!location.hasVerticalAccuracy()) {
            return;
        }
        double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
        uc1.m7700c(location);
        location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
    }
}
