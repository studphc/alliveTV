package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* loaded from: classes2.dex */
public final class r71 extends s10 {

    /* renamed from: d */
    public final Continuation f25889d;

    public r71(CoroutineContext coroutineContext, Function2 function2) {
        super(coroutineContext, true, false);
        this.f25889d = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStart() {
        CancellableKt.startCoroutineCancellable((Continuation<? super Unit>) this.f25889d, this);
    }
}
