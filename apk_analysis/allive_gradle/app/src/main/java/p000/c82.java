package p000;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures;
import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class c82 extends ProtectedSignalsManagerFutures {

    /* renamed from: a */
    public final ProtectedSignalsManager f8287a;

    public c82(ProtectedSignalsManager protectedSignalsManager) {
        this.f8287a = protectedSignalsManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> updateSignalsAsync(@NotNull UpdateSignalsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new b82(this, request, null), 3, null), null, 1, null);
    }
}
