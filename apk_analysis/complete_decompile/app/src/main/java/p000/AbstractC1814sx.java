package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Booleans;
import java.io.Serializable;

/* renamed from: sx */
/* loaded from: classes.dex */
public abstract class AbstractC1814sx implements Comparable, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Comparable f26609a;

    public AbstractC1814sx(Comparable comparable) {
        this.f26609a = comparable;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [sx, rx] */
    /* renamed from: a */
    public static C1777rx m7422a(Comparable comparable) {
        return new AbstractC1814sx((Comparable) Preconditions.checkNotNull(comparable));
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC1814sx abstractC1814sx) {
        if (abstractC1814sx == C1740qx.f25786b) {
            return 1;
        }
        if (abstractC1814sx == C1666ox.f24940b) {
            return -1;
        }
        Comparable comparable = abstractC1814sx.f26609a;
        Range range = Range.f14746c;
        int compareTo = this.f26609a.compareTo(comparable);
        if (compareTo != 0) {
            return compareTo;
        }
        return Booleans.compare(this instanceof C1703px, abstractC1814sx instanceof C1703px);
    }

    /* renamed from: d */
    public abstract void mo6737d(StringBuilder sb);

    /* renamed from: e */
    public abstract void mo6738e(StringBuilder sb);

    public final boolean equals(Object obj) {
        if (!(obj instanceof AbstractC1814sx)) {
            return false;
        }
        try {
            if (compareTo((AbstractC1814sx) obj) != 0) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* renamed from: f */
    public Comparable mo6739f() {
        return this.f26609a;
    }

    /* renamed from: g */
    public abstract Comparable mo6740g(DiscreteDomain discreteDomain);

    /* renamed from: h */
    public abstract boolean mo6741h(Comparable comparable);

    public abstract int hashCode();

    /* renamed from: i */
    public abstract Comparable mo6742i(DiscreteDomain discreteDomain);

    /* renamed from: j */
    public abstract BoundType mo6743j();

    /* renamed from: k */
    public abstract BoundType mo6744k();

    /* renamed from: l */
    public abstract AbstractC1814sx mo6745l(BoundType boundType, DiscreteDomain discreteDomain);

    /* renamed from: m */
    public abstract AbstractC1814sx mo6746m(BoundType boundType, DiscreteDomain discreteDomain);

    /* renamed from: b */
    public AbstractC1814sx mo6933b(DiscreteDomain discreteDomain) {
        return this;
    }
}
