package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class vg0 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f27772d;

    /* renamed from: e */
    public final /* synthetic */ wg0 f27773e;

    /* renamed from: f */
    public int f27774f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vg0(wg0 wg0Var, Continuation continuation) {
        super(continuation);
        this.f27773e = wg0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f27772d = obj;
        this.f27774f |= Integer.MIN_VALUE;
        return this.f27773e.emit(null, this);
    }
}
