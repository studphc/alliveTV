package p000;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class u12 {
    @Nullable
    @DoNotInline
    /* renamed from: a */
    public static Signature[] m7520a(@NonNull SigningInfo signingInfo) {
        return signingInfo.getApkContentsSigners();
    }

    @DoNotInline
    /* renamed from: b */
    public static long m7521b(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }

    @Nullable
    @DoNotInline
    /* renamed from: c */
    public static Signature[] m7522c(@NonNull SigningInfo signingInfo) {
        return signingInfo.getSigningCertificateHistory();
    }

    @DoNotInline
    /* renamed from: d */
    public static boolean m7523d(@NonNull SigningInfo signingInfo) {
        return signingInfo.hasMultipleSigners();
    }

    @DoNotInline
    /* renamed from: e */
    public static boolean m7524e(@NonNull PackageManager packageManager, @NonNull String str, @NonNull byte[] bArr, int i) {
        return packageManager.hasSigningCertificate(str, bArr, i);
    }
}
