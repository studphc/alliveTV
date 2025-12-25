package p000;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public final class t62 implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final List f26708a;

    public t62(List list) {
        this.f26708a = list;
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        int i = 0;
        while (true) {
            List list = this.f26708a;
            if (i < list.size()) {
                if (!((Predicate) list.get(i)).apply(obj)) {
                    return false;
                }
                i++;
            } else {
                return true;
            }
        }
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (obj instanceof t62) {
            return this.f26708a.equals(((t62) obj).f26708a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f26708a.hashCode() + 306654252;
    }

    public final String toString() {
        return Predicates.m3775a("and", this.f26708a);
    }
}
