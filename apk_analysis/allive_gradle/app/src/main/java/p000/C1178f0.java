package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.AbstractFlow;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* renamed from: f0 */
/* loaded from: classes2.dex */
public final class C1178f0 extends ContinuationImpl {

    /* renamed from: d */
    public SafeCollector f17049d;

    /* renamed from: e */
    public /* synthetic */ Object f17050e;

    /* renamed from: f */
    public final /* synthetic */ AbstractFlow f17051f;

    /* renamed from: g */
    public int f17052g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1178f0(AbstractFlow abstractFlow, Continuation continuation) {
        super(continuation);
        this.f17051f = abstractFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f17050e = obj;
        this.f17052g |= Integer.MIN_VALUE;
        return this.f17051f.collect(null, this);
    }
}
