package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: sm */
/* loaded from: classes2.dex */
public final class C1803sm extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f26476e;

    /* renamed from: f */
    public Object f26477f;

    /* renamed from: g */
    public int f26478g;

    /* renamed from: h */
    public /* synthetic */ Object f26479h;

    /* renamed from: i */
    public final /* synthetic */ ReceiveChannel f26480i;

    /* renamed from: j */
    public final /* synthetic */ Function2 f26481j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1803sm(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f26480i = receiveChannel;
        this.f26481j = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1803sm c1803sm = new C1803sm(this.f26480i, this.f26481j, continuation);
        c1803sm.f26479h = obj;
        return c1803sm;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1803sm) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00e2 -> B:9:0x0023). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0097 -> B:28:0x0050). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator it;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        ChannelIterator it2;
        ProducerScope producerScope3;
        ChannelIterator channelIterator;
        Object hasNext;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f26478g;
        ReceiveChannel receiveChannel = this.f26480i;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                channelIterator = this.f26476e;
                                producerScope3 = (ProducerScope) this.f26479h;
                                ResultKt.throwOnFailure(obj);
                                it2 = channelIterator;
                                producerScope2 = producerScope3;
                                this.f26479h = producerScope2;
                                this.f26476e = it2;
                                this.f26478g = 4;
                                hasNext = it2.hasNext(this);
                                if (hasNext == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ProducerScope producerScope4 = producerScope2;
                                channelIterator = it2;
                                obj = hasNext;
                                producerScope3 = producerScope4;
                                if (!((Boolean) obj).booleanValue()) {
                                    Object next = channelIterator.next();
                                    this.f26479h = producerScope3;
                                    this.f26476e = channelIterator;
                                    this.f26478g = 5;
                                    if (producerScope3.send(next, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    it2 = channelIterator;
                                    producerScope2 = producerScope3;
                                    this.f26479h = producerScope2;
                                    this.f26476e = it2;
                                    this.f26478g = 4;
                                    hasNext = it2.hasNext(this);
                                    if (hasNext == coroutine_suspended) {
                                    }
                                } else {
                                    return Unit.INSTANCE;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            channelIterator = this.f26476e;
                            producerScope3 = (ProducerScope) this.f26479h;
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        }
                    } else {
                        producerScope2 = (ProducerScope) this.f26479h;
                        ResultKt.throwOnFailure(obj);
                        it2 = receiveChannel.iterator();
                        this.f26479h = producerScope2;
                        this.f26476e = it2;
                        this.f26478g = 4;
                        hasNext = it2.hasNext(this);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                } else {
                    Object obj2 = this.f26477f;
                    ChannelIterator channelIterator2 = this.f26476e;
                    ProducerScope producerScope5 = (ProducerScope) this.f26479h;
                    ResultKt.throwOnFailure(obj);
                    ChannelIterator channelIterator3 = channelIterator2;
                    Object obj3 = obj2;
                    it = channelIterator3;
                    if (((Boolean) obj).booleanValue()) {
                        this.f26479h = producerScope5;
                        this.f26476e = null;
                        this.f26477f = null;
                        this.f26478g = 3;
                        if (producerScope5.send(obj3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope2 = producerScope5;
                        it2 = receiveChannel.iterator();
                        this.f26479h = producerScope2;
                        this.f26476e = it2;
                        this.f26478g = 4;
                        hasNext = it2.hasNext(this);
                        if (hasNext == coroutine_suspended) {
                        }
                    } else {
                        producerScope = producerScope5;
                        this.f26479h = producerScope;
                        this.f26476e = it;
                        this.f26477f = null;
                        this.f26478g = 1;
                        obj = it.hasNext(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ProducerScope producerScope6 = producerScope;
                        ChannelIterator channelIterator4 = it;
                        producerScope2 = producerScope6;
                        if (((Boolean) obj).booleanValue()) {
                            Object next2 = channelIterator4.next();
                            this.f26479h = producerScope2;
                            this.f26476e = channelIterator4;
                            this.f26477f = next2;
                            this.f26478g = 2;
                            Object invoke = this.f26481j.invoke(next2, this);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            channelIterator3 = channelIterator4;
                            obj3 = next2;
                            obj = invoke;
                            producerScope5 = producerScope2;
                            it = channelIterator3;
                            if (((Boolean) obj).booleanValue()) {
                            }
                        }
                        it2 = receiveChannel.iterator();
                        this.f26479h = producerScope2;
                        this.f26476e = it2;
                        this.f26478g = 4;
                        hasNext = it2.hasNext(this);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                }
            } else {
                it = this.f26476e;
                producerScope = (ProducerScope) this.f26479h;
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope62 = producerScope;
                ChannelIterator channelIterator42 = it;
                producerScope2 = producerScope62;
                if (((Boolean) obj).booleanValue()) {
                }
                it2 = receiveChannel.iterator();
                this.f26479h = producerScope2;
                this.f26476e = it2;
                this.f26478g = 4;
                hasNext = it2.hasNext(this);
                if (hasNext == coroutine_suspended) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope7 = (ProducerScope) this.f26479h;
            it = receiveChannel.iterator();
            producerScope = producerScope7;
            this.f26479h = producerScope;
            this.f26476e = it;
            this.f26477f = null;
            this.f26478g = 1;
            obj = it.hasNext(this);
            if (obj == coroutine_suspended) {
            }
            ProducerScope producerScope622 = producerScope;
            ChannelIterator channelIterator422 = it;
            producerScope2 = producerScope622;
            if (((Boolean) obj).booleanValue()) {
            }
            it2 = receiveChannel.iterator();
            this.f26479h = producerScope2;
            this.f26476e = it2;
            this.f26478g = 4;
            hasNext = it2.hasNext(this);
            if (hasNext == coroutine_suspended) {
            }
        }
    }
}
