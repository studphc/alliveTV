package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamite.DynamiteModule;
import p000.C1540m9;
import p000.ff3;
import p000.jb3;
import p000.k93;
import p000.od3;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class PackageSignatureVerifier {

    /* renamed from: a */
    public static k93 f12997a;

    /* renamed from: b */
    public static volatile C1540m9 f12998b;

    /* JADX WARN: Type inference failed for: r1v1, types: [k93, java.lang.Object] */
    /* renamed from: a */
    public static void m3079a(Context context) {
        synchronized (PackageSignatureVerifier.class) {
            try {
                if (f12997a == null) {
                    ?? obj = new Object();
                    od3.m6564a(context);
                    f12997a = obj;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerified(@NonNull Context context, @NonNull String str) {
        boolean z;
        String str2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        m3079a(context);
        jb3 jb3Var = od3.f23779a;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                od3.m6567d();
                z = od3.f23783e.zzg();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            z = false;
        }
        if (z) {
            if (true != honorsDebugCertificates) {
                str2 = "-0";
            } else {
                str2 = "-1";
            }
            String concat = String.valueOf(str).concat(str2);
            if (f12998b != null && ((String) f12998b.f22854b).equals(concat)) {
                return (PackageVerificationResult) f12998b.f22855c;
            }
            m3079a(context);
            ff3 m6566c = od3.m6566c(str, honorsDebugCertificates, false);
            if (m6566c.f17243a) {
                f12998b = new C1540m9(28, concat, PackageVerificationResult.zzd(str, m6566c.f17246d));
                return (PackageVerificationResult) f12998b.f22855c;
            }
            Preconditions.checkNotNull(m6566c.f17244b);
            return PackageVerificationResult.zza(str, m6566c.f17244b, m6566c.f17245c);
        }
        throw new zzad();
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(@NonNull Context context, @NonNull String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzb();
            return queryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (queryPackageSignatureVerified2.zzc()) {
                Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
                return queryPackageSignatureVerified2;
            }
            return queryPackageSignatureVerified2;
        }
    }
}
