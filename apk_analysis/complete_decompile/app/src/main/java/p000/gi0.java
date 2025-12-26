package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class gi0 extends ContinuationImpl {

    /* renamed from: d */
    public hi0 f17704d;

    /* renamed from: e */
    public Ref.ObjectRef f17705e;

    /* renamed from: f */
    public /* synthetic */ Object f17706f;

    /* renamed from: g */
    public final /* synthetic */ hi0 f17707g;

    /* renamed from: h */
    public int f17708h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gi0(hi0 hi0Var, Continuation continuation) {
        super(continuation);
        this.f17707g = hi0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f17706f = obj;
        this.f17708h |= Integer.MIN_VALUE;
        return this.f17707g.emit(null, this);
    }
}
