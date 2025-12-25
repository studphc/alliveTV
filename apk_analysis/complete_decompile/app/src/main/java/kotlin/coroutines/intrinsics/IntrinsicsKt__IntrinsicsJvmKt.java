package kotlin.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> Continuation<Unit> createCoroutineUnintercepted(@NotNull final Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation<?> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(probeCoroutineCreated);
        }
        final CoroutineContext f20923a = probeCoroutineCreated.getF20923a();
        if (f20923a == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(probeCoroutineCreated, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1

                /* renamed from: b */
                public int f21082b;

                /* renamed from: c */
                public final /* synthetic */ Function1 f21083c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(probeCoroutineCreated);
                    this.f21083c = function1;
                    Intrinsics.checkNotNull(probeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public Object invokeSuspend(@NotNull Object result) {
                    int i = this.f21082b;
                    if (i != 0) {
                        if (i == 1) {
                            this.f21082b = 2;
                            ResultKt.throwOnFailure(result);
                            return result;
                        }
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.f21082b = 1;
                    ResultKt.throwOnFailure(result);
                    Function1 function12 = this.f21083c;
                    Intrinsics.checkNotNull(function12, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                    return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function12, 1)).invoke(this);
                }
            };
        }
        return new ContinuationImpl(probeCoroutineCreated, f20923a, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2

            /* renamed from: d */
            public int f21084d;

            /* renamed from: e */
            public final /* synthetic */ Function1 f21085e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(probeCoroutineCreated, f20923a);
                this.f21085e = function1;
                Intrinsics.checkNotNull(probeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public Object invokeSuspend(@NotNull Object result) {
                int i = this.f21084d;
                if (i != 0) {
                    if (i == 1) {
                        this.f21084d = 2;
                        ResultKt.throwOnFailure(result);
                        return result;
                    }
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.f21084d = 1;
                ResultKt.throwOnFailure(result);
                Function1 function12 = this.f21085e;
                Intrinsics.checkNotNull(function12, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function12, 1)).invoke(this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> Continuation<T> intercepted(@NotNull Continuation<? super T> continuation) {
        ContinuationImpl continuationImpl;
        Continuation<T> continuation2;
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        if (continuation instanceof ContinuationImpl) {
            continuationImpl = (ContinuationImpl) continuation;
        } else {
            continuationImpl = null;
        }
        if (continuationImpl != null && (continuation2 = (Continuation<T>) continuationImpl.intercepted()) != null) {
            return continuation2;
        }
        return continuation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static <R, T> Continuation<Unit> createCoroutineUnintercepted(@NotNull final Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, final R r, @NotNull Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation<?> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r, probeCoroutineCreated);
        }
        final CoroutineContext f20923a = probeCoroutineCreated.getF20923a();
        if (f20923a == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(probeCoroutineCreated, function2, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3

                /* renamed from: b */
                public int f21086b;

                /* renamed from: c */
                public final /* synthetic */ Function2 f21087c;

                /* renamed from: d */
                public final /* synthetic */ Object f21088d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(probeCoroutineCreated);
                    this.f21087c = function2;
                    this.f21088d = r;
                    Intrinsics.checkNotNull(probeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public Object invokeSuspend(@NotNull Object result) {
                    int i = this.f21086b;
                    if (i != 0) {
                        if (i == 1) {
                            this.f21086b = 2;
                            ResultKt.throwOnFailure(result);
                            return result;
                        }
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.f21086b = 1;
                    ResultKt.throwOnFailure(result);
                    Function2 function22 = this.f21087c;
                    Intrinsics.checkNotNull(function22, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function22, 2)).invoke(this.f21088d, this);
                }
            };
        }
        return new ContinuationImpl(probeCoroutineCreated, f20923a, function2, r) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4

            /* renamed from: d */
            public int f21089d;

            /* renamed from: e */
            public final /* synthetic */ Function2 f21090e;

            /* renamed from: f */
            public final /* synthetic */ Object f21091f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(probeCoroutineCreated, f20923a);
                this.f21090e = function2;
                this.f21091f = r;
                Intrinsics.checkNotNull(probeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public Object invokeSuspend(@NotNull Object result) {
                int i = this.f21089d;
                if (i != 0) {
                    if (i == 1) {
                        this.f21089d = 2;
                        ResultKt.throwOnFailure(result);
                        return result;
                    }
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.f21089d = 1;
                ResultKt.throwOnFailure(result);
                Function2 function22 = this.f21090e;
                Intrinsics.checkNotNull(function22, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function22, 2)).invoke(this.f21091f, this);
            }
        };
    }
}
