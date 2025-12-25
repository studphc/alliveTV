package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: rn */
/* loaded from: classes2.dex */
public final class C1767rn extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f26032e;

    /* renamed from: f */
    public Object f26033f;

    /* renamed from: g */
    public int f26034g;

    /* renamed from: h */
    public /* synthetic */ Object f26035h;

    /* renamed from: i */
    public final /* synthetic */ ReceiveChannel f26036i;

    /* renamed from: j */
    public final /* synthetic */ Function2 f26037j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1767rn(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f26036i = receiveChannel;
        this.f26037j = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1767rn c1767rn = new C1767rn(this.f26036i, this.f26037j, continuation);
        c1767rn.f26035h = obj;
        return c1767rn;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1767rn) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0091 -> B:7:0x0047). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator it;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        ChannelIterator channelIterator;
        Object obj2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f26034g;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        it = this.f26032e;
                        producerScope = (ProducerScope) this.f26035h;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    obj2 = this.f26033f;
                    channelIterator = this.f26032e;
                    producerScope2 = (ProducerScope) this.f26035h;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.f26035h = producerScope2;
                    this.f26032e = channelIterator;
                    this.f26033f = null;
                    this.f26034g = 3;
                    if (producerScope2.send(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = channelIterator;
                    producerScope = producerScope2;
                }
            } else {
                it = this.f26032e;
                producerScope = (ProducerScope) this.f26035h;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    Object next = it.next();
                    this.f26035h = producerScope;
                    this.f26032e = it;
                    this.f26033f = next;
                    this.f26034g = 2;
                    Object invoke = this.f26037j.invoke(next, this);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ChannelIterator channelIterator2 = it;
                    obj2 = next;
                    obj = invoke;
                    producerScope2 = producerScope;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj).booleanValue()) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope3 = (ProducerScope) this.f26035h;
            it = this.f26036i.iterator();
            producerScope = producerScope3;
        }
        this.f26035h = producerScope;
        this.f26032e = it;
        this.f26034g = 1;
        obj = it.hasNext(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }
}
