package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes2.dex */
public final class pf0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.IntRef f25145d;

    /* renamed from: e */
    public /* synthetic */ Object f25146e;

    /* renamed from: f */
    public int f25147f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25146e = obj;
        this.f25147f |= Integer.MIN_VALUE;
        return FlowKt.count(null, this);
    }
}
