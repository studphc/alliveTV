package p000;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;

/* loaded from: classes.dex */
public abstract class ks2 {
    @SuppressLint({"MissingPermission"})
    @Nullable
    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @DoNotInline
    /* renamed from: a */
    public static String m5787a(TelephonyManager telephonyManager) {
        return telephonyManager.getImei();
    }
}
