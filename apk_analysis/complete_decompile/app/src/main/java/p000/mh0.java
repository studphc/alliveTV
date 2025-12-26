package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1;

/* loaded from: classes2.dex */
public final class mh0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f22939d;

    /* renamed from: e */
    public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 f22940e;

    /* renamed from: f */
    public /* synthetic */ Object f22941f;

    /* renamed from: g */
    public int f22942g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22941f = obj;
        this.f22942g |= Integer.MIN_VALUE;
        return FlowKt.firstOrNull(null, this);
    }
}
