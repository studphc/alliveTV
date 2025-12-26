package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzax {

    /* renamed from: a */
    public final HashMap f13787a = new HashMap();

    /* renamed from: b */
    public final zzbj f13788b = new zzbj();

    public zzax() {
        m3284a(new zzav());
        m3284a(new zzay());
        m3284a(new zzaz());
        m3284a(new zzbc());
        m3284a(new zzbh());
        m3284a(new zzbi());
        m3284a(new zzbk());
    }

    /* renamed from: a */
    public final void m3284a(zzaw zzawVar) {
        Iterator it = zzawVar.f13786a.iterator();
        while (it.hasNext()) {
            this.f13787a.put(((zzbl) it.next()).zzb().toString(), zzawVar);
        }
    }

    public final zzap zza(zzg zzgVar, zzap zzapVar) {
        zzaw zzawVar;
        zzh.zzc(zzgVar);
        if (zzapVar instanceof zzaq) {
            zzaq zzaqVar = (zzaq) zzapVar;
            ArrayList zzc = zzaqVar.zzc();
            String zzb = zzaqVar.zzb();
            HashMap hashMap = this.f13787a;
            if (hashMap.containsKey(zzb)) {
                zzawVar = (zzaw) hashMap.get(zzb);
            } else {
                zzawVar = this.f13788b;
            }
            return zzawVar.zza(zzb, zzgVar, zzc);
        }
        return zzapVar;
    }
}
