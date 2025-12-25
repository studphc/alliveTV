package p000;

import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public class sr2 extends gr2 implements Set {
    private static final long serialVersionUID = 0;

    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.f25273b) {
            equals = mo4086e().equals(obj);
        }
        return equals;
    }

    @Override // p000.gr2
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Set mo4086e() {
        return (Set) ((Collection) this.f25272a);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int hashCode;
        synchronized (this.f25273b) {
            hashCode = mo4086e().hashCode();
        }
        return hashCode;
    }
}
