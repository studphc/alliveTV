package p000;

import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.reflect.ReflectionHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* renamed from: nv */
/* loaded from: classes2.dex */
public final class C1599nv implements ObjectConstructor {

    /* renamed from: a */
    public final /* synthetic */ Constructor f23504a;

    public C1599nv(Constructor constructor) {
        this.f23504a = constructor;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        Constructor constructor = this.f23504a;
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e) {
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e3.getCause());
        }
    }
}
