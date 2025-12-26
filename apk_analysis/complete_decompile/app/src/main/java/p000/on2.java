package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class on2 extends ContinuationImpl {

    /* renamed from: d */
    public pn2 f24836d;

    /* renamed from: e */
    public FlowCollector f24837e;

    /* renamed from: f */
    public qn2 f24838f;

    /* renamed from: g */
    public Job f24839g;

    /* renamed from: h */
    public Object f24840h;

    /* renamed from: i */
    public /* synthetic */ Object f24841i;

    /* renamed from: j */
    public final /* synthetic */ pn2 f24842j;

    /* renamed from: k */
    public int f24843k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public on2(pn2 pn2Var, Continuation continuation) {
        super(continuation);
        this.f24842j = pn2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f24841i = obj;
        this.f24843k |= Integer.MIN_VALUE;
        return this.f24842j.collect(null, this);
    }
}
