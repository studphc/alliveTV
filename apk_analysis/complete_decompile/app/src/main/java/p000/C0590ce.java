package p000;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobNode;
import org.jetbrains.annotations.Nullable;

/* renamed from: ce */
/* loaded from: classes2.dex */
public final class C0590ce extends JobNode {

    /* renamed from: g */
    public static final AtomicReferenceFieldUpdater f8341g = AtomicReferenceFieldUpdater.newUpdater(C0590ce.class, Object.class, "_disposer");

    @Volatile
    @Nullable
    private volatile Object _disposer;

    /* renamed from: d */
    public final CancellableContinuationImpl f8342d;

    /* renamed from: e */
    public DisposableHandle f8343e;

    /* renamed from: f */
    public final /* synthetic */ C1155ee f8344f;

    public C0590ce(C1155ee c1155ee, CancellableContinuationImpl cancellableContinuationImpl) {
        this.f8344f = c1155ee;
        this.f8342d = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        CancellableContinuationImpl cancellableContinuationImpl = this.f8342d;
        if (th != null) {
            Object tryResumeWithException = cancellableContinuationImpl.tryResumeWithException(th);
            if (tryResumeWithException != null) {
                cancellableContinuationImpl.completeResume(tryResumeWithException);
                C1119de c1119de = (C1119de) f8341g.get(this);
                if (c1119de != null) {
                    c1119de.m4572a();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C1155ee.f16779b;
        C1155ee c1155ee = this.f8344f;
        if (atomicIntegerFieldUpdater.decrementAndGet(c1155ee) == 0) {
            Deferred[] deferredArr = c1155ee.f16780a;
            ArrayList arrayList = new ArrayList(deferredArr.length);
            for (Deferred deferred : deferredArr) {
                arrayList.add(deferred.getCompleted());
            }
            cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(arrayList));
        }
    }
}
