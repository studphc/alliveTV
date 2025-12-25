package p000;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class et0 extends ActivityResultLauncher {

    /* renamed from: a */
    public final /* synthetic */ AtomicReference f16977a;

    /* renamed from: b */
    public final /* synthetic */ ActivityResultContract f16978b;

    public et0(AtomicReference atomicReference, ActivityResultContract activityResultContract) {
        this.f16977a = atomicReference;
        this.f16978b = activityResultContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final ActivityResultContract getContract() {
        return this.f16978b;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final void launch(Object obj, ActivityOptionsCompat activityOptionsCompat) {
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) this.f16977a.get();
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(obj, activityOptionsCompat);
            return;
        }
        throw new IllegalStateException("Operation cannot be started before fragment is in created state");
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final void unregister() {
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) this.f16977a.getAndSet(null);
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
    }
}
