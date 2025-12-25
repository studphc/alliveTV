package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class sv0 implements Function, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Predicate f26581a;

    public sv0(Predicate predicate) {
        this.f26581a = (Predicate) Preconditions.checkNotNull(predicate);
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f26581a.apply(obj));
    }

    @Override // com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (obj instanceof sv0) {
            return this.f26581a.equals(((sv0) obj).f26581a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f26581a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f26581a);
        return AbstractC1726qj.m7059o("Functions.forPredicate(", valueOf, ")", valueOf.length() + 24);
    }
}
