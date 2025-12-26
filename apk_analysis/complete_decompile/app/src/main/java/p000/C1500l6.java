package p000;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* renamed from: l6 */
/* loaded from: classes.dex */
public final class C1500l6 extends AdSelectionManagerFutures {

    /* renamed from: a */
    public final AdSelectionManager f22354a;

    public C1500l6(AdSelectionManager adSelectionManager) {
        this.f22354a = adSelectionManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<GetAdSelectionDataOutcome> getAdSelectionDataAsync(@NotNull GetAdSelectionDataRequest getAdSelectionDataRequest) {
        Intrinsics.checkNotNullParameter(getAdSelectionDataRequest, "getAdSelectionDataRequest");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1147e6(this, getAdSelectionDataRequest, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<AdSelectionOutcome> persistAdSelectionResultAsync(@NotNull PersistAdSelectionResultRequest persistAdSelectionResultRequest) {
        Intrinsics.checkNotNullParameter(persistAdSelectionResultRequest, "persistAdSelectionResultRequest");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1184f6(this, persistAdSelectionResultRequest, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> reportEventAsync(@NotNull ReportEventRequest reportEventRequest) {
        Intrinsics.checkNotNullParameter(reportEventRequest, "reportEventRequest");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1221g6(this, reportEventRequest, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> reportImpressionAsync(@NotNull ReportImpressionRequest reportImpressionRequest) {
        Intrinsics.checkNotNullParameter(reportImpressionRequest, "reportImpressionRequest");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1258h6(this, reportImpressionRequest, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<AdSelectionOutcome> selectAdsAsync(@NotNull AdSelectionConfig adSelectionConfig) {
        Intrinsics.checkNotNullParameter(adSelectionConfig, "adSelectionConfig");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1295i6(this, adSelectionConfig, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> updateAdCounterHistogramAsync(@NotNull UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest) {
        Intrinsics.checkNotNullParameter(updateAdCounterHistogramRequest, "updateAdCounterHistogramRequest");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1380k6(this, updateAdCounterHistogramRequest, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    @NotNull
    public ListenableFuture<AdSelectionOutcome> selectAdsAsync(@NotNull AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig) {
        Intrinsics.checkNotNullParameter(adSelectionFromOutcomesConfig, "adSelectionFromOutcomesConfig");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1343j6(this, adSelectionFromOutcomesConfig, null), 3, null), null, 1, null);
    }
}
