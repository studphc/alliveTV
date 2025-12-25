package p000;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class jx0 extends GnssStatusCompat {

    /* renamed from: a */
    public final GpsStatus f20668a;

    /* renamed from: b */
    public int f20669b;

    /* renamed from: c */
    public Iterator f20670c;

    /* renamed from: d */
    public int f20671d;

    /* renamed from: e */
    public GpsSatellite f20672e;

    public jx0(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.f20668a = gpsStatus2;
        this.f20669b = -1;
        this.f20670c = gpsStatus2.getSatellites().iterator();
        this.f20671d = -1;
        this.f20672e = null;
    }

    /* renamed from: a */
    public static int m5465a(int i) {
        if (i > 0 && i <= 32) {
            return 1;
        }
        if (i >= 33 && i <= 64) {
            return 2;
        }
        if (i > 64 && i <= 88) {
            return 3;
        }
        if (i > 200 && i <= 235) {
            return 5;
        }
        if (i >= 193 && i <= 200) {
            return 4;
        }
        return 0;
    }

    /* renamed from: b */
    public final GpsSatellite m5466b(int i) {
        GpsSatellite gpsSatellite;
        synchronized (this.f20668a) {
            try {
                if (i < this.f20671d) {
                    this.f20670c = this.f20668a.getSatellites().iterator();
                    this.f20671d = -1;
                }
                while (true) {
                    int i2 = this.f20671d;
                    if (i2 >= i) {
                        break;
                    }
                    this.f20671d = i2 + 1;
                    if (!this.f20670c.hasNext()) {
                        this.f20672e = null;
                        break;
                    }
                    this.f20672e = (GpsSatellite) this.f20670c.next();
                }
                gpsSatellite = this.f20672e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jx0)) {
            return false;
        }
        return this.f20668a.equals(((jx0) obj).f20668a);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getAzimuthDegrees(int i) {
        return m5466b(i).getAzimuth();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getBasebandCn0DbHz(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getCarrierFrequencyHz(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getCn0DbHz(int i) {
        return m5466b(i).getSnr();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final int getConstellationType(int i) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return m5465a(m5466b(i).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final float getElevationDegrees(int i) {
        return m5466b(i).getElevation();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final int getSatelliteCount() {
        int i;
        synchronized (this.f20668a) {
            try {
                if (this.f20669b == -1) {
                    for (GpsSatellite gpsSatellite : this.f20668a.getSatellites()) {
                        this.f20669b++;
                    }
                    this.f20669b++;
                }
                i = this.f20669b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final int getSvid(int i) {
        if (Build.VERSION.SDK_INT < 24) {
            return m5466b(i).getPrn();
        }
        int prn = m5466b(i).getPrn();
        int m5465a = m5465a(prn);
        if (m5465a != 2) {
            if (m5465a != 3) {
                if (m5465a == 5) {
                    return prn - 200;
                }
                return prn;
            }
            return prn - 64;
        }
        return prn + 87;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean hasAlmanacData(int i) {
        return m5466b(i).hasAlmanac();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean hasBasebandCn0DbHz(int i) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean hasCarrierFrequencyHz(int i) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean hasEphemerisData(int i) {
        return m5466b(i).hasEphemeris();
    }

    public final int hashCode() {
        return this.f20668a.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public final boolean usedInFix(int i) {
        return m5466b(i).usedInFix();
    }
}
