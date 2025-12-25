package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NopCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0022al;
import p000.C0023am;
import p000.C0561bl;
import p000.C1223g8;
import p000.C1949wk;
import p000.C1987xl;
import p000.C2026yn;
import p000.a92;
import p000.ag0;
import p000.b51;
import p000.b92;
import p000.bg0;
import p000.bi2;
import p000.ch0;
import p000.dh0;
import p000.di0;
import p000.fh0;
import p000.gg0;
import p000.gh0;
import p000.ha0;
import p000.hh0;
import p000.hi0;
import p000.ih0;
import p000.jg0;
import p000.jh0;
import p000.ji0;
import p000.kg0;
import p000.kh0;
import p000.lh0;
import p000.mh0;
import p000.nf0;
import p000.nh0;
import p000.o63;
import p000.of0;
import p000.pf0;
import p000.pg0;
import p000.ph0;
import p000.qf0;
import p000.qh0;
import p000.rf0;
import p000.rg0;
import p000.rh0;
import p000.s80;
import p000.sh0;
import p000.tf0;
import p000.tg0;
import p000.th0;
import p000.ud2;
import p000.uf0;
import p000.vf0;
import p000.vh0;
import p000.wg0;
import p000.wh0;
import p000.xh0;
import p000.ye0;
import p000.yg0;
import p000.yh0;
import p000.yp2;
import p000.zh0;

