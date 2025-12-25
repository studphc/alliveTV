package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* renamed from: androidx.core.hardware.fingerprint.b */
/* loaded from: classes.dex */
public abstract class AbstractC0180b {
    @RequiresPermission("android.permission.USE_FINGERPRINT")
    @DoNotInline
    /* renamed from: a */
    public static void m850a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i, Object obj3, Handler handler) {
        ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i, (FingerprintManager.AuthenticationCallback) obj3, handler);
    }

    @DoNotInline
    /* renamed from: b */
    public static FingerprintManager.CryptoObject m851b(Object obj) {
        return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
    }

    @DoNotInline
    /* renamed from: c */
    public static FingerprintManager m852c(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (i > 23 && context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        return null;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    @DoNotInline
    /* renamed from: d */
    public static boolean m853d(Object obj) {
        return ((FingerprintManager) obj).hasEnrolledFingerprints();
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    @DoNotInline
    /* renamed from: e */
    public static boolean m854e(Object obj) {
        return ((FingerprintManager) obj).isHardwareDetected();
    }

    @DoNotInline
    /* renamed from: f */
    public static FingerprintManagerCompat.CryptoObject m855f(Object obj) {
        FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManagerCompat.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManagerCompat.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) {
            return null;
        }
        return new FingerprintManagerCompat.CryptoObject(cryptoObject.getMac());
    }

    @DoNotInline
    /* renamed from: g */
    public static FingerprintManager.CryptoObject m856g(FingerprintManagerCompat.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) {
            return null;
        }
        return new FingerprintManager.CryptoObject(cryptoObject.getMac());
    }
}
