package p000;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.channels.BufferedChannel;

/* renamed from: nh */
/* loaded from: classes2.dex */
public final class C1585nh extends BufferedChannel {

    /* renamed from: l */
    public final /* synthetic */ BroadcastChannelImpl f23364l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1585nh(BroadcastChannelImpl broadcastChannelImpl) {
        super(broadcastChannelImpl.getCapacity(), null, 2, null);
        this.f23364l = broadcastChannelImpl;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
        ReentrantLock reentrantLock;
        BroadcastChannelImpl broadcastChannelImpl = this.f23364l;
        reentrantLock = broadcastChannelImpl.f21446m;
        reentrantLock.lock();
        try {
            BroadcastChannelImpl.access$removeSubscriber(broadcastChannelImpl, this);
            return super.cancelImpl$kotlinx_coroutines_core(th);
        } finally {
            reentrantLock.unlock();
        }
    }
}
