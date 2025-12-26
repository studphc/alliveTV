package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", m5601f = "Zip.kt", m5602i = {}, m5603l = {308}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
@SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7\n*L\n1#1,332:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__ZipKt$combineTransform$7 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: e */
    public int f21935e;

    /* renamed from: f */
    public /* synthetic */ Object f21936f;

    /* renamed from: g */
    public final /* synthetic */ Flow[] f21937g;

    /* renamed from: h */
    public final /* synthetic */ Function3 f21938h;

    @Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "invoke", "()[Ljava/lang/Object;"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
    @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7$1\n*L\n1#1,332:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$1 */
    /* loaded from: classes2.dex */
    public static final class C14751 extends Lambda implements Function0<Object[]> {

        /* renamed from: b */
        public final /* synthetic */ Flow[] f21939b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14751(Flow<Object>[] flowArr) {
            super(0);
            this.f21939b = flowArr;
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Object[] invoke() {
            int length = this.f21939b.length;
            Intrinsics.reifiedOperationMarker(0, "T?");
            return new Object[length];
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", m5601f = "Zip.kt", m5602i = {}, m5603l = {308}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
    @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7$2\n*L\n1#1,332:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2 */
    /* loaded from: classes2.dex */
    public static final class C14762 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

        /* renamed from: e */
        public int f21940e;

        /* renamed from: f */
        public /* synthetic */ FlowCollector f21941f;

        /* renamed from: g */
        public /* synthetic */ Object[] f21942g;

        /* renamed from: h */
        public final /* synthetic */ Function3 f21943h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14762(Function3<? super FlowCollector<Object>, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super C14762> continuation) {
            super(3, continuation);
            this.f21943h = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
            int i = this.f21940e;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = this.f21941f;
                Object[] objArr = this.f21942g;
                this.f21941f = null;
                this.f21940e = 1;
                if (this.f21943h.invoke(flowCollector, objArr, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            this.f21943h.invoke(this.f21941f, this.f21942g, this);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
            Intrinsics.needClassReification();
            C14762 c14762 = new C14762(this.f21943h, continuation);
            c14762.f21941f = flowCollector;
            c14762.f21942g = objArr;
            return c14762.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$7(Flow<Object>[] flowArr, Function3<? super FlowCollector<Object>, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combineTransform$7> continuation) {
        super(2, continuation);
        this.f21937g = flowArr;
        this.f21938h = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.f21937g, this.f21938h, continuation);
        flowKt__ZipKt$combineTransform$7.f21936f = obj;
        return flowKt__ZipKt$combineTransform$7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f21935e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.f21936f;
            Intrinsics.needClassReification();
            Flow[] flowArr = this.f21937g;
            C14751 c14751 = new C14751(flowArr);
            Intrinsics.needClassReification();
            C14762 c14762 = new C14762(this.f21938h, null);
            this.f21935e = 1;
            if (CombineKt.combineInternal(flowCollector, flowArr, c14751, c14762, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.f21936f;
        Intrinsics.needClassReification();
        Flow[] flowArr = this.f21937g;
        C14751 c14751 = new C14751(flowArr);
        Intrinsics.needClassReification();
        C14762 c14762 = new C14762(this.f21938h, null);
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, flowArr, c14751, c14762, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__ZipKt$combineTransform$7) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
