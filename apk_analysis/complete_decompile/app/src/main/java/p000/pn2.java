package p000;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.SubscribedFlowCollector;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class pn2 extends AbstractSharedFlow implements MutableStateFlow, CancellableFlow, FusibleFlow {

    /* renamed from: f */
    public static final AtomicReferenceFieldUpdater f25235f = AtomicReferenceFieldUpdater.newUpdater(pn2.class, Object.class, "_state");

    @Volatile
    @Nullable
    private volatile Object _state;

    /* renamed from: e */
    public int f25236e;

    public pn2(Object obj) {
        this._state = obj;
    }

    /* renamed from: a */
    public final boolean m6919a(Object obj, Object obj2) {
        int i;
        AbstractSharedFlowSlot[] slots;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f25235f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !Intrinsics.areEqual(obj3, obj)) {
                return false;
            }
            if (Intrinsics.areEqual(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i2 = this.f25236e;
            if ((i2 & 1) == 0) {
                int i3 = i2 + 1;
                this.f25236e = i3;
                AbstractSharedFlowSlot[] slots2 = getSlots();
                while (true) {
                    qn2[] qn2VarArr = (qn2[]) slots2;
                    if (qn2VarArr != null) {
                        for (qn2 qn2Var : qn2VarArr) {
                            if (qn2Var != null) {
                                while (true) {
                                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = qn2.f25701a;
                                    Object obj4 = atomicReferenceFieldUpdater2.get(qn2Var);
                                    if (obj4 == null) {
                                        break;
                                    }
                                    symbol = StateFlowKt.f21969b;
                                    if (obj4 == symbol) {
                                        break;
                                    }
                                    symbol2 = StateFlowKt.f21968a;
                                    if (obj4 == symbol2) {
                                        symbol3 = StateFlowKt.f21969b;
                                        while (!atomicReferenceFieldUpdater2.compareAndSet(qn2Var, obj4, symbol3)) {
                                            if (atomicReferenceFieldUpdater2.get(qn2Var) != obj4) {
                                                break;
                                            }
                                        }
                                    } else {
                                        symbol4 = StateFlowKt.f21968a;
                                        while (!atomicReferenceFieldUpdater2.compareAndSet(qn2Var, obj4, symbol4)) {
                                            if (atomicReferenceFieldUpdater2.get(qn2Var) != obj4) {
                                                break;
                                            }
                                        }
                                        Result.Companion companion = Result.INSTANCE;
                                        ((CancellableContinuationImpl) obj4).resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    synchronized (this) {
                        i = this.f25236e;
                        if (i == i3) {
                            this.f25236e = i3 + 1;
                            return true;
                        }
                        slots = getSlots();
                    }
                    slots2 = slots;
                    i3 = i;
                }
            } else {
                this.f25236e = i2 + 2;
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a4, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r11, r12) == false) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009b A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0036, B:14:0x0093, B:16:0x009b, B:18:0x00a0, B:20:0x00c1, B:23:0x00d8, B:27:0x00a6, B:30:0x00ad, B:39:0x004f, B:41:0x005a, B:42:0x0084), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0036, B:14:0x0093, B:16:0x009b, B:18:0x00a0, B:20:0x00c1, B:23:0x00d8, B:27:0x00a6, B:30:0x00ad, B:39:0x004f, B:41:0x005a, B:42:0x0084), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d8 A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0036, B:14:0x0093, B:16:0x009b, B:18:0x00a0, B:20:0x00c1, B:23:0x00d8, B:27:0x00a6, B:30:0x00ad, B:39:0x004f, B:41:0x005a, B:42:0x0084), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7, types: [qn2] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00d7 -> B:14:0x0093). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00e8 -> B:14:0x0093). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        on2 on2Var;
        Object coroutine_suspended;
        int i;
        pn2 pn2Var;
        qn2 qn2Var;
        FlowCollector flowCollector2;
        Job job;
        Object obj;
        qn2 qn2Var2;
        Symbol symbol;
        Object andSet;
        Symbol symbol2;
        Object obj2;
        Object obj3;
        try {
            if (continuation instanceof on2) {
                on2Var = (on2) continuation;
                int i2 = on2Var.f24843k;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    on2Var.f24843k = i2 - Integer.MIN_VALUE;
                    Object obj4 = on2Var.f24841i;
                    coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = on2Var.f24843k;
                    ?? r6 = 1;
                    if (i == 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    obj = on2Var.f24840h;
                                    job = on2Var.f24839g;
                                    qn2 qn2Var3 = on2Var.f24838f;
                                    flowCollector2 = on2Var.f24837e;
                                    pn2Var = on2Var.f24836d;
                                    ResultKt.throwOnFailure(obj4);
                                    r6 = qn2Var3;
                                    obj2 = f25235f.get(pn2Var);
                                    if (job != null) {
                                        JobKt.ensureActive(job);
                                    }
                                    if (obj != null) {
                                        qn2Var2 = r6;
                                    }
                                    if (obj2 == NullSurrogateKt.NULL) {
                                        obj3 = null;
                                    } else {
                                        obj3 = obj2;
                                    }
                                    on2Var.f24836d = pn2Var;
                                    on2Var.f24837e = flowCollector2;
                                    on2Var.f24838f = r6;
                                    on2Var.f24839g = job;
                                    on2Var.f24840h = obj2;
                                    on2Var.f24843k = 2;
                                    if (flowCollector2.emit(obj3, on2Var) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj = obj2;
                                    qn2Var2 = r6;
                                    qn2Var2.getClass();
                                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = qn2.f25701a;
                                    symbol = StateFlowKt.f21968a;
                                    andSet = atomicReferenceFieldUpdater.getAndSet(qn2Var2, symbol);
                                    Intrinsics.checkNotNull(andSet);
                                    symbol2 = StateFlowKt.f21969b;
                                    if (andSet != symbol2) {
                                        r6 = qn2Var2;
                                    } else {
                                        on2Var.f24836d = pn2Var;
                                        on2Var.f24837e = flowCollector2;
                                        on2Var.f24838f = qn2Var2;
                                        on2Var.f24839g = job;
                                        on2Var.f24840h = obj;
                                        on2Var.f24843k = 3;
                                        Object m7113a = qn2Var2.m7113a(on2Var);
                                        r6 = qn2Var2;
                                        if (m7113a == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    obj2 = f25235f.get(pn2Var);
                                    if (job != null) {
                                    }
                                    if (obj != null) {
                                    }
                                    if (obj2 == NullSurrogateKt.NULL) {
                                    }
                                    on2Var.f24836d = pn2Var;
                                    on2Var.f24837e = flowCollector2;
                                    on2Var.f24838f = r6;
                                    on2Var.f24839g = job;
                                    on2Var.f24840h = obj2;
                                    on2Var.f24843k = 2;
                                    if (flowCollector2.emit(obj3, on2Var) == coroutine_suspended) {
                                    }
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                obj = on2Var.f24840h;
                                job = on2Var.f24839g;
                                qn2 qn2Var4 = on2Var.f24838f;
                                flowCollector2 = on2Var.f24837e;
                                pn2Var = on2Var.f24836d;
                                ResultKt.throwOnFailure(obj4);
                                qn2Var2 = qn2Var4;
                                qn2Var2.getClass();
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = qn2.f25701a;
                                symbol = StateFlowKt.f21968a;
                                andSet = atomicReferenceFieldUpdater2.getAndSet(qn2Var2, symbol);
                                Intrinsics.checkNotNull(andSet);
                                symbol2 = StateFlowKt.f21969b;
                                if (andSet != symbol2) {
                                }
                                obj2 = f25235f.get(pn2Var);
                                if (job != null) {
                                }
                                if (obj != null) {
                                }
                                if (obj2 == NullSurrogateKt.NULL) {
                                }
                                on2Var.f24836d = pn2Var;
                                on2Var.f24837e = flowCollector2;
                                on2Var.f24838f = r6;
                                on2Var.f24839g = job;
                                on2Var.f24840h = obj2;
                                on2Var.f24843k = 2;
                                if (flowCollector2.emit(obj3, on2Var) == coroutine_suspended) {
                                }
                            }
                        } else {
                            qn2 qn2Var5 = on2Var.f24838f;
                            flowCollector = on2Var.f24837e;
                            pn2Var = on2Var.f24836d;
                            ResultKt.throwOnFailure(obj4);
                            qn2Var = qn2Var5;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj4);
                        qn2 qn2Var6 = (qn2) allocateSlot();
                        try {
                            if (flowCollector instanceof SubscribedFlowCollector) {
                                on2Var.f24836d = this;
                                on2Var.f24837e = flowCollector;
                                on2Var.f24838f = qn2Var6;
                                on2Var.f24843k = 1;
                                if (((SubscribedFlowCollector) flowCollector).onSubscription(on2Var) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            pn2Var = this;
                            qn2Var = qn2Var6;
                        } catch (Throwable th) {
                            th = th;
                            pn2Var = this;
                            r6 = qn2Var6;
                            pn2Var.freeSlot(r6);
                            throw th;
                        }
                    }
                    flowCollector2 = flowCollector;
                    job = (Job) on2Var.getContext().get(Job.INSTANCE);
                    obj = null;
                    r6 = qn2Var;
                    obj2 = f25235f.get(pn2Var);
                    if (job != null) {
                    }
                    if (obj != null) {
                    }
                    if (obj2 == NullSurrogateKt.NULL) {
                    }
                    on2Var.f24836d = pn2Var;
                    on2Var.f24837e = flowCollector2;
                    on2Var.f24838f = r6;
                    on2Var.f24839g = job;
                    on2Var.f24840h = obj2;
                    on2Var.f24843k = 2;
                    if (flowCollector2.emit(obj3, on2Var) == coroutine_suspended) {
                    }
                }
            }
            if (i == 0) {
            }
            flowCollector2 = flowCollector;
            job = (Job) on2Var.getContext().get(Job.INSTANCE);
            obj = null;
            r6 = qn2Var;
            obj2 = f25235f.get(pn2Var);
            if (job != null) {
            }
            if (obj != null) {
            }
            if (obj2 == NullSurrogateKt.NULL) {
            }
            on2Var.f24836d = pn2Var;
            on2Var.f24837e = flowCollector2;
            on2Var.f24838f = r6;
            on2Var.f24839g = job;
            on2Var.f24840h = obj2;
            on2Var.f24843k = 2;
            if (flowCollector2.emit(obj3, on2Var) == coroutine_suspended) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        on2Var = new on2(this, continuation);
        Object obj42 = on2Var.f24841i;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = on2Var.f24843k;
        ?? r62 = 1;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public final boolean compareAndSet(Object obj, Object obj2) {
        if (obj == null) {
            obj = NullSurrogateKt.NULL;
        }
        if (obj2 == null) {
            obj2 = NullSurrogateKt.NULL;
        }
        return m6919a(obj, obj2);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot createSlot() {
        return new AbstractSharedFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot[] createSlotArray(int i) {
        return new qn2[i];
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        setValue(obj);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public final List getReplayCache() {
        return AbstractC1167eq.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        Object obj = f25235f.get(this);
        if (obj == symbol) {
            return null;
        }
        return obj;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public final void setValue(Object obj) {
        if (obj == null) {
            obj = NullSurrogateKt.NULL;
        }
        m6919a(null, obj);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(Object obj) {
        setValue(obj);
        return true;
    }
}
