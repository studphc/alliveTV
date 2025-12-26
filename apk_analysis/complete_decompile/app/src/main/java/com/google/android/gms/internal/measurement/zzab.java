package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzab {

    /* renamed from: a */
    public zzaa f13773a;

    /* renamed from: b */
    public zzaa f13774b;

    /* renamed from: c */
    public final ArrayList f13775c;

    public zzab() {
        this.f13773a = new zzaa("", 0L, null);
        this.f13774b = new zzaa("", 0L, null);
        this.f13775c = new ArrayList();
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzab zzabVar = new zzab(this.f13773a.clone());
        Iterator it = this.f13775c.iterator();
        while (it.hasNext()) {
            zzabVar.f13775c.add(((zzaa) it.next()).clone());
        }
        return zzabVar;
    }

    public final zzaa zza() {
        return this.f13773a;
    }

    public final zzaa zzb() {
        return this.f13774b;
    }

    public final List zzc() {
        return this.f13775c;
    }

    public final void zzd(zzaa zzaaVar) {
        this.f13773a = zzaaVar;
        this.f13774b = zzaaVar.clone();
        this.f13775c.clear();
    }

    public final void zze(String str, long j, Map map) {
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            hashMap.put(str2, zzaa.zzd(str2, this.f13773a.zzc(str2), map.get(str2)));
        }
        this.f13775c.add(new zzaa(str, j, hashMap));
    }

    public final void zzf(zzaa zzaaVar) {
        this.f13774b = zzaaVar;
    }

    public zzab(zzaa zzaaVar) {
        this.f13773a = zzaaVar;
        this.f13774b = zzaaVar.clone();
        this.f13775c = new ArrayList();
    }
}
