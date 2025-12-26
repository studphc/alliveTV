package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.exoplayer2.C0643C;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.Unit;
import kotlinx.coroutines.DebugKt;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.AbstractC1726qj;
import p000.ai2;
import p000.go2;
import p000.mb3;
import p000.me3;
import p000.pc3;
import p000.sc3;
import p000.sn1;
import p000.ub3;
import p000.w93;
import p000.xy1;
import p000.yb3;
import p000.yc3;

/* loaded from: classes.dex */
public final class zzlw extends mb3 {

    /* renamed from: b */
    public zzkb f14300b;

    /* renamed from: c */
    public final CopyOnWriteArraySet f14301c;

    /* renamed from: d */
    public boolean f14302d;

    /* renamed from: e */
    public final AtomicReference f14303e;

    /* renamed from: f */
    public final Object f14304f;

    /* renamed from: g */
    public boolean f14305g;

    /* renamed from: h */
    public int f14306h;

    /* renamed from: i */
    public pc3 f14307i;

    /* renamed from: j */
    public C0813n f14308j;

    /* renamed from: k */
    public PriorityQueue f14309k;

    /* renamed from: l */
    public boolean f14310l;

    /* renamed from: m */
    public zzjx f14311m;

    /* renamed from: n */
    public final AtomicLong f14312n;

    /* renamed from: o */
    public long f14313o;

    /* renamed from: p */
    public final zzx f14314p;

    /* renamed from: q */
    public C0813n f14315q;

    /* renamed from: r */
    public zzkp f14316r;

    /* renamed from: s */
    public pc3 f14317s;

    /* renamed from: t */
    public final ai2 f14318t;

    @VisibleForTesting
    protected C0828x zza;

    @VisibleForTesting
    protected boolean zzc;

    public zzlw(zzio zzioVar) {
        super(zzioVar);
        this.f14301c = new CopyOnWriteArraySet();
        this.f14304f = new Object();
        this.f14305g = false;
        this.f14306h = 1;
        this.zzc = true;
        this.f14318t = new ai2(22, this);
        this.f14303e = new AtomicReference();
        this.f14311m = zzjx.zza;
        this.f14313o = -1L;
        this.f14312n = new AtomicLong(0L);
        this.f14314p = new zzx(zzioVar);
    }

