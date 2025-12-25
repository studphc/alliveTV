package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFeatures.Ext10OptIn
@Metadata(m5568d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0015R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/FetchAndJoinCustomAudienceRequest;", "", "Landroid/net/Uri;", "fetchUri", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Ljava/time/Instant;", "activationTime", "expirationTime", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "userBiddingSignals", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/time/Instant;Ljava/time/Instant;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Landroid/adservices/customaudience/FetchAndJoinCustomAudienceRequest;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/customaudience/FetchAndJoinCustomAudienceRequest;", "convertToAdServices", "a", "Landroid/net/Uri;", "getFetchUri", "()Landroid/net/Uri;", "b", "Ljava/lang/String;", "getName", "c", "Ljava/time/Instant;", "getActivationTime", "()Ljava/time/Instant;", "d", "getExpirationTime", "e", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "getUserBiddingSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class FetchAndJoinCustomAudienceRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final Uri fetchUri;

    /* renamed from: b, reason: from kotlin metadata */
    public final String name;

    /* renamed from: c, reason: from kotlin metadata */
    public final Instant activationTime;

    /* renamed from: d, reason: from kotlin metadata */
    public final Instant expirationTime;

    /* renamed from: e, reason: from kotlin metadata */
    public final AdSelectionSignals userBiddingSignals;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri fetchUri) {
        this(fetchUri, null, null, null, null, 30, null);
        Intrinsics.checkNotNullParameter(fetchUri, "fetchUri");
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.customaudience.FetchAndJoinCustomAudienceRequest convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdSelectionSignals adSelectionSignals;
        FetchAndJoinCustomAudienceRequest.Builder expirationTime = new FetchAndJoinCustomAudienceRequest.Builder(this.fetchUri).setName(this.name).setActivationTime(this.activationTime).setExpirationTime(this.expirationTime);
        AdSelectionSignals adSelectionSignals2 = this.userBiddingSignals;
        if (adSelectionSignals2 != null) {
            adSelectionSignals = adSelectionSignals2.convertToAdServices$ads_adservices_release();
        } else {
            adSelectionSignals = null;
        }
        android.adservices.customaudience.FetchAndJoinCustomAudienceRequest build = expirationTime.setUserBiddingSignals(adSelectionSignals).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(fetchUri)\n      …s())\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FetchAndJoinCustomAudienceRequest)) {
            return false;
        }
        FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest = (FetchAndJoinCustomAudienceRequest) other;
        if (Intrinsics.areEqual(this.fetchUri, fetchAndJoinCustomAudienceRequest.fetchUri) && Intrinsics.areEqual(this.name, fetchAndJoinCustomAudienceRequest.name) && Intrinsics.areEqual(this.activationTime, fetchAndJoinCustomAudienceRequest.activationTime) && Intrinsics.areEqual(this.expirationTime, fetchAndJoinCustomAudienceRequest.expirationTime) && Intrinsics.areEqual(this.userBiddingSignals, fetchAndJoinCustomAudienceRequest.userBiddingSignals)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Instant getActivationTime() {
        return this.activationTime;
    }

    @Nullable
    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    @NotNull
    public final Uri getFetchUri() {
        return this.fetchUri;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int hashCode = this.fetchUri.hashCode() * 31;
        int i4 = 0;
        String str = this.name;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i5 = (hashCode + i) * 31;
        Instant instant = this.activationTime;
        if (instant != null) {
            i2 = instant.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i5 + i2) * 31;
        Instant instant2 = this.expirationTime;
        if (instant2 != null) {
            i3 = instant2.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        if (adSelectionSignals != null) {
            i4 = adSelectionSignals.hashCode();
        }
        return i7 + i4;
    }

    @NotNull
    public String toString() {
        return "FetchAndJoinCustomAudienceRequest: fetchUri=" + this.fetchUri + ", name=" + this.name + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", userBiddingSignals=" + this.userBiddingSignals;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri fetchUri, @Nullable String str) {
        this(fetchUri, str, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(fetchUri, "fetchUri");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri fetchUri, @Nullable String str, @Nullable Instant instant) {
        this(fetchUri, str, instant, null, null, 24, null);
        Intrinsics.checkNotNullParameter(fetchUri, "fetchUri");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri fetchUri, @Nullable String str, @Nullable Instant instant, @Nullable Instant instant2) {
        this(fetchUri, str, instant, instant2, null, 16, null);
        Intrinsics.checkNotNullParameter(fetchUri, "fetchUri");
    }

    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri fetchUri, @Nullable String str, @Nullable Instant instant, @Nullable Instant instant2, @Nullable AdSelectionSignals adSelectionSignals) {
        Intrinsics.checkNotNullParameter(fetchUri, "fetchUri");
        this.fetchUri = fetchUri;
        this.name = str;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
    }

    public /* synthetic */ FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : instant, (i & 8) != 0 ? null : instant2, (i & 16) != 0 ? null : adSelectionSignals);
    }
}
