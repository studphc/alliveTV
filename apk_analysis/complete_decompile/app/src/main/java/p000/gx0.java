package p000;

import android.location.GnssStatus;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class gx0 {
    @DoNotInline
    /* renamed from: a */
    public static float m5023a(GnssStatus gnssStatus, int i) {
        return gnssStatus.getCarrierFrequencyHz(i);
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m5024b(GnssStatus gnssStatus, int i) {
        return gnssStatus.hasCarrierFrequencyHz(i);
    }
}
