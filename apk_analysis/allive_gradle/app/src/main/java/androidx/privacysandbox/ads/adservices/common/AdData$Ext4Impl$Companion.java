package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdData;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1971x5;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"androidx/privacysandbox/ads/adservices/common/AdData$Ext4Impl$Companion", "", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "adData", "Landroid/adservices/common/AdData;", "convertAdData", "(Landroidx/privacysandbox/ads/adservices/common/AdData;)Landroid/adservices/common/AdData;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class AdData$Ext4Impl$Companion {
    public AdData$Ext4Impl$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @NotNull
    public final android.adservices.common.AdData convertAdData(@NotNull AdData adData) {
        AdData.Builder metadata;
        AdData.Builder renderUri;
        android.adservices.common.AdData build;
        Intrinsics.checkNotNullParameter(adData, "adData");
        if (!adData.getAdCounterKeys().isEmpty()) {
            Log.w("AdData", "adCounterKeys is ignored. Min version to use adCounterKeys is API 33 ext 8 or API 31/32 ext 9");
        }
        if (adData.getAdFilters() != null) {
            Log.w("AdData", "adFilters is ignored. Min version to use adFilters is API 33 ext 8 or API 31/32 ext 9");
        }
        if (adData.getAdRenderId() != null) {
            Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
        }
        metadata = AbstractC1971x5.m8116o().setMetadata(adData.getMetadata());
        renderUri = metadata.setRenderUri(adData.getRenderUri());
        build = renderUri.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
        return build;
    }
}
