package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p000.ox0;
import p000.qx0;
import p000.rx0;
import p000.sx0;
import p000.vm2;
import p000.wm2;
import p000.xm2;

@Beta
/* loaded from: classes2.dex */
public final class Graphs {
    /* renamed from: a */
    public static void m4172a(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Not true that %s is non-negative.", i);
    }

    /* renamed from: b */
    public static boolean m4173b(Graph graph, HashMap hashMap, Object obj, Object obj2) {
        ox0 ox0Var = (ox0) hashMap.get(obj);
        ox0 ox0Var2 = ox0.f24942b;
        if (ox0Var == ox0Var2) {
            return false;
        }
        ox0 ox0Var3 = ox0.f24941a;
        if (ox0Var == ox0Var3) {
            return true;
        }
        hashMap.put(obj, ox0Var3);
        for (Object obj3 : graph.successors((Graph) obj)) {
            if (graph.isDirected() || !Objects.equal(obj2, obj3)) {
                if (m4173b(graph, hashMap, obj3, obj)) {
                    return true;
                }
            }
        }
        hashMap.put(obj, ox0Var2);
        return false;
    }

    /* renamed from: c */
    public static EndpointPair m4174c(EndpointPair endpointPair) {
        if (endpointPair.isOrdered()) {
            return EndpointPair.ordered(endpointPair.target(), endpointPair.source());
        }
        return endpointPair;
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> graph) {
        MutableGraph<N> mutableGraph = (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            mutableGraph.addNode(it.next());
        }
        for (EndpointPair<N> endpointPair : graph.edges()) {
            mutableGraph.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return mutableGraph;
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (!graph.isDirected() && size >= graph.nodes().size()) {
            return true;
        }
        HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(graph.nodes().size());
        Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            if (m4173b(graph, newHashMapWithExpectedSize, it.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> graph, Iterable<? extends N> iterable) {
        vm2 vm2Var;
        if (iterable instanceof Collection) {
            vm2Var = (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            vm2Var = (MutableGraph<N>) GraphBuilder.from(graph).build();
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            vm2Var.addNode(it.next());
        }
        for (N n : vm2Var.nodes()) {
            for (N n2 : graph.successors((Graph<N>) n)) {
                if (vm2Var.nodes().contains(n2)) {
                    vm2Var.putEdge(n, n2);
                }
            }
        }
        return vm2Var;
    }

    public static <N> Set<N> reachableNodes(Graph<N> graph, N n) {
        Preconditions.checkArgument(graph.nodes().contains(n), "Node %s is not an element of this graph.", n);
        return ImmutableSet.copyOf(Traverser.forGraph(graph).breadthFirst((Traverser) n));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        vm2 build = GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (N n : graph.nodes()) {
                Iterator it = reachableNodes(graph, n).iterator();
                while (it.hasNext()) {
                    build.putEdge(n, it.next());
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n2 : graph.nodes()) {
                if (!hashSet.contains(n2)) {
                    Set reachableNodes = reachableNodes(graph, n2);
                    hashSet.addAll(reachableNodes);
                    int i = 1;
                    for (Object obj : reachableNodes) {
                        int i2 = i + 1;
                        Iterator it2 = Iterables.limit(reachableNodes, i).iterator();
                        while (it2.hasNext()) {
                            build.putEdge(obj, it2.next());
                        }
                        i = i2;
                    }
                }
            }
        }
        return build;
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        if (!graph.isDirected()) {
            return graph;
        }
        if (graph instanceof qx0) {
            return ((qx0) graph).f25787a;
        }
        return new qx0(graph);
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> valueGraph) {
        if (!valueGraph.isDirected()) {
            return valueGraph;
        }
        if (valueGraph instanceof sx0) {
            return ((sx0) valueGraph).f26610a;
        }
        return new sx0(valueGraph);
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        MutableValueGraph<N, V> mutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(valueGraph.nodes().size()).build();
        Iterator<N> it = valueGraph.nodes().iterator();
        while (it.hasNext()) {
            mutableValueGraph.addNode(it.next());
        }
        for (EndpointPair<N> endpointPair : valueGraph.edges()) {
            N nodeU = endpointPair.nodeU();
            N nodeV = endpointPair.nodeV();
            V edgeValueOrDefault = valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
            java.util.Objects.requireNonNull(edgeValueOrDefault);
            mutableValueGraph.putEdgeValue(nodeU, nodeV, edgeValueOrDefault);
        }
        return mutableValueGraph;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        if (!network.isDirected()) {
            return network;
        }
        if (network instanceof rx0) {
            return ((rx0) network).f26174a;
        }
        return new rx0(network);
    }

    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        xm2 xm2Var;
        if (iterable instanceof Collection) {
            xm2Var = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            xm2Var = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).build();
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            xm2Var.addNode(it.next());
        }
        for (N n : xm2Var.nodes()) {
            for (N n2 : valueGraph.successors((ValueGraph<N, V>) n)) {
                if (xm2Var.nodes().contains(n2)) {
                    V edgeValueOrDefault = valueGraph.edgeValueOrDefault(n, n2, null);
                    java.util.Objects.requireNonNull(edgeValueOrDefault);
                    xm2Var.putEdgeValue(n, n2, edgeValueOrDefault);
                }
            }
        }
        return xm2Var;
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> network) {
        MutableNetwork<N, E> mutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        Iterator<N> it = network.nodes().iterator();
        while (it.hasNext()) {
            mutableNetwork.addNode(it.next());
        }
        for (E e : network.edges()) {
            EndpointPair<N> incidentNodes = network.incidentNodes(e);
            mutableNetwork.addEdge(incidentNodes.nodeU(), incidentNodes.nodeV(), e);
        }
        return mutableNetwork;
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> network, Iterable<? extends N> iterable) {
        wm2 wm2Var;
        if (iterable instanceof Collection) {
            wm2Var = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            wm2Var = (MutableNetwork<N, E>) NetworkBuilder.from(network).build();
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            wm2Var.addNode(it.next());
        }
        for (E e : wm2Var.nodes()) {
            for (E e2 : network.outEdges(e)) {
                N adjacentNode = network.incidentNodes(e2).adjacentNode(e);
                if (wm2Var.nodes().contains(adjacentNode)) {
                    wm2Var.addEdge(e, adjacentNode, e2);
                }
            }
        }
        return wm2Var;
    }
}
