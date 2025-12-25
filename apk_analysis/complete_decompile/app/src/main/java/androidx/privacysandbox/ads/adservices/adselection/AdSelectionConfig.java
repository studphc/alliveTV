package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.AdSelectionConfig;
import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1971x5;
import p000.lh1;

@Metadata(m5568d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 62\u00020\u0001:\u00016BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000b8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b4\u0010#\u001a\u0004\b5\u0010%¨\u00067"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "seller", "Landroid/net/Uri;", "decisionLogicUri", "", "customAudienceBuyers", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "adSelectionSignals", "sellerSignals", "", "perBuyerSignals", "trustedScoringSignalsUri", "<init>", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Landroid/net/Uri;Ljava/util/List;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Ljava/util/Map;Landroid/net/Uri;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/adselection/AdSelectionConfig;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/adselection/AdSelectionConfig;", "convertToAdServices", "a", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "b", "Landroid/net/Uri;", "getDecisionLogicUri", "()Landroid/net/Uri;", "c", "Ljava/util/List;", "getCustomAudienceBuyers", "()Ljava/util/List;", "d", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "getAdSelectionSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "e", "getSellerSignals", "f", "Ljava/util/Map;", "getPerBuyerSignals", "()Ljava/util/Map;", "g", "getTrustedScoringSignalsUri", "Companion", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class AdSelectionConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h */
    public static final AdSelectionConfig f6758h;

    /* renamed from: a, reason: from kotlin metadata */
    public final AdTechIdentifier seller;

    /* renamed from: b, reason: from kotlin metadata */
    public final Uri decisionLogicUri;

    /* renamed from: c, reason: from kotlin metadata */
    public final List customAudienceBuyers;

    /* renamed from: d, reason: from kotlin metadata */
    public final AdSelectionSignals adSelectionSignals;

    /* renamed from: e, reason: from kotlin metadata */
    public final AdSelectionSignals sellerSignals;

    /* renamed from: f, reason: from kotlin metadata */
    public final Map perBuyerSignals;

    /* renamed from: g, reason: from kotlin metadata */
    public final Uri trustedScoringSignalsUri;

    @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\u0003\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig$Companion;", "", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "EMPTY", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "getEMPTY", "()Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final AdSelectionConfig getEMPTY() {
            return AdSelectionConfig.f6758h;
        }
    }

    static {
        AdTechIdentifier adTechIdentifier = new AdTechIdentifier("");
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        AdSelectionSignals adSelectionSignals = new AdSelectionSignals("");
        AdSelectionSignals adSelectionSignals2 = new AdSelectionSignals("");
        Map emptyMap = lh1.emptyMap();
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        f6758h = new AdSelectionConfig(adTechIdentifier, EMPTY, emptyList, adSelectionSignals, adSelectionSignals2, emptyMap, EMPTY);
    }

    public AdSelectionConfig(@NotNull AdTechIdentifier seller, @NotNull Uri decisionLogicUri, @NotNull List<AdTechIdentifier> customAudienceBuyers, @NotNull AdSelectionSignals adSelectionSignals, @NotNull AdSelectionSignals sellerSignals, @NotNull Map<AdTechIdentifier, AdSelectionSignals> perBuyerSignals, @NotNull Uri trustedScoringSignalsUri) {
        Intrinsics.checkNotNullParameter(seller, "seller");
        Intrinsics.checkNotNullParameter(decisionLogicUri, "decisionLogicUri");
        Intrinsics.checkNotNullParameter(customAudienceBuyers, "customAudienceBuyers");
        Intrinsics.checkNotNullParameter(adSelectionSignals, "adSelectionSignals");
        Intrinsics.checkNotNullParameter(sellerSignals, "sellerSignals");
        Intrinsics.checkNotNullParameter(perBuyerSignals, "perBuyerSignals");
        Intrinsics.checkNotNullParameter(trustedScoringSignalsUri, "trustedScoringSignalsUri");
        this.seller = seller;
        this.decisionLogicUri = decisionLogicUri;
        this.customAudienceBuyers = customAudienceBuyers;
        this.adSelectionSignals = adSelectionSignals;
        this.sellerSignals = sellerSignals;
        this.perBuyerSignals = perBuyerSignals;
        this.trustedScoringSignalsUri = trustedScoringSignalsUri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.adselection.AdSelectionConfig convertToAdServices$ads_adservices_release() {
        AdSelectionConfig.Builder adSelectionSignals;
        AdSelectionConfig.Builder customAudienceBuyers;
        AdSelectionConfig.Builder decisionLogicUri;
        AdSelectionConfig.Builder seller;
        AdSelectionConfig.Builder perBuyerSignals;
        AdSelectionConfig.Builder sellerSignals;
        AdSelectionConfig.Builder trustedScoringSignalsUri;
        android.adservices.adselection.AdSelectionConfig build;
        android.adservices.common.AdSelectionSignals adSelectionSignals2;
        adSelectionSignals = AbstractC1971x5.m8106e().setAdSelectionSignals(this.adSelectionSignals.convertToAdServices$ads_adservices_release());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.customAudienceBuyers.iterator();
        while (it.hasNext()) {
            arrayList.add(((AdTechIdentifier) it.next()).convertToAdServices$ads_adservices_release());
        }
        customAudienceBuyers = adSelectionSignals.setCustomAudienceBuyers(arrayList);
        decisionLogicUri = customAudienceBuyers.setDecisionLogicUri(this.decisionLogicUri);
        seller = decisionLogicUri.setSeller(this.seller.convertToAdServices$ads_adservices_release());
        HashMap hashMap = new HashMap();
        Map map = this.perBuyerSignals;
        for (AdTechIdentifier adTechIdentifier : map.keySet()) {
            android.adservices.common.AdTechIdentifier convertToAdServices$ads_adservices_release = adTechIdentifier.convertToAdServices$ads_adservices_release();
            AdSelectionSignals adSelectionSignals3 = (AdSelectionSignals) map.get(adTechIdentifier);
            if (adSelectionSignals3 != null) {
                adSelectionSignals2 = adSelectionSignals3.convertToAdServices$ads_adservices_release();
            } else {
                adSelectionSignals2 = null;
            }
            hashMap.put(convertToAdServices$ads_adservices_release, adSelectionSignals2);
        }
        perBuyerSignals = seller.setPerBuyerSignals(hashMap);
        sellerSignals = perBuyerSignals.setSellerSignals(this.sellerSignals.convertToAdServices$ads_adservices_release());
        trustedScoringSignalsUri = sellerSignals.setTrustedScoringSignalsUri(this.trustedScoringSignalsUri);
        build = trustedScoringSignalsUri.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…Uri)\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdSelectionConfig)) {
            return false;
        }
        AdSelectionConfig adSelectionConfig = (AdSelectionConfig) other;
        if (Intrinsics.areEqual(this.seller, adSelectionConfig.seller) && Intrinsics.areEqual(this.decisionLogicUri, adSelectionConfig.decisionLogicUri) && Intrinsics.areEqual(this.customAudienceBuyers, adSelectionConfig.customAudienceBuyers) && Intrinsics.areEqual(this.adSelectionSignals, adSelectionConfig.adSelectionSignals) && Intrinsics.areEqual(this.sellerSignals, adSelectionConfig.sellerSignals) && Intrinsics.areEqual(this.perBuyerSignals, adSelectionConfig.perBuyerSignals) && Intrinsics.areEqual(this.trustedScoringSignalsUri, adSelectionConfig.trustedScoringSignalsUri)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    @NotNull
    public final List<AdTechIdentifier> getCustomAudienceBuyers() {
        return this.customAudienceBuyers;
    }

    @NotNull
    public final Uri getDecisionLogicUri() {
        return this.decisionLogicUri;
    }

    @NotNull
    public final Map<AdTechIdentifier, AdSelectionSignals> getPerBuyerSignals() {
        return this.perBuyerSignals;
    }

    @NotNull
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    @NotNull
    public final AdSelectionSignals getSellerSignals() {
        return this.sellerSignals;
    }

    @NotNull
    public final Uri getTrustedScoringSignalsUri() {
        return this.trustedScoringSignalsUri;
    }

    public int hashCode() {
        return this.trustedScoringSignalsUri.hashCode() + ((this.perBuyerSignals.hashCode() + ((this.sellerSignals.hashCode() + ((this.adSelectionSignals.hashCode() + ((this.customAudienceBuyers.hashCode() + ((this.decisionLogicUri.hashCode() + (this.seller.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "AdSelectionConfig: seller=" + this.seller + ", decisionLogicUri='" + this.decisionLogicUri + "', customAudienceBuyers=" + this.customAudienceBuyers + ", adSelectionSignals=" + this.adSelectionSignals + ", sellerSignals=" + this.sellerSignals + ", perBuyerSignals=" + this.perBuyerSignals + ", trustedScoringSignalsUri=" + this.trustedScoringSignalsUri;
    }
}