@Metadata(m5568d1 = {"o63", "kg0", "og0", "dh0", "gh0", "zh0", "kotlinx/coroutines/flow/b"}, m5569d2 = {}, m5570k = 4, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class FlowKt {

    @NotNull
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    @Deprecated(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull final BroadcastChannel<T> broadcastChannel) {
        return (Flow<T>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object emitAll = FlowKt.emitAll(flowCollector, BroadcastChannel.this.openSubscription(), continuation);
                if (emitAll == b51.getCOROUTINE_SUSPENDED()) {
                    return emitAll;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> SharedFlow<T> asSharedFlow(@NotNull MutableSharedFlow<T> mutableSharedFlow) {
        return new a92(mutableSharedFlow, null);
    }

    @NotNull
    public static final <T> StateFlow<T> asStateFlow(@NotNull MutableStateFlow<T> mutableStateFlow) {
        return new b92(mutableStateFlow, null);
    }

    @NotNull
    public static final <T> Flow<T> buffer(@NotNull Flow<? extends T> flow, int i, @NotNull BufferOverflow bufferOverflow) {
        if (i < 0 && i != -2 && i != -1) {
            throw new IllegalArgumentException(ye0.m8291k(i, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ").toString());
        }
        if (i == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i == -1) {
            bufferOverflow = BufferOverflow.DROP_OLDEST;
            i = 0;
        }
        int i2 = i;
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if (flow instanceof FusibleFlow) {
            return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, null, i2, bufferOverflow2, 1, null);
        }
        return new ChannelFlowOperatorImpl(flow, null, i2, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return buffer(flow, i, bufferOverflow);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @NotNull
    public static final <T> Flow<T> cache(@NotNull Flow<? extends T> flow) {
        throw ye0.m8305y();
    }

    @NotNull
    public static final <T> Flow<T> callbackFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new C1949wk(function2, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Flow<T> cancellable(@NotNull Flow<? extends T> flow) {
        if (!(flow instanceof CancellableFlow)) {
            return new C0561bl(flow);
        }
        return flow;
    }

    @NotNull
    /* renamed from: catch, reason: not valid java name */
    public static final <T> Flow<T> m8883catch(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(flow, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object catchImpl(@NotNull Flow<? extends T> flow, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Throwable> continuation) {
        pg0 pg0Var;
        int i;
        Throwable th;
        Ref.ObjectRef objectRef;
        Throwable th2;
        Job job;
        CancellationException cancellationException;
        if (continuation instanceof pg0) {
            pg0 pg0Var2 = (pg0) continuation;
            int i2 = pg0Var2.f25161f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pg0Var2.f25161f = i2 - Integer.MIN_VALUE;
                pg0Var = pg0Var2;
                Object obj = pg0Var.f25160e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = pg0Var.f25161f;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = pg0Var.f25159d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = (Throwable) objectRef.element;
                            if (th2 != null) {
                            }
                            job = (Job) pg0Var.getContext().get(Job.INSTANCE);
                            if (job == null) {
                            }
                            if (th2 != null) {
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    try {
                        FlowCollector<? super Object> rg0Var = new rg0(flowCollector, objectRef2);
                        pg0Var.f25159d = objectRef2;
                        pg0Var.f25161f = 1;
                        if (flow.collect(rg0Var, pg0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        objectRef = objectRef2;
                        th2 = (Throwable) objectRef.element;
                        if (th2 != null || !Intrinsics.areEqual(th2, th)) {
                            job = (Job) pg0Var.getContext().get(Job.INSTANCE);
                            if (job == null && job.isCancelled() && (cancellationException = job.getCancellationException()) != null && Intrinsics.areEqual(cancellationException, th)) {
                                throw th;
                            }
                            if (th2 != null) {
                                return th;
                            }
                            if (th instanceof CancellationException) {
                                ha0.addSuppressed(th2, th);
                                throw th2;
                            }
                            ha0.addSuppressed(th, th2);
                            throw th;
                        }
                        throw th;
                    }
                }
                return null;
            }
        }
        pg0Var = new ContinuationImpl(continuation);
        Object obj2 = pg0Var.f25160e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = pg0Var.f25161f;
        if (i == 0) {
        }
        return null;
    }

    @NotNull
    public static final <T> Flow<T> channelFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new C0023am(function2, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    @Nullable
    public static final Object collect(@NotNull Flow<?> flow, @NotNull Continuation<? super Unit> continuation) {
        Object collect = flow.collect(NopCollector.INSTANCE, continuation);
        return collect == b51.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @Nullable
    public static final <T> Object collectIndexed(@NotNull Flow<? extends T> flow, @NotNull Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, @NotNull Continuation<? super Unit> continuation) {
        Object collect = flow.collect(new FlowKt__CollectKt$collectIndexed$2(function3), continuation);
        if (collect != b51.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return collect;
    }

    @Nullable
    public static final <T> Object collectLatest(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object collect = collect(buffer$default(mapLatest(flow, function2), 0, null, 2, null), continuation);
        if (collect != b51.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return collect;
    }

    @Nullable
    public static final <T> Object collectWhile(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return dh0.m4584b(flow, function2, continuation);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return flowCombine(flow, flow2, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return combine(flow, flow2, function3);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return flow(new C1468xd7c321e7(new Flow[]{flow, flow2}, null, function4));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> compose(@NotNull Flow<? extends T> flow, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> concatMap(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends Flow<? extends R>> function1) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> flow, T t) {
        throw ye0.m8305y();
    }

    @NotNull
    public static final <T> Flow<T> conflate(@NotNull Flow<? extends T> flow) {
        return buffer$default(flow, -1, null, 2, null);
    }

    @NotNull
    public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return new C1987xl(receiveChannel, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super Integer> continuation) {
        pf0 pf0Var;
        int i;
        Ref.IntRef intRef;
        if (continuation instanceof pf0) {
            pf0 pf0Var2 = (pf0) continuation;
            int i2 = pf0Var2.f25147f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pf0Var2.f25147f = i2 - Integer.MIN_VALUE;
                pf0Var = pf0Var2;
                Object obj = pf0Var.f25146e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = pf0Var.f25147f;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    FlowCollector<? super Object> qf0Var = new qf0(intRef2);
                    pf0Var.f25145d = intRef2;
                    pf0Var.f25147f = 1;
                    if (flow.collect(qf0Var, pf0Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    intRef = pf0Var.f25145d;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        pf0Var = new ContinuationImpl(continuation);
        Object obj2 = pf0Var.f25146e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = pf0Var.f25147f;
        if (i != 0) {
        }
        return Boxing.boxInt(intRef.element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, long j) {
        if (j >= 0) {
            return j == 0 ? flow : FlowCoroutineKt.scopedFlow(new ag0(new uf0(j), flow, null));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    @FlowPreview
    @NotNull
    /* renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m8884debounceHG0u8IE(@NotNull Flow<? extends T> flow, long j) {
        return debounce(flow, DelayKt.m8850toDelayMillisLRDsOJo(j));
    }

    @FlowPreview
    @JvmName(name = "debounceDuration")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T> Flow<T> debounceDuration(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Duration> function1) {
        return FlowCoroutineKt.scopedFlow(new ag0(new vf0(0, function1), flow, null));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> delayEach(@NotNull Flow<? extends T> flow, long j) {
        return onEach(flow, new hh0(j, null));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> delayFlow(@NotNull Flow<? extends T> flow, long j) {
        return onStart(flow, new ih0(j, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> flow) {
        C1223g8 c1223g8 = kg0.f20844a;
        return flow instanceof StateFlow ? flow : kg0.m5528a(flow, kg0.f20844a, kg0.f20845b);
    }

    @NotNull
    public static final <T, K> Flow<T> distinctUntilChangedBy(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends K> function1) {
        return kg0.m5528a(flow, function1, kg0.f20845b);
    }

    @NotNull
    public static final <T> Flow<T> drop(@NotNull final Flow<? extends T> flow, final int i) {
        if (i >= 0) {
            return (Flow<T>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$$inlined$unsafeFlow$1
                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                    Object collect = Flow.this.collect(new wg0(new Ref.IntRef(), i, flowCollector), continuation);
                    if (collect == b51.getCOROUTINE_SUSPENDED()) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            };
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Drop count should be non-negative, but had ").toString());
    }

    @NotNull
    public static final <T> Flow<T> dropWhile(@NotNull final Flow<? extends T> flow, @NotNull final Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return (Flow<T>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object collect = Flow.this.collect(new yg0(new Ref.BooleanRef(), flowCollector, function2), continuation);
                if (collect == b51.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super Unit> continuation) {
        Object m6468k = o63.m6468k(flowCollector, receiveChannel, true, continuation);
        return m6468k == b51.getCOROUTINE_SUSPENDED() ? m6468k : Unit.INSTANCE;
    }

    @NotNull
    public static final <T> Flow<T> emptyFlow() {
        return s80.f26313a;
    }

    public static final void ensureActive(@NotNull FlowCollector<?> flowCollector) {
        if (!(flowCollector instanceof ThrowingCollector)) {
        } else {
            throw ((ThrowingCollector) flowCollector).e;
        }
    }

    @NotNull
    public static final <T> Flow<T> filter(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(flow, function2);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Collections.java:4483)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:103)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static final /* synthetic */ <R> kotlinx.coroutines.flow.Flow<R> filterIsInstance(kotlinx.coroutines.flow.Flow<?> r1) {
        /*
            kotlin.jvm.internal.Intrinsics.needClassReification()
            kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.filterIsInstance(kotlinx.coroutines.flow.Flow):kotlinx.coroutines.flow.Flow");
    }

    @NotNull
    public static final <T> Flow<T> filterNot(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> filterNotNull(@NotNull final Flow<? extends T> flow) {
        return (Flow<T>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            @Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n47#2,2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2 */
            /* loaded from: classes2.dex */
            public static final class C14552<T> implements FlowCollector {

                /* renamed from: a */
                public final /* synthetic */ FlowCollector f21798a;

                @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
                @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", m5601f = "Transform.kt", m5602i = {}, m5603l = {223}, m5604m = "emit", m5605n = {}, m5606s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: d */
                    public /* synthetic */ Object f21799d;

                    /* renamed from: e */
                    public int f21800e;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f21799d = obj;
                        this.f21800e |= Integer.MIN_VALUE;
                        return C14552.this.emit(null, this);
                    }
                }

                public C14552(FlowCollector flowCollector) {
                    this.f21798a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.f21800e;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f21800e = i2 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.f21799d;
                            Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.f21800e;
                            if (i == 0) {
                                if (i == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                if (t != null) {
                                    anonymousClass1.f21800e = 1;
                                    if (this.f21798a.emit(t, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.f21799d;
                    Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.f21800e;
                    if (i == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                Object collect = Flow.this.collect(new C14552(flowCollector), continuation);
                if (collect == b51.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object first(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        kh0 kh0Var;
        Object coroutine_suspended;
        int i;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$first$$inlined$collectWhile$1 flowKt__ReduceKt$first$$inlined$collectWhile$1;
        if (continuation instanceof kh0) {
            kh0 kh0Var2 = (kh0) continuation;
            int i2 = kh0Var2.f20856g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kh0Var2.f20856g = i2 - Integer.MIN_VALUE;
                kh0Var = kh0Var2;
                Object obj = kh0Var.f20855f;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = kh0Var.f20856g;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    ?? r2 = new FlowCollector<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public Object emit(Object obj2, @NotNull Continuation<? super Unit> continuation2) {
                            Ref.ObjectRef.this.element = obj2;
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        kh0Var.f20853d = objectRef2;
                        kh0Var.f20854e = r2;
                        kh0Var.f20856g = 1;
                        if (flow.collect(r2, kh0Var) != coroutine_suspended) {
                            objectRef = objectRef2;
                        }
                    } catch (AbortFlowException e2) {
                        objectRef = objectRef2;
                        e = e2;
                        flowKt__ReduceKt$first$$inlined$collectWhile$1 = r2;
                        FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$first$$inlined$collectWhile$1);
                        coroutine_suspended = objectRef.element;
                        if (coroutine_suspended == NullSurrogateKt.NULL) {
                        }
                        return coroutine_suspended;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowKt__ReduceKt$first$$inlined$collectWhile$1 = kh0Var.f20854e;
                objectRef = kh0Var.f20853d;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (AbortFlowException e3) {
                    e = e3;
                    FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$first$$inlined$collectWhile$1);
                    coroutine_suspended = objectRef.element;
                    if (coroutine_suspended == NullSurrogateKt.NULL) {
                    }
                    return coroutine_suspended;
                }
                coroutine_suspended = objectRef.element;
                if (coroutine_suspended == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Expected at least one element");
                }
                return coroutine_suspended;
            }
        }
        kh0Var = new ContinuationImpl(continuation);
        Object obj2 = kh0Var.f20855f;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = kh0Var.f20856g;
        if (i != 0) {
        }
        coroutine_suspended = objectRef.element;
        if (coroutine_suspended == NullSurrogateKt.NULL) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        mh0 mh0Var;
        int i;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1;
        if (continuation instanceof mh0) {
            mh0 mh0Var2 = (mh0) continuation;
            int i2 = mh0Var2.f22942g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                mh0Var2.f22942g = i2 - Integer.MIN_VALUE;
                mh0Var = mh0Var2;
                Object obj = mh0Var.f22941f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = mh0Var.f22942g;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    ?? r2 = new FlowCollector<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public Object emit(Object obj2, @NotNull Continuation<? super Unit> continuation2) {
                            Ref.ObjectRef.this.element = obj2;
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        mh0Var.f22939d = objectRef2;
                        mh0Var.f22940e = r2;
                        mh0Var.f22942g = 1;
                        if (flow.collect(r2, mh0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (AbortFlowException e2) {
                        objectRef = objectRef2;
                        e = e2;
                        flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 = r2;
                        FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1);
                        return objectRef.element;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 = mh0Var.f22940e;
                    objectRef = mh0Var.f22939d;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (AbortFlowException e3) {
                        e = e3;
                        FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1);
                        return objectRef.element;
                    }
                }
                return objectRef.element;
            }
        }
        mh0Var = new ContinuationImpl(continuation);
        Object obj2 = mh0Var.f22941f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = mh0Var.f22942g;
        if (i != 0) {
        }
        return objectRef.element;
    }

    @NotNull
    public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope coroutineScope, long j, long j2) {
        if (j >= 0) {
            if (j2 >= 0) {
                return ProduceKt.produce$default(coroutineScope, null, 0, new bg0(j2, j, null), 1, null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        return fixedPeriodTicker(coroutineScope, j, j2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> flatMap(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        throw ye0.m8305y();
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapConcat(@NotNull final Flow<? extends T> flow, @NotNull final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        int i = gh0.f17694a;
        return flattenConcat(new Flow<Flow<Object>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            @Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 */
            /* loaded from: classes2.dex */
            public static final class C14442<T> implements FlowCollector {

                /* renamed from: a */
                public final /* synthetic */ FlowCollector f21715a;

                /* renamed from: b */
                public final /* synthetic */ Function2 f21716b;

                @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
                @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", m5601f = "Merge.kt", m5602i = {}, m5603l = {223, 223}, m5604m = "emit", m5605n = {}, m5606s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: d */
                    public /* synthetic */ Object f21717d;

                    /* renamed from: e */
                    public int f21718e;

                    /* renamed from: f */
                    public FlowCollector f21719f;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f21717d = obj;
                        this.f21718e |= Integer.MIN_VALUE;
                        return C14442.this.emit(null, this);
                    }
                }

                public C14442(FlowCollector flowCollector, Function2 function2) {
                    this.f21715a = flowCollector;
                    this.f21716b = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object obj2;
                    Object coroutine_suspended;
                    int i;
                    FlowCollector flowCollector;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.f21718e;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f21718e = i2 - Integer.MIN_VALUE;
                            obj2 = anonymousClass1.f21717d;
                            coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.f21718e;
                            if (i == 0) {
                                if (i != 1) {
                                    if (i == 2) {
                                        ResultKt.throwOnFailure(obj2);
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                FlowCollector flowCollector2 = anonymousClass1.f21719f;
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = flowCollector2;
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector3 = this.f21715a;
                                anonymousClass1.f21719f = flowCollector3;
                                anonymousClass1.f21718e = 1;
                                Object invoke = this.f21716b.invoke(obj, anonymousClass1);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj2 = invoke;
                                flowCollector = flowCollector3;
                            }
                            anonymousClass1.f21719f = null;
                            anonymousClass1.f21718e = 2;
                            if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    obj2 = anonymousClass1.f21717d;
                    coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.f21718e;
                    if (i == 0) {
                    }
                    anonymousClass1.f21719f = null;
                    anonymousClass1.f21718e = 2;
                    if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Flow<Object>> flowCollector, @NotNull Continuation continuation) {
                Object collect = Flow.this.collect(new C14442(flowCollector, function2), continuation);
                if (collect == b51.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapLatest(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        int i = gh0.f17694a;
        return transformLatest(flow, new FlowKt__MergeKt$flatMapLatest$1(function2, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapMerge(@NotNull final Flow<? extends T> flow, int i, @NotNull final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        int i2 = gh0.f17694a;
        return flattenMerge(new Flow<Flow<Object>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            @Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 */
            /* loaded from: classes2.dex */
            public static final class C14452<T> implements FlowCollector {

                /* renamed from: a */
                public final /* synthetic */ FlowCollector f21723a;

                /* renamed from: b */
                public final /* synthetic */ Function2 f21724b;

                @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
                @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", m5601f = "Merge.kt", m5602i = {}, m5603l = {223, 223}, m5604m = "emit", m5605n = {}, m5606s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: d */
                    public /* synthetic */ Object f21725d;

                    /* renamed from: e */
                    public int f21726e;

                    /* renamed from: f */
                    public FlowCollector f21727f;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f21725d = obj;
                        this.f21726e |= Integer.MIN_VALUE;
                        return C14452.this.emit(null, this);
                    }
                }

                public C14452(FlowCollector flowCollector, Function2 function2) {
                    this.f21723a = flowCollector;
                    this.f21724b = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object obj2;
                    Object coroutine_suspended;
                    int i;
                    FlowCollector flowCollector;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.f21726e;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f21726e = i2 - Integer.MIN_VALUE;
                            obj2 = anonymousClass1.f21725d;
                            coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.f21726e;
                            if (i == 0) {
                                if (i != 1) {
                                    if (i == 2) {
                                        ResultKt.throwOnFailure(obj2);
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                FlowCollector flowCollector2 = anonymousClass1.f21727f;
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = flowCollector2;
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector3 = this.f21723a;
                                anonymousClass1.f21727f = flowCollector3;
                                anonymousClass1.f21726e = 1;
                                Object invoke = this.f21724b.invoke(obj, anonymousClass1);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj2 = invoke;
                                flowCollector = flowCollector3;
                            }
                            anonymousClass1.f21727f = null;
                            anonymousClass1.f21726e = 2;
                            if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    obj2 = anonymousClass1.f21725d;
                    coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.f21726e;
                    if (i == 0) {
                    }
                    anonymousClass1.f21727f = null;
                    anonymousClass1.f21726e = 2;
                    if (flowCollector.emit(obj2, anonymousClass1) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Flow<Object>> flowCollector, @NotNull Continuation continuation) {
                Object collect = Flow.this.collect(new C14452(flowCollector, function2), continuation);
                if (collect == b51.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, i);
    }

    public static /* synthetic */ Flow flatMapMerge$default(Flow flow, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gh0.f17694a;
        } else {
            int i3 = gh0.f17694a;
        }
        return flatMapMerge(flow, i, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> Flow<T> flatten(@NotNull Flow<? extends Flow<? extends T>> flow) {
        throw ye0.m8305y();
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> flattenConcat(@NotNull final Flow<? extends Flow<? extends T>> flow) {
        int i = gh0.f17694a;
        return (Flow<T>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object collect = Flow.this.collect(new C0022al(1, flowCollector), continuation);
                if (collect == b51.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> flattenMerge(@NotNull Flow<? extends Flow<? extends T>> flow, int i) {
        int i2 = gh0.f17694a;
        if (i > 0) {
            if (i == 1) {
                return flattenConcat(flow);
            }
            return new ChannelFlowMerge(flow, i, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Expected positive concurrency level, but had ").toString());
    }

    public static /* synthetic */ Flow flattenMerge$default(Flow flow, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gh0.f17694a;
        } else {
            int i3 = gh0.f17694a;
        }
        return flattenMerge(flow, i);
    }

    @NotNull
    public static final <T> Flow<T> flow(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new ud2(function2);
    }

    @JvmName(name = "flowCombine")
    @NotNull
    public static final <T1, T2, R> Flow<R> flowCombine(@NotNull final Flow<? extends T1> flow, @NotNull final Flow<? extends T2> flow2, @NotNull final Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return (Flow<R>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object combineInternal = CombineKt.combineInternal(flowCollector, new Flow[]{Flow.this, flow2}, C2026yn.f29028e, new fh0(function3, null, 1), continuation);
                if (combineInternal == b51.getCOROUTINE_SUSPENDED()) {
                    return combineInternal;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @JvmName(name = "flowCombineTransform")
    @NotNull
    public static final <T1, T2, R> Flow<R> flowCombineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return flow(new C1467xd7c321e6(new Flow[]{flow, flow2}, null, function4));
    }

    @NotNull
    public static final <T> Flow<T> flowOf(@NotNull T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Flow<T> flowOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.INSTANCE) == null) {
            if (!Intrinsics.areEqual(coroutineContext, EmptyCoroutineContext.INSTANCE)) {
                if (flow instanceof FusibleFlow) {
                    return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, coroutineContext, 0, null, 6, null);
                }
                return new ChannelFlowOperatorImpl(flow, coroutineContext, 0, null, 12, null);
            }
            return flow;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    @Nullable
    public static final <T, R> Object fold(@NotNull Flow<? extends T> flow, R r, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, @NotNull Continuation<? super R> continuation) {
        return zh0.m8416a(flow, r, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(action)", imports = {}))
    public static final <T> void forEach(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        throw ye0.m8305y();
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return gh0.f17694a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object last(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        ph0 ph0Var;
        Object coroutine_suspended;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof ph0) {
            ph0 ph0Var2 = (ph0) continuation;
            int i2 = ph0Var2.f25176f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ph0Var2.f25176f = i2 - Integer.MIN_VALUE;
                ph0Var = ph0Var2;
                Object obj = ph0Var.f25175e;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = ph0Var.f25176f;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = ph0Var.f25174d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowCollector<? super Object> qh0Var = new qh0(objectRef2);
                    ph0Var.f25174d = objectRef2;
                    ph0Var.f25176f = 1;
                    if (flow.collect(qh0Var, ph0Var) != coroutine_suspended) {
                        objectRef = objectRef2;
                    }
                    return coroutine_suspended;
                }
                coroutine_suspended = objectRef.element;
                if (coroutine_suspended == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Expected at least one element");
                }
                return coroutine_suspended;
            }
        }
        ph0Var = new ContinuationImpl(continuation);
        Object obj2 = ph0Var.f25175e;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = ph0Var.f25176f;
        if (i == 0) {
        }
        coroutine_suspended = objectRef.element;
        if (coroutine_suspended == NullSurrogateKt.NULL) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object lastOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        rh0 rh0Var;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof rh0) {
            rh0 rh0Var2 = (rh0) continuation;
            int i2 = rh0Var2.f25971f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rh0Var2.f25971f = i2 - Integer.MIN_VALUE;
                rh0Var = rh0Var2;
                Object obj = rh0Var.f25970e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = rh0Var.f25971f;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = rh0Var.f25969d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    FlowCollector<? super Object> sh0Var = new sh0(objectRef2);
                    rh0Var.f25969d = objectRef2;
                    rh0Var.f25971f = 1;
                    if (flow.collect(sh0Var, rh0Var) != coroutine_suspended) {
                        objectRef = objectRef2;
                    } else {
                        return coroutine_suspended;
                    }
                }
                return objectRef.element;
            }
        }
        rh0Var = new ContinuationImpl(continuation);
        Object obj2 = rh0Var.f25970e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = rh0Var.f25971f;
        if (i == 0) {
        }
        return objectRef.element;
    }

    @NotNull
    public static final <T> Job launchIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return BuildersKt.launch$default(coroutineScope, null, null, new nf0(flow, null), 3, null);
    }

    @NotNull
    public static final <T, R> Flow<R> map(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(flow, function2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> mapLatest(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        int i = gh0.f17694a;
        return transformLatest(flow, new fh0(function2, null, 0));
    }

    @NotNull
    public static final <T, R> Flow<R> mapNotNull(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(flow, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> Flow<T> merge(@NotNull Flow<? extends Flow<? extends T>> flow) {
        throw ye0.m8305y();
    }

    @NotNull
    public static final Void noImpl() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> Flow<T> observeOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        throw ye0.m8305y();
    }

    @NotNull
    public static final <T> Flow<T> onCompletion(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(flow, function3);
    }

    @NotNull
    public static final <T> Flow<T> onEach(@NotNull final Flow<? extends T> flow, @NotNull final Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return (Flow<T>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            @Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n79#2,2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 */
            /* loaded from: classes2.dex */
            public static final class C14602<T> implements FlowCollector {

                /* renamed from: a */
                public final /* synthetic */ FlowCollector f21824a;

                /* renamed from: b */
                public final /* synthetic */ Function2 f21825b;

                @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
                @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", m5601f = "Transform.kt", m5602i = {0, 0}, m5603l = {223, 224}, m5604m = "emit", m5605n = {"value", "$this$onEach_u24lambda_u248"}, m5606s = {"L$0", "L$1"})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: d */
                    public /* synthetic */ Object f21826d;

                    /* renamed from: e */
                    public int f21827e;

                    /* renamed from: g */
                    public Object f21829g;

                    /* renamed from: h */
                    public FlowCollector f21830h;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f21826d = obj;
                        this.f21827e |= Integer.MIN_VALUE;
                        return C14602.this.emit(null, this);
                    }
                }

                public C14602(FlowCollector flowCollector, Function2 function2) {
                    this.f21824a = flowCollector;
                    this.f21825b = function2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0067 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i;
                    Object obj;
                    FlowCollector flowCollector;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.f21827e;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f21827e = i2 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.f21826d;
                            coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.f21827e;
                            if (i == 0) {
                                if (i != 1) {
                                    if (i == 2) {
                                        ResultKt.throwOnFailure(obj2);
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                FlowCollector flowCollector2 = anonymousClass1.f21830h;
                                obj = anonymousClass1.f21829g;
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = flowCollector2;
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                anonymousClass1.f21829g = t;
                                FlowCollector flowCollector3 = this.f21824a;
                                anonymousClass1.f21830h = flowCollector3;
                                anonymousClass1.f21827e = 1;
                                InlineMarker.mark(6);
                                Object invoke = this.f21825b.invoke(t, anonymousClass1);
                                InlineMarker.mark(7);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = t;
                                flowCollector = flowCollector3;
                            }
                            anonymousClass1.f21829g = null;
                            anonymousClass1.f21830h = null;
                            anonymousClass1.f21827e = 2;
                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.f21826d;
                    coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.f21827e;
                    if (i == 0) {
                    }
                    anonymousClass1.f21829g = null;
                    anonymousClass1.f21830h = null;
                    anonymousClass1.f21827e = 2;
                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                Object collect = Flow.this.collect(new C14602(flowCollector, function2), continuation);
                if (collect == b51.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> onEmpty(@NotNull Flow<? extends T> flow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(flow, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorResume(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorResumeNext(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> flow, T t) {
        throw ye0.m8305y();
    }

    public static /* synthetic */ Flow onErrorReturn$default(Flow flow, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = C1223g8.f17578g;
        }
        return onErrorReturn(flow, obj, function1);
    }

    @NotNull
    public static final <T> Flow<T> onStart(@NotNull Flow<? extends T> flow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(function2, flow);
    }

    @NotNull
    public static final <T> SharedFlow<T> onSubscription(@NotNull SharedFlow<? extends T> sharedFlow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new yp2(sharedFlow, function2);
    }

    @NotNull
    public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> Flow<T> publish(@NotNull Flow<? extends T> flow) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> Flow<T> publishOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        throw ye0.m8305y();
    }

    @NotNull
    public static final <T> Flow<T> receiveAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return new C1987xl(receiveChannel, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S, T extends S> Object reduce(@NotNull Flow<? extends T> flow, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, @NotNull Continuation<? super S> continuation) {
        th0 th0Var;
        Object coroutine_suspended;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof th0) {
            th0 th0Var2 = (th0) continuation;
            int i2 = th0Var2.f26813f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                th0Var2.f26813f = i2 - Integer.MIN_VALUE;
                th0Var = th0Var2;
                Object obj = th0Var.f26812e;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = th0Var.f26813f;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = th0Var.f26811d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = NullSurrogateKt.NULL;
                    FlowCollector<? super Object> vh0Var = new vh0(objectRef2, function3);
                    th0Var.f26811d = objectRef2;
                    th0Var.f26813f = 1;
                    if (flow.collect(vh0Var, th0Var) != coroutine_suspended) {
                        objectRef = objectRef2;
                    }
                    return coroutine_suspended;
                }
                coroutine_suspended = objectRef.element;
                if (coroutine_suspended == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Empty flow can't be reduced");
                }
                return coroutine_suspended;
            }
        }
        th0Var = new ContinuationImpl(continuation);
        Object obj2 = th0Var.f26812e;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = th0Var.f26813f;
        if (i == 0) {
        }
        coroutine_suspended = objectRef.element;
        if (coroutine_suspended == NullSurrogateKt.NULL) {
        }
        return coroutine_suspended;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @NotNull
    public static final <T> Flow<T> replay(@NotNull Flow<? extends T> flow) {
        throw ye0.m8305y();
    }

    @NotNull
    public static final <T> Flow<T> retry(@NotNull Flow<? extends T> flow, long j, @NotNull Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        if (j > 0) {
            return retryWhen(flow, new tg0(j, function2, null));
        }
        throw new IllegalArgumentException(ye0.m8294n(j, "Expected positive amount of retries, but had ").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.coroutines.jvm.internal.SuspendLambda] */
    public static Flow retry$default(Flow flow, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        Function2 function22 = function2;
        if ((i & 2) != 0) {
            function22 = new SuspendLambda(2, null);
        }
        return retry(flow, j, function22);
    }

    @NotNull
    public static final <T> Flow<T> retryWhen(@NotNull Flow<? extends T> flow, @NotNull Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(flow, function4);
    }

    @NotNull
    public static final <T, R> Flow<R> runningFold(@NotNull Flow<? extends T> flow, R r, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return new FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(r, flow, function3);
    }

    @NotNull
    public static final <T> Flow<T> runningReduce(@NotNull final Flow<? extends T> flow, @NotNull final Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return (Flow<T>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1
            /* JADX WARN: Type inference failed for: r1v0, types: [kotlinx.coroutines.internal.Symbol, T] */
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = NullSurrogateKt.NULL;
                Object collect = Flow.this.collect(new hi0(objectRef, function3, flowCollector), continuation);
                if (collect == b51.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> flow, long j) {
        if (j > 0) {
            return FlowCoroutineKt.scopedFlow(new gg0(j, flow, null));
        }
        throw new IllegalArgumentException("Sample period should be positive");
    }

    @FlowPreview
    @NotNull
    /* renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m8885sampleHG0u8IE(@NotNull Flow<? extends T> flow, long j) {
        return sample(flow, DelayKt.m8850toDelayMillisLRDsOJo(j));
    }

    @NotNull
    public static final <T, R> Flow<R> scan(@NotNull Flow<? extends T> flow, R r, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return runningFold(flow, r, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> scanFold(@NotNull Flow<? extends T> flow, R r, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    @NotNull
    public static final <T> Flow<T> scanReduce(@NotNull Flow<? extends T> flow, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return runningReduce(flow, function3);
    }

    @NotNull
    public static final <T> SharedFlow<T> shareIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull SharingStarted sharingStarted, int i) {
        CoroutineStart coroutineStart;
        bi2 m5725a = AbstractC1479b.m5725a(flow, i);
        MutableSharedFlow MutableSharedFlow = SharedFlowKt.MutableSharedFlow(i, m5725a.f8027a, (BufferOverflow) m5725a.f8029c);
        Symbol symbol = SharedFlowKt.NO_VALUE;
        if (Intrinsics.areEqual(sharingStarted, SharingStarted.INSTANCE.getEagerly())) {
            coroutineStart = CoroutineStart.DEFAULT;
        } else {
            coroutineStart = CoroutineStart.UNDISPATCHED;
        }
        return new a92(MutableSharedFlow, BuildersKt.launch(coroutineScope, (CoroutineContext) m5725a.f8030d, coroutineStart, new C1478a(sharingStarted, (Flow) m5725a.f8028b, MutableSharedFlow, symbol, null)));
    }

    public static /* synthetic */ SharedFlow shareIn$default(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return shareIn(flow, coroutineScope, sharingStarted, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object single(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        wh0 wh0Var;
        Object coroutine_suspended;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof wh0) {
            wh0 wh0Var2 = (wh0) continuation;
            int i2 = wh0Var2.f28186f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                wh0Var2.f28186f = i2 - Integer.MIN_VALUE;
                wh0Var = wh0Var2;
                Object obj = wh0Var.f28185e;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = wh0Var.f28186f;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = wh0Var.f28184d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowCollector<? super Object> xh0Var = new xh0(objectRef2);
                    wh0Var.f28184d = objectRef2;
                    wh0Var.f28186f = 1;
                    if (flow.collect(xh0Var, wh0Var) != coroutine_suspended) {
                        objectRef = objectRef2;
                    }
                    return coroutine_suspended;
                }
                coroutine_suspended = objectRef.element;
                if (coroutine_suspended == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Flow is empty");
                }
                return coroutine_suspended;
            }
        }
        wh0Var = new ContinuationImpl(continuation);
        Object obj2 = wh0Var.f28185e;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = wh0Var.f28186f;
        if (i == 0) {
        }
        coroutine_suspended = objectRef.element;
        if (coroutine_suspended == NullSurrogateKt.NULL) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1, kotlinx.coroutines.flow.FlowCollector] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object singleOrNull(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        yh0 yh0Var;
        int i;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 flowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1;
        T t;
        if (continuation instanceof yh0) {
            yh0 yh0Var2 = (yh0) continuation;
            int i2 = yh0Var2.f28954g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                yh0Var2.f28954g = i2 - Integer.MIN_VALUE;
                yh0Var = yh0Var2;
                Object obj = yh0Var.f28953f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = yh0Var.f28954g;
                if (i == 0) {
                    if (i == 1) {
                        flowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 = yh0Var.f28952e;
                        objectRef = yh0Var.f28951d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (AbortFlowException e2) {
                            e = e2;
                            FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1);
                            t = objectRef.element;
                            if (t == NullSurrogateKt.NULL) {
                            }
                            return t;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    ?? r2 = new FlowCollector<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r1v0, types: [kotlinx.coroutines.internal.Symbol, T] */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public Object emit(Object obj2, @NotNull Continuation<? super Unit> continuation2) {
                            Ref.ObjectRef objectRef3 = Ref.ObjectRef.this;
                            T t2 = objectRef3.element;
                            ?? r1 = NullSurrogateKt.NULL;
                            if (t2 == r1) {
                                objectRef3.element = obj2;
                                return Unit.INSTANCE;
                            }
                            objectRef3.element = r1;
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        yh0Var.f28951d = objectRef2;
                        yh0Var.f28952e = r2;
                        yh0Var.f28954g = 1;
                        if (flow.collect(r2, yh0Var) != coroutine_suspended) {
                            objectRef = objectRef2;
                        } else {
                            return coroutine_suspended;
                        }
                    } catch (AbortFlowException e3) {
                        objectRef = objectRef2;
                        e = e3;
                        flowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 = r2;
                        FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1);
                        t = objectRef.element;
                        if (t == NullSurrogateKt.NULL) {
                        }
                        return t;
                    }
                }
                t = objectRef.element;
                if (t == NullSurrogateKt.NULL) {
                    t = null;
                }
                return t;
            }
        }
        yh0Var = new ContinuationImpl(continuation);
        Object obj2 = yh0Var.f28953f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = yh0Var.f28954g;
        if (i == 0) {
        }
        t = objectRef.element;
        if (t == NullSurrogateKt.NULL) {
        }
        return t;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    @NotNull
    public static final <T> Flow<T> skip(@NotNull Flow<? extends T> flow, int i) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> flow, T t) {
        throw ye0.m8305y();
    }

    @NotNull
    public static final <T> StateFlow<T> stateIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull SharingStarted sharingStarted, T t) {
        bi2 m5725a = AbstractC1479b.m5725a(flow, 1);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(t);
        return new b92(MutableStateFlow, BuildersKt.launch(coroutineScope, (CoroutineContext) m5725a.f8030d, Intrinsics.areEqual(sharingStarted, SharingStarted.INSTANCE.getEagerly()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new C1478a(sharingStarted, (Flow) m5725a.f8028b, MutableStateFlow, t, null)));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(@NotNull Flow<? extends T> flow) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @NotNull
    public static final <T> Flow<T> subscribeOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    @NotNull
    public static final <T, R> Flow<R> switchMap(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return transformLatest(flow, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(function2, null));
    }

    @NotNull
    public static final <T> Flow<T> take(@NotNull Flow<? extends T> flow, int i) {
        if (i > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(flow, i);
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Requested element count ", " should be positive").toString());
    }

    @NotNull
    public static final <T> Flow<T> takeWhile(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(flow, function2);
    }

    @FlowPreview
    @NotNull
    /* renamed from: timeout-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m8886timeoutHG0u8IE(@NotNull Flow<? extends T> flow, long j) {
        return FlowCoroutineKt.scopedFlow(new jg0(j, flow, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, C extends Collection<? super T>> Object toCollection(@NotNull Flow<? extends T> flow, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        of0 of0Var;
        int i;
        if (continuation instanceof of0) {
            of0 of0Var2 = (of0) continuation;
            int i2 = of0Var2.f23796f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                of0Var2.f23796f = i2 - Integer.MIN_VALUE;
                of0Var = of0Var2;
                Object obj = of0Var.f23795e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = of0Var.f23796f;
                if (i == 0) {
                    if (i == 1) {
                        c = (C) of0Var.f23794d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector<? super Object> c0022al = new C0022al(2, c);
                    of0Var.f23794d = c;
                    of0Var.f23796f = 1;
                    if (flow.collect(c0022al, of0Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return c;
            }
        }
        of0Var = new ContinuationImpl(continuation);
        Object obj2 = of0Var.f23795e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = of0Var.f23796f;
        if (i == 0) {
        }
        return c;
    }

    @Nullable
    public static final <T> Object toList(@NotNull Flow<? extends T> flow, @NotNull List<T> list, @NotNull Continuation<? super List<? extends T>> continuation) {
        return toCollection(flow, list, continuation);
    }

    public static /* synthetic */ Object toList$default(Flow flow, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return toList(flow, list, continuation);
    }

    @Nullable
    public static final <T> Object toSet(@NotNull Flow<? extends T> flow, @NotNull Set<T> set, @NotNull Continuation<? super Set<? extends T>> continuation) {
        return toCollection(flow, set, continuation);
    }

    public static /* synthetic */ Object toSet$default(Flow flow, Set set, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        return toSet(flow, set, continuation);
    }

    @NotNull
    public static final <T, R> Flow<R> transform(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return flow(new FlowKt__EmittersKt$transform$1(flow, function3, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> transformLatest(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        int i = gh0.f17694a;
        return new ChannelFlowTransformLatest(function3, flow, null, 0, null, 28, null);
    }

    @NotNull
    public static final <T, R> Flow<R> transformWhile(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return flow(new ch0(flow, function3, null));
    }

    @PublishedApi
    @NotNull
    public static final <T, R> Flow<R> unsafeTransform(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(flow, function3);
    }

    @NotNull
    public static final <T> Flow<IndexedValue<T>> withIndex(@NotNull final Flow<? extends T> flow) {
        return (Flow<IndexedValue<T>>) new Flow<IndexedValue<Object>>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super IndexedValue<Object>> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object collect = Flow.this.collect(new ji0(flowCollector, new Ref.IntRef()), continuation);
                if (collect == b51.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> zip(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return CombineKt.zipImpl(flow, flow2, function3);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull final Function0<? extends T> function0) {
        return (Flow<T>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object emit = flowCollector.emit(Function0.this.invoke(), continuation);
                if (emit == b51.getCOROUTINE_SUSPENDED()) {
                    return emit;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        return buffer$default(flow, i, null, 2, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object collect(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object collect = flow.collect(new FlowKt__CollectKt$collect$3(function2), continuation);
        return collect == b51.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @BuilderInference @NotNull final Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        final Flow[] flowArr = {flow, flow2, flow3};
        return (Flow<R>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            @Metadata(m5568d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¨\u0006\u0007"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
            @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", m5601f = "Zip.kt", m5602i = {}, m5603l = {333, 262}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
            @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n120#2,4:333\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 */
            /* loaded from: classes2.dex */
            public static final class C14622 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

                /* renamed from: e */
                public int f21845e;

                /* renamed from: f */
                public /* synthetic */ FlowCollector f21846f;

                /* renamed from: g */
                public /* synthetic */ Object[] f21847g;

                /* renamed from: h */
                public final /* synthetic */ Function4 f21848h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C14622(Continuation continuation, Function4 function4) {
                    super(3, continuation);
                    this.f21848h = function4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    FlowCollector flowCollector;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    int i = this.f21845e;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        flowCollector = this.f21846f;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        flowCollector = this.f21846f;
                        Object[] objArr = this.f21847g;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        this.f21846f = flowCollector;
                        this.f21845e = 1;
                        InlineMarker.mark(6);
                        obj = this.f21848h.invoke(obj2, obj3, obj4, this);
                        InlineMarker.mark(7);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    this.f21846f = null;
                    this.f21845e = 2;
                    if (flowCollector.emit(obj, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
                    C14622 c14622 = new C14622(continuation, this.f21848h);
                    c14622.f21846f = flowCollector;
                    c14622.f21847g = objArr;
                    return c14622.invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, C2026yn.f29028e, new C14622(null, function4), continuation);
                if (combineInternal == b51.getCOROUTINE_SUSPENDED()) {
                    return combineInternal;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return combine(flow, flow2, flow3, function4);
    }

    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> flowCollector, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super Unit> continuation) {
        ensureActive(flowCollector);
        Object collect = flow.collect(flowCollector, continuation);
        return collect == b51.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @NotNull
    public static final <R> Flow<R> filterIsInstance(@NotNull final Flow<?> flow, @NotNull final KClass<R> kClass) {
        return (Flow<R>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2

            @Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n22#2:223\n41#2:224\n23#2:225\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2 */
            /* loaded from: classes2.dex */
            public static final class C14522<T> implements FlowCollector {

                /* renamed from: a */
                public final /* synthetic */ FlowCollector f21781a;

                /* renamed from: b */
                public final /* synthetic */ KClass f21782b;

                @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
                @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2", m5601f = "Transform.kt", m5602i = {}, m5603l = {223}, m5604m = "emit", m5605n = {}, m5606s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: d */
                    public /* synthetic */ Object f21783d;

                    /* renamed from: e */
                    public int f21784e;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f21783d = obj;
                        this.f21784e |= Integer.MIN_VALUE;
                        return C14522.this.emit(null, this);
                    }
                }

                public C14522(FlowCollector flowCollector, KClass kClass) {
                    this.f21781a = flowCollector;
                    this.f21782b = kClass;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.f21784e;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f21784e = i2 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.f21783d;
                            Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.f21784e;
                            if (i == 0) {
                                if (i == 1) {
                                    ResultKt.throwOnFailure(obj2);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                if (this.f21782b.isInstance(obj)) {
                                    anonymousClass1.f21784e = 1;
                                    if (this.f21781a.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.f21783d;
                    Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.f21784e;
                    if (i == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                Object collect = Flow.this.collect(new C14522(flowCollector, kClass), continuation);
                if (collect == b51.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> flowOf(final T t) {
        return (Flow<T>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object emit = flowCollector.emit(t, continuation);
                if (emit == b51.getCOROUTINE_SUSPENDED()) {
                    return emit;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return combine(flow, flow2, flow3, flow4, function5);
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @BuilderInference @NotNull Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> function5) {
        return flow(new C1469xd7c321e8(new Flow[]{flow, flow2, flow3}, null, function5));
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull final Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        final Flow[] flowArr = {flow, flow2, flow3, flow4};
        return (Flow<R>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            @Metadata(m5568d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¨\u0006\u0007"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
            @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", m5601f = "Zip.kt", m5602i = {}, m5603l = {333, 262}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
            @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n157#2,5:333\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2 */
            /* loaded from: classes2.dex */
            public static final class C14632 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

                /* renamed from: e */
                public int f21851e;

                /* renamed from: f */
                public /* synthetic */ FlowCollector f21852f;

                /* renamed from: g */
                public /* synthetic */ Object[] f21853g;

                /* renamed from: h */
                public final /* synthetic */ Function5 f21854h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C14632(Continuation continuation, Function5 function5) {
                    super(3, continuation);
                    this.f21854h = function5;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    FlowCollector flowCollector;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    int i = this.f21851e;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        flowCollector = this.f21852f;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        flowCollector = this.f21852f;
                        Object[] objArr = this.f21853g;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        this.f21852f = flowCollector;
                        this.f21851e = 1;
                        InlineMarker.mark(6);
                        obj = this.f21854h.invoke(obj2, obj3, obj4, obj5, this);
                        InlineMarker.mark(7);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    this.f21852f = null;
                    this.f21851e = 2;
                    if (flowCollector.emit(obj, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
                    C14632 c14632 = new C14632(continuation, this.f21854h);
                    c14632.f21852f = flowCollector;
                    c14632.f21853g = objArr;
                    return c14632.invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, C2026yn.f29028e, new C14632(null, function5), continuation);
                if (combineInternal == b51.getCOROUTINE_SUSPENDED()) {
                    return combineInternal;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return combine(flow, flow2, flow3, flow4, flow5, function6);
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Long> function1) {
        return FlowCoroutineKt.scopedFlow(new ag0(function1, flow, null));
    }

    @NotNull
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super T, Boolean> function2) {
        C1223g8 c1223g8 = kg0.f20844a;
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return kg0.m5528a(flow, c1223g8, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2));
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterator<? extends T> it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @BuilderInference @NotNull Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> function6) {
        return flow(new C1470xd7c321e9(new Flow[]{flow, flow2, flow3, flow4}, null, function6));
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Sequence<? extends T> sequence) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(sequence);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull final Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        final Flow[] flowArr = {flow, flow2, flow3, flow4, flow5};
        return (Flow<R>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3

            @Metadata(m5568d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¨\u0006\u0007"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
            @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", m5601f = "Zip.kt", m5602i = {}, m5603l = {333, 262}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
            @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n198#2,6:333\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2 */
            /* loaded from: classes2.dex */
            public static final class C14642 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

                /* renamed from: e */
                public int f21857e;

                /* renamed from: f */
                public /* synthetic */ FlowCollector f21858f;

                /* renamed from: g */
                public /* synthetic */ Object[] f21859g;

                /* renamed from: h */
                public final /* synthetic */ Function6 f21860h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C14642(Continuation continuation, Function6 function6) {
                    super(3, continuation);
                    this.f21860h = function6;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    FlowCollector flowCollector;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    int i = this.f21857e;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        flowCollector = this.f21858f;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        flowCollector = this.f21858f;
                        Object[] objArr = this.f21859g;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        Object obj6 = objArr[4];
                        this.f21858f = flowCollector;
                        this.f21857e = 1;
                        InlineMarker.mark(6);
                        obj = this.f21860h.invoke(obj2, obj3, obj4, obj5, obj6, this);
                        InlineMarker.mark(7);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    this.f21858f = null;
                    this.f21857e = 2;
                    if (flowCollector.emit(obj, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
                    C14642 c14642 = new C14642(continuation, this.f21860h);
                    c14642.f21858f = flowCollector;
                    c14642.f21859g = objArr;
                    return c14642.invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, C2026yn.f29028e, new C14642(null, function6), continuation);
                if (combineInternal == b51.getCOROUTINE_SUSPENDED()) {
                    return combineInternal;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        throw ye0.m8305y();
    }

    @NotNull
    public static final <T> Flow<T> merge(@NotNull Iterable<? extends Flow<? extends T>> iterable) {
        int i = gh0.f17694a;
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> flow, T t, @NotNull Function1<? super Throwable, Boolean> function1) {
        return m8883catch(flow, new jh0(null, t, function1));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> Flow<T> publish(@NotNull Flow<? extends T> flow, int i) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @NotNull
    public static final <T> Flow<T> replay(@NotNull Flow<? extends T> flow, int i) {
        throw ye0.m8305y();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        throw ye0.m8305y();
    }

    @Nullable
    public static final <T> Object stateIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super StateFlow<? extends T>> continuation) {
        bi2 m5725a = AbstractC1479b.m5725a(flow, 1);
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) m5725a.f8030d, null, new di0((Flow) m5725a.f8028b, CompletableDeferred$default, null), 2, null);
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        throw ye0.m8305y();
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @BuilderInference @NotNull Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> function7) {
        return flow(new C1471xd7c321ea(new Flow[]{flow, flow2, flow3, flow4, flow5}, null, function7));
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Iterable<? extends Flow<? extends T>> iterable, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2) {
        Flow[] flowArr = (Flow[]) CollectionsKt___CollectionsKt.toList(iterable).toArray(new Flow[0]);
        Intrinsics.needClassReification();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(flowArr, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        rf0 rf0Var;
        int i;
        Ref.IntRef intRef;
        if (continuation instanceof rf0) {
            rf0 rf0Var2 = (rf0) continuation;
            int i2 = rf0Var2.f25954f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rf0Var2.f25954f = i2 - Integer.MIN_VALUE;
                rf0Var = rf0Var2;
                Object obj = rf0Var.f25953e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = rf0Var.f25954f;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    FlowCollector<? super Object> tf0Var = new tf0(function2, intRef2);
                    rf0Var.f25952d = intRef2;
                    rf0Var.f25954f = 1;
                    if (flow.collect(tf0Var, rf0Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    intRef = rf0Var.f25952d;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        rf0Var = new ContinuationImpl(continuation);
        Object obj2 = rf0Var.f25953e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = rf0Var.f25954f;
        if (i != 0) {
        }
        return Boxing.boxInt(intRef.element);
    }

    @NotNull
    public static final <T> Flow<T> merge(@NotNull Flow<? extends T>... flowArr) {
        int i = gh0.f17694a;
        return merge(ArraysKt___ArraysKt.asIterable(flowArr));
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Collections.java:4483)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:103)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T>[] r2, @kotlin.BuilderInference kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r3) {
        /*
            kotlin.jvm.internal.Intrinsics.needClassReification()
            kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6 r0 = new kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6
            r1 = 0
            r0.<init>(r2, r3, r1)
            kotlinx.coroutines.flow.Flow r2 = flow(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.combineTransform(kotlinx.coroutines.flow.Flow[], kotlin.jvm.functions.Function3):kotlinx.coroutines.flow.Flow");
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull IntRange intRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(intRange);
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Iterable<? extends Flow<? extends T>> iterable, @BuilderInference Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3) {
        Flow[] flowArr = (Flow[]) CollectionsKt___CollectionsKt.toList(iterable).toArray(new Flow[0]);
        Intrinsics.needClassReification();
        return flow(new FlowKt__ZipKt$combineTransform$7(flowArr, function3, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object first(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        lh0 lh0Var;
        Object coroutine_suspended;
        int i;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$2;
        if (continuation instanceof lh0) {
            lh0 lh0Var2 = (lh0) continuation;
            int i2 = lh0Var2.f22508h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                lh0Var2.f22508h = i2 - Integer.MIN_VALUE;
                lh0Var = lh0Var2;
                Object obj = lh0Var.f22507g;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = lh0Var.f22508h;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$22 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(function2, objectRef2);
                    try {
                        lh0Var.f22504d = function2;
                        lh0Var.f22505e = objectRef2;
                        lh0Var.f22506f = flowKt__ReduceKt$first$$inlined$collectWhile$22;
                        lh0Var.f22508h = 1;
                        if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$22, lh0Var) != coroutine_suspended) {
                            function22 = function2;
                            objectRef = objectRef2;
                        }
                    } catch (AbortFlowException e2) {
                        function22 = function2;
                        objectRef = objectRef2;
                        e = e2;
                        flowKt__ReduceKt$first$$inlined$collectWhile$2 = flowKt__ReduceKt$first$$inlined$collectWhile$22;
                        FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$first$$inlined$collectWhile$2);
                        coroutine_suspended = objectRef.element;
                        if (coroutine_suspended == NullSurrogateKt.NULL) {
                        }
                        return coroutine_suspended;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowKt__ReduceKt$first$$inlined$collectWhile$2 = lh0Var.f22506f;
                objectRef = lh0Var.f22505e;
                function22 = lh0Var.f22504d;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (AbortFlowException e3) {
                    e = e3;
                    FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$first$$inlined$collectWhile$2);
                    coroutine_suspended = objectRef.element;
                    if (coroutine_suspended == NullSurrogateKt.NULL) {
                    }
                    return coroutine_suspended;
                }
                coroutine_suspended = objectRef.element;
                if (coroutine_suspended == NullSurrogateKt.NULL) {
                    throw new NoSuchElementException("Expected at least one element matching the predicate " + function22);
                }
                return coroutine_suspended;
            }
        }
        lh0Var = new ContinuationImpl(continuation);
        Object obj2 = lh0Var.f22507g;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = lh0Var.f22508h;
        if (i != 0) {
        }
        coroutine_suspended = objectRef.element;
        if (coroutine_suspended == NullSurrogateKt.NULL) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        nh0 nh0Var;
        int i;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
        if (continuation instanceof nh0) {
            nh0 nh0Var2 = (nh0) continuation;
            int i2 = nh0Var2.f23368g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                nh0Var2.f23368g = i2 - Integer.MIN_VALUE;
                nh0Var = nh0Var2;
                Object obj = nh0Var.f23367f;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = nh0Var.f23368g;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$22 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(function2, objectRef2);
                    try {
                        nh0Var.f23365d = objectRef2;
                        nh0Var.f23366e = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$22;
                        nh0Var.f23368g = 1;
                        if (flow.collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$22, nh0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (AbortFlowException e2) {
                        objectRef = objectRef2;
                        e = e2;
                        flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$22;
                        FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2);
                        return objectRef.element;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = nh0Var.f23366e;
                    objectRef = nh0Var.f23365d;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (AbortFlowException e3) {
                        e = e3;
                        FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2);
                        return objectRef.element;
                    }
                }
                return objectRef.element;
            }
        }
        nh0Var = new ContinuationImpl(continuation);
        Object obj2 = nh0Var.f23367f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = nh0Var.f23368g;
        if (i != 0) {
        }
        return objectRef.element;
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull LongRange longRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(longRange);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22) {
        throw ye0.m8305y();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Collections.java:4483)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:103)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T>[] r1, kotlin.jvm.functions.Function2<? super T[], ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r2) {
        /*
            kotlin.jvm.internal.Intrinsics.needClassReification()
            kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$2 r0 = new kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$2
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.combine(kotlinx.coroutines.flow.Flow[], kotlin.jvm.functions.Function2):kotlinx.coroutines.flow.Flow");
    }
}
