package p000;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

/* renamed from: hm */
/* loaded from: classes2.dex */
public final class C1274hm implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.ObjectRef f18094a;

    /* renamed from: b */
    public final /* synthetic */ CoroutineScope f18095b;

    /* renamed from: c */
    public final /* synthetic */ ChannelFlowTransformLatest f18096c;

    /* renamed from: d */
    public final /* synthetic */ FlowCollector f18097d;

    public C1274hm(Ref.ObjectRef objectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector) {
        this.f18094a = objectRef;
        this.f18095b = coroutineScope;
        this.f18096c = channelFlowTransformLatest;
        this.f18097d = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, kotlinx.coroutines.Job] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Object obj, Continuation continuation) {
        C1237gm c1237gm;
        int i;
        C1274hm c1274hm;
        if (continuation instanceof C1237gm) {
            c1237gm = (C1237gm) continuation;
            int i2 = c1237gm.f17758i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1237gm.f17758i = i2 - Integer.MIN_VALUE;
                Object obj2 = c1237gm.f17756g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1237gm.f17758i;
                if (i == 0) {
                    if (i == 1) {
                        obj = c1237gm.f17754e;
                        c1274hm = c1237gm.f17753d;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Job job = (Job) this.f18094a.element;
                    if (job != null) {
                        job.cancel((CancellationException) new ChildCancelledException());
                        c1237gm.f17753d = this;
                        c1237gm.f17754e = obj;
                        c1237gm.f17755f = job;
                        c1237gm.f17758i = 1;
                        if (job.join(c1237gm) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    c1274hm = this;
                }
                c1274hm.f18094a.element = BuildersKt.launch$default(c1274hm.f18095b, null, CoroutineStart.UNDISPATCHED, new C1200fm(c1274hm.f18096c, c1274hm.f18097d, obj, null), 1, null);
                return Unit.INSTANCE;
            }
        }
        c1237gm = new C1237gm(this, continuation);
        Object obj22 = c1237gm.f17756g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1237gm.f17758i;
        if (i == 0) {
        }
        c1274hm.f18094a.element = BuildersKt.launch$default(c1274hm.f18095b, null, CoroutineStart.UNDISPATCHED, new C1200fm(c1274hm.f18096c, c1274hm.f18097d, obj, null), 1, null);
        return Unit.INSTANCE;
    }
}
