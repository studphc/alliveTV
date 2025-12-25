package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class bw0 implements Funnel, Serializable {

    /* renamed from: a */
    public final Charset f8168a;

    public bw0(Charset charset) {
        this.f8168a = (Charset) Preconditions.checkNotNull(charset);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bw0) {
            return this.f8168a.equals(((bw0) obj).f8168a);
        }
        return false;
    }

    @Override // com.google.common.hash.Funnel
    public final void funnel(Object obj, PrimitiveSink primitiveSink) {
        primitiveSink.putString((CharSequence) obj, this.f8168a);
    }

    public final int hashCode() {
        return bw0.class.hashCode() ^ this.f8168a.hashCode();
    }

    public final String toString() {
        String name = this.f8168a.name();
        return AbstractC1726qj.m7059o("Funnels.stringFunnel(", name, ")", AbstractC1726qj.m7052h(22, name));
    }

    public Object writeReplace() {
        return new aw0(this.f8168a);
    }
}
