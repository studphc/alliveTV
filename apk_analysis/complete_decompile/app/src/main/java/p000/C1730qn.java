package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: qn */
/* loaded from: classes2.dex */
public final class C1730qn extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f25689e;

    /* renamed from: f */
    public int f25690f;

    /* renamed from: g */
    public int f25691g;

    /* renamed from: h */
    public /* synthetic */ Object f25692h;

    /* renamed from: i */
    public final /* synthetic */ int f25693i;

    /* renamed from: j */
    public final /* synthetic */ ReceiveChannel f25694j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1730qn(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.f25693i = i;
        this.f25694j = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1730qn c1730qn = new C1730qn(this.f25694j, this.f25693i, continuation);
        c1730qn.f25692h = obj;
        return c1730qn;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1730qn) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x006f -> B:6:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        int i;
        ChannelIterator it;
        ProducerScope producerScope2;
        Object hasNext;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f25691g;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    i = this.f25690f;
                    it = this.f25689e;
                    producerScope2 = (ProducerScope) this.f25692h;
                    ResultKt.throwOnFailure(obj);
                    producerScope = producerScope2;
                    i--;
                    if (i == 0) {
                        return Unit.INSTANCE;
                    }
                    this.f25692h = producerScope;
                    this.f25689e = it;
                    this.f25690f = i;
                    this.f25691g = 1;
                    hasNext = it.hasNext(this);
                    if (hasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    producerScope2 = producerScope;
                    obj = hasNext;
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = it.next();
                        this.f25692h = producerScope2;
                        this.f25689e = it;
                        this.f25690f = i;
                        this.f25691g = 2;
                        if (producerScope2.send(next, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope = producerScope2;
                        i--;
                        if (i == 0) {
                        }
                        this.f25692h = producerScope;
                        this.f25689e = it;
                        this.f25690f = i;
                        this.f25691g = 1;
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
                i = this.f25690f;
                it = this.f25689e;
                producerScope2 = (ProducerScope) this.f25692h;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.f25692h;
            i = this.f25693i;
            if (i == 0) {
                return Unit.INSTANCE;
            }
            if (i >= 0) {
                it = this.f25694j.iterator();
                this.f25692h = producerScope;
                this.f25689e = it;
                this.f25690f = i;
                this.f25691g = 1;
                hasNext = it.hasNext(this);
                if (hasNext == coroutine_suspended) {
                }
            } else {
                throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " is less than zero.").toString());
            }
        }
    }
}
