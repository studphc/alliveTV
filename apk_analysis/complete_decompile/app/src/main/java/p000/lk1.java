package p000;

import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.SourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class lk1 extends MeasurementManagerFutures {

    /* renamed from: a */
    public final MeasurementManager f22548a;

    public lk1(MeasurementManager mMeasurementManager) {
        Intrinsics.checkNotNullParameter(mMeasurementManager, "mMeasurementManager");
        this.f22548a = mMeasurementManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> deleteRegistrationsAsync(@NotNull DeletionRequest deletionRequest) {
        Intrinsics.checkNotNullParameter(deletionRequest, "deletionRequest");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new ek1(this, deletionRequest, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @NotNull
    public ListenableFuture<Integer> getMeasurementApiStatusAsync() {
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new fk1(this, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> registerSourceAsync(@NotNull Uri attributionSource, @Nullable InputEvent inputEvent) {
        Intrinsics.checkNotNullParameter(attributionSource, "attributionSource");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new gk1(this, attributionSource, inputEvent, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> registerTriggerAsync(@NotNull Uri trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new ik1(this, trigger, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> registerWebSourceAsync(@NotNull WebSourceRegistrationRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new jk1(this, request, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @NotNull
    public ListenableFuture<Unit> registerWebTriggerAsync(@NotNull WebTriggerRegistrationRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new kk1(this, request, null), 3, null), null, 1, null);
    }

    @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
    @NotNull
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @ExperimentalFeatures.RegisterSourceOptIn
    public ListenableFuture<Unit> registerSourceAsync(@NotNull SourceRegistrationRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new hk1(this, request, null), 3, null), null, 1, null);
    }
}
