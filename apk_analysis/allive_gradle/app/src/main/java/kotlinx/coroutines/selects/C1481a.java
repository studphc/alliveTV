package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: kotlinx.coroutines.selects.a */
/* loaded from: classes2.dex */
public final class C1481a extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f22110d;

    /* renamed from: e */
    public final /* synthetic */ SelectImplementation f22111e;

    /* renamed from: f */
    public int f22112f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1481a(SelectImplementation selectImplementation, Continuation continuation) {
        super(continuation);
        this.f22111e = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22110d = obj;
        this.f22112f |= Integer.MIN_VALUE;
        return SelectImplementation.access$processResultAndInvokeBlockRecoveringException(this.f22111e, null, null, this);
    }
}
