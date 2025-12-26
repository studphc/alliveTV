package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: oq */
/* loaded from: classes2.dex */
public final class C1646oq extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f24859d;

    /* renamed from: e */
    public final /* synthetic */ C1696pq f24860e;

    /* renamed from: f */
    public int f24861f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1646oq(C1696pq c1696pq, Continuation continuation) {
        super(continuation);
        this.f24860e = c1696pq;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f24859d = obj;
        this.f24861f |= Integer.MIN_VALUE;
        return this.f24860e.emit(null, this);
    }
}
