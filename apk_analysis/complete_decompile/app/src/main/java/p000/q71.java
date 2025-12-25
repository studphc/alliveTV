package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.C1412a;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* loaded from: classes2.dex */
public final class q71 extends C1412a {

    /* renamed from: e */
    public final Continuation f25479e;

    public q71(CoroutineContext coroutineContext, BroadcastChannel broadcastChannel, Function2 function2) {
        super(coroutineContext, broadcastChannel, false);
        this.f25479e = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStart() {
        CancellableKt.startCoroutineCancellable((Continuation<? super Unit>) this.f25479e, this);
    }

    @Override // kotlinx.coroutines.channels.C1412a, kotlinx.coroutines.channels.BroadcastChannel
    public final ReceiveChannel openSubscription() {
        ReceiveChannel openSubscription = this.f21490d.openSubscription();
        start();
        return openSubscription;
    }
}
