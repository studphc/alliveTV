package p000;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: hn */
/* loaded from: classes2.dex */
public final class C1275hn extends ContinuationImpl {

    /* renamed from: d */
    public ReceiveChannel f18099d;

    /* renamed from: e */
    public ChannelIterator f18100e;

    /* renamed from: f */
    public Object f18101f;

    /* renamed from: g */
    public /* synthetic */ Object f18102g;

    /* renamed from: h */
    public int f18103h;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f18102g = obj;
        this.f18103h |= Integer.MIN_VALUE;
        return ChannelsKt.lastOrNull(null, this);
    }
}
