package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import p000.ad3;
import p000.jd3;
import p000.le3;
import p000.oc3;
import p000.wc3;
import p000.xd3;
import p000.yd3;
import p000.zc3;

/* renamed from: com.google.android.gms.internal.measurement.e */
/* loaded from: classes.dex */
public final class C0785e implements xd3 {

    /* renamed from: a */
    public final zznh f13765a;

    /* renamed from: b */
    public final C0782b f13766b;

    /* renamed from: c */
    public final boolean f13767c;

    public C0785e(C0782b c0782b, zznh zznhVar) {
        C0782b c0782b2 = zc3.f29312a;
        this.f13766b = c0782b;
        this.f13767c = zznhVar instanceof zzma;
        this.f13765a = zznhVar;
    }

    @Override // p000.xd3
    /* renamed from: a */
    public final void mo3234a(Object obj) {
        this.f13766b.getClass();
        C0782b.m3219b(obj);
        C0782b c0782b = zc3.f29312a;
        C0782b.m3218a(obj);
    }

    @Override // p000.xd3
    /* renamed from: b */
    public final void mo3235b(Object obj, le3 le3Var) {
        Iterator m71b = ((zzma) obj).zzb.m71b();
        while (m71b.hasNext()) {
            Map.Entry entry = (Map.Entry) m71b.next();
            zzlt zzltVar = (zzlt) entry.getKey();
            if (zzltVar.zzc() == zzoq.zzi && !zzltVar.zze() && !zzltVar.zzd()) {
                if (entry instanceof jd3) {
                    ((wc3) le3Var).m8045r(zzltVar.zza(), ((zzmr) ((jd3) entry).f20475a.getValue()).zzb());
                } else {
                    ((wc3) le3Var).m8045r(zzltVar.zza(), entry.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        zzof zzofVar = ((zzmd) obj).zzc;
        for (int i = 0; i < zzofVar.f13894a; i++) {
            ((wc3) le3Var).m8045r(zzofVar.f13895b[i] >>> 3, zzofVar.f13896c[i]);
        }
    }

    @Override // p000.xd3
    /* renamed from: c */
    public final void mo3236c(Object obj, byte[] bArr, int i, int i2, oc3 oc3Var) {
        zzmd zzmdVar = (zzmd) obj;
        if (zzmdVar.zzc == zzof.zzc()) {
            zzmdVar.zzc = zzof.m3477a();
        }
        throw null;
    }

    @Override // p000.xd3
    /* renamed from: d */
    public final boolean mo3237d(zzmd zzmdVar, Object obj) {
        if (!zzmdVar.zzc.equals(((zzmd) obj).zzc)) {
            return false;
        }
        if (this.f13767c) {
            return ((zzma) zzmdVar).zzb.equals(((zzma) obj).zzb);
        }
        return true;
    }

    @Override // p000.xd3
    /* renamed from: e */
    public final int mo3238e(zzmd zzmdVar) {
        int zzb = zzmdVar.zzc.zzb();
        if (this.f13767c) {
            yd3 yd3Var = ((zzma) zzmdVar).zzb.f144a;
            int i = yd3Var.f28915b;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                i2 += ad3.m69g(yd3Var.m8270f(i3));
            }
            Iterator it = yd3Var.m8268c().iterator();
            while (it.hasNext()) {
                i2 += ad3.m69g((Map.Entry) it.next());
            }
            return zzb + i2;
        }
        return zzb;
    }

    @Override // p000.xd3
    /* renamed from: f */
    public final boolean mo3239f(Object obj) {
        return ((zzma) obj).zzb.m74e();
    }

    @Override // p000.xd3
    /* renamed from: g */
    public final void mo3240g(Object obj, Object obj2) {
        AbstractC0786f.m3275s(obj, obj2);
        if (this.f13767c) {
            C0782b c0782b = zc3.f29312a;
            if (((zzma) obj2).zzb.f144a.isEmpty()) {
                return;
            }
            throw null;
        }
    }

    @Override // p000.xd3
    /* renamed from: h */
    public final int mo3241h(zzmd zzmdVar) {
        int hashCode = zzmdVar.zzc.hashCode();
        if (this.f13767c) {
            return ((zzma) zzmdVar).zzb.f144a.hashCode() + (hashCode * 53);
        }
        return hashCode;
    }

    @Override // p000.xd3
    public final Object zze() {
        zznh zznhVar = this.f13765a;
        if (zznhVar instanceof zzmd) {
            return (zzmd) ((zzmd) zznhVar).zzl(4, null, null);
        }
        return zznhVar.zzcA().zzbc();
    }
}
