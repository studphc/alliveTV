package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: vm */
/* loaded from: classes2.dex */
public final class C1914vm extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f27865e;

    /* renamed from: f */
    public Object f27866f;

    /* renamed from: g */
    public int f27867g;

    /* renamed from: h */
    public /* synthetic */ Object f27868h;

    /* renamed from: i */
    public final /* synthetic */ ReceiveChannel f27869i;

    /* renamed from: j */
    public final /* synthetic */ Function2 f27870j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1914vm(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f27869i = receiveChannel;
        this.f27870j = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1914vm c1914vm = new C1914vm(this.f27869i, this.f27870j, continuation);
        c1914vm.f27868h = obj;
        return c1914vm;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1914vm) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator it;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        Object obj2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f27867g;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        it = this.f27865e;
                        producerScope = (ProducerScope) this.f27868h;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    Object obj3 = this.f27866f;
                    ChannelIterator channelIterator = this.f27865e;
                    producerScope2 = (ProducerScope) this.f27868h;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj3;
                    it = channelIterator;
                    if (((Boolean) obj).booleanValue()) {
                        this.f27868h = producerScope2;
                        this.f27865e = it;
                        this.f27866f = null;
                        this.f27867g = 3;
                        if (producerScope2.send(obj2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    producerScope = producerScope2;
                }
            } else {
                it = this.f27865e;
                producerScope = (ProducerScope) this.f27868h;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    Object next = it.next();
                    this.f27868h = producerScope;
                    this.f27865e = it;
                    this.f27866f = next;
                    this.f27867g = 2;
                    Object invoke = this.f27870j.invoke(next, this);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ProducerScope producerScope3 = producerScope;
                    obj2 = next;
                    obj = invoke;
                    producerScope2 = producerScope3;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    producerScope = producerScope2;
                } else {
                    return Unit.INSTANCE;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope4 = (ProducerScope) this.f27868h;
            it = this.f27869i.iterator();
            producerScope = producerScope4;
        }
        this.f27868h = producerScope;
        this.f27865e = it;
        this.f27866f = null;
        this.f27867g = 1;
        obj = it.hasNext(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }
}
