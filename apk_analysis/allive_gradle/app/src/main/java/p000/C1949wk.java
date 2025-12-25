package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* renamed from: wk */
/* loaded from: classes2.dex */
public final class C1949wk extends C0023am {

    /* renamed from: b */
    public final Function2 f28206b;

    public C1949wk(Function2 function2, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(function2, coroutineContext, i, bufferOverflow);
        this.f28206b = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // p000.C0023am, kotlinx.coroutines.flow.internal.ChannelFlow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectTo(ProducerScope producerScope, Continuation continuation) {
        C1912vk c1912vk;
        int i;
        if (continuation instanceof C1912vk) {
            c1912vk = (C1912vk) continuation;
            int i2 = c1912vk.f27825g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1912vk.f27825g = i2 - Integer.MIN_VALUE;
                Object obj = c1912vk.f27823e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1912vk.f27825g;
                if (i == 0) {
                    if (i == 1) {
                        producerScope = c1912vk.f27822d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    c1912vk.f27822d = producerScope;
                    c1912vk.f27825g = 1;
                    if (super.collectTo(producerScope, c1912vk) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (!producerScope.isClosedForSend()) {
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
            }
        }
        c1912vk = new C1912vk(this, continuation);
        Object obj2 = c1912vk.f27823e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1912vk.f27825g;
        if (i == 0) {
        }
        if (!producerScope.isClosedForSend()) {
        }
    }

    @Override // p000.C0023am, kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow create(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new C1949wk(this.f28206b, coroutineContext, i, bufferOverflow);
    }
}
