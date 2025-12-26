package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class ii0 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f18418d;

    /* renamed from: e */
    public final /* synthetic */ ji0 f18419e;

    /* renamed from: f */
    public int f18420f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii0(ji0 ji0Var, Continuation continuation) {
        super(continuation);
        this.f18419e = ji0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f18418d = obj;
        this.f18420f |= Integer.MIN_VALUE;
        return this.f18419e.emit(null, this);
    }
}
