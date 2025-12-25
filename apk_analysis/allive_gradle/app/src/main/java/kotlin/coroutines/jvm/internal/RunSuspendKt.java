package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m5569d2 = {"runSuspend", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RunSuspendKt {
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.coroutines.Continuation, hd2, java.lang.Object] */
    @SinceKotlin(version = "1.3")
    public static final void runSuspend(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ?? obj = new Object();
        ContinuationKt.startCoroutine(block, obj);
        synchronized (obj) {
            while (true) {
                try {
                    Result result = obj.f18031a;
                    if (result == null) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Object");
                        obj.wait();
                    } else {
                        ResultKt.throwOnFailure(result.getValue());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
