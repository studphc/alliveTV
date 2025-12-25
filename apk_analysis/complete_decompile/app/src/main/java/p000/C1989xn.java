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

/* renamed from: xn */
/* loaded from: classes2.dex */
public final class C1989xn extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f28631e;

    /* renamed from: f */
    public Function2 f28632f;

    /* renamed from: g */
    public ReceiveChannel f28633g;

    /* renamed from: h */
    public ChannelIterator f28634h;

    /* renamed from: i */
    public Object f28635i;

    /* renamed from: j */
    public int f28636j;

    /* renamed from: k */
    public /* synthetic */ Object f28637k;

    /* renamed from: l */
    public final /* synthetic */ ReceiveChannel f28638l;

    /* renamed from: m */
    public final /* synthetic */ ReceiveChannel f28639m;

    /* renamed from: n */
    public final /* synthetic */ Function2 f28640n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1989xn(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f28638l = receiveChannel;
        this.f28639m = receiveChannel2;
        this.f28640n = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1989xn c1989xn = new C1989xn(this.f28638l, this.f28639m, this.f28640n, continuation);
        c1989xn.f28637k = obj;
        return c1989xn;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1989xn) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e A[Catch: all -> 0x0022, TRY_LEAVE, TryCatch #0 {all -> 0x0022, blocks: (B:8:0x001e, B:9:0x0071, B:13:0x0086, B:15:0x008e, B:45:0x0053, B:47:0x0066), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #1 {all -> 0x0043, blocks: (B:19:0x00ae, B:21:0x00b6, B:42:0x003b), top: B:41:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel receiveChannel;
        ProducerScope producerScope;
        ChannelIterator channelIterator;
        ChannelIterator it;
        Function2 function2;
        ReceiveChannel receiveChannel2;
        ProducerScope producerScope2;
        ChannelIterator channelIterator2;
        Function2 function22;
        Object obj2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f28636j;
        try {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            it = this.f28634h;
                            receiveChannel = this.f28633g;
                            function2 = this.f28632f;
                            channelIterator = this.f28631e;
                            producerScope = (ProducerScope) this.f28637k;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        Object obj3 = this.f28635i;
                        ChannelIterator channelIterator3 = this.f28634h;
                        receiveChannel2 = this.f28633g;
                        function22 = this.f28632f;
                        channelIterator2 = this.f28631e;
                        producerScope2 = (ProducerScope) this.f28637k;
                        try {
                            ResultKt.throwOnFailure(obj);
                            obj2 = obj3;
                            it = channelIterator3;
                            if (((Boolean) obj).booleanValue()) {
                                Object invoke = function22.invoke(obj2, channelIterator2.next());
                                this.f28637k = producerScope2;
                                this.f28631e = channelIterator2;
                                this.f28632f = function22;
                                this.f28633g = receiveChannel2;
                                this.f28634h = it;
                                this.f28635i = null;
                                this.f28636j = 3;
                                if (producerScope2.send(invoke, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            receiveChannel = receiveChannel2;
                            function2 = function22;
                            channelIterator = channelIterator2;
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
                    it = this.f28634h;
                    receiveChannel = this.f28633g;
                    function2 = this.f28632f;
                    channelIterator = this.f28631e;
                    producerScope = (ProducerScope) this.f28637k;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = it.next();
                        this.f28637k = producerScope;
                        this.f28631e = channelIterator;
                        this.f28632f = function2;
                        this.f28633g = receiveChannel;
                        this.f28634h = it;
                        this.f28635i = next;
                        this.f28636j = 2;
                        Object hasNext = channelIterator.hasNext(this);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ReceiveChannel receiveChannel3 = receiveChannel;
                        obj2 = next;
                        obj = hasNext;
                        producerScope2 = producerScope;
                        channelIterator2 = channelIterator;
                        function22 = function2;
                        receiveChannel2 = receiveChannel3;
                        if (((Boolean) obj).booleanValue()) {
                        }
                        receiveChannel = receiveChannel2;
                        function2 = function22;
                        channelIterator = channelIterator2;
                        producerScope = producerScope2;
                    } else {
                        ChannelsKt.cancelConsumed(receiveChannel, null);
                        return Unit.INSTANCE;
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope3 = (ProducerScope) this.f28637k;
                ChannelIterator it2 = this.f28638l.iterator();
                receiveChannel = this.f28639m;
                producerScope = producerScope3;
                channelIterator = it2;
                it = receiveChannel.iterator();
                function2 = this.f28640n;
            }
            this.f28637k = producerScope;
            this.f28631e = channelIterator;
            this.f28632f = function2;
            this.f28633g = receiveChannel;
            this.f28634h = it;
            this.f28635i = null;
            this.f28636j = 1;
            obj = it.hasNext(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (!((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
