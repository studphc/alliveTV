package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n85#2:114\n126#2,15:115\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n85#1:115,15\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Flow f21689a;

    /* renamed from: b */
    public final /* synthetic */ Function2 f21690b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1", m5601f = "Limit.kt", m5602i = {0}, m5603l = {125}, m5604m = "collect", m5605n = {"collector$iv"}, m5606s = {"L$0"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14411 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21691d;

        /* renamed from: e */
        public int f21692e;

        /* renamed from: g */
        public FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 f21694g;

        public C14411(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21691d = obj;
            this.f21692e |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.f21689a = flow;
        this.f21690b = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14411 c14411;
        int i;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1;
        if (continuation instanceof C14411) {
            c14411 = (C14411) continuation;
            int i2 = c14411.f21692e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14411.f21692e = i2 - Integer.MIN_VALUE;
                Object obj = c14411.f21691d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14411.f21692e;
                if (i == 0) {
                    if (i == 1) {
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = c14411.f21694g;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (AbortFlowException e) {
                            e = e;
                            FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1);
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Flow flow = this.f21689a;
                    FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12 = new FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1(this.f21690b, flowCollector);
                    try {
                        c14411.f21694g = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12;
                        c14411.f21692e = 1;
                        if (flow.collect(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12, c14411) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (AbortFlowException e2) {
                        e = e2;
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12;
                        FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1);
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        c14411 = new C14411(continuation);
        Object obj2 = c14411.f21691d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14411.f21692e;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
