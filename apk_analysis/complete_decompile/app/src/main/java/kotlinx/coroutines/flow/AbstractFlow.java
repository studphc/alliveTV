package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1178f0;
import p000.b51;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m5569d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalCoroutinesApi
/* loaded from: classes2.dex */
public abstract class AbstractFlow<T> implements Flow<T>, CancellableFlow<T> {
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C1178f0 c1178f0;
        int i;
        Throwable th;
        SafeCollector safeCollector;
        if (continuation instanceof C1178f0) {
            c1178f0 = (C1178f0) continuation;
            int i2 = c1178f0.f17052g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1178f0.f17052g = i2 - Integer.MIN_VALUE;
                Object obj = c1178f0.f17050e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1178f0.f17052g;
                if (i == 0) {
                    if (i == 1) {
                        safeCollector = c1178f0.f17049d;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            safeCollector.releaseIntercepted();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    SafeCollector safeCollector2 = new SafeCollector(flowCollector, c1178f0.getContext());
                    try {
                        c1178f0.f17049d = safeCollector2;
                        c1178f0.f17052g = 1;
                        if (collectSafely(safeCollector2, c1178f0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        safeCollector = safeCollector2;
                    } catch (Throwable th3) {
                        th = th3;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                safeCollector.releaseIntercepted();
                return Unit.INSTANCE;
            }
        }
        c1178f0 = new C1178f0(this, continuation);
        Object obj2 = c1178f0.f17050e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1178f0.f17052g;
        if (i == 0) {
        }
        safeCollector.releaseIntercepted();
        return Unit.INSTANCE;
    }

    @Nullable
    public abstract Object collectSafely(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation);
}
