package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__TransformKt$map$$inlined$unsafeTransform$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Flow f21802a;

    /* renamed from: b */
    public final /* synthetic */ Function2 f21803b;

    @Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2 */
    /* loaded from: classes2.dex */
    public static final class C14572<T> implements FlowCollector {

        /* renamed from: a */
        public final /* synthetic */ FlowCollector f21806a;

        /* renamed from: b */
        public final /* synthetic */ Function2 f21807b;

        @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
        @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2", m5601f = "Transform.kt", m5602i = {}, m5603l = {223, 223}, m5604m = "emit", m5605n = {}, m5606s = {})
        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: d */
            public /* synthetic */ Object f21808d;

            /* renamed from: e */
            public int f21809e;

            /* renamed from: g */
            public FlowCollector f21811g;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f21808d = obj;
                this.f21809e |= Integer.MIN_VALUE;
                return C14572.this.emit(null, this);
            }
        }

        public C14572(FlowCollector flowCollector, Function2 function2) {
            this.f21806a = flowCollector;
            this.f21807b = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1;
            Object obj;
            Object coroutine_suspended;
            int i;
            FlowCollector flowCollector;
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                int i2 = anonymousClass1.f21809e;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.f21809e = i2 - Integer.MIN_VALUE;
                    obj = anonymousClass1.f21808d;
                    coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.f21809e;
                    if (i == 0) {
                        if (i != 1) {
                            if (i == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        FlowCollector flowCollector2 = anonymousClass1.f21811g;
                        ResultKt.throwOnFailure(obj);
                        flowCollector = flowCollector2;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector flowCollector3 = this.f21806a;
                        anonymousClass1.f21811g = flowCollector3;
                        anonymousClass1.f21809e = 1;
                        Object invoke = this.f21807b.invoke(t, anonymousClass1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = invoke;
                        flowCollector = flowCollector3;
                    }
                    anonymousClass1.f21811g = null;
                    anonymousClass1.f21809e = 2;
                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            anonymousClass1 = new AnonymousClass1(continuation);
            obj = anonymousClass1.f21808d;
            coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
            i = anonymousClass1.f21809e;
            if (i == 0) {
            }
            anonymousClass1.f21811g = null;
            anonymousClass1.f21809e = 2;
            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public final Object emit$$forInline(Object obj, @NotNull Continuation continuation) {
            InlineMarker.mark(4);
            new AnonymousClass1(continuation);
            InlineMarker.mark(5);
            Object invoke = this.f21807b.invoke(obj, continuation);
            InlineMarker.mark(0);
            this.f21806a.emit(invoke, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
    }

    public FlowKt__TransformKt$map$$inlined$unsafeTransform$1(Flow flow, Function2 function2) {
        this.f21802a = flow;
        this.f21803b = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
        Object collect = this.f21802a.collect(new C14572(flowCollector, this.f21803b), continuation);
        if (collect == b51.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object collect$$forInline(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.1

            /* renamed from: d */
            public /* synthetic */ Object f21804d;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f21804d = obj;
                return FlowKt__TransformKt$map$$inlined$unsafeTransform$1.this.collect(null, this);
            }
        };
        InlineMarker.mark(5);
        C14572 c14572 = new C14572(flowCollector, this.f21803b);
        InlineMarker.mark(0);
        this.f21802a.collect(c14572, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
