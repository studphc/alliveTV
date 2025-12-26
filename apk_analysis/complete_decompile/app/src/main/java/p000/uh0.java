package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class uh0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f27264d;

    /* renamed from: e */
    public /* synthetic */ Object f27265e;

    /* renamed from: f */
    public final /* synthetic */ vh0 f27266f;

    /* renamed from: g */
    public int f27267g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uh0(vh0 vh0Var, Continuation continuation) {
        super(continuation);
        this.f27266f = vh0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f27265e = obj;
        this.f27267g |= Integer.MIN_VALUE;
        return this.f27266f.emit(null, this);
    }
}
