package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.bh0;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n53#2,3:114\n66#2,4:117\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Flow f21683a;

    /* renamed from: b */
    public final /* synthetic */ int f21684b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", m5601f = "Limit.kt", m5602i = {0}, m5603l = {116}, m5604m = "collect", m5605n = {"$this$take_u24lambda_u244"}, m5606s = {"L$0"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14401 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21685d;

        /* renamed from: e */
        public int f21686e;

        /* renamed from: g */
        public FlowCollector f21688g;

        public C14401(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21685d = obj;
            this.f21686e |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$take$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__LimitKt$take$$inlined$unsafeFlow$1(Flow flow, int i) {
        this.f21683a = flow;
        this.f21684b = i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(3:19|20|(1:22))|12|13|14))|25|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002b, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(r8, r7);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14401 c14401;
        int i;
        if (continuation instanceof C14401) {
            c14401 = (C14401) continuation;
            int i2 = c14401.f21686e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14401.f21686e = i2 - Integer.MIN_VALUE;
                Object obj = c14401.f21685d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14401.f21686e;
                if (i == 0) {
                    if (i == 1) {
                        FlowCollector<? super Object> flowCollector2 = c14401.f21688g;
                        ResultKt.throwOnFailure(obj);
                        flowCollector = flowCollector2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef = new Ref.IntRef();
                    Flow flow = this.f21683a;
                    bh0 bh0Var = new bh0(intRef, this.f21684b, flowCollector);
                    c14401.f21688g = flowCollector;
                    c14401.f21686e = 1;
                    Object collect = flow.collect(bh0Var, c14401);
                    flowCollector = collect;
                    if (collect == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        c14401 = new C14401(continuation);
        Object obj2 = c14401.f21685d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14401.f21686e;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }
}
