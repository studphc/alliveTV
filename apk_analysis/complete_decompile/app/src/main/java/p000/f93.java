package p000;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzkb;
import com.google.android.gms.measurement.internal.zzkc;
import com.google.android.gms.measurement.internal.zzlw;
import com.google.android.gms.measurement.internal.zzqb;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class f93 extends ia3 {

    /* renamed from: a */
    public final zzio f17185a;

    /* renamed from: b */
    public final zzlw f17186b;

    public f93(zzio zzioVar) {
        Preconditions.checkNotNull(zzioVar);
        this.f17185a = zzioVar;
        this.f17186b = zzioVar.zzq();
    }

    @Override // p000.ia3
    /* renamed from: a */
    public final Boolean mo4783a() {
        return this.f17186b.zzl();
    }

    @Override // p000.ia3
    /* renamed from: b */
    public final Double mo4784b() {
        return this.f17186b.zzm();
    }

    @Override // p000.ia3
    /* renamed from: c */
    public final Integer mo4785c() {
        return this.f17186b.zzp();
    }

    @Override // p000.ia3
    /* renamed from: d */
    public final Long mo4786d() {
        return this.f17186b.zzq();
    }

    @Override // p000.ia3
    /* renamed from: e */
    public final String mo4787e() {
        return this.f17186b.zzu();
    }

    @Override // p000.ia3
    /* renamed from: f */
    public final Map mo4788f(boolean z) {
        List<zzqb> zzw = this.f17186b.zzw(z);
        ArrayMap arrayMap = new ArrayMap(zzw.size());
        for (zzqb zzqbVar : zzw) {
            Object zza = zzqbVar.zza();
            if (zza != null) {
                arrayMap.put(zzqbVar.zzb, zza);
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final int zza(String str) {
        this.f17186b.zzi(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final long zzb() {
        return this.f17185a.zzw().zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final Object zzg(int i) {
        zzlw zzlwVar = this.f17186b;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return zzlwVar.zzl();
                    }
                    return zzlwVar.zzp();
                }
                return zzlwVar.zzm();
            }
            return zzlwVar.zzq();
        }
        return zzlwVar.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final String zzh() {
        return this.f17186b.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final String zzi() {
        return this.f17186b.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final String zzj() {
        return this.f17186b.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final String zzk() {
        return this.f17186b.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final List zzm(String str, String str2) {
        return this.f17186b.zzv(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final Map zzo(String str, String str2, boolean z) {
        return this.f17186b.zzx(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzp(String str) {
        zzio zzioVar = this.f17185a;
        zzioVar.zzd().zzd(str, zzioVar.zzaU().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzq(String str, String str2, Bundle bundle) {
        this.f17185a.zzq().zzJ(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzr(String str) {
        zzio zzioVar = this.f17185a;
        zzioVar.zzd().zze(str, zzioVar.zzaU().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzs(String str, String str2, Bundle bundle) {
        this.f17186b.zzO(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzt(String str, String str2, Bundle bundle, long j) {
        this.f17186b.zzP(str, str2, bundle, true, false, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzu(zzkc zzkcVar) {
        this.f17186b.zzV(zzkcVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzv(Bundle bundle) {
        this.f17186b.zzad(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzw(zzkb zzkbVar) {
        this.f17186b.zzah(zzkbVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlx
    public final void zzx(zzkc zzkcVar) {
        this.f17186b.zzao(zzkcVar);
    }
}
