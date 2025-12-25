package p000;

import com.google.common.base.Function;
import com.google.common.graph.Network;
import com.google.common.graph.ValueGraph;
import java.util.Objects;

/* loaded from: classes2.dex */
public final /* synthetic */ class p31 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f25021a;

    /* renamed from: b */
    public final /* synthetic */ Object f25022b;

    /* renamed from: c */
    public final /* synthetic */ Object f25023c;

    public /* synthetic */ p31(int i, Object obj, Object obj2) {
        this.f25021a = i;
        this.f25023c = obj;
        this.f25022b = obj2;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f25021a) {
            case 0:
                return ((Network) this.f25023c).incidentNodes(obj).adjacentNode(this.f25022b);
            default:
                Object edgeValueOrDefault = ((ValueGraph) this.f25023c).edgeValueOrDefault(this.f25022b, obj, null);
                Objects.requireNonNull(edgeValueOrDefault);
                return edgeValueOrDefault;
        }
    }
}
