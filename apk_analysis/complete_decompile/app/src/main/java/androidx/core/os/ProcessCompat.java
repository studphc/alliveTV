package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.Method;
import p000.m72;
import p000.yy2;

/* loaded from: classes.dex */
public final class ProcessCompat {
    public static boolean isApplicationUid(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return m72.m6089a(i);
        }
        try {
            synchronized (yy2.f29189m) {
                try {
                    if (!yy2.f29191o) {
                        yy2.f29191o = true;
                        yy2.f29190n = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                    }
                } finally {
                }
            }
            Method method = yy2.f29190n;
            if (method == null) {
                return true;
            }
            Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i));
            if (bool != null) {
                return bool.booleanValue();
            }
            throw new NullPointerException();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
