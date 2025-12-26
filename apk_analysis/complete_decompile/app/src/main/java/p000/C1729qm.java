package p000;

import java.util.HashSet;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: qm */
/* loaded from: classes2.dex */
public final class C1729qm extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public HashSet f25678e;

    /* renamed from: f */
    public ChannelIterator f25679f;

    /* renamed from: g */
    public Object f25680g;

    /* renamed from: h */
    public int f25681h;

    /* renamed from: i */
    public /* synthetic */ Object f25682i;

    /* renamed from: j */
    public final /* synthetic */ ReceiveChannel f25683j;

    /* renamed from: k */
    public final /* synthetic */ Function2 f25684k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1729qm(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f25683j = receiveChannel;
        this.f25684k = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1729qm c1729qm = new C1729qm(this.f25683j, this.f25684k, continuation);
        c1729qm.f25682i = obj;
        return c1729qm;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1729qm) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0095 -> B:8:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a8 -> B:7:0x00aa). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        HashSet hashSet;
        ChannelIterator it;
        ProducerScope producerScope2;
        HashSet hashSet2;
        Object obj2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f25681h;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        Object obj3 = this.f25680g;
                        ChannelIterator channelIterator = this.f25679f;
                        hashSet2 = this.f25678e;
                        producerScope2 = (ProducerScope) this.f25682i;
                        ResultKt.throwOnFailure(obj);
                        hashSet2.add(obj3);
                        it = channelIterator;
                        hashSet = hashSet2;
                        producerScope = producerScope2;
                        this.f25682i = producerScope;
                        this.f25678e = hashSet;
                        this.f25679f = it;
                        this.f25680g = null;
                        this.f25681h = 1;
                        obj = it.hasNext(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) obj).booleanValue()) {
                            Object next = it.next();
                            this.f25682i = producerScope;
                            this.f25678e = hashSet;
                            this.f25679f = it;
                            this.f25680g = next;
                            this.f25681h = 2;
                            Object invoke = this.f25684k.invoke(next, this);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            HashSet hashSet3 = hashSet;
                            obj2 = next;
                            obj = invoke;
                            producerScope2 = producerScope;
                            hashSet2 = hashSet3;
                            if (!hashSet2.contains(obj)) {
                                this.f25682i = producerScope2;
                                this.f25678e = hashSet2;
                                this.f25679f = it;
                                this.f25680g = obj;
                                this.f25681h = 3;
                                if (producerScope2.send(obj2, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                channelIterator = it;
                                obj3 = obj;
                                hashSet2.add(obj3);
                                it = channelIterator;
                            }
                            hashSet = hashSet2;
                            producerScope = producerScope2;
                            this.f25682i = producerScope;
                            this.f25678e = hashSet;
                            this.f25679f = it;
                            this.f25680g = null;
                            this.f25681h = 1;
                            obj = it.hasNext(this);
                            if (obj == coroutine_suspended) {
                            }
                            if (((Boolean) obj).booleanValue()) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    Object obj4 = this.f25680g;
                    ChannelIterator channelIterator2 = this.f25679f;
                    hashSet2 = this.f25678e;
                    producerScope2 = (ProducerScope) this.f25682i;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj4;
                    it = channelIterator2;
                    if (!hashSet2.contains(obj)) {
                    }
                    hashSet = hashSet2;
                    producerScope = producerScope2;
                    this.f25682i = producerScope;
                    this.f25678e = hashSet;
                    this.f25679f = it;
                    this.f25680g = null;
                    this.f25681h = 1;
                    obj = it.hasNext(this);
                    if (obj == coroutine_suspended) {
                    }
                    if (((Boolean) obj).booleanValue()) {
                    }
                }
            } else {
                it = this.f25679f;
                hashSet = this.f25678e;
                producerScope = (ProducerScope) this.f25682i;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope3 = (ProducerScope) this.f25682i;
            HashSet hashSet4 = new HashSet();
            producerScope = producerScope3;
            hashSet = hashSet4;
            it = this.f25683j.iterator();
            this.f25682i = producerScope;
            this.f25678e = hashSet;
            this.f25679f = it;
            this.f25680g = null;
            this.f25681h = 1;
            obj = it.hasNext(this);
            if (obj == coroutine_suspended) {
            }
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }
}
