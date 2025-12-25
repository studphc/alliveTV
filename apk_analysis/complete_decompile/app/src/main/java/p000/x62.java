package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class x62 implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Class f28449a;

    public x62(Class cls) {
        this.f28449a = (Class) Preconditions.checkNotNull(cls);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return this.f28449a.isInstance(obj);
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (!(obj instanceof x62) || this.f28449a != ((x62) obj).f28449a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f28449a.hashCode();
    }

    public final String toString() {
        String name = this.f28449a.getName();
        return AbstractC1726qj.m7059o("Predicates.instanceOf(", name, ")", name.length() + 23);
    }
}
