package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* renamed from: am */
/* loaded from: classes2.dex */
public class C0023am extends ChannelFlow {

    /* renamed from: a */
    public final Function2 f256a;

    public C0023am(Function2 function2, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f256a = function2;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collectTo(ProducerScope producerScope, Continuation continuation) {
        Object invoke = this.f256a.invoke(producerScope, continuation);
        if (invoke != b51.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return invoke;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow create(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new C0023am(this.f256a, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String toString() {
        return "block[" + this.f256a + "] -> " + super.toString();
    }
}
