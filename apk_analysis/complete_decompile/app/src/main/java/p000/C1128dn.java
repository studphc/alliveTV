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

/* renamed from: dn */
/* loaded from: classes2.dex */
public final class C1128dn extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f16434e;

    /* renamed from: f */
    public int f16435f;

    /* renamed from: g */
    public /* synthetic */ Object f16436g;

    /* renamed from: h */
    public final /* synthetic */ ReceiveChannel f16437h;

    /* renamed from: i */
    public final /* synthetic */ Function2 f16438i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1128dn(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f16437h = receiveChannel;
        this.f16438i = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1128dn c1128dn = new C1128dn(this.f16437h, this.f16438i, continuation);
        c1128dn.f16436g = obj;
        return c1128dn;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1128dn) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0079 -> B:7:0x0045). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator it;
        ProducerScope producerScope;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f16435f;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        it = this.f16434e;
                        producerScope = (ProducerScope) this.f16436g;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    it = this.f16434e;
                    producerScope = (ProducerScope) this.f16436g;
                    ResultKt.throwOnFailure(obj);
                    this.f16436g = producerScope;
                    this.f16434e = it;
                    this.f16435f = 3;
                    if (ChannelsKt.toChannel((ReceiveChannel) obj, producerScope, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                it = this.f16434e;
                producerScope = (ProducerScope) this.f16436g;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    Object next = it.next();
                    this.f16436g = producerScope;
                    this.f16434e = it;
                    this.f16435f = 2;
                    obj = this.f16438i.invoke(next, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.f16436g = producerScope;
                    this.f16434e = it;
                    this.f16435f = 3;
                    if (ChannelsKt.toChannel((ReceiveChannel) obj, producerScope, this) == coroutine_suspended) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope2 = (ProducerScope) this.f16436g;
            it = this.f16437h.iterator();
            producerScope = producerScope2;
        }
        this.f16436g = producerScope;
        this.f16434e = it;
        this.f16435f = 1;
        obj = it.hasNext(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }
}
