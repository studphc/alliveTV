package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class mg0 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f22927d;

    /* renamed from: e */
    public final /* synthetic */ ng0 f22928e;

    /* renamed from: f */
    public int f22929f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mg0(ng0 ng0Var, Continuation continuation) {
        super(continuation);
        this.f22928e = ng0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22927d = obj;
        this.f22929f |= Integer.MIN_VALUE;
        return this.f22928e.emit(null, this);
    }
}
