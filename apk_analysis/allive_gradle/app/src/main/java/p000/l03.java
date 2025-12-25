package p000;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class l03 extends UnsafeAllocator {

    /* renamed from: a */
    public final /* synthetic */ Method f22275a;

    public l03(Method method) {
        this.f22275a = method;
    }

    @Override // com.google.gson.internal.UnsafeAllocator
    public final Object newInstance(Class cls) {
        String m4417a = ConstructorConstructor.m4417a(cls);
        if (m4417a == null) {
            return this.f22275a.invoke(null, cls, Object.class);
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(m4417a));
    }
}
