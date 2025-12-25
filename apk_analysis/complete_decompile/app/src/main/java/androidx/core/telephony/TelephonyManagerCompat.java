package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000.js2;
import p000.ks2;
import p000.ls2;

/* loaded from: classes.dex */
public class TelephonyManagerCompat {

    /* renamed from: a */
    public static Method f3771a;

    @Nullable
    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"MissingPermission"})
    public static String getImei(@NonNull TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ks2.m5787a(telephonyManager);
        }
        int subscriptionId = getSubscriptionId(telephonyManager);
        if (subscriptionId != Integer.MAX_VALUE && subscriptionId != -1) {
            return js2.m5458a(telephonyManager, SubscriptionManagerCompat.getSlotIndex(subscriptionId));
        }
        return telephonyManager.getDeviceId();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getSubscriptionId(@NonNull TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return ls2.m5982a(telephonyManager);
        }
        try {
            if (f3771a == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", null);
                f3771a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) f3771a.invoke(telephonyManager, null);
            if (num != null && num.intValue() != -1) {
                return num.intValue();
            }
            return Integer.MAX_VALUE;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }
}
