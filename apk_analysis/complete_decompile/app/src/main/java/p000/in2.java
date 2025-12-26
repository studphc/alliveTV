package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class in2 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f18476d;

    /* renamed from: e */
    public final /* synthetic */ jn2 f18477e;

    /* renamed from: f */
    public int f18478f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public in2(jn2 jn2Var, Continuation continuation) {
        super(continuation);
        this.f18477e = jn2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f18476d = obj;
        this.f18478f |= Integer.MIN_VALUE;
        return this.f18477e.m5445a(0, this);
    }
}
