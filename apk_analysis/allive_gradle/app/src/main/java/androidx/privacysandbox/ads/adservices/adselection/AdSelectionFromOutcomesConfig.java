package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.AdSelectionFromOutcomesConfig;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFeatures.Ext10OptIn
@Metadata(m5568d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006-"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionFromOutcomesConfig;", "", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "seller", "", "", "adSelectionIds", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "adSelectionSignals", "Landroid/net/Uri;", "selectionLogicUri", "<init>", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Ljava/util/List;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Landroid/net/Uri;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/adselection/AdSelectionFromOutcomesConfig;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/adselection/AdSelectionFromOutcomesConfig;", "convertToAdServices", "a", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "b", "Ljava/util/List;", "getAdSelectionIds", "()Ljava/util/List;", "c", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "getAdSelectionSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "d", "Landroid/net/Uri;", "getSelectionLogicUri", "()Landroid/net/Uri;", "setSelectionLogicUri", "(Landroid/net/Uri;)V", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class AdSelectionFromOutcomesConfig {

    /* renamed from: a, reason: from kotlin metadata */
    public final AdTechIdentifier seller;

    /* renamed from: b, reason: from kotlin metadata */
    public final List adSelectionIds;

    /* renamed from: c, reason: from kotlin metadata */
    public final AdSelectionSignals adSelectionSignals;

    /* renamed from: d, reason: from kotlin metadata */
    public Uri selectionLogicUri;

    public AdSelectionFromOutcomesConfig(@NotNull AdTechIdentifier seller, @NotNull List<Long> adSelectionIds, @NotNull AdSelectionSignals adSelectionSignals, @NotNull Uri selectionLogicUri) {
        Intrinsics.checkNotNullParameter(seller, "seller");
        Intrinsics.checkNotNullParameter(adSelectionIds, "adSelectionIds");
        Intrinsics.checkNotNullParameter(adSelectionSignals, "adSelectionSignals");
        Intrinsics.checkNotNullParameter(selectionLogicUri, "selectionLogicUri");
        this.seller = seller;
        this.adSelectionIds = adSelectionIds;
        this.adSelectionSignals = adSelectionSignals;
        this.selectionLogicUri = selectionLogicUri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.adselection.AdSelectionFromOutcomesConfig convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.AdSelectionFromOutcomesConfig build = new AdSelectionFromOutcomesConfig.Builder().setSelectionSignals(this.adSelectionSignals.convertToAdServices$ads_adservices_release()).setAdSelectionIds(this.adSelectionIds).setSelectionLogicUri(this.selectionLogicUri).setSeller(this.seller.convertToAdServices$ads_adservices_release()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…s())\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdSelectionFromOutcomesConfig)) {
            return false;
        }
        AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig = (AdSelectionFromOutcomesConfig) other;
        if (Intrinsics.areEqual(this.seller, adSelectionFromOutcomesConfig.seller) && Intrinsics.areEqual(this.adSelectionIds, adSelectionFromOutcomesConfig.adSelectionIds) && Intrinsics.areEqual(this.adSelectionSignals, adSelectionFromOutcomesConfig.adSelectionSignals) && Intrinsics.areEqual(this.selectionLogicUri, adSelectionFromOutcomesConfig.selectionLogicUri)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<Long> getAdSelectionIds() {
        return this.adSelectionIds;
    }

    @NotNull
    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    @NotNull
    public final Uri getSelectionLogicUri() {
        return this.selectionLogicUri;
    }

    @NotNull
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        return this.selectionLogicUri.hashCode() + ((this.adSelectionSignals.hashCode() + ((this.adSelectionIds.hashCode() + (this.seller.hashCode() * 31)) * 31)) * 31);
    }

    public final void setSelectionLogicUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.selectionLogicUri = uri;
    }

    @NotNull
    public String toString() {
        return "AdSelectionFromOutcomesConfig: seller=" + this.seller + ", adSelectionIds='" + this.adSelectionIds + "', adSelectionSignals=" + this.adSelectionSignals + ", selectionLogicUri=" + this.selectionLogicUri;
    }
}
