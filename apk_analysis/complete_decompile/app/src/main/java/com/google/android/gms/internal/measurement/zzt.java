package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import java.util.List;
import p000.oe3;
import p000.ze3;

/* loaded from: classes.dex */
public final class zzt extends zzai {

    /* renamed from: a */
    public final zzr f13956a;

    public zzt(zzr zzrVar) {
        super("internal.logger");
        this.f13956a = zzrVar;
        this.zze.put("log", new ze3(this, false, true));
        this.zze.put(NotificationCompat.GROUP_KEY_SILENT, new oe3(NotificationCompat.GROUP_KEY_SILENT, 0));
        ((zzai) this.zze.get(NotificationCompat.GROUP_KEY_SILENT)).zzr("log", new ze3(this, true, true));
        this.zze.put("unmonitored", new oe3("unmonitored", 1));
        ((zzai) this.zze.get("unmonitored")).zzr("log", new ze3(this, false, false));
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        return zzap.zzf;
    }
}
