package p000;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* loaded from: classes2.dex */
public final class zx2 extends ge3 {

    /* renamed from: b */
    public final /* synthetic */ ImmutableSet.Builder f29559b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zx2(ImmutableSet.Builder builder) {
        super(6);
        this.f29559b = builder;
    }

    @Override // p000.ge3
    /* renamed from: d */
    public final void mo4944d(Class cls) {
        this.f29559b.add((ImmutableSet.Builder) cls);
    }

    @Override // p000.ge3
    /* renamed from: e */
    public final void mo4945e(GenericArrayType genericArrayType) {
        Class<? super Object> rawType = TypeToken.m4294of(genericArrayType.getGenericComponentType()).getRawType();
        Joiner joiner = mz2.f23181a;
        this.f29559b.add((ImmutableSet.Builder) Array.newInstance(rawType, 0).getClass());
    }

    @Override // p000.ge3
    /* renamed from: g */
    public final void mo4947g(ParameterizedType parameterizedType) {
        this.f29559b.add((ImmutableSet.Builder) parameterizedType.getRawType());
    }

    @Override // p000.ge3
    /* renamed from: h */
    public final void mo4948h(TypeVariable typeVariable) {
        m4943c(typeVariable.getBounds());
    }

    @Override // p000.ge3
    /* renamed from: i */
    public final void mo4949i(WildcardType wildcardType) {
        m4943c(wildcardType.getUpperBounds());
    }
}
