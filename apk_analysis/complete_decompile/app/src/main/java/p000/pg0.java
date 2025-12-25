package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes2.dex */
public final class pg0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f25159d;

    /* renamed from: e */
    public /* synthetic */ Object f25160e;

    /* renamed from: f */
    public int f25161f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25160e = obj;
        this.f25161f |= Integer.MIN_VALUE;
        return FlowKt.catchImpl(null, null, this);
    }
}
