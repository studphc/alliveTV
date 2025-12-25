package p000;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzde;
import com.google.android.gms.internal.measurement.zzo;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzif;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzkb;
import java.util.Map;

/* loaded from: classes.dex */
public final class pe3 implements zzkb, zzo {

    /* renamed from: a */
    public final Object f25141a;

    /* renamed from: b */
    public final /* synthetic */ Object f25142b;

    public /* synthetic */ pe3(Object obj, Object obj2) {
        this.f25142b = obj;
        this.f25141a = obj2;
    }

    @Override // com.google.android.gms.measurement.internal.zzkb
    public void interceptEvent(String str, String str2, Bundle bundle, long j) {
        try {
            ((zzde) this.f25141a).zzf(str, str2, bundle, j);
        } catch (RemoteException e) {
            zzio zzioVar = ((AppMeasurementDynamiteService) this.f25142b).f13971a;
            if (zzioVar != null) {
                zzioVar.zzaW().zzk().zzb("Event interceptor threw exception", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public String zza(String str) {
        Map map = (Map) ((zzif) this.f25142b).f14226b.get((String) this.f25141a);
        if (map != null && map.containsKey(str)) {
            return (String) map.get(str);
        }
        return null;
    }
}
