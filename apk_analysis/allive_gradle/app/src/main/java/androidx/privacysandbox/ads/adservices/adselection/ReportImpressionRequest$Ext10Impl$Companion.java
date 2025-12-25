package androidx.privacysandbox.ads.adservices.adselection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.hb2;
import p000.mk1;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"androidx/privacysandbox/ads/adservices/adselection/ReportImpressionRequest$Ext10Impl$Companion", "", "Landroidx/privacysandbox/ads/adservices/adselection/ReportImpressionRequest;", "request", "Landroid/adservices/adselection/ReportImpressionRequest;", "convertReportImpressionRequest", "(Landroidx/privacysandbox/ads/adservices/adselection/ReportImpressionRequest;)Landroid/adservices/adselection/ReportImpressionRequest;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class ReportImpressionRequest$Ext10Impl$Companion {
    public ReportImpressionRequest$Ext10Impl$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @NotNull
    public final android.adservices.adselection.ReportImpressionRequest convertReportImpressionRequest(@NotNull ReportImpressionRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (Intrinsics.areEqual(request.getAdSelectionConfig(), AdSelectionConfig.INSTANCE.getEMPTY())) {
            mk1.m6172t();
            return hb2.m5049a(request.getAdSelectionId());
        }
        mk1.m6172t();
        return mk1.m6153a(request.getAdSelectionId(), request.getAdSelectionConfig().convertToAdServices$ads_adservices_release());
    }
}
