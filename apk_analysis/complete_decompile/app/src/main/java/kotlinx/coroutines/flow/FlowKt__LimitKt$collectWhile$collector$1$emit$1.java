package kotlinx.coroutines.flow;

import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1", m5601f = "Limit.kt", m5602i = {0}, m5603l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m5604m = "emit", m5605n = {"this"}, m5606s = {"L$0"})
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$collectWhile$collector$1$emit$1 extends ContinuationImpl {

    /* renamed from: d */
    public FlowKt__LimitKt$collectWhile$collector$1 f21709d;

    /* renamed from: e */
    public /* synthetic */ Object f21710e;

    /* renamed from: f */
    public final /* synthetic */ FlowKt__LimitKt$collectWhile$collector$1 f21711f;

    /* renamed from: g */
    public int f21712g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$collectWhile$collector$1$emit$1(FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1, Continuation continuation) {
        super(continuation);
        this.f21711f = flowKt__LimitKt$collectWhile$collector$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f21710e = obj;
        this.f21712g |= Integer.MIN_VALUE;
        return this.f21711f.emit(null, this);
    }
}
