package kotlinx.coroutines.flow;

import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, m5569d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n*L\n1#1,118:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__CollectKt$collect$3 implements FlowCollector<Object> {

    /* renamed from: a */
    public final /* synthetic */ Function2 f21615a;

    public FlowKt__CollectKt$collect$3(Function2<Object, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f21615a = function2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Object obj, @NotNull Continuation<? super Unit> continuation) {
        Object invoke = this.f21615a.invoke(obj, continuation);
        if (invoke == b51.getCOROUTINE_SUSPENDED()) {
            return invoke;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object emit$$forInline(Object obj, @NotNull final Continuation<? super Unit> continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3$emit$1

            /* renamed from: d */
            public /* synthetic */ Object f21616d;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj2) {
                this.f21616d = obj2;
                return FlowKt__CollectKt$collect$3.this.emit(null, this);
            }
        };
        InlineMarker.mark(5);
        this.f21615a.invoke(obj, continuation);
        return Unit.INSTANCE;
    }
}
