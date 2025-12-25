package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class yv0 implements Funnel, Serializable {

    /* renamed from: a */
    public final Funnel f29139a;

    public yv0(Funnel funnel) {
        this.f29139a = (Funnel) Preconditions.checkNotNull(funnel);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof yv0) {
            return this.f29139a.equals(((yv0) obj).f29139a);
        }
        return false;
    }

    @Override // com.google.common.hash.Funnel
    public final void funnel(Object obj, PrimitiveSink primitiveSink) {
        Iterator it = ((Iterable) obj).iterator();
        while (it.hasNext()) {
            this.f29139a.funnel(it.next(), primitiveSink);
        }
    }

    public final int hashCode() {
        return yv0.class.hashCode() ^ this.f29139a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f29139a);
        return AbstractC1726qj.m7059o("Funnels.sequentialFunnel(", valueOf, ")", valueOf.length() + 26);
    }
}
