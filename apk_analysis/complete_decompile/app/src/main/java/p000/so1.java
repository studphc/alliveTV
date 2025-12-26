package p000;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class so1 {

    /* renamed from: a */
    public Method f26506a;

    /* renamed from: b */
    public Method f26507b;

    /* renamed from: c */
    public Method f26508c;

    public so1(Method method, Method method2, Method method3) {
        this.f26506a = method;
        this.f26507b = method2;
        this.f26508c = method3;
    }

    /* renamed from: a */
    public static void m7394a() {
        if (Build.VERSION.SDK_INT < 29) {
        } else {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
