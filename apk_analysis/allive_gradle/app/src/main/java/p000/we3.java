package p000;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzde;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzkc;

/* loaded from: classes.dex */
public final class we3 implements zzkc {

    /* renamed from: a */
    public final zzde f28165a;

    /* renamed from: b */
    public final /* synthetic */ AppMeasurementDynamiteService f28166b;

    public we3(AppMeasurementDynamiteService appMeasurementDynamiteService, zzde zzdeVar) {
        this.f28166b = appMeasurementDynamiteService;
        this.f28165a = zzdeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzkc
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.f28165a.zzf(str, str2, bundle, j);
        } catch (RemoteException e) {
            zzio zzioVar = this.f28166b.f13971a;
            if (zzioVar != null) {
                zzioVar.zzaW().zzk().zzb("Event listener threw exception", e);
            }
        }
    }
}
