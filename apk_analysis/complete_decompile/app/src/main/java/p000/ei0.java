package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class ei0 extends ContinuationImpl {

    /* renamed from: d */
    public fi0 f16830d;

    /* renamed from: e */
    public Ref.ObjectRef f16831e;

    /* renamed from: f */
    public /* synthetic */ Object f16832f;

    /* renamed from: g */
    public final /* synthetic */ fi0 f16833g;

    /* renamed from: h */
    public int f16834h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei0(fi0 fi0Var, Continuation continuation) {
        super(continuation);
        this.f16833g = fi0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16832f = obj;
        this.f16834h |= Integer.MIN_VALUE;
        return this.f16833g.emit(null, this);
    }
}
