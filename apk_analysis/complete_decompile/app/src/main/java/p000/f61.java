package p000;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class f61 implements InvocationHandler {

    /* renamed from: a */
    public final List f17145a;

    /* renamed from: b */
    public boolean f17146b;

    /* renamed from: c */
    public String f17147c;

    public f61(List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        this.f17145a = protocols;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object proxy, Method method, Object[] objArr) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(method, "method");
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (Intrinsics.areEqual(name, "supports") && Intrinsics.areEqual(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(name, "unsupported") && Intrinsics.areEqual(Void.TYPE, returnType)) {
            this.f17146b = true;
            return null;
        }
        boolean areEqual = Intrinsics.areEqual(name, "protocols");
        List list = this.f17145a;
        if (areEqual && objArr.length == 0) {
            return list;
        }
        if ((Intrinsics.areEqual(name, "selectProtocol") || Intrinsics.areEqual(name, "select")) && Intrinsics.areEqual(String.class, returnType) && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof List) {
                if (obj != null) {
                    List list2 = (List) obj;
                    int size = list2.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Object obj2 = list2.get(i);
                            if (obj2 != null) {
                                String str = (String) obj2;
                                if (list.contains(str)) {
                                    this.f17147c = str;
                                    return str;
                                }
                                if (i == size) {
                                    break;
                                }
                                i++;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                    }
                    String str2 = (String) list.get(0);
                    this.f17147c = str2;
                    return str2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
            }
        }
        if ((Intrinsics.areEqual(name, "protocolSelected") || Intrinsics.areEqual(name, "selected")) && objArr.length == 1) {
            Object obj3 = objArr[0];
            if (obj3 != null) {
                this.f17147c = (String) obj3;
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
    }
}
