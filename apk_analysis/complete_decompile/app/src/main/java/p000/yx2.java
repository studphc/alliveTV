package p000;

import com.google.common.base.Joiner;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public final class yx2 extends f51 {

    /* renamed from: e */
    public final /* synthetic */ TypeToken f29168e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx2(TypeToken typeToken, Constructor constructor) {
        super(constructor);
        this.f29168e = typeToken;
    }

    @Override // p000.f51, com.google.common.reflect.Invokable
    /* renamed from: a */
    public final Type[] mo4280a() {
        TypeResolver m4295e = this.f29168e.m4295e();
        Type[] genericExceptionTypes = ((Constructor) this.f17128d).getGenericExceptionTypes();
        m4295e.m4287c(genericExceptionTypes);
        return genericExceptionTypes;
    }

    @Override // p000.f51, com.google.common.reflect.Invokable
    /* renamed from: b */
    public final Type[] mo4281b() {
        TypeResolver m4296f = this.f29168e.m4296f();
        Type[] mo4281b = super.mo4281b();
        m4296f.m4287c(mo4281b);
        return mo4281b;
    }

    @Override // p000.f51, com.google.common.reflect.Invokable
    /* renamed from: c */
    public final Type mo4282c() {
        return this.f29168e.m4295e().resolveType(super.mo4282c());
    }

    @Override // com.google.common.reflect.Invokable
    public final TypeToken getOwnerType() {
        return this.f29168e;
    }

    @Override // com.google.common.reflect.Invokable
    public final String toString() {
        String valueOf = String.valueOf(this.f29168e);
        String join = Joiner.m3766on(", ").join(mo4281b());
        return AbstractC1726qj.m7055k(AbstractC1726qj.m7052h(valueOf.length() + 2, join), valueOf, "(", join, ")");
    }
}
