package p000;

import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class wv2 extends Traverser {

    /* renamed from: b */
    public final /* synthetic */ int f28353b;

    /* renamed from: c */
    public final /* synthetic */ SuccessorsFunction f28354c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wv2(SuccessorsFunction successorsFunction, SuccessorsFunction successorsFunction2, int i) {
        super(successorsFunction);
        this.f28353b = i;
        this.f28354c = successorsFunction2;
    }

    @Override // com.google.common.graph.Traverser
    /* renamed from: a */
    public final ge3 mo4176a() {
        switch (this.f28353b) {
            case 0:
                return new yv2(this.f28354c, new HashSet());
            default:
                return new ge3(this.f28354c);
        }
    }
}
