package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.yh2;
import p000.zh2;

@Metadata(m5568d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u00019B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010 0\u001f2\u0006\u0010\u001e\u001a\u00020\u001aH\u0000¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020\u0003H\u0014¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001f2\u0006\u0010&\u001a\u00020\u0007H\u0014¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0017H\u0016¢\u0006\u0004\b)\u0010*J-\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u00100R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00028\u0000018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u001a\u00108\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b7\u0010*\u001a\u0004\b5\u00106\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, m5569d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "", "replay", "bufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "tryEmit", "(Ljava/lang/Object;)Z", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "()J", "updateNewCollectorIndexLocked", "oldIndex", "", "Lkotlin/coroutines/Continuation;", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateCollectorIndexLocked", "createSlot", "()Lkotlinx/coroutines/flow/SharedFlowSlot;", "size", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "resetReplayCache", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "getLastReplayedLocked", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "lastReplayedLocked", "yh2", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,731:1\n28#2,4:732\n28#2,4:738\n28#2,4:760\n28#2,4:767\n28#2,4:779\n28#2,4:793\n28#2,4:807\n20#3:736\n20#3:742\n20#3:764\n20#3:771\n20#3:783\n20#3:797\n20#3:811\n329#4:737\n1#5:743\n94#6,2:744\n96#6,2:747\n98#6:750\n94#6,2:772\n96#6,2:775\n98#6:778\n94#6,2:800\n96#6,2:803\n98#6:806\n13579#7:746\n13580#7:749\n13579#7:774\n13580#7:777\n13579#7:802\n13580#7:805\n314#8,9:751\n323#8,2:765\n314#8,9:784\n323#8,2:798\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n351#1:732,4\n391#1:738,4\n485#1:760,4\n506#1:767,4\n626#1:779,4\n661#1:793,4\n689#1:807,4\n351#1:736\n391#1:742\n485#1:764\n506#1:771\n626#1:783\n661#1:797\n689#1:811\n373#1:737\n453#1:744,2\n453#1:747,2\n453#1:750\n529#1:772,2\n529#1:775,2\n529#1:778\n676#1:800,2\n676#1:803,2\n676#1:806\n453#1:746\n453#1:749\n529#1:774\n529#1:777\n676#1:802\n676#1:805\n483#1:751,9\n483#1:765,2\n660#1:784,9\n660#1:798,2\n*E\n"})
/* loaded from: classes2.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {

    /* renamed from: e */
    public final int f21956e;

    /* renamed from: f */
    public final int f21957f;

    /* renamed from: g */
    public final BufferOverflow f21958g;

    /* renamed from: h */
    public Object[] f21959h;

    /* renamed from: i */
    public long f21960i;

    /* renamed from: j */
    public long f21961j;

    /* renamed from: k */
    public int f21962k;

    /* renamed from: l */
    public int f21963l;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SharedFlowImpl(int i, int i2, @NotNull BufferOverflow bufferOverflow) {
        this.f21956e = i;
        this.f21957f = i2;
        this.f21958g = bufferOverflow;
    }

    public static final void access$cancelEmitter(SharedFlowImpl sharedFlowImpl, yh2 yh2Var) {
        synchronized (sharedFlowImpl) {
            if (yh2Var.f28959b >= sharedFlowImpl.m5719h()) {
                Object[] objArr = sharedFlowImpl.f21959h;
                Intrinsics.checkNotNull(objArr);
                if (SharedFlowKt.access$getBufferAt(objArr, yh2Var.f28959b) == yh2Var) {
                    SharedFlowKt.access$setBufferAt(objArr, yh2Var.f28959b, SharedFlowKt.NO_VALUE);
                    sharedFlowImpl.m5714b();
                }
            }
        }
    }

    public static final int access$getTotalSize(SharedFlowImpl sharedFlowImpl) {
        return sharedFlowImpl.f21962k + sharedFlowImpl.f21963l;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|(3:(6:(1:(1:11)(2:41|42))(1:43)|12|13|14|15|(3:16|(3:28|29|(2:31|32)(1:33))(4:18|(1:20)|21|(2:23|24)(1:26))|27))(4:44|45|46|47)|37|38)(5:53|54|55|(2:57|(1:59))|61)|48|49|15|(3:16|(0)(0)|27)))|64|6|(0)(0)|48|49|15|(3:16|(0)(0)|27)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
    
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00af A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object m5712c(SharedFlowImpl sharedFlowImpl, FlowCollector flowCollector, Continuation continuation) {
        zh2 zh2Var;
        int i;
        SharedFlowImpl sharedFlowImpl2;
        Throwable th;
        SharedFlowSlot sharedFlowSlot;
        FlowCollector flowCollector2;
        Job job;
        FlowCollector flowCollector3;
        Object m5723l;
        Job job2;
        FlowCollector flowCollector4;
        if (continuation instanceof zh2) {
            zh2Var = (zh2) continuation;
            int i2 = zh2Var.f29383j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zh2Var.f29383j = i2 - Integer.MIN_VALUE;
                Object obj = zh2Var.f29381h;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = zh2Var.f29383j;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                job2 = zh2Var.f29380g;
                                sharedFlowSlot = zh2Var.f29379f;
                                flowCollector4 = zh2Var.f29378e;
                                sharedFlowImpl2 = zh2Var.f29377d;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            job2 = zh2Var.f29380g;
                            sharedFlowSlot = zh2Var.f29379f;
                            flowCollector4 = zh2Var.f29378e;
                            sharedFlowImpl2 = zh2Var.f29377d;
                        }
                        try {
                            ResultKt.throwOnFailure(obj);
                            flowCollector3 = flowCollector4;
                            job = job2;
                            sharedFlowImpl = sharedFlowImpl2;
                            while (true) {
                                m5723l = sharedFlowImpl.m5723l(sharedFlowSlot);
                                if (m5723l == SharedFlowKt.NO_VALUE) {
                                    zh2Var.f29377d = sharedFlowImpl;
                                    zh2Var.f29378e = flowCollector3;
                                    zh2Var.f29379f = sharedFlowSlot;
                                    zh2Var.f29380g = job;
                                    zh2Var.f29383j = 2;
                                    if (sharedFlowImpl.m5713a(sharedFlowSlot, zh2Var) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (job != null) {
                                        JobKt.ensureActive(job);
                                    }
                                    zh2Var.f29377d = sharedFlowImpl;
                                    zh2Var.f29378e = flowCollector3;
                                    zh2Var.f29379f = sharedFlowSlot;
                                    zh2Var.f29380g = job;
                                    zh2Var.f29383j = 3;
                                    if (flowCollector3.emit(m5723l, zh2Var) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        sharedFlowSlot = zh2Var.f29379f;
                        FlowCollector flowCollector5 = zh2Var.f29378e;
                        SharedFlowImpl sharedFlowImpl3 = zh2Var.f29377d;
                        try {
                            ResultKt.throwOnFailure(obj);
                            flowCollector2 = flowCollector5;
                            sharedFlowImpl = sharedFlowImpl3;
                        } catch (Throwable th3) {
                            th = th3;
                            sharedFlowImpl2 = sharedFlowImpl3;
                        }
                    }
                    sharedFlowImpl2.freeSlot(sharedFlowSlot);
                    throw th;
                }
                ResultKt.throwOnFailure(obj);
                SharedFlowSlot allocateSlot = sharedFlowImpl.allocateSlot();
                try {
                    if (flowCollector instanceof SubscribedFlowCollector) {
                        zh2Var.f29377d = sharedFlowImpl;
                        zh2Var.f29378e = flowCollector;
                        zh2Var.f29379f = allocateSlot;
                        zh2Var.f29383j = 1;
                        if (((SubscribedFlowCollector) flowCollector).onSubscription(zh2Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    flowCollector2 = flowCollector;
                    sharedFlowSlot = allocateSlot;
                } catch (Throwable th4) {
                    sharedFlowImpl2 = sharedFlowImpl;
                    th = th4;
                    sharedFlowSlot = allocateSlot;
                }
                job = (Job) zh2Var.getF20923a().get(Job.INSTANCE);
                flowCollector3 = flowCollector2;
                while (true) {
                    m5723l = sharedFlowImpl.m5723l(sharedFlowSlot);
                    if (m5723l == SharedFlowKt.NO_VALUE) {
                    }
                }
            }
        }
        zh2Var = new zh2(sharedFlowImpl, continuation);
        Object obj2 = zh2Var.f29381h;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = zh2Var.f29383j;
        if (i == 0) {
        }
        job = (Job) zh2Var.getF20923a().get(Job.INSTANCE);
        flowCollector3 = flowCollector2;
        while (true) {
            m5723l = sharedFlowImpl.m5723l(sharedFlowSlot);
            if (m5723l == SharedFlowKt.NO_VALUE) {
            }
        }
    }

    public static /* synthetic */ void getLastReplayedLocked$annotations() {
    }

    /* renamed from: a */
    public final Object m5713a(SharedFlowSlot sharedFlowSlot, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (m5722k(sharedFlowSlot) < 0) {
                    sharedFlowSlot.cont = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: b */
    public final void m5714b() {
        if (this.f21957f == 0 && this.f21963l <= 1) {
            return;
        }
        Object[] objArr = this.f21959h;
        Intrinsics.checkNotNull(objArr);
        while (this.f21963l > 0 && SharedFlowKt.access$getBufferAt(objArr, (m5719h() + (this.f21962k + this.f21963l)) - 1) == SharedFlowKt.NO_VALUE) {
            this.f21963l--;
            SharedFlowKt.access$setBufferAt(objArr, m5719h() + this.f21962k + this.f21963l, null);
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<?> continuation) {
        return m5712c(this, flowCollector, continuation);
    }

    /* renamed from: d */
    public final void m5715d() {
        AbstractSharedFlowSlot[] access$getSlots;
        Object[] objArr = this.f21959h;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.access$setBufferAt(objArr, m5719h(), null);
        this.f21962k--;
        long m5719h = m5719h() + 1;
        if (this.f21960i < m5719h) {
            this.f21960i = m5719h;
        }
        if (this.f21961j < m5719h) {
            if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
                for (AbstractSharedFlowSlot abstractSharedFlowSlot : access$getSlots) {
                    if (abstractSharedFlowSlot != null) {
                        SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                        long j = sharedFlowSlot.index;
                        if (j >= 0 && j < m5719h) {
                            sharedFlowSlot.index = m5719h;
                        }
                    }
                }
            }
            this.f21961j = m5719h;
        }
    }

    /* renamed from: e */
    public final Object m5716e(Object obj, Continuation continuation) {
        Continuation<Unit>[] continuationArr;
        yh2 yh2Var;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                if (m5721j(obj)) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
                    continuationArr = m5718g(continuationArr2);
                    yh2Var = null;
                } else {
                    yh2 yh2Var2 = new yh2(this, access$getTotalSize(this) + m5719h(), obj, cancellableContinuationImpl);
                    m5717f(yh2Var2);
                    this.f21963l++;
                    if (this.f21957f == 0) {
                        continuationArr2 = m5718g(continuationArr2);
                    }
                    continuationArr = continuationArr2;
                    yh2Var = yh2Var2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (yh2Var != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, yh2Var);
        }
        for (Continuation<Unit> continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        if (tryEmit(t)) {
            return Unit.INSTANCE;
        }
        Object m5716e = m5716e(t, continuation);
        if (m5716e != b51.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return m5716e;
    }

    /* renamed from: f */
    public final void m5717f(Object obj) {
        int i = this.f21962k + this.f21963l;
        Object[] objArr = this.f21959h;
        if (objArr == null) {
            objArr = m5720i(0, 2, null);
        } else if (i >= objArr.length) {
            objArr = m5720i(i, objArr.length * 2, objArr);
        }
        SharedFlowKt.access$setBufferAt(objArr, m5719h() + i, obj);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, context, capacity, onBufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    /* renamed from: g */
    public final Continuation[] m5718g(Continuation[] continuationArr) {
        AbstractSharedFlowSlot[] access$getSlots;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super Unit> continuation;
        int length = continuationArr.length;
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            int length2 = access$getSlots.length;
            int i = 0;
            continuationArr = continuationArr;
            while (i < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = access$getSlots[i];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && m5722k(sharedFlowSlot) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        continuationArr = copyOf;
                    }
                    continuationArr[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i++;
                continuationArr = continuationArr;
            }
        }
        return continuationArr;
    }

    public final T getLastReplayedLocked() {
        Object[] objArr = this.f21959h;
        Intrinsics.checkNotNull(objArr);
        return (T) SharedFlowKt.access$getBufferAt(objArr, (this.f21960i + ((int) ((m5719h() + this.f21962k) - this.f21960i))) - 1);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        synchronized (this) {
            int m5719h = (int) ((m5719h() + this.f21962k) - this.f21960i);
            if (m5719h == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(m5719h);
            Object[] objArr = this.f21959h;
            Intrinsics.checkNotNull(objArr);
            for (int i = 0; i < m5719h; i++) {
                arrayList.add(SharedFlowKt.access$getBufferAt(objArr, this.f21960i + i));
            }
            return arrayList;
        }
    }

    /* renamed from: h */
    public final long m5719h() {
        return Math.min(this.f21961j, this.f21960i);
    }

    /* renamed from: i */
    public final Object[] m5720i(int i, int i2, Object[] objArr) {
        if (i2 > 0) {
            Object[] objArr2 = new Object[i2];
            this.f21959h = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long m5719h = m5719h();
            for (int i3 = 0; i3 < i; i3++) {
                long j = i3 + m5719h;
                SharedFlowKt.access$setBufferAt(objArr2, j, SharedFlowKt.access$getBufferAt(objArr, j));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow");
    }

    /* renamed from: j */
    public final boolean m5721j(Object obj) {
        int nCollectors = getNCollectors();
        int i = this.f21956e;
        if (nCollectors == 0) {
            if (i != 0) {
                m5717f(obj);
                int i2 = this.f21962k + 1;
                this.f21962k = i2;
                if (i2 > i) {
                    m5715d();
                }
                this.f21961j = m5719h() + this.f21962k;
            }
            return true;
        }
        int i3 = this.f21962k;
        int i4 = this.f21957f;
        if (i3 >= i4 && this.f21961j <= this.f21960i) {
            int i5 = WhenMappings.$EnumSwitchMapping$0[this.f21958g.ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        m5717f(obj);
        int i6 = this.f21962k + 1;
        this.f21962k = i6;
        if (i6 > i4) {
            m5715d();
        }
        long m5719h = m5719h() + this.f21962k;
        long j = this.f21960i;
        if (((int) (m5719h - j)) > i) {
            m5724m(j + 1, this.f21961j, m5719h() + this.f21962k, m5719h() + this.f21962k + this.f21963l);
        }
        return true;
    }

    /* renamed from: k */
    public final long m5722k(SharedFlowSlot sharedFlowSlot) {
        long j = sharedFlowSlot.index;
        if (j < m5719h() + this.f21962k) {
            return j;
        }
        if (this.f21957f > 0 || j > m5719h() || this.f21963l == 0) {
            return -1L;
        }
        return j;
    }

    /* renamed from: l */
    public final Object m5723l(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                long m5722k = m5722k(sharedFlowSlot);
                if (m5722k < 0) {
                    obj = SharedFlowKt.NO_VALUE;
                } else {
                    long j = sharedFlowSlot.index;
                    Object[] objArr = this.f21959h;
                    Intrinsics.checkNotNull(objArr);
                    Object access$getBufferAt = SharedFlowKt.access$getBufferAt(objArr, m5722k);
                    if (access$getBufferAt instanceof yh2) {
                        access$getBufferAt = ((yh2) access$getBufferAt).f28960c;
                    }
                    sharedFlowSlot.index = m5722k + 1;
                    Object obj2 = access$getBufferAt;
                    continuationArr = updateCollectorIndexLocked$kotlinx_coroutines_core(j);
                    obj = obj2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    /* renamed from: m */
    public final void m5724m(long j, long j2, long j3, long j4) {
        long min = Math.min(j2, j);
        for (long m5719h = m5719h(); m5719h < min; m5719h++) {
            Object[] objArr = this.f21959h;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.access$setBufferAt(objArr, m5719h, null);
        }
        this.f21960i = j;
        this.f21961j = j2;
        this.f21962k = (int) (j3 - min);
        this.f21963l = (int) (j4 - j3);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            m5724m(m5719h() + this.f21962k, this.f21961j, m5719h() + this.f21962k, m5719h() + this.f21962k + this.f21963l);
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        int i;
        boolean z;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (m5721j(value)) {
                continuationArr = m5718g(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
            }
        }
        return z;
    }

    @NotNull
    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long oldIndex) {
        int i;
        long j;
        long j2;
        long j3;
        AbstractSharedFlowSlot[] access$getSlots;
        if (oldIndex > this.f21961j) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long m5719h = m5719h();
        long j4 = this.f21962k + m5719h;
        int i2 = this.f21957f;
        if (i2 == 0 && this.f21963l > 0) {
            j4++;
        }
        int i3 = 0;
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : access$getSlots) {
                if (abstractSharedFlowSlot != null) {
                    long j5 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j5 >= 0 && j5 < j4) {
                        j4 = j5;
                    }
                }
            }
        }
        if (j4 <= this.f21961j) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long m5719h2 = m5719h() + this.f21962k;
        if (getNCollectors() > 0) {
            i = Math.min(this.f21963l, i2 - ((int) (m5719h2 - j4)));
        } else {
            i = this.f21963l;
        }
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j6 = this.f21963l + m5719h2;
        if (i > 0) {
            continuationArr = new Continuation[i];
            Object[] objArr = this.f21959h;
            Intrinsics.checkNotNull(objArr);
            long j7 = m5719h2;
            while (true) {
                if (m5719h2 < j6) {
                    j = j4;
                    Object access$getBufferAt = SharedFlowKt.access$getBufferAt(objArr, m5719h2);
                    Symbol symbol = SharedFlowKt.NO_VALUE;
                    j2 = j6;
                    if (access$getBufferAt != symbol) {
                        Intrinsics.checkNotNull(access$getBufferAt, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                        yh2 yh2Var = (yh2) access$getBufferAt;
                        int i4 = i3 + 1;
                        continuationArr[i3] = yh2Var.f28961d;
                        SharedFlowKt.access$setBufferAt(objArr, m5719h2, symbol);
                        SharedFlowKt.access$setBufferAt(objArr, j7, yh2Var.f28960c);
                        j3 = 1;
                        j7++;
                        if (i4 >= i) {
                            break;
                        }
                        i3 = i4;
                    } else {
                        j3 = 1;
                    }
                    m5719h2 += j3;
                    j4 = j;
                    j6 = j2;
                } else {
                    j = j4;
                    j2 = j6;
                    break;
                }
            }
            m5719h2 = j7;
        } else {
            j = j4;
            j2 = j6;
        }
        int i5 = (int) (m5719h2 - m5719h);
        if (getNCollectors() == 0) {
            j = m5719h2;
        }
        long max = Math.max(this.f21960i, m5719h2 - Math.min(this.f21956e, i5));
        if (i2 == 0 && max < j2) {
            Object[] objArr2 = this.f21959h;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(objArr2, max), SharedFlowKt.NO_VALUE)) {
                m5719h2++;
                max++;
            }
        }
        m5724m(max, j, m5719h2, j2);
        m5714b();
        if (continuationArr.length != 0) {
            return m5718g(continuationArr);
        }
        return continuationArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j = this.f21960i;
        if (j < this.f21961j) {
            this.f21961j = j;
        }
        return j;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    public SharedFlowSlot[] createSlotArray(int size) {
        return new SharedFlowSlot[size];
    }
}
