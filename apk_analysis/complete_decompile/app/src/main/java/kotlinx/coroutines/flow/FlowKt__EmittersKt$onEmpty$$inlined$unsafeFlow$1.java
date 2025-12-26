package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.ng0;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,113:1\n182#2,7:114\n189#2,7:122\n329#3:121\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n188#1:121\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Flow f21629a;

    /* renamed from: b */
    public final /* synthetic */ Function2 f21630b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", m5601f = "Emitters.kt", m5602i = {0, 0, 0, 1}, m5603l = {115, 123}, m5604m = "collect", m5605n = {"this", "$this$onEmpty_u24lambda_u243", "isEmpty", "collector"}, m5606s = {"L$0", "L$1", "L$2", "L$0"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14341 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21631d;

        /* renamed from: e */
        public int f21632e;

        /* renamed from: g */
        public Object f21634g;

        /* renamed from: h */
        public FlowCollector f21635h;

        /* renamed from: i */
        public Ref.BooleanRef f21636i;

        public C14341(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21631d = obj;
            this.f21632e |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.f21629a = flow;
        this.f21630b = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v7, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14341 c14341;
        int i;
        FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1;
        FlowCollector flowCollector2;
        Ref.BooleanRef booleanRef;
        try {
            if (continuation instanceof C14341) {
                c14341 = (C14341) continuation;
                int i2 = c14341.f21632e;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    c14341.f21632e = i2 - Integer.MIN_VALUE;
                    Object obj = c14341.f21631d;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = c14341.f21632e;
                    if (i == 0) {
                        if (i != 1) {
                            if (i == 2) {
                                SafeCollector safeCollector = (SafeCollector) c14341.f21634g;
                                ResultKt.throwOnFailure(obj);
                                flowCollector = safeCollector;
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        booleanRef = c14341.f21636i;
                        flowCollector2 = c14341.f21635h;
                        flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1) c14341.f21634g;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                        booleanRef2.element = true;
                        ng0 ng0Var = new ng0(booleanRef2, flowCollector);
                        c14341.f21634g = this;
                        c14341.f21635h = flowCollector;
                        c14341.f21636i = booleanRef2;
                        c14341.f21632e = 1;
                        if (this.f21629a.collect(ng0Var, c14341) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = this;
                        flowCollector2 = flowCollector;
                        booleanRef = booleanRef2;
                    }
                    if (booleanRef.element) {
                        SafeCollector safeCollector2 = new SafeCollector(flowCollector2, c14341.getContext());
                        Function2 function2 = flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.f21630b;
                        c14341.f21634g = safeCollector2;
                        c14341.f21635h = null;
                        c14341.f21636i = null;
                        c14341.f21632e = 2;
                        InlineMarker.mark(6);
                        Object invoke = function2.invoke(safeCollector2, c14341);
                        InlineMarker.mark(7);
                        flowCollector = safeCollector2;
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i == 0) {
            }
            if (booleanRef.element) {
            }
            return Unit.INSTANCE;
        } finally {
            flowCollector.releaseIntercepted();
        }
        c14341 = new C14341(continuation);
        Object obj2 = c14341.f21631d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14341.f21632e;
    }
}
