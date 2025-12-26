package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: in */
/* loaded from: classes2.dex */
public final class C1312in extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public Function2 f18466e;

    /* renamed from: f */
    public ReceiveChannel f18467f;

    /* renamed from: g */
    public ChannelIterator f18468g;

    /* renamed from: h */
    public ProducerScope f18469h;

    /* renamed from: i */
    public int f18470i;

    /* renamed from: j */
    public /* synthetic */ Object f18471j;

    /* renamed from: k */
    public final /* synthetic */ ReceiveChannel f18472k;

    /* renamed from: l */
    public final /* synthetic */ Function2 f18473l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1312in(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f18472k = receiveChannel;
        this.f18473l = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1312in c1312in = new C1312in(this.f18472k, this.f18473l, continuation);
        c1312in.f18471j = obj;
        return c1312in;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1312in) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0079 A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:8:0x001c, B:10:0x005d, B:15:0x0071, B:17:0x0079, B:43:0x004a, B:45:0x0057), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a8 -> B:10:0x005d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel receiveChannel;
        ProducerScope producerScope;
        ChannelIterator it;
        Function2 function2;
        ReceiveChannel receiveChannel2;
        ProducerScope producerScope2;
        Function2 function22;
        ChannelIterator channelIterator;
        ProducerScope producerScope3;
        ProducerScope producerScope4;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f18470i;
        try {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            it = this.f18468g;
                            receiveChannel = this.f18467f;
                            function2 = this.f18466e;
                            ProducerScope producerScope5 = (ProducerScope) this.f18471j;
                            ResultKt.throwOnFailure(obj);
                            producerScope = producerScope5;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        producerScope3 = this.f18469h;
                        channelIterator = this.f18468g;
                        receiveChannel2 = this.f18467f;
                        function22 = this.f18466e;
                        producerScope2 = (ProducerScope) this.f18471j;
                        try {
                            ResultKt.throwOnFailure(obj);
                            this.f18471j = producerScope2;
                            this.f18466e = function22;
                            this.f18467f = receiveChannel2;
                            this.f18468g = channelIterator;
                            this.f18469h = null;
                            this.f18470i = 3;
                            if (producerScope3.send(obj, this) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            it = channelIterator;
                            receiveChannel = receiveChannel2;
                            function2 = function22;
                            producerScope = producerScope2;
                        } catch (Throwable th) {
                            th = th;
                            receiveChannel = receiveChannel2;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                ChannelsKt.cancelConsumed(receiveChannel, th);
                                throw th2;
                            }
                        }
                    }
                } else {
                    it = this.f18468g;
                    receiveChannel = this.f18467f;
                    function2 = this.f18466e;
                    producerScope4 = (ProducerScope) this.f18471j;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = it.next();
                        this.f18471j = producerScope4;
                        this.f18466e = function2;
                        this.f18467f = receiveChannel;
                        this.f18468g = it;
                        this.f18469h = producerScope4;
                        this.f18470i = 2;
                        obj = function2.invoke(next, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope2 = producerScope4;
                        function22 = function2;
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        producerScope3 = producerScope2;
                        this.f18471j = producerScope2;
                        this.f18466e = function22;
                        this.f18467f = receiveChannel2;
                        this.f18468g = channelIterator;
                        this.f18469h = null;
                        this.f18470i = 3;
                        if (producerScope3.send(obj, this) != coroutine_suspended) {
                        }
                    } else {
                        ChannelsKt.cancelConsumed(receiveChannel, null);
                        return Unit.INSTANCE;
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.f18471j;
                receiveChannel = this.f18472k;
                it = receiveChannel.iterator();
                function2 = this.f18473l;
            }
            this.f18471j = producerScope;
            this.f18466e = function2;
            this.f18467f = receiveChannel;
            this.f18468g = it;
            this.f18470i = 1;
            Object hasNext = it.hasNext(this);
            if (hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            producerScope4 = producerScope;
            obj = hasNext;
            if (!((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
