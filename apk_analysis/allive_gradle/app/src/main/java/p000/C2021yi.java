package p000;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;

/* renamed from: yi */
/* loaded from: classes.dex */
public final class C2021yi extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Function f28962a;

    /* renamed from: b */
    public final Ordering f28963b;

    public C2021yi(Function function, Ordering ordering) {
        this.f28962a = (Function) Preconditions.checkNotNull(function);
        this.f28963b = (Ordering) Preconditions.checkNotNull(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Function function = this.f28962a;
        return this.f28963b.compare(function.apply(obj), function.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2021yi)) {
            return false;
        }
        C2021yi c2021yi = (C2021yi) obj;
        if (this.f28962a.equals(c2021yi.f28962a) && this.f28963b.equals(c2021yi.f28963b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f28962a, this.f28963b);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f28963b);
        String valueOf2 = String.valueOf(this.f28962a);
        return AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 13, valueOf, ".onResultOf(", valueOf2, ")");
    }
}
