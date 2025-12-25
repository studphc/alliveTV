package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zziv;
import com.google.android.gms.internal.measurement.zzmm;
import com.google.android.gms.internal.measurement.zzn;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import p000.AbstractC1726qj;
import p000.jz2;
import p000.ob3;
import p000.pe3;
import p000.r93;
import p000.re3;
import p000.v93;

/* loaded from: classes.dex */
public final class zzif extends re3 implements r93 {

    /* renamed from: b */
    public final ArrayMap f14226b;

    /* renamed from: c */
    public final ArrayMap f14227c;

    /* renamed from: d */
    public final ArrayMap f14228d;

    /* renamed from: e */
    public final ArrayMap f14229e;

    /* renamed from: f */
    public final ArrayMap f14230f;

    /* renamed from: g */
    public final ArrayMap f14231g;

    /* renamed from: h */
    public final C0797f f14232h;

    /* renamed from: i */
    public final C0799g f14233i;

    /* renamed from: j */
    public final ArrayMap f14234j;

    /* renamed from: k */
    public final ArrayMap f14235k;

    /* renamed from: l */
    public final ArrayMap f14236l;

    public zzif(zzpv zzpvVar) {
        super(zzpvVar);
        this.f14226b = new ArrayMap();
        this.f14227c = new ArrayMap();
        this.f14228d = new ArrayMap();
        this.f14229e = new ArrayMap();
        this.f14230f = new ArrayMap();
        this.f14234j = new ArrayMap();
        this.f14235k = new ArrayMap();
        this.f14236l = new ArrayMap();
        this.f14231g = new ArrayMap();
        this.f14232h = new C0797f(this);
        this.f14233i = new C0799g(this);
    }

