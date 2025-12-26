package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class xg0 extends ContinuationImpl {

    /* renamed from: d */
    public yg0 f28543d;

    /* renamed from: e */
    public Object f28544e;

    /* renamed from: f */
    public /* synthetic */ Object f28545f;

    /* renamed from: g */
    public final /* synthetic */ yg0 f28546g;

    /* renamed from: h */
    public int f28547h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg0(yg0 yg0Var, Continuation continuation) {
        super(continuation);
        this.f28546g = yg0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28545f = obj;
        this.f28547h |= Integer.MIN_VALUE;
        return this.f28546g.emit(null, this);
    }
}
