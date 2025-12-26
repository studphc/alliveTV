package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class mf0 extends ContinuationImpl {

    /* renamed from: d */
    public FlowCollector f22920d;

    /* renamed from: e */
    public ReceiveChannel f22921e;

    /* renamed from: f */
    public ChannelIterator f22922f;

    /* renamed from: g */
    public boolean f22923g;

    /* renamed from: h */
    public /* synthetic */ Object f22924h;

    /* renamed from: i */
    public int f22925i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22924h = obj;
        this.f22925i |= Integer.MIN_VALUE;
        return o63.m6468k(null, null, false, this);
    }
}
