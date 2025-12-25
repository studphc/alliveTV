package p000;

import com.google.common.base.Predicate;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class y62 implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f28849a;

    public y62(Object obj) {
        this.f28849a = obj;
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return this.f28849a.equals(obj);
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (obj instanceof y62) {
            return this.f28849a.equals(((y62) obj).f28849a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f28849a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f28849a);
        return AbstractC1726qj.m7059o("Predicates.equalTo(", valueOf, ")", valueOf.length() + 20);
    }
}
