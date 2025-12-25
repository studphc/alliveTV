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

/* renamed from: wm */
/* loaded from: classes2.dex */
public final class C1951wm extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f28232e;

    /* renamed from: f */
    public Object f28233f;

    /* renamed from: g */
    public int f28234g;

    /* renamed from: h */
    public int f28235h;

    /* renamed from: i */
    public /* synthetic */ Object f28236i;

    /* renamed from: j */
    public final /* synthetic */ ReceiveChannel f28237j;

    /* renamed from: k */
    public final /* synthetic */ Function3 f28238k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1951wm(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f28237j = receiveChannel;
        this.f28238k = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1951wm c1951wm = new C1951wm(this.f28237j, this.f28238k, continuation);
        c1951wm.f28236i = obj;
        return c1951wm;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1951wm) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        r7 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelIterator it;
        int i;
        ProducerScope producerScope2;
        Object obj2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f28235h;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        i = this.f28234g;
                        it = this.f28232e;
                        producerScope = (ProducerScope) this.f28236i;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    i = this.f28234g;
                    Object obj3 = this.f28233f;
                    ChannelIterator channelIterator = this.f28232e;
                    producerScope2 = (ProducerScope) this.f28236i;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj3;
                    it = channelIterator;
                    if (((Boolean) obj).booleanValue()) {
                        this.f28236i = producerScope2;
                        this.f28232e = it;
                        this.f28233f = null;
                        this.f28234g = i;
                        this.f28235h = 3;
                        if (producerScope2.send(obj2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    producerScope = producerScope2;
                }
            } else {
                i = this.f28234g;
                it = this.f28232e;
                producerScope = (ProducerScope) this.f28236i;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    Object next = it.next();
                    int i3 = i + 1;
                    Integer boxInt = Boxing.boxInt(i);
                    this.f28236i = producerScope;
                    this.f28232e = it;
                    this.f28233f = next;
                    this.f28234g = i3;
                    this.f28235h = 2;
                    Object invoke = this.f28238k.invoke(boxInt, next, this);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ProducerScope producerScope3 = producerScope;
                    obj2 = next;
                    obj = invoke;
                    i = i3;
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
            producerScope = (ProducerScope) this.f28236i;
            it = this.f28237j.iterator();
            i = 0;
        }
        this.f28236i = producerScope;
        this.f28232e = it;
        this.f28233f = null;
        this.f28234g = i;
        this.f28235h = 1;
        obj = it.hasNext(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }
}
