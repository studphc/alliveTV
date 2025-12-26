package p000;

import com.google.common.base.Preconditions;
import com.google.common.graph.EndpointPair;
import com.google.common.math.IntMath;
import java.util.Set;

/* renamed from: k */
/* loaded from: classes2.dex */
public abstract class AbstractC1373k implements InterfaceC1304if {
    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    public int degree(Object obj) {
        int i;
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors(obj).size(), successors(obj).size());
        }
        Set adjacentNodes = adjacentNodes(obj);
        if (allowsSelfLoops() && adjacentNodes.contains(obj)) {
            i = 1;
        } else {
            i = 0;
        }
        return IntMath.saturatedAdd(adjacentNodes.size(), i);
    }

    public long edgeCount() {
        boolean z;
        long j = 0;
        while (nodes().iterator().hasNext()) {
            j += degree(r0.next());
        }
        if ((1 & j) == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return j >>> 1;
    }

    @Override // p000.InterfaceC1304if, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        Object nodeU = endpointPair.nodeU();
        Object nodeV = endpointPair.nodeV();
        if (!nodes().contains(nodeU) || !successors(nodeU).contains(nodeV)) {
            return false;
        }
        return true;
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        if (!endpointPair.isOrdered() && isDirected()) {
            return false;
        }
        return true;
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }
}
