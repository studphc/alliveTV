package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n1#1,113:1\n133#2,15:114\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Flow f21670a;

    /* renamed from: b */
    public final /* synthetic */ Function4 f21671b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", m5601f = "Errors.kt", m5602i = {0, 0, 0, 0, 1, 1, 1, 1}, m5603l = {118, 120}, m5604m = "collect", m5605n = {"this", "$this$retryWhen_u24lambda_u242", "attempt", "shallRetry", "this", "$this$retryWhen_u24lambda_u242", "cause", "attempt"}, m5606s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14391 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21672d;

        /* renamed from: e */
        public int f21673e;

        /* renamed from: g */
        public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 f21675g;

        /* renamed from: h */
        public FlowCollector f21676h;

        /* renamed from: i */
        public Throwable f21677i;

        /* renamed from: j */
        public long f21678j;

        public C14391(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21672d = obj;
            this.f21673e |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.f21670a = flow;
        this.f21671b = function4;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0086 -> B:11:0x0089). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0098 -> B:14:0x0095). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14391 c14391;
        int i;
        long j;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
        FlowCollector<? super Object> flowCollector2;
        Throwable th;
        Object catchImpl;
        if (continuation instanceof C14391) {
            c14391 = (C14391) continuation;
            int i2 = c14391.f21673e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14391.f21673e = i2 - Integer.MIN_VALUE;
                Object obj = c14391.f21672d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14391.f21673e;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            j = c14391.f21678j;
                            th = c14391.f21677i;
                            flowCollector2 = c14391.f21676h;
                            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = c14391.f21675g;
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                j++;
                                boolean z = true;
                                flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                                if (z) {
                                    return Unit.INSTANCE;
                                }
                                flowCollector = flowCollector2;
                                Flow flow = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.f21670a;
                                c14391.f21675g = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                                c14391.f21676h = flowCollector;
                                c14391.f21677i = null;
                                c14391.f21678j = j;
                                c14391.f21673e = 1;
                                catchImpl = FlowKt.catchImpl(flow, flowCollector, c14391);
                                if (catchImpl != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                                obj = catchImpl;
                                flowCollector2 = flowCollector;
                                th = (Throwable) obj;
                                if (th == null) {
                                    Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.f21671b;
                                    Long boxLong = Boxing.boxLong(j);
                                    c14391.f21675g = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                                    c14391.f21676h = flowCollector2;
                                    c14391.f21677i = th;
                                    c14391.f21678j = j;
                                    c14391.f21673e = 2;
                                    InlineMarker.mark(6);
                                    obj = function4.invoke(flowCollector2, th, boxLong, c14391);
                                    InlineMarker.mark(7);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    if (!((Boolean) obj).booleanValue()) {
                                        throw th;
                                    }
                                } else {
                                    z = false;
                                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                                    if (z) {
                                    }
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        j = c14391.f21678j;
                        flowCollector = c14391.f21676h;
                        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$13 = c14391.f21675g;
                        ResultKt.throwOnFailure(obj);
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$13;
                        flowCollector2 = flowCollector;
                        th = (Throwable) obj;
                        if (th == null) {
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    j = 0;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = this;
                    Flow flow2 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.f21670a;
                    c14391.f21675g = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                    c14391.f21676h = flowCollector;
                    c14391.f21677i = null;
                    c14391.f21678j = j;
                    c14391.f21673e = 1;
                    catchImpl = FlowKt.catchImpl(flow2, flowCollector, c14391);
                    if (catchImpl != coroutine_suspended) {
                    }
                }
            }
        }
        c14391 = new C14391(continuation);
        Object obj2 = c14391.f21672d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14391.f21673e;
        if (i == 0) {
        }
    }
}
