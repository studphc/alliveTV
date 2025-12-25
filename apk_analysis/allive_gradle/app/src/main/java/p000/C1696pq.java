package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: pq */
/* loaded from: classes2.dex */
public final class C1696pq implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Channel f25257a;

    /* renamed from: b */
    public final /* synthetic */ int f25258b;

    public C1696pq(Channel channel, int i) {
        this.f25257a = channel;
        this.f25258b = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        C1646oq c1646oq;
        Object coroutine_suspended;
        int i;
        if (continuation instanceof C1646oq) {
            c1646oq = (C1646oq) continuation;
            int i2 = c1646oq.f24861f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1646oq.f24861f = i2 - Integer.MIN_VALUE;
                Object obj2 = c1646oq.f24859d;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1646oq.f24861f;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj2);
                } else {
                    ResultKt.throwOnFailure(obj2);
                    IndexedValue indexedValue = new IndexedValue(this.f25258b, obj);
                    c1646oq.f24861f = 1;
                    if (this.f25257a.send(indexedValue, c1646oq) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                c1646oq.f24861f = 2;
                if (YieldKt.yield(c1646oq) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        c1646oq = new C1646oq(this, continuation);
        Object obj22 = c1646oq.f24859d;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = c1646oq.f24861f;
        if (i == 0) {
        }
        c1646oq.f24861f = 2;
        if (YieldKt.yield(c1646oq) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
