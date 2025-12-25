package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdData;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.time.Instant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\u0018\u00002\u00020\u0001:\u0001=Be\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u00102R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006>"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "buyer", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroid/net/Uri;", "dailyUpdateUri", "biddingLogicUri", "", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "ads", "Ljava/time/Instant;", "activationTime", "expirationTime", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "userBiddingSignals", "Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "trustedBiddingSignals", "<init>", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/util/List;Ljava/time/Instant;Ljava/time/Instant;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "a", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getBuyer", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "b", "Ljava/lang/String;", "getName", "c", "Landroid/net/Uri;", "getDailyUpdateUri", "()Landroid/net/Uri;", "d", "getBiddingLogicUri", "e", "Ljava/util/List;", "getAds", "()Ljava/util/List;", "f", "Ljava/time/Instant;", "getActivationTime", "()Ljava/time/Instant;", "g", "getExpirationTime", "h", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "getUserBiddingSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "i", "Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "getTrustedBiddingSignals", "()Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "Builder", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class CustomAudience {

    /* renamed from: a, reason: from kotlin metadata */
    public final AdTechIdentifier buyer;

    /* renamed from: b, reason: from kotlin metadata */
    public final String name;

    /* renamed from: c, reason: from kotlin metadata */
    public final Uri dailyUpdateUri;

    /* renamed from: d, reason: from kotlin metadata */
    public final Uri biddingLogicUri;

    /* renamed from: e, reason: from kotlin metadata */
    public final List ads;

    /* renamed from: f, reason: from kotlin metadata */
    public final Instant activationTime;

    /* renamed from: g, reason: from kotlin metadata */
    public final Instant expirationTime;

    /* renamed from: h, reason: from kotlin metadata */
    public final AdSelectionSignals userBiddingSignals;

    /* renamed from: i, reason: from kotlin metadata */
    public final TrustedBiddingData trustedBiddingSignals;

    @Metadata(m5568d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u0019J\u001b\u0010#\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b#\u0010$J\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'¨\u0006("}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "buyer", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Landroid/net/Uri;", "dailyUpdateUri", "biddingLogicUri", "", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "ads", "<init>", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/util/List;)V", "setBuyer", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;)Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "setName", "(Ljava/lang/String;)Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "Ljava/time/Instant;", "activationTime", "setActivationTime", "(Ljava/time/Instant;)Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "expirationTime", "setExpirationTime", "setDailyUpdateUri", "(Landroid/net/Uri;)Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "userBiddingSignals", "setUserBiddingSignals", "(Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;)Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "trustedBiddingSignals", "setTrustedBiddingData", "(Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;)Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "setBiddingLogicUri", "setAds", "(Ljava/util/List;)Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "build", "()Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nCustomAudience.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomAudience.kt\nandroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,252:1\n1#2:253\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public AdTechIdentifier f6819a;

        /* renamed from: b */
        public String f6820b;

        /* renamed from: c */
        public Uri f6821c;

        /* renamed from: d */
        public Uri f6822d;

        /* renamed from: e */
        public List f6823e;

        /* renamed from: f */
        public Instant f6824f;

        /* renamed from: g */
        public Instant f6825g;

        /* renamed from: h */
        public AdSelectionSignals f6826h;

        /* renamed from: i */
        public TrustedBiddingData f6827i;

        public Builder(@NotNull AdTechIdentifier buyer, @NotNull String name, @NotNull Uri dailyUpdateUri, @NotNull Uri biddingLogicUri, @NotNull List<AdData> ads) {
            Intrinsics.checkNotNullParameter(buyer, "buyer");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(dailyUpdateUri, "dailyUpdateUri");
            Intrinsics.checkNotNullParameter(biddingLogicUri, "biddingLogicUri");
            Intrinsics.checkNotNullParameter(ads, "ads");
            this.f6819a = buyer;
            this.f6820b = name;
            this.f6821c = dailyUpdateUri;
            this.f6822d = biddingLogicUri;
            this.f6823e = ads;
        }

        @NotNull
        public final CustomAudience build() {
            return new CustomAudience(this.f6819a, this.f6820b, this.f6821c, this.f6822d, this.f6823e, this.f6824f, this.f6825g, this.f6826h, this.f6827i);
        }

        @NotNull
        public final Builder setActivationTime(@NotNull Instant activationTime) {
            Intrinsics.checkNotNullParameter(activationTime, "activationTime");
            this.f6824f = activationTime;
            return this;
        }

        @NotNull
        public final Builder setAds(@NotNull List<AdData> ads) {
            Intrinsics.checkNotNullParameter(ads, "ads");
            this.f6823e = ads;
            return this;
        }

        @NotNull
        public final Builder setBiddingLogicUri(@NotNull Uri biddingLogicUri) {
            Intrinsics.checkNotNullParameter(biddingLogicUri, "biddingLogicUri");
            this.f6822d = biddingLogicUri;
            return this;
        }

        @NotNull
        public final Builder setBuyer(@NotNull AdTechIdentifier buyer) {
            Intrinsics.checkNotNullParameter(buyer, "buyer");
            this.f6819a = buyer;
            return this;
        }

        @NotNull
        public final Builder setDailyUpdateUri(@NotNull Uri dailyUpdateUri) {
            Intrinsics.checkNotNullParameter(dailyUpdateUri, "dailyUpdateUri");
            this.f6821c = dailyUpdateUri;
            return this;
        }

        @NotNull
        public final Builder setExpirationTime(@NotNull Instant expirationTime) {
            Intrinsics.checkNotNullParameter(expirationTime, "expirationTime");
            this.f6825g = expirationTime;
            return this;
        }

        @NotNull
        public final Builder setName(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f6820b = name;
            return this;
        }

        @NotNull
        public final Builder setTrustedBiddingData(@NotNull TrustedBiddingData trustedBiddingSignals) {
            Intrinsics.checkNotNullParameter(trustedBiddingSignals, "trustedBiddingSignals");
            this.f6827i = trustedBiddingSignals;
            return this;
        }

        @NotNull
        public final Builder setUserBiddingSignals(@NotNull AdSelectionSignals userBiddingSignals) {
            Intrinsics.checkNotNullParameter(userBiddingSignals, "userBiddingSignals");
            this.f6826h = userBiddingSignals;
            return this;
        }
    }

    public CustomAudience(@NotNull AdTechIdentifier buyer, @NotNull String name, @NotNull Uri dailyUpdateUri, @NotNull Uri biddingLogicUri, @NotNull List<AdData> ads, @Nullable Instant instant, @Nullable Instant instant2, @Nullable AdSelectionSignals adSelectionSignals, @Nullable TrustedBiddingData trustedBiddingData) {
        Intrinsics.checkNotNullParameter(buyer, "buyer");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dailyUpdateUri, "dailyUpdateUri");
        Intrinsics.checkNotNullParameter(biddingLogicUri, "biddingLogicUri");
        Intrinsics.checkNotNullParameter(ads, "ads");
        this.buyer = buyer;
        this.name = name;
        this.dailyUpdateUri = dailyUpdateUri;
        this.biddingLogicUri = biddingLogicUri;
        this.ads = ads;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
        this.trustedBiddingSignals = trustedBiddingData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomAudience)) {
            return false;
        }
        CustomAudience customAudience = (CustomAudience) other;
        if (Intrinsics.areEqual(this.buyer, customAudience.buyer) && Intrinsics.areEqual(this.name, customAudience.name) && Intrinsics.areEqual(this.activationTime, customAudience.activationTime) && Intrinsics.areEqual(this.expirationTime, customAudience.expirationTime) && Intrinsics.areEqual(this.dailyUpdateUri, customAudience.dailyUpdateUri) && Intrinsics.areEqual(this.userBiddingSignals, customAudience.userBiddingSignals) && Intrinsics.areEqual(this.trustedBiddingSignals, customAudience.trustedBiddingSignals) && Intrinsics.areEqual(this.ads, customAudience.ads)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Instant getActivationTime() {
        return this.activationTime;
    }

    @NotNull
    public final List<AdData> getAds() {
        return this.ads;
    }

    @NotNull
    public final Uri getBiddingLogicUri() {
        return this.biddingLogicUri;
    }

    @NotNull
    public final AdTechIdentifier getBuyer() {
        return this.buyer;
    }

    @NotNull
    public final Uri getDailyUpdateUri() {
        return this.dailyUpdateUri;
    }

    @Nullable
    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final TrustedBiddingData getTrustedBiddingSignals() {
        return this.trustedBiddingSignals;
    }

    @Nullable
    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int m8286f = ye0.m8286f(this.buyer.hashCode() * 31, 31, this.name);
        Instant instant = this.activationTime;
        int i4 = 0;
        if (instant != null) {
            i = instant.hashCode();
        } else {
            i = 0;
        }
        int i5 = (m8286f + i) * 31;
        Instant instant2 = this.expirationTime;
        if (instant2 != null) {
            i2 = instant2.hashCode();
        } else {
            i2 = 0;
        }
        int hashCode = (this.dailyUpdateUri.hashCode() + ((i5 + i2) * 31)) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        if (adSelectionSignals != null) {
            i3 = adSelectionSignals.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (hashCode + i3) * 31;
        TrustedBiddingData trustedBiddingData = this.trustedBiddingSignals;
        if (trustedBiddingData != null) {
            i4 = trustedBiddingData.hashCode();
        }
        return this.ads.hashCode() + ((this.biddingLogicUri.hashCode() + ((i6 + i4) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomAudience: buyer=");
        Uri uri = this.biddingLogicUri;
        sb.append(uri);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", activationTime=");
        sb.append(this.activationTime);
        sb.append(", expirationTime=");
        sb.append(this.expirationTime);
        sb.append(", dailyUpdateUri=");
        sb.append(this.dailyUpdateUri);
        sb.append(", userBiddingSignals=");
        sb.append(this.userBiddingSignals);
        sb.append(", trustedBiddingSignals=");
        sb.append(this.trustedBiddingSignals);
        sb.append(", biddingLogicUri=");
        sb.append(uri);
        sb.append(", ads=");
        sb.append(this.ads);
        return sb.toString();
    }

    public /* synthetic */ CustomAudience(AdTechIdentifier adTechIdentifier, String str, Uri uri, Uri uri2, List list, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, TrustedBiddingData trustedBiddingData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adTechIdentifier, str, uri, uri2, list, (i & 32) != 0 ? null : instant, (i & 64) != 0 ? null : instant2, (i & 128) != 0 ? null : adSelectionSignals, (i & 256) != 0 ? null : trustedBiddingData);
    }
}
