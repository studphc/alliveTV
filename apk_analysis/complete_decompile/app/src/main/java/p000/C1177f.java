package p000;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Collections;
import java.util.Set;

/* renamed from: f */
/* loaded from: classes.dex */
public final class C1177f extends Optional {

    /* renamed from: a */
    public static final C1177f f17048a = new Object();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f17048a;
    }

    @Override // com.google.common.base.Optional
    public final Set asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public final Object get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public final int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public final boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public final Object mo3773or(Object obj) {
        return Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.common.base.Optional
    public final Object orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.common.base.Optional
    public final Optional transform(Function function) {
        Preconditions.checkNotNull(function);
        return Optional.absent();
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public final Optional mo3771or(Optional optional) {
        return (Optional) Preconditions.checkNotNull(optional);
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public final Object mo3772or(Supplier supplier) {
        return Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
