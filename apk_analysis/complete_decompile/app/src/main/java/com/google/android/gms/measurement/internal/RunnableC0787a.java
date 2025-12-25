package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import p000.AbstractC1726qj;
import p000.hb3;

/* renamed from: com.google.android.gms.measurement.internal.a */
/* loaded from: classes.dex */
public final class RunnableC0787a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f13973a;

    /* renamed from: b */
    public final /* synthetic */ Object f13974b;

    /* renamed from: c */
    public final /* synthetic */ long f13975c;

    /* renamed from: d */
    public final /* synthetic */ hb3 f13976d;

    public /* synthetic */ RunnableC0787a(hb3 hb3Var, Object obj, long j, int i) {
        this.f13973a = i;
        this.f13974b = obj;
        this.f13975c = j;
        this.f13976d = hb3Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13973a) {
            case 0:
                zzd zzdVar = (zzd) this.f13976d;
                zzdVar.zzg();
                String str = (String) this.f13974b;
                Preconditions.checkNotEmpty(str);
                ArrayMap arrayMap = zzdVar.f14150b;
                boolean isEmpty = arrayMap.isEmpty();
                long j = this.f13975c;
                if (isEmpty) {
                    zzdVar.f14151c = j;
                }
                Integer num = (Integer) arrayMap.get(str);
                if (num != null) {
                    arrayMap.put(str, Integer.valueOf(num.intValue() + 1));
                    return;
                } else if (arrayMap.size() >= 100) {
                    AbstractC1726qj.m7037B(zzdVar.zzu, "Too many ads visible");
                    return;
                } else {
                    arrayMap.put(str, 1);
                    zzdVar.f14149a.put(str, Long.valueOf(j));
                    return;
                }
            case 1:
                zzd zzdVar2 = (zzd) this.f13976d;
                zzdVar2.zzg();
                String str2 = (String) this.f13974b;
                Preconditions.checkNotEmpty(str2);
                ArrayMap arrayMap2 = zzdVar2.f14150b;
                Integer num2 = (Integer) arrayMap2.get(str2);
                if (num2 != null) {
                    zzmh zzj = zzdVar2.zzu.zzt().zzj(false);
                    int intValue = num2.intValue() - 1;
                    if (intValue == 0) {
                        arrayMap2.remove(str2);
                        ArrayMap arrayMap3 = zzdVar2.f14149a;
                        Long l = (Long) arrayMap3.get(str2);
                        long j2 = this.f13975c;
                        if (l == null) {
                            AbstractC1726qj.m7039D(zzdVar2.zzu, "First ad unit exposure time was never set");
                        } else {
                            long longValue = j2 - l.longValue();
                            arrayMap3.remove(str2);
                            zzdVar2.m3522b(str2, longValue, zzj);
                        }
                        if (arrayMap2.isEmpty()) {
                            long j3 = zzdVar2.f14151c;
                            if (j3 == 0) {
                                AbstractC1726qj.m7039D(zzdVar2.zzu, "First ad exposure time was never set");
                                return;
                            } else {
                                zzdVar2.m3521a(j2 - j3, zzj);
                                zzdVar2.f14151c = 0L;
                                return;
                            }
                        }
                        return;
                    }
                    arrayMap2.put(str2, Integer.valueOf(intValue));
                    return;
                }
                zzdVar2.zzu.zzaW().zze().zzb("Call to endAdUnitExposure for unknown ad unit id", str2);
                return;
            default:
                zzmo zzmoVar = (zzmo) this.f13976d;
                zzmoVar.m3579c((zzmh) this.f13974b, false, this.f13975c);
                zzmoVar.zza = null;
                zzmoVar.zzu.zzu().zzS(null);
                return;
        }
    }
}
