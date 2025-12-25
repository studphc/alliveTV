package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ib2;
import p000.jb2;

@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/ReportImpressionRequest;", "", "", "adSelectionId", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "adSelectionConfig", "<init>", "(JLandroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;)V", "(J)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/adselection/ReportImpressionRequest;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/adselection/ReportImpressionRequest;", "convertToAdServices", "a", "J", "getAdSelectionId", "()J", "b", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "getAdSelectionConfig", "()Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "ib2", "jb2", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class ReportImpressionRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final long adSelectionId;

    /* renamed from: b, reason: from kotlin metadata */
    public final AdSelectionConfig adSelectionConfig;

    public ReportImpressionRequest(long j, @NotNull AdSelectionConfig adSelectionConfig) {
        Intrinsics.checkNotNullParameter(adSelectionConfig, "adSelectionConfig");
        this.adSelectionId = j;
        this.adSelectionConfig = adSelectionConfig;
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.adselection.ReportImpressionRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 10 && adServicesInfo.extServicesVersionS() < 10) {
            return jb2.f20454a.convertReportImpressionRequest(this);
        }
        return ib2.f18357a.convertReportImpressionRequest(this);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportImpressionRequest)) {
            return false;
        }
        ReportImpressionRequest reportImpressionRequest = (ReportImpressionRequest) other;
        if (this.adSelectionId == reportImpressionRequest.adSelectionId && Intrinsics.areEqual(this.adSelectionConfig, reportImpressionRequest.adSelectionConfig)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AdSelectionConfig getAdSelectionConfig() {
        return this.adSelectionConfig;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        long j = this.adSelectionId;
        return this.adSelectionConfig.hashCode() + (((int) (j ^ (j >>> 32))) * 31);
    }

    @NotNull
    public String toString() {
        return "ReportImpressionRequest: adSelectionId=" + this.adSelectionId + ", adSelectionConfig=" + this.adSelectionConfig;
    }

    @ExperimentalFeatures.Ext8OptIn
    public ReportImpressionRequest(long j) {
        this(j, AdSelectionConfig.INSTANCE.getEMPTY());
    }
}
