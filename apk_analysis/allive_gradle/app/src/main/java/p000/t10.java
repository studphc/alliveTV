package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes2.dex */
public final class t10 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f26656d;

    /* renamed from: e */
    public int f26657e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26656d = obj;
        this.f26657e |= Integer.MIN_VALUE;
        return DelayKt.awaitCancellation(this);
    }
}
