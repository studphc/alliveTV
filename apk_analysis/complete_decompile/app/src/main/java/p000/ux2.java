package p000;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.lang.reflect.TypeVariable;

/* loaded from: classes2.dex */
public final class ux2 {

    /* renamed from: a */
    public final TypeVariable f27524a;

    public ux2(TypeVariable typeVariable) {
        this.f27524a = (TypeVariable) Preconditions.checkNotNull(typeVariable);
    }

    /* renamed from: a */
    public final boolean m7789a(TypeVariable typeVariable) {
        TypeVariable typeVariable2 = this.f27524a;
        if (typeVariable2.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && typeVariable2.getName().equals(typeVariable.getName())) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ux2) {
            return m7789a(((ux2) obj).f27524a);
        }
        return false;
    }

    public final int hashCode() {
        TypeVariable typeVariable = this.f27524a;
        return Objects.hashCode(typeVariable.getGenericDeclaration(), typeVariable.getName());
    }

    public final String toString() {
        return this.f27524a.toString();
    }
}
