package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class ah0 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f185d;

    /* renamed from: e */
    public final /* synthetic */ bh0 f186e;

    /* renamed from: f */
    public int f187f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah0(bh0 bh0Var, Continuation continuation) {
        super(continuation);
        this.f186e = bh0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f185d = obj;
        this.f187f |= Integer.MIN_VALUE;
        return this.f186e.emit(null, this);
    }
}
