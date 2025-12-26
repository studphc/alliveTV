package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
/* loaded from: classes.dex */
public class FingerprintManagerCompat {

    /* renamed from: a */
    public final Context f3666a;

    /* loaded from: classes.dex */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, @NonNull CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, @NonNull CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(@NonNull AuthenticationResult authenticationResult) {
        }
    }

    /* loaded from: classes.dex */
    public static final class AuthenticationResult {

        /* renamed from: a */
        public final CryptoObject f3667a;

        public AuthenticationResult(@NonNull CryptoObject cryptoObject) {
            this.f3667a = cryptoObject;
        }

        @NonNull
        public CryptoObject getCryptoObject() {
            return this.f3667a;
        }
    }

    public FingerprintManagerCompat(Context context) {
        this.f3666a = context;
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context context) {
        return new FingerprintManagerCompat(context);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public void authenticate(@Nullable CryptoObject cryptoObject, int i, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        authenticate(cryptoObject, i, cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, authenticationCallback, handler);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager m852c = AbstractC0180b.m852c(this.f3666a);
        if (m852c != null && AbstractC0180b.m853d(m852c)) {
            return true;
        }
        return false;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager m852c = AbstractC0180b.m852c(this.f3666a);
        if (m852c != null && AbstractC0180b.m854e(m852c)) {
            return true;
        }
        return false;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject cryptoObject, int i, @Nullable android.os.CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        FingerprintManager m852c = AbstractC0180b.m852c(this.f3666a);
        if (m852c != null) {
            AbstractC0180b.m850a(m852c, AbstractC0180b.m856g(cryptoObject), cancellationSignal, i, new C0179a(authenticationCallback), handler);
        }
    }

    /* loaded from: classes.dex */
    public static class CryptoObject {

        /* renamed from: a */
        public final Signature f3668a;

        /* renamed from: b */
        public final Cipher f3669b;

        /* renamed from: c */
        public final Mac f3670c;

        public CryptoObject(@NonNull Signature signature) {
            this.f3668a = signature;
            this.f3669b = null;
            this.f3670c = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.f3669b;
        }

        @Nullable
        public Mac getMac() {
            return this.f3670c;
        }

        @Nullable
        public Signature getSignature() {
            return this.f3668a;
        }

        public CryptoObject(@NonNull Cipher cipher) {
            this.f3669b = cipher;
            this.f3668a = null;
            this.f3670c = null;
        }

        public CryptoObject(@NonNull Mac mac) {
            this.f3670c = mac;
            this.f3669b = null;
            this.f3668a = null;
        }
    }
}
