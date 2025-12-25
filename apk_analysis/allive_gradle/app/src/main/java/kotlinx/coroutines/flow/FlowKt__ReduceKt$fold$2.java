package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$2\n*L\n1#1,172:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__ReduceKt$fold$2<T> implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.ObjectRef f21755a;

    /* renamed from: b */
    public final /* synthetic */ Function3 f21756b;

    public FlowKt__ReduceKt$fold$2(Ref.ObjectRef<Object> objectRef, Function3<Object, ? super T, ? super Continuation<Object>, ? extends Object> function3) {
        this.f21755a = objectRef;
        this.f21756b = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$fold$2$emit$1) {
            flowKt__ReduceKt$fold$2$emit$1 = (FlowKt__ReduceKt$fold$2$emit$1) continuation;
            int i2 = flowKt__ReduceKt$fold$2$emit$1.f21760g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$fold$2$emit$1.f21760g = i2 - Integer.MIN_VALUE;
                T t2 = (T) flowKt__ReduceKt$fold$2$emit$1.f21758e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$fold$2$emit$1.f21760g;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = flowKt__ReduceKt$fold$2$emit$1.f21757d;
                        ResultKt.throwOnFailure(t2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(t2);
                    Ref.ObjectRef objectRef2 = this.f21755a;
                    T t3 = objectRef2.element;
                    flowKt__ReduceKt$fold$2$emit$1.f21757d = objectRef2;
                    flowKt__ReduceKt$fold$2$emit$1.f21760g = 1;
                    Object invoke = this.f21756b.invoke(t3, t, flowKt__ReduceKt$fold$2$emit$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    t2 = (T) invoke;
                    objectRef = objectRef2;
                }
                objectRef.element = t2;
                return Unit.INSTANCE;
            }
        }
        flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
        T t22 = (T) flowKt__ReduceKt$fold$2$emit$1.f21758e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$fold$2$emit$1.f21760g;
        if (i == 0) {
        }
        objectRef.element = t22;
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object emit$$forInline(T t, @NotNull Continuation<? super Unit> continuation) {
        InlineMarker.mark(4);
        new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
        InlineMarker.mark(5);
        Function3 function3 = this.f21756b;
        Ref.ObjectRef objectRef = this.f21755a;
        objectRef.element = (T) function3.invoke(objectRef.element, t, continuation);
        return Unit.INSTANCE;
    }
}
