package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n*L\n1#1,222:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__EmittersKt$unsafeTransform$1$1<T> implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Function3 f21658a;

    /* renamed from: b */
    public final /* synthetic */ FlowCollector f21659b;

    public FlowKt__EmittersKt$unsafeTransform$1$1(Function3<? super FlowCollector<Object>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<Object> flowCollector) {
        this.f21658a = function3;
        this.f21659b = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 flowKt__EmittersKt$unsafeTransform$1$1$emit$1;
        int i;
        if (continuation instanceof FlowKt__EmittersKt$unsafeTransform$1$1$emit$1) {
            flowKt__EmittersKt$unsafeTransform$1$1$emit$1 = (FlowKt__EmittersKt$unsafeTransform$1$1$emit$1) continuation;
            int i2 = flowKt__EmittersKt$unsafeTransform$1$1$emit$1.f21662f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$unsafeTransform$1$1$emit$1.f21662f = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__EmittersKt$unsafeTransform$1$1$emit$1.f21660d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = flowKt__EmittersKt$unsafeTransform$1$1$emit$1.f21662f;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    flowKt__EmittersKt$unsafeTransform$1$1$emit$1.f21662f = 1;
                    if (this.f21658a.invoke(this.f21659b, t, flowKt__EmittersKt$unsafeTransform$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__EmittersKt$unsafeTransform$1$1$emit$1 = new FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(this, continuation);
        Object obj2 = flowKt__EmittersKt$unsafeTransform$1$1$emit$1.f21660d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = flowKt__EmittersKt$unsafeTransform$1$1$emit$1.f21662f;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object emit$$forInline(T t, @NotNull Continuation<? super Unit> continuation) {
        InlineMarker.mark(4);
        new FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(this, continuation);
        InlineMarker.mark(5);
        this.f21658a.invoke(this.f21659b, t, continuation);
        return Unit.INSTANCE;
    }
}
