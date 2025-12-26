package p000;

import android.location.GnssStatus;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class hx0 {
    @DoNotInline
    /* renamed from: a */
    public static float m5136a(GnssStatus gnssStatus, int i) {
        return gnssStatus.getBasebandCn0DbHz(i);
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m5137b(GnssStatus gnssStatus, int i) {
        return gnssStatus.hasBasebandCn0DbHz(i);
    }
}
