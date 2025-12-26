package androidx.core.location;

import android.location.GnssStatus;
import android.location.GnssStatus$Callback;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;

/* renamed from: androidx.core.location.c */
/* loaded from: classes.dex */
public final class C0183c extends GnssStatus$Callback {

    /* renamed from: a */
    public final GnssStatusCompat.Callback f3697a;

    public C0183c(GnssStatusCompat.Callback callback) {
        boolean z;
        if (callback != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "invalid null callback");
        this.f3697a = callback;
    }

    public final void onFirstFix(int i) {
        this.f3697a.onFirstFix(i);
    }

    public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        this.f3697a.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
    }

    public final void onStarted() {
        this.f3697a.onStarted();
    }

    public final void onStopped() {
        this.f3697a.onStopped();
    }
}
