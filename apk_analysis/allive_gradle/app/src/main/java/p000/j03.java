package p000;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class j03 extends UnsafeAllocator {

    /* renamed from: a */
    public final /* synthetic */ Method f20334a;

    /* renamed from: b */
    public final /* synthetic */ Object f20335b;

    public j03(Method method, Object obj) {
        this.f20334a = method;
        this.f20335b = obj;
    }

    @Override // com.google.gson.internal.UnsafeAllocator
    public final Object newInstance(Class cls) {
        String m4417a = ConstructorConstructor.m4417a(cls);
        if (m4417a == null) {
            return this.f20334a.invoke(this.f20335b, cls);
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(m4417a));
    }
}
