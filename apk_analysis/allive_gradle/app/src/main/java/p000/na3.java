package p000;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjy;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;

/* loaded from: classes2.dex */
public final class na3 implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a */
    public final /* synthetic */ zze f23315a;

    public na3(zze zzeVar) {
        this.f23315a = zzeVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzkc
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        zze zzeVar = this.f23315a;
        if (!zzeVar.f15503a.contains(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        ImmutableSet immutableSet = zzc.f15497a;
        String zza = zzjy.zza(str2);
        if (zza != null) {
            str2 = zza;
        }
        bundle2.putString("events", str2);
        zzeVar.f15504b.onMessageTriggered(2, bundle2);
    }
}
