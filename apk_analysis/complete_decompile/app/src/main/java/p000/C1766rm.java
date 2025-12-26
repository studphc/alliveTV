package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: rm */
/* loaded from: classes2.dex */
public final class C1766rm extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f26019e;

    /* renamed from: f */
    public int f26020f;

    /* renamed from: g */
    public int f26021g;

    /* renamed from: h */
    public /* synthetic */ Object f26022h;

    /* renamed from: i */
    public final /* synthetic */ int f26023i;

    /* renamed from: j */
    public final /* synthetic */ ReceiveChannel f26024j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1766rm(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.f26023i = i;
        this.f26024j = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1766rm c1766rm = new C1766rm(this.f26024j, this.f26023i, continuation);
        c1766rm.f26022h = obj;
        return c1766rm;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1766rm) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        if (r1 == 0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0097 -> B:7:0x001c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x005a -> B:24:0x005d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        int i;
        ChannelIterator it;
        ProducerScope producerScope2;
        ChannelIterator it2;
        ProducerScope producerScope3;
        Object hasNext;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f26021g;
        ReceiveChannel receiveChannel = this.f26024j;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        it2 = this.f26019e;
                        producerScope3 = (ProducerScope) this.f26022h;
                        ResultKt.throwOnFailure(obj);
                        producerScope = producerScope3;
                        this.f26022h = producerScope;
                        this.f26019e = it2;
                        this.f26021g = 2;
                        hasNext = it2.hasNext(this);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope3 = producerScope;
                        obj = hasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            Object next = it2.next();
                            this.f26022h = producerScope3;
                            this.f26019e = it2;
                            this.f26021g = 3;
                            if (producerScope3.send(next, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            producerScope = producerScope3;
                            this.f26022h = producerScope;
                            this.f26019e = it2;
                            this.f26021g = 2;
                            hasNext = it2.hasNext(this);
                            if (hasNext != coroutine_suspended) {
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    it2 = this.f26019e;
                    producerScope3 = (ProducerScope) this.f26022h;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                    }
                }
            } else {
                i = this.f26020f;
                it = this.f26019e;
                producerScope2 = (ProducerScope) this.f26022h;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    it.next();
                    i--;
                }
                producerScope = producerScope2;
                it2 = receiveChannel.iterator();
                this.f26022h = producerScope;
                this.f26019e = it2;
                this.f26021g = 2;
                hasNext = it2.hasNext(this);
                if (hasNext != coroutine_suspended) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.f26022h;
            i = this.f26023i;
            if (i >= 0) {
                if (i > 0) {
                    it = receiveChannel.iterator();
                    producerScope2 = producerScope;
                    this.f26022h = producerScope2;
                    this.f26019e = it;
                    this.f26020f = i;
                    this.f26021g = 1;
                    obj = it.hasNext(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                    producerScope = producerScope2;
                }
                it2 = receiveChannel.iterator();
                this.f26022h = producerScope;
                this.f26019e = it2;
                this.f26021g = 2;
                hasNext = it2.hasNext(this);
                if (hasNext != coroutine_suspended) {
                }
            } else {
                throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
            }
        }
    }
}
