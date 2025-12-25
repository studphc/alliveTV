package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2;

/* loaded from: classes2.dex */
public final class lh0 extends ContinuationImpl {

    /* renamed from: d */
    public Function2 f22504d;

    /* renamed from: e */
    public Ref.ObjectRef f22505e;

    /* renamed from: f */
    public FlowKt__ReduceKt$first$$inlined$collectWhile$2 f22506f;

    /* renamed from: g */
    public /* synthetic */ Object f22507g;

    /* renamed from: h */
    public int f22508h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22507g = obj;
        this.f22508h |= Integer.MIN_VALUE;
        return FlowKt.first(null, null, this);
    }
}
