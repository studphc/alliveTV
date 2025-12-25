package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.wp2;

@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m5569d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "action", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,426:1\n329#2:427\n*S KotlinDebug\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n*L\n417#1:427\n*E\n"})
/* loaded from: classes2.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {

    /* renamed from: a */
    public final FlowCollector f21970a;

    /* renamed from: b */
    public final Function2 f21971b;

    public SubscribedFlowCollector(@NotNull FlowCollector<? super T> flowCollector, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f21970a = flowCollector;
        this.f21971b = function2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        return this.f21970a.emit(t, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onSubscription(@NotNull Continuation<? super Unit> continuation) {
        wp2 wp2Var;
        ?? r2;
        SafeCollector safeCollector;
        SubscribedFlowCollector<T> subscribedFlowCollector;
        try {
            if (continuation instanceof wp2) {
                wp2Var = (wp2) continuation;
                int i = wp2Var.f28274h;
                if ((i & Integer.MIN_VALUE) != 0) {
                    wp2Var.f28274h = i - Integer.MIN_VALUE;
                    Object obj = wp2Var.f28272f;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    r2 = wp2Var.f28274h;
                    if (r2 == 0) {
                        if (r2 != 1) {
                            if (r2 == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        safeCollector = wp2Var.f28271e;
                        subscribedFlowCollector = wp2Var.f28270d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        safeCollector = new SafeCollector(this.f21970a, wp2Var.getF20923a());
                        Function2 function2 = this.f21971b;
                        wp2Var.f28270d = this;
                        wp2Var.f28271e = safeCollector;
                        wp2Var.f28274h = 1;
                        if (function2.invoke(safeCollector, wp2Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        subscribedFlowCollector = this;
                    }
                    safeCollector.releaseIntercepted();
                    FlowCollector flowCollector = subscribedFlowCollector.f21970a;
                    r2 = flowCollector instanceof SubscribedFlowCollector;
                    if (r2 == 0) {
                        wp2Var.f28270d = null;
                        wp2Var.f28271e = null;
                        wp2Var.f28274h = 2;
                        if (((SubscribedFlowCollector) flowCollector).onSubscription(wp2Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
            }
            if (r2 == 0) {
            }
            safeCollector.releaseIntercepted();
            FlowCollector flowCollector2 = subscribedFlowCollector.f21970a;
            r2 = flowCollector2 instanceof SubscribedFlowCollector;
            if (r2 == 0) {
            }
        } catch (Throwable th) {
            r2.releaseIntercepted();
            throw th;
        }
        wp2Var = new wp2(this, continuation);
        Object obj2 = wp2Var.f28272f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        r2 = wp2Var.f28274h;
    }
}
