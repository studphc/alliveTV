package p000;

import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;

/* loaded from: classes2.dex */
public final /* synthetic */ class f40 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f17119a;

    /* renamed from: b */
    public final /* synthetic */ Object f17120b;

    public /* synthetic */ f40(int i, Object obj) {
        this.f17119a = i;
        this.f17120b = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f17119a) {
            case 0:
                return EndpointPair.ordered(obj, this.f17120b);
            case 1:
                return EndpointPair.ordered(this.f17120b, obj);
            case 2:
                j40 j40Var = (j40) obj;
                boolean z = j40Var instanceof i40;
                Object obj2 = this.f17120b;
                if (z) {
                    return EndpointPair.ordered(obj2, j40Var.f20368a);
                }
                return EndpointPair.ordered(j40Var.f20368a, obj2);
            default:
                return EndpointPair.unordered(this.f17120b, obj);
        }
    }
}
