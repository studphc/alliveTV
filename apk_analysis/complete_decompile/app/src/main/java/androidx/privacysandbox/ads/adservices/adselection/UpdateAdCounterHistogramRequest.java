package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/UpdateAdCounterHistogramRequest;", "", "", "adSelectionId", "", "adEventType", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "callerAdTech", "<init>", "(JILandroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/adselection/UpdateAdCounterHistogramRequest;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/adselection/UpdateAdCounterHistogramRequest;", "convertToAdServices", "a", "J", "getAdSelectionId", "()J", "b", "I", "getAdEventType", "c", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getCallerAdTech", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes.dex */
public final class UpdateAdCounterHistogramRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final long adSelectionId;

    /* renamed from: b, reason: from kotlin metadata */
    public final int adEventType;

    /* renamed from: c, reason: from kotlin metadata */
    public final AdTechIdentifier callerAdTech;

    public UpdateAdCounterHistogramRequest(long j, int i, @NotNull AdTechIdentifier callerAdTech) {
        Intrinsics.checkNotNullParameter(callerAdTech, "callerAdTech");
        this.adSelectionId = j;
        this.adEventType = i;
        this.callerAdTech = callerAdTech;
        if (i != 0) {
            if (i != 1 && i != 2 && i != 3) {
                throw new IllegalArgumentException("Ad event type must be one of AD_EVENT_TYPE_IMPRESSION, AD_EVENT_TYPE_VIEW, or AD_EVENT_TYPE_CLICK");
            }
            return;
        }
        throw new IllegalArgumentException("Win event types cannot be manually updated.");
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.adselection.UpdateAdCounterHistogramRequest convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.UpdateAdCounterHistogramRequest build = new UpdateAdCounterHistogramRequest.Builder(this.adSelectionId, this.adEventType, this.callerAdTech.convertToAdServices$ads_adservices_release()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(\n               …   )\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateAdCounterHistogramRequest)) {
            return false;
        }
        UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest = (UpdateAdCounterHistogramRequest) other;
        if (this.adSelectionId == updateAdCounterHistogramRequest.adSelectionId && this.adEventType == updateAdCounterHistogramRequest.adEventType && Intrinsics.areEqual(this.callerAdTech, updateAdCounterHistogramRequest.callerAdTech)) {
            return true;
        }
        return false;
    }

    public final int getAdEventType() {
        return this.adEventType;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    @NotNull
    public final AdTechIdentifier getCallerAdTech() {
        return this.callerAdTech;
    }

    public int hashCode() {
        long j = this.adSelectionId;
        return this.callerAdTech.hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + this.adEventType) * 31);
    }

    @NotNull
    public String toString() {
        String str;
        int i = this.adEventType;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        str = "Invalid ad event type";
                    } else {
                        str = "AD_EVENT_TYPE_CLICK";
                    }
                } else {
                    str = "AD_EVENT_TYPE_VIEW";
                }
            } else {
                str = "AD_EVENT_TYPE_IMPRESSION";
            }
        } else {
            str = "AD_EVENT_TYPE_WIN";
        }
        return "UpdateAdCounterHistogramRequest: adSelectionId=" + this.adSelectionId + ", adEventType=" + str + ", callerAdTech=" + this.callerAdTech;
    }
}
