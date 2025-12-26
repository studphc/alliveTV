package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.GetAdSelectionDataRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"androidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest$Ext12Impl$Companion", "", "Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;", "request", "Landroid/adservices/adselection/GetAdSelectionDataRequest;", "convertGetAdSelectionDataRequest", "(Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;)Landroid/adservices/adselection/GetAdSelectionDataRequest;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class GetAdSelectionDataRequest$Ext12Impl$Companion {
    public GetAdSelectionDataRequest$Ext12Impl$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @NotNull
    public final android.adservices.adselection.GetAdSelectionDataRequest convertGetAdSelectionDataRequest(@NotNull GetAdSelectionDataRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        android.adservices.adselection.GetAdSelectionDataRequest build = new GetAdSelectionDataRequest.Builder().setSeller(request.getSeller().convertToAdServices$ads_adservices_release()).setCoordinatorOriginUri(request.getCoordinatorOriginUri()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
        return build;
    }
}
