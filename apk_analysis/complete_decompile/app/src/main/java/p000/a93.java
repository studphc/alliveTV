package p000;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class a93 extends IStatusCallback.Stub {

    /* renamed from: a */
    public final /* synthetic */ TaskCompletionSource f99a;

    public a93(TaskCompletionSource taskCompletionSource) {
        this.f99a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        TaskUtil.trySetResultOrApiException(status, Boolean.TRUE, this.f99a);
    }
}
