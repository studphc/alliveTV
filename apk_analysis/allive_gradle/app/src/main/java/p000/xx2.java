package p000;

import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public final class xx2 extends f51 {

    /* renamed from: e */
    public final /* synthetic */ TypeToken f28763e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xx2(TypeToken typeToken, Method method) {
        super(method);
        this.f28763e = typeToken;
    }

    @Override // p000.f51, com.google.common.reflect.Invokable
    /* renamed from: a */
    public final Type[] mo4280a() {
        TypeResolver m4295e = this.f28763e.m4295e();
        Type[] genericExceptionTypes = ((Method) this.f17128d).getGenericExceptionTypes();
        m4295e.m4287c(genericExceptionTypes);
        return genericExceptionTypes;
    }

    @Override // p000.f51, com.google.common.reflect.Invokable
    /* renamed from: b */
    public final Type[] mo4281b() {
        TypeResolver m4296f = this.f28763e.m4296f();
        Type[] genericParameterTypes = ((Method) this.f17128d).getGenericParameterTypes();
        m4296f.m4287c(genericParameterTypes);
        return genericParameterTypes;
    }

    @Override // p000.f51, com.google.common.reflect.Invokable
    /* renamed from: c */
    public final Type mo4282c() {
        return this.f28763e.m4295e().resolveType(((Method) this.f17128d).getGenericReturnType());
    }

    @Override // com.google.common.reflect.Invokable
    public final TypeToken getOwnerType() {
        return this.f28763e;
    }

    @Override // com.google.common.reflect.Invokable
    public final String toString() {
        String valueOf = String.valueOf(this.f28763e);
        String invokable = super.toString();
        return AbstractC1726qj.m7059o(valueOf, ".", invokable, AbstractC1726qj.m7052h(valueOf.length() + 1, invokable));
    }
}
