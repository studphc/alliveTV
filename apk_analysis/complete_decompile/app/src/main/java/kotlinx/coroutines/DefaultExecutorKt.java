package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\b\" \u0010\u0007\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, m5569d2 = {"Lkotlinx/coroutines/Delay;", "a", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "getDefaultDelay$annotations", "()V", "DefaultDelay", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DefaultExecutorKt {

    /* renamed from: a */
    public static final Delay f21402a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Delay delay;
        if (!SystemPropsKt.systemProp("kotlinx.coroutines.main.delay", false)) {
            delay = DefaultExecutor.INSTANCE;
        } else {
            MainCoroutineDispatcher main = Dispatchers.getMain();
            if (!MainDispatchersKt.isMissing(main) && (main instanceof Delay)) {
                delay = (Delay) main;
            } else {
                delay = DefaultExecutor.INSTANCE;
            }
        }
        f21402a = delay;
    }

    @NotNull
    public static final Delay getDefaultDelay() {
        return f21402a;
    }

    @PublishedApi
    public static /* synthetic */ void getDefaultDelay$annotations() {
    }
}
