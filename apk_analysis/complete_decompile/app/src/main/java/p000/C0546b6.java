package p000;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adid.AdId;
import androidx.privacysandbox.ads.adservices.adid.AdIdManager;
import androidx.privacysandbox.ads.adservices.java.adid.AdIdManagerFutures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* renamed from: b6 */
/* loaded from: classes.dex */
public final class C0546b6 extends AdIdManagerFutures {

    /* renamed from: a */
    public final AdIdManager f7905a;

    public C0546b6(AdIdManager mAdIdManager) {
        Intrinsics.checkNotNullParameter(mAdIdManager, "mAdIdManager");
        this.f7905a = mAdIdManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.java.adid.AdIdManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    @DoNotInline
    @NotNull
    public ListenableFuture<AdId> getAdIdAsync() {
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C0007a6(this, null), 3, null), null, 1, null);
    }
}
