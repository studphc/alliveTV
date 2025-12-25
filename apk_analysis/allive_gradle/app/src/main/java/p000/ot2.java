package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.channels.TickerChannelsKt;

/* loaded from: classes2.dex */
public final class ot2 extends ContinuationImpl {

    /* renamed from: d */
    public long f24905d;

    /* renamed from: e */
    public SendChannel f24906e;

    /* renamed from: f */
    public /* synthetic */ Object f24907f;

    /* renamed from: g */
    public int f24908g;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f24907f = obj;
        this.f24908g |= Integer.MIN_VALUE;
        return TickerChannelsKt.access$fixedDelayTicker(0L, 0L, null, this);
    }
}
