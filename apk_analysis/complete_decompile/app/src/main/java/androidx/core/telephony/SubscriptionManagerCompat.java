package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000.hq2;

@RequiresApi(22)
/* loaded from: classes.dex */
public class SubscriptionManagerCompat {

    /* renamed from: a */
    public static Method f3770a;

    public static int getSlotIndex(int i) {
        if (i == -1) {
            return -1;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return hq2.m5123a(i);
        }
        try {
            if (f3770a == null) {
                if (i2 >= 26) {
                    f3770a = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE);
                } else {
                    f3770a = SubscriptionManager.class.getDeclaredMethod("getSlotId", Integer.TYPE);
                }
                f3770a.setAccessible(true);
            }
            Integer num = (Integer) f3770a.invoke(null, Integer.valueOf(i));
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
