package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1;

/* loaded from: classes2.dex */
public final class yh0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f28951d;

    /* renamed from: e */
    public FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 f28952e;

    /* renamed from: f */
    public /* synthetic */ Object f28953f;

    /* renamed from: g */
    public int f28954g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28953f = obj;
        this.f28954g |= Integer.MIN_VALUE;
        return FlowKt.singleOrNull(null, this);
    }
}
