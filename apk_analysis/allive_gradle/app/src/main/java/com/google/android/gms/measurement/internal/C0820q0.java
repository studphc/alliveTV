package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzhh;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import p000.l93;

/* renamed from: com.google.android.gms.measurement.internal.q0 */
/* loaded from: classes.dex */
public final class C0820q0 {

    /* renamed from: a */
    public final String f14074a;

    /* renamed from: b */
    public final boolean f14075b;

    /* renamed from: c */
    public final zzic f14076c;

    /* renamed from: d */
    public final BitSet f14077d;

    /* renamed from: e */
    public final BitSet f14078e;

    /* renamed from: f */
    public final ArrayMap f14079f;

    /* renamed from: g */
    public final ArrayMap f14080g;

    /* renamed from: h */
    public final /* synthetic */ l93 f14081h;

    public /* synthetic */ C0820q0(l93 l93Var, String str) {
        this.f14081h = l93Var;
        this.f14074a = str;
        this.f14075b = true;
        this.f14077d = new BitSet();
        this.f14078e = new BitSet();
        this.f14079f = new ArrayMap();
        this.f14080g = new ArrayMap();
    }

    /* renamed from: a */
    public final zzhi m3502a(int i) {
        ArrayList arrayList;
        List list;
        zzhh zzb = zzhi.zzb();
        zzb.zza(i);
        zzb.zzc(this.f14075b);
        zzic zzicVar = this.f14076c;
        if (zzicVar != null) {
            zzb.zzd(zzicVar);
        }
        com.google.android.gms.internal.measurement.zzib zze = zzic.zze();
        zze.zzb(zzqa.m3664B(this.f14077d));
        zze.zzd(zzqa.m3664B(this.f14078e));
        ArrayMap arrayMap = this.f14079f;
        if (arrayMap == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(arrayMap.size());
            for (Integer num : arrayMap.keySet()) {
                int intValue = num.intValue();
                Long l = (Long) arrayMap.get(num);
                if (l != null) {
                    com.google.android.gms.internal.measurement.zzhj zzc = com.google.android.gms.internal.measurement.zzhk.zzc();
                    zzc.zzb(intValue);
                    zzc.zza(l.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.zzhk) zzc.zzba());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zze.zza(arrayList);
        }
        ArrayMap arrayMap2 = this.f14080g;
        if (arrayMap2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(arrayMap2.size());
            for (Integer num2 : arrayMap2.keySet()) {
                zzid zzd = zzie.zzd();
                zzd.zzb(num2.intValue());
                List list2 = (List) arrayMap2.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd.zza(list2);
                }
                arrayList3.add((zzie) zzd.zzba());
            }
            list = arrayList3;
        }
        zze.zzc(list);
        zzb.zzb(zze);
        return (zzhi) zzb.zzba();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final void m3503b(C0789b c0789b) {
        int zzb;
        boolean z;
        boolean zzo;
        switch (c0789b.f13985g) {
            case 0:
                zzb = ((com.google.android.gms.internal.measurement.zzfj) c0789b.f13987i).zzb();
                break;
            default:
                zzb = ((com.google.android.gms.internal.measurement.zzfr) c0789b.f13987i).zza();
                break;
        }
        if (c0789b.f13981c != null) {
            this.f14078e.set(zzb, true);
        }
        Boolean bool = c0789b.f13982d;
        if (bool != null) {
            this.f14077d.set(zzb, bool.booleanValue());
        }
        if (c0789b.f13983e != null) {
            Integer valueOf = Integer.valueOf(zzb);
            ArrayMap arrayMap = this.f14079f;
            Long l = (Long) arrayMap.get(valueOf);
            long longValue = c0789b.f13983e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                arrayMap.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (c0789b.f13984f != null) {
            ArrayMap arrayMap2 = this.f14080g;
            Integer valueOf2 = Integer.valueOf(zzb);
            List list = (List) arrayMap2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                arrayMap2.put(valueOf2, list);
            }
            switch (c0789b.f13985g) {
                case 0:
                    z = false;
                    break;
                default:
                    z = true;
                    break;
            }
            if (z) {
                list.clear();
            }
            zzpq.zzb();
            zzio zzioVar = this.f14081h.zzu;
            zzam zzf = zzioVar.zzf();
            zzgg zzggVar = zzgi.zzaE;
            String str = this.f14074a;
            if (zzf.zzx(str, zzggVar)) {
                switch (c0789b.f13985g) {
                    case 0:
                        zzo = ((com.google.android.gms.internal.measurement.zzfj) c0789b.f13987i).zzo();
                        break;
                    default:
                        zzo = false;
                        break;
                }
                if (zzo) {
                    list.clear();
                }
            }
            zzpq.zzb();
            if (zzioVar.zzf().zzx(str, zzggVar)) {
                Long valueOf3 = Long.valueOf(c0789b.f13984f.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(c0789b.f13984f.longValue() / 1000));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ C0820q0(l93 l93Var, String str, zzic zzicVar, BitSet bitSet, BitSet bitSet2, ArrayMap arrayMap, ArrayMap arrayMap2) {
        this.f14081h = l93Var;
        this.f14074a = str;
        this.f14077d = bitSet;
        this.f14078e = bitSet2;
        this.f14079f = arrayMap;
        this.f14080g = new ArrayMap();
        for (K k : arrayMap2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) arrayMap2.get(k));
            this.f14080g.put(k, arrayList);
        }
        this.f14075b = false;
        this.f14076c = zzicVar;
    }
}
