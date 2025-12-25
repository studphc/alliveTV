package p000;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import p000.bc3;
import p000.jb3;
import p000.od3;

/* loaded from: classes.dex */
public abstract class od3 {

    /* renamed from: e */
    public static volatile zzag f23783e;

    /* renamed from: g */
    public static Context f23785g;

    /* renamed from: a */
    public static final jb3 f23779a = new jb3(bc3.m2082a("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"), 0);

    /* renamed from: b */
    public static final jb3 f23780b = new jb3(bc3.m2082a("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"), 1);

    /* renamed from: c */
    public static final jb3 f23781c = new jb3(bc3.m2082a("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"), 2);

    /* renamed from: d */
    public static final jb3 f23782d = new jb3(bc3.m2082a("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"), 3);

    /* renamed from: f */
    public static final Object f23784f = new Object();

    /* renamed from: a */
    public static synchronized void m6564a(Context context) {
        synchronized (od3.class) {
            if (f23785g == null) {
                if (context != null) {
                    f23785g = context.getApplicationContext();
                    return;
                }
                return;
            }
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        }
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [com.google.android.gms.common.zze] */
    /* renamed from: b */
    public static ff3 m6565b(final String str, final bc3 bc3Var, final boolean z, boolean z2) {
        try {
            m6567d();
            Preconditions.checkNotNull(f23785g);
            try {
                if (f23783e.zzh(new zzs(str, bc3Var, z, z2), ObjectWrapper.wrap(f23785g.getPackageManager()))) {
                    return ff3.f17242e;
                }
                return new bf3(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        String str2;
                        boolean z3 = z;
                        String str3 = str;
                        bc3 bc3Var2 = bc3Var;
                        if (!z3) {
                            if (od3.m6565b(str3, bc3Var2, true, false).f17243a) {
                                str2 = "debug cert rejected";
                                MessageDigest zza = AndroidUtilsLight.zza("SHA-256");
                                Preconditions.checkNotNull(zza);
                                return str2 + ": pkg=" + str3 + ", sha256=" + Hex.bytesToStringLowercase(zza.digest(bc3Var2.mo2083b())) + ", atk=" + z3 + ", ver=12451000.false";
                            }
                        } else {
                            jb3 jb3Var = od3.f23779a;
                        }
                        str2 = "not allowed";
                        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-256");
                        Preconditions.checkNotNull(zza2);
                        return str2 + ": pkg=" + str3 + ", sha256=" + Hex.bytesToStringLowercase(zza2.digest(bc3Var2.mo2083b())) + ", atk=" + z3 + ", ver=12451000.false";
                    }
                });
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return new ff3(false, 1, "module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            return new ff3(false, 1, "module init: ".concat(String.valueOf(e2.getMessage())), e2);
        }
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    /* renamed from: c */
    public static ff3 m6566c(String str, boolean z, boolean z2) {
        ff3 ff3Var;
        ff3 ff3Var2;
        zzq zzf;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(f23785g);
            try {
                m6567d();
                zzo zzoVar = new zzo(str, z, false, ObjectWrapper.wrap(f23785g), false, true);
                try {
                    if (z2) {
                        zzf = f23783e.zze(zzoVar);
                    } else {
                        zzf = f23783e.zzf(zzoVar);
                    }
                    PackageManager.NameNotFoundException nameNotFoundException = null;
                    if (zzf.zzb()) {
                        ff3Var2 = new ff3(true, zzf.zzc(), null, null);
                    } else {
                        String zza = zzf.zza();
                        if (zzf.zzd() == 4) {
                            nameNotFoundException = new PackageManager.NameNotFoundException();
                        }
                        if (zza == null) {
                            zza = "error checking package certificate";
                        }
                        int zzc = zzf.zzc();
                        zzf.zzd();
                        ff3Var2 = new ff3(false, zzc, zza, nameNotFoundException);
                    }
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    ff3Var = new ff3(false, 1, "module call", e);
                    ff3Var2 = ff3Var;
                    return ff3Var2;
                }
            } catch (DynamiteModule.LoadingException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                ff3Var = new ff3(false, 1, "module init: ".concat(String.valueOf(e2.getMessage())), e2);
            }
            return ff3Var2;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: d */
    public static void m6567d() {
        if (f23783e != null) {
            return;
        }
        Preconditions.checkNotNull(f23785g);
        synchronized (f23784f) {
            try {
                if (f23783e == null) {
                    f23783e = zzaf.zzb(DynamiteModule.load(f23785g, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
