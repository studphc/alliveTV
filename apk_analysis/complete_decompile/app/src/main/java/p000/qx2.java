package p000;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeResolver;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class qx2 extends ge3 {

    /* renamed from: b */
    public final /* synthetic */ HashMap f25796b;

    /* renamed from: c */
    public final /* synthetic */ Type f25797c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx2(HashMap hashMap, Type type) {
        super(6);
        this.f25796b = hashMap;
        this.f25797c = type;
    }

    @Override // p000.ge3
    /* renamed from: d */
    public final void mo4944d(Class cls) {
        Type type = this.f25797c;
        if (type instanceof WildcardType) {
            return;
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(type);
        throw new IllegalArgumentException(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 25, "No type mapping from ", valueOf, " to ", valueOf2));
    }

    @Override // p000.ge3
    /* renamed from: e */
    public final void mo4945e(GenericArrayType genericArrayType) {
        boolean z;
        Type type = this.f25797c;
        if (type instanceof WildcardType) {
            return;
        }
        Type m6267d = mz2.m6267d(type);
        if (m6267d != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "%s is not an array type.", type);
        TypeResolver.m4285a(this.f25796b, genericArrayType.getGenericComponentType(), m6267d);
    }

    @Override // p000.ge3
    /* renamed from: g */
    public final void mo4947g(ParameterizedType parameterizedType) {
        boolean z;
        Type type = this.f25797c;
        if (type instanceof WildcardType) {
            return;
        }
        try {
            ParameterizedType parameterizedType2 = (ParameterizedType) ParameterizedType.class.cast(type);
            Type ownerType = parameterizedType.getOwnerType();
            HashMap hashMap = this.f25796b;
            if (ownerType != null && parameterizedType2.getOwnerType() != null) {
                TypeResolver.m4285a(hashMap, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            Preconditions.checkArgument(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, type);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            if (actualTypeArguments.length == actualTypeArguments2.length) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i = 0; i < actualTypeArguments.length; i++) {
                TypeResolver.m4285a(hashMap, actualTypeArguments[i], actualTypeArguments2[i]);
            }
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(type);
            throw new IllegalArgumentException(AbstractC1726qj.m7054j(valueOf.length() + 27, valueOf, " is not a ParameterizedType"));
        }
    }

    @Override // p000.ge3
    /* renamed from: h */
    public final void mo4948h(TypeVariable typeVariable) {
        this.f25796b.put(new ux2(typeVariable), this.f25797c);
    }

    @Override // p000.ge3
    /* renamed from: i */
    public final void mo4949i(WildcardType wildcardType) {
        boolean z;
        HashMap hashMap;
        Type type = this.f25797c;
        if (!(type instanceof WildcardType)) {
            return;
        }
        WildcardType wildcardType2 = (WildcardType) type;
        Type[] upperBounds = wildcardType.getUpperBounds();
        Type[] upperBounds2 = wildcardType2.getUpperBounds();
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Type[] lowerBounds2 = wildcardType2.getLowerBounds();
        if (upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Incompatible type: %s vs. %s", wildcardType, type);
        int i = 0;
        while (true) {
            int length = upperBounds.length;
            hashMap = this.f25796b;
            if (i >= length) {
                break;
            }
            TypeResolver.m4285a(hashMap, upperBounds[i], upperBounds2[i]);
            i++;
        }
        for (int i2 = 0; i2 < lowerBounds.length; i2++) {
            TypeResolver.m4285a(hashMap, lowerBounds[i2], lowerBounds2[i2]);
        }
    }
}
