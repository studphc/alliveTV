package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, m5569d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {

    /* renamed from: Key, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f21393a;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(coroutineExceptionHandler, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.get(coroutineExceptionHandler, key);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(coroutineExceptionHandler, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(coroutineExceptionHandler, coroutineContext);
        }
    }

    @Metadata(m5568d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m5569d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* renamed from: kotlinx.coroutines.CoroutineExceptionHandler$Key, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* renamed from: a */
        public static final /* synthetic */ Companion f21393a = new Object();
    }

    void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception);
}
