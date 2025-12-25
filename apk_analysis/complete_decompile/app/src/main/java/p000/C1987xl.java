package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

/* renamed from: xl */
/* loaded from: classes2.dex */
public final class C1987xl extends ChannelFlow {

    /* renamed from: c */
    public static final AtomicIntegerFieldUpdater f28608c = AtomicIntegerFieldUpdater.newUpdater(C1987xl.class, "consumed");

    /* renamed from: a */
    public final ReceiveChannel f28609a;

    /* renamed from: b */
    public final boolean f28610b;

    @Volatile
    private volatile int consumed;

    public /* synthetic */ C1987xl(ReceiveChannel receiveChannel, boolean z) {
        this(receiveChannel, z, EmptyCoroutineContext.INSTANCE, -3, BufferOverflow.SUSPEND);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String additionalToStringProps() {
        return "channel=" + this.f28609a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        if (this.capacity == -3) {
            boolean z = this.f28610b;
            if (z && f28608c.getAndSet(this, 1) != 0) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
            }
            Object m6468k = o63.m6468k(flowCollector, this.f28609a, z, continuation);
            if (m6468k == b51.getCOROUTINE_SUSPENDED()) {
                return m6468k;
            }
            return Unit.INSTANCE;
        }
        Object collect = super.collect(flowCollector, continuation);
        if (collect == b51.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object collectTo(ProducerScope producerScope, Continuation continuation) {
        Object m6468k = o63.m6468k(new SendingCollector(producerScope), this.f28609a, this.f28610b, continuation);
        if (m6468k == b51.getCOROUTINE_SUSPENDED()) {
            return m6468k;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow create(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new C1987xl(this.f28609a, this.f28610b, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Flow dropChannelOperators() {
        return new C1987xl(this.f28609a, this.f28610b);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ReceiveChannel produceImpl(CoroutineScope coroutineScope) {
        if (this.f28610b && f28608c.getAndSet(this, 1) != 0) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
        }
        if (this.capacity == -3) {
            return this.f28609a;
        }
        return super.produceImpl(coroutineScope);
    }

    public C1987xl(ReceiveChannel receiveChannel, boolean z, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f28609a = receiveChannel;
        this.f28610b = z;
        this.consumed = 0;
    }
}
