package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class z62 implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Predicate f29259a;

    public z62(Predicate predicate) {
        this.f29259a = (Predicate) Preconditions.checkNotNull(predicate);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return !this.f29259a.apply(obj);
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (obj instanceof z62) {
            return this.f29259a.equals(((z62) obj).f29259a);
        }
        return false;
    }

    public final int hashCode() {
        return ~this.f29259a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f29259a);
        return AbstractC1726qj.m7059o("Predicates.not(", valueOf, ")", valueOf.length() + 16);
    }
}
