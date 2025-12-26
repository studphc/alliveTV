package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.ReportEventRequest;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"androidx/privacysandbox/ads/adservices/adselection/ReportEventRequest$Ext8Impl$Companion", "", "Landroidx/privacysandbox/ads/adservices/adselection/ReportEventRequest;", "request", "Landroid/adservices/adselection/ReportEventRequest;", "convertReportEventRequest", "(Landroidx/privacysandbox/ads/adservices/adselection/ReportEventRequest;)Landroid/adservices/adselection/ReportEventRequest;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class ReportEventRequest$Ext8Impl$Companion {
    public ReportEventRequest$Ext8Impl$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @NotNull
    public final android.adservices.adselection.ReportEventRequest convertReportEventRequest(@NotNull ReportEventRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.getInputEvent() != null) {
            Log.w("ReportEventRequest", "inputEvent is ignored. Min version to use inputEvent is API 31 ext 10");
        }
        android.adservices.adselection.ReportEventRequest build = new ReportEventRequest.Builder(request.getAdSelectionId(), request.getEventKey(), request.getEventData(), request.getReportingDestinations()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(\n               …                 .build()");
        return build;
    }
}
