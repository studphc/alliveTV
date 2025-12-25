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
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@"}, m5569d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
@DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$1$1", m5601f = "Zip.kt", m5602i = {}, m5603l = {262, 262}, m5604m = "invokeSuspend", m5605n = {}, m5606s = {})
@SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n*L\n1#1,332:1\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__ZipKt$combineUnsafe$1$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

    /* renamed from: e */
    public int f21952e;

    /* renamed from: f */
    public /* synthetic */ FlowCollector f21953f;

    /* renamed from: g */
    public /* synthetic */ Object[] f21954g;

    /* renamed from: h */
    public final /* synthetic */ Function2 f21955h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineUnsafe$1$1(Function2<? super Object[], ? super Continuation<Object>, ? extends Object> function2, Continuation<? super FlowKt__ZipKt$combineUnsafe$1$1> continuation) {
        super(3, continuation);
        this.f21955h = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f21952e;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = this.f21953f;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = this.f21953f;
            Object[] objArr = this.f21954g;
            this.f21953f = flowCollector;
            this.f21952e = 1;
            obj = this.f21955h.invoke(objArr, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.f21953f = null;
        this.f21952e = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector flowCollector = this.f21953f;
        Object invoke = this.f21955h.invoke(this.f21954g, this);
        InlineMarker.mark(0);
        flowCollector.emit(invoke, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combineUnsafe$1$1 flowKt__ZipKt$combineUnsafe$1$1 = new FlowKt__ZipKt$combineUnsafe$1$1(this.f21955h, continuation);
        flowKt__ZipKt$combineUnsafe$1$1.f21953f = flowCollector;
        flowKt__ZipKt$combineUnsafe$1$1.f21954g = objArr;
        return flowKt__ZipKt$combineUnsafe$1$1.invokeSuspend(Unit.INSTANCE);
    }
}
