package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n1#1,113:1\n59#2,3:114\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Flow f21663a;

    /* renamed from: b */
    public final /* synthetic */ Function3 f21664b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", m5601f = "Errors.kt", m5602i = {0, 0}, m5603l = {114, 115}, m5604m = "collect", m5605n = {"this", "$this$catch_u24lambda_u240"}, m5606s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14381 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21665d;

        /* renamed from: e */
        public int f21666e;

        /* renamed from: g */
        public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 f21668g;

        /* renamed from: h */
        public FlowCollector f21669h;

        public C14381(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21665d = obj;
            this.f21666e |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.f21663a = flow;
        this.f21664b = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14381 c14381;
        int i;
        FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
        Throwable th;
        if (continuation instanceof C14381) {
            c14381 = (C14381) continuation;
            int i2 = c14381.f21666e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14381.f21666e = i2 - Integer.MIN_VALUE;
                Object obj = c14381.f21665d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14381.f21666e;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = c14381.f21669h;
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 = c14381.f21668g;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    c14381.f21668g = this;
                    c14381.f21669h = flowCollector;
                    c14381.f21666e = 1;
                    obj = FlowKt.catchImpl(this.f21663a, flowCollector, c14381);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 = this;
                }
                th = (Throwable) obj;
                if (th != null) {
                    Function3 function3 = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.f21664b;
                    c14381.f21668g = null;
                    c14381.f21669h = null;
                    c14381.f21666e = 2;
                    InlineMarker.mark(6);
                    Object invoke = function3.invoke(flowCollector, th, c14381);
                    InlineMarker.mark(7);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        c14381 = new C14381(continuation);
        Object obj2 = c14381.f21665d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14381.f21666e;
        if (i == 0) {
        }
        th = (Throwable) obj2;
        if (th != null) {
        }
        return Unit.INSTANCE;
    }
}
