package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,113:1\n77#2:114\n78#2,7:116\n329#3:115\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n77#1:115\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Function2 f21637a;

    /* renamed from: b */
    public final /* synthetic */ Flow f21638b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", m5601f = "Emitters.kt", m5602i = {0, 0, 0}, m5603l = {117, 121}, m5604m = "collect", m5605n = {"this", "$this$onStart_u24lambda_u241", "safeCollector"}, m5606s = {"L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14351 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21639d;

        /* renamed from: e */
        public int f21640e;

        /* renamed from: g */
        public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 f21642g;

        /* renamed from: h */
        public FlowCollector f21643h;

        /* renamed from: i */
        public SafeCollector f21644i;

        public C14351(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21639d = obj;
            this.f21640e |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Function2 function2, Flow flow) {
        this.f21637a = function2;
        this.f21638b = flow;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14351 c14351;
        Object coroutine_suspended;
        int i;
        Throwable th;
        SafeCollector safeCollector;
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
        FlowCollector<? super Object> flowCollector2;
        Flow flow;
        if (continuation instanceof C14351) {
            c14351 = (C14351) continuation;
            int i2 = c14351.f21640e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14351.f21640e = i2 - Integer.MIN_VALUE;
                Object obj = c14351.f21639d;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14351.f21640e;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    safeCollector = c14351.f21644i;
                    flowCollector2 = c14351.f21643h;
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 = c14351.f21642g;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    SafeCollector safeCollector2 = new SafeCollector(flowCollector, c14351.getContext());
                    try {
                        Function2 function2 = this.f21637a;
                        c14351.f21642g = this;
                        c14351.f21643h = flowCollector;
                        c14351.f21644i = safeCollector2;
                        c14351.f21640e = 1;
                        InlineMarker.mark(6);
                        Object invoke = function2.invoke(safeCollector2, c14351);
                        InlineMarker.mark(7);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 = this;
                        flowCollector2 = flowCollector;
                        safeCollector = safeCollector2;
                    } catch (Throwable th3) {
                        th = th3;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                safeCollector.releaseIntercepted();
                flow = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.f21638b;
                c14351.f21642g = null;
                c14351.f21643h = null;
                c14351.f21644i = null;
                c14351.f21640e = 2;
                if (flow.collect(flowCollector2, c14351) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        c14351 = new C14351(continuation);
        Object obj2 = c14351.f21639d;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = c14351.f21640e;
        if (i == 0) {
        }
        safeCollector.releaseIntercepted();
        flow = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.f21638b;
        c14351.f21642g = null;
        c14351.f21643h = null;
        c14351.f21644i = null;
        c14351.f21640e = 2;
        if (flow.collect(flowCollector2, c14351) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
