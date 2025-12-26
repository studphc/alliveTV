package kotlinx.coroutines.flow;

import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2", m5601f = "Reduce.kt", m5602i = {}, m5603l = {45}, m5604m = "emit", m5605n = {}, m5606s = {})
@SourceDebugExtension({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$2$emit$1\n*L\n1#1,172:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__ReduceKt$fold$2$emit$1 extends ContinuationImpl {

    /* renamed from: d */
    public Ref.ObjectRef f21757d;

    /* renamed from: e */
    public /* synthetic */ Object f21758e;

    /* renamed from: f */
    public final /* synthetic */ FlowKt__ReduceKt$fold$2 f21759f;

    /* renamed from: g */
    public int f21760g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ReduceKt$fold$2$emit$1(FlowKt__ReduceKt$fold$2<? super T> flowKt__ReduceKt$fold$2, Continuation<? super FlowKt__ReduceKt$fold$2$emit$1> continuation) {
        super(continuation);
        this.f21759f = flowKt__ReduceKt$fold$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f21758e = obj;
        this.f21760g |= Integer.MIN_VALUE;
        return this.f21759f.emit(null, this);
    }
}
