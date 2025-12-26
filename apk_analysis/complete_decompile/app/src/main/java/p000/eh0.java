package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class eh0 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f16822d;

    /* renamed from: e */
    public final /* synthetic */ C0022al f16823e;

    /* renamed from: f */
    public int f16824f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eh0(C0022al c0022al, Continuation continuation) {
        super(continuation);
        this.f16823e = c0022al;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16822d = obj;
        this.f16824f |= Integer.MIN_VALUE;
        return this.f16823e.m113a(null, this);
    }
}
