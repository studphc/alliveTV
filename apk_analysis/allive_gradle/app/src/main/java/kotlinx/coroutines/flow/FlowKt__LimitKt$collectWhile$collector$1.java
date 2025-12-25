package kotlinx.coroutines.flow;

import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, m5569d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n*L\n1#1,141:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$collectWhile$collector$1 implements FlowCollector<Object> {

    /* renamed from: a */
    public final /* synthetic */ Function2 f21708a;

    public FlowKt__LimitKt$collectWhile$collector$1(Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.f21708a = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, @NotNull Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 flowKt__LimitKt$collectWhile$collector$1$emit$1;
        Object obj2;
        int i;
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1;
        if (continuation instanceof FlowKt__LimitKt$collectWhile$collector$1$emit$1) {
            flowKt__LimitKt$collectWhile$collector$1$emit$1 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) continuation;
            int i2 = flowKt__LimitKt$collectWhile$collector$1$emit$1.f21712g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$collectWhile$collector$1$emit$1.f21712g = i2 - Integer.MIN_VALUE;
                obj2 = flowKt__LimitKt$collectWhile$collector$1$emit$1.f21710e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = flowKt__LimitKt$collectWhile$collector$1$emit$1.f21712g;
                if (i == 0) {
                    if (i == 1) {
                        flowKt__LimitKt$collectWhile$collector$1 = flowKt__LimitKt$collectWhile$collector$1$emit$1.f21709d;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    flowKt__LimitKt$collectWhile$collector$1$emit$1.f21709d = this;
                    flowKt__LimitKt$collectWhile$collector$1$emit$1.f21712g = 1;
                    obj2 = this.f21708a.invoke(obj, flowKt__LimitKt$collectWhile$collector$1$emit$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__LimitKt$collectWhile$collector$1 = this;
                }
                if (!((Boolean) obj2).booleanValue()) {
                    return Unit.INSTANCE;
                }
                throw new AbortFlowException(flowKt__LimitKt$collectWhile$collector$1);
            }
        }
        flowKt__LimitKt$collectWhile$collector$1$emit$1 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, continuation);
        obj2 = flowKt__LimitKt$collectWhile$collector$1$emit$1.f21710e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = flowKt__LimitKt$collectWhile$collector$1$emit$1.f21712g;
        if (i == 0) {
        }
        if (!((Boolean) obj2).booleanValue()) {
        }
    }

    @Nullable
    public Object emit$$forInline(Object obj, @NotNull Continuation<? super Unit> continuation) {
        InlineMarker.mark(4);
        new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, continuation);
        InlineMarker.mark(5);
        if (((Boolean) this.f21708a.invoke(obj, continuation)).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new AbortFlowException(this);
    }
}
