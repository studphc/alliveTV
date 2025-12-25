package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.bg2;
import p000.cg2;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006*\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m5569d2 = {"", "permits", "acquiredPermits", "Lkotlinx/coroutines/sync/Semaphore;", "Semaphore", "(II)Lkotlinx/coroutines/sync/Semaphore;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "action", "withPermit", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SemaphoreKt {

    /* renamed from: a */
    public static final int f22124a = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);

    /* renamed from: b */
    public static final Symbol f22125b = new Symbol("PERMIT");

    /* renamed from: c */
    public static final Symbol f22126c = new Symbol("TAKEN");

    /* renamed from: d */
    public static final Symbol f22127d = new Symbol("BROKEN");

    /* renamed from: e */
    public static final Symbol f22128e = new Symbol("CANCELLED");

    /* renamed from: f */
    public static final int f22129f = SystemPropsKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    @NotNull
    public static final Semaphore Semaphore(int i, int i2) {
        return new SemaphoreImpl(i, i2);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return Semaphore(i, i2);
    }

    public static final cg2 access$createSegment(long j, cg2 cg2Var) {
        return new cg2(j, cg2Var, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withPermit(@NotNull Semaphore semaphore, @NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        bg2 bg2Var;
        int i;
        Semaphore semaphore2;
        try {
            if (continuation instanceof bg2) {
                bg2 bg2Var2 = (bg2) continuation;
                int i2 = bg2Var2.f8008g;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    bg2Var2.f8008g = i2 - Integer.MIN_VALUE;
                    bg2Var = bg2Var2;
                    Object obj = bg2Var.f8007f;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = bg2Var.f8008g;
                    if (i == 0) {
                        if (i == 1) {
                            function0 = bg2Var.f8006e;
                            Semaphore semaphore3 = bg2Var.f8005d;
                            ResultKt.throwOnFailure(obj);
                            semaphore2 = semaphore3;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        bg2Var.f8005d = semaphore;
                        bg2Var.f8006e = function0;
                        bg2Var.f8008g = 1;
                        Object acquire = semaphore.acquire(bg2Var);
                        semaphore2 = semaphore;
                        if (acquire == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return function0.invoke();
                }
            }
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            semaphore2.release();
            InlineMarker.finallyEnd(1);
        }
        bg2Var = new ContinuationImpl(continuation);
        Object obj2 = bg2Var.f8007f;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = bg2Var.f8008g;
        if (i == 0) {
        }
    }
}
