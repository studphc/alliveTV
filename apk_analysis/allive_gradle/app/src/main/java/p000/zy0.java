package p000;

import android.view.Choreographer;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* loaded from: classes2.dex */
public final /* synthetic */ class zy0 implements Choreographer.FrameCallback {

    /* renamed from: a */
    public final /* synthetic */ CancellableContinuation f29561a;

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        HandlerDispatcher handlerDispatcher = HandlerDispatcherKt.Main;
        this.f29561a.resumeUndispatched(Dispatchers.getMain(), Long.valueOf(j));
    }
}
