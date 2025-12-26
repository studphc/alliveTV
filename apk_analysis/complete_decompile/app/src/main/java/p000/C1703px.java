package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

/* renamed from: px */
/* loaded from: classes.dex */
public final class C1703px extends AbstractC1814sx {
    private static final long serialVersionUID = 0;

    public C1703px(Comparable comparable) {
        super((Comparable) Preconditions.checkNotNull(comparable));
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: b */
    public final AbstractC1814sx mo6933b(DiscreteDomain discreteDomain) {
        Comparable next = discreteDomain.next(this.f26609a);
        if (next != null) {
            return AbstractC1814sx.m7422a(next);
        }
        return C1666ox.f24940b;
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: d */
    public final void mo6737d(StringBuilder sb) {
        sb.append('(');
        sb.append(this.f26609a);
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: e */
    public final void mo6738e(StringBuilder sb) {
        sb.append(this.f26609a);
        sb.append(']');
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: g */
    public final Comparable mo6740g(DiscreteDomain discreteDomain) {
        return this.f26609a;
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: h */
    public final boolean mo6741h(Comparable comparable) {
        Range range = Range.f14746c;
        if (this.f26609a.compareTo(comparable) < 0) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1814sx
    public final int hashCode() {
        return ~this.f26609a.hashCode();
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: i */
    public final Comparable mo6742i(DiscreteDomain discreteDomain) {
        return discreteDomain.next(this.f26609a);
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: j */
    public final BoundType mo6743j() {
        return BoundType.OPEN;
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: k */
    public final BoundType mo6744k() {
        return BoundType.CLOSED;
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: l */
    public final AbstractC1814sx mo6745l(BoundType boundType, DiscreteDomain discreteDomain) {
        int i = AbstractC1601nx.f23519a[boundType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this;
            }
            throw new AssertionError();
        }
        Comparable next = discreteDomain.next(this.f26609a);
        if (next == null) {
            return C1740qx.f25786b;
        }
        return AbstractC1814sx.m7422a(next);
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: m */
    public final AbstractC1814sx mo6746m(BoundType boundType, DiscreteDomain discreteDomain) {
        int i = AbstractC1601nx.f23519a[boundType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                Comparable next = discreteDomain.next(this.f26609a);
                if (next == null) {
                    return C1666ox.f24940b;
                }
                return AbstractC1814sx.m7422a(next);
            }
            throw new AssertionError();
        }
        return this;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f26609a);
        return AbstractC1726qj.m7059o("/", valueOf, "\\", valueOf.length() + 2);
    }
}
