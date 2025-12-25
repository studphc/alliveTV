package p000;

import com.google.common.collect.ImmutableMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;

/* loaded from: classes2.dex */
public final class kz2 implements InvocationHandler {

    /* renamed from: b */
    public static final ImmutableMap f22258b;

    /* renamed from: a */
    public final jz2 f22259a;

    static {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (Method method : jz2.class.getMethods()) {
            if (method.getDeclaringClass().equals(jz2.class)) {
                try {
                    method.setAccessible(true);
                } catch (AccessControlException unused) {
                }
                builder.put(method.getName(), method);
            }
        }
        f22258b = builder.buildKeepingLast();
    }

    public kz2(jz2 jz2Var) {
        this.f22259a = jz2Var;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        Method method2 = (Method) f22258b.get(name);
        if (method2 != null) {
            try {
                return method2.invoke(this.f22259a, objArr);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }
        throw new UnsupportedOperationException(name);
    }
}