    /* renamed from: g */
    public static final ArrayMap m3536g(com.google.android.gms.internal.measurement.zzgo zzgoVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzgoVar != null) {
            for (com.google.android.gms.internal.measurement.zzgw zzgwVar : zzgoVar.zzp()) {
                arrayMap.put(zzgwVar.zzb(), zzgwVar.zzc());
            }
        }
        return arrayMap;
    }

    /* renamed from: h */
    public static final zzjw m3537h(int i) {
        int i2 = i - 1;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return zzjw.AD_PERSONALIZATION;
                }
                return zzjw.AD_USER_DATA;
            }
            return zzjw.ANALYTICS_STORAGE;
        }
        return zzjw.AD_STORAGE;
    }

    /* renamed from: a */
    public final boolean m3538a(String str) {
        zzg();
        m3542e(str);
        ArrayMap arrayMap = this.f14227c;
        if (arrayMap.get(str) != 0 && ((Set) arrayMap.get(str)).contains("app_instance_id")) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final boolean m3539b(String str) {
        zzg();
        m3542e(str);
        ArrayMap arrayMap = this.f14227c;
        if (arrayMap.get(str) == 0) {
            return false;
        }
        if (!((Set) arrayMap.get(str)).contains("os_version") && !((Set) arrayMap.get(str)).contains("device_info")) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public final com.google.android.gms.internal.measurement.zzgo m3540c(String str, byte[] bArr) {
        Long l;
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzgo.zzh();
        }
        try {
            com.google.android.gms.internal.measurement.zzgo zzgoVar = (com.google.android.gms.internal.measurement.zzgo) ((com.google.android.gms.internal.measurement.zzgn) zzqa.m3683x(com.google.android.gms.internal.measurement.zzgo.zzf(), bArr)).zzba();
            zzhc zzj = this.zzu.zzaW().zzj();
            String str2 = null;
            if (zzgoVar.zzw()) {
                l = Long.valueOf(zzgoVar.zzc());
            } else {
                l = null;
            }
            if (zzgoVar.zzu()) {
                str2 = zzgoVar.zzj();
            }
            zzj.zzc("Parsed config. version, gmp_app_id", l, str2);
            return zzgoVar;
        } catch (zzmm e) {
            this.zzu.zzaW().zzk().zzc("Unable to merge remote config. appId", zzhe.zzn(str), e);
            return com.google.android.gms.internal.measurement.zzgo.zzh();
        } catch (RuntimeException e2) {
            this.zzu.zzaW().zzk().zzc("Unable to merge remote config. appId", zzhe.zzn(str), e2);
            return com.google.android.gms.internal.measurement.zzgo.zzh();
        }
    }

    /* renamed from: d */
    public final void m3541d(String str, com.google.android.gms.internal.measurement.zzgn zzgnVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = zzgnVar.zzh().iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.zzgk) it.next()).zzb());
        }
        for (int i = 0; i < zzgnVar.zza(); i++) {
            com.google.android.gms.internal.measurement.zzgl zzglVar = (com.google.android.gms.internal.measurement.zzgl) zzgnVar.zzb(i).zzch();
            if (zzglVar.zzc().isEmpty()) {
                AbstractC1726qj.m7037B(this.zzu, "EventConfig contained null event name");
            } else {
                String zzc = zzglVar.zzc();
                String zzb = zzjy.zzb(zzglVar.zzc());
                if (!TextUtils.isEmpty(zzb)) {
                    zzglVar.zzb(zzb);
                    zzgnVar.zze(i, zzglVar);
                }
                if (zzglVar.zzf() && zzglVar.zzd()) {
                    arrayMap.put(zzc, Boolean.TRUE);
                }
                if (zzglVar.zzg() && zzglVar.zze()) {
                    arrayMap2.put(zzglVar.zzc(), Boolean.TRUE);
                }
                if (zzglVar.zzh()) {
                    if (zzglVar.zza() >= 2 && zzglVar.zza() <= 65535) {
                        arrayMap3.put(zzglVar.zzc(), Integer.valueOf(zzglVar.zza()));
                    } else {
                        this.zzu.zzaW().zzk().zzc("Invalid sampling rate. Event name, sample rate", zzglVar.zzc(), Integer.valueOf(zzglVar.zza()));
                    }
                }
            }
        }
        this.f14227c.put(str, hashSet);
        this.f14228d.put(str, arrayMap);
        this.f14229e.put(str, arrayMap2);
        this.f14231g.put(str, arrayMap3);
    }

    /* renamed from: e */
    public final void m3542e(String str) {
        zzav();
        zzg();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = this.f14230f;
        if (arrayMap.get(str) == 0) {
            jz2 m7844T = this.zzg.zzj().m7844T(str);
            ArrayMap arrayMap2 = this.f14236l;
            ArrayMap arrayMap3 = this.f14235k;
            ArrayMap arrayMap4 = this.f14234j;
            ArrayMap arrayMap5 = this.f14226b;
            if (m7844T == null) {
                arrayMap5.put(str, null);
                this.f14228d.put(str, null);
                this.f14227c.put(str, null);
                this.f14229e.put(str, null);
                arrayMap.put(str, null);
                arrayMap4.put(str, null);
                arrayMap3.put(str, null);
                arrayMap2.put(str, null);
                this.f14231g.put(str, null);
                return;
            }
            com.google.android.gms.internal.measurement.zzgn zzgnVar = (com.google.android.gms.internal.measurement.zzgn) m3540c(str, (byte[]) m7844T.f20698b).zzch();
            m3541d(str, zzgnVar);
            arrayMap5.put(str, m3536g((com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba()));
            arrayMap.put(str, (com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba());
            m3543f(str, (com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba());
            arrayMap4.put(str, zzgnVar.zzf());
            arrayMap3.put(str, (String) m7844T.f20699c);
            arrayMap2.put(str, (String) m7844T.f20700d);
        }
    }

    /* renamed from: f */
    public final void m3543f(final String str, com.google.android.gms.internal.measurement.zzgo zzgoVar) {
        int zza = zzgoVar.zza();
        C0797f c0797f = this.f14232h;
        if (zza != 0) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzj().zzb("EES programs found", Integer.valueOf(zzgoVar.zza()));
            zziv zzivVar = (zziv) zzgoVar.zzo().get(0);
            try {
                zzc zzcVar = new zzc();
                zzcVar.zzd("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhy
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new zzn("internal.remoteConfig", new pe3(zzif.this, str));
                    }
                });
                zzcVar.zzd("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhz
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        final zzif zzifVar = zzif.this;
                        final String str2 = str;
                        return new com.google.android.gms.internal.measurement.zzu("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzib
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                zzif zzifVar2 = zzif.this;
                                v93 zzj = zzifVar2.zzg.zzj();
                                String str3 = str2;
                                ob3 m7842R = zzj.m7842R(str3);
                                HashMap hashMap = new HashMap();
                                hashMap.put("platform", "android");
                                hashMap.put("package_name", str3);
                                zzifVar2.zzu.zzf().zzj();
                                hashMap.put("gmp_version", 119002L);
                                if (m7842R != null) {
                                    String m6538e = m7842R.m6538e();
                                    if (m6538e != null) {
                                        hashMap.put("app_version", m6538e);
                                    }
                                    hashMap.put("app_version_int", Long.valueOf(m7842R.m6533G()));
                                    m7842R.f23733a.zzaX().zzg();
                                    hashMap.put("dynamite_version", Long.valueOf(m7842R.f23751s));
                                }
                                return hashMap;
                            }
                        });
                    }
                });
                zzcVar.zzd("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzia
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new com.google.android.gms.internal.measurement.zzt(zzif.this.f14233i);
                    }
                });
                zzcVar.zzc(zzivVar);
                c0797f.put(str, zzcVar);
                zzioVar.zzaW().zzj().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzivVar.zza().zza()));
                Iterator it = zzivVar.zza().zzd().iterator();
                while (it.hasNext()) {
                    zzioVar.zzaW().zzj().zzb("EES program activity", ((com.google.android.gms.internal.measurement.zzit) it.next()).zzb());
                }
                return;
            } catch (com.google.android.gms.internal.measurement.zzd unused) {
                this.zzu.zzaW().zze().zzb("Failed to load EES program. appId", str);
                return;
            }
        }
        c0797f.remove(str);
    }

    /* renamed from: i */
    public final int m3544i(String str, String str2) {
        Integer num;
        zzg();
        m3542e(str);
        Map map = (Map) this.f14231g.get(str);
        if (map != null && (num = (Integer) map.get(str2)) != null) {
            return num.intValue();
        }
        return 1;
    }

    /* renamed from: j */
    public final zzju m3545j(String str, zzjw zzjwVar) {
        zzg();
        m3542e(str);
        com.google.android.gms.internal.measurement.zzgi m3546k = m3546k(str);
        if (m3546k == null) {
            return zzju.UNINITIALIZED;
        }
        for (com.google.android.gms.internal.measurement.zzfz zzfzVar : m3546k.zzf()) {
            if (m3537h(zzfzVar.zzc()) == zzjwVar) {
                int zzb = zzfzVar.zzb() - 1;
                if (zzb != 1) {
                    if (zzb != 2) {
                        return zzju.UNINITIALIZED;
                    }
                    return zzju.DENIED;
                }
                return zzju.GRANTED;
            }
        }
        return zzju.UNINITIALIZED;
    }

    /* renamed from: k */
    public final com.google.android.gms.internal.measurement.zzgi m3546k(String str) {
        zzg();
        m3542e(str);
        com.google.android.gms.internal.measurement.zzgo zzj = zzj(str);
        if (zzj != null && zzj.zzt()) {
            return zzj.zzd();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l */
    public final String m3547l(String str) {
        zzg();
        m3542e(str);
        return (String) this.f14234j.get(str);
    }

    /* renamed from: m */
    public final boolean m3548m(String str, zzjw zzjwVar) {
        zzg();
        m3542e(str);
        com.google.android.gms.internal.measurement.zzgi m3546k = m3546k(str);
        if (m3546k == null) {
            return false;
        }
        Iterator it = m3546k.zzd().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.google.android.gms.internal.measurement.zzfz zzfzVar = (com.google.android.gms.internal.measurement.zzfz) it.next();
            if (zzjwVar == m3537h(zzfzVar.zzc())) {
                if (zzfzVar.zzb() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: n */
    public final boolean m3549n(String str, String str2) {
        Boolean bool;
        zzg();
        m3542e(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = (Map) this.f14229e.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* renamed from: o */
    public final boolean m3550o(String str, String str2) {
        Boolean bool;
        zzg();
        m3542e(str);
        if (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(zza(str, "measurement.upload.blacklist_internal")) && zzqf.m3699E(str2)) {
            return true;
        }
        if (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(zza(str, "measurement.upload.blacklist_public")) && zzqf.m3700F(str2)) {
            return true;
        }
        Map map = (Map) this.f14228d.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // p000.r93
    @WorkerThread
    public final String zza(String str, String str2) {
        zzg();
        m3542e(str);
        Map map = (Map) this.f14226b.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @Override // p000.re3
    public final boolean zzb() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final com.google.android.gms.internal.measurement.zzgo zzj(String str) {
        zzav();
        zzg();
        Preconditions.checkNotEmpty(str);
        m3542e(str);
        return (com.google.android.gms.internal.measurement.zzgo) this.f14230f.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final String zzk(String str) {
        zzg();
        return (String) this.f14236l.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final String zzl(String str) {
        zzg();
        return (String) this.f14235k.get(str);
    }

    @WorkerThread
    public final void zzq(String str) {
        zzg();
        this.f14235k.put(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzs(String str) {
        com.google.android.gms.internal.measurement.zzgo zzgoVar;
        if (TextUtils.isEmpty(str) || (zzgoVar = (com.google.android.gms.internal.measurement.zzgo) this.f14230f.get(str)) == null || zzgoVar.zza() == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02e0, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02c4, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x026c, code lost:
    
        r0 = r7.zzu.zzaW().zzk();
        r6 = com.google.android.gms.measurement.internal.zzhe.zzn(r29);
        r12 = java.lang.Integer.valueOf(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0284, code lost:
    
        if (r9.zzp() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0286, code lost:
    
        r17 = java.lang.Integer.valueOf(r9.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0293, code lost:
    
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r6, r12, java.lang.String.valueOf(r17));
        r23 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0291, code lost:
    
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0326, code lost:
    
        r23 = r3;
        r0 = r0.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0334, code lost:
    
        if (r0.hasNext() == false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0336, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzfr) r0.next();
        r7.zzav();
        r7.zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0350, code lost:
    
        if (r3.zze().isEmpty() == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0382, code lost:
    
        r6 = r3.zzcd();
        r9 = new android.content.ContentValues();
        r9.put("app_id", r29);
        r24 = r0;
        r9.put(r4, java.lang.Integer.valueOf(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x039b, code lost:
    
        if (r3.zzj() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x039d, code lost:
    
        r0 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x03a7, code lost:
    
        r9.put("filter_id", r0);
        r25 = r4;
        r9.put("property_name", r3.zze());
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x03b9, code lost:
    
        if (r3.zzk() == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x03bb, code lost:
    
        r0 = java.lang.Boolean.valueOf(r3.zzi());
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x03c5, code lost:
    
        r9.put("session_scoped", r0);
        r9.put(com.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x03d9, code lost:
    
        if (r7.m7841Q().insertWithOnConflict("property_filters", null, r9, 5) != (-1)) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x03f1, code lost:
    
        r0 = r24;
        r4 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x03db, code lost:
    
        r7.zzu.zzaW().zze().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzhe.zzn(r29));
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03ef, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03f7, code lost:
    
        r7.zzu.zzaW().zze().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r29), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03c4, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03a6, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0352, code lost:
    
        r0 = r7.zzu.zzaW().zzk();
        r6 = com.google.android.gms.measurement.internal.zzhe.zzn(r29);
        r9 = java.lang.Integer.valueOf(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x036a, code lost:
    
        if (r3.zzj() == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x036c, code lost:
    
        r17 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0379, code lost:
    
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r6, r9, java.lang.String.valueOf(r17));
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0377, code lost:
    
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0205, code lost:
    
        r6 = r0.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0211, code lost:
    
        if (r6.hasNext() == false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x021d, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzfr) r6.next()).zzj() != false) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x021f, code lost:
    
        r7.zzu.zzaW().zzk().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzhe.zzn(r29), java.lang.Integer.valueOf(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0238, code lost:
    
        r6 = r0.zzg().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0244, code lost:
    
        r4 = "audience_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x024e, code lost:
    
        if (r6.hasNext() == false) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0250, code lost:
    
        r9 = (com.google.android.gms.internal.measurement.zzfj) r6.next();
        r7.zzav();
        r7.zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x026a, code lost:
    
        if (r9.zzg().isEmpty() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x029e, code lost:
    
        r23 = r3;
        r3 = r9.zzcd();
        r24 = r6;
        r6 = new android.content.ContentValues();
        r6.put("app_id", r29);
        r6.put("audience_id", java.lang.Integer.valueOf(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02b9, code lost:
    
        if (r9.zzp() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02bb, code lost:
    
        r4 = java.lang.Integer.valueOf(r9.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02c5, code lost:
    
        r6.put("filter_id", r4);
        r6.put("event_name", r9.zzg());
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02d5, code lost:
    
        if (r9.zzq() == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02d7, code lost:
    
        r4 = java.lang.Boolean.valueOf(r9.zzn());
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02e1, code lost:
    
        r6.put("session_scoped", r4);
        r6.put(com.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02f5, code lost:
    
        if (r7.m7841Q().insertWithOnConflict("event_filters", null, r6, 5) != (-1)) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02f7, code lost:
    
        r7.zzu.zzaW().zze().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzhe.zzn(r29));
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x030a, code lost:
    
        r3 = r23;
        r6 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0310, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0311, code lost:
    
        r7.zzu.zzaW().zze().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r29), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x040a, code lost:
    
        r7.zzav();
        r7.zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29);
        r0 = r7.m7841Q();
        r4 = r20;
        r0.delete("property_filters", r4, new java.lang.String[]{r29, java.lang.String.valueOf(r5)});
        r0.delete("event_filters", r4, new java.lang.String[]{r29, java.lang.String.valueOf(r5)});
        r20 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0431, code lost:
    
        r3 = r23;
     */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzz(String str, byte[] bArr, String str2, String str3) {
        zzif zzifVar;
        byte[] bArr2;
        Integer num;
        boolean z;
        zzav();
        zzg();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzgn zzgnVar = (com.google.android.gms.internal.measurement.zzgn) m3540c(str, bArr).zzch();
        m3541d(str, zzgnVar);
        m3543f(str, (com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba());
        com.google.android.gms.internal.measurement.zzgo zzgoVar = (com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba();
        ArrayMap arrayMap = this.f14230f;
        arrayMap.put(str, zzgoVar);
        this.f14234j.put(str, zzgnVar.zzf());
        this.f14235k.put(str, str2);
        this.f14236l.put(str, str3);
        this.f14226b.put(str, m3536g((com.google.android.gms.internal.measurement.zzgo) zzgnVar.zzba()));
        v93 zzj = this.zzg.zzj();
        ArrayList arrayList = new ArrayList(zzgnVar.zzg());
        zzj.getClass();
        String str4 = "app_id=? and audience_id=?";
        Preconditions.checkNotNull(arrayList);
        int i = 0;
        while (i < arrayList.size()) {
            com.google.android.gms.internal.measurement.zzfg zzfgVar = (com.google.android.gms.internal.measurement.zzfg) ((com.google.android.gms.internal.measurement.zzfh) arrayList.get(i)).zzch();
            if (zzfgVar.zza() != 0) {
                int i2 = 0;
                while (i2 < zzfgVar.zza()) {
                    com.google.android.gms.internal.measurement.zzfi zzfiVar = (com.google.android.gms.internal.measurement.zzfi) zzfgVar.zze(i2).zzch();
                    ArrayMap arrayMap2 = arrayMap;
                    com.google.android.gms.internal.measurement.zzfi zzfiVar2 = (com.google.android.gms.internal.measurement.zzfi) zzfiVar.clone();
                    String zzb = zzjy.zzb(zzfiVar.zze());
                    if (zzb != null) {
                        zzfiVar2.zzb(zzb);
                        z = true;
                    } else {
                        z = false;
                    }
                    int i3 = 0;
                    while (i3 < zzfiVar.zza()) {
                        com.google.android.gms.internal.measurement.zzfl zzd = zzfiVar.zzd(i3);
                        com.google.android.gms.internal.measurement.zzfi zzfiVar3 = zzfiVar;
                        com.google.android.gms.internal.measurement.zzgn zzgnVar2 = zzgnVar;
                        String str5 = str4;
                        String zzb2 = zzmg.zzb(zzd.zze(), zzjz.zza, zzjz.zzb);
                        if (zzb2 != null) {
                            com.google.android.gms.internal.measurement.zzfk zzfkVar = (com.google.android.gms.internal.measurement.zzfk) zzd.zzch();
                            zzfkVar.zza(zzb2);
                            zzfiVar2.zzc(i3, (com.google.android.gms.internal.measurement.zzfl) zzfkVar.zzba());
                            z = true;
                        }
                        i3++;
                        zzfiVar = zzfiVar3;
                        zzgnVar = zzgnVar2;
                        str4 = str5;
                    }
                    com.google.android.gms.internal.measurement.zzgn zzgnVar3 = zzgnVar;
                    String str6 = str4;
                    if (z) {
                        zzfgVar.zzc(i2, zzfiVar2);
                        arrayList.set(i, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzba());
                    }
                    i2++;
                    arrayMap = arrayMap2;
                    zzgnVar = zzgnVar3;
                    str4 = str6;
                }
            }
            com.google.android.gms.internal.measurement.zzgn zzgnVar4 = zzgnVar;
            ArrayMap arrayMap3 = arrayMap;
            String str7 = str4;
            if (zzfgVar.zzb() != 0) {
                for (int i4 = 0; i4 < zzfgVar.zzb(); i4++) {
                    com.google.android.gms.internal.measurement.zzfr zzf = zzfgVar.zzf(i4);
                    String zzb3 = zzmg.zzb(zzf.zze(), zzka.zza, zzka.zzb);
                    if (zzb3 != null) {
                        com.google.android.gms.internal.measurement.zzfq zzfqVar = (com.google.android.gms.internal.measurement.zzfq) zzf.zzch();
                        zzfqVar.zza(zzb3);
                        zzfgVar.zzd(i4, zzfqVar);
                        arrayList.set(i, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzba());
                    }
                }
            }
            i++;
            arrayMap = arrayMap3;
            zzgnVar = zzgnVar4;
            str4 = str7;
        }
        com.google.android.gms.internal.measurement.zzgn zzgnVar5 = zzgnVar;
        ArrayMap arrayMap4 = arrayMap;
        String str8 = str4;
        zzj.zzav();
        zzj.zzg();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(arrayList);
        SQLiteDatabase m7841Q = zzj.m7841Q();
        m7841Q.beginTransaction();
        try {
            zzj.zzav();
            zzj.zzg();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase m7841Q2 = zzj.m7841Q();
            m7841Q2.delete("property_filters", "app_id=?", new String[]{str});
            m7841Q2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzfh zzfhVar = (com.google.android.gms.internal.measurement.zzfh) it.next();
                zzj.zzav();
                zzj.zzg();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfhVar);
                if (!zzfhVar.zzk()) {
                    zzj.zzu.zzaW().zzk().zzb("Audience with no ID. appId", zzhe.zzn(str));
                } else {
                    int zza = zzfhVar.zza();
                    Iterator it2 = zzfhVar.zzg().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (!((com.google.android.gms.internal.measurement.zzfj) it2.next()).zzp()) {
                            zzj.zzu.zzaW().zzk().zzc("Event filter with no ID. Audience definition ignored. appId, audienceId", zzhe.zzn(str), Integer.valueOf(zza));
                            break;
                        }
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                com.google.android.gms.internal.measurement.zzfh zzfhVar2 = (com.google.android.gms.internal.measurement.zzfh) it3.next();
                if (zzfhVar2.zzk()) {
                    num = Integer.valueOf(zzfhVar2.zza());
                } else {
                    num = null;
                }
                arrayList2.add(num);
            }
            Preconditions.checkNotEmpty(str);
            zzj.zzav();
            zzj.zzg();
            SQLiteDatabase m7841Q3 = zzj.m7841Q();
            try {
                long m7836L = zzj.m7836L("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int max = Math.max(0, Math.min(2000, zzj.zzu.zzf().zzh(str, zzgi.zzT)));
                if (m7836L > max) {
                    ArrayList arrayList3 = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        if (i5 < arrayList2.size()) {
                            Integer num2 = (Integer) arrayList2.get(i5);
                            if (num2 == null) {
                                break;
                            }
                            arrayList3.add(Integer.toString(num2.intValue()));
                            i5++;
                        } else {
                            m7841Q3.delete("audience_filter_values", "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(",", arrayList3) + ")") + " order by rowid desc limit -1 offset ?)", new String[]{str, Integer.toString(max)});
                            break;
                        }
                    }
                }
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zze().zzc("Database error querying filters. appId", zzhe.zzn(str), e);
            }
            m7841Q.setTransactionSuccessful();
            m7841Q.endTransaction();
            try {
                zzgnVar5.zzc();
                bArr2 = ((com.google.android.gms.internal.measurement.zzgo) zzgnVar5.zzba()).zzcd();
                zzifVar = this;
            } catch (RuntimeException e2) {
                zzifVar = this;
                zzifVar.zzu.zzaW().zzk().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzhe.zzn(str), e2);
                bArr2 = bArr;
            }
            v93 zzj2 = zzifVar.zzg.zzj();
            Preconditions.checkNotEmpty(str);
            zzj2.zzg();
            zzj2.zzav();
            ContentValues contentValues = new ContentValues();
            contentValues.put("remote_config", bArr2);
            contentValues.put("config_last_modified_time", str2);
            contentValues.put("e_tag", str3);
            try {
                if (zzj2.m7841Q().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                    zzj2.zzu.zzaW().zze().zzb("Failed to update remote config (got 0). appId", zzhe.zzn(str));
                }
            } catch (SQLiteException e3) {
                zzj2.zzu.zzaW().zze().zzc("Error storing remote config. appId", zzhe.zzn(str), e3);
            }
            if (zzifVar.zzu.zzf().zzx(null, zzgi.zzbn)) {
                zzgnVar5.zzd();
            }
            arrayMap4.put(str, (com.google.android.gms.internal.measurement.zzgo) zzgnVar5.zzba());
            return true;
        } catch (Throwable th) {
            m7841Q.endTransaction();
            throw th;
        }
    }
}
