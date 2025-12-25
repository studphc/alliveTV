package p000;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.measurement.internal.zzhp;
import com.google.android.gms.measurement.internal.zzhq;
import com.google.android.gms.measurement.internal.zzhr;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzjx;
import com.google.android.gms.measurement.internal.zzoq;

/* loaded from: classes.dex */
public final class ub3 extends fc3 {

    /* renamed from: z */
    public static final Pair f27192z = new Pair("", 0L);

    /* renamed from: b */
    public SharedPreferences f27193b;

    /* renamed from: c */
    public final Object f27194c;

    /* renamed from: d */
    public SharedPreferences f27195d;

    /* renamed from: e */
    public zzhq f27196e;

    /* renamed from: f */
    public final zzhp f27197f;

    /* renamed from: g */
    public final zzhr f27198g;

    /* renamed from: h */
    public String f27199h;

    /* renamed from: i */
    public boolean f27200i;

    /* renamed from: j */
    public long f27201j;

    /* renamed from: k */
    public final zzhp f27202k;

    /* renamed from: l */
    public final zzhn f27203l;

    /* renamed from: m */
    public final zzhr f27204m;

    /* renamed from: n */
    public final zzho f27205n;

    /* renamed from: o */
    public final zzhn f27206o;

    /* renamed from: p */
    public final zzhp f27207p;

    /* renamed from: q */
    public final zzhp f27208q;

    /* renamed from: r */
    public boolean f27209r;

    /* renamed from: s */
    public final zzhn f27210s;

    /* renamed from: t */
    public final zzhn f27211t;

    /* renamed from: u */
    public final zzhp f27212u;

    /* renamed from: v */
    public final zzhr f27213v;

    /* renamed from: w */
    public final zzhr f27214w;

    /* renamed from: x */
    public final zzhp f27215x;

    /* renamed from: y */
    public final zzho f27216y;

    public ub3(zzio zzioVar) {
        super(zzioVar);
        this.f27194c = new Object();
        this.f27202k = new zzhp(this, "session_timeout", 1800000L);
        this.f27203l = new zzhn(this, "start_new_session", true);
        this.f27207p = new zzhp(this, "last_pause_time", 0L);
        this.f27208q = new zzhp(this, "session_id", 0L);
        this.f27204m = new zzhr(this, "non_personalized_ads", null);
        this.f27205n = new zzho(this, "last_received_uri_timestamps_by_source", null);
        this.f27206o = new zzhn(this, "allow_remote_dynamite", false);
        this.f27197f = new zzhp(this, "first_open_time", 0L);
        new zzhp(this, "app_install_time", 0L);
        this.f27198g = new zzhr(this, "app_instance_id", null);
        this.f27210s = new zzhn(this, "app_backgrounded", false);
        this.f27211t = new zzhn(this, "deep_link_retrieval_complete", false);
        this.f27212u = new zzhp(this, "deep_link_retrieval_attempts", 0L);
        this.f27213v = new zzhr(this, "firebase_feature_rollouts", null);
        this.f27214w = new zzhr(this, "deferred_attribution_cache", null);
        this.f27215x = new zzhp(this, "deferred_attribution_cache_timestamp", 0L);
        this.f27216y = new zzho(this, "default_event_parameters", null);
    }

    /* renamed from: a */
    public final SharedPreferences m7691a() {
        zzg();
        zzv();
        if (this.f27195d == null) {
            synchronized (this.f27194c) {
                try {
                    if (this.f27195d == null) {
                        zzio zzioVar = this.zzu;
                        String str = zzioVar.zzaT().getPackageName() + "_preferences";
                        zzioVar.zzaW().zzj().zzb("Default prefs file", str);
                        this.f27195d = zzioVar.zzaT().getSharedPreferences(str, 0);
                    }
                } finally {
                }
            }
        }
        return this.f27195d;
    }

    /* renamed from: b */
    public final SharedPreferences m7692b() {
        zzg();
        zzv();
        Preconditions.checkNotNull(this.f27193b);
        return this.f27193b;
    }

    /* renamed from: c */
    public final SparseArray m7693c() {
        Bundle zza = this.f27205n.zza();
        int[] intArray = zza.getIntArray("uriSources");
        long[] longArray = zza.getLongArray("uriTimestamps");
        if (intArray != null && longArray != null) {
            if (intArray.length != longArray.length) {
                this.zzu.zzaW().zze().zza("Trigger URI source and timestamp array lengths do not match");
                return new SparseArray();
            }
            SparseArray sparseArray = new SparseArray();
            for (int i = 0; i < intArray.length; i++) {
                sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
            }
            return sparseArray;
        }
        return new SparseArray();
    }

    /* renamed from: d */
    public final zzjx m7694d() {
        zzg();
        return zzjx.zzk(m7692b().getString("consent_settings", "G1"), m7692b().getInt("consent_source", 100));
    }

    /* renamed from: e */
    public final void m7695e(boolean z) {
        zzg();
        this.zzu.zzaW().zzj().zzb("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = m7692b().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* renamed from: f */
    public final boolean m7696f(long j) {
        if (j - this.f27202k.zza() > this.f27207p.zza()) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public final boolean m7697g(zzoq zzoqVar) {
        zzg();
        String string = m7692b().getString("stored_tcf_param", "");
        String m3595a = zzoqVar.m3595a();
        if (!m3595a.equals(string)) {
            SharedPreferences.Editor edit = m7692b().edit();
            edit.putString("stored_tcf_param", m3595a);
            edit.apply();
            return true;
        }
        return false;
    }

    @Override // p000.fc3
    public final void zzaZ() {
        zzio zzioVar = this.zzu;
        SharedPreferences sharedPreferences = zzioVar.zzaT().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f27193b = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.f27209r = z;
        if (!z) {
            SharedPreferences.Editor edit = this.f27193b.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        zzioVar.zzf();
        this.f27196e = new zzhq(this, Math.max(0L, ((Long) zzgi.zzc.zza(null)).longValue()));
    }

    @Override // p000.fc3
    public final boolean zzc() {
        return true;
    }
}
