package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* renamed from: sn */
/* loaded from: classes2.dex */
public final class C1804sn extends ContinuationImpl {

    /* renamed from: d */
    public SendChannel f26496d;

    /* renamed from: e */
    public ReceiveChannel f26497e;

    /* renamed from: f */
    public ChannelIterator f26498f;

    /* renamed from: g */
    public /* synthetic */ Object f26499g;

    /* renamed from: h */
    public int f26500h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26499g = obj;
        this.f26500h |= Integer.MIN_VALUE;
        return ChannelsKt.toChannel(null, null, this);
    }
}
