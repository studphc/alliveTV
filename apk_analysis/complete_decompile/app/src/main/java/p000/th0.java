package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes2.dex */
public final class th0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f26811d;

    /* renamed from: e */
    public /* synthetic */ Object f26812e;

    /* renamed from: f */
    public int f26813f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26812e = obj;
        this.f26813f |= Integer.MIN_VALUE;
        return FlowKt.reduce(null, null, this);
    }
}
