package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1776rw;
import p000.C1813sw;
import p000.C1850tw;
import p000.b03;

@Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0006\u001a6\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0080\b¢\u0006\u0004\b\f\u0010\r\u001a:\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0080\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a/\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001a\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013*\u00020\u0016H\u0080\u0010¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, m5569d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "newCoroutineContext", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "addedContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", ExifInterface.GPS_DIRECTION_TRUE, "", "countOrElement", "Lkotlin/Function0;", "block", "withCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "continuation", "withContinuationContext", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "oldValue", "Lkotlinx/coroutines/UndispatchedCoroutine;", "updateUndispatchedCompletion", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "undispatchedCompletion", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/UndispatchedCoroutine;", "", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* renamed from: a */
    public static final CoroutineContext m5661a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z) {
        Boolean bool = Boolean.FALSE;
        C1850tw c1850tw = C1850tw.f27002b;
        boolean booleanValue = ((Boolean) coroutineContext.fold(bool, c1850tw)).booleanValue();
        boolean booleanValue2 = ((Boolean) coroutineContext2.fold(bool, c1850tw)).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new C1813sw(objectRef, z));
        if (booleanValue2) {
            objectRef.element = ((CoroutineContext) objectRef.element).fold(emptyCoroutineContext, C1776rw.f26166b);
        }
        return coroutineContext3.plus((CoroutineContext) objectRef.element);
    }

    @Nullable
    public static final String getCoroutineName(@NotNull CoroutineContext coroutineContext) {
        return null;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final CoroutineContext newCoroutineContext(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext) {
        CoroutineContext m5661a = m5661a(coroutineScope.getCoroutineContext(), coroutineContext, true);
        return (m5661a == Dispatchers.getDefault() || m5661a.get(ContinuationInterceptor.INSTANCE) != null) ? m5661a : m5661a.plus(Dispatchers.getDefault());
    }

    @Nullable
    public static final UndispatchedCoroutine<?> undispatchedCompletion(@NotNull CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof DispatchedCoroutine) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) coroutineStackFrame;
            }
        }
        return null;
    }

    @Nullable
    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(@NotNull Continuation<?> continuation, @NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (!(continuation instanceof CoroutineStackFrame) || coroutineContext.get(b03.f7845a) == null) {
            return null;
        }
        UndispatchedCoroutine<?> undispatchedCompletion = undispatchedCompletion((CoroutineStackFrame) continuation);
        if (undispatchedCompletion != null) {
            undispatchedCompletion.saveThreadContext(coroutineContext, obj);
        }
        return undispatchedCompletion;
    }

    public static final <T> T withContinuationContext(@NotNull Continuation<?> continuation, @Nullable Object obj, @NotNull Function0<? extends T> function0) {
        UndispatchedCoroutine<?> undispatchedCoroutine;
        CoroutineContext context = continuation.getContext();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
        if (updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
            undispatchedCoroutine = updateUndispatchedCompletion(continuation, context, updateThreadContext);
        } else {
            undispatchedCoroutine = null;
        }
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T withCoroutineContext(@NotNull CoroutineContext coroutineContext, @Nullable Object obj, @NotNull Function0<? extends T> function0) {
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, obj);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    @InternalCoroutinesApi
    @NotNull
    public static final CoroutineContext newCoroutineContext(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2) {
        if (!((Boolean) coroutineContext2.fold(Boolean.FALSE, C1850tw.f27002b)).booleanValue()) {
            return coroutineContext.plus(coroutineContext2);
        }
        return m5661a(coroutineContext, coroutineContext2, false);
    }
}
