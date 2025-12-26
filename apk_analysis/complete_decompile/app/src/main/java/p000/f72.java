package p000;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public final class f72 implements Predicate, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final List f17161a;

    public f72(List list) {
        this.f17161a = list;
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        int i = 0;
        while (true) {
            List list = this.f17161a;
            if (i >= list.size()) {
                return false;
            }
            if (((Predicate) list.get(i)).apply(obj)) {
                return true;
            }
            i++;
        }
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (obj instanceof f72) {
            return this.f17161a.equals(((f72) obj).f17161a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f17161a.hashCode() + 87855567;
    }

    public final String toString() {
        return Predicates.m3775a("or", this.f17161a);
    }
}
