package p000;

import android.location.GnssStatus;
import android.os.Build;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class ix0 extends GnssStatusCompat {

    /* renamed from: a */
    public final GnssStatus f20301a;

    public ix0(Object obj) {
        this.f20301a = fx0.m4854g(Preconditions.checkNotNull(fx0.m4854g(obj)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ix0)) {
            return false;
        }
        return fx0.m4870w(this.f20301a, ((ix0) obj).f20301a);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getAzimuthDegrees(int i) {
        return fx0.m4872y(this.f20301a, i);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getBasebandCn0DbHz(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            return hx0.m5136a(this.f20301a, i);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getCarrierFrequencyHz(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return gx0.m5023a(this.f20301a, i);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getCn0DbHz(int i) {
        return fx0.m4848a(this.f20301a, i);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final int getConstellationType(int i) {
        return fx0.m4873z(this.f20301a, i);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getElevationDegrees(int i) {
        return fx0.m4846C(this.f20301a, i);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final int getSatelliteCount() {
        return fx0.m4849b(this.f20301a);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final int getSvid(int i) {
        return fx0.m4850c(this.f20301a, i);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean hasAlmanacData(int i) {
        return fx0.m4845B(this.f20301a, i);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean hasBasebandCn0DbHz(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            return hx0.m5137b(this.f20301a, i);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean hasCarrierFrequencyHz(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return gx0.m5024b(this.f20301a, i);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean hasEphemerisData(int i) {
        return fx0.m4869v(this.f20301a, i);
    }

    public final int hashCode() {
        return ki0.m5533a(this.f20301a);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean usedInFix(int i) {
        return fx0.m4847D(this.f20301a, i);
    }
}
