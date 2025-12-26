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
@DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", m5601f = "Zip.kt", m5602i = {}, m5603l = {251}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
@SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6\n*L\n1#1,332:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__ZipKt$combineTransform$6 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* renamed from: e */
    public int f21926e;

    /* renamed from: f */
    public /* synthetic */ Object f21927f;

    /* renamed from: g */
    public final /* synthetic */ Flow[] f21928g;

    /* renamed from: h */
    public final /* synthetic */ Function3 f21929h;

    @Metadata(m5568d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "invoke", "()[Ljava/lang/Object;"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
    @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$1\n*L\n1#1,332:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$1 */
    /* loaded from: classes2.dex */
    public static final class C14731 extends Lambda implements Function0<Object[]> {

        /* renamed from: b */
        public final /* synthetic */ Flow[] f21930b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14731(Flow<Object>[] flowArr) {
            super(0);
            this.f21930b = flowArr;
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Object[] invoke() {
            int length = this.f21930b.length;
            Intrinsics.reifiedOperationMarker(0, "T?");
            return new Object[length];
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", m5601f = "Zip.kt", m5602i = {}, m5603l = {251}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
    @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$2\n*L\n1#1,332:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2 */
    /* loaded from: classes2.dex */
    public static final class C14742 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

        /* renamed from: e */
        public int f21931e;

        /* renamed from: f */
        public /* synthetic */ FlowCollector f21932f;

        /* renamed from: g */
        public /* synthetic */ Object[] f21933g;

        /* renamed from: h */
        public final /* synthetic */ Function3 f21934h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14742(Function3<? super FlowCollector<Object>, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super C14742> continuation) {
            super(3, continuation);
            this.f21934h = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
            int i = this.f21931e;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = this.f21932f;
                Object[] objArr = this.f21933g;
                this.f21932f = null;
                this.f21931e = 1;
                if (this.f21934h.invoke(flowCollector, objArr, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            this.f21934h.invoke(this.f21932f, this.f21933g, this);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
            Intrinsics.needClassReification();
            C14742 c14742 = new C14742(this.f21934h, continuation);
            c14742.f21932f = flowCollector;
            c14742.f21933g = objArr;
            return c14742.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$6(Flow<Object>[] flowArr, Function3<? super FlowCollector<Object>, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combineTransform$6> continuation) {
        super(2, continuation);
        this.f21928g = flowArr;
        this.f21929h = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransform$6 flowKt__ZipKt$combineTransform$6 = new FlowKt__ZipKt$combineTransform$6(this.f21928g, this.f21929h, continuation);
        flowKt__ZipKt$combineTransform$6.f21927f = obj;
        return flowKt__ZipKt$combineTransform$6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f21926e;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.f21927f;
            Intrinsics.needClassReification();
            Flow[] flowArr = this.f21928g;
            C14731 c14731 = new C14731(flowArr);
            Intrinsics.needClassReification();
            C14742 c14742 = new C14742(this.f21929h, null);
            this.f21926e = 1;
            if (CombineKt.combineInternal(flowCollector, flowArr, c14731, c14742, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.f21927f;
        Intrinsics.needClassReification();
        Flow[] flowArr = this.f21928g;
        C14731 c14731 = new C14731(flowArr);
        Intrinsics.needClassReification();
        C14742 c14742 = new C14742(this.f21929h, null);
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, flowArr, c14731, c14742, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__ZipKt$combineTransform$6) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
