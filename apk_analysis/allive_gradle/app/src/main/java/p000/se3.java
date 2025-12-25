package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzhx;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzpv;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class se3 {

    /* renamed from: a */
    public zzhx f26396a;

    /* renamed from: b */
    public ArrayList f26397b;

    /* renamed from: c */
    public ArrayList f26398c;

    /* renamed from: d */
    public long f26399d;

    /* renamed from: e */
    public final /* synthetic */ zzpv f26400e;

    public /* synthetic */ se3(zzpv zzpvVar) {
        this.f26400e = zzpvVar;
    }

    /* renamed from: a */
    public final boolean m7369a(long j, zzhm zzhmVar) {
        Preconditions.checkNotNull(zzhmVar);
        if (this.f26398c == null) {
            this.f26398c = new ArrayList();
        }
        if (this.f26397b == null) {
            this.f26397b = new ArrayList();
        }
        if (!this.f26398c.isEmpty() && ((((zzhm) this.f26398c.get(0)).zzd() / 1000) / 60) / 60 != ((zzhmVar.zzd() / 1000) / 60) / 60) {
            return false;
        }
        long zzcf = this.f26399d + zzhmVar.zzcf();
        zzpv zzpvVar = this.f26400e;
        if (zzpvVar.zzi().zzx(null, zzgi.zzbq)) {
            if (!this.f26398c.isEmpty()) {
                zzpvVar.zzi();
                if (zzcf >= zzam.zzG()) {
                    return false;
                }
            }
        } else {
            zzpvVar.zzi();
            if (zzcf >= zzam.zzG()) {
                return false;
            }
        }
        this.f26399d = zzcf;
        this.f26398c.add(zzhmVar);
        this.f26397b.add(Long.valueOf(j));
        int size = this.f26398c.size();
        zzpvVar.zzi();
        if (size >= Math.max(1, ((Integer) zzgi.zzj.zza(null)).intValue())) {
            return false;
        }
        return true;
    }
}
