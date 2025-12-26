package p000;

import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* loaded from: classes2.dex */
public class um2 extends AbstractCoroutine {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean handleJobException(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        return true;
    }
}
