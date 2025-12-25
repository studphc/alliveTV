package p000;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class i72 extends Optional {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f18330a;

    public i72(Object obj) {
        this.f18330a = obj;
    }

    @Override // com.google.common.base.Optional
    public final Set asSet() {
        return Collections.singleton(this.f18330a);
    }

    @Override // com.google.common.base.Optional
    public final boolean equals(Object obj) {
        if (obj instanceof i72) {
            return this.f18330a.equals(((i72) obj).f18330a);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public final Object get() {
        return this.f18330a;
    }

    @Override // com.google.common.base.Optional
    public final int hashCode() {
        return this.f18330a.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public final boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public final Object mo3773or(Object obj) {
        Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.f18330a;
    }

    @Override // com.google.common.base.Optional
    public final Object orNull() {
        return this.f18330a;
    }

    @Override // com.google.common.base.Optional
    public final String toString() {
        String valueOf = String.valueOf(this.f18330a);
        return AbstractC1726qj.m7059o("Optional.of(", valueOf, ")", valueOf.length() + 13);
    }

    @Override // com.google.common.base.Optional
    public final Optional transform(Function function) {
        return new i72(Preconditions.checkNotNull(function.apply(this.f18330a), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public final Optional mo3771or(Optional optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public final Object mo3772or(Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        return this.f18330a;
    }
}
