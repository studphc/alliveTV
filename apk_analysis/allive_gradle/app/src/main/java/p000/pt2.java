package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.channels.TickerChannelsKt;

/* loaded from: classes2.dex */
public final class pt2 extends ContinuationImpl {

    /* renamed from: d */
    public long f25293d;

    /* renamed from: e */
    public long f25294e;

    /* renamed from: f */
    public SendChannel f25295f;

    /* renamed from: g */
    public /* synthetic */ Object f25296g;

    /* renamed from: h */
    public int f25297h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f25296g = obj;
        this.f25297h |= Integer.MIN_VALUE;
        return TickerChannelsKt.access$fixedPeriodTicker(0L, 0L, null, this);
    }
}
