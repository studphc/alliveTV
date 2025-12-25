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
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n107#2,5:142\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__ReduceKt$first$$inlined$collectWhile$2 implements FlowCollector<Object> {

    /* renamed from: a */
    public final /* synthetic */ Function2 f21739a;

    /* renamed from: b */
    public final /* synthetic */ Ref.ObjectRef f21740b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", m5601f = "Reduce.kt", m5602i = {0, 0}, m5603l = {142}, m5604m = "emit", m5605n = {"this", "it"}, m5606s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1 */
    /* loaded from: classes2.dex */
    public static final class C14461 extends ContinuationImpl {

        /* renamed from: d */
        public FlowKt__ReduceKt$first$$inlined$collectWhile$2 f21741d;

        /* renamed from: e */
        public /* synthetic */ Object f21742e;

        /* renamed from: f */
        public int f21743f;

        /* renamed from: h */
        public Object f21745h;

        public C14461(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21742e = obj;
            this.f21743f |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt$first$$inlined$collectWhile$2.this.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$first$$inlined$collectWhile$2(Function2 function2, Ref.ObjectRef objectRef) {
        this.f21739a = function2;
        this.f21740b = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, @NotNull Continuation<? super Unit> continuation) {
        C14461 c14461;
        Object obj2;
        int i;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$2;
        T t;
        if (continuation instanceof C14461) {
            c14461 = (C14461) continuation;
            int i2 = c14461.f21743f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14461.f21743f = i2 - Integer.MIN_VALUE;
                obj2 = c14461.f21742e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14461.f21743f;
                if (i == 0) {
                    if (i == 1) {
                        Object obj3 = c14461.f21745h;
                        flowKt__ReduceKt$first$$inlined$collectWhile$2 = c14461.f21741d;
                        ResultKt.throwOnFailure(obj2);
                        t = obj3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    c14461.f21741d = this;
                    c14461.f21745h = obj;
                    c14461.f21743f = 1;
                    InlineMarker.mark(6);
                    obj2 = this.f21739a.invoke(obj, c14461);
                    InlineMarker.mark(7);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__ReduceKt$first$$inlined$collectWhile$2 = this;
                    t = obj;
                }
                if (((Boolean) obj2).booleanValue()) {
                    return Unit.INSTANCE;
                }
                flowKt__ReduceKt$first$$inlined$collectWhile$2.f21740b.element = t;
                throw new AbortFlowException(flowKt__ReduceKt$first$$inlined$collectWhile$2);
            }
        }
        c14461 = new C14461(continuation);
        obj2 = c14461.f21742e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14461.f21743f;
        if (i == 0) {
        }
        if (((Boolean) obj2).booleanValue()) {
        }
    }
}
