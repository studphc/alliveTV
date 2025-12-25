package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.google.android.exoplayer2.C0643C;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000.AbstractC1726qj;
import p000.u12;

/* loaded from: classes.dex */
public final class PackageInfoCompat {
    public static long getLongVersionCode(@NonNull PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return u12.m7521b(packageInfo);
        }
        return packageInfo.versionCode;
    }

    @NonNull
    public static List<Signature> getSignatures(@NonNull PackageManager packageManager, @NonNull String str) {
        Signature[] signatureArr;
        SigningInfo signingInfo;
        if (Build.VERSION.SDK_INT >= 28) {
            signingInfo = packageManager.getPackageInfo(str, C0643C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
            if (u12.m7523d(signingInfo)) {
                signatureArr = u12.m7520a(signingInfo);
            } else {
                signatureArr = u12.m7522c(signingInfo);
            }
        } else {
            signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        }
        if (signatureArr == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(signatureArr);
    }

    public static boolean hasSignatures(@NonNull PackageManager packageManager, @NonNull String str, @NonNull @Size(min = 1) Map<byte[], Integer> map, boolean z) {
        byte[][] bArr;
        if (map.isEmpty()) {
            return false;
        }
        Set<byte[]> keySet = map.keySet();
        for (byte[] bArr2 : keySet) {
            if (bArr2 != null) {
                Integer num = map.get(bArr2);
                if (num != null) {
                    int intValue = num.intValue();
                    if (intValue != 0 && intValue != 1) {
                        throw new IllegalArgumentException("Unsupported certificate type " + num + " when verifying " + str);
                    }
                } else {
                    throw new IllegalArgumentException(AbstractC1726qj.m7038C("Type must be specified for cert when verifying ", str));
                }
            } else {
                throw new IllegalArgumentException(AbstractC1726qj.m7038C("Cert byte array cannot be null when verifying ", str));
            }
        }
        List<Signature> signatures = getSignatures(packageManager, str);
        if (!z && Build.VERSION.SDK_INT >= 28) {
            for (byte[] bArr3 : keySet) {
                if (!u12.m7524e(packageManager, str, bArr3, map.get(bArr3).intValue())) {
                    return false;
                }
            }
            return true;
        }
        if (signatures.size() != 0 && map.size() <= signatures.size() && (!z || map.size() == signatures.size())) {
            if (map.containsValue(1)) {
                bArr = new byte[signatures.size()];
                for (int i = 0; i < signatures.size(); i++) {
                    try {
                        bArr[i] = MessageDigest.getInstance("SHA256").digest(signatures.get(i).toByteArray());
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException("Device doesn't support SHA256 cert checking", e);
                    }
                }
            } else {
                bArr = null;
            }
            Iterator<byte[]> it = keySet.iterator();
            if (it.hasNext()) {
                byte[] next = it.next();
                Integer num2 = map.get(next);
                int intValue2 = num2.intValue();
                if (intValue2 != 0) {
                    if (intValue2 == 1) {
                        for (byte[] bArr4 : bArr) {
                            if (!Arrays.equals(next, bArr4)) {
                            }
                        }
                        return false;
                    }
                    throw new IllegalArgumentException("Unsupported certificate type " + num2);
                }
                if (!signatures.contains(new Signature(next))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
