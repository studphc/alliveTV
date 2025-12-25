package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: uq */
/* loaded from: classes2.dex */
public final class C1881uq extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f27406d;

    /* renamed from: e */
    public final /* synthetic */ C1918vq f27407e;

    /* renamed from: f */
    public int f27408f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1881uq(C1918vq c1918vq, Continuation continuation) {
        super(continuation);
        this.f27407e = c1918vq;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f27406d = obj;
        this.f27408f |= Integer.MIN_VALUE;
        return this.f27407e.emit(null, this);
    }
}
