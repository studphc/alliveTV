package p000;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* renamed from: q5 */
/* loaded from: classes.dex */
public abstract class AbstractC1712q5 {

    /* renamed from: a */
    public static final Class f25446a;

    /* renamed from: b */
    public static final Field f25447b;

    /* renamed from: c */
    public static final Field f25448c;

    /* renamed from: d */
    public static final Method f25449d;

    /* renamed from: e */
    public static final Method f25450e;

    /* renamed from: f */
    public static final Method f25451f;

    /* renamed from: g */
    public static final Handler f25452g = new Handler(Looper.getMainLooper());

    /* JADX WARN: Can't wrap try/catch for region: R(21:1|(2:2|3)|4|5|6|7|8|9|10|(12:33|34|13|(6:29|30|16|(3:24|25|26)|20|21)|15|16|(1:18)|24|25|26|20|21)|12|13|(0)|15|16|(0)|24|25|26|20|21) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Class<?> cls;
        Field field;
        Field field2;
        Method declaredMethod;
        Class cls2;
        Method declaredMethod2;
        Class cls3;
        int i;
        Method method = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        f25446a = cls;
        try {
            field = Activity.class.getDeclaredField("mMainThread");
            field.setAccessible(true);
        } catch (Throwable unused2) {
            field = null;
        }
        f25447b = field;
        try {
            field2 = Activity.class.getDeclaredField("mToken");
            field2.setAccessible(true);
        } catch (Throwable unused3) {
            field2 = null;
        }
        f25448c = field2;
        Class cls4 = f25446a;
        if (cls4 != null) {
            try {
                declaredMethod = cls4.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
            }
            f25449d = declaredMethod;
            cls2 = f25446a;
            if (cls2 != null) {
                try {
                    declaredMethod2 = cls2.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                    declaredMethod2.setAccessible(true);
                } catch (Throwable unused5) {
                }
                f25450e = declaredMethod2;
                cls3 = f25446a;
                i = Build.VERSION.SDK_INT;
                if ((i != 26 || i == 27) && cls3 != null) {
                    Class<?> cls5 = Boolean.TYPE;
                    Method declaredMethod3 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls5, Configuration.class, Configuration.class, cls5, cls5);
                    declaredMethod3.setAccessible(true);
                    method = declaredMethod3;
                }
                f25451f = method;
            }
            declaredMethod2 = null;
            f25450e = declaredMethod2;
            cls3 = f25446a;
            i = Build.VERSION.SDK_INT;
            if (i != 26) {
            }
            Class<?> cls52 = Boolean.TYPE;
            Method declaredMethod32 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls52, Configuration.class, Configuration.class, cls52, cls52);
            declaredMethod32.setAccessible(true);
            method = declaredMethod32;
            f25451f = method;
        }
        declaredMethod = null;
        f25449d = declaredMethod;
        cls2 = f25446a;
        if (cls2 != null) {
        }
        declaredMethod2 = null;
        f25450e = declaredMethod2;
        cls3 = f25446a;
        i = Build.VERSION.SDK_INT;
        if (i != 26) {
        }
        Class<?> cls522 = Boolean.TYPE;
        Method declaredMethod322 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls522, Configuration.class, Configuration.class, cls522, cls522);
        declaredMethod322.setAccessible(true);
        method = declaredMethod322;
        f25451f = method;
    }
}
