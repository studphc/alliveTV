package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamite.DynamiteModule;
import javax.annotation.Nullable;
import p000.bc3;
import p000.fd3;
import p000.ff3;
import p000.jb3;
import p000.kc3;
import p000.od3;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class GoogleSignatureVerifier {

    /* renamed from: c */
    public static GoogleSignatureVerifier f12994c;

    /* renamed from: a */
    public final Context f12995a;

    /* renamed from: b */
    public volatile String f12996b;

    public GoogleSignatureVerifier(@NonNull Context context) {
        this.f12995a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static final bc3 m3077a(PackageInfo packageInfo, bc3... bc3VarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            kc3 kc3Var = new kc3(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < bc3VarArr.length; i++) {
                if (bc3VarArr[i].equals(kc3Var)) {
                    return bc3VarArr[i];
                }
            }
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (f12994c == null) {
                    od3.m6564a(context);
                    f12994c = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f12994c;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean zzb(@NonNull PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        bc3 m3077a;
        if (z) {
            if (packageInfo != null) {
                if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if (applicationInfo == null || (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
            } else {
                packageInfo2 = null;
                if (packageInfo != null && packageInfo2.signatures != null) {
                    if (!z) {
                        m3077a = m3077a(packageInfo2, fd3.f17227a);
                    } else {
                        m3077a = m3077a(packageInfo2, fd3.f17227a[0]);
                    }
                    if (m3077a == null) {
                        return true;
                    }
                }
                return false;
            }
        }
        packageInfo2 = packageInfo;
        if (packageInfo != null) {
            if (!z) {
            }
            if (m3077a == null) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public final ff3 m3078b(String str) {
        boolean z;
        ff3 ff3Var;
        ff3 ff3Var2;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return new ff3(false, 1, "null pkg", null);
        }
        if (!str.equals(this.f12996b)) {
            jb3 jb3Var = od3.f23779a;
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                try {
                    od3.m6567d();
                    z = od3.f23783e.zzi();
                } finally {
                }
            } catch (RemoteException | DynamiteModule.LoadingException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                z = false;
            }
            if (z) {
                ff3Var2 = od3.m6566c(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.f12995a), true);
            } else {
                try {
                    PackageInfo packageInfo = this.f12995a.getPackageManager().getPackageInfo(str, 64);
                    boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.f12995a);
                    if (packageInfo == null) {
                        ff3Var2 = new ff3(false, 1, "null pkg", null);
                    } else {
                        Signature[] signatureArr = packageInfo.signatures;
                        if (signatureArr != null && signatureArr.length == 1) {
                            kc3 kc3Var = new kc3(packageInfo.signatures[0].toByteArray());
                            String str2 = packageInfo.packageName;
                            allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                            try {
                                ff3 m6565b = od3.m6565b(str2, kc3Var, honorsDebugCertificates, false);
                                StrictMode.setThreadPolicy(allowThreadDiskReads);
                                if (m6565b.f17243a && (applicationInfo = packageInfo.applicationInfo) != null && (applicationInfo.flags & 2) != 0) {
                                    allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                                    try {
                                        ff3 m6565b2 = od3.m6565b(str2, kc3Var, false, true);
                                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                                        if (m6565b2.f17243a) {
                                            ff3Var = new ff3(false, 1, "debuggable release cert app rejected", null);
                                        }
                                    } finally {
                                    }
                                }
                                ff3Var2 = m6565b;
                            } finally {
                            }
                        } else {
                            ff3Var = new ff3(false, 1, "single cert required", null);
                        }
                        ff3Var2 = ff3Var;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    return new ff3(false, 1, "no pkg ".concat(str), e2);
                }
            }
            if (ff3Var2.f17243a) {
                this.f12996b = str;
            }
            return ff3Var2;
        }
        return ff3.f17242e;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(@NonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.f12995a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(@Nullable String str) {
        ff3 m3078b = m3078b(str);
        m3078b.m4806b();
        return m3078b.f17243a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        int length;
        String[] packagesForUid = this.f12995a.getPackageManager().getPackagesForUid(i);
        ff3 ff3Var = null;
        int i2 = 0;
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            while (true) {
                if (i2 < length) {
                    ff3Var = m3078b(packagesForUid[i2]);
                    if (ff3Var.f17243a) {
                        break;
                    }
                    i2++;
                } else {
                    Preconditions.checkNotNull(ff3Var);
                    break;
                }
            }
        } else {
            ff3Var = new ff3(false, 1, "no pkgs", null);
        }
        ff3Var.m4806b();
        return ff3Var.f17243a;
    }
}
