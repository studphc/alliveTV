package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b!\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0015\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, m5569d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "completion", "Lkotlin/coroutines/CoroutineContext;", "_context", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "(Lkotlin/coroutines/Continuation;)V", "intercepted", "()Lkotlin/coroutines/Continuation;", "", "releaseIntercepted", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuationImpl.kt\nkotlin/coroutines/jvm/internal/ContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1#2:169\n*E\n"})
/* loaded from: classes2.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {

    /* renamed from: b */
    public final CoroutineContext f21097b;

    /* renamed from: c */
    public transient Continuation f21098c;

    public ContinuationImpl(@Nullable Continuation<Object> continuation, @Nullable CoroutineContext coroutineContext) {
        super(continuation);
        this.f21097b = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.f21097b;
        Intrinsics.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    @NotNull
    public final Continuation<Object> intercepted() {
        Continuation<Object> continuation = this.f21098c;
        if (continuation == null) {
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) getContext().get(ContinuationInterceptor.INSTANCE);
            if (continuationInterceptor == null || (continuation = continuationInterceptor.interceptContinuation(this)) == null) {
                continuation = this;
            }
            this.f21098c = continuation;
        }
        return continuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        Continuation<?> continuation = this.f21098c;
        if (continuation != null && continuation != this) {
            CoroutineContext.Element element = getContext().get(ContinuationInterceptor.INSTANCE);
            Intrinsics.checkNotNull(element);
            ((ContinuationInterceptor) element).releaseInterceptedContinuation(continuation);
        }
        this.f21098c = CompletedContinuation.INSTANCE;
    }

    public ContinuationImpl(@Nullable Continuation<Object> continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
