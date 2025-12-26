package androidx.privacysandbox.ads.adservices.customaudience;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;", "", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "customAudience", "<init>", "(Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "getCustomAudience", "()Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class JoinCustomAudienceRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final CustomAudience customAudience;

    public JoinCustomAudienceRequest(@NotNull CustomAudience customAudience) {
        Intrinsics.checkNotNullParameter(customAudience, "customAudience");
        this.customAudience = customAudience;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinCustomAudienceRequest)) {
            return false;
        }
        return Intrinsics.areEqual(this.customAudience, ((JoinCustomAudienceRequest) other).customAudience);
    }

    @NotNull
    public final CustomAudience getCustomAudience() {
        return this.customAudience;
    }

    public int hashCode() {
        return this.customAudience.hashCode();
    }

    @NotNull
    public String toString() {
        return "JoinCustomAudience: customAudience=" + this.customAudience;
    }
}