    /* renamed from: a */
    public static void m3565a(zzlw zzlwVar, zzjx zzjxVar, long j, boolean z, boolean z2) {
        zzlwVar.zzg();
        zzlwVar.zza();
        zzio zzioVar = zzlwVar.zzu;
        zzjx m7694d = zzioVar.zzm().m7694d();
        if (j <= zzlwVar.f14313o && zzjx.zzs(m7694d.zzb(), zzjxVar.zzb())) {
            zzioVar.zzaW().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjxVar);
            return;
        }
        ub3 zzm = zzioVar.zzm();
        zzio zzioVar2 = zzm.zzu;
        zzm.zzg();
        int zzb = zzjxVar.zzb();
        if (zzjx.zzs(zzb, zzm.m7692b().getInt("consent_source", 100))) {
            zzio zzioVar3 = zzlwVar.zzu;
            SharedPreferences.Editor edit = zzm.m7692b().edit();
            edit.putString("consent_settings", zzjxVar.zzq());
            edit.putInt("consent_source", zzb);
            edit.apply();
            zzioVar.zzaW().zzj().zzb("Setting storage consent(FE)", zzjxVar);
            zzlwVar.f14313o = j;
            zzny zzu = zzioVar3.zzu();
            zzu.zzg();
            zzu.zza();
            if (zzu.m3586d() && zzu.zzu.zzw().zzm() < 241200) {
                zzioVar3.zzu().zzR(z);
            } else {
                zzioVar3.zzu().zzX(z);
            }
            if (z2) {
                zzioVar3.zzu().zzE(new AtomicReference());
                return;
            }
            return;
        }
        zzioVar.zzaW().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjxVar.zzb()));
    }

    public static /* synthetic */ void zzA(zzlw zzlwVar, SharedPreferences sharedPreferences, String str) {
        zzio zzioVar = zzlwVar.zzu;
        if (!zzioVar.zzf().zzx(null, zzgi.zzbj)) {
            if (Objects.equals(str, "IABTCF_TCString")) {
                zzioVar.zzaW().zzj().zza("IABTCF_TCString change picked up in listener.");
                ((w93) Preconditions.checkNotNull(zzlwVar.f14317s)).m8016c(500L);
                return;
            }
            return;
        }
        if (!Objects.equals(str, "IABTCF_TCString") && !Objects.equals(str, "IABTCF_gdprApplies") && !Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            return;
        }
        zzioVar.zzaW().zzj().zza("IABTCF_TCString change picked up in listener.");
        ((w93) Preconditions.checkNotNull(zzlwVar.f14317s)).m8016c(500L);
    }

    public static void zzz(zzlw zzlwVar, Bundle bundle) {
        Bundle bundle2;
        ai2 ai2Var;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            zzio zzioVar = zzlwVar.zzu;
            bundle2 = new Bundle(zzioVar.zzm().f27216y.zza());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                ai2Var = zzlwVar.f14318t;
                if (!hasNext) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzioVar.zzw().getClass();
                    if (zzqf.m3698C(obj)) {
                        zzioVar.zzw().getClass();
                        zzqf.m3708m(ai2Var, null, 27, null, null, 0);
                    }
                    zzioVar.zzaW().zzl().zzc("Invalid default event parameter type. Name, value", next, obj);
                } else if (zzqf.m3699E(next)) {
                    zzioVar.zzaW().zzl().zzb("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else {
                    zzqf zzw = zzioVar.zzw();
                    zzioVar.zzf().getClass();
                    if (zzw.m3741x("param", next, HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR, obj)) {
                        zzioVar.zzw().m3733n(bundle2, next, obj);
                    }
                }
            }
            zzioVar.zzw();
            int zze = zzioVar.zzf().zze();
            if (bundle2.size() > zze) {
                Iterator it2 = new TreeSet(bundle2.keySet()).iterator();
                int i = 0;
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    i++;
                    if (i > zze) {
                        bundle2.remove(str);
                    }
                }
                zzioVar.zzw().getClass();
                zzqf.m3708m(ai2Var, null, 26, null, null, 0);
                zzioVar.zzaW().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzio zzioVar2 = zzlwVar.zzu;
        zzioVar2.zzm().f27216y.zzb(bundle2);
        if (bundle.isEmpty() && !zzioVar2.zzf().zzx(null, zzgi.zzbd)) {
            return;
        }
        zzlwVar.zzu.zzu().zzT(bundle2);
    }

    /* renamed from: b */
    public final void m3566b() {
        zzqr.zzb();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaW)) {
            if (!zzioVar.zzaX().zzu()) {
                zzioVar.zzaV();
                if (!zzaf.zza()) {
                    zza();
                    zzioVar.zzaW().zzj().zza("Getting trigger URIs (FE)");
                    final AtomicReference atomicReference = new AtomicReference();
                    zzioVar.zzaX().m3551a(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzki
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzlw zzlwVar = zzlw.this;
                            zzlwVar.zzu.zzu().zzH(atomicReference, zzlwVar.zzu.zzm().f27205n.zza());
                        }
                    });
                    final List list = (List) atomicReference.get();
                    if (list == null) {
                        AbstractC1726qj.m7039D(zzioVar, "Timed out waiting for get trigger URIs");
                        return;
                    } else {
                        zzioVar.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkj
                            @Override // java.lang.Runnable
                            public final void run() {
                                boolean contains;
                                zzlw zzlwVar = zzlw.this;
                                zzlwVar.zzg();
                                if (Build.VERSION.SDK_INT < 30) {
                                    return;
                                }
                                List<zzov> list2 = list;
                                SparseArray m7693c = zzlwVar.zzu.zzm().m7693c();
                                for (zzov zzovVar : list2) {
                                    int i = zzovVar.zzc;
                                    contains = m7693c.contains(i);
                                    if (!contains || ((Long) m7693c.get(i)).longValue() < zzovVar.zzb) {
                                        zzlwVar.m3575k().add(zzovVar);
                                    }
                                }
                                zzlwVar.zzU();
                            }
                        });
                        return;
                    }
                }
                AbstractC1726qj.m7039D(zzioVar, "Cannot get trigger URIs from main thread");
                return;
            }
            AbstractC1726qj.m7039D(zzioVar, "Cannot get trigger URIs from analytics worker thread");
        }
    }

    /* renamed from: c */
    public final void m3567c(String str, String str2, Bundle bundle) {
        zzg();
        m3568d(str, str2, bundle, this.zzu.zzaU().currentTimeMillis());
    }

    /* renamed from: d */
    public final void m3568d(String str, String str2, Bundle bundle, long j) {
        boolean z;
        zzg();
        if (this.f14300b == null || zzqf.m3699E(str2)) {
            z = true;
        } else {
            z = false;
        }
        zzT(str, str2, j, bundle, true, z, true, null);
    }

    /* renamed from: e */
    public final void m3569e(Bundle bundle, int i, long j) {
        Object obj;
        String str;
        String string;
        zza();
        zzjx zzjxVar = zzjx.zza;
        zzjw[] zzjwVarArr = zzjv.STORAGE.f14286a;
        int length = zzjwVarArr.length;
        int i2 = 0;
        while (true) {
            obj = null;
            if (i2 >= length) {
                break;
            }
            String str2 = zzjwVarArr[i2].zze;
            if (bundle.containsKey(str2) && (string = bundle.getString(str2)) != null) {
                if (string.equals("granted")) {
                    obj = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    obj = Boolean.FALSE;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i2++;
        }
        if (obj != null) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzl().zzb("Ignoring invalid consent setting", obj);
            zzioVar.zzaW().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zzu = this.zzu.zzaX().zzu();
        zzjx zzi = zzjx.zzi(bundle, i);
        if (zzi.zzt()) {
            zzak(zzi, zzu);
        }
        zzba zzc = zzba.zzc(bundle, i);
        if (zzc.zzk()) {
            m3570f(zzc, zzu);
        }
        Boolean zzg = zzba.zzg(bundle);
        if (zzg != null) {
            if (i == -30) {
                str = "tcf";
            } else {
                str = "app";
            }
            if (zzu) {
                m3572h(j, zzg.toString(), str, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS);
            } else {
                zzam(str, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzg.toString(), false, j);
            }
        }
    }

    /* renamed from: f */
    public final void m3570f(zzba zzbaVar, boolean z) {
        RunnableC0807k runnableC0807k = new RunnableC0807k(2, zzbaVar, this);
        if (z) {
            zzg();
            runnableC0807k.run();
        } else {
            this.zzu.zzaX().zzq(runnableC0807k);
        }
    }

    /* renamed from: g */
    public final void m3571g(zzjx zzjxVar) {
        boolean z;
        Boolean bool;
        zzg();
        if ((zzjxVar.zzr(zzjw.ANALYTICS_STORAGE) && zzjxVar.zzr(zzjw.AD_STORAGE)) || this.zzu.zzu().m3585c()) {
            z = true;
        } else {
            z = false;
        }
        zzio zzioVar = this.zzu;
        if (z != zzioVar.zzK()) {
            zzioVar.zzG(z);
            ub3 zzm = this.zzu.zzm();
            zzio zzioVar2 = zzm.zzu;
            zzm.zzg();
            if (zzm.m7692b().contains("measurement_enabled_from_api")) {
                bool = Boolean.valueOf(zzm.m7692b().getBoolean("measurement_enabled_from_api", true));
            } else {
                bool = null;
            }
            if (!z || bool == null || bool.booleanValue()) {
                m3573i(Boolean.valueOf(z), false);
            }
        }
    }

    /* renamed from: h */
    public final void m3572h(long j, Object obj, String str, String str2) {
        long j2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zza();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = "false";
                    if (true != "false".equals(str3.toLowerCase(Locale.ENGLISH))) {
                        j2 = 0;
                    } else {
                        j2 = 1;
                    }
                    zzio zzioVar = this.zzu;
                    Long valueOf = Long.valueOf(j2);
                    zzhr zzhrVar = zzioVar.zzm().f27204m;
                    if (j2 == 1) {
                        str4 = "true";
                    }
                    zzhrVar.zzb(str4);
                    obj = valueOf;
                    str2 = "_npa";
                    this.zzu.zzaW().zzj().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                this.zzu.zzm().f27204m.zzb("unset");
                str2 = "_npa";
            }
            this.zzu.zzaW().zzj().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        Object obj2 = obj;
        String str5 = str2;
        zzio zzioVar2 = this.zzu;
        if (!zzioVar2.zzJ()) {
            this.zzu.zzaW().zzj().zza("User property not set since app measurement is disabled");
        } else {
            if (!zzioVar2.zzM()) {
                return;
            }
            this.zzu.zzu().zzY(new zzqb(j, obj2, str5, str));
        }
    }

    /* renamed from: i */
    public final void m3573i(Boolean bool, boolean z) {
        zzg();
        zza();
        zzio zzioVar = this.zzu;
        zzioVar.zzaW().zzd().zzb("Setting app measurement enabled (FE)", bool);
        ub3 zzm = zzioVar.zzm();
        zzm.zzg();
        SharedPreferences.Editor edit = zzm.m7692b().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
        if (z) {
            ub3 zzm2 = zzioVar.zzm();
            zzio zzioVar2 = zzm2.zzu;
            zzm2.zzg();
            SharedPreferences.Editor edit2 = zzm2.m7692b().edit();
            if (bool != null) {
                edit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit2.remove("measurement_enabled_from_api");
            }
            edit2.apply();
        }
        if (!this.zzu.zzK() && (bool == null || bool.booleanValue())) {
            return;
        }
        m3574j();
    }

    /* renamed from: j */
    public final void m3574j() {
        long j;
        zzg();
        zzio zzioVar = this.zzu;
        String zza = zzioVar.zzm().f27204m.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                m3572h(zzioVar.zzaU().currentTimeMillis(), null, "app", "_npa");
            } else {
                if (true != "true".equals(zza)) {
                    j = 0;
                } else {
                    j = 1;
                }
                m3572h(zzioVar.zzaU().currentTimeMillis(), Long.valueOf(j), "app", "_npa");
            }
        }
        if (this.zzu.zzJ() && this.zzc) {
            zzioVar.zzaW().zzd().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzH();
            this.zzu.zzv().zza.m3498a();
            zzioVar.zzaX().zzq(new sn1(23, this));
            return;
        }
        zzioVar.zzaW().zzd().zza("Updating Scion state (FE)");
        this.zzu.zzu().zzV();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.measurement.internal.zzkf] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.measurement.internal.zzkh] */
    /* renamed from: k */
    public final PriorityQueue m3575k() {
        Comparator comparing;
        if (this.f14309k == null) {
            comparing = Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzkf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzov) obj).zzb);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzkh
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            });
            this.f14309k = go2.m4968i(comparing);
        }
        return this.f14309k;
    }

    @WorkerThread
    public final void zzH() {
        zzg();
        zza();
        if (this.zzu.zzM()) {
            zzio zzioVar = this.zzu;
            zzam zzf = zzioVar.zzf();
            zzf.zzu.zzaV();
            Boolean m3512d = zzf.m3512d("google_analytics_deferred_deep_link_enabled");
            if (m3512d != null && m3512d.booleanValue()) {
                zzioVar.zzaW().zzd().zza("Deferred Deep Link feature enabled.");
                zzioVar.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzko
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzlw.this.zzM();
                    }
                });
            }
            this.zzu.zzu().zzA();
            this.zzc = false;
            ub3 zzm = zzioVar.zzm();
            zzm.zzg();
            String string = zzm.m7692b().getString("previous_os_version", null);
            zzm.zzu.zzg().zzv();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzm.m7692b().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                zzioVar.zzg().zzv();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    m3567c(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
    }

    public final void zzJ(String str, String str2, Bundle bundle) {
        zzio zzioVar = this.zzu;
        long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzioVar.zzaX().zzq(new RunnableC0825u(this, bundle2, 1));
    }

    public final void zzK() {
        zzio zzioVar = this.zzu;
        if ((zzioVar.zzaT().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) zzioVar.zzaT().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    @WorkerThread
    public final void zzM() {
        zzg();
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzm().f27211t.zzb()) {
            long zza = zzioVar.zzm().f27212u.zza();
            zzioVar.zzm().f27212u.zzb(1 + zza);
            zzioVar.zzf();
            if (zza >= 5) {
                zzioVar.zzaW().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzioVar.zzm().f27211t.zza(true);
                return;
            } else {
                if (this.f14315q == null) {
                    this.f14315q = new C0813n(this, this.zzu, 1);
                }
                this.f14315q.m8016c(0L);
                return;
            }
        }
        zzioVar.zzaW().zzd().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final void zzN() {
        zzio zzioVar;
        zzgg zzggVar;
        zzoq zzoqVar;
        zzoq zzoqVar2;
        int i;
        zzlw zzlwVar;
        boolean z;
        boolean z2;
        com.google.android.gms.internal.measurement.zzkm zzkmVar;
        zzg();
        zzio zzioVar2 = this.zzu;
        zzioVar2.zzaW().zzd().zza("Handle tcf update.");
        SharedPreferences m7691a = zzioVar2.zzm().m7691a();
        HashMap hashMap = new HashMap();
        zzgg zzggVar2 = zzgi.zzbj;
        if (((Boolean) zzggVar2.zza(null)).booleanValue()) {
            ImmutableList immutableList = zzot.f14350a;
            com.google.android.gms.internal.measurement.zzkl zzklVar = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            me3 me3Var = me3.f22917a;
            Map.Entry zza = zzor.zza(zzklVar, me3Var);
            com.google.android.gms.internal.measurement.zzkl zzklVar2 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            me3 me3Var2 = me3.f22918b;
            zzggVar = zzggVar2;
            zzioVar = zzioVar2;
            ImmutableMap ofEntries = ImmutableMap.ofEntries(zza, zzor.zza(zzklVar2, me3Var2), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, me3Var), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, me3Var), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, me3Var2), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, me3Var2), zzor.zza(com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, me3Var2));
            ImmutableSet m3972of = ImmutableSet.m3972of("CH");
            char[] cArr = new char[5];
            int m3598a = zzot.m3598a(m7691a, "IABTCF_CmpSdkID");
            int m3598a2 = zzot.m3598a(m7691a, "IABTCF_PolicyVersion");
            int m3598a3 = zzot.m3598a(m7691a, "IABTCF_gdprApplies");
            int m3598a4 = zzot.m3598a(m7691a, "IABTCF_PurposeOneTreatment");
            int m3598a5 = zzot.m3598a(m7691a, "IABTCF_EnableAdvertiserConsentMode");
            String m3599b = zzot.m3599b(m7691a, "IABTCF_PublisherCC");
            ImmutableMap.Builder builder = ImmutableMap.builder();
            UnmodifiableIterator it = ofEntries.keySet().iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzkl zzklVar3 = (com.google.android.gms.internal.measurement.zzkl) it.next();
                String m3599b2 = zzot.m3599b(m7691a, "IABTCF_PublisherRestrictions" + zzklVar3.zza());
                if (!TextUtils.isEmpty(m3599b2) && m3599b2.length() >= 755) {
                    int digit = Character.digit(m3599b2.charAt(754), 10);
                    if (digit >= 0 && digit <= com.google.android.gms.internal.measurement.zzkm.values().length && digit != 0) {
                        if (digit != 1) {
                            if (digit != 2) {
                                zzkmVar = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED;
                            } else {
                                zzkmVar = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                            }
                        } else {
                            zzkmVar = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                        }
                    } else {
                        zzkmVar = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_NOT_ALLOWED;
                    }
                } else {
                    zzkmVar = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED;
                }
                builder.put(zzklVar3, zzkmVar);
            }
            ImmutableMap buildOrThrow = builder.buildOrThrow();
            String m3599b3 = zzot.m3599b(m7691a, "IABTCF_PurposeConsents");
            String m3599b4 = zzot.m3599b(m7691a, "IABTCF_VendorConsents");
            if (!TextUtils.isEmpty(m3599b4) && m3599b4.length() >= 755 && m3599b4.charAt(754) == '1') {
                z = true;
            } else {
                z = false;
            }
            String m3599b5 = zzot.m3599b(m7691a, "IABTCF_PurposeLegitimateInterests");
            String m3599b6 = zzot.m3599b(m7691a, "IABTCF_VendorLegitimateInterests");
            if (!TextUtils.isEmpty(m3599b6) && m3599b6.length() >= 755 && m3599b6.charAt(754) == '1') {
                z2 = true;
            } else {
                z2 = false;
            }
            cArr[0] = '2';
            zzoqVar = new zzoq(zzot.zzc(ofEntries, buildOrThrow, m3972of, cArr, m3598a, m3598a5, m3598a3, m3598a2, m3598a4, m3599b, m3599b3, m3599b5, z, z2));
        } else {
            zzioVar = zzioVar2;
            zzggVar = zzggVar2;
            String m3599b7 = zzot.m3599b(m7691a, "IABTCF_VendorConsents");
            if (!"".equals(m3599b7) && m3599b7.length() > 754) {
                hashMap.put("GoogleConsent", String.valueOf(m3599b7.charAt(754)));
            }
            int m3598a6 = zzot.m3598a(m7691a, "IABTCF_gdprApplies");
            if (m3598a6 != -1) {
                hashMap.put("gdprApplies", String.valueOf(m3598a6));
            }
            int m3598a7 = zzot.m3598a(m7691a, "IABTCF_EnableAdvertiserConsentMode");
            if (m3598a7 != -1) {
                hashMap.put("EnableAdvertiserConsentMode", String.valueOf(m3598a7));
            }
            int m3598a8 = zzot.m3598a(m7691a, "IABTCF_PolicyVersion");
            if (m3598a8 != -1) {
                hashMap.put("PolicyVersion", String.valueOf(m3598a8));
            }
            String m3599b8 = zzot.m3599b(m7691a, "IABTCF_PurposeConsents");
            if (!"".equals(m3599b8)) {
                hashMap.put("PurposeConsents", m3599b8);
            }
            int m3598a9 = zzot.m3598a(m7691a, "IABTCF_CmpSdkID");
            if (m3598a9 != -1) {
                hashMap.put("CmpSdkID", String.valueOf(m3598a9));
            }
            zzoqVar = new zzoq(hashMap);
        }
        zzioVar.zzaW().zzj().zzb("Tcf preferences read", zzoqVar);
        if (zzioVar.zzf().zzx(null, zzggVar)) {
            ub3 zzm = zzioVar.zzm();
            zzm.zzg();
            String string = zzm.m7692b().getString("stored_tcf_param", "");
            HashMap hashMap2 = new HashMap();
            if (TextUtils.isEmpty(string)) {
                zzoqVar2 = new zzoq(hashMap2);
            } else {
                String[] split = string.split(";");
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String[] split2 = split[i2].split("=");
                    if (split2.length >= 2 && zzot.f14350a.contains(split2[0])) {
                        i = 1;
                        hashMap2.put(split2[0], split2[1]);
                    } else {
                        i = 1;
                    }
                    i2 += i;
                }
                zzoqVar2 = new zzoq(hashMap2);
            }
            if (zzioVar.zzm().m7697g(zzoqVar)) {
                Bundle zza2 = zzoqVar.zza();
                zzioVar.zzaW().zzj().zzb("Consent generated from Tcf", zza2);
                if (zza2 != Bundle.EMPTY) {
                    zzlwVar = this;
                    zzlwVar.m3569e(zza2, -30, zzioVar.zzaU().currentTimeMillis());
                } else {
                    zzlwVar = this;
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfm", zzoqVar.zzc(zzoqVar2));
                bundle.putString("_tcfd2", zzoqVar.zzb());
                bundle.putString("_tcfd", zzoqVar.zzd());
                zzlwVar.m3567c(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_tcf", bundle);
                return;
            }
            return;
        }
        if (zzioVar.zzm().m7697g(zzoqVar)) {
            Bundle zza3 = zzoqVar.zza();
            zzioVar.zzaW().zzj().zzb("Consent generated from Tcf", zza3);
            if (zza3 != Bundle.EMPTY) {
                m3569e(zza3, -30, zzioVar.zzaU().currentTimeMillis());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfd", zzoqVar.zzd());
            m3567c(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_tcf", bundle2);
        }
    }

    public final void zzO(String str, String str2, Bundle bundle) {
        zzP(str, str2, bundle, true, true, this.zzu.zzaU().currentTimeMillis());
    }

    public final void zzP(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Bundle bundle2;
        String str3;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            this.zzu.zzt().zzy(bundle2, j);
            return;
        }
        boolean z3 = true;
        if (z2 && this.f14300b != null && !zzqf.m3699E(str2)) {
            z3 = false;
        }
        boolean z4 = z3;
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        zzZ(str3, str2, j, bundle2, z2, z4, z, null);
    }

    public final void zzQ(String str, String str2, Bundle bundle, String str3) {
        throw new IllegalStateException("Unexpected call on client side");
    }

    @WorkerThread
    public final void zzT(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean z4;
        boolean z5;
        String str4;
        boolean zzb;
        ArrayList arrayList;
        zzio zzioVar;
        String str5;
        zzio zzioVar2;
        String str6;
        long j2;
        Bundle[] bundleArr;
        String str7;
        Bundle[] bundleArr2;
        int i;
        int i2;
        Class<?> cls;
        String str8 = str;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzg();
        zza();
        zzio zzioVar3 = this.zzu;
        if (zzioVar3.zzJ()) {
            List list = this.zzu.zzh().f14167j;
            if (list != null && !list.contains(str2)) {
                this.zzu.zzaW().zzd().zzc("Dropping non-safelisted event. event name, origin", str2, str8);
                return;
            }
            if (!this.f14302d) {
                this.f14302d = true;
                try {
                    if (!zzioVar3.zzN()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzu.zzaT().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", Context.class).invoke(null, this.zzu.zzaT());
                    } catch (Exception e) {
                        this.zzu.zzaW().zzk().zzb("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException unused) {
                    this.zzu.zzaW().zzi().zza("Tag Manager is not found and thus will not be used");
                }
            }
            if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
                zzio zzioVar4 = this.zzu;
                zzioVar4.zzaV();
                m3572h(zzioVar4.zzaU().currentTimeMillis(), bundle.getString("gclid"), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid");
            }
            zzio zzioVar5 = this.zzu;
            zzioVar5.zzaV();
            if (z && zzqf.zzau(str2)) {
                zzioVar5.zzw().m3730j(bundle, zzioVar5.zzm().f27216y.zza());
            }
            ai2 ai2Var = this.f14318t;
            if (!z3) {
                zzioVar5.zzaV();
                if (!"_iap".equals(str2)) {
                    zzio zzioVar6 = this.zzu;
                    zzqf zzw = zzioVar6.zzw();
                    int i3 = 2;
                    if (zzw.m3743z(NotificationCompat.CATEGORY_EVENT, str2)) {
                        if (!zzw.m3740w(NotificationCompat.CATEGORY_EVENT, zzjy.zza, zzjy.zzb, str2)) {
                            i3 = 13;
                        } else {
                            zzw.zzu.zzf();
                            if (zzw.m3739v(40, NotificationCompat.CATEGORY_EVENT, str2)) {
                                i3 = 0;
                            }
                        }
                    }
                    if (i3 != 0) {
                        zzioVar5.zzaW().zzf().zzb("Invalid public event name. Event will not be logged (FE)", zzioVar5.zzj().zzd(str2));
                        zzqf zzw2 = zzioVar6.zzw();
                        zzioVar6.zzf();
                        String zzG = zzw2.zzG(str2, 40, true);
                        if (str2 != null) {
                            i2 = str2.length();
                        } else {
                            i2 = 0;
                        }
                        zzioVar6.zzw().getClass();
                        zzqf.m3708m(ai2Var, null, i3, "_ev", zzG, i2);
                        return;
                    }
                }
            }
            zzioVar5.zzaV();
            zzio zzioVar7 = this.zzu;
            zzmh zzj = zzioVar7.zzt().zzj(false);
            if (zzj != null && !bundle.containsKey("_sc")) {
                zzj.f14324a = true;
            }
            if (z && !z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            zzqf.zzN(zzj, bundle, z4);
            boolean equals = "am".equals(str8);
            boolean m3699E = zzqf.m3699E(str2);
            if (z && this.f14300b != null && !m3699E) {
                if (equals) {
                    z5 = true;
                } else {
                    zzioVar5.zzaW().zzd().zzc("Passing event to registered event handler (FE)", zzioVar5.zzj().zzd(str2), zzioVar5.zzj().zzb(bundle));
                    Preconditions.checkNotNull(this.f14300b);
                    this.f14300b.interceptEvent(str, str2, bundle, j);
                    return;
                }
            } else {
                z5 = equals;
            }
            zzio zzioVar8 = this.zzu;
            if (zzioVar8.zzM()) {
                int zzf = zzioVar5.zzw().zzf(str2);
                if (zzf != 0) {
                    zzioVar5.zzaW().zzf().zzb("Invalid event name. Event will not be logged (FE)", zzioVar5.zzj().zzd(str2));
                    zzqf zzw3 = zzioVar5.zzw();
                    zzioVar5.zzf();
                    String zzG2 = zzw3.zzG(str2, 40, true);
                    if (str2 != null) {
                        i = str2.length();
                    } else {
                        i = 0;
                    }
                    zzioVar8.zzw().getClass();
                    zzqf.m3708m(ai2Var, str3, zzf, "_ev", zzG2, i);
                    return;
                }
                Bundle m3722a = zzioVar5.zzw().m3722a(str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
                Preconditions.checkNotNull(m3722a);
                zzioVar5.zzaV();
                if (zzioVar7.zzt().zzj(false) == null || !"_ae".equals(str2)) {
                    str4 = "_o";
                } else {
                    C0814n0 c0814n0 = zzioVar7.zzv().zzb;
                    long elapsedRealtime = c0814n0.f14067d.zzu.zzaU().elapsedRealtime();
                    str4 = "_o";
                    long j3 = elapsedRealtime - c0814n0.f14065b;
                    c0814n0.f14065b = elapsedRealtime;
                    if (j3 > 0) {
                        zzioVar5.zzw().m3728h(m3722a, j3);
                    }
                }
                if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str8) && "_ssr".equals(str2)) {
                    zzqf zzw4 = zzioVar5.zzw();
                    String string = m3722a.getString("_ffr");
                    if (Strings.isEmptyOrWhitespace(string)) {
                        string = null;
                    } else if (string != null) {
                        string = string.trim();
                    }
                    zzio zzioVar9 = zzw4.zzu;
                    if (!Objects.equals(string, zzioVar9.zzm().f27213v.zza())) {
                        zzioVar9.zzm().f27213v.zzb(string);
                    } else {
                        zzioVar9.zzaW().zzd().zza("Not logging duplicate session_start_with_rollout event");
                        return;
                    }
                } else if ("_ae".equals(str2)) {
                    String zza = zzioVar5.zzw().zzu.zzm().f27213v.zza();
                    if (!TextUtils.isEmpty(zza)) {
                        m3722a.putString("_ffr", zza);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(m3722a);
                if (zzioVar5.zzf().zzx(null, zzgi.zzba)) {
                    zzop zzv = zzioVar7.zzv();
                    zzv.zzg();
                    zzb = zzv.f14348c;
                } else {
                    zzb = zzioVar5.zzm().f27210s.zzb();
                }
                if (zzioVar5.zzm().f27207p.zza() > 0 && zzioVar5.zzm().m7696f(j) && zzb) {
                    zzioVar5.zzaW().zzj().zza("Current session is expired, remove the session number, ID, and engagement time");
                    str5 = "_ae";
                    zzioVar2 = zzioVar7;
                    j2 = 0;
                    bundleArr = null;
                    arrayList = arrayList2;
                    str6 = str4;
                    zzioVar = zzioVar8;
                    m3572h(zzioVar5.zzaU().currentTimeMillis(), null, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid");
                    m3572h(zzioVar5.zzaU().currentTimeMillis(), null, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno");
                    m3572h(zzioVar5.zzaU().currentTimeMillis(), null, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_se");
                    zzioVar5.zzm().f27208q.zzb(0L);
                } else {
                    arrayList = arrayList2;
                    zzioVar = zzioVar8;
                    str5 = "_ae";
                    zzioVar2 = zzioVar7;
                    str6 = str4;
                    j2 = 0;
                    bundleArr = null;
                }
                if (m3722a.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j2) == 1) {
                    zzioVar5.zzaW().zzj().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    zzioVar.zzv().zza.m3499b(j, true);
                }
                ArrayList arrayList3 = new ArrayList(m3722a.keySet());
                Collections.sort(arrayList3);
                int size = arrayList3.size();
                for (int i4 = 0; i4 < size; i4++) {
                    String str9 = (String) arrayList3.get(i4);
                    if (str9 != null) {
                        zzioVar5.zzw();
                        Object obj = m3722a.get(str9);
                        if (obj instanceof Bundle) {
                            bundleArr2 = new Bundle[]{(Bundle) obj};
                        } else if (obj instanceof Parcelable[]) {
                            Parcelable[] parcelableArr = (Parcelable[]) obj;
                            bundleArr2 = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                        } else if (obj instanceof ArrayList) {
                            ArrayList arrayList4 = (ArrayList) obj;
                            bundleArr2 = (Bundle[]) arrayList4.toArray(new Bundle[arrayList4.size()]);
                        } else {
                            bundleArr2 = bundleArr;
                        }
                        if (bundleArr2 != null) {
                            m3722a.putParcelableArray(str9, bundleArr2);
                        }
                    }
                }
                int i5 = 0;
                while (i5 < arrayList.size()) {
                    ArrayList arrayList5 = arrayList;
                    Bundle bundle2 = (Bundle) arrayList5.get(i5);
                    if (i5 != 0) {
                        str7 = "_ep";
                    } else {
                        str7 = str2;
                    }
                    String str10 = str6;
                    bundle2.putString(str10, str8);
                    if (z2) {
                        bundle2 = zzioVar5.zzw().m3721T(bundle2);
                    }
                    Bundle bundle3 = bundle2;
                    zzioVar2.zzu().zzM(new zzbh(str7, new zzbf(bundle3), str, j), str3);
                    if (!z5) {
                        Iterator it = this.f14301c.iterator();
                        while (it.hasNext()) {
                            ((zzkc) it.next()).onEvent(str, str2, new Bundle(bundle3), j);
                        }
                    }
                    i5++;
                    str8 = str;
                    arrayList = arrayList5;
                    str6 = str10;
                }
                zzioVar5.zzaV();
                if (zzioVar2.zzt().zzj(false) != null && str5.equals(str2)) {
                    zzioVar2.zzv().zzb.m3497a(zzioVar5.zzaU().elapsedRealtime(), true, true);
                    return;
                }
                return;
            }
            return;
        }
        this.zzu.zzaW().zzd().zza("Event not sent since app measurement is disabled");
    }

    public final void zzU() {
        zzov zzovVar;
        zzg();
        this.f14310l = false;
        if (!m3575k().isEmpty() && !this.f14305g && (zzovVar = (zzov) m3575k().poll()) != null) {
            zzio zzioVar = this.zzu;
            zzqf zzw = zzioVar.zzw();
            if (zzw.f14409e == null) {
                zzw.f14409e = MeasurementManagerFutures.from(zzw.zzu.zzaT());
            }
            MeasurementManagerFutures measurementManagerFutures = zzw.f14409e;
            if (measurementManagerFutures != null) {
                this.f14305g = true;
                zzhc zzj = zzioVar.zzaW().zzj();
                String str = zzovVar.zza;
                zzj.zzb("Registering trigger URI", str);
                ListenableFuture<Unit> registerTriggerAsync = measurementManagerFutures.registerTriggerAsync(Uri.parse(str));
                if (registerTriggerAsync == null) {
                    this.f14305g = false;
                    m3575k().add(zzovVar);
                } else {
                    Futures.addCallback(registerTriggerAsync, new C0817p(this, zzovVar), new ExecutorC0815o(this));
                }
            }
        }
    }

    public final void zzV(zzkc zzkcVar) {
        zza();
        Preconditions.checkNotNull(zzkcVar);
        if (!this.f14301c.add(zzkcVar)) {
            AbstractC1726qj.m7037B(this.zzu, "OnEventListener already registered");
        }
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.google.android.gms.measurement.internal.zzkp] */
    @WorkerThread
    public final void zzW() {
        zzg();
        zzio zzioVar = this.zzu;
        zzioVar.zzaW().zzd().zza("Register tcfPrefChangeListener.");
        if (this.f14316r == null) {
            this.f14317s = new pc3(this, this.zzu, 1);
            this.f14316r = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzkp
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzlw.zzA(zzlw.this, sharedPreferences, str);
                }
            };
        }
        zzioVar.zzm().m7691a().registerOnSharedPreferenceChangeListener(this.f14316r);
    }

    public final void zzX(long j) {
        this.f14303e.set(null);
        this.zzu.zzaX().zzq(new RunnableC0821r(this, j, 1));
    }

    public final void zzZ(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzu.zzaX().zzq(new sc3(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    public final void zzad(Bundle bundle) {
        zzae(bundle, this.zzu.zzaU().currentTimeMillis());
    }

    public final void zzae(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            AbstractC1726qj.m7037B(this.zzu, "Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjt.zza(bundle2, "app_id", String.class, null);
        zzjt.zza(bundle2, "origin", String.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzjt.zza(bundle2, "value", Object.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjt.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle2.get("value");
        zzio zzioVar = this.zzu;
        if (zzioVar.zzw().m3718P(string) == 0) {
            if (zzioVar.zzw().m3716N(obj, string) == 0) {
                Object m3725d = zzioVar.zzw().m3725d(obj, string);
                if (m3725d == null) {
                    zzioVar.zzaW().zze().zzc("Unable to normalize conditional user property value", zzioVar.zzj().zzf(string), obj);
                    return;
                }
                zzjt.zzb(bundle2, m3725d);
                long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    zzioVar.zzf();
                    if (j2 > 15552000000L || j2 < 1) {
                        zzioVar.zzaW().zze().zzc("Invalid conditional user property timeout", zzioVar.zzj().zzf(string), Long.valueOf(j2));
                        return;
                    }
                }
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                zzioVar.zzf();
                if (j3 <= 15552000000L && j3 >= 1) {
                    zzioVar.zzaX().zzq(new RunnableC0825u(this, bundle2, 0));
                    return;
                } else {
                    zzioVar.zzaW().zze().zzc("Invalid conditional user property time to live", zzioVar.zzj().zzf(string), Long.valueOf(j3));
                    return;
                }
            }
            zzioVar.zzaW().zze().zzc("Invalid conditional user property value", zzioVar.zzj().zzf(string), obj);
            return;
        }
        zzioVar.zzaW().zze().zzb("Invalid conditional user property name", zzioVar.zzj().zzf(string));
    }

    @WorkerThread
    public final void zzah(zzkb zzkbVar) {
        zzkb zzkbVar2;
        boolean z;
        zzg();
        zza();
        if (zzkbVar != null && zzkbVar != (zzkbVar2 = this.f14300b)) {
            if (zzkbVar2 == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "EventInterceptor already set.");
        }
        this.f14300b = zzkbVar;
    }

    public final void zzai(Boolean bool) {
        zza();
        this.zzu.zzaX().zzq(new xy1(29, this, bool));
    }

    public final void zzak(zzjx zzjxVar, boolean z) {
        boolean z2;
        zzjx zzjxVar2;
        boolean z3;
        boolean z4;
        zza();
        int zzb = zzjxVar.zzb();
        if (zzb != -10) {
            zzju zze = zzjxVar.zze();
            zzju zzjuVar = zzju.UNINITIALIZED;
            if (zze == zzjuVar && zzjxVar.zzf() == zzjuVar) {
                this.zzu.zzaW().zzl().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.f14304f) {
            try {
                z2 = false;
                if (zzjx.zzs(zzb, this.f14311m.zzb())) {
                    z3 = zzjxVar.zzu(this.f14311m);
                    zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
                    if (zzjxVar.zzr(zzjwVar) && !this.f14311m.zzr(zzjwVar)) {
                        z2 = true;
                    }
                    zzjx zzm = zzjxVar.zzm(this.f14311m);
                    this.f14311m = zzm;
                    zzjxVar2 = zzm;
                    z4 = z2;
                    z2 = true;
                } else {
                    zzjxVar2 = zzjxVar;
                    z3 = false;
                    z4 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
            this.zzu.zzaW().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjxVar2);
            return;
        }
        long andIncrement = this.f14312n.getAndIncrement();
        if (z3) {
            this.f14303e.set(null);
            yc3 yc3Var = new yc3(this, zzjxVar2, andIncrement, z4, 0);
            if (z) {
                zzg();
                yc3Var.run();
                return;
            } else {
                this.zzu.zzaX().zzr(yc3Var);
                return;
            }
        }
        yc3 yc3Var2 = new yc3(this, zzjxVar2, andIncrement, z4, 1);
        if (z) {
            zzg();
            yc3Var2.run();
        } else if (zzb != 30 && zzb != -10) {
            this.zzu.zzaX().zzq(yc3Var2);
        } else {
            this.zzu.zzaX().zzr(yc3Var2);
        }
    }

    public final void zzal(String str, String str2, Object obj, boolean z) {
        zzam(str, str2, obj, z, this.zzu.zzaU().currentTimeMillis());
    }

    public final void zzam(String str, String str2, Object obj, boolean z, long j) {
        int i;
        String str3;
        int i2 = 0;
        if (z) {
            i = this.zzu.zzw().m3718P(str2);
        } else {
            zzqf zzw = this.zzu.zzw();
            if (zzw.m3743z("user property", str2)) {
                if (!zzw.m3740w("user property", zzka.zza, null, str2)) {
                    i = 15;
                } else {
                    zzw.zzu.zzf();
                    if (zzw.m3739v(24, "user property", str2)) {
                        i = 0;
                    }
                }
            }
            i = 6;
        }
        ai2 ai2Var = this.f14318t;
        if (i != 0) {
            zzio zzioVar = this.zzu;
            zzqf zzw2 = zzioVar.zzw();
            zzioVar.zzf();
            String zzG = zzw2.zzG(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzu.zzw().getClass();
            zzqf.m3708m(ai2Var, null, i, "_ev", zzG, i2);
            return;
        }
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (obj != null) {
            zzio zzioVar2 = this.zzu;
            int m3716N = zzioVar2.zzw().m3716N(obj, str2);
            if (m3716N != 0) {
                zzqf zzw3 = zzioVar2.zzw();
                zzioVar2.zzf();
                String zzG2 = zzw3.zzG(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = obj.toString().length();
                }
                this.zzu.zzw().getClass();
                zzqf.m3708m(ai2Var, null, m3716N, "_ev", zzG2, i2);
                return;
            }
            Object m3725d = zzioVar2.zzw().m3725d(obj, str2);
            if (m3725d != null) {
                this.zzu.zzaX().zzq(new yb3(this, str3, str2, m3725d, j, 1));
                return;
            }
            return;
        }
        this.zzu.zzaX().zzq(new yb3(this, str3, str2, null, j, 1));
    }

    public final void zzao(zzkc zzkcVar) {
        zza();
        Preconditions.checkNotNull(zzkcVar);
        if (!this.f14301c.remove(zzkcVar)) {
            AbstractC1726qj.m7037B(this.zzu, "OnEventListener had not been registered");
        }
    }

    @Override // p000.mb3
    public final boolean zzf() {
        return false;
    }

    public final int zzi(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzu.zzf();
        return 25;
    }

    public final Boolean zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzu.zzaX().m3551a(atomicReference, C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "boolean test flag value", new RunnableC0823s(this, atomicReference, 0));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzu.zzaX().m3551a(atomicReference, C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "double test flag value", new RunnableC0823s(this, atomicReference, 4));
    }

    public final Integer zzp() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzu.zzaX().m3551a(atomicReference, C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "int test flag value", new RunnableC0823s(this, atomicReference, 3));
    }

    public final Long zzq() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzu.zzaX().m3551a(atomicReference, C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "long test flag value", new RunnableC0823s(this, atomicReference, 2));
    }

    public final String zzr() {
        return (String) this.f14303e.get();
    }

    public final String zzs() {
        zzmh zzi = this.zzu.zzt().zzi();
        if (zzi != null) {
            return zzi.zzb;
        }
        return null;
    }

    public final String zzt() {
        zzmh zzi = this.zzu.zzt().zzi();
        if (zzi != null) {
            return zzi.zza;
        }
        return null;
    }

    public final String zzu() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzu.zzaX().m3551a(atomicReference, C0643C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, "String test flag value", new RunnableC0823s(this, atomicReference, 1));
    }

    public final ArrayList zzv(String str, String str2) {
        zzio zzioVar = this.zzu;
        if (zzioVar.zzaX().zzu()) {
            zzioVar.zzaW().zze().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        zzioVar.zzaV();
        if (zzaf.zza()) {
            zzioVar.zzaW().zze().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzaX().m3551a(atomicReference, 5000L, "get conditional user properties", new RunnableC0826v(this, atomicReference, str, str2, 0));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzioVar.zzaW().zze().zzb("Timed out waiting for get conditional user properties", null);
            return new ArrayList();
        }
        return zzqf.zzK(list);
    }

    public final List zzw(boolean z) {
        zza();
        zzio zzioVar = this.zzu;
        zzioVar.zzaW().zzj().zza("Getting user properties (FE)");
        if (!zzioVar.zzaX().zzu()) {
            zzioVar.zzaV();
            if (zzaf.zza()) {
                zzioVar.zzaW().zze().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().m3551a(atomicReference, 5000L, "get user properties", new RunnableC0824t(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzioVar.zzaW().zze().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyList();
            }
            return list;
        }
        zzioVar.zzaW().zze().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzx(String str, String str2, boolean z) {
        zzio zzioVar = this.zzu;
        if (zzioVar.zzaX().zzu()) {
            zzioVar.zzaW().zze().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        zzioVar.zzaV();
        if (zzaf.zza()) {
            zzioVar.zzaW().zze().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzaX().m3551a(atomicReference, 5000L, "get user properties", new RunnableC0827w(this, atomicReference, str, str2, z));
        List<zzqb> list = (List) atomicReference.get();
        if (list == null) {
            zzioVar.zzaW().zze().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzqb zzqbVar : list) {
            Object zza = zzqbVar.zza();
            if (zza != null) {
                arrayMap.put(zzqbVar.zzb, zza);
            }
        }
        return arrayMap;
    }
}
