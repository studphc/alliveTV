package p000;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.PredecessorsFunction;
import com.google.common.graph.SuccessorsFunction;
import java.util.Set;

/* renamed from: if */
/* loaded from: classes2.dex */
public interface InterfaceC1304if extends SuccessorsFunction, PredecessorsFunction {
    Set adjacentNodes(Object obj);

    boolean allowsSelfLoops();

    int degree(Object obj);

    Set edges();

    boolean hasEdgeConnecting(EndpointPair endpointPair);

    boolean hasEdgeConnecting(Object obj, Object obj2);

    int inDegree(Object obj);

    ElementOrder incidentEdgeOrder();

    Set incidentEdges(Object obj);

    boolean isDirected();

    ElementOrder nodeOrder();

    Set nodes();

    int outDegree(Object obj);

    Set predecessors(Object obj);

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set successors(Object obj);
}
