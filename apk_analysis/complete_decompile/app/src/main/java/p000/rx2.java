package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class rx2 extends ge3 {

    /* renamed from: b */
    public final /* synthetic */ int f26178b;

    /* renamed from: c */
    public final Serializable f26179c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rx2(Serializable serializable, int i) {
        super(6);
        this.f26178b = i;
        this.f26179c = serializable;
    }

    @Override // p000.ge3
    /* renamed from: d */
    public void mo4944d(Class cls) {
        switch (this.f26178b) {
            case 0:
                m4943c(cls.getGenericSuperclass());
                m4943c(cls.getGenericInterfaces());
                return;
            case 1:
            default:
                return;
            case 2:
                ((AtomicReference) this.f26179c).set(cls.getComponentType());
                return;
        }
    }

    @Override // p000.ge3
    /* renamed from: e */
    public void mo4945e(GenericArrayType genericArrayType) {
        switch (this.f26178b) {
            case 1:
                m4943c(genericArrayType.getGenericComponentType());
                return;
            case 2:
                ((AtomicReference) this.f26179c).set(genericArrayType.getGenericComponentType());
                return;
            default:
                return;
        }
    }

    @Override // p000.ge3
    /* renamed from: g */
    public void mo4947g(ParameterizedType parameterizedType) {
        boolean z;
        boolean z2;
        ux2 ux2Var;
        switch (this.f26178b) {
            case 0:
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (typeParameters.length == actualTypeArguments.length) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                for (int i = 0; i < typeParameters.length; i++) {
                    ux2 ux2Var2 = new ux2(typeParameters[i]);
                    Type type = actualTypeArguments[i];
                    HashMap hashMap = (HashMap) this.f26179c;
                    if (!hashMap.containsKey(ux2Var2)) {
                        Type type2 = type;
                        while (true) {
                            if (type2 != null) {
                                boolean z3 = type2 instanceof TypeVariable;
                                if (z3) {
                                    z2 = ux2Var2.m7789a((TypeVariable) type2);
                                } else {
                                    z2 = false;
                                }
                                ux2 ux2Var3 = null;
                                if (z2) {
                                    while (type != null) {
                                        if (type instanceof TypeVariable) {
                                            ux2Var = new ux2((TypeVariable) type);
                                        } else {
                                            ux2Var = null;
                                        }
                                        type = (Type) hashMap.remove(ux2Var);
                                    }
                                } else {
                                    if (z3) {
                                        ux2Var3 = new ux2((TypeVariable) type2);
                                    }
                                    type2 = (Type) hashMap.get(ux2Var3);
                                }
                            } else {
                                hashMap.put(ux2Var2, type);
                            }
                        }
                    }
                }
                m4943c(cls);
                m4943c(parameterizedType.getOwnerType());
                return;
            case 1:
                m4943c(parameterizedType.getActualTypeArguments());
                m4943c(parameterizedType.getOwnerType());
                return;
            default:
                return;
        }
    }

    @Override // p000.ge3
    /* renamed from: h */
    public final void mo4948h(TypeVariable typeVariable) {
        switch (this.f26178b) {
            case 0:
                m4943c(typeVariable.getBounds());
                return;
            case 1:
                String valueOf = String.valueOf(((TypeToken) this.f26179c).f15237a);
                throw new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf.length() + 58, valueOf, "contains a type variable and is not safe for the operation"));
            default:
                ((AtomicReference) this.f26179c).set(mz2.m6264a(typeVariable.getBounds()));
                return;
        }
    }

    @Override // p000.ge3
    /* renamed from: i */
    public final void mo4949i(WildcardType wildcardType) {
        switch (this.f26178b) {
            case 0:
                m4943c(wildcardType.getUpperBounds());
                return;
            case 1:
                m4943c(wildcardType.getLowerBounds());
                m4943c(wildcardType.getUpperBounds());
                return;
            default:
                ((AtomicReference) this.f26179c).set(mz2.m6264a(wildcardType.getUpperBounds()));
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rx2() {
        super(6);
        this.f26178b = 0;
        this.f26179c = Maps.newHashMap();
    }
}
