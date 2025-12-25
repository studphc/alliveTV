package p000;

import com.google.common.base.Function;
import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graph;
import com.google.common.graph.Network;
import com.google.common.graph.ValueGraph;
import java.util.Objects;

/* renamed from: i2 */
/* loaded from: classes2.dex */
public final class C1291i2 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f18267a;

    /* renamed from: b */
    public final /* synthetic */ Object f18268b;

    public /* synthetic */ C1291i2(int i, Object obj) {
        this.f18267a = i;
        this.f18268b = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f18267a) {
            case 0:
                return ((AbstractNetwork) ((C1339j2) ((C1251h) this.f18268b).f17896b).f20348b).incidentNodes(obj);
            case 1:
                return ((Network) this.f18268b).incidentNodes(obj);
            case 2:
                EndpointPair endpointPair = (EndpointPair) obj;
                Object edgeValueOrDefault = ((ValueGraph) this.f18268b).edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
                Objects.requireNonNull(edgeValueOrDefault);
                return edgeValueOrDefault;
            case 3:
                EndpointPair endpointPair2 = (EndpointPair) obj;
                Graph graph = ((qx0) ((px0) this.f18268b).f25330e).f25787a;
                Object nodeV = endpointPair2.nodeV();
                Object nodeU = endpointPair2.nodeU();
                if (graph.isDirected()) {
                    return EndpointPair.ordered(nodeV, nodeU);
                }
                return EndpointPair.unordered(nodeV, nodeU);
            case 4:
                ((lb1) this.f18268b).f22434b.set(obj);
                return obj;
            case 5:
                return ((kd0) ((C1290i1) this.f18268b).f18247b).f20824e.get(obj);
            case 6:
                return ((dn2) ((cn2) this.f18268b).f8429c).f16446e.column(obj);
            default:
                return ((dn2) ((cn2) this.f18268b).f8429c).f16446e.row(obj);
        }
    }
}
