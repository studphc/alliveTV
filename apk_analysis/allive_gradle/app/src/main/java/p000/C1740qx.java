package p000;

import com.google.common.collect.BoundType;
import com.google.common.collect.DiscreteDomain;
import java.util.NoSuchElementException;

/* renamed from: qx */
/* loaded from: classes.dex */
public final class C1740qx extends AbstractC1814sx {

    /* renamed from: b */
    public static final C1740qx f25786b = new AbstractC1814sx("");
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f25786b;
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: b */
    public final AbstractC1814sx mo6933b(DiscreteDomain discreteDomain) {
        try {
            return AbstractC1814sx.m7422a(discreteDomain.minValue());
        } catch (NoSuchElementException unused) {
            return this;
        }
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: c */
    public final int compareTo(AbstractC1814sx abstractC1814sx) {
        if (abstractC1814sx == this) {
            return 0;
        }
        return -1;
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: d */
    public final void mo6737d(StringBuilder sb) {
        sb.append("(-∞");
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: e */
    public final void mo6738e(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: f */
    public final Comparable mo6739f() {
        throw new IllegalStateException("range unbounded on this side");
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: g */
    public final Comparable mo6740g(DiscreteDomain discreteDomain) {
        throw new AssertionError();
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: h */
    public final boolean mo6741h(Comparable comparable) {
        return true;
    }

    @Override // p000.AbstractC1814sx
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: i */
    public final Comparable mo6742i(DiscreteDomain discreteDomain) {
        return discreteDomain.minValue();
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: j */
    public final BoundType mo6743j() {
        throw new IllegalStateException();
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: k */
    public final BoundType mo6744k() {
        throw new AssertionError("this statement should be unreachable");
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: l */
    public final AbstractC1814sx mo6745l(BoundType boundType, DiscreteDomain discreteDomain) {
        throw new IllegalStateException();
    }

    @Override // p000.AbstractC1814sx
    /* renamed from: m */
    public final AbstractC1814sx mo6746m(BoundType boundType, DiscreteDomain discreteDomain) {
        throw new AssertionError("this statement should be unreachable");
    }

    public final String toString() {
        return "-∞";
    }
}
