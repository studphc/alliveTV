package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes2.dex */
public final class rh0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f25969d;

    /* renamed from: e */
    public /* synthetic */ Object f25970e;

    /* renamed from: f */
    public int f25971f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25970e = obj;
        this.f25971f |= Integer.MIN_VALUE;
        return FlowKt.lastOrNull(null, this);
    }
}
