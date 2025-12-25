package kotlinx.coroutines.flow;

import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1", m5601f = "Emitters.kt", m5602i = {}, m5603l = {53}, m5604m = "emit", m5605n = {}, m5606s = {})
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: d */
    public /* synthetic */ Object f21660d;

    /* renamed from: e */
    public final /* synthetic */ FlowKt__EmittersKt$unsafeTransform$1$1 f21661e;

    /* renamed from: f */
    public int f21662f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(FlowKt__EmittersKt$unsafeTransform$1$1<? super T> flowKt__EmittersKt$unsafeTransform$1$1, Continuation<? super FlowKt__EmittersKt$unsafeTransform$1$1$emit$1> continuation) {
        super(continuation);
        this.f21661e = flowKt__EmittersKt$unsafeTransform$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f21660d = obj;
        this.f21662f |= Integer.MIN_VALUE;
        return this.f21661e.emit(null, this);
    }
}
