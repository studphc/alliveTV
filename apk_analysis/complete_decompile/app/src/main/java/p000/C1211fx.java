package p000;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* renamed from: fx */
/* loaded from: classes.dex */
public final class C1211fx extends CustomAudienceManagerFutures {

    /* renamed from: a */
    public final CustomAudienceManager f17424a;

    public C1211fx(CustomAudienceManager customAudienceManager) {
        this.f17424a = customAudienceManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> fetchAndJoinCustomAudienceAsync(@NotNull FetchAndJoinCustomAudienceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1101cx(this, request, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> joinCustomAudienceAsync(@NotNull JoinCustomAudienceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1137dx(this, request, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> leaveCustomAudienceAsync(@NotNull LeaveCustomAudienceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1174ex(this, request, null), 3, null), null, 1, null);
    }
}
