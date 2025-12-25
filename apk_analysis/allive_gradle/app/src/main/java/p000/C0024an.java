package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* renamed from: an */
/* loaded from: classes2.dex */
public final class C0024an extends ContinuationImpl {

    /* renamed from: d */
    public SendChannel f259d;

    /* renamed from: e */
    public ReceiveChannel f260e;

    /* renamed from: f */
    public ChannelIterator f261f;

    /* renamed from: g */
    public /* synthetic */ Object f262g;

    /* renamed from: h */
    public int f263h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f262g = obj;
        this.f263h |= Integer.MIN_VALUE;
        return ChannelsKt.filterNotNullTo((ReceiveChannel) null, (SendChannel) null, this);
    }
}
