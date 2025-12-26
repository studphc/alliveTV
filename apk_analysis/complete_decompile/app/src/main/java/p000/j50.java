package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class j50 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f20374d;

    /* renamed from: e */
    public final /* synthetic */ k50 f20375e;

    /* renamed from: f */
    public int f20376f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j50(k50 k50Var, Continuation continuation) {
        super(continuation);
        this.f20375e = k50Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f20374d = obj;
        this.f20376f |= Integer.MIN_VALUE;
        return this.f20375e.emit(null, this);
    }
}
