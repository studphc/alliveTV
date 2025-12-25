package p000;

import com.google.common.base.Objects;
import com.google.common.graph.EndpointPair;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class a90 extends EndpointPair {

    /* renamed from: c */
    public final /* synthetic */ int f90c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a90(int i, Object obj, Object obj2) {
        super(obj, obj2);
        this.f90c = i;
    }

    @Override // com.google.common.graph.EndpointPair
    public final boolean equals(Object obj) {
        switch (this.f90c) {
            case 0:
                if (obj == this) {
                    return true;
                }
                if (obj instanceof EndpointPair) {
                    EndpointPair endpointPair = (EndpointPair) obj;
                    if (true == endpointPair.isOrdered() && nodeU().equals(endpointPair.source()) && nodeV().equals(endpointPair.target())) {
                        return true;
                    }
                }
                return false;
            default:
                if (obj == this) {
                    return true;
                }
                if (obj instanceof EndpointPair) {
                    EndpointPair endpointPair2 = (EndpointPair) obj;
                    if (!endpointPair2.isOrdered()) {
                        if (nodeU().equals(endpointPair2.nodeU())) {
                            return nodeV().equals(endpointPair2.nodeV());
                        }
                        if (nodeU().equals(endpointPair2.nodeV()) && nodeV().equals(endpointPair2.nodeU())) {
                            return true;
                        }
                    }
                }
                return false;
        }
    }

    @Override // com.google.common.graph.EndpointPair
    public final int hashCode() {
        switch (this.f90c) {
            case 0:
                return Objects.hashCode(nodeU(), nodeV());
            default:
                return nodeV().hashCode() + nodeU().hashCode();
        }
    }

    @Override // com.google.common.graph.EndpointPair
    public final boolean isOrdered() {
        switch (this.f90c) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        switch (this.f90c) {
            case 0:
                return iterator();
            default:
                return iterator();
        }
    }

    @Override // com.google.common.graph.EndpointPair
    public final Object source() {
        switch (this.f90c) {
            case 0:
                return nodeU();
            default:
                throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }
    }

    @Override // com.google.common.graph.EndpointPair
    public final Object target() {
        switch (this.f90c) {
            case 0:
                return nodeV();
            default:
                throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }
    }

    public final String toString() {
        switch (this.f90c) {
            case 0:
                String valueOf = String.valueOf(nodeU());
                String valueOf2 = String.valueOf(nodeV());
                StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 6, "<", valueOf, " -> ", valueOf2);
                m7062r.append(">");
                return m7062r.toString();
            default:
                String valueOf3 = String.valueOf(nodeU());
                String valueOf4 = String.valueOf(nodeV());
                StringBuilder m7062r2 = AbstractC1726qj.m7062r(valueOf4.length() + valueOf3.length() + 4, "[", valueOf3, ", ", valueOf4);
                m7062r2.append("]");
                return m7062r2.toString();
        }
    }
}
