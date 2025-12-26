package p000;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class xn2 extends ContinuationImpl {

    /* renamed from: d */
    public yn2 f28659d;

    /* renamed from: e */
    public FlowCollector f28660e;

    /* renamed from: f */
    public Iterator f28661f;

    /* renamed from: g */
    public /* synthetic */ Object f28662g;

    /* renamed from: h */
    public final /* synthetic */ yn2 f28663h;

    /* renamed from: i */
    public int f28664i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xn2(yn2 yn2Var, Continuation continuation) {
        super(continuation);
        this.f28663h = yn2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28662g = obj;
        this.f28664i |= Integer.MIN_VALUE;
        return this.f28663h.collect(null, this);
    }
}
