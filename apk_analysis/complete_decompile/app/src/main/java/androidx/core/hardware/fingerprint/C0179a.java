package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* renamed from: androidx.core.hardware.fingerprint.a */
/* loaded from: classes.dex */
public final class C0179a extends FingerprintManager.AuthenticationCallback {

    /* renamed from: a */
    public final /* synthetic */ FingerprintManagerCompat.AuthenticationCallback f3671a;

    public C0179a(FingerprintManagerCompat.AuthenticationCallback authenticationCallback) {
        this.f3671a = authenticationCallback;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationError(int i, CharSequence charSequence) {
        this.f3671a.onAuthenticationError(i, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationFailed() {
        this.f3671a.onAuthenticationFailed();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        this.f3671a.onAuthenticationHelp(i, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        this.f3671a.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(AbstractC0180b.m855f(AbstractC0180b.m851b(authenticationResult))));
    }
}
