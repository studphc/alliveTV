package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class g72 implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Class f17572a;

    public g72(Class cls) {
        this.f17572a = (Class) Preconditions.checkNotNull(cls);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return this.f17572a.isAssignableFrom((Class) obj);
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (!(obj instanceof g72) || this.f17572a != ((g72) obj).f17572a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f17572a.hashCode();
    }

    public final String toString() {
        String name = this.f17572a.getName();
        return AbstractC1726qj.m7059o("Predicates.subtypeOf(", name, ")", name.length() + 22);
    }
}
