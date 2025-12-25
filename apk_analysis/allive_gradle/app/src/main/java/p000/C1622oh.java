package p000;

import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ConflatedBufferedChannel;

/* renamed from: oh */
/* loaded from: classes2.dex */
public final class C1622oh extends ConflatedBufferedChannel {

    /* renamed from: m */
    public final /* synthetic */ BroadcastChannelImpl f23805m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1622oh(BroadcastChannelImpl broadcastChannelImpl) {
        super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        this.f23805m = broadcastChannelImpl;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
        BroadcastChannelImpl.access$removeSubscriber(this.f23805m, this);
        return super.cancelImpl$kotlinx_coroutines_core(th);
    }
}
