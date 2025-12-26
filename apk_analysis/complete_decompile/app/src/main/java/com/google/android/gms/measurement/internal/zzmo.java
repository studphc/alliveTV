package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.id3;
import p000.mb3;
import p000.pq0;
import p000.sn1;

/* loaded from: classes.dex */
public final class zzmo extends mb3 {

    /* renamed from: b */
    public volatile zzmh f14325b;

    /* renamed from: c */
    public volatile zzmh f14326c;

    /* renamed from: d */
    public final ConcurrentHashMap f14327d;

    /* renamed from: e */
    public com.google.android.gms.internal.measurement.zzdj f14328e;

    /* renamed from: f */
    public volatile boolean f14329f;

    /* renamed from: g */
    public volatile zzmh f14330g;

    /* renamed from: h */
    public zzmh f14331h;

    /* renamed from: i */
    public boolean f14332i;

    /* renamed from: j */
    public final Object f14333j;

    @VisibleForTesting
    protected zzmh zza;

    public zzmo(zzio zzioVar) {
        super(zzioVar);
        this.f14333j = new Object();
        this.f14327d = new ConcurrentHashMap();
    }

    /* renamed from: a */
    public final void m3577a(String str, zzmh zzmhVar, boolean z) {
        zzmh zzmhVar2;
        zzmh zzmhVar3;
        String str2;
        if (this.f14325b == null) {
            zzmhVar2 = this.f14326c;
        } else {
            zzmhVar2 = this.f14325b;
        }
        zzmh zzmhVar4 = zzmhVar2;
        if (zzmhVar.zzb == null) {
            if (str != null) {
                str2 = m3580d(str);
            } else {
                str2 = null;
            }
            zzmhVar3 = new zzmh(zzmhVar.zza, str2, zzmhVar.zzc, zzmhVar.zze, zzmhVar.zzf);
        } else {
            zzmhVar3 = zzmhVar;
        }
        this.f14326c = this.f14325b;
        this.f14325b = zzmhVar3;
        zzio zzioVar = this.zzu;
        zzioVar.zzaX().zzq(new id3(this, zzmhVar3, zzmhVar4, zzioVar.zzaU().elapsedRealtime(), z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b0, code lost:
    
        if (r13 == 0) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cf  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3578b(zzmh zzmhVar, zzmh zzmhVar2, long j, boolean z, Bundle bundle) {
        boolean z2;
        Bundle bundle2;
        String str;
        long j2;
        long j3;
        zzg();
        boolean z3 = false;
        if (zzmhVar2 != null) {
            if (zzmhVar2.zzc == zzmhVar.zzc && Objects.equals(zzmhVar2.zzb, zzmhVar.zzb) && Objects.equals(zzmhVar2.zza, zzmhVar.zza)) {
                z2 = false;
                if (z && this.zza != null) {
                    z3 = true;
                }
                if (z2) {
                    if (bundle != null) {
                        bundle2 = new Bundle(bundle);
                    } else {
                        bundle2 = new Bundle();
                    }
                    Bundle bundle3 = bundle2;
                    zzqf.zzN(zzmhVar, bundle3, true);
                    if (zzmhVar2 != null) {
                        String str2 = zzmhVar2.zza;
                        if (str2 != null) {
                            bundle3.putString("_pn", str2);
                        }
                        String str3 = zzmhVar2.zzb;
                        if (str3 != null) {
                            bundle3.putString("_pc", str3);
                        }
                        bundle3.putLong("_pi", zzmhVar2.zzc);
                    }
                    if (z3) {
                        C0814n0 c0814n0 = this.zzu.zzv().zzb;
                        long j4 = j - c0814n0.f14065b;
                        c0814n0.f14065b = j;
                        if (j4 > 0) {
                            this.zzu.zzw().m3728h(bundle3, j4);
                        }
                    }
                    zzio zzioVar = this.zzu;
                    if (!zzioVar.zzf().zzz()) {
                        bundle3.putLong("_mst", 1L);
                    }
                    boolean z4 = zzmhVar.zze;
                    if (true != z4) {
                        str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
                    } else {
                        str = "app";
                    }
                    long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
                    if (z4) {
                        j2 = currentTimeMillis;
                        j3 = zzmhVar.zzf;
                    } else {
                        j2 = currentTimeMillis;
                    }
                    j3 = j2;
                    this.zzu.zzq().m3568d(str, "_vs", bundle3, j3);
                }
                if (z3) {
                    m3579c(this.zza, true, j);
                }
                this.zza = zzmhVar;
                if (zzmhVar.zze) {
                    this.f14331h = zzmhVar;
                }
                this.zzu.zzu().zzS(zzmhVar);
            }
        }
        z2 = true;
        if (z) {
            z3 = true;
        }
        if (z2) {
        }
        if (z3) {
        }
        this.zza = zzmhVar;
        if (zzmhVar.zze) {
        }
        this.zzu.zzu().zzS(zzmhVar);
    }

    /* renamed from: c */
    public final void m3579c(zzmh zzmhVar, boolean z, long j) {
        boolean z2;
        zzio zzioVar = this.zzu;
        zzioVar.zzd().zzf(zzioVar.zzaU().elapsedRealtime());
        if (zzmhVar != null && zzmhVar.f14324a) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (zzioVar.zzv().zzb.m3497a(j, z2, z) && zzmhVar != null) {
            zzmhVar.f14324a = false;
        }
    }

    /* renamed from: d */
    public final String m3580d(String str) {
        String str2;
        if (str == null) {
            return "Activity";
        }
        String[] split = str.split("\\.");
        int length = split.length;
        if (length > 0) {
            str2 = split[length - 1];
        } else {
            str2 = "";
        }
        zzio zzioVar = this.zzu;
        int length2 = str2.length();
        zzioVar.zzf().getClass();
        if (length2 > 500) {
            zzioVar.zzf().getClass();
            return str2.substring(0, HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR);
        }
        return str2;
    }

    /* renamed from: e */
    public final zzmh m3581e(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        Preconditions.checkNotNull(zzdjVar);
        Integer valueOf = Integer.valueOf(zzdjVar.zza);
        ConcurrentHashMap concurrentHashMap = this.f14327d;
        zzmh zzmhVar = (zzmh) concurrentHashMap.get(valueOf);
        if (zzmhVar == null) {
            zzmh zzmhVar2 = new zzmh(null, m3580d(zzdjVar.zzb), this.zzu.zzw().zzs());
            concurrentHashMap.put(valueOf, zzmhVar2);
            zzmhVar = zzmhVar2;
        }
        if (this.f14330g != null) {
            return this.f14330g;
        }
        return zzmhVar;
    }

    @Override // p000.mb3
    public final boolean zzf() {
        return false;
    }

    public final zzmh zzi() {
        return this.f14325b;
    }

    @WorkerThread
    public final zzmh zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zzmh zzmhVar = this.zza;
        if (zzmhVar != null) {
            return zzmhVar;
        }
        return this.f14331h;
    }

    @MainThread
    public final void zzs(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        Bundle bundle2;
        if (this.zzu.zzf().zzz() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.f14327d.put(Integer.valueOf(zzdjVar.zza), new zzmh(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    @MainThread
    public final void zzt(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        synchronized (this.f14333j) {
            try {
                if (Objects.equals(this.f14328e, zzdjVar)) {
                    this.f14328e = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!this.zzu.zzf().zzz()) {
            return;
        }
        this.f14327d.remove(Integer.valueOf(zzdjVar.zza));
    }

    @MainThread
    public final void zzu(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        synchronized (this.f14333j) {
            this.f14332i = false;
            this.f14329f = true;
        }
        zzio zzioVar = this.zzu;
        long elapsedRealtime = zzioVar.zzaU().elapsedRealtime();
        if (!zzioVar.zzf().zzz()) {
            this.f14325b = null;
            zzioVar.zzaX().zzq(new RunnableC0821r(this, elapsedRealtime, 2));
        } else {
            zzmh m3581e = m3581e(zzdjVar);
            this.f14326c = this.f14325b;
            this.f14325b = null;
            zzioVar.zzaX().zzq(new RunnableC0787a(this, m3581e, elapsedRealtime, 2));
        }
    }

    @MainThread
    public final void zzv(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        Object obj = this.f14333j;
        synchronized (obj) {
            this.f14332i = true;
            if (!Objects.equals(zzdjVar, this.f14328e)) {
                synchronized (obj) {
                    this.f14328e = zzdjVar;
                    this.f14329f = false;
                    zzio zzioVar = this.zzu;
                    if (zzioVar.zzf().zzz()) {
                        this.f14330g = null;
                        zzioVar.zzaX().zzq(new sn1(24, this));
                    }
                }
            }
        }
        zzio zzioVar2 = this.zzu;
        if (!zzioVar2.zzf().zzz()) {
            this.f14325b = this.f14330g;
            zzioVar2.zzaX().zzq(new RunnableC0788a0(0, this));
            return;
        }
        m3577a(zzdjVar.zzb, m3581e(zzdjVar), false);
        zzd zzd = this.zzu.zzd();
        zzio zzioVar3 = zzd.zzu;
        zzioVar3.zzaX().zzq(new pq0(zzd, zzioVar3.zzaU().elapsedRealtime(), 3));
    }

    @MainThread
    public final void zzw(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        zzmh zzmhVar;
        if (this.zzu.zzf().zzz() && bundle != null && (zzmhVar = (zzmh) this.f14327d.get(Integer.valueOf(zzdjVar.zza))) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzmhVar.zzc);
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzmhVar.zza);
            bundle2.putString("referrer_name", zzmhVar.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0084, code lost:
    
        if (r4 <= 500) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b0, code lost:
    
        if (r4 <= 500) goto L39;
     */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzx(@NonNull com.google.android.gms.internal.measurement.zzdj zzdjVar, @Size(max = 36, min = 1) String str, @Size(max = 36, min = 1) String str2) {
        String str3;
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzf().zzz()) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzmh zzmhVar = this.f14325b;
        if (zzmhVar == null) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        ConcurrentHashMap concurrentHashMap = this.f14327d;
        Integer valueOf = Integer.valueOf(zzdjVar.zza);
        if (concurrentHashMap.get(valueOf) == null) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = m3580d(zzdjVar.zzb);
        }
        String str4 = zzmhVar.zzb;
        String str5 = zzmhVar.zza;
        boolean equals = Objects.equals(str4, str2);
        boolean equals2 = Objects.equals(str5, str);
        if (equals && equals2) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null) {
            if (str.length() > 0) {
                int length = str.length();
                zzioVar.zzf().getClass();
            }
            zzioVar.zzaW().zzl().zzb("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null) {
            if (str2.length() > 0) {
                int length2 = str2.length();
                zzioVar.zzf().getClass();
            }
            zzioVar.zzaW().zzl().zzb("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzhc zzj = zzioVar.zzaW().zzj();
        if (str == null) {
            str3 = "null";
        } else {
            str3 = str;
        }
        zzj.zzc("Setting current screen to name, class", str3, str2);
        zzmh zzmhVar2 = new zzmh(str, str2, zzioVar.zzw().zzs());
        concurrentHashMap.put(valueOf, zzmhVar2);
        m3577a(zzdjVar.zzb, zzmhVar2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r2 > 500) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r4 > 500) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzy(Bundle bundle, long j) {
        String str;
        String str2;
        String str3;
        zzmh zzmhVar;
        String str4;
        synchronized (this.f14333j) {
            try {
                if (!this.f14332i) {
                    this.zzu.zzaW().zzl().zza("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
                if (string != null) {
                    if (string.length() > 0) {
                        int length = string.length();
                        this.zzu.zzf().getClass();
                    }
                    this.zzu.zzaW().zzl().zzb("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 != null) {
                    if (string2.length() > 0) {
                        int length2 = string2.length();
                        this.zzu.zzf().getClass();
                    }
                    this.zzu.zzaW().zzl().zzb("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                }
                if (string2 == null) {
                    com.google.android.gms.internal.measurement.zzdj zzdjVar = this.f14328e;
                    if (zzdjVar != null) {
                        str4 = m3580d(zzdjVar.zzb);
                    } else {
                        str4 = "Activity";
                    }
                    str = str4;
                } else {
                    str = string2;
                }
                zzmh zzmhVar2 = this.f14325b;
                if (this.f14329f && zzmhVar2 != null) {
                    this.f14329f = false;
                    boolean equals = Objects.equals(zzmhVar2.zzb, str);
                    boolean equals2 = Objects.equals(zzmhVar2.zza, string);
                    if (equals && equals2) {
                        this.zzu.zzaW().zzl().zza("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                zzio zzioVar = this.zzu;
                zzhc zzj = zzioVar.zzaW().zzj();
                if (string == null) {
                    str2 = "null";
                } else {
                    str2 = string;
                }
                if (str == null) {
                    str3 = "null";
                } else {
                    str3 = str;
                }
                zzj.zzc("Logging screen view with name, class", str2, str3);
                if (this.f14325b == null) {
                    zzmhVar = this.f14326c;
                } else {
                    zzmhVar = this.f14325b;
                }
                zzmh zzmhVar3 = new zzmh(string, str, zzioVar.zzw().zzs(), true, j);
                this.f14325b = zzmhVar3;
                this.f14326c = zzmhVar;
                this.f14330g = zzmhVar3;
                zzioVar.zzaX().zzq(new RunnableC0830z(this, bundle, zzmhVar3, zzmhVar, zzioVar.zzaU().elapsedRealtime()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
