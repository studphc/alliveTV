package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class zg0 extends ContinuationImpl {

    /* renamed from: d */
    public FlowCollector f29368d;

    /* renamed from: e */
    public /* synthetic */ Object f29369e;

    /* renamed from: f */
    public int f29370f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29369e = obj;
        this.f29370f |= Integer.MIN_VALUE;
        return dh0.m4583a(null, null, this);
    }
}
