package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadLocalKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\n\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, m5569d2 = {"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "Lkotlinx/coroutines/EventLoop;", "currentOrNull$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "currentOrNull", "", "resetEventLoop$kotlinx_coroutines_core", "()V", "resetEventLoop", "eventLoop", "setEventLoop$kotlinx_coroutines_core", "(Lkotlinx/coroutines/EventLoop;)V", "setEventLoop", "getEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/ThreadLocalEventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
/* loaded from: classes2.dex */
public final class ThreadLocalEventLoop {

    @NotNull
    public static final ThreadLocalEventLoop INSTANCE = new Object();

    /* renamed from: a */
    public static final ThreadLocal f21432a = ThreadLocalKt.commonThreadLocal(new Symbol("ThreadLocalEventLoop"));

    @Nullable
    public final EventLoop currentOrNull$kotlinx_coroutines_core() {
        return (EventLoop) f21432a.get();
    }

    @NotNull
    public final EventLoop getEventLoop$kotlinx_coroutines_core() {
        ThreadLocal threadLocal = f21432a;
        EventLoop eventLoop = (EventLoop) threadLocal.get();
        if (eventLoop == null) {
            EventLoop createEventLoop = EventLoopKt.createEventLoop();
            threadLocal.set(createEventLoop);
            return createEventLoop;
        }
        return eventLoop;
    }

    public final void resetEventLoop$kotlinx_coroutines_core() {
        f21432a.set(null);
    }

    public final void setEventLoop$kotlinx_coroutines_core(@NotNull EventLoop eventLoop) {
        f21432a.set(eventLoop);
    }
}
