package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* renamed from: cm */
/* loaded from: classes2.dex */
public final class C0598cm extends ContinuationImpl {

    /* renamed from: d */
    public C1127dm f8412d;

    /* renamed from: e */
    public Flow f8413e;

    /* renamed from: f */
    public /* synthetic */ Object f8414f;

    /* renamed from: g */
    public final /* synthetic */ C1127dm f8415g;

    /* renamed from: h */
    public int f8416h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0598cm(C1127dm c1127dm, Continuation continuation) {
        super(continuation);
        this.f8415g = c1127dm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f8414f = obj;
        this.f8416h |= Integer.MIN_VALUE;
        return this.f8415g.emit(null, this);
    }
}
