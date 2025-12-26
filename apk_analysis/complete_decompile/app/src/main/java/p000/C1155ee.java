package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* renamed from: ee */
/* loaded from: classes2.dex */
public final class C1155ee {

    /* renamed from: b */
    public static final AtomicIntegerFieldUpdater f16779b = AtomicIntegerFieldUpdater.newUpdater(C1155ee.class, "notCompletedCount");

    /* renamed from: a */
    public final Deferred[] f16780a;

    @Volatile
    private volatile int notCompletedCount;

    public C1155ee(Deferred[] deferredArr) {
        this.f16780a = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    /* renamed from: a */
    public final Object m4691a(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Job[] jobArr = this.f16780a;
        int length = jobArr.length;
        C0590ce[] c0590ceArr = new C0590ce[length];
        for (int i = 0; i < length; i++) {
            Job job = jobArr[i];
            job.start();
            C0590ce c0590ce = new C0590ce(this, cancellableContinuationImpl);
            c0590ce.f8343e = job.invokeOnCompletion(c0590ce);
            c0590ceArr[i] = c0590ce;
        }
        C1119de c1119de = new C1119de(c0590ceArr);
        for (int i2 = 0; i2 < length; i2++) {
            C0590ce c0590ce2 = c0590ceArr[i2];
            c0590ce2.getClass();
            C0590ce.f8341g.set(c0590ce2, c1119de);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            c1119de.m4572a();
        } else {
            cancellableContinuationImpl.invokeOnCancellation(c1119de);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
