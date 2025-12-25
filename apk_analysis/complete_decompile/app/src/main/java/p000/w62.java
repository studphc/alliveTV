package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.util.Collection;

/* loaded from: classes.dex */
public final class w62 implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Collection f28084a;

    public w62(Collection collection) {
        this.f28084a = (Collection) Preconditions.checkNotNull(collection);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        try {
            return this.f28084a.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (obj instanceof w62) {
            return this.f28084a.equals(((w62) obj).f28084a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f28084a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f28084a);
        return AbstractC1726qj.m7059o("Predicates.in(", valueOf, ")", valueOf.length() + 15);
    }
}
