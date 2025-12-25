package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class yf0 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f28933d;

    /* renamed from: e */
    public final /* synthetic */ C2029yq f28934e;

    /* renamed from: f */
    public int f28935f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf0(C2029yq c2029yq, Continuation continuation) {
        super(continuation);
        this.f28934e = c2029yq;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28933d = obj;
        this.f28935f |= Integer.MIN_VALUE;
        return this.f28934e.emit(null, this);
    }
}
