package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m5569d2 = {"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Thread;", "thread", "<init>", "(Ljava/lang/Thread;)V", "h", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class BlockingEventLoop extends EventLoopImplBase {

    /* renamed from: h, reason: from kotlin metadata */
    public final Thread thread;

    public BlockingEventLoop(@NotNull Thread thread) {
        this.thread = thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    @NotNull
    public Thread getThread() {
        return this.thread;
    }
}
