package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import p000.AbstractC1726qj;
import p000.r93;

/* loaded from: classes.dex */
public final class zzam extends AbstractC0811m {

    /* renamed from: a */
    public Boolean f14121a;

    /* renamed from: b */
    public String f14122b;

    /* renamed from: c */
    public r93 f14123c;

    /* renamed from: d */
    public Boolean f14124d;

    public static final long zzF() {
        return ((Long) zzgi.zzd.zza(null)).longValue();
    }

    public static final int zzG() {
        return Math.max(0, ((Integer) zzgi.zzi.zza(null)).intValue());
    }

    public static final long zzH() {
        return ((Integer) zzgi.zzk.zza(null)).intValue();
    }

    public static final long zzI() {
        return ((Long) zzgi.zzQ.zza(null)).longValue();
    }

    public static final long zzJ() {
        return ((Long) zzgi.zzL.zza(null)).longValue();
    }

    /* renamed from: a */
    public final boolean m3509a() {
        if (this.f14121a == null) {
            Boolean m3512d = m3512d("app_measurement_lite");
            this.f14121a = m3512d;
            if (m3512d == null) {
                this.f14121a = Boolean.FALSE;
            }
        }
        if (!this.f14121a.booleanValue() && this.zzu.zzN()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public final String m3510b(String str) {
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str2);
            return str2;
        } catch (ClassNotFoundException e) {
            this.zzu.zzaW().zze().zzb("Could not find SystemProperties class", e);
            return "";
        } catch (IllegalAccessException e2) {
            this.zzu.zzaW().zze().zzb("Could not access SystemProperties.get()", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            this.zzu.zzaW().zze().zzb("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (InvocationTargetException e4) {
            this.zzu.zzaW().zze().zzb("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    /* renamed from: c */
    public final Bundle m3511c() {
        try {
            zzio zzioVar = this.zzu;
            if (zzioVar.zzaT().getPackageManager() == null) {
                zzioVar.zzaW().zze().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzioVar.zzaT()).getApplicationInfo(zzioVar.zzaT().getPackageName(), 128);
            if (applicationInfo == null) {
                zzioVar.zzaW().zze().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzu.zzaW().zze().zzb("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* renamed from: d */
    public final Boolean m3512d(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle m3511c = m3511c();
        if (m3511c == null) {
            AbstractC1726qj.m7039D(this.zzu, "Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (!m3511c.containsKey(str)) {
            return null;
        }
        return Boolean.valueOf(m3511c.getBoolean(str));
    }

    public final boolean zzA() {
        this.zzu.zzaV();
        Boolean m3512d = m3512d("firebase_analytics_collection_deactivated");
        if (m3512d != null && m3512d.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean zzB(String str) {
        return IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(this.f14123c.zza(str, "measurement.event_sampling_enabled"));
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzD() {
        if (this.f14124d == null) {
            synchronized (this) {
                try {
                    if (this.f14124d == null) {
                        zzio zzioVar = this.zzu;
                        ApplicationInfo applicationInfo = zzioVar.zzaT().getApplicationInfo();
                        String myProcessName = ProcessUtils.getMyProcessName();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z = false;
                            if (str != null && str.equals(myProcessName)) {
                                z = true;
                            }
                            this.f14124d = Boolean.valueOf(z);
                        }
                        if (this.f14124d == null) {
                            this.f14124d = Boolean.TRUE;
                            zzioVar.zzaW().zze().zza("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.f14124d.booleanValue();
    }

    public final boolean zzE() {
        Boolean m3512d = m3512d("google_analytics_sgtm_upload_enabled");
        if (m3512d == null) {
            return false;
        }
        return m3512d.booleanValue();
    }

    @WorkerThread
    public final double zza(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) zzggVar.zza(null)).doubleValue();
        }
        String zza = this.f14123c.zza(str, zzggVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Double) zzggVar.zza(null)).doubleValue();
        }
        try {
            return ((Double) zzggVar.zza(Double.valueOf(Double.parseDouble(zza)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzggVar.zza(null)).doubleValue();
        }
    }

    public final int zze() {
        if (this.zzu.zzw().zzao(201500000, true)) {
            return 100;
        }
        return 25;
    }

    public final int zzf(@Size(min = 1) String str) {
        return zzi(str, zzgi.zzW, 25, 100);
    }

    @WorkerThread
    public final int zzh(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) zzggVar.zza(null)).intValue();
        }
        String zza = this.f14123c.zza(str, zzggVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Integer) zzggVar.zza(null)).intValue();
        }
        try {
            return ((Integer) zzggVar.zza(Integer.valueOf(Integer.parseInt(zza)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzggVar.zza(null)).intValue();
        }
    }

    @WorkerThread
    public final int zzi(String str, zzgg zzggVar, int i, int i2) {
        return Math.max(Math.min(zzh(str, zzggVar), i2), i);
    }

    public final long zzj() {
        this.zzu.zzaV();
        return 119002L;
    }

    @WorkerThread
    public final long zzk(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) zzggVar.zza(null)).longValue();
        }
        String zza = this.f14123c.zza(str, zzggVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Long) zzggVar.zza(null)).longValue();
        }
        try {
            return ((Long) zzggVar.zza(Long.valueOf(Long.parseLong(zza)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzggVar.zza(null)).longValue();
        }
    }

    public final zzju zzm(String str, boolean z) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        zzio zzioVar = this.zzu;
        Bundle m3511c = m3511c();
        if (m3511c == null) {
            AbstractC1726qj.m7039D(zzioVar, "Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = m3511c.get(str);
        }
        if (obj == null) {
            return zzju.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzju.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzju.DENIED;
        }
        if (z && "eu_consent_policy".equals(obj)) {
            return zzju.POLICY;
        }
        zzioVar.zzaW().zzk().zzb("Invalid manifest metadata for", str);
        return zzju.UNINITIALIZED;
    }

    public final String zzo() {
        return m3510b("debug.firebase.analytics.app");
    }

    public final String zzp() {
        return m3510b("debug.deferred.deeplink");
    }

    @WorkerThread
    public final String zzr(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return (String) zzggVar.zza(null);
        }
        return (String) zzggVar.zza(this.f14123c.zza(str, zzggVar.zzb()));
    }

    public final String zzs() {
        return this.f14122b;
    }

    public final void zzv(String str) {
        this.f14122b = str;
    }

    public final boolean zzw() {
        Boolean m3512d = m3512d("google_analytics_adid_collection_enabled");
        if (m3512d != null && !m3512d.booleanValue()) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzx(String str, zzgg zzggVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) zzggVar.zza(null)).booleanValue();
        }
        String zza = this.f14123c.zza(str, zzggVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Boolean) zzggVar.zza(null)).booleanValue();
        }
        return ((Boolean) zzggVar.zza(Boolean.valueOf(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(zza)))).booleanValue();
    }

    public final boolean zzy(String str) {
        return IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(this.f14123c.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzz() {
        Boolean m3512d = m3512d("google_analytics_automatic_screen_reporting_enabled");
        if (m3512d != null && !m3512d.booleanValue()) {
            return false;
        }
        return true;
    }
}
