package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", m5601f = "Emitters.kt", m5602i = {}, m5603l = {40}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1\n*L\n1#1,222:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__EmittersKt$transform$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: e */
    public int f21649e;

    /* renamed from: f */
    public /* synthetic */ Object f21650f;

    /* renamed from: g */
    public final /* synthetic */ Flow f21651g;

    /* renamed from: h */
    public final /* synthetic */ Function3 f21652h;

    @Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$1\n*L\n1#1,222:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14371<T> implements FlowCollector {

        /* renamed from: a */
        public final /* synthetic */ Function3 f21653a;

        /* renamed from: b */
        public final /* synthetic */ FlowCollector f21654b;

        public C14371(Function3<? super FlowCollector<Object>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<Object> flowCollector) {
            this.f21653a = function3;
            this.f21654b = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
            FlowKt__EmittersKt$transform$1$1$emit$1 flowKt__EmittersKt$transform$1$1$emit$1;
            int i;
            if (continuation instanceof FlowKt__EmittersKt$transform$1$1$emit$1) {
                flowKt__EmittersKt$transform$1$1$emit$1 = (FlowKt__EmittersKt$transform$1$1$emit$1) continuation;
                int i2 = flowKt__EmittersKt$transform$1$1$emit$1.f21657f;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    flowKt__EmittersKt$transform$1$1$emit$1.f21657f = i2 - Integer.MIN_VALUE;
                    Object obj = flowKt__EmittersKt$transform$1$1$emit$1.f21655d;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = flowKt__EmittersKt$transform$1$1$emit$1.f21657f;
                    if (i == 0) {
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        flowKt__EmittersKt$transform$1$1$emit$1.f21657f = 1;
                        if (this.f21653a.invoke(this.f21654b, t, flowKt__EmittersKt$transform$1$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            flowKt__EmittersKt$transform$1$1$emit$1 = new FlowKt__EmittersKt$transform$1$1$emit$1(this, continuation);
            Object obj2 = flowKt__EmittersKt$transform$1$1$emit$1.f21655d;
            Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
            i = flowKt__EmittersKt$transform$1$1$emit$1.f21657f;
            if (i == 0) {
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object emit$$forInline(T t, @NotNull Continuation<? super Unit> continuation) {
            InlineMarker.mark(4);
            new FlowKt__EmittersKt$transform$1$1$emit$1(this, continuation);
            InlineMarker.mark(5);
            this.f21653a.invoke(this.f21654b, t, continuation);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$transform$1(Flow<Object> flow, Function3<? super FlowCollector<Object>, Object, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__EmittersKt$transform$1> continuation) {
        super(2, continuation);
        this.f21651g = flow;
        this.f21652h = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.f21651g, this.f21652h, continuation);
        flowKt__EmittersKt$transform$1.f21650f = obj;
        return flowKt__EmittersKt$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f21649e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            C14371 c14371 = new C14371(this.f21652h, (FlowCollector) this.f21650f);
            this.f21649e = 1;
            if (this.f21651g.collect(c14371, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        C14371 c14371 = new C14371(this.f21652h, (FlowCollector) this.f21650f);
        InlineMarker.mark(0);
        this.f21651g.collect(c14371, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__EmittersKt$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
