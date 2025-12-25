package p000;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.TaskExecutors;

/* loaded from: classes.dex */
public final class aa3 extends CancellationToken {

    /* renamed from: a */
    public final ef3 f103a = new ef3();

    @Override // com.google.android.gms.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.f103a.isComplete();
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        this.f103a.addOnSuccessListener(TaskExecutors.MAIN_THREAD, new ai2(17, onTokenCanceledListener));
        return this;
    }
}
