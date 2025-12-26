package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: xq */
/* loaded from: classes2.dex */
public final class C1992xq extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f28682d;

    /* renamed from: e */
    public final /* synthetic */ C2029yq f28683e;

    /* renamed from: f */
    public int f28684f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1992xq(C2029yq c2029yq, Continuation continuation) {
        super(continuation);
        this.f28683e = c2029yq;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28682d = obj;
        this.f28684f |= Integer.MIN_VALUE;
        return this.f28683e.emit(null, this);
    }
}
