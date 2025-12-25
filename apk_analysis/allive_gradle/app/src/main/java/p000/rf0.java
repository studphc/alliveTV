package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes2.dex */
public final class rf0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.IntRef f25952d;

    /* renamed from: e */
    public /* synthetic */ Object f25953e;

    /* renamed from: f */
    public int f25954f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25953e = obj;
        this.f25954f |= Integer.MIN_VALUE;
        return FlowKt.count(null, null, this);
    }
}
