package p000;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* renamed from: ph */
/* loaded from: classes2.dex */
public final class C1687ph extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f25170e;

    /* renamed from: f */
    public final /* synthetic */ BroadcastChannelImpl f25171f;

    /* renamed from: g */
    public final /* synthetic */ Object f25172g;

    /* renamed from: h */
    public final /* synthetic */ SelectInstance f25173h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1687ph(BroadcastChannelImpl broadcastChannelImpl, Object obj, SelectInstance selectInstance, Continuation continuation) {
        super(2, continuation);
        this.f25171f = broadcastChannelImpl;
        this.f25172g = obj;
        this.f25173h = selectInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1687ph(this.f25171f, this.f25172g, this.f25173h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1687ph) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ReentrantLock reentrantLock;
        HashMap hashMap;
        Object channel_closed;
        HashMap hashMap2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f25170e;
        boolean z = true;
        BroadcastChannelImpl broadcastChannelImpl = this.f25171f;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.f25172g;
                this.f25170e = 1;
                if (broadcastChannelImpl.send(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Throwable th) {
            if (broadcastChannelImpl.isClosedForSend() && ((th instanceof ClosedSendChannelException) || broadcastChannelImpl.getSendException() == th)) {
                z = false;
            } else {
                throw th;
            }
        }
        reentrantLock = broadcastChannelImpl.f21446m;
        SelectInstance selectInstance = this.f25173h;
        reentrantLock.lock();
        try {
            hashMap = broadcastChannelImpl.f21449p;
            if (z) {
                channel_closed = Unit.INSTANCE;
            } else {
                channel_closed = BufferedChannelKt.getCHANNEL_CLOSED();
            }
            hashMap.put(selectInstance, channel_closed);
            Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            Unit unit = Unit.INSTANCE;
            if (((SelectImplementation) selectInstance).trySelectDetailed(broadcastChannelImpl, unit) != TrySelectDetailedResult.REREGISTER) {
                hashMap2 = broadcastChannelImpl.f21449p;
                hashMap2.remove(selectInstance);
            }
            reentrantLock.unlock();
            return unit;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }
}
