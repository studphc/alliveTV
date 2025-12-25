package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000.v03;

/* loaded from: classes.dex */
public class UserHandleCompat {

    /* renamed from: a */
    public static Method f3717a;

    /* renamed from: b */
    public static Constructor f3718b;

    /* renamed from: a */
    public static Method m877a() {
        if (f3717a == null) {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("getUserId", Integer.TYPE);
            f3717a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f3717a;
    }

    /* renamed from: b */
    public static Constructor m878b() {
        if (f3718b == null) {
            Constructor declaredConstructor = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
            f3718b = declaredConstructor;
            declaredConstructor.setAccessible(true);
        }
        return f3718b;
    }

    @NonNull
    public static UserHandle getUserHandleForUid(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return v03.m7805a(i);
        }
        try {
            return (UserHandle) m878b().newInstance((Integer) m877a().invoke(null, Integer.valueOf(i)));
        } catch (IllegalAccessException e) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e);
            throw illegalAccessError;
        } catch (InstantiationException e2) {
            InstantiationError instantiationError = new InstantiationError();
            instantiationError.initCause(e2);
            throw instantiationError;
        } catch (NoSuchMethodException e3) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e3);
            throw noSuchMethodError;
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }
}
