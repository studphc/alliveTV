package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes2.dex */
public final class wh0 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f28184d;

    /* renamed from: e */
    public /* synthetic */ Object f28185e;

    /* renamed from: f */
    public int f28186f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f28185e = obj;
        this.f28186f |= Integer.MIN_VALUE;
        return FlowKt.single(null, this);
    }
}
