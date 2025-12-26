package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* renamed from: vn */
/* loaded from: classes2.dex */
public final class C1915vn extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public ChannelIterator f27875e;

    /* renamed from: f */
    public int f27876f;

    /* renamed from: g */
    public int f27877g;

    /* renamed from: h */
    public /* synthetic */ Object f27878h;

    /* renamed from: i */
    public final /* synthetic */ ReceiveChannel f27879i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1915vn(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.f27879i = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1915vn c1915vn = new C1915vn(this.f27879i, continuation);
        c1915vn.f27878h = obj;
        return c1915vn;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1915vn) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0077 -> B:6:0x0040). Please report as a decompilation issue!!! */
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
        int i2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i3 = this.f27877g;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = this.f27876f;
                    ChannelIterator channelIterator2 = this.f27875e;
                    ProducerScope producerScope3 = (ProducerScope) this.f27878h;
                    ResultKt.throwOnFailure(obj);
                    producerScope = producerScope3;
                    i = i4;
                    it = channelIterator2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                i2 = this.f27876f;
                channelIterator = this.f27875e;
                producerScope2 = (ProducerScope) this.f27878h;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    int i5 = i2 + 1;
                    IndexedValue indexedValue = new IndexedValue(i2, channelIterator.next());
                    this.f27878h = producerScope2;
                    this.f27875e = channelIterator;
                    this.f27876f = i5;
                    this.f27877g = 2;
                    if (producerScope2.send(indexedValue, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = channelIterator;
                    producerScope = producerScope2;
                    i = i5;
                } else {
                    return Unit.INSTANCE;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.f27878h;
            it = this.f27879i.iterator();
            i = 0;
        }
        this.f27878h = producerScope;
        this.f27875e = it;
        this.f27876f = i;
        this.f27877g = 1;
        Object hasNext = it.hasNext(this);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        producerScope2 = producerScope;
        obj = hasNext;
        int i6 = i;
        channelIterator = it;
        i2 = i6;
        if (!((Boolean) obj).booleanValue()) {
        }
    }
}
