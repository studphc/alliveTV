package com.google.android.gms.common;

import androidx.annotation.NonNull;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class PackageVerificationResult {

    /* renamed from: a */
    public final boolean f12999a;

    /* renamed from: b */
    public final String f13000b;

    /* renamed from: c */
    public final Throwable f13001c;

    public PackageVerificationResult(boolean z, String str, Throwable th) {
        this.f12999a = z;
        this.f13000b = str;
        this.f13001c = th;
    }

    @NonNull
    public static PackageVerificationResult zza(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        return new PackageVerificationResult(false, str2, th);
    }

    @NonNull
    public static PackageVerificationResult zzd(@NonNull String str, int i) {
        return new PackageVerificationResult(true, null, null);
    }

    public final void zzb() {
        if (!this.f12999a) {
            String concat = "PackageVerificationRslt: ".concat(String.valueOf(this.f13000b));
            Throwable th = this.f13001c;
            if (th != null) {
                throw new SecurityException(concat, th);
            }
            throw new SecurityException(concat);
        }
    }

    public final boolean zzc() {
        return this.f12999a;
    }
}
