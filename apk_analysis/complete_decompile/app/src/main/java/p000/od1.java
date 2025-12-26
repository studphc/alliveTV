package p000;

import android.location.LocationRequest;
import androidx.annotation.DoNotInline;
import androidx.core.location.LocationRequestCompat;

/* loaded from: classes.dex */
public abstract class od1 {
    @DoNotInline
    /* renamed from: a */
    public static LocationRequest m6562a(LocationRequestCompat locationRequestCompat) {
        return new LocationRequest.Builder(locationRequestCompat.getIntervalMillis()).setQuality(locationRequestCompat.getQuality()).setMinUpdateIntervalMillis(locationRequestCompat.getMinUpdateIntervalMillis()).setDurationMillis(locationRequestCompat.getDurationMillis()).setMaxUpdates(locationRequestCompat.getMaxUpdates()).setMinUpdateDistanceMeters(locationRequestCompat.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(locationRequestCompat.getMaxUpdateDelayMillis()).build();
    }
}
