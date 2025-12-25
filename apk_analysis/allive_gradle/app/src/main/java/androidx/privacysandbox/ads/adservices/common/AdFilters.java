package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdFilters;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdFilters;", "", "Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters;", "frequencyCapFilters", "<init>", "(Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/common/AdFilters;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/common/AdFilters;", "convertToAdServices", "a", "Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters;", "getFrequencyCapFilters", "()Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes.dex */
public final class AdFilters {

    /* renamed from: a, reason: from kotlin metadata */
    public final FrequencyCapFilters frequencyCapFilters;

    public AdFilters(@Nullable FrequencyCapFilters frequencyCapFilters) {
        this.frequencyCapFilters = frequencyCapFilters;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.common.AdFilters convertToAdServices$ads_adservices_release() {
        android.adservices.common.FrequencyCapFilters frequencyCapFilters;
        AdFilters.Builder builder = new AdFilters.Builder();
        FrequencyCapFilters frequencyCapFilters2 = this.frequencyCapFilters;
        if (frequencyCapFilters2 != null) {
            frequencyCapFilters = frequencyCapFilters2.convertToAdServices$ads_adservices_release();
        } else {
            frequencyCapFilters = null;
        }
        android.adservices.common.AdFilters build = builder.setFrequencyCapFilters(frequencyCapFilters).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…s())\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdFilters)) {
            return false;
        }
        return Intrinsics.areEqual(this.frequencyCapFilters, ((AdFilters) other).frequencyCapFilters);
    }

    @Nullable
    public final FrequencyCapFilters getFrequencyCapFilters() {
        return this.frequencyCapFilters;
    }

    public int hashCode() {
        FrequencyCapFilters frequencyCapFilters = this.frequencyCapFilters;
        if (frequencyCapFilters != null) {
            return frequencyCapFilters.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "AdFilters: frequencyCapFilters=" + this.frequencyCapFilters;
    }
}
