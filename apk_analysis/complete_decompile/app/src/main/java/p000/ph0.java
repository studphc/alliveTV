package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes2.dex */
public final class ph0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f25174d;

    /* renamed from: e */
    public /* synthetic */ Object f25175e;

    /* renamed from: f */
    public int f25176f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25175e = obj;
        this.f25176f |= Integer.MIN_VALUE;
        return FlowKt.last(null, this);
    }
}
