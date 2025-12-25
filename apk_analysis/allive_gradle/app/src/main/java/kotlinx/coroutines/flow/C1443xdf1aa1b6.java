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
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n*L\n1#1,141:1\n120#2:142\n*E\n"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 */
/* loaded from: classes2.dex */
public final class C1443xdf1aa1b6 implements FlowCollector<Object> {

    /* renamed from: a */
    public final /* synthetic */ Function3 f21702a;

    /* renamed from: b */
    public final /* synthetic */ FlowCollector f21703b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1", m5601f = "Limit.kt", m5602i = {0}, m5603l = {142}, m5604m = "emit", m5605n = {"this"}, m5606s = {"L$0"})
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: d */
        public C1443xdf1aa1b6 f21704d;

        /* renamed from: e */
        public /* synthetic */ Object f21705e;

        /* renamed from: f */
        public int f21706f;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21705e = obj;
            this.f21706f |= Integer.MIN_VALUE;
            return C1443xdf1aa1b6.this.emit(null, this);
        }
    }

    public C1443xdf1aa1b6(Function3 function3, FlowCollector flowCollector) {
        this.f21702a = function3;
        this.f21703b = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj2;
        int i;
        C1443xdf1aa1b6 c1443xdf1aa1b6;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.f21706f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.f21706f = i2 - Integer.MIN_VALUE;
                obj2 = anonymousClass1.f21705e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.f21706f;
                if (i == 0) {
                    if (i == 1) {
                        c1443xdf1aa1b6 = anonymousClass1.f21704d;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    anonymousClass1.f21704d = this;
                    anonymousClass1.f21706f = 1;
                    InlineMarker.mark(6);
                    obj2 = this.f21702a.invoke(this.f21703b, obj, anonymousClass1);
                    InlineMarker.mark(7);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c1443xdf1aa1b6 = this;
                }
                if (!((Boolean) obj2).booleanValue()) {
                    return Unit.INSTANCE;
                }
                throw new AbortFlowException(c1443xdf1aa1b6);
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        obj2 = anonymousClass1.f21705e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.f21706f;
        if (i == 0) {
        }
        if (!((Boolean) obj2).booleanValue()) {
        }
    }
}
