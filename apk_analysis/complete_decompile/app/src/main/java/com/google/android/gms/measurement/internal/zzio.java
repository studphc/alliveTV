package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URL;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;
import org.json.JSONException;
import org.json.JSONObject;
import p000.AbstractC1726qj;
import p000.ai2;
import p000.bd3;
import p000.fc3;
import p000.hc3;
import p000.mb3;
import p000.p63;
import p000.r93;
import p000.ub3;

/* loaded from: classes.dex */
public final class zzio implements hc3 {

    /* renamed from: H */
    public static volatile zzio f14246H;

    /* renamed from: A */
    public long f14247A;

    /* renamed from: B */
    public volatile Boolean f14248B;

    /* renamed from: C */
    public volatile boolean f14249C;

    /* renamed from: D */
    public int f14250D;

    /* renamed from: E */
    public int f14251E;

    /* renamed from: G */
    public final long f14253G;

    /* renamed from: a */
    public final Context f14254a;

    /* renamed from: b */
    public final String f14255b;

    /* renamed from: c */
    public final String f14256c;

    /* renamed from: d */
    public final String f14257d;

    /* renamed from: e */
    public final boolean f14258e;

    /* renamed from: f */
    public final zzaf f14259f;

    /* renamed from: g */
    public final zzam f14260g;

    /* renamed from: h */
    public final ub3 f14261h;

    /* renamed from: i */
    public final zzhe f14262i;

    /* renamed from: j */
    public final zzil f14263j;

    /* renamed from: k */
    public final zzop f14264k;

    /* renamed from: l */
    public final zzqf f14265l;

    /* renamed from: m */
    public final zzgx f14266m;

    /* renamed from: n */
    public final Clock f14267n;

    /* renamed from: o */
    public final zzmo f14268o;

    /* renamed from: p */
    public final zzlw f14269p;

    /* renamed from: q */
    public final zzd f14270q;

    /* renamed from: r */
    public final zzmb f14271r;

    /* renamed from: s */
    public final String f14272s;

    /* renamed from: t */
    public zzgv f14273t;

    /* renamed from: u */
    public zzny f14274u;

    /* renamed from: v */
    public zzbb f14275v;

    /* renamed from: w */
    public zzgs f14276w;

    /* renamed from: x */
    public zzmd f14277x;

    /* renamed from: z */
    public Boolean f14279z;

    /* renamed from: y */
    public boolean f14278y = false;

