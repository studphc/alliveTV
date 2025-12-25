package p000;

import com.google.common.base.Predicate;
import com.google.common.graph.AbstractNetwork;

/* renamed from: k2 */
/* loaded from: classes2.dex */
public final class C1376k2 implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ Object f20721a;

    /* renamed from: b */
    public final /* synthetic */ Object f20722b;

    /* renamed from: c */
    public final /* synthetic */ AbstractNetwork f20723c;

    public C1376k2(AbstractNetwork abstractNetwork, Object obj, Object obj2) {
        this.f20723c = abstractNetwork;
        this.f20721a = obj;
        this.f20722b = obj2;
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return this.f20723c.incidentNodes(obj).adjacentNode(this.f20721a).equals(this.f20722b);
    }
}
