package _COROUTINE;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p000.o63;
import p000.p63;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, m5569d2 = {"L_COROUTINE/ArtificialStackFrames;", "", "()V", "coroutineBoundary", "Ljava/lang/StackTraceElement;", "coroutineCreation", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class ArtificialStackFrames {
    @NotNull
    public final StackTraceElement coroutineBoundary() {
        return CoroutineDebuggingKt.access$artificialFrame(new Exception(), o63.class.getSimpleName());
    }

    @NotNull
    public final StackTraceElement coroutineCreation() {
        return CoroutineDebuggingKt.access$artificialFrame(new Exception(), p63.class.getSimpleName());
    }
}
