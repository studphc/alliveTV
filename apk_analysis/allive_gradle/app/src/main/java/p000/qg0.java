package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class qg0 extends ContinuationImpl {

    /* renamed from: d */
    public rg0 f25572d;

    /* renamed from: e */
    public /* synthetic */ Object f25573e;

    /* renamed from: f */
    public final /* synthetic */ rg0 f25574f;

    /* renamed from: g */
    public int f25575g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qg0(rg0 rg0Var, Continuation continuation) {
        super(continuation);
        this.f25574f = rg0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25573e = obj;
        this.f25575g |= Integer.MIN_VALUE;
        return this.f25574f.emit(null, this);
    }
}
