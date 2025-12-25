package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;

/* loaded from: classes2.dex */
public final class nh0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f23365d;

    /* renamed from: e */
    public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 f23366e;

    /* renamed from: f */
    public /* synthetic */ Object f23367f;

    /* renamed from: g */
    public int f23368g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f23367f = obj;
        this.f23368g |= Integer.MIN_VALUE;
        return FlowKt.firstOrNull(null, null, this);
    }
}
