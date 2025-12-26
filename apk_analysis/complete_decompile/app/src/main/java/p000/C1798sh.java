package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: sh */
/* loaded from: classes2.dex */
public final class C1798sh extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f26425e;

    /* renamed from: f */
    public int f26426f;

    /* renamed from: g */
    public /* synthetic */ Object f26427g;

    /* renamed from: h */
    public final /* synthetic */ ReceiveChannel f26428h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1798sh(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.f26428h = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1798sh c1798sh = new C1798sh(this.f26428h, continuation);
        c1798sh.f26427g = obj;
        return c1798sh;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1798sh) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005e -> B:6:0x0017). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        ChannelIterator it;
        ProducerScope producerScope2;
        Object hasNext;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f26426f;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    it = this.f26425e;
                    producerScope2 = (ProducerScope) this.f26427g;
                    ResultKt.throwOnFailure(obj);
                    producerScope = producerScope2;
                    this.f26427g = producerScope;
                    this.f26425e = it;
                    this.f26426f = 1;
                    hasNext = it.hasNext(this);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    producerScope2 = producerScope;
                    obj = hasNext;
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = it.next();
                        this.f26427g = producerScope2;
                        this.f26425e = it;
                        this.f26426f = 2;
                        if (producerScope2.send(next, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope = producerScope2;
                        this.f26427g = producerScope;
                        this.f26425e = it;
                        this.f26426f = 1;
                        hasNext = it.hasNext(this);
                        if (hasNext == coroutine_suspended) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                it = this.f26425e;
                producerScope2 = (ProducerScope) this.f26427g;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.f26427g;
            it = this.f26428h.iterator();
            this.f26427g = producerScope;
            this.f26425e = it;
            this.f26426f = 1;
            hasNext = it.hasNext(this);
            if (hasNext == coroutine_suspended) {
            }
        }
    }
}
