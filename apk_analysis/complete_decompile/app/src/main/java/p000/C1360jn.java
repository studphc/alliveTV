package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: jn */
/* loaded from: classes2.dex */
public final class C1360jn extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f20547e;

    /* renamed from: f */
    public ProducerScope f20548f;

    /* renamed from: g */
    public int f20549g;

    /* renamed from: h */
    public int f20550h;

    /* renamed from: i */
    public /* synthetic */ Object f20551i;

    /* renamed from: j */
    public final /* synthetic */ ReceiveChannel f20552j;

    /* renamed from: k */
    public final /* synthetic */ Function3 f20553k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1360jn(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f20552j = receiveChannel;
        this.f20553k = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1360jn c1360jn = new C1360jn(this.f20552j, this.f20553k, continuation);
        c1360jn.f20551i = obj;
        return c1360jn;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1360jn) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009e -> B:7:0x0051). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelIterator it;
        int i;
        ProducerScope producerScope2;
        ChannelIterator channelIterator;
        ProducerScope producerScope3;
        ProducerScope producerScope4;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f20550h;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        i = this.f20549g;
                        it = this.f20547e;
                        ProducerScope producerScope5 = (ProducerScope) this.f20551i;
                        ResultKt.throwOnFailure(obj);
                        producerScope = producerScope5;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    i = this.f20549g;
                    producerScope3 = this.f20548f;
                    channelIterator = this.f20547e;
                    producerScope2 = (ProducerScope) this.f20551i;
                    ResultKt.throwOnFailure(obj);
                    this.f20551i = producerScope2;
                    this.f20547e = channelIterator;
                    this.f20548f = null;
                    this.f20549g = i;
                    this.f20550h = 3;
                    if (producerScope3.send(obj, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = channelIterator;
                    producerScope = producerScope2;
                }
            } else {
                i = this.f20549g;
                it = this.f20547e;
                producerScope4 = (ProducerScope) this.f20551i;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    Object next = it.next();
                    int i3 = i + 1;
                    Integer boxInt = Boxing.boxInt(i);
                    this.f20551i = producerScope4;
                    this.f20547e = it;
                    this.f20548f = producerScope4;
                    this.f20549g = i3;
                    this.f20550h = 2;
                    obj = this.f20553k.invoke(boxInt, next, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = i3;
                    producerScope2 = producerScope4;
                    channelIterator = it;
                    producerScope3 = producerScope2;
                    this.f20551i = producerScope2;
                    this.f20547e = channelIterator;
                    this.f20548f = null;
                    this.f20549g = i;
                    this.f20550h = 3;
                    if (producerScope3.send(obj, this) != coroutine_suspended) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.f20551i;
            it = this.f20552j.iterator();
            i = 0;
        }
        this.f20551i = producerScope;
        this.f20547e = it;
        this.f20549g = i;
        this.f20550h = 1;
        Object hasNext = it.hasNext(this);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        producerScope4 = producerScope;
        obj = hasNext;
        if (!((Boolean) obj).booleanValue()) {
        }
    }
}
