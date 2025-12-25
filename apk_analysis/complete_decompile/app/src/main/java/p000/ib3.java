package p000;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzg;

/* loaded from: classes2.dex */
public final class ib3 implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a */
    public final /* synthetic */ zzg f18358a;

    public ib3(zzg zzgVar) {
        this.f18358a = zzgVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzkc
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (str != null && zzc.zzc(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle("params", bundle);
            this.f18358a.f15505a.onMessageTriggered(3, bundle2);
        }
    }
}
