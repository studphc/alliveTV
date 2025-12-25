package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.fr1;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aD\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m5569d2 = {"", "locked", "Lkotlinx/coroutines/sync/Mutex;", "Mutex", "(Z)Lkotlinx/coroutines/sync/Mutex;", ExifInterface.GPS_DIRECTION_TRUE, "", "owner", "Lkotlin/Function0;", "action", "withLock", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class MutexKt {

    /* renamed from: a */
    public static final Symbol f22115a = new Symbol("NO_OWNER");

    /* renamed from: b */
    public static final Symbol f22116b = new Symbol("ALREADY_LOCKED_BY_OWNER");

    @NotNull
    public static final Mutex Mutex(boolean z) {
        return new MutexImpl(z);
    }

    public static /* synthetic */ Mutex Mutex$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Mutex(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withLock(@NotNull Mutex mutex, @Nullable Object obj, @NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        fr1 fr1Var;
        int i;
        Mutex mutex2;
        try {
            if (continuation instanceof fr1) {
                fr1 fr1Var2 = (fr1) continuation;
                int i2 = fr1Var2.f17378h;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    fr1Var2.f17378h = i2 - Integer.MIN_VALUE;
                    fr1Var = fr1Var2;
                    Object obj2 = fr1Var.f17377g;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = fr1Var.f17378h;
                    if (i == 0) {
                        if (i == 1) {
                            function0 = fr1Var.f17376f;
                            obj = fr1Var.f17375e;
                            Mutex mutex3 = fr1Var.f17374d;
                            ResultKt.throwOnFailure(obj2);
                            mutex2 = mutex3;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        fr1Var.f17374d = mutex;
                        fr1Var.f17375e = obj;
                        fr1Var.f17376f = function0;
                        fr1Var.f17378h = 1;
                        Object lock = mutex.lock(obj, fr1Var);
                        mutex2 = mutex;
                        if (lock == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return function0.invoke();
                }
            }
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex2.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
        fr1Var = new ContinuationImpl(continuation);
        Object obj22 = fr1Var.f17377g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = fr1Var.f17378h;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object withLock$default(Mutex mutex, Object obj, Function0 function0, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        InlineMarker.mark(0);
        mutex.lock(obj, continuation);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }
}
