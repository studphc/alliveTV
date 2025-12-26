package p000;

import java.util.Collection;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes2.dex */
public final class of0 extends ContinuationImpl {

    /* renamed from: d */
    public Collection f23794d;

    /* renamed from: e */
    public /* synthetic */ Object f23795e;

    /* renamed from: f */
    public int f23796f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f23795e = obj;
        this.f23796f |= Integer.MIN_VALUE;
        return FlowKt.toCollection(null, null, this);
    }
}
