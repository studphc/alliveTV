package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.SubscribedFlowCollector;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* loaded from: classes2.dex */
public final class wp2 extends ContinuationImpl {

    /* renamed from: d */
    public SubscribedFlowCollector f28270d;

    /* renamed from: e */
    public SafeCollector f28271e;

    /* renamed from: f */
    public /* synthetic */ Object f28272f;

    /* renamed from: g */
    public final /* synthetic */ SubscribedFlowCollector f28273g;

    /* renamed from: h */
    public int f28274h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wp2(SubscribedFlowCollector subscribedFlowCollector, Continuation continuation) {
        super(continuation);
        this.f28273g = subscribedFlowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28272f = obj;
        this.f28274h |= Integer.MIN_VALUE;
        return this.f28273g.onSubscription(this);
    }
}
