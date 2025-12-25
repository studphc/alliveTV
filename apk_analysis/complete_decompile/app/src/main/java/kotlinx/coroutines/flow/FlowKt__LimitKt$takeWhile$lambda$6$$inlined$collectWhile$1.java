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
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,141:1\n86#2,5:142\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 implements FlowCollector<Object> {

    /* renamed from: a */
    public final /* synthetic */ Function2 f21695a;

    /* renamed from: b */
    public final /* synthetic */ FlowCollector f21696b;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1", m5601f = "Limit.kt", m5602i = {0, 0, 1}, m5603l = {142, 143}, m5604m = "emit", m5605n = {"this", "value", "this"}, m5606s = {"L$0", "L$1", "L$0"})
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14421 extends ContinuationImpl {

        /* renamed from: d */
        public FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 f21697d;

        /* renamed from: e */
        public /* synthetic */ Object f21698e;

        /* renamed from: f */
        public int f21699f;

        /* renamed from: h */
        public Object f21701h;

        public C14421(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21698e = obj;
            this.f21699f |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1.this.emit(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1(Function2 function2, FlowCollector flowCollector) {
        this.f21695a = function2;
        this.f21696b = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, @NotNull Continuation<? super Unit> continuation) {
        C14421 c14421;
        int i;
        boolean z;
        Object obj2;
        Object obj3;
        FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1;
        if (continuation instanceof C14421) {
            c14421 = (C14421) continuation;
            int i2 = c14421.f21699f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14421.f21699f = i2 - Integer.MIN_VALUE;
                Object obj4 = c14421.f21698e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14421.f21699f;
                z = true;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = c14421.f21697d;
                            ResultKt.throwOnFailure(obj4);
                            if (z) {
                                return Unit.INSTANCE;
                            }
                            throw new AbortFlowException(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj5 = c14421.f21701h;
                    FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12 = c14421.f21697d;
                    ResultKt.throwOnFailure(obj4);
                    obj3 = obj5;
                    flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$12;
                    obj2 = obj4;
                } else {
                    ResultKt.throwOnFailure(obj4);
                    c14421.f21697d = this;
                    c14421.f21701h = obj;
                    c14421.f21699f = 1;
                    InlineMarker.mark(6);
                    Object invoke = this.f21695a.invoke(obj, c14421);
                    InlineMarker.mark(7);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = invoke;
                    obj3 = obj;
                    flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1 = this;
                }
                if (!((Boolean) obj2).booleanValue()) {
                    FlowCollector flowCollector = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1.f21696b;
                    c14421.f21697d = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1;
                    c14421.f21701h = null;
                    c14421.f21699f = 2;
                    if (flowCollector.emit(obj3, c14421) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    z = false;
                }
                if (z) {
                }
            }
        }
        c14421 = new C14421(continuation);
        Object obj42 = c14421.f21698e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14421.f21699f;
        z = true;
        if (i == 0) {
        }
        if (!((Boolean) obj2).booleanValue()) {
        }
        if (z) {
        }
    }
}
