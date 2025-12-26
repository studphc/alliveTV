package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R \u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u0004\u001a\u0004\b\b\u0010\tR \u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\r\u0010\tR \u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0011\u0010\tR\u001a\u0010\u0018\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, m5569d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "", "shutdown", "()V", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "Default", "b", "getUnconfined", "getUnconfined$annotations", "Unconfined", "c", "getIO", "getIO$annotations", "IO", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "Main", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Dispatchers {

    @NotNull
    public static final Dispatchers INSTANCE = new Object();

    /* renamed from: a */
    public static final DefaultScheduler f21404a = DefaultScheduler.INSTANCE;

    /* renamed from: b */
    public static final Unconfined f21405b = Unconfined.INSTANCE;

    /* renamed from: c */
    public static final DefaultIoScheduler f21406c = DefaultIoScheduler.INSTANCE;

    @NotNull
    public static final CoroutineDispatcher getDefault() {
        return f21404a;
    }

    @JvmStatic
    public static /* synthetic */ void getDefault$annotations() {
    }

    @NotNull
    public static final CoroutineDispatcher getIO() {
        return f21406c;
    }

    @JvmStatic
    public static /* synthetic */ void getIO$annotations() {
    }

    @NotNull
    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    @JvmStatic
    public static /* synthetic */ void getMain$annotations() {
    }

    @NotNull
    public static final CoroutineDispatcher getUnconfined() {
        return f21405b;
    }

    @JvmStatic
    public static /* synthetic */ void getUnconfined$annotations() {
    }

    @DelicateCoroutinesApi
    public final void shutdown() {
        DefaultExecutor.INSTANCE.shutdown();
        DefaultScheduler.INSTANCE.shutdown$kotlinx_coroutines_core();
    }
}
