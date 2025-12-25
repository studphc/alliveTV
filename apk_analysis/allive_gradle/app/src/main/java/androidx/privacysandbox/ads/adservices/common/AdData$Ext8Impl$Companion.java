package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdData;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"androidx/privacysandbox/ads/adservices/common/AdData$Ext8Impl$Companion", "", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "adData", "Landroid/adservices/common/AdData;", "convertAdData", "(Landroidx/privacysandbox/ads/adservices/common/AdData;)Landroid/adservices/common/AdData;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class AdData$Ext8Impl$Companion {
    public AdData$Ext8Impl$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @NotNull
    public final android.adservices.common.AdData convertAdData(@NotNull AdData adData) {
        android.adservices.common.AdFilters adFilters;
        Intrinsics.checkNotNullParameter(adData, "adData");
        if (adData.getAdRenderId() != null) {
            Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
        }
        AdData.Builder adCounterKeys = new AdData.Builder().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).setAdCounterKeys(adData.getAdCounterKeys());
        AdFilters adFilters2 = adData.getAdFilters();
        if (adFilters2 != null) {
            adFilters = adFilters2.convertToAdServices$ads_adservices_release();
        } else {
            adFilters = null;
        }
        android.adservices.common.AdData build = adCounterKeys.setAdFilters(adFilters).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
        return build;
    }
}
