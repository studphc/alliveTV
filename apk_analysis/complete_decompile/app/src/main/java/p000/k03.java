package p000;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class k03 extends UnsafeAllocator {

    /* renamed from: a */
    public final /* synthetic */ Method f20711a;

    /* renamed from: b */
    public final /* synthetic */ int f20712b;

    public k03(int i, Method method) {
        this.f20711a = method;
        this.f20712b = i;
    }

    @Override // com.google.gson.internal.UnsafeAllocator
    public final Object newInstance(Class cls) {
        String m4417a = ConstructorConstructor.m4417a(cls);
        if (m4417a == null) {
            return this.f20711a.invoke(null, cls, Integer.valueOf(this.f20712b));
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(m4417a));
    }
}
