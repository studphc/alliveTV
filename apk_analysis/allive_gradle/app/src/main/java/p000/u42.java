package p000;

import java.lang.reflect.Method;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class u42 {

    /* renamed from: a */
    public static final Method f27103a;

    /* renamed from: b */
    public static final Method f27104b;

    static {
        Method method;
        Method method2;
        Method[] throwableMethods = Throwable.class.getMethods();
        Intrinsics.checkNotNullExpressionValue(throwableMethods, "throwableMethods");
        int length = throwableMethods.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            method = null;
            if (i2 < length) {
                method2 = throwableMethods[i2];
                if (Intrinsics.areEqual(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (Intrinsics.areEqual(ArraysKt___ArraysKt.singleOrNull(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i2++;
            } else {
                method2 = null;
                break;
            }
        }
        f27103a = method2;
        int length2 = throwableMethods.length;
        while (true) {
            if (i >= length2) {
                break;
            }
            Method method3 = throwableMethods[i];
            if (Intrinsics.areEqual(method3.getName(), "getSuppressed")) {
                method = method3;
                break;
            }
            i++;
        }
        f27104b = method;
    }
}
