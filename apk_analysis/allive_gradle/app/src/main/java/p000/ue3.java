package p000;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzpv;

/* loaded from: classes.dex */
public final class ue3 {

    /* renamed from: a */
    public final zzpv f27242a;

    /* renamed from: b */
    public int f27243b = 1;

    /* renamed from: c */
    public long f27244c = m7703a();

    public ue3(zzpv zzpvVar) {
        this.f27242a = zzpvVar;
    }

    /* renamed from: a */
    public final long m7703a() {
        zzpv zzpvVar = this.f27242a;
        Preconditions.checkNotNull(zzpvVar);
        long longValue = ((Long) zzgi.zzu.zza(null)).longValue();
        long longValue2 = ((Long) zzgi.zzv.zza(null)).longValue();
        for (int i = 1; i < this.f27243b; i++) {
            longValue += longValue;
            if (longValue >= longValue2) {
                break;
            }
        }
        return Math.min(longValue, longValue2) + zzpvVar.zzaU().currentTimeMillis();
    }
}
