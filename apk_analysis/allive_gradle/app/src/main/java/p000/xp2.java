package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class xp2 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f28679d;

    /* renamed from: e */
    public final /* synthetic */ yp2 f28680e;

    /* renamed from: f */
    public int f28681f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xp2(yp2 yp2Var, Continuation continuation) {
        super(continuation);
        this.f28680e = yp2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28679d = obj;
        this.f28681f |= Integer.MIN_VALUE;
        return this.f28680e.collect(null, this);
    }
}
