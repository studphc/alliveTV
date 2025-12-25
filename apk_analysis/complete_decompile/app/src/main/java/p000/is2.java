package p000;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes2.dex */
public final class is2 implements OnCompleteListener {

    /* renamed from: a */
    public final /* synthetic */ CancellableContinuationImpl f20250a;

    public is2(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f20250a = cancellableContinuationImpl;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        Exception exception = task.getException();
        CancellableContinuationImpl cancellableContinuationImpl = this.f20250a;
        if (exception == null) {
            if (task.isCanceled()) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuationImpl, null, 1, null);
                return;
            } else {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(task.getResult()));
                return;
            }
        }
        Result.Companion companion2 = Result.INSTANCE;
        cancellableContinuationImpl.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(exception)));
    }
}
