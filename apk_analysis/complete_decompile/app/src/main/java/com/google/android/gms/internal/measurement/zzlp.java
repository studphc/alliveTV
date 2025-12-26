package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Map;
import p000.ud3;
import p000.xc3;

/* loaded from: classes.dex */
public final class zzlp {

    /* renamed from: b */
    public static volatile zzlp f13880b;

    /* renamed from: c */
    public static final zzlp f13881c = new zzlp();
    public static final /* synthetic */ int zzb = 0;

    /* renamed from: a */
    public final Map f13882a = Collections.emptyMap();

    public static zzlp zza() {
        zzlp zzlpVar = f13880b;
        if (zzlpVar != null) {
            return zzlpVar;
        }
        synchronized (zzlp.class) {
            try {
                zzlp zzlpVar2 = f13880b;
                if (zzlpVar2 != null) {
                    return zzlpVar2;
                }
                ud3 ud3Var = ud3.f27230c;
                zzlp m3468a = zzlx.m3468a();
                f13880b = m3468a;
                return m3468a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzmc zzb(zznh zznhVar, int i) {
        return (zzmc) this.f13882a.get(new xc3(i, zznhVar));
    }
}
