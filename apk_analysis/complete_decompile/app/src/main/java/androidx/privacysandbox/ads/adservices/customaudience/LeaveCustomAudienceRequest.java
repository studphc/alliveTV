package androidx.privacysandbox.ads.adservices.customaudience;

import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;", "", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "buyer", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "<init>", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "a", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getBuyer", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "b", "Ljava/lang/String;", "getName", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class LeaveCustomAudienceRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final AdTechIdentifier buyer;

    /* renamed from: b, reason: from kotlin metadata */
    public final String name;

    public LeaveCustomAudienceRequest(@NotNull AdTechIdentifier buyer, @NotNull String name) {
        Intrinsics.checkNotNullParameter(buyer, "buyer");
        Intrinsics.checkNotNullParameter(name, "name");
        this.buyer = buyer;
        this.name = name;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveCustomAudienceRequest)) {
            return false;
        }
        LeaveCustomAudienceRequest leaveCustomAudienceRequest = (LeaveCustomAudienceRequest) other;
        if (Intrinsics.areEqual(this.buyer, leaveCustomAudienceRequest.buyer) && Intrinsics.areEqual(this.name, leaveCustomAudienceRequest.name)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AdTechIdentifier getBuyer() {
        return this.buyer;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode() + (this.buyer.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "LeaveCustomAudience: buyer=" + this.buyer + ", name=" + this.name;
    }
}
