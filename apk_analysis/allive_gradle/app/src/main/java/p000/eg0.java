package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class eg0 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f16808d;

    /* renamed from: e */
    public final /* synthetic */ C2029yq f16809e;

    /* renamed from: f */
    public int f16810f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eg0(C2029yq c2029yq, Continuation continuation) {
        super(continuation);
        this.f16809e = c2029yq;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16808d = obj;
        this.f16810f |= Integer.MIN_VALUE;
        return this.f16809e.emit(null, this);
    }
}
