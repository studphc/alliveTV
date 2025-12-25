package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.RequiresPermission;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.SourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.lk1;

@Metadata(m5568d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u001fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0010\u001a\u00020\nH'¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u000e\u0010\u0015J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u0016H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u0019H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006H'¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006!"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures;", "", "<init>", "()V", "Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;", "deletionRequest", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "deleteRegistrationsAsync", "(Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;)Lcom/google/common/util/concurrent/ListenableFuture;", "Landroid/net/Uri;", "attributionSource", "Landroid/view/InputEvent;", "inputEvent", "registerSourceAsync", "(Landroid/net/Uri;Landroid/view/InputEvent;)Lcom/google/common/util/concurrent/ListenableFuture;", "trigger", "registerTriggerAsync", "(Landroid/net/Uri;)Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest;", "request", "(Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest;)Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "registerWebSourceAsync", "(Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;)Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;", "registerWebTriggerAsync", "(Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;)Lcom/google/common/util/concurrent/ListenableFuture;", "", "getMeasurementApiStatusAsync", "()Lcom/google/common/util/concurrent/ListenableFuture;", "Companion", "lk1", "ads-adservices-java_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public abstract class MeasurementManagerFutures {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures;", TypedValues.TransitionType.S_FROM, "(Landroid/content/Context;)Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures;", "ads-adservices-java_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nMeasurementManagerFutures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeasurementManagerFutures.kt\nandroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1#2:209\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @Nullable
        public final MeasurementManagerFutures from(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            MeasurementManager obtain = MeasurementManager.INSTANCE.obtain(context);
            if (obtain != null) {
                return new lk1(obtain);
            }
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final MeasurementManagerFutures from(@NotNull Context context) {
        return INSTANCE.from(context);
    }

    @NotNull
    public abstract ListenableFuture<Unit> deleteRegistrationsAsync(@NotNull DeletionRequest deletionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Integer> getMeasurementApiStatusAsync();

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Unit> registerSourceAsync(@NotNull Uri attributionSource, @Nullable InputEvent inputEvent);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @ExperimentalFeatures.RegisterSourceOptIn
    @NotNull
    public abstract ListenableFuture<Unit> registerSourceAsync(@NotNull SourceRegistrationRequest request);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Unit> registerTriggerAsync(@NotNull Uri trigger);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Unit> registerWebSourceAsync(@NotNull WebSourceRegistrationRequest request);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract ListenableFuture<Unit> registerWebTriggerAsync(@NotNull WebTriggerRegistrationRequest request);
}
