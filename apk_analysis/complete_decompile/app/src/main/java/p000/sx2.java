package p000;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes2.dex */
public final class sx2 extends tx2 {

    /* renamed from: b */
    public final /* synthetic */ TypeVariable f26611b;

    /* renamed from: c */
    public final /* synthetic */ tx2 f26612c;

    public sx2(TypeVariable typeVariable, tx2 tx2Var) {
        this.f26611b = typeVariable;
        this.f26612c = tx2Var;
    }

    @Override // p000.tx2
    /* renamed from: a */
    public final Type mo7423a(TypeVariable typeVariable, sx2 sx2Var) {
        if (typeVariable.getGenericDeclaration().equals(this.f26611b.getGenericDeclaration())) {
            return typeVariable;
        }
        return this.f26612c.mo7423a(typeVariable, sx2Var);
    }
}
