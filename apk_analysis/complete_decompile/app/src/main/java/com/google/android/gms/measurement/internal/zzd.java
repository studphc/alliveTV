package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.hb3;

/* loaded from: classes.dex */
public final class zzd extends hb3 {

    /* renamed from: a */
    public final ArrayMap f14149a;

    /* renamed from: b */
    public final ArrayMap f14150b;

    /* renamed from: c */
    public long f14151c;

    public zzd(zzio zzioVar) {
        super(zzioVar);
        this.f14150b = new ArrayMap();
        this.f14149a = new ArrayMap();
    }

    /* renamed from: a */
    public final void m3521a(long j, zzmh zzmhVar) {
        if (zzmhVar == null) {
            this.zzu.zzaW().zzj().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            this.zzu.zzaW().zzj().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        zzqf.zzN(zzmhVar, bundle, true);
        this.zzu.zzq().m3567c("am", "_xa", bundle);
    }

    /* renamed from: b */
    public final void m3522b(String str, long j, zzmh zzmhVar) {
        if (zzmhVar == null) {
            this.zzu.zzaW().zzj().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            this.zzu.zzaW().zzj().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        zzqf.zzN(zzmhVar, bundle, true);
        this.zzu.zzq().m3567c("am", "_xu", bundle);
    }

    /* renamed from: c */
    public final void m3523c(long j) {
        ArrayMap arrayMap = this.f14149a;
        Iterator it = arrayMap.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put((String) it.next(), Long.valueOf(j));
        }
        if (!arrayMap.isEmpty()) {
            this.f14151c = j;
        }
    }

    public final void zzd(String str, long j) {
        if (str != null && str.length() != 0) {
            this.zzu.zzaX().zzq(new RunnableC0787a(this, str, j, 0));
        } else {
            AbstractC1726qj.m7039D(this.zzu, "Ad unit id must be a non-empty string");
        }
    }

    public final void zze(String str, long j) {
        if (str != null && str.length() != 0) {
            this.zzu.zzaX().zzq(new RunnableC0787a(this, str, j, 1));
        } else {
            AbstractC1726qj.m7039D(this.zzu, "Ad unit id must be a non-empty string");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final void zzf(long j) {
        zzmh zzj = this.zzu.zzt().zzj(false);
        ArrayMap arrayMap = this.f14149a;
        for (K k : arrayMap.keySet()) {
            m3522b(k, j - ((Long) arrayMap.get(k)).longValue(), zzj);
        }
        if (!arrayMap.isEmpty()) {
            m3521a(j - this.f14151c, zzj);
        }
        m3523c(j);
    }
}
