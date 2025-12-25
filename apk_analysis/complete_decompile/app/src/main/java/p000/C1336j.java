package p000;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.graph.EndpointPair;
import java.util.Iterator;

/* renamed from: j */
/* loaded from: classes2.dex */
public final class C1336j extends d41 {
    @Override // p000.d41, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        AbstractC1373k abstractC1373k = (AbstractC1373k) this.f16242c;
        boolean isDirected = abstractC1373k.isDirected();
        Object obj = this.f16241b;
        if (isDirected) {
            final int i = 0;
            final int i2 = 1;
            return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(abstractC1373k.predecessors(obj).iterator(), new Function(this) { // from class: i

                /* renamed from: b */
                public final /* synthetic */ C1336j f18232b;

                {
                    this.f18232b = this;
                }

                @Override // com.google.common.base.Function
                public final Object apply(Object obj2) {
                    switch (i) {
                        case 0:
                            return EndpointPair.ordered(obj2, this.f18232b.f16241b);
                        case 1:
                            return EndpointPair.ordered(this.f18232b.f16241b, obj2);
                        default:
                            return EndpointPair.unordered(this.f18232b.f16241b, obj2);
                    }
                }
            }), Iterators.transform(Sets.difference(abstractC1373k.successors(obj), ImmutableSet.m3972of(obj)).iterator(), new Function(this) { // from class: i

                /* renamed from: b */
                public final /* synthetic */ C1336j f18232b;

                {
                    this.f18232b = this;
                }

                @Override // com.google.common.base.Function
                public final Object apply(Object obj2) {
                    switch (i2) {
                        case 0:
                            return EndpointPair.ordered(obj2, this.f18232b.f16241b);
                        case 1:
                            return EndpointPair.ordered(this.f18232b.f16241b, obj2);
                        default:
                            return EndpointPair.unordered(this.f18232b.f16241b, obj2);
                    }
                }
            })));
        }
        Iterator it = abstractC1373k.adjacentNodes(obj).iterator();
        final int i3 = 2;
        return Iterators.unmodifiableIterator(Iterators.transform(it, new Function(this) { // from class: i

            /* renamed from: b */
            public final /* synthetic */ C1336j f18232b;

            {
                this.f18232b = this;
            }

            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                switch (i3) {
                    case 0:
                        return EndpointPair.ordered(obj2, this.f18232b.f16241b);
                    case 1:
                        return EndpointPair.ordered(this.f18232b.f16241b, obj2);
                    default:
                        return EndpointPair.unordered(this.f18232b.f16241b, obj2);
                }
            }
        }));
    }
}
