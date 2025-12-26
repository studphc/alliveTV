package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.SharedFlowSlot;

/* loaded from: classes2.dex */
public final class zh2 extends ContinuationImpl {

    /* renamed from: d */
    public SharedFlowImpl f29377d;

    /* renamed from: e */
    public FlowCollector f29378e;

    /* renamed from: f */
    public SharedFlowSlot f29379f;

    /* renamed from: g */
    public Job f29380g;

    /* renamed from: h */
    public /* synthetic */ Object f29381h;

    /* renamed from: i */
    public final /* synthetic */ SharedFlowImpl f29382i;

    /* renamed from: j */
    public int f29383j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zh2(SharedFlowImpl sharedFlowImpl, Continuation continuation) {
        super(continuation);
        this.f29382i = sharedFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29381h = obj;
        this.f29383j |= Integer.MIN_VALUE;
        return SharedFlowImpl.m5712c(this.f29382i, null, this);
    }
}
