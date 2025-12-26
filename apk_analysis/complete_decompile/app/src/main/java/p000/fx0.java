package p000;

import android.location.GnssMeasurementsEvent$Callback;
import android.location.GnssStatus;
import android.os.LocaleList;
import io.reactivex.rxjava3.core.MaybeObserver;
import java.util.StringJoiner;
import java.util.concurrent.CompletionStage;

/* loaded from: classes.dex */
public abstract /* synthetic */ class fx0 {
    /* renamed from: B */
    public static /* bridge */ /* synthetic */ boolean m4845B(GnssStatus gnssStatus, int i) {
        return gnssStatus.hasAlmanacData(i);
    }

    /* renamed from: C */
    public static /* bridge */ /* synthetic */ float m4846C(GnssStatus gnssStatus, int i) {
        return gnssStatus.getElevationDegrees(i);
    }

    /* renamed from: D */
    public static /* bridge */ /* synthetic */ boolean m4847D(GnssStatus gnssStatus, int i) {
        return gnssStatus.usedInFix(i);
    }

    /* renamed from: a */
    public static /* bridge */ /* synthetic */ float m4848a(GnssStatus gnssStatus, int i) {
        return gnssStatus.getCn0DbHz(i);
    }

    /* renamed from: b */
    public static /* bridge */ /* synthetic */ int m4849b(GnssStatus gnssStatus) {
        return gnssStatus.getSatelliteCount();
    }

    /* renamed from: c */
    public static /* bridge */ /* synthetic */ int m4850c(GnssStatus gnssStatus, int i) {
        return gnssStatus.getSvid(i);
    }

    /* renamed from: f */
    public static /* bridge */ /* synthetic */ GnssMeasurementsEvent$Callback m4853f(Object obj) {
        return (GnssMeasurementsEvent$Callback) obj;
    }

    /* renamed from: g */
    public static /* bridge */ /* synthetic */ GnssStatus m4854g(Object obj) {
        return (GnssStatus) obj;
    }

    /* renamed from: i */
    public static /* bridge */ /* synthetic */ LocaleList m4856i(Object obj) {
        return (LocaleList) obj;
    }

    /* renamed from: j */
    public static /* bridge */ /* synthetic */ Class m4857j() {
        return GnssMeasurementsEvent$Callback.class;
    }

    /* renamed from: p */
    public static /* synthetic */ StringJoiner m4863p() {
        return new StringJoiner(", ", " conversion category (one of: ", ")");
    }

    /* renamed from: q */
    public static /* bridge */ /* synthetic */ CompletionStage m4864q(MaybeObserver maybeObserver) {
        return (CompletionStage) maybeObserver;
    }

    /* renamed from: v */
    public static /* bridge */ /* synthetic */ boolean m4869v(GnssStatus gnssStatus, int i) {
        return gnssStatus.hasEphemerisData(i);
    }

    /* renamed from: w */
    public static /* bridge */ /* synthetic */ boolean m4870w(GnssStatus gnssStatus, Object obj) {
        return gnssStatus.equals(obj);
    }

    /* renamed from: y */
    public static /* bridge */ /* synthetic */ float m4872y(GnssStatus gnssStatus, int i) {
        return gnssStatus.getAzimuthDegrees(i);
    }

    /* renamed from: z */
    public static /* bridge */ /* synthetic */ int m4873z(GnssStatus gnssStatus, int i) {
        return gnssStatus.getConstellationType(i);
    }
}
