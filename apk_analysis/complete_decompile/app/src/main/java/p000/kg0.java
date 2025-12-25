package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class kg0 {

    /* renamed from: a */
    public static final C1223g8 f20844a = C1223g8.f17577f;

    /* renamed from: b */
    public static final C1952wn f20845b = C1952wn.f28249h;

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (r0.f22327c == r4) goto L10;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final l50 m5528a(Flow flow, Function1 function1, Function2 function2) {
        if (flow instanceof l50) {
            l50 l50Var = (l50) flow;
            if (l50Var.f22326b == function1) {
            }
        }
        flow = new l50(flow, function1, function2);
        return (l50) flow;
    }
}
