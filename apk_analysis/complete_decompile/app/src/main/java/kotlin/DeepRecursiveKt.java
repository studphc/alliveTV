package kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import p000.b51;

@Metadata(m5568d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\u0002¢\u0006\u0004\b\u0004\u0010\u0005*r\b\u0002\u0010\u000b\"5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\t\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006¢\u0006\u0002\b\n25\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\t\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006¢\u0006\u0002\b\n¨\u0006\f"}, m5569d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/DeepRecursiveFunction;", "value", "invoke", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "DeepRecursiveFunctionBlock", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DeepRecursiveKt {

    /* renamed from: a */
    public static final Object f20922a;

    static {
        Result.Companion companion = Result.INSTANCE;
        f20922a = Result.m8512constructorimpl(b51.getCOROUTINE_SUSPENDED());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [hz, kotlin.coroutines.Continuation, java.lang.Object, kotlin.DeepRecursiveScope] */
    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> R invoke(@NotNull DeepRecursiveFunction<T, R> deepRecursiveFunction, T t) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "<this>");
        Function3<DeepRecursiveScope<T, R>, T, Continuation<? super R>, Object> block = deepRecursiveFunction.getBlock$kotlin_stdlib();
        Intrinsics.checkNotNullParameter(block, "block");
        ?? deepRecursiveScope = new DeepRecursiveScope(null);
        deepRecursiveScope.f18220a = block;
        deepRecursiveScope.f18221b = t;
        Intrinsics.checkNotNull(deepRecursiveScope, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        deepRecursiveScope.f18222c = deepRecursiveScope;
        deepRecursiveScope.f18223d = f20922a;
        while (true) {
            R r = (R) deepRecursiveScope.f18223d;
            Continuation continuation = deepRecursiveScope.f18222c;
            if (continuation == null) {
                ResultKt.throwOnFailure(r);
                return r;
            }
            if (Result.m8514equalsimpl0(f20922a, r)) {
                try {
                    Function3 function3 = deepRecursiveScope.f18220a;
                    Object obj = deepRecursiveScope.f18221b;
                    Intrinsics.checkNotNull(function3, "null cannot be cast to non-null type kotlin.Function3<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, P of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn>, kotlin.Any?>");
                    Object invoke = ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(deepRecursiveScope, obj, continuation);
                    if (invoke != b51.getCOROUTINE_SUSPENDED()) {
                        continuation.resumeWith(Result.m8512constructorimpl(invoke));
                    }
                } catch (Throwable th) {
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(th)));
                }
            } else {
                deepRecursiveScope.f18223d = f20922a;
                continuation.resumeWith(r);
            }
        }
    }
}
