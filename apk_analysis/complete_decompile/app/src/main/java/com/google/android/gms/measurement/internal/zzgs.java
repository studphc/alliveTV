package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzrp;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import p000.AbstractC1726qj;
import p000.mb3;
import p000.ub3;

/* loaded from: classes.dex */
public final class zzgs extends mb3 {

    /* renamed from: b */
    public String f14159b;

    /* renamed from: c */
    public String f14160c;

    /* renamed from: d */
    public int f14161d;

    /* renamed from: e */
    public String f14162e;

    /* renamed from: f */
    public String f14163f;

    /* renamed from: g */
    public long f14164g;

    /* renamed from: h */
    public final long f14165h;

    /* renamed from: i */
    public final long f14166i;

    /* renamed from: j */
    public List f14167j;

    /* renamed from: k */
    public String f14168k;

    /* renamed from: l */
    public int f14169l;

    /* renamed from: m */
    public String f14170m;

    /* renamed from: n */
    public String f14171n;

    /* renamed from: o */
    public String f14172o;

    /* renamed from: p */
    public long f14173p;

    /* renamed from: q */
    public String f14174q;

    public zzgs(zzio zzioVar, long j, long j2) {
        super(zzioVar);
        this.f14173p = 0L;
        this.f14174q = null;
        this.f14165h = j;
        this.f14166i = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x024a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0176  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzr m3525a(String str) {
        String str2;
        Class<?> loadClass;
        long zza;
        zzio zzioVar;
        boolean z;
        boolean z2;
        long j;
        long j2;
        String str3;
        zzio zzioVar2;
        int i;
        int i2;
        long j3;
        ApplicationInfo applicationInfo;
        zzio zzioVar3;
        zzam zzf;
        zzgg zzggVar;
        int i3;
        long j4;
        int i4;
        int i5;
        int extensionVersion;
        zzg();
        String m3527c = m3527c();
        String zzo = zzo();
        zza();
        String str4 = this.f14160c;
        zza();
        long j5 = this.f14161d;
        zza();
        Preconditions.checkNotNull(this.f14162e);
        String str5 = this.f14162e;
        zzio zzioVar4 = this.zzu;
        zzioVar4.zzf().zzj();
        zza();
        zzg();
        long j6 = this.f14164g;
        if (j6 == 0) {
            zzqf zzw = this.zzu.zzw();
            Context zzaT = zzioVar4.zzaT();
            String packageName = zzioVar4.zzaT().getPackageName();
            zzw.zzg();
            Preconditions.checkNotNull(zzaT);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = zzaT.getPackageManager();
            MessageDigest m3707f = zzqf.m3707f();
            long j7 = -1;
            if (m3707f == null) {
                AbstractC1726qj.m7039D(zzw.zzu, "Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (!zzw.m3713D(zzaT, packageName)) {
                            PackageManagerWrapper packageManager2 = Wrappers.packageManager(zzaT);
                            zzio zzioVar5 = zzw.zzu;
                            Signature[] signatureArr = packageManager2.getPackageInfo(zzioVar5.zzaT().getPackageName(), 64).signatures;
                            if (signatureArr != null && signatureArr.length > 0) {
                                j7 = zzqf.m3706R(m3707f.digest(signatureArr[0].toByteArray()));
                            } else {
                                zzioVar5.zzaW().zzk().zza("Could not get signatures");
                            }
                        } else {
                            j7 = 0;
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        zzw.zzu.zzaW().zze().zzb("Package name not found", e);
                    }
                }
                j6 = 0;
                this.f14164g = j6;
            }
            j6 = j7;
            this.f14164g = j6;
        }
        long j8 = j6;
        zzio zzioVar6 = this.zzu;
        boolean zzJ = zzioVar6.zzJ();
        boolean z3 = !zzioVar6.zzm().f27209r;
        zzg();
        if (zzioVar6.zzJ()) {
            zzrp.zzb();
            if (zzioVar6.zzf().zzx(null, zzgi.zzaG)) {
                this.zzu.zzaW().zzj().zza("Disabled IID for tests.");
            } else {
                try {
                    loadClass = zzioVar6.zzaT().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                } catch (ClassNotFoundException unused) {
                }
                if (loadClass != null) {
                    try {
                        Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzu.zzaT());
                        if (invoke == null) {
                            str2 = null;
                        } else {
                            try {
                                str2 = (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(invoke, null);
                            } catch (Exception unused2) {
                                this.zzu.zzaW().zzl().zza("Failed to retrieve Firebase Instance Id");
                                str2 = null;
                                zzio zzioVar7 = this.zzu;
                                zza = zzioVar7.zzm().f27197f.zza();
                                long j9 = zzioVar7.f14253G;
                                if (zza != 0) {
                                }
                                long j10 = j9;
                                zza();
                                int i6 = this.f14169l;
                                zzioVar = this.zzu;
                                boolean zzw2 = zzioVar.zzf().zzw();
                                ub3 zzm = zzioVar.zzm();
                                zzm.zzg();
                                boolean z4 = zzm.m7692b().getBoolean("deferred_analytics_collection", false);
                                String m3526b = m3526b();
                                if (zzioVar.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true) != zzju.GRANTED) {
                                }
                                Boolean valueOf = Boolean.valueOf(z);
                                List list = this.f14167j;
                                String zzq = zzioVar.zzm().m7694d().zzq();
                                if (this.f14168k == null) {
                                }
                                String str6 = this.f14168k;
                                if (!zzioVar.zzm().m7694d().zzr(zzjw.ANALYTICS_STORAGE)) {
                                }
                                boolean zzE = zzioVar.zzf().zzE();
                                zzqf zzw3 = zzioVar.zzw();
                                String m3527c2 = m3527c();
                                zzioVar2 = zzw3.zzu;
                                if (zzioVar2.zzaT().getPackageManager() == null) {
                                }
                                zzioVar3 = this.zzu;
                                int zzb = zzioVar3.zzm().m7694d().zzb();
                                ub3 zzm2 = zzioVar3.zzm();
                                zzm2.zzg();
                                String zzj = zzba.zze(zzm2.m7692b().getString("dma_consent_settings", null)).zzj();
                                zzqr.zzb();
                                zzf = zzioVar3.zzf();
                                zzggVar = zzgi.zzaW;
                                if (!zzf.zzx(null, zzggVar)) {
                                }
                                zzqr.zzb();
                                if (!zzioVar3.zzf().zzx(null, zzggVar)) {
                                }
                                String zzs = zzioVar3.zzf().zzs();
                                String valueOf2 = String.valueOf(zzjx.m3561a(zzioVar3.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true)));
                                long j11 = this.zzu.f14253G;
                                if (!zzioVar3.zzf().zzx(null, zzgi.zzaR)) {
                                }
                                return new zzr(m3527c, zzo, str4, j5, str5, 119002L, j2, str, z2, z3, str2, j10, i6, zzw2, z4, m3526b, valueOf, this.f14165h, list, (String) null, zzq, str6, str3, zzE, j3, zzb, zzj, i3, j4, zzs, valueOf2, j11, i4);
                            }
                        }
                    } catch (Exception unused3) {
                        this.zzu.zzaW().zzm().zza("Failed to obtain Firebase Analytics instance");
                    }
                    zzio zzioVar72 = this.zzu;
                    zza = zzioVar72.zzm().f27197f.zza();
                    long j92 = zzioVar72.f14253G;
                    if (zza != 0) {
                        j92 = Math.min(j92, zza);
                    }
                    long j102 = j92;
                    zza();
                    int i62 = this.f14169l;
                    zzioVar = this.zzu;
                    boolean zzw22 = zzioVar.zzf().zzw();
                    ub3 zzm3 = zzioVar.zzm();
                    zzm3.zzg();
                    boolean z42 = zzm3.m7692b().getBoolean("deferred_analytics_collection", false);
                    String m3526b2 = m3526b();
                    if (zzioVar.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true) != zzju.GRANTED) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Boolean valueOf3 = Boolean.valueOf(z);
                    List list2 = this.f14167j;
                    String zzq2 = zzioVar.zzm().m7694d().zzq();
                    if (this.f14168k == null) {
                        this.f14168k = zzioVar.zzw().m3726e();
                    }
                    String str62 = this.f14168k;
                    if (!zzioVar.zzm().m7694d().zzr(zzjw.ANALYTICS_STORAGE)) {
                        j2 = j8;
                        z2 = zzJ;
                        j = 0;
                        str3 = null;
                    } else {
                        zzg();
                        z2 = zzJ;
                        j = 0;
                        if (this.f14173p == 0) {
                            j2 = j8;
                        } else {
                            j2 = j8;
                            long currentTimeMillis = zzioVar.zzaU().currentTimeMillis() - this.f14173p;
                            if (this.f14172o != null && currentTimeMillis > 86400000 && this.f14174q == null) {
                                m3528d();
                            }
                        }
                        if (this.f14172o == null) {
                            m3528d();
                        }
                        str3 = this.f14172o;
                    }
                    boolean zzE2 = zzioVar.zzf().zzE();
                    zzqf zzw32 = zzioVar.zzw();
                    String m3527c22 = m3527c();
                    zzioVar2 = zzw32.zzu;
                    if (zzioVar2.zzaT().getPackageManager() == null) {
                        j3 = j;
                        i = 0;
                    } else {
                        try {
                            i = 0;
                            try {
                                applicationInfo = Wrappers.packageManager(zzioVar2.zzaT()).getApplicationInfo(m3527c22, 0);
                            } catch (PackageManager.NameNotFoundException unused4) {
                                zzio zzioVar8 = zzw32.zzu;
                                zzioVar8.zzaV();
                                zzioVar8.zzaW().zzi().zzb("PackageManager failed to find running app: app_id", m3527c22);
                                i2 = i;
                                j3 = i2;
                                zzioVar3 = this.zzu;
                                int zzb2 = zzioVar3.zzm().m7694d().zzb();
                                ub3 zzm22 = zzioVar3.zzm();
                                zzm22.zzg();
                                String zzj2 = zzba.zze(zzm22.m7692b().getString("dma_consent_settings", null)).zzj();
                                zzqr.zzb();
                                zzf = zzioVar3.zzf();
                                zzggVar = zzgi.zzaW;
                                if (!zzf.zzx(null, zzggVar)) {
                                }
                                zzqr.zzb();
                                if (!zzioVar3.zzf().zzx(null, zzggVar)) {
                                }
                                String zzs2 = zzioVar3.zzf().zzs();
                                String valueOf22 = String.valueOf(zzjx.m3561a(zzioVar3.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true)));
                                long j112 = this.zzu.f14253G;
                                if (!zzioVar3.zzf().zzx(null, zzgi.zzaR)) {
                                }
                                return new zzr(m3527c, zzo, str4, j5, str5, 119002L, j2, str, z2, z3, str2, j102, i62, zzw22, z42, m3526b2, valueOf3, this.f14165h, list2, (String) null, zzq2, str62, str3, zzE2, j3, zzb2, zzj2, i3, j4, zzs2, valueOf22, j112, i4);
                            }
                        } catch (PackageManager.NameNotFoundException unused5) {
                            i = 0;
                        }
                        if (applicationInfo != null) {
                            i2 = applicationInfo.targetSdkVersion;
                            j3 = i2;
                        }
                        i2 = i;
                        j3 = i2;
                    }
                    zzioVar3 = this.zzu;
                    int zzb22 = zzioVar3.zzm().m7694d().zzb();
                    ub3 zzm222 = zzioVar3.zzm();
                    zzm222.zzg();
                    String zzj22 = zzba.zze(zzm222.m7692b().getString("dma_consent_settings", null)).zzj();
                    zzqr.zzb();
                    zzf = zzioVar3.zzf();
                    zzggVar = zzgi.zzaW;
                    if (!zzf.zzx(null, zzggVar)) {
                        zzioVar3.zzw().getClass();
                        if (Build.VERSION.SDK_INT >= 30) {
                            extensionVersion = SdkExtensions.getExtensionVersion(30);
                            if (extensionVersion > 3) {
                                i5 = SdkExtensions.getExtensionVersion(1000000);
                                i3 = i5;
                            }
                        }
                        i5 = i;
                        i3 = i5;
                    } else {
                        i3 = i;
                    }
                    zzqr.zzb();
                    if (!zzioVar3.zzf().zzx(null, zzggVar)) {
                        j4 = zzioVar3.zzw().m3719Q();
                    } else {
                        j4 = j;
                    }
                    String zzs22 = zzioVar3.zzf().zzs();
                    String valueOf222 = String.valueOf(zzjx.m3561a(zzioVar3.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true)));
                    long j1122 = this.zzu.f14253G;
                    if (!zzioVar3.zzf().zzx(null, zzgi.zzaR)) {
                        i4 = this.zzu.zzs().m3576a().zza();
                    } else {
                        i4 = i;
                    }
                    return new zzr(m3527c, zzo, str4, j5, str5, 119002L, j2, str, z2, z3, str2, j102, i62, zzw22, z42, m3526b2, valueOf3, this.f14165h, list2, (String) null, zzq2, str62, str3, zzE2, j3, zzb22, zzj22, i3, j4, zzs22, valueOf222, j1122, i4);
                }
            }
        }
        str2 = null;
        zzio zzioVar722 = this.zzu;
        zza = zzioVar722.zzm().f27197f.zza();
        long j922 = zzioVar722.f14253G;
        if (zza != 0) {
        }
        long j1022 = j922;
        zza();
        int i622 = this.f14169l;
        zzioVar = this.zzu;
        boolean zzw222 = zzioVar.zzf().zzw();
        ub3 zzm32 = zzioVar.zzm();
        zzm32.zzg();
        boolean z422 = zzm32.m7692b().getBoolean("deferred_analytics_collection", false);
        String m3526b22 = m3526b();
        if (zzioVar.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true) != zzju.GRANTED) {
        }
        Boolean valueOf32 = Boolean.valueOf(z);
        List list22 = this.f14167j;
        String zzq22 = zzioVar.zzm().m7694d().zzq();
        if (this.f14168k == null) {
        }
        String str622 = this.f14168k;
        if (!zzioVar.zzm().m7694d().zzr(zzjw.ANALYTICS_STORAGE)) {
        }
        boolean zzE22 = zzioVar.zzf().zzE();
        zzqf zzw322 = zzioVar.zzw();
        String m3527c222 = m3527c();
        zzioVar2 = zzw322.zzu;
        if (zzioVar2.zzaT().getPackageManager() == null) {
        }
        zzioVar3 = this.zzu;
        int zzb222 = zzioVar3.zzm().m7694d().zzb();
        ub3 zzm2222 = zzioVar3.zzm();
        zzm2222.zzg();
        String zzj222 = zzba.zze(zzm2222.m7692b().getString("dma_consent_settings", null)).zzj();
        zzqr.zzb();
        zzf = zzioVar3.zzf();
        zzggVar = zzgi.zzaW;
        if (!zzf.zzx(null, zzggVar)) {
        }
        zzqr.zzb();
        if (!zzioVar3.zzf().zzx(null, zzggVar)) {
        }
        String zzs222 = zzioVar3.zzf().zzs();
        String valueOf2222 = String.valueOf(zzjx.m3561a(zzioVar3.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true)));
        long j11222 = this.zzu.f14253G;
        if (!zzioVar3.zzf().zzx(null, zzgi.zzaR)) {
        }
        return new zzr(m3527c, zzo, str4, j5, str5, 119002L, j2, str, z2, z3, str2, j1022, i622, zzw222, z422, m3526b22, valueOf32, this.f14165h, list22, (String) null, zzq22, str622, str3, zzE22, j3, zzb222, zzj222, i3, j4, zzs222, valueOf2222, j11222, i4);
    }

    /* renamed from: b */
    public final String m3526b() {
        zza();
        if (this.zzu.zzf().zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.f14171n;
    }

    /* renamed from: c */
    public final String m3527c() {
        zza();
        Preconditions.checkNotNull(this.f14159b);
        return this.f14159b;
    }

    /* renamed from: d */
    public final void m3528d() {
        String format;
        String str;
        zzg();
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzm().m7694d().zzr(zzjw.ANALYTICS_STORAGE)) {
            zzioVar.zzaW().zzd().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            zzioVar.zzw().m3727g().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzhc zzd = zzioVar.zzaW().zzd();
        if (format == null) {
            str = "null";
        } else {
            str = "not null";
        }
        zzd.zza("Resetting session stitching token to ".concat(str));
        this.f14172o = format;
        this.f14173p = zzioVar.zzaU().currentTimeMillis();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:1|(1:3)(6:96|97|(1:99)(2:114|(1:116))|100|101|(24:103|(1:105)(1:112)|106|107|5|(2:7|(18:11|12|(1:(2:15|(2:17|(2:19|(2:21|(2:23|(1:25)(1:88))(1:89))(1:90))(1:91))(1:92))(1:93))(1:94)|26|(1:28)|29|30|(1:32)(1:84)|33|(3:37|(1:39)(1:41)|40)|(3:43|(1:45)(1:48)|46)|49|(1:51)(2:81|(5:83|(3:73|74|(1:76)(1:77))|(3:55|(1:57)(3:64|(3:67|(1:69)(1:70)|65)|71)|(2:59|60)(2:62|63))|72|(0)(0)))|52|(0)|(0)|72|(0)(0)))|95|12|(0)(0)|26|(0)|29|30|(0)(0)|33|(4:35|37|(0)(0)|40)|(0)|49|(0)(0)|52|(0)|(0)|72|(0)(0)))|4|5|(0)|95|12|(0)(0)|26|(0)|29|30|(0)(0)|33|(0)|(0)|49|(0)(0)|52|(0)|(0)|72|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01da, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01fb, code lost:
    
        r12.zzu.zzaW().zze().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r1), r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b1 A[Catch: IllegalStateException -> 0x01da, TryCatch #3 {IllegalStateException -> 0x01da, blocks: (B:30:0x018f, B:33:0x01a5, B:35:0x01b1, B:37:0x01b7, B:40:0x01d1, B:41:0x01cd, B:43:0x01de, B:45:0x01f2, B:46:0x01f7, B:48:0x01f5), top: B:29:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01cd A[Catch: IllegalStateException -> 0x01da, TryCatch #3 {IllegalStateException -> 0x01da, blocks: (B:30:0x018f, B:33:0x01a5, B:35:0x01b1, B:37:0x01b7, B:40:0x01d1, B:41:0x01cd, B:43:0x01de, B:45:0x01f2, B:46:0x01f7, B:48:0x01f5), top: B:29:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01de A[Catch: IllegalStateException -> 0x01da, TryCatch #3 {IllegalStateException -> 0x01da, blocks: (B:30:0x018f, B:33:0x01a5, B:35:0x01b1, B:37:0x01b7, B:40:0x01d1, B:41:0x01cd, B:43:0x01de, B:45:0x01f2, B:46:0x01f7, B:48:0x01f5), top: B:29:0x018f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0241 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0173  */
    @Override // p000.mb3
    @EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd() {
        String str;
        String str2;
        PackageInfo packageInfo;
        zzio zzioVar;
        zzam zzf;
        zzgg zzggVar;
        List list;
        Object[] objArr;
        zzio zzioVar2;
        int zza;
        Bundle m3511c;
        Integer valueOf;
        String zzc;
        String str3;
        String zzA;
        zzio zzioVar3 = this.zzu;
        zzioVar3.zzaW().zzj().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.f14166i), Long.valueOf(this.f14165h));
        String packageName = zzioVar3.zzaT().getPackageName();
        PackageManager packageManager = zzioVar3.zzaT().getPackageManager();
        int i = Integer.MIN_VALUE;
        String str4 = "";
        String str5 = "Unknown";
        String str6 = EnvironmentCompat.MEDIA_UNKNOWN;
        if (packageManager == null) {
            zzioVar3.zzaW().zze().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzhe.zzn(packageName));
        } else {
            try {
                str6 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.zzu.zzaW().zze().zzb("Error retrieving app installer package name. appId", zzhe.zzn(packageName));
            }
            if (str6 == null) {
                str6 = "manual_install";
            } else if ("com.android.vending".equals(str6)) {
                str6 = "";
            }
            try {
                packageInfo = packageManager.getPackageInfo(this.zzu.zzaT().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused2) {
                str = "Unknown";
            }
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (TextUtils.isEmpty(applicationLabel)) {
                    str2 = "Unknown";
                } else {
                    str2 = applicationLabel.toString();
                }
                try {
                    str5 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = str5;
                    str5 = str2;
                    this.zzu.zzaW().zze().zzc("Error retrieving package info. appId, appName", zzhe.zzn(packageName), str5);
                    str2 = str5;
                    str5 = str;
                    this.f14159b = packageName;
                    this.f14162e = str6;
                    this.f14160c = str5;
                    this.f14161d = i;
                    this.f14163f = str2;
                    this.f14164g = 0L;
                    zzioVar = this.zzu;
                    zzf = zzioVar.zzf();
                    zzggVar = zzgi.zzbp;
                    list = null;
                    if (!zzf.zzx(null, zzggVar)) {
                    }
                    objArr = false;
                    zzioVar2 = this.zzu;
                    zza = zzioVar2.zza();
                    if (zza == 0) {
                    }
                    this.f14170m = "";
                    this.f14171n = "";
                    zzioVar.zzaV();
                    if (objArr != false) {
                    }
                    zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                    if (TextUtils.isEmpty(zzc)) {
                    }
                    this.f14170m = str4;
                    if (!zzioVar.zzf().zzx(null, zzggVar)) {
                    }
                    if (zza == 0) {
                    }
                    this.f14167j = null;
                    zzio zzioVar4 = this.zzu;
                    zzioVar4.zzaV();
                    zzam zzf2 = zzioVar4.zzf();
                    zzf2.getClass();
                    Preconditions.checkNotEmpty("analytics.safelisted_events");
                    m3511c = zzf2.m3511c();
                    if (m3511c != null) {
                    }
                    valueOf = null;
                    if (valueOf != null) {
                    }
                    if (list != null) {
                    }
                    this.f14167j = list;
                    if (packageManager == null) {
                    }
                }
                this.f14159b = packageName;
                this.f14162e = str6;
                this.f14160c = str5;
                this.f14161d = i;
                this.f14163f = str2;
                this.f14164g = 0L;
                zzioVar = this.zzu;
                zzf = zzioVar.zzf();
                zzggVar = zzgi.zzbp;
                list = null;
                if (!zzf.zzx(null, zzggVar)) {
                    zzio zzioVar5 = this.zzu;
                    if (!TextUtils.isEmpty(zzioVar5.zzx()) && "am".equals(zzioVar5.zzy())) {
                        objArr = true;
                        zzioVar2 = this.zzu;
                        zza = zzioVar2.zza();
                        if (zza == 0) {
                            if (zza != 1) {
                                if (zza != 3) {
                                    if (zza != 4) {
                                        if (zza != 6) {
                                            if (zza != 7) {
                                                if (zza != 8) {
                                                    zzioVar.zzaW().zzi().zza("App measurement disabled");
                                                    zzioVar.zzaW().zzh().zza("Invalid scion state in identity");
                                                } else {
                                                    zzioVar.zzaW().zzi().zza("App measurement disabled due to denied storage consent");
                                                }
                                            } else {
                                                zzioVar.zzaW().zzi().zza("App measurement disabled via the global data collection setting");
                                            }
                                        } else {
                                            zzioVar.zzaW().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                                        }
                                    } else {
                                        zzioVar.zzaW().zzi().zza("App measurement disabled via the manifest");
                                    }
                                } else {
                                    zzioVar.zzaW().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                                }
                            } else {
                                zzioVar.zzaW().zzi().zza("App measurement deactivated via the manifest");
                            }
                        } else {
                            zzioVar.zzaW().zzj().zza("App measurement collection enabled");
                        }
                        this.f14170m = "";
                        this.f14171n = "";
                        zzioVar.zzaV();
                        if (objArr != false) {
                            this.f14171n = zzioVar2.zzx();
                        }
                        zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                        if (TextUtils.isEmpty(zzc)) {
                            str4 = zzc;
                        }
                        this.f14170m = str4;
                        if (!zzioVar.zzf().zzx(null, zzggVar) && !TextUtils.isEmpty(zzc)) {
                            Context zzaT = zzioVar.zzaT();
                            zzA = zzioVar2.zzA();
                            Preconditions.checkNotNull(zzaT);
                            Resources resources = zzaT.getResources();
                            if (!TextUtils.isEmpty(zzA)) {
                                zzA = zzig.zza(zzaT);
                            }
                            this.f14171n = zzig.zzb("admob_app_id", resources, zzA);
                        }
                        if (zza == 0) {
                            zzhc zzj = zzioVar.zzaW().zzj();
                            String str7 = this.f14159b;
                            if (TextUtils.isEmpty(this.f14170m)) {
                                str3 = this.f14171n;
                            } else {
                                str3 = this.f14170m;
                            }
                            zzj.zzc("App measurement enabled for app package, google app id", str7, str3);
                        }
                        this.f14167j = null;
                        zzio zzioVar42 = this.zzu;
                        zzioVar42.zzaV();
                        zzam zzf22 = zzioVar42.zzf();
                        zzf22.getClass();
                        Preconditions.checkNotEmpty("analytics.safelisted_events");
                        m3511c = zzf22.m3511c();
                        if (m3511c != null) {
                            AbstractC1726qj.m7039D(zzf22.zzu, "Failed to load metadata: Metadata bundle is null");
                        } else if (m3511c.containsKey("analytics.safelisted_events")) {
                            valueOf = Integer.valueOf(m3511c.getInt("analytics.safelisted_events"));
                            if (valueOf != null) {
                                try {
                                    String[] stringArray = zzf22.zzu.zzaT().getResources().getStringArray(valueOf.intValue());
                                    if (stringArray != null) {
                                        list = Arrays.asList(stringArray);
                                    }
                                } catch (Resources.NotFoundException e) {
                                    zzf22.zzu.zzaW().zze().zzb("Failed to load string array from metadata: resource not found", e);
                                }
                            }
                            if (list != null) {
                                if (list.isEmpty()) {
                                    zzioVar42.zzaW().zzl().zza("Safelisted event list is empty. Ignoring");
                                } else {
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        if (!zzioVar42.zzw().m3742y("safelisted event", (String) it.next())) {
                                            break;
                                        }
                                    }
                                }
                                if (packageManager == null) {
                                    this.f14169l = InstantApps.isInstantApp(zzioVar42.zzaT()) ? 1 : 0;
                                    return;
                                } else {
                                    this.f14169l = 0;
                                    return;
                                }
                            }
                            this.f14167j = list;
                            if (packageManager == null) {
                            }
                        }
                        valueOf = null;
                        if (valueOf != null) {
                        }
                        if (list != null) {
                        }
                        this.f14167j = list;
                        if (packageManager == null) {
                        }
                    }
                }
                objArr = false;
                zzioVar2 = this.zzu;
                zza = zzioVar2.zza();
                if (zza == 0) {
                }
                this.f14170m = "";
                this.f14171n = "";
                zzioVar.zzaV();
                if (objArr != false) {
                }
                zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                if (TextUtils.isEmpty(zzc)) {
                }
                this.f14170m = str4;
                if (!zzioVar.zzf().zzx(null, zzggVar)) {
                    Context zzaT2 = zzioVar.zzaT();
                    zzA = zzioVar2.zzA();
                    Preconditions.checkNotNull(zzaT2);
                    Resources resources2 = zzaT2.getResources();
                    if (!TextUtils.isEmpty(zzA)) {
                    }
                    this.f14171n = zzig.zzb("admob_app_id", resources2, zzA);
                }
                if (zza == 0) {
                }
                this.f14167j = null;
                zzio zzioVar422 = this.zzu;
                zzioVar422.zzaV();
                zzam zzf222 = zzioVar422.zzf();
                zzf222.getClass();
                Preconditions.checkNotEmpty("analytics.safelisted_events");
                m3511c = zzf222.m3511c();
                if (m3511c != null) {
                }
                valueOf = null;
                if (valueOf != null) {
                }
                if (list != null) {
                }
                this.f14167j = list;
                if (packageManager == null) {
                }
            }
        }
        str2 = "Unknown";
        this.f14159b = packageName;
        this.f14162e = str6;
        this.f14160c = str5;
        this.f14161d = i;
        this.f14163f = str2;
        this.f14164g = 0L;
        zzioVar = this.zzu;
        zzf = zzioVar.zzf();
        zzggVar = zzgi.zzbp;
        list = null;
        if (!zzf.zzx(null, zzggVar)) {
        }
        objArr = false;
        zzioVar2 = this.zzu;
        zza = zzioVar2.zza();
        if (zza == 0) {
        }
        this.f14170m = "";
        this.f14171n = "";
        zzioVar.zzaV();
        if (objArr != false) {
        }
        zzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
        if (TextUtils.isEmpty(zzc)) {
        }
        this.f14170m = str4;
        if (!zzioVar.zzf().zzx(null, zzggVar)) {
        }
        if (zza == 0) {
        }
        this.f14167j = null;
        zzio zzioVar4222 = this.zzu;
        zzioVar4222.zzaV();
        zzam zzf2222 = zzioVar4222.zzf();
        zzf2222.getClass();
        Preconditions.checkNotEmpty("analytics.safelisted_events");
        m3511c = zzf2222.m3511c();
        if (m3511c != null) {
        }
        valueOf = null;
        if (valueOf != null) {
        }
        if (list != null) {
        }
        this.f14167j = list;
        if (packageManager == null) {
        }
    }

    @Override // p000.mb3
    public final boolean zzf() {
        return true;
    }

    public final String zzo() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.f14170m);
        return this.f14170m;
    }
}
