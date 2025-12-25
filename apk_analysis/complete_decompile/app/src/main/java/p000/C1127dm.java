package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.SendingCollector;
import kotlinx.coroutines.sync.Semaphore;

/* renamed from: dm */
/* loaded from: classes2.dex */
public final class C1127dm implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Job f16412a;

    /* renamed from: b */
    public final /* synthetic */ Semaphore f16413b;

    /* renamed from: c */
    public final /* synthetic */ ProducerScope f16414c;

    /* renamed from: d */
    public final /* synthetic */ SendingCollector f16415d;

    public C1127dm(Job job, Semaphore semaphore, ProducerScope producerScope, SendingCollector sendingCollector) {
        this.f16412a = job;
        this.f16413b = semaphore;
        this.f16414c = producerScope;
        this.f16415d = sendingCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Flow flow, Continuation continuation) {
        C0598cm c0598cm;
        int i;
        C1127dm c1127dm;
        if (continuation instanceof C0598cm) {
            c0598cm = (C0598cm) continuation;
            int i2 = c0598cm.f8416h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c0598cm.f8416h = i2 - Integer.MIN_VALUE;
                Object obj = c0598cm.f8414f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c0598cm.f8416h;
                if (i == 0) {
                    if (i == 1) {
                        flow = c0598cm.f8413e;
                        c1127dm = c0598cm.f8412d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Job job = this.f16412a;
                    if (job != null) {
                        JobKt.ensureActive(job);
                    }
                    c0598cm.f8412d = this;
                    c0598cm.f8413e = flow;
                    c0598cm.f8416h = 1;
                    if (this.f16413b.acquire(c0598cm) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c1127dm = this;
                }
                BuildersKt.launch$default(c1127dm.f16414c, null, null, new C0562bm(flow, c1127dm.f16415d, c1127dm.f16413b, null), 3, null);
                return Unit.INSTANCE;
            }
        }
        c0598cm = new C0598cm(this, continuation);
        Object obj2 = c0598cm.f8414f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c0598cm.f8416h;
        if (i == 0) {
        }
        BuildersKt.launch$default(c1127dm.f16414c, null, null, new C0562bm(flow, c1127dm.f16415d, c1127dm.f16413b, null), 3, null);
        return Unit.INSTANCE;
    }
}
