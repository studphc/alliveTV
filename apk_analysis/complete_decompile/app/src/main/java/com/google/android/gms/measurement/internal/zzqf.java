package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import p000.AbstractC1726qj;
import p000.ai2;
import p000.fc3;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzqf extends fc3 {

    /* renamed from: h */
    public static final String[] f14404h = {"firebase_", "google_", "ga_"};

    /* renamed from: i */
    public static final String[] f14405i = {"_err"};
    public static final /* synthetic */ int zza = 0;

    /* renamed from: b */
    public SecureRandom f14406b;

    /* renamed from: c */
    public final AtomicLong f14407c;

    /* renamed from: d */
    public int f14408d;

    /* renamed from: e */
    public MeasurementManagerFutures f14409e;

    /* renamed from: f */
    public Boolean f14410f;

    /* renamed from: g */
    public Integer f14411g;

    public zzqf(zzio zzioVar) {
        super(zzioVar);
        this.f14411g = null;
        this.f14407c = new AtomicLong(0L);
    }

    /* renamed from: C */
    public static boolean m3698C(Object obj) {
        if (!(obj instanceof Parcelable[]) && !(obj instanceof ArrayList) && !(obj instanceof Bundle)) {
            return false;
        }
        return true;
    }

    /* renamed from: E */
    public static boolean m3699E(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("_")) {
            return true;
        }
        return false;
    }

    /* renamed from: F */
    public static boolean m3700F(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) == '_' && !str.equals("_ep")) {
            return false;
        }
        return true;
    }

    /* renamed from: G */
    public static boolean m3701G(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* renamed from: H */
    public static boolean m3702H(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* renamed from: I */
    public static boolean m3703I(Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return m3702H(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return m3702H(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* renamed from: L */
    public static byte[] m3704L(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    /* renamed from: M */
    public static final boolean m3705M(int i, Bundle bundle) {
        if (bundle != null && bundle.getLong("_err") == 0) {
            bundle.putLong("_err", i);
            return true;
        }
        return false;
    }

    /* renamed from: R */
    public static long m3706R(byte[] bArr) {
        boolean z;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (bArr[i2] & 255) << i;
            i += 8;
        }
        return j;
    }

    /* renamed from: f */
    public static MessageDigest m3707f() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    /* renamed from: m */
    public static void m3708m(ai2 ai2Var, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        m3705M(i, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        ai2Var.m98h(str, "_err", bundle);
    }

    /* renamed from: r */
    public static boolean m3709r(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: t */
    public static boolean m3710t(String str) {
        String str2 = (String) zzgi.zzaq.zza(null);
        if (!str2.equals("*") && !Arrays.asList(str2.split(",")).contains(str)) {
            return false;
        }
        return true;
    }

    public static ArrayList zzK(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzai zzaiVar = (zzai) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzaiVar.zza);
            bundle.putString("origin", zzaiVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzaiVar.zzd);
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaiVar.zzc.zzb);
            zzjt.zzb(bundle, Preconditions.checkNotNull(zzaiVar.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzaiVar.zze);
            String str = zzaiVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzbh zzbhVar = zzaiVar.zzg;
            if (zzbhVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzbhVar.zza);
                zzbf zzbfVar = zzbhVar.zzb;
                if (zzbfVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzbfVar.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzaiVar.zzh);
            zzbh zzbhVar2 = zzaiVar.zzi;
            if (zzbhVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzbhVar2.zza);
                zzbf zzbfVar2 = zzbhVar2.zzb;
                if (zzbfVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzbfVar2.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzaiVar.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzaiVar.zzj);
            zzbh zzbhVar3 = zzaiVar.zzk;
            if (zzbhVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzbhVar3.zza);
                zzbf zzbfVar3 = zzbhVar3.zzb;
                if (zzbfVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzbfVar3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    @WorkerThread
    public static void zzN(zzmh zzmhVar, Bundle bundle, boolean z) {
        if (bundle != null && zzmhVar != null) {
            if (bundle.containsKey("_sc") && !z) {
                z = false;
            } else {
                String str = zzmhVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzmhVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzmhVar.zzc);
                return;
            }
        }
        if (bundle != null && zzmhVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static boolean zzau(String str) {
        if (f14405i[0].equals(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: A */
    public final boolean m3711A(String str) {
        zzg();
        zzio zzioVar = this.zzu;
        if (Wrappers.packageManager(zzioVar.zzaT()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzioVar.zzaW().zzd().zzb("Permission not granted", str);
        return false;
    }

    /* renamed from: B */
    public final boolean m3712B(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        zzio zzioVar = this.zzu;
        String zzo = zzioVar.zzf().zzo();
        zzioVar.zzaV();
        return zzo.equals(str);
    }

    /* renamed from: D */
    public final boolean m3713D(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzu.zzaW().zze().zzb("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            this.zzu.zzaW().zze().zzb("Error obtaining certificate", e2);
            return true;
        }
    }

    /* renamed from: J */
    public final boolean m3714J(String str, String str2, String str3, String str4) {
        if (this.zzu.zzf().zzx(null, zzgi.zzbp)) {
            boolean isEmpty = TextUtils.isEmpty(str);
            boolean isEmpty2 = TextUtils.isEmpty(str2);
            if (!isEmpty && !isEmpty2) {
                Preconditions.checkNotNull(str);
                if (!str.equals(str2)) {
                    return true;
                }
            }
            return false;
        }
        boolean isEmpty3 = TextUtils.isEmpty(str);
        boolean isEmpty4 = TextUtils.isEmpty(str2);
        if (!isEmpty3 && !isEmpty4) {
            Preconditions.checkNotNull(str);
            if (!str.equals(str2)) {
                return true;
            }
            return false;
        }
        if (isEmpty3 && isEmpty4) {
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                if (!str3.equals(str4)) {
                    return true;
                }
                return false;
            }
            if (!TextUtils.isEmpty(str4)) {
                return true;
            }
            return false;
        }
        if (!isEmpty3) {
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                return true;
            }
            return false;
        }
        if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
            return true;
        }
        return false;
    }

    /* renamed from: K */
    public final boolean m3715K(String str) {
        String str2;
        Preconditions.checkNotNull(str);
        if (true != this.zzu.zzf().zzx(null, zzgi.zzbp)) {
            str2 = "^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$";
        } else {
            str2 = "^1:\\d+:android:[a-f0-9]+$";
        }
        return str.matches(str2);
    }

    /* renamed from: N */
    public final int m3716N(Object obj, String str) {
        boolean m3741x;
        if ("_ldl".equals(str)) {
            m3741x = m3741x("user property referrer", str, m3735p(str), obj);
        } else {
            m3741x = m3741x("user property", str, m3735p(str), obj);
        }
        if (m3741x) {
            return 0;
        }
        return 7;
    }

    /* renamed from: O */
    public final int m3717O(String str) {
        if (!m3742y("event param", str)) {
            return 3;
        }
        if (!m3740w("event param", null, null, str)) {
            return 14;
        }
        this.zzu.zzf();
        if (!m3739v(40, "event param", str)) {
            return 3;
        }
        return 0;
    }

    /* renamed from: P */
    public final int m3718P(String str) {
        if (!m3742y("user property", str)) {
            return 6;
        }
        if (!m3740w("user property", zzka.zza, null, str)) {
            return 15;
        }
        this.zzu.zzf();
        if (!m3739v(24, "user property", str)) {
            return 6;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0050  */
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long m3719Q() {
        int extensionVersion;
        int i;
        long j;
        int extensionVersion2;
        Object e;
        Integer num;
        zzg();
        if (!m3710t(this.zzu.zzh().m3527c())) {
            return 0L;
        }
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        Integer num2 = null;
        if (i2 >= 30) {
            extensionVersion = SdkExtensions.getExtensionVersion(30);
            if (extensionVersion < 4) {
                j = 8;
            } else {
                zzio zzioVar = this.zzu;
                if (i2 >= 30) {
                    extensionVersion2 = SdkExtensions.getExtensionVersion(30);
                    if (extensionVersion2 > 3) {
                        i = SdkExtensions.getExtensionVersion(1000000);
                        zzioVar.zzf();
                        if (i >= ((Integer) zzgi.zzak.zza(null)).intValue()) {
                            j = 16;
                        } else {
                            j = 0;
                        }
                    }
                }
                i = 0;
                zzioVar.zzf();
                if (i >= ((Integer) zzgi.zzak.zza(null)).intValue()) {
                }
            }
        } else {
            j = 4;
        }
        if (!m3711A("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j |= 2;
        }
        if (j == 0) {
            if (this.f14410f == null) {
                if (this.f14409e == null) {
                    this.f14409e = MeasurementManagerFutures.from(this.zzu.zzaT());
                }
                MeasurementManagerFutures measurementManagerFutures = this.f14409e;
                if (measurementManagerFutures != null) {
                    try {
                        num = measurementManagerFutures.getMeasurementApiStatusAsync().get(10000L, TimeUnit.MILLISECONDS);
                        if (num != null) {
                            try {
                                if (num.intValue() == 1) {
                                    z = true;
                                }
                            } catch (InterruptedException e2) {
                                e = e2;
                                num2 = num;
                                this.zzu.zzaW().zzk().zzb("Measurement manager api exception", e);
                                this.f14410f = Boolean.FALSE;
                                num = num2;
                                this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                                z = this.f14410f.booleanValue();
                                if (!z) {
                                }
                                if (j == 0) {
                                }
                            } catch (CancellationException e3) {
                                e = e3;
                                num2 = num;
                                this.zzu.zzaW().zzk().zzb("Measurement manager api exception", e);
                                this.f14410f = Boolean.FALSE;
                                num = num2;
                                this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                                z = this.f14410f.booleanValue();
                                if (!z) {
                                }
                                if (j == 0) {
                                }
                            } catch (ExecutionException e4) {
                                e = e4;
                                num2 = num;
                                this.zzu.zzaW().zzk().zzb("Measurement manager api exception", e);
                                this.f14410f = Boolean.FALSE;
                                num = num2;
                                this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                                z = this.f14410f.booleanValue();
                                if (!z) {
                                }
                                if (j == 0) {
                                }
                            } catch (TimeoutException e5) {
                                e = e5;
                                num2 = num;
                                this.zzu.zzaW().zzk().zzb("Measurement manager api exception", e);
                                this.f14410f = Boolean.FALSE;
                                num = num2;
                                this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                                z = this.f14410f.booleanValue();
                                if (!z) {
                                }
                                if (j == 0) {
                                }
                            }
                        }
                        this.f14410f = Boolean.valueOf(z);
                    } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e6) {
                        e = e6;
                    }
                    this.zzu.zzaW().zzj().zzb("Measurement manager api status result", num);
                }
                if (!z) {
                    j = 64;
                }
            }
            z = this.f14410f.booleanValue();
            if (!z) {
            }
        }
        if (j == 0) {
            return 1L;
        }
        return j;
    }

    /* renamed from: S */
    public final Bundle m3720S(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
                str5 = uri.getQueryParameter("gbraid");
                str6 = uri.getQueryParameter("utm_id");
                str7 = uri.getQueryParameter("dclid");
                str8 = uri.getQueryParameter("srsltid");
                str9 = uri.getQueryParameter("sfmc_id");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
                str9 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                str10 = "sfmc_id";
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN, str);
            } else {
                str10 = "sfmc_id";
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString("gbraid", str5);
            }
            String queryParameter = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("gad_source", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter5);
            }
            String queryParameter6 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("anid", queryParameter6);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("dclid", str7);
            }
            String queryParameter7 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter8);
            }
            String queryParameter9 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter9);
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("srsltid", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                bundle.putString(str10, str9);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            this.zzu.zzaW().zzk().zzb("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    /* renamed from: T */
    public final Bundle m3721T(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object m3724c = m3724c(bundle.get(str), str);
                if (m3724c == null) {
                    zzio zzioVar = this.zzu;
                    zzioVar.zzaW().zzl().zzb("Param value can't be null", zzioVar.zzj().zze(str));
                } else {
                    m3733n(bundle2, str, m3724c);
                }
            }
        }
        return bundle2;
    }

    /* renamed from: a */
    public final Bundle m3722a(String str, Bundle bundle, List list, boolean z) {
        int i;
        int i2;
        String str2;
        String str3;
        List list2 = list;
        boolean m3709r = m3709r(str, zzjy.zzd);
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            zzio zzioVar = this.zzu;
            int zze = zzioVar.zzf().zze();
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i3 = 0;
            boolean z2 = false;
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (list2 != null && list2.contains(str4)) {
                    i = 0;
                } else {
                    if (!z) {
                        i = zzi(str4);
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        i = m3717O(str4);
                    }
                }
                if (i != 0) {
                    if (i == 3) {
                        str3 = str4;
                    } else {
                        str3 = null;
                    }
                    m3729i(bundle2, i, str4, str3);
                    bundle2.remove(str4);
                    i2 = zze;
                } else {
                    i2 = zze;
                    int m3734o = m3734o(str, str4, bundle.get(str4), bundle2, list, z, m3709r);
                    if (m3734o == 17) {
                        m3729i(bundle2, 17, str4, Boolean.FALSE);
                    } else if (m3734o != 0 && !"_ev".equals(str4)) {
                        if (m3734o == 21) {
                            str2 = str;
                        } else {
                            str2 = str4;
                        }
                        m3729i(bundle2, m3734o, str2, bundle.get(str4));
                        bundle2.remove(str4);
                    }
                    if (m3700F(str4)) {
                        int i4 = i3 + 1;
                        if (i4 > i2) {
                            if (!zzioVar.zzf().zzx(null, zzgi.zzbr) || !z2) {
                                zzioVar.zzaW().zzf().zzc(ye0.m8292l(i2, "Event can't contain more than ", " params"), zzioVar.zzj().zzd(str), zzioVar.zzj().zzb(bundle));
                            }
                            m3705M(5, bundle2);
                            bundle2.remove(str4);
                            z2 = true;
                        }
                        i3 = i4;
                        zze = i2;
                        list2 = list;
                    }
                }
                zze = i2;
                list2 = list;
            }
            return bundle2;
        }
        return null;
    }

    /* renamed from: b */
    public final zzbh m3723b(String str, Bundle bundle, String str2, long j, boolean z) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzf(str) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putString("_o", str2);
            Bundle m3722a = m3722a(str, bundle2, CollectionUtils.listOf("_o"), true);
            if (z) {
                m3722a = m3721T(m3722a);
            }
            Preconditions.checkNotNull(m3722a);
            return new zzbh(str, new zzbf(m3722a), str2, j);
        }
        zzio zzioVar = this.zzu;
        zzioVar.zzaW().zze().zzb("Invalid conditional property event name", zzioVar.zzj().zzf(str));
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    public final Object m3724c(Object obj, String str) {
        boolean equals = "_ev".equals(str);
        int i = HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR;
        if (equals) {
            this.zzu.zzf().getClass();
            return m3736q(Math.max(HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR, 256), obj, true, true);
        }
        if (m3699E(str)) {
            this.zzu.zzf().getClass();
            i = Math.max(HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR, 256);
        } else {
            this.zzu.zzf().getClass();
        }
        return m3736q(i, obj, false, true);
    }

    /* renamed from: d */
    public final Object m3725d(Object obj, String str) {
        if ("_ldl".equals(str)) {
            return m3736q(m3735p(str), obj, true, false);
        }
        return m3736q(m3735p(str), obj, false, false);
    }

    /* renamed from: e */
    public final String m3726e() {
        byte[] bArr = new byte[16];
        m3727g().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* renamed from: g */
    public final SecureRandom m3727g() {
        zzg();
        if (this.f14406b == null) {
            this.f14406b = new SecureRandom();
        }
        return this.f14406b;
    }

    /* renamed from: h */
    public final void m3728h(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzu.zzaW().zzk().zzb("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    /* renamed from: i */
    public final void m3729i(Bundle bundle, int i, String str, Object obj) {
        if (m3705M(i, bundle)) {
            this.zzu.zzf();
            bundle.putString("_ev", zzG(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    /* renamed from: j */
    public final void m3730j(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    this.zzu.zzw().m3733n(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    /* renamed from: k */
    public final void m3731k(Parcelable[] parcelableArr, int i) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i2 = 0;
            boolean z = false;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (m3700F(str) && !m3709r(str, zzjz.zzd) && (i2 = i2 + 1) > i) {
                    zzio zzioVar = this.zzu;
                    if (!zzioVar.zzf().zzx(null, zzgi.zzbr) || !z) {
                        zzioVar.zzaW().zzf().zzc(ye0.m8292l(i, "Param can't contain more than ", " item-scoped custom parameters"), zzioVar.zzj().zze(str), zzioVar.zzj().zzb(bundle));
                    }
                    m3705M(28, bundle);
                    bundle.remove(str);
                    z = true;
                }
            }
        }
    }

    /* renamed from: l */
    public final void m3732l(zzhf zzhfVar, int i) {
        Bundle bundle = zzhfVar.zzd;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i2 = 0;
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (m3700F(str) && (i2 = i2 + 1) > i) {
                zzio zzioVar = this.zzu;
                if (!zzioVar.zzf().zzx(null, zzgi.zzbr) || !z) {
                    zzioVar.zzaW().zzf().zzc(ye0.m8292l(i, "Event can't contain more than ", " params"), zzioVar.zzj().zzd(zzhfVar.zza), zzioVar.zzj().zzb(bundle));
                    m3705M(5, bundle);
                }
                bundle.remove(str);
                z = true;
            }
        }
    }

    /* renamed from: n */
    public final void m3733n(Bundle bundle, String str, Object obj) {
        String str2;
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
                return;
            }
            if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
                return;
            }
            if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
                return;
            }
            if (str != null) {
                if (obj != null) {
                    str2 = obj.getClass().getSimpleName();
                } else {
                    str2 = null;
                }
                zzio zzioVar = this.zzu;
                zzioVar.zzaW().zzl().zzc("Not putting event parameter. Invalid value type. name, type", zzioVar.zzj().zze(str), str2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d7  */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m3734o(String str, String str2, Object obj, Bundle bundle, List list, boolean z, boolean z2) {
        int i;
        boolean m3699E;
        int i2;
        Object obj2;
        int size;
        zzg();
        if (m3698C(obj)) {
            if (z2) {
                if (!m3709r(str2, zzjz.zzc)) {
                    return 20;
                }
                zzny zzu = this.zzu.zzu();
                zzu.zzg();
                zzu.zza();
                if (zzu.m3586d() && zzu.zzu.zzw().zzm() < 200900) {
                    return 25;
                }
                zzio zzioVar = this.zzu;
                zzioVar.zzf();
                boolean z3 = obj instanceof Parcelable[];
                if (z3) {
                    size = ((Parcelable[]) obj).length;
                } else if (obj instanceof ArrayList) {
                    size = ((ArrayList) obj).size();
                }
                if (size > 200) {
                    zzioVar.zzaW().zzl().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str2, Integer.valueOf(size));
                    zzioVar.zzf();
                    if (z3) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        if (parcelableArr.length > 200) {
                            bundle.putParcelableArray(str2, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        if (arrayList.size() > 200) {
                            bundle.putParcelableArrayList(str2, new ArrayList<>(arrayList.subList(0, 200)));
                        }
                    }
                    i = 17;
                    m3699E = m3699E(str);
                    i2 = HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR;
                    if (m3699E && !m3699E(str2)) {
                        this.zzu.zzf().getClass();
                    } else {
                        this.zzu.zzf().getClass();
                        i2 = Math.max(HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR, 256);
                    }
                    if (!m3741x("param", str2, i2, obj)) {
                        return i;
                    }
                    if (z2) {
                        if (obj instanceof Bundle) {
                            m3737s(str, str2, (Bundle) obj, list, z);
                        } else if (obj instanceof Parcelable[]) {
                            for (Parcelable parcelable : (Parcelable[]) obj) {
                                if (!(parcelable instanceof Bundle)) {
                                    this.zzu.zzaW().zzl().zzc("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                                    return 4;
                                }
                                m3737s(str, str2, (Bundle) parcelable, list, z);
                            }
                        } else if (obj instanceof ArrayList) {
                            ArrayList arrayList2 = (ArrayList) obj;
                            int size2 = arrayList2.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                Object obj3 = arrayList2.get(i3);
                                if (!(obj3 instanceof Bundle)) {
                                    zzhc zzl = this.zzu.zzaW().zzl();
                                    if (obj3 != null) {
                                        obj2 = obj3.getClass();
                                    } else {
                                        obj2 = "null";
                                    }
                                    zzl.zzc("All ArrayList elements must be of type Bundle. Value type, name", obj2, str2);
                                    return 4;
                                }
                                m3737s(str, str2, (Bundle) obj3, list, z);
                            }
                        } else {
                            return 4;
                        }
                        return i;
                    }
                    return 4;
                }
            } else {
                return 21;
            }
        }
        i = 0;
        m3699E = m3699E(str);
        i2 = HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR;
        if (m3699E) {
        }
        this.zzu.zzf().getClass();
        i2 = Math.max(HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR, 256);
        if (!m3741x("param", str2, i2, obj)) {
        }
    }

    /* renamed from: p */
    public final int m3735p(String str) {
        if ("_ldl".equals(str)) {
            this.zzu.zzf();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.zzu.zzf();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            this.zzu.zzf();
            return 100;
        }
        this.zzu.zzf();
        return 36;
    }

    /* renamed from: q */
    public final Object m3736q(int i, Object obj, boolean z, boolean z2) {
        long j;
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Long) && !(obj instanceof Double)) {
            if (obj instanceof Integer) {
                return Long.valueOf(((Integer) obj).intValue());
            }
            if (obj instanceof Byte) {
                return Long.valueOf(((Byte) obj).byteValue());
            }
            if (obj instanceof Short) {
                return Long.valueOf(((Short) obj).shortValue());
            }
            if (obj instanceof Boolean) {
                if (true != ((Boolean) obj).booleanValue()) {
                    j = 0;
                } else {
                    j = 1;
                }
                return Long.valueOf(j);
            }
            if (obj instanceof Float) {
                return Double.valueOf(((Float) obj).doubleValue());
            }
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : (Parcelable[]) obj) {
                    if (parcelable instanceof Bundle) {
                        Bundle m3721T = m3721T((Bundle) parcelable);
                        if (!m3721T.isEmpty()) {
                            arrayList.add(m3721T);
                        }
                    }
                }
                return arrayList.toArray(new Bundle[arrayList.size()]);
            }
            return zzG(obj.toString(), i, z);
        }
        return obj;
    }

    /* renamed from: s */
    public final void m3737s(String str, String str2, Bundle bundle, List list, boolean z) {
        int i;
        int i2;
        int i3;
        String str3;
        int i4;
        int m3734o;
        if (bundle != null) {
            zzio zzioVar = this.zzu;
            if (true != zzioVar.zzf().zzu.zzw().zzao(231100000, true)) {
                i = 0;
            } else {
                i = 35;
            }
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i5 = 0;
            boolean z2 = false;
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (list != null && list.contains(str4)) {
                    i2 = 0;
                } else {
                    if (!z) {
                        i2 = zzi(str4);
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        i2 = m3717O(str4);
                    }
                }
                String str5 = null;
                if (i2 != 0) {
                    if (i2 == 3) {
                        str5 = str4;
                    }
                    m3729i(bundle, i2, str4, str5);
                    bundle.remove(str4);
                    i3 = i;
                } else {
                    if (m3698C(bundle.get(str4))) {
                        zzioVar.zzaW().zzl().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str4);
                        m3734o = 22;
                        str3 = str4;
                        i4 = i;
                    } else {
                        str3 = str4;
                        i4 = i;
                        m3734o = m3734o(str, str4, bundle.get(str4), bundle, list, z, false);
                    }
                    if (m3734o != 0 && !"_ev".equals(str3)) {
                        m3729i(bundle, m3734o, str3, bundle.get(str3));
                        bundle.remove(str3);
                    } else if (m3700F(str3) && !m3709r(str3, zzjz.zzd)) {
                        int i6 = i5 + 1;
                        if (!zzao(231100000, true)) {
                            zzioVar.zzaW().zzf().zzc("Item array not supported on client's version of Google Play Services (Android Only)", zzioVar.zzj().zzd(str), zzioVar.zzj().zzb(bundle));
                            m3705M(23, bundle);
                            bundle.remove(str3);
                            i3 = i4;
                        } else {
                            i3 = i4;
                            if (i6 > i3) {
                                if (!zzioVar.zzf().zzx(null, zzgi.zzbr) || !z2) {
                                    zzioVar.zzaW().zzf().zzc(ye0.m8292l(i3, "Item can't contain more than ", " item-scoped custom params"), zzioVar.zzj().zzd(str), zzioVar.zzj().zzb(bundle));
                                }
                                m3705M(28, bundle);
                                bundle.remove(str3);
                                i5 = i6;
                                i = i3;
                                z2 = true;
                            }
                        }
                        i5 = i6;
                    }
                    i3 = i4;
                }
                i = i3;
            }
        }
    }

    /* renamed from: u */
    public final boolean m3738u(String str, String str2) {
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzbp)) {
            if (!TextUtils.isEmpty(str)) {
                if (m3715K(str)) {
                    return true;
                }
                if (this.zzu.zzL()) {
                    zzioVar.zzaW().zzf().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzhe.zzn(str));
                    return false;
                }
            } else if (this.zzu.zzL()) {
                zzioVar.zzaW().zzf().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                return false;
            }
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!m3715K(str)) {
                if (this.zzu.zzL()) {
                    zzioVar.zzaW().zzf().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzhe.zzn(str));
                }
                return false;
            }
        } else if (!TextUtils.isEmpty(str2)) {
            if (!m3715K(str2)) {
                zzioVar.zzaW().zzf().zzb("Invalid admob_app_id. Analytics disabled.", zzhe.zzn(str2));
                return false;
            }
        } else {
            if (this.zzu.zzL()) {
                zzioVar.zzaW().zzf().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        return true;
    }

    /* renamed from: v */
    public final boolean m3739v(int i, String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) > i) {
            this.zzu.zzaW().zzf().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
        return true;
    }

    /* renamed from: w */
    public final boolean m3740w(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = f14404h;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzu.zzaW().zzf().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr != null && m3709r(str2, strArr)) {
            if (strArr2 == null || !m3709r(str2, strArr2)) {
                this.zzu.zzaW().zzf().zzc("Name is reserved. Type, name", str, str2);
                return false;
            }
            return true;
        }
        return true;
    }

    /* renamed from: x */
    public final boolean m3741x(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i) {
                this.zzu.zzaW().zzl().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    /* renamed from: y */
    public final boolean m3742y(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            if (codePointAt == 95) {
                codePointAt = 95;
            } else {
                this.zzu.zzaW().zzf().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                this.zzu.zzaW().zzf().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* renamed from: z */
    public final boolean m3743z(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzu.zzaW().zzf().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            this.zzu.zzaW().zzf().zzc("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                this.zzu.zzaW().zzf().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public final String zzG(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) > i) {
            if (!z) {
                return null;
            }
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return str;
    }

    public final URL zzH(long j, String str, String str2, long j2, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String str4 = "https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=" + ("v119002." + zzm()) + "&rdid=" + str2 + "&bundleid=" + str + "&retry=" + j2;
            if (str.equals(this.zzu.zzf().zzp())) {
                str4 = str4.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    str4 = str4.concat("&");
                }
                str4 = str4.concat(str3);
            }
            return new URL(str4);
        } catch (IllegalArgumentException e) {
            e = e;
            this.zzu.zzaW().zze().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e2) {
            e = e2;
            this.zzu.zzaW().zze().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    public final void zzT(com.google.android.gms.internal.measurement.zzcy zzcyVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning boolean value to wrapper", e);
        }
    }

    public final void zzU(com.google.android.gms.internal.measurement.zzcy zzcyVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning bundle list to wrapper", e);
        }
    }

    public final void zzV(com.google.android.gms.internal.measurement.zzcy zzcyVar, Bundle bundle) {
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public final void zzW(com.google.android.gms.internal.measurement.zzcy zzcyVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning byte array to wrapper", e);
        }
    }

    public final void zzX(com.google.android.gms.internal.measurement.zzcy zzcyVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning int value to wrapper", e);
        }
    }

    public final void zzY(com.google.android.gms.internal.measurement.zzcy zzcyVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning long value to wrapper", e);
        }
    }

    public final void zzZ(com.google.android.gms.internal.measurement.zzcy zzcyVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcyVar.zze(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zzk().zzb("Error returning string value to wrapper", e);
        }
    }

    @Override // p000.fc3
    @WorkerThread
    public final void zzaZ() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                AbstractC1726qj.m7037B(this.zzu, "Utils falling back to Random for random id");
            }
        }
        this.f14407c.set(nextLong);
    }

    public final boolean zzao(int i, boolean z) {
        Boolean bool = this.zzu.zzu().f14339d;
        if (zzm() >= i / 1000) {
            return true;
        }
        if (bool != null && !bool.booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // p000.fc3
    public final boolean zzc() {
        return true;
    }

    public final int zzf(String str) {
        if (!m3742y(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!m3740w(NotificationCompat.CATEGORY_EVENT, zzjy.zza, zzjy.zzb, str)) {
            return 13;
        }
        this.zzu.zzf();
        if (!m3739v(40, NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        return 0;
    }

    public final int zzi(String str) {
        if (!m3743z("event param", str)) {
            return 3;
        }
        if (!m3740w("event param", null, null, str)) {
            return 14;
        }
        this.zzu.zzf();
        if (!m3739v(40, "event param", str)) {
            return 3;
        }
        return 0;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzm() {
        if (this.f14411g == null) {
            this.f14411g = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzu.zzaT()) / 1000);
        }
        return this.f14411g.intValue();
    }

    public final int zzp(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzu.zzaT(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final long zzs() {
        long andIncrement;
        long j;
        AtomicLong atomicLong = this.f14407c;
        if (atomicLong.get() == 0) {
            synchronized (atomicLong) {
                long nextLong = new Random(System.nanoTime() ^ this.zzu.zzaU().currentTimeMillis()).nextLong();
                int i = this.f14408d + 1;
                this.f14408d = i;
                j = nextLong + i;
            }
            return j;
        }
        AtomicLong atomicLong2 = this.f14407c;
        synchronized (atomicLong2) {
            atomicLong2.compareAndSet(-1L, 1L);
            andIncrement = atomicLong2.getAndIncrement();
        }
        return andIncrement;
    }

    public final long zzt(long j, long j2) {
        return ((j2 * 60000) + j) / 86400000;
    }
}
