package kotlinx.coroutines.flow;

import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.og0;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,113:1\n147#2,13:114\n160#2,6:128\n329#3:127\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n159#1:127\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Flow f21622a;

    /* renamed from: b */
    public final /* synthetic */ Function3 f21623b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", m5601f = "Emitters.kt", m5602i = {0, 0, 1, 2}, m5603l = {115, 122, TsExtractor.TS_STREAM_TYPE_AC3}, m5604m = "collect", m5605n = {"this", "$this$onCompletion_u24lambda_u242", "e", "sc"}, m5606s = {"L$0", "L$1", "L$0", "L$0"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14331 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21624d;

        /* renamed from: e */
        public int f21625e;

        /* renamed from: g */
        public Object f21627g;

        /* renamed from: h */
        public FlowCollector f21628h;

        public C14331(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21624d = obj;
            this.f21625e |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.f21622a = flow;
        this.f21623b = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14331 c14331;
        Object coroutine_suspended;
        int i;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        ThrowingCollector throwingCollector;
        Function3 function3;
        SafeCollector safeCollector;
        Throwable th;
        SafeCollector safeCollector2;
        Object invoke;
        try {
            if (continuation instanceof C14331) {
                c14331 = (C14331) continuation;
                int i2 = c14331.f21625e;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    c14331.f21625e = i2 - Integer.MIN_VALUE;
                    Object obj = c14331.f21624d;
                    coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = c14331.f21625e;
                    if (i == 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    safeCollector2 = (SafeCollector) c14331.f21627g;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        safeCollector2.releaseIntercepted();
                                        return Unit.INSTANCE;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        safeCollector2.releaseIntercepted();
                                        throw th;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th3 = (Throwable) c14331.f21627g;
                            ResultKt.throwOnFailure(obj);
                            throw th3;
                        }
                        flowCollector = c14331.f21628h;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) c14331.f21627g;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th4) {
                            th = th4;
                            throwingCollector = new ThrowingCollector(th);
                            function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.f21623b;
                            c14331.f21627g = th;
                            c14331.f21628h = null;
                            c14331.f21625e = 2;
                            if (og0.m6571a(throwingCollector, function3, th, c14331) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        try {
                            Flow flow = this.f21622a;
                            c14331.f21627g = this;
                            c14331.f21628h = flowCollector;
                            c14331.f21625e = 1;
                            if (flow.collect(flowCollector, c14331) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                        } catch (Throwable th5) {
                            th = th5;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                            throwingCollector = new ThrowingCollector(th);
                            function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.f21623b;
                            c14331.f21627g = th;
                            c14331.f21628h = null;
                            c14331.f21625e = 2;
                            if (og0.m6571a(throwingCollector, function3, th, c14331) != coroutine_suspended) {
                            }
                        }
                    }
                    safeCollector = new SafeCollector(flowCollector, c14331.getContext());
                    Function3 function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.f21623b;
                    c14331.f21627g = safeCollector;
                    c14331.f21628h = null;
                    c14331.f21625e = 3;
                    InlineMarker.mark(6);
                    invoke = function32.invoke(safeCollector, null, c14331);
                    InlineMarker.mark(7);
                    if (invoke != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    safeCollector2 = safeCollector;
                    safeCollector2.releaseIntercepted();
                    return Unit.INSTANCE;
                }
            }
            Function3 function322 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.f21623b;
            c14331.f21627g = safeCollector;
            c14331.f21628h = null;
            c14331.f21625e = 3;
            InlineMarker.mark(6);
            invoke = function322.invoke(safeCollector, null, c14331);
            InlineMarker.mark(7);
            if (invoke != coroutine_suspended) {
            }
        } catch (Throwable th6) {
            th = th6;
            safeCollector2 = safeCollector;
            safeCollector2.releaseIntercepted();
            throw th;
        }
        c14331 = new C14331(continuation);
        Object obj2 = c14331.f21624d;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = c14331.f21625e;
        if (i == 0) {
        }
        safeCollector = new SafeCollector(flowCollector, c14331.getContext());
    }
}
