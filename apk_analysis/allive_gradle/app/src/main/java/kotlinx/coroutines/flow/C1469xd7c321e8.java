package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C2026yn;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@¨\u0006\u0005"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
@DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3", m5601f = "Zip.kt", m5602i = {}, m5603l = {273}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
@SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 */
/* loaded from: classes2.dex */
public final class C1469xd7c321e8 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: e */
    public int f21888e;

    /* renamed from: f */
    public /* synthetic */ Object f21889f;

    /* renamed from: g */
    public final /* synthetic */ Flow[] f21890g;

    /* renamed from: h */
    public final /* synthetic */ Function5 f21891h;

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¨\u0006\u0007"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1", m5601f = "Zip.kt", m5602i = {}, m5603l = {333}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
    @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n139#2,6:333\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

        /* renamed from: e */
        public int f21892e;

        /* renamed from: f */
        public /* synthetic */ FlowCollector f21893f;

        /* renamed from: g */
        public /* synthetic */ Object[] f21894g;

        /* renamed from: h */
        public final /* synthetic */ Function5 f21895h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Continuation continuation, Function5 function5) {
            super(3, continuation);
            this.f21895h = function5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
            int i = this.f21892e;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = this.f21893f;
                Object[] objArr = this.f21894g;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                this.f21892e = 1;
                InlineMarker.mark(6);
                Object invoke = this.f21895h.invoke(flowCollector, obj2, obj3, obj4, this);
                InlineMarker.mark(7);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation, this.f21895h);
            anonymousClass1.f21893f = flowCollector;
            anonymousClass1.f21894g = objArr;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1469xd7c321e8(Flow[] flowArr, Continuation continuation, Function5 function5) {
        super(2, continuation);
        this.f21890g = flowArr;
        this.f21891h = function5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C1469xd7c321e8 c1469xd7c321e8 = new C1469xd7c321e8(this.f21890g, continuation, this.f21891h);
        c1469xd7c321e8.f21889f = obj;
        return c1469xd7c321e8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f21888e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.f21889f;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null, this.f21891h);
            this.f21888e = 1;
            if (CombineKt.combineInternal(flowCollector, this.f21890g, C2026yn.f29028e, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((C1469xd7c321e8) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
