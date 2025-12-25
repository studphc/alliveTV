package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1;

/* loaded from: classes2.dex */
public final class kh0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f20853d;

    /* renamed from: e */
    public FlowKt__ReduceKt$first$$inlined$collectWhile$1 f20854e;

    /* renamed from: f */
    public /* synthetic */ Object f20855f;

    /* renamed from: g */
    public int f20856g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f20855f = obj;
        this.f20856g |= Integer.MIN_VALUE;
        return FlowKt.first(null, this);
    }
}
