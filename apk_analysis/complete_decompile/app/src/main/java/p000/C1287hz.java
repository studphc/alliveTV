package p000;

import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveScope;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.C1287hz;

/* renamed from: hz */
/* loaded from: classes2.dex */
public final class C1287hz extends DeepRecursiveScope implements Continuation {

    /* renamed from: a */
    public Function3 f18220a;

    /* renamed from: b */
    public Object f18221b;

    /* renamed from: c */
    public Continuation f18222c;

    /* renamed from: d */
    public Object f18223d;

    @Override // kotlin.DeepRecursiveScope
    public final Object callRecursive(Object obj, Continuation continuation) {
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f18222c = continuation;
        this.f18221b = obj;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public final CoroutineContext getF20923a() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.f18222c = null;
        this.f18223d = obj;
    }

    @Override // kotlin.DeepRecursiveScope
    public final Object callRecursive(DeepRecursiveFunction deepRecursiveFunction, Object obj, final Continuation continuation) {
        Function3 block$kotlin_stdlib = deepRecursiveFunction.getBlock$kotlin_stdlib();
        Intrinsics.checkNotNull(block$kotlin_stdlib, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>{ kotlin.DeepRecursiveKt.DeepRecursiveFunctionBlock }");
        final Function3 function3 = this.f18220a;
        if (block$kotlin_stdlib != function3) {
            this.f18220a = block$kotlin_stdlib;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            final EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            this.f18222c = new Continuation<Object>() { // from class: kotlin.DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1
                @Override // kotlin.coroutines.Continuation
                @NotNull
                /* renamed from: getContext, reason: from getter */
                public CoroutineContext getF20923a() {
                    return CoroutineContext.this;
                }

                @Override // kotlin.coroutines.Continuation
                public void resumeWith(@NotNull Object result) {
                    C1287hz c1287hz = this;
                    c1287hz.f18220a = function3;
                    c1287hz.f18222c = continuation;
                    c1287hz.f18223d = result;
                }
            };
        } else {
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f18222c = continuation;
        }
        this.f18221b = obj;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }
}
