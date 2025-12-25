package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.dt2;
import p000.et2;
import p000.ft2;
import p000.it2;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\r\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "threadContextElements", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "countOrElement", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;", "oldState", "", "restoreThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/Symbol;", "NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ThreadContextKt {

    @JvmField
    @NotNull
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");

    /* renamed from: a */
    public static final dt2 f22043a = dt2.f16538b;

    /* renamed from: b */
    public static final et2 f22044b = et2.f16980b;

    /* renamed from: c */
    public static final ft2 f22045c = ft2.f17397b;

    public static final void restoreThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (obj instanceof it2) {
            it2 it2Var = (it2) obj;
            ThreadContextElement[] threadContextElementArr = it2Var.f20259c;
            int length = threadContextElementArr.length - 1;
            if (length < 0) {
                return;
            }
            while (true) {
                int i = length - 1;
                ThreadContextElement threadContextElement = threadContextElementArr[length];
                Intrinsics.checkNotNull(threadContextElement);
                threadContextElement.restoreThreadContext(coroutineContext, it2Var.f20258b[length]);
                if (i >= 0) {
                    length = i;
                } else {
                    return;
                }
            }
        } else {
            Object fold = coroutineContext.fold(null, f22044b);
            Intrinsics.checkNotNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((ThreadContextElement) fold).restoreThreadContext(coroutineContext, obj);
        }
    }

    @NotNull
    public static final Object threadContextElements(@NotNull CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, f22043a);
        Intrinsics.checkNotNull(fold);
        return fold;
    }

    @Nullable
    public static final Object updateThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new it2(coroutineContext, ((Number) obj).intValue()), f22045c);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }
}