    /* renamed from: F */
    public final AtomicInteger f14252F = new AtomicInteger(0);

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, com.google.android.gms.measurement.internal.zzaf] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.android.gms.measurement.internal.m, com.google.android.gms.measurement.internal.zzam] */
    /* JADX WARN: Type inference failed for: r5v3, types: [fc3, com.google.android.gms.measurement.internal.zzmb] */
    public zzio(zzke zzkeVar) {
        long currentTimeMillis;
        Preconditions.checkNotNull(zzkeVar);
        Context context = zzkeVar.f14290a;
        ?? obj = new Object();
        this.f14259f = obj;
        p63.f25051e = obj;
        this.f14254a = context;
        this.f14255b = zzkeVar.f14291b;
        this.f14256c = zzkeVar.f14292c;
        this.f14257d = zzkeVar.f14293d;
        this.f14258e = zzkeVar.f14297h;
        this.f14248B = zzkeVar.f14294e;
        this.f14272s = zzkeVar.f14299j;
        this.f14249C = true;
        com.google.android.gms.internal.measurement.zzki.zzd(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.f14267n = defaultClock;
        Long l = zzkeVar.f14298i;
        if (l != null) {
            currentTimeMillis = l.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.f14253G = currentTimeMillis;
        ?? abstractC0811m = new AbstractC0811m(this);
        abstractC0811m.f14123c = new r93() { // from class: com.google.android.gms.measurement.internal.zzak
            @Override // p000.r93
            public final String zza(String str, String str2) {
                return null;
            }
        };
        this.f14260g = abstractC0811m;
        ub3 ub3Var = new ub3(this);
        ub3Var.zzw();
        this.f14261h = ub3Var;
        zzhe zzheVar = new zzhe(this);
        zzheVar.zzw();
        this.f14262i = zzheVar;
        zzqf zzqfVar = new zzqf(this);
        zzqfVar.zzw();
        this.f14265l = zzqfVar;
        this.f14266m = new zzgx(new ai2(21, this));
        this.f14270q = new zzd(this);
        zzmo zzmoVar = new zzmo(this);
        zzmoVar.zzb();
        this.f14268o = zzmoVar;
        zzlw zzlwVar = new zzlw(this);
        zzlwVar.zzb();
        this.f14269p = zzlwVar;
        zzop zzopVar = new zzop(this);
        zzopVar.zzb();
        this.f14264k = zzopVar;
        ?? fc3Var = new fc3(this);
        fc3Var.zzw();
        this.f14271r = fc3Var;
        zzil zzilVar = new zzil(this);
        zzilVar.zzw();
        this.f14263j = zzilVar;
        com.google.android.gms.internal.measurement.zzdh zzdhVar = zzkeVar.f14296g;
        boolean z = zzdhVar == null || zzdhVar.zzb == 0;
        if (context.getApplicationContext() instanceof Application) {
            m3554b(zzlwVar);
            if (zzlwVar.zzu.f14254a.getApplicationContext() instanceof Application) {
                Application application = (Application) zzlwVar.zzu.f14254a.getApplicationContext();
                if (zzlwVar.zza == null) {
                    zzlwVar.zza = new C0828x(zzlwVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzlwVar.zza);
                    application.registerActivityLifecycleCallbacks(zzlwVar.zza);
                    zzhe zzheVar2 = zzlwVar.zzu.f14262i;
                    m3555c(zzheVar2);
                    zzheVar2.zzj().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            m3555c(zzheVar);
            zzheVar.zzk().zza("Application context is not an Application");
        }
        zzilVar.zzq(new RunnableC0807k(0, zzkeVar, this));
    }

    /* renamed from: a */
    public static final void m3553a(AbstractC0811m abstractC0811m) {
        if (abstractC0811m != null) {
        } else {
            throw new IllegalStateException("Component not created");
        }
    }

    /* renamed from: b */
    public static final void m3554b(mb3 mb3Var) {
        if (mb3Var != null) {
            if (mb3Var.f22888a) {
                return;
            } else {
                throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(mb3Var.getClass())));
            }
        }
        throw new IllegalStateException("Component not created");
    }

    /* renamed from: c */
    public static final void m3555c(fc3 fc3Var) {
        if (fc3Var != null) {
            if (fc3Var.f17212a) {
                return;
            } else {
                throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(fc3Var.getClass())));
            }
        }
        throw new IllegalStateException("Component not created");
    }

    public static /* synthetic */ void zzB(zzio zzioVar, String str, int i, Throwable th, byte[] bArr, Map map) {
        int i2;
        zzhe zzheVar;
        BroadcastOptions makeBasic;
        BroadcastOptions shareIdentityEnabled;
        Bundle bundle;
        if (i != 200 && i != 204) {
            i2 = 304;
            if (i != 304) {
                i2 = i;
                zzhe zzheVar2 = zzioVar.f14262i;
                m3555c(zzheVar2);
                zzheVar2.zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            }
        } else {
            i2 = i;
        }
        if (th == null) {
            ub3 ub3Var = zzioVar.f14261h;
            m3553a(ub3Var);
            ub3Var.f27211t.zza(true);
            zzhe zzheVar3 = zzioVar.f14262i;
            if (bArr != null && bArr.length != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String optString = jSONObject.optString("deeplink", "");
                    if (TextUtils.isEmpty(optString)) {
                        m3555c(zzheVar3);
                        zzheVar3.zzd().zza("Deferred Deep Link is empty.");
                        return;
                    }
                    String optString2 = jSONObject.optString("gclid", "");
                    String optString3 = jSONObject.optString("gbraid", "");
                    String optString4 = jSONObject.optString("gad_source", "");
                    double optDouble = jSONObject.optDouble("timestamp", 0.0d);
                    Bundle bundle2 = new Bundle();
                    zzqf zzqfVar = zzioVar.f14265l;
                    m3553a(zzqfVar);
                    zzio zzioVar2 = zzqfVar.zzu;
                    if (TextUtils.isEmpty(optString)) {
                        zzheVar = zzheVar3;
                    } else {
                        Context context = zzioVar2.f14254a;
                        zzheVar = zzheVar3;
                        try {
                            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                                if (!TextUtils.isEmpty(optString3)) {
                                    bundle2.putString("gbraid", optString3);
                                }
                                if (!TextUtils.isEmpty(optString4)) {
                                    bundle2.putString("gad_source", optString4);
                                }
                                bundle2.putString("gclid", optString2);
                                bundle2.putString("_cis", "ddp");
                                zzioVar.f14269p.m3567c(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmp", bundle2);
                                if (!TextUtils.isEmpty(optString)) {
                                    try {
                                        SharedPreferences.Editor edit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                        edit.putString("deeplink", optString);
                                        edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                                        if (edit.commit()) {
                                            Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                            Context context2 = zzqfVar.zzu.f14254a;
                                            if (Build.VERSION.SDK_INT >= 34) {
                                                makeBasic = BroadcastOptions.makeBasic();
                                                shareIdentityEnabled = makeBasic.setShareIdentityEnabled(true);
                                                bundle = shareIdentityEnabled.toBundle();
                                                context2.sendBroadcast(intent, null, bundle);
                                                return;
                                            }
                                            context2.sendBroadcast(intent);
                                            return;
                                        }
                                        return;
                                    } catch (RuntimeException e) {
                                        zzhe zzheVar4 = zzqfVar.zzu.f14262i;
                                        m3555c(zzheVar4);
                                        zzheVar4.zze().zzb("Failed to persist Deferred Deep Link. exception", e);
                                        return;
                                    }
                                }
                                return;
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            m3555c(zzheVar);
                            zzheVar.zze().zzb("Failed to parse the Deferred Deep Link response. exception", e);
                            return;
                        }
                    }
                    m3555c(zzheVar);
                    zzheVar.zzk().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                    return;
                } catch (JSONException e3) {
                    e = e3;
                    zzheVar = zzheVar3;
                }
            } else {
                m3555c(zzheVar3);
                zzheVar3.zzd().zza("Deferred Deep Link response empty.");
                return;
            }
        }
        zzhe zzheVar22 = zzioVar.f14262i;
        m3555c(zzheVar22);
        zzheVar22.zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    public static zzio zzp(Context context, com.google.android.gms.internal.measurement.zzdh zzdhVar, Long l) {
        Bundle bundle;
        if (zzdhVar != null && (zzdhVar.zze == null || zzdhVar.zzf == null)) {
            zzdhVar = new com.google.android.gms.internal.measurement.zzdh(zzdhVar.zza, zzdhVar.zzb, zzdhVar.zzc, zzdhVar.zzd, null, null, zzdhVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f14246H == null) {
            synchronized (zzio.class) {
                try {
                    if (f14246H == null) {
                        f14246H = new zzio(new zzke(context, zzdhVar, l));
                    }
                } finally {
                }
            }
        } else if (zzdhVar != null && (bundle = zzdhVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(f14246H);
            f14246H.f14248B = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(f14246H);
        return f14246H;
    }

    @Pure
    public final String zzA() {
        return this.f14272s;
    }

    @WorkerThread
    public final void zzG(boolean z) {
        zzil zzilVar = this.f14263j;
        m3555c(zzilVar);
        zzilVar.zzg();
        this.f14249C = z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:92|(2:94|(9:151|118|(1:120)|121|122|123|124|125|(5:131|(1:133)(1:141)|(1:137)|(1:139)|140)))(1:152)|98|(4:100|(2:103|(2:105|106))|149|106)(1:150)|(5:108|(1:110)(1:147)|111|(1:113)|114)(1:148)|115|(1:117)(1:146)|118|(0)|121|122|123|124|125|(2:127|129)|131|(0)(0)|(2:135|137)|(0)|140) */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0485, code lost:
    
        r1 = r2.f27213v;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x048f, code lost:
    
        if (android.text.TextUtils.isEmpty(r1.zza()) == false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0491, code lost:
    
        m3555c(r9);
        r9.zzk().zza("Remote config removed with active feature rollouts");
        r5 = null;
        r1.zzb(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0135, code lost:
    
        if (r4.zzt() == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r11.m3719Q() == 1) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02fc  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzH(com.google.android.gms.internal.measurement.zzdh zzdhVar) {
        boolean z;
        zzjx zzj;
        Bundle bundle;
        Boolean zzg;
        Bundle bundle2;
        Boolean m3512d;
        long zza;
        zzx zzxVar;
        String str;
        zzlw zzlwVar;
        zzlw zzlwVar2;
        boolean zzJ;
        SharedPreferences sharedPreferences;
        boolean contains;
        zzam zzamVar;
        boolean m3714J;
        String str2;
        Boolean bool;
        boolean z2;
        Bundle bundle3;
        zzil zzilVar = this.f14263j;
        m3555c(zzilVar);
        zzilVar.zzg();
        zzgg zzggVar = zzgi.zzaR;
        zzam zzamVar2 = this.f14260g;
        if (zzamVar2.zzx(null, zzggVar) && zzs().m3576a() == zzih.CLIENT_UPLOAD_ELIGIBLE) {
            z = true;
        } else {
            z = false;
        }
        zzqr.zzb();
        boolean zzx = zzamVar2.zzx(null, zzgi.zzaW);
        zzqf zzqfVar = this.f14265l;
        if (zzx) {
            m3553a(zzqfVar);
            zzqfVar.zzg();
        }
        if (z) {
            z = true;
            m3553a(zzqfVar);
            zzqfVar.zzg();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            zzio zzioVar = zzqfVar.zzu;
            if (zzioVar.f14260g.zzx(null, zzggVar)) {
                intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
            }
            ContextCompat.registerReceiver(zzioVar.f14254a, new zzw(zzqfVar.zzu), intentFilter, 2);
            zzhe zzheVar = zzioVar.f14262i;
            m3555c(zzheVar);
            zzheVar.zzd().zza("Registered app receiver");
            if (z) {
                zzs().zzj(((Long) zzgi.zzB.zza(null)).longValue());
            }
        }
        ub3 ub3Var = this.f14261h;
        m3553a(ub3Var);
        zzjx m7694d = ub3Var.m7694d();
        int zzb = m7694d.zzb();
        zzju zzm = zzamVar2.zzm("google_analytics_default_allow_ad_storage", false);
        zzju zzm2 = zzamVar2.zzm("google_analytics_default_allow_analytics_storage", false);
        zzju zzjuVar = zzju.UNINITIALIZED;
        zzlw zzlwVar3 = this.f14269p;
        if ((zzm != zzjuVar || zzm2 != zzjuVar) && zzjx.zzs(-10, ub3Var.m7692b().getInt("consent_source", 100))) {
            zzj = zzjx.zzj(zzm, zzm2, -10);
        } else if (!TextUtils.isEmpty(zzh().zzo()) && (zzb == 0 || zzb == 30 || zzb == 10 || zzb == 30 || zzb == 30 || zzb == 40)) {
            m3554b(zzlwVar3);
            zzlwVar3.zzak(new zzjx(null, null, -10), false);
            zzj = null;
        } else {
            if (!zzamVar2.zzx(null, zzgi.zzbp) && TextUtils.isEmpty(zzh().zzo()) && zzdhVar != null && (bundle3 = zzdhVar.zzg) != null && zzjx.zzs(30, ub3Var.m7692b().getInt("consent_source", 100))) {
                zzj = zzjx.zzi(bundle3, 30);
            }
            zzj = null;
        }
        if (zzj != null) {
            m3554b(zzlwVar3);
            zzlwVar3.zzak(zzj, true);
            m7694d = zzj;
        }
        m3554b(zzlwVar3);
        zzlwVar3.m3571g(m7694d);
        ub3Var.zzg();
        int zza2 = zzba.zze(ub3Var.m7692b().getString("dma_consent_settings", null)).zza();
        zzju zzm3 = zzamVar2.zzm("google_analytics_default_allow_ad_personalization_signals", true);
        zzhe zzheVar2 = this.f14262i;
        if (zzm3 != zzjuVar) {
            m3555c(zzheVar2);
            zzheVar2.zzj().zzb("Default ad personalization consent from Manifest", zzm3);
        }
        zzju zzm4 = zzamVar2.zzm("google_analytics_default_allow_ad_user_data", true);
        if (zzm4 != zzjuVar && zzjx.zzs(-10, zza2)) {
            m3554b(zzlwVar3);
            EnumMap enumMap = new EnumMap(zzjw.class);
            enumMap.put((EnumMap) zzjw.AD_USER_DATA, (zzjw) zzm4);
            zzlwVar3.m3570f(new zzba(enumMap, -10, (Boolean) null, (String) null), true);
        } else if (!TextUtils.isEmpty(zzh().zzo()) && (zza2 == 0 || zza2 == 30)) {
            m3554b(zzlwVar3);
            zzlwVar3.m3570f(new zzba((Boolean) null, -10, (Boolean) null, (String) null), true);
        } else {
            if (TextUtils.isEmpty(zzh().zzo()) && zzdhVar != null && (bundle2 = zzdhVar.zzg) != null && zzjx.zzs(30, zza2)) {
                zzba zzc = zzba.zzc(bundle2, 30);
                if (zzc.zzk()) {
                    m3554b(zzlwVar3);
                    zzlwVar3.m3570f(zzc, true);
                }
            }
            if (TextUtils.isEmpty(zzh().zzo()) && zzdhVar != null && (bundle = zzdhVar.zzg) != null && ub3Var.f27204m.zza() == null && (zzg = zzba.zzg(bundle)) != null) {
                m3554b(zzlwVar3);
                zzlwVar3.zzal(zzdhVar.zze, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzg.toString(), false);
                m3512d = zzamVar2.m3512d("google_analytics_tcf_data_enabled");
                if (m3512d != null || m3512d.booleanValue()) {
                    m3555c(zzheVar2);
                    zzheVar2.zzd().zza("TCF client enabled.");
                    m3554b(zzlwVar3);
                    zzlwVar3.zzW();
                    m3554b(zzlwVar3);
                    zzlwVar3.zzN();
                }
                zzhp zzhpVar = ub3Var.f27197f;
                zza = zzhpVar.zza();
                long j = this.f14253G;
                if (zza == 0) {
                    m3555c(zzheVar2);
                    zzheVar2.zzj().zzb("Persisting first open", Long.valueOf(j));
                    zzhpVar.zzb(j);
                }
                m3554b(zzlwVar3);
                zzxVar = zzlwVar3.f14314p;
                if (zzxVar.m3745b() && zzxVar.m3746c()) {
                    zzxVar.f14413a.zzm().f27214w.zzb(null);
                }
                if (zzM()) {
                    if (zzJ()) {
                        m3553a(zzqfVar);
                        if (!zzqfVar.m3711A("android.permission.INTERNET")) {
                            m3555c(zzheVar2);
                            zzheVar2.zze().zza("App is missing INTERNET permission");
                        }
                        if (!zzqfVar.m3711A("android.permission.ACCESS_NETWORK_STATE")) {
                            m3555c(zzheVar2);
                            zzheVar2.zze().zza("App is missing ACCESS_NETWORK_STATE permission");
                        }
                        Context context = this.f14254a;
                        if (!Wrappers.packageManager(context).isCallerInstantApp() && !zzamVar2.m3509a()) {
                            if (!zzqf.m3701G(context)) {
                                m3555c(zzheVar2);
                                zzheVar2.zze().zza("AppMeasurementReceiver not registered/enabled");
                            }
                            if (!zzqf.m3703I(context)) {
                                m3555c(zzheVar2);
                                zzheVar2.zze().zza("AppMeasurementService not registered/enabled");
                            }
                        }
                        m3555c(zzheVar2);
                        zzheVar2.zze().zza("Uploading is not possible. App measurement disabled");
                    }
                    zzlwVar2 = zzlwVar3;
                } else {
                    boolean isEmpty = TextUtils.isEmpty(zzh().zzo());
                    zzhr zzhrVar = ub3Var.f27198g;
                    if (isEmpty) {
                        str = null;
                        if (zzamVar2.zzx(null, zzgi.zzbp) || TextUtils.isEmpty(zzh().m3526b())) {
                            zzlwVar = zzlwVar3;
                            if (!ub3Var.m7694d().zzr(zzjw.ANALYTICS_STORAGE)) {
                                zzhrVar.zzb(null);
                            }
                            m3554b(zzlwVar);
                            zzlwVar2 = zzlwVar;
                            zzlwVar2.f14303e.set(zzhrVar.zza());
                            m3553a(zzqfVar);
                            zzqfVar.zzu.f14254a.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                            String str3 = null;
                            if (TextUtils.isEmpty(zzh().zzo()) || (!zzamVar2.zzx(str3, zzgi.zzbp) && !TextUtils.isEmpty(zzh().m3526b()))) {
                                zzJ = zzJ();
                                sharedPreferences = ub3Var.f27193b;
                                if (sharedPreferences != null) {
                                    contains = false;
                                } else {
                                    contains = sharedPreferences.contains("deferred_analytics_collection");
                                }
                                if (!contains && !zzamVar2.zzA()) {
                                    ub3Var.m7695e(!zzJ);
                                }
                                if (zzJ) {
                                    m3554b(zzlwVar2);
                                    zzlwVar2.zzH();
                                }
                                zzop zzopVar = this.f14264k;
                                m3554b(zzopVar);
                                zzopVar.zza.m3498a();
                                zzu().zzE(new AtomicReference());
                                zzu().zzT(ub3Var.f27216y.zza());
                            }
                        }
                    } else {
                        str = null;
                    }
                    zzgg zzggVar2 = zzgi.zzbp;
                    if (zzamVar2.zzx(str, zzggVar2)) {
                        m3553a(zzqfVar);
                        String zzo = zzh().zzo();
                        ub3Var.zzg();
                        String string = ub3Var.m7692b().getString("gmp_app_id", str);
                        boolean isEmpty2 = TextUtils.isEmpty(zzo);
                        boolean isEmpty3 = TextUtils.isEmpty(string);
                        if (!isEmpty2 && !isEmpty3) {
                            Preconditions.checkNotNull(zzo);
                            if (!zzo.equals(string)) {
                                m3714J = true;
                                zzamVar = zzamVar2;
                                zzlwVar = zzlwVar3;
                            }
                        }
                        m3714J = false;
                        zzamVar = zzamVar2;
                        zzlwVar = zzlwVar3;
                    } else {
                        m3553a(zzqfVar);
                        String zzo2 = zzh().zzo();
                        ub3Var.zzg();
                        String string2 = ub3Var.m7692b().getString("gmp_app_id", null);
                        String m3526b = zzh().m3526b();
                        ub3Var.zzg();
                        zzlwVar = zzlwVar3;
                        zzamVar = zzamVar2;
                        m3714J = zzqfVar.m3714J(zzo2, string2, m3526b, ub3Var.m7692b().getString("admob_app_id", null));
                    }
                    if (m3714J) {
                        m3555c(zzheVar2);
                        zzheVar2.zzi().zza("Rechecking which service to use due to a GMP App Id change");
                        ub3Var.zzg();
                        ub3Var.zzg();
                        if (ub3Var.m7692b().contains("measurement_enabled")) {
                            bool = Boolean.valueOf(ub3Var.m7692b().getBoolean("measurement_enabled", true));
                        } else {
                            bool = null;
                        }
                        SharedPreferences.Editor edit = ub3Var.m7692b().edit();
                        edit.clear();
                        edit.apply();
                        if (bool != null) {
                            ub3Var.zzg();
                            SharedPreferences.Editor edit2 = ub3Var.m7692b().edit();
                            edit2.putBoolean("measurement_enabled", bool.booleanValue());
                            edit2.apply();
                        }
                        zzi().zzj();
                        this.f14274u.zzC();
                        this.f14274u.m3583a();
                        zzhpVar.zzb(j);
                        str2 = null;
                        zzhrVar.zzb(null);
                    } else {
                        str2 = null;
                    }
                    String zzo3 = zzh().zzo();
                    ub3Var.zzg();
                    SharedPreferences.Editor edit3 = ub3Var.m7692b().edit();
                    edit3.putString("gmp_app_id", zzo3);
                    edit3.apply();
                    zzamVar2 = zzamVar;
                    if (zzamVar2.zzx(str2, zzggVar2)) {
                        ub3Var.zzg();
                        SharedPreferences.Editor edit4 = ub3Var.m7692b().edit();
                        edit4.putString("admob_app_id", str2);
                        edit4.apply();
                    } else {
                        String m3526b2 = zzh().m3526b();
                        ub3Var.zzg();
                        SharedPreferences.Editor edit5 = ub3Var.m7692b().edit();
                        edit5.putString("admob_app_id", m3526b2);
                        edit5.apply();
                    }
                    if (!ub3Var.m7694d().zzr(zzjw.ANALYTICS_STORAGE)) {
                    }
                    m3554b(zzlwVar);
                    zzlwVar2 = zzlwVar;
                    zzlwVar2.f14303e.set(zzhrVar.zza());
                    m3553a(zzqfVar);
                    zzqfVar.zzu.f14254a.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                    String str32 = null;
                    if (TextUtils.isEmpty(zzh().zzo())) {
                    }
                    zzJ = zzJ();
                    sharedPreferences = ub3Var.f27193b;
                    if (sharedPreferences != null) {
                    }
                    if (!contains) {
                        ub3Var.m7695e(!zzJ);
                    }
                    if (zzJ) {
                    }
                    zzop zzopVar2 = this.f14264k;
                    m3554b(zzopVar2);
                    zzopVar2.zza.m3498a();
                    zzu().zzE(new AtomicReference());
                    zzu().zzT(ub3Var.f27216y.zza());
                }
                zzqr.zzb();
                if (zzamVar2.zzx(null, zzgi.zzaW)) {
                    m3553a(zzqfVar);
                    zzqfVar.zzg();
                    if (zzqfVar.m3719Q() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        long max = Math.max(500L, ((((Integer) zzgi.zzaw.zza(null)).intValue() * 1000) + new Random().nextInt(5000)) - this.f14267n.elapsedRealtime());
                        if (max > 500) {
                            m3555c(zzheVar2);
                            zzheVar2.zzj().zzb("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(max));
                        }
                        m3554b(zzlwVar2);
                        zzlwVar2.zzg();
                        if (zzlwVar2.f14308j == null) {
                            zzlwVar2.f14308j = new C0813n(zzlwVar2, zzlwVar2.zzu, 0);
                        }
                        zzlwVar2.f14308j.m8016c(max);
                    }
                }
                ub3Var.f27206o.zza(true);
            }
        }
        m3512d = zzamVar2.m3512d("google_analytics_tcf_data_enabled");
        if (m3512d != null) {
        }
        m3555c(zzheVar2);
        zzheVar2.zzd().zza("TCF client enabled.");
        m3554b(zzlwVar3);
        zzlwVar3.zzW();
        m3554b(zzlwVar3);
        zzlwVar3.zzN();
        zzhp zzhpVar2 = ub3Var.f27197f;
        zza = zzhpVar2.zza();
        long j2 = this.f14253G;
        if (zza == 0) {
        }
        m3554b(zzlwVar3);
        zzxVar = zzlwVar3.f14314p;
        if (zzxVar.m3745b()) {
            zzxVar.f14413a.zzm().f27214w.zzb(null);
        }
        if (zzM()) {
        }
        zzqr.zzb();
        if (zzamVar2.zzx(null, zzgi.zzaW)) {
        }
        ub3Var.f27206o.zza(true);
    }

    @WorkerThread
    public final boolean zzI() {
        if (this.f14248B != null && this.f14248B.booleanValue()) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean zzJ() {
        if (zza() == 0) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean zzK() {
        zzil zzilVar = this.f14263j;
        m3555c(zzilVar);
        zzilVar.zzg();
        return this.f14249C;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.f14255b);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzM() {
        boolean z;
        if (this.f14278y) {
            zzil zzilVar = this.f14263j;
            m3555c(zzilVar);
            zzilVar.zzg();
            Boolean bool = this.f14279z;
            Clock clock = this.f14267n;
            if (bool == null || this.f14247A == 0 || (!bool.booleanValue() && Math.abs(clock.elapsedRealtime() - this.f14247A) > 1000)) {
                this.f14247A = clock.elapsedRealtime();
                zzqf zzqfVar = this.f14265l;
                m3553a(zzqfVar);
                boolean m3711A = zzqfVar.m3711A("android.permission.INTERNET");
                zzam zzamVar = this.f14260g;
                boolean z2 = true;
                if (m3711A && zzqfVar.m3711A("android.permission.ACCESS_NETWORK_STATE")) {
                    Context context = this.f14254a;
                    if (Wrappers.packageManager(context).isCallerInstantApp() || zzamVar.m3509a() || (zzqf.m3701G(context) && zzqf.m3703I(context))) {
                        z = true;
                        this.f14279z = Boolean.valueOf(z);
                        if (z) {
                            if (!zzqfVar.m3738u(zzh().zzo(), zzh().m3526b()) && (zzamVar.zzx(null, zzgi.zzbp) || TextUtils.isEmpty(zzh().m3526b()))) {
                                z2 = false;
                            }
                            this.f14279z = Boolean.valueOf(z2);
                        }
                    }
                }
                z = false;
                this.f14279z = Boolean.valueOf(z);
                if (z) {
                }
            }
            return this.f14279z.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean zzN() {
        return this.f14258e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x010d, code lost:
    
        if (r8.zzm() >= 234200) goto L41;
     */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzO() {
        Pair pair;
        NetworkInfo activeNetworkInfo;
        String str;
        zzil zzilVar = this.f14263j;
        m3555c(zzilVar);
        zzilVar.zzg();
        zzmb zzmbVar = this.f14271r;
        m3555c(zzmbVar);
        m3555c(zzmbVar);
        String m3527c = zzh().m3527c();
        boolean zzw = this.f14260g.zzw();
        zzhe zzheVar = this.f14262i;
        boolean z = false;
        if (zzw) {
            ub3 ub3Var = this.f14261h;
            m3553a(ub3Var);
            ub3Var.zzg();
            if (ub3Var.m7694d().zzr(zzjw.AD_STORAGE)) {
                zzio zzioVar = ub3Var.zzu;
                long elapsedRealtime = zzioVar.zzaU().elapsedRealtime();
                String str2 = ub3Var.f27199h;
                if (str2 != null && elapsedRealtime < ub3Var.f27201j) {
                    pair = new Pair(str2, Boolean.valueOf(ub3Var.f27200i));
                } else {
                    ub3Var.f27201j = zzioVar.zzf().zzk(m3527c, zzgi.zza) + elapsedRealtime;
                    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
                    try {
                        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzioVar.zzaT());
                        ub3Var.f27199h = "";
                        String id = advertisingIdInfo.getId();
                        if (id != null) {
                            ub3Var.f27199h = id;
                        }
                        ub3Var.f27200i = advertisingIdInfo.isLimitAdTrackingEnabled();
                    } catch (Exception e) {
                        ub3Var.zzu.zzaW().zzd().zzb("Unable to get advertising id", e);
                        ub3Var.f27199h = "";
                    }
                    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
                    pair = new Pair(ub3Var.f27199h, Boolean.valueOf(ub3Var.f27200i));
                }
            } else {
                pair = new Pair("", Boolean.FALSE);
            }
            if (!((Boolean) pair.second).booleanValue() && !TextUtils.isEmpty((CharSequence) pair.first)) {
                m3555c(zzmbVar);
                zzmbVar.zzv();
                ConnectivityManager connectivityManager = (ConnectivityManager) zzmbVar.zzu.f14254a.getSystemService("connectivity");
                Bundle bundle = null;
                if (connectivityManager != null) {
                    try {
                        activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    } catch (SecurityException unused) {
                    }
                    if (activeNetworkInfo == null && activeNetworkInfo.isConnected()) {
                        StringBuilder sb = new StringBuilder();
                        zzny zzu = zzu();
                        zzu.zzg();
                        zzu.zza();
                        if (zzu.m3586d()) {
                            zzqf zzqfVar = zzu.zzu.f14265l;
                            m3553a(zzqfVar);
                        }
                        zzlw zzlwVar = this.f14269p;
                        m3554b(zzlwVar);
                        zzio zzioVar2 = zzlwVar.zzu;
                        zzlwVar.zzg();
                        zzap zzh = zzioVar2.zzu().zzh();
                        if (zzh != null) {
                            bundle = zzh.zza;
                        }
                        if (bundle == null) {
                            int i = this.f14251E;
                            this.f14251E = i + 1;
                            if (i < 10) {
                                z = true;
                            }
                            m3555c(zzheVar);
                            zzhc zzd = zzheVar.zzd();
                            StringBuilder sb2 = new StringBuilder("Failed to retrieve DMA consent from the service, ");
                            if (i < 10) {
                                str = "Retrying.";
                            } else {
                                str = "Skipping.";
                            }
                            zzd.zzb(AbstractC1726qj.m7061q(sb2, str, " retryCount"), Integer.valueOf(this.f14251E));
                            return z;
                        }
                        zzjx zzi = zzjx.zzi(bundle, 100);
                        sb.append("&gcs=");
                        sb.append(zzi.zzp());
                        zzba zzc = zzba.zzc(bundle, 100);
                        sb.append("&dma=");
                        sb.append(!Objects.equals(zzc.zzh(), Boolean.FALSE) ? 1 : 0);
                        if (!TextUtils.isEmpty(zzc.zzi())) {
                            sb.append("&dma_cps=");
                            sb.append(zzc.zzi());
                        }
                        int i2 = 1 ^ (Objects.equals(zzba.zzg(bundle), Boolean.TRUE) ? 1 : 0);
                        sb.append("&npa=");
                        sb.append(i2);
                        m3555c(zzheVar);
                        zzheVar.zzj().zzb("Consent query parameters to Bow", sb);
                        zzqf zzqfVar2 = this.f14265l;
                        m3553a(zzqfVar2);
                        zzh().zzu.f14260g.zzj();
                        URL zzH = zzqfVar2.zzH(119002L, m3527c, (String) pair.first, (-1) + ub3Var.f27212u.zza(), sb.toString());
                        if (zzH != null) {
                            m3555c(zzmbVar);
                            bd3 bd3Var = new bd3() { // from class: com.google.android.gms.measurement.internal.zzim
                                @Override // p000.bd3
                                public final void zza(String str3, int i3, Throwable th, byte[] bArr, Map map) {
                                    zzio.zzB(zzio.this, str3, i3, th, bArr, map);
                                }
                            };
                            zzmbVar.zzv();
                            Preconditions.checkNotNull(zzH);
                            Preconditions.checkNotNull(bd3Var);
                            zzil zzilVar2 = zzmbVar.zzu.f14263j;
                            m3555c(zzilVar2);
                            zzilVar2.zzp(new RunnableC0829y(zzmbVar, m3527c, zzH, null, null, bd3Var));
                        }
                        return false;
                    }
                    m3555c(zzheVar);
                    zzheVar.zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
                    return false;
                }
                activeNetworkInfo = null;
                if (activeNetworkInfo == null) {
                }
                m3555c(zzheVar);
                zzheVar.zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
                return false;
            }
            m3555c(zzheVar);
            zzheVar.zzj().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        m3555c(zzheVar);
        zzheVar.zzj().zza("ADID collection is disabled from Manifest. Skipping");
        return false;
    }

    @WorkerThread
    public final int zza() {
        Boolean bool;
        zzil zzilVar = this.f14263j;
        m3555c(zzilVar);
        zzilVar.zzg();
        zzam zzamVar = this.f14260g;
        if (zzamVar.zzA()) {
            return 1;
        }
        m3555c(zzilVar);
        zzilVar.zzg();
        if (this.f14249C) {
            ub3 ub3Var = this.f14261h;
            m3553a(ub3Var);
            ub3Var.zzg();
            if (ub3Var.m7692b().contains("measurement_enabled")) {
                bool = Boolean.valueOf(ub3Var.m7692b().getBoolean("measurement_enabled", true));
            } else {
                bool = null;
            }
            if (bool != null) {
                if (bool.booleanValue()) {
                    return 0;
                }
                return 3;
            }
            zzaf zzafVar = zzamVar.zzu.f14259f;
            Boolean m3512d = zzamVar.m3512d("firebase_analytics_collection_enabled");
            if (m3512d != null) {
                if (m3512d.booleanValue()) {
                    return 0;
                }
                return 4;
            }
            if (this.f14248B == null || this.f14248B.booleanValue()) {
                return 0;
            }
            return 7;
        }
        return 8;
    }

    @Override // p000.hc3
    @Pure
    public final Context zzaT() {
        return this.f14254a;
    }

    @Override // p000.hc3
    @Pure
    public final Clock zzaU() {
        return this.f14267n;
    }

    @Override // p000.hc3
    @Pure
    public final zzaf zzaV() {
        return this.f14259f;
    }

    @Override // p000.hc3
    @Pure
    public final zzhe zzaW() {
        zzhe zzheVar = this.f14262i;
        m3555c(zzheVar);
        return zzheVar;
    }

    @Override // p000.hc3
    @Pure
    public final zzil zzaX() {
        zzil zzilVar = this.f14263j;
        m3555c(zzilVar);
        return zzilVar;
    }

    @Pure
    public final zzd zzd() {
        zzd zzdVar = this.f14270q;
        if (zzdVar != null) {
            return zzdVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzam zzf() {
        return this.f14260g;
    }

    @Pure
    public final zzbb zzg() {
        m3555c(this.f14275v);
        return this.f14275v;
    }

    @Pure
    public final zzgs zzh() {
        m3554b(this.f14276w);
        return this.f14276w;
    }

    @Pure
    public final zzgv zzi() {
        m3554b(this.f14273t);
        return this.f14273t;
    }

    @Pure
    public final zzgx zzj() {
        return this.f14266m;
    }

    public final zzhe zzl() {
        zzhe zzheVar = this.f14262i;
        if (zzheVar != null && zzheVar.f17212a) {
            return zzheVar;
        }
        return null;
    }

    @Pure
    public final ub3 zzm() {
        ub3 ub3Var = this.f14261h;
        m3553a(ub3Var);
        return ub3Var;
    }

    @Pure
    public final zzlw zzq() {
        zzlw zzlwVar = this.f14269p;
        m3554b(zzlwVar);
        return zzlwVar;
    }

    @Pure
    public final zzmb zzr() {
        zzmb zzmbVar = this.f14271r;
        m3555c(zzmbVar);
        return zzmbVar;
    }

    @Pure
    public final zzmd zzs() {
        zzmd zzmdVar = this.f14277x;
        if (zzmdVar != null) {
            return zzmdVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzmo zzt() {
        zzmo zzmoVar = this.f14268o;
        m3554b(zzmoVar);
        return zzmoVar;
    }

    @Pure
    public final zzny zzu() {
        m3554b(this.f14274u);
        return this.f14274u;
    }

    @Pure
    public final zzop zzv() {
        zzop zzopVar = this.f14264k;
        m3554b(zzopVar);
        return zzopVar;
    }

    @Pure
    public final zzqf zzw() {
        zzqf zzqfVar = this.f14265l;
        m3553a(zzqfVar);
        return zzqfVar;
    }

    @Pure
    public final String zzx() {
        if (this.f14260g.zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.f14255b;
    }

    @Pure
    public final String zzy() {
        if (this.f14260g.zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.f14256c;
    }

    @Pure
    public final String zzz() {
        return this.f14257d;
    }
}
