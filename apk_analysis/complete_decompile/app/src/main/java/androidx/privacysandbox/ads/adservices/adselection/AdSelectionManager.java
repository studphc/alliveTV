package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH§@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH§@¢\u0006\u0002\u0010 ¨\u0006\""}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManager;", "", "()V", "getAdSelectionData", "Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataOutcome;", "getAdSelectionDataRequest", "Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;", "(Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistAdSelectionResult", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionOutcome;", "persistAdSelectionResultRequest", "Landroidx/privacysandbox/ads/adservices/adselection/PersistAdSelectionResultRequest;", "(Landroidx/privacysandbox/ads/adservices/adselection/PersistAdSelectionResultRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportEvent", "", "reportEventRequest", "Landroidx/privacysandbox/ads/adservices/adselection/ReportEventRequest;", "(Landroidx/privacysandbox/ads/adservices/adselection/ReportEventRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportImpression", "reportImpressionRequest", "Landroidx/privacysandbox/ads/adservices/adselection/ReportImpressionRequest;", "(Landroidx/privacysandbox/ads/adservices/adselection/ReportImpressionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectAds", "adSelectionConfig", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "(Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adSelectionFromOutcomesConfig", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionFromOutcomesConfig;", "(Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionFromOutcomesConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAdCounterHistogram", "updateAdCounterHistogramRequest", "Landroidx/privacysandbox/ads/adservices/adselection/UpdateAdCounterHistogramRequest;", "(Landroidx/privacysandbox/ads/adservices/adselection/UpdateAdCounterHistogramRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public abstract class AdSelectionManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManager$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManager;", "obtain", "(Landroid/content/Context;)Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionManager;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        @Nullable
        public final AdSelectionManager obtain(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            if (adServicesInfo.adServicesVersion() >= 4) {
                return new AdSelectionManagerApi33Ext4Impl(context);
            }
            if (adServicesInfo.extServicesVersionS() >= 9) {
                return (AdSelectionManager) BackCompatManager.INSTANCE.getManager(context, "AdSelectionManager", new C0447a(context));
            }
            return null;
        }
    }

    @JvmStatic
    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    @Nullable
    public static final AdSelectionManager obtain(@NotNull Context context) {
        return INSTANCE.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    @Nullable
    public abstract Object getAdSelectionData(@NotNull GetAdSelectionDataRequest getAdSelectionDataRequest, @NotNull Continuation<? super GetAdSelectionDataOutcome> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    @Nullable
    public abstract Object persistAdSelectionResult(@NotNull PersistAdSelectionResultRequest persistAdSelectionResultRequest, @NotNull Continuation<? super AdSelectionOutcome> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    @Nullable
    public abstract Object reportEvent(@NotNull ReportEventRequest reportEventRequest, @NotNull Continuation<? super Unit> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @Nullable
    public abstract Object reportImpression(@NotNull ReportImpressionRequest reportImpressionRequest, @NotNull Continuation<? super Unit> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @Nullable
    public abstract Object selectAds(@NotNull AdSelectionConfig adSelectionConfig, @NotNull Continuation<? super AdSelectionOutcome> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    @Nullable
    public abstract Object selectAds(@NotNull AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, @NotNull Continuation<? super AdSelectionOutcome> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    @Nullable
    public abstract Object updateAdCounterHistogram(@NotNull UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, @NotNull Continuation<? super Unit> continuation);
}
