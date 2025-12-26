package androidx.privacysandbox.ads.adservices.common;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1934w5;
import p000.AbstractC2008y5;
import p000.AbstractC2045z5;
import p000.sh2;
import p000.ye0;

@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001:\u0003-./BA\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rB5\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0017R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010\u0017¨\u00060"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdData;", "", "Landroid/net/Uri;", "renderUri", "", "metadata", "", "", "adCounterKeys", "Landroidx/privacysandbox/ads/adservices/common/AdFilters;", "adFilters", "adRenderId", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Set;Landroidx/privacysandbox/ads/adservices/common/AdFilters;Ljava/lang/String;)V", "(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Set;Landroidx/privacysandbox/ads/adservices/common/AdFilters;)V", "(Landroid/net/Uri;Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Landroid/adservices/common/AdData;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/common/AdData;", "convertToAdServices", "a", "Landroid/net/Uri;", "getRenderUri", "()Landroid/net/Uri;", "b", "Ljava/lang/String;", "getMetadata", "c", "Ljava/util/Set;", "getAdCounterKeys", "()Ljava/util/Set;", "d", "Landroidx/privacysandbox/ads/adservices/common/AdFilters;", "getAdFilters", "()Landroidx/privacysandbox/ads/adservices/common/AdFilters;", "e", "getAdRenderId", "w5", "y5", "z5", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class AdData {

    /* renamed from: a, reason: from kotlin metadata */
    public final Uri renderUri;

    /* renamed from: b, reason: from kotlin metadata */
    public final String metadata;

    /* renamed from: c, reason: from kotlin metadata */
    public final Set adCounterKeys;

    /* renamed from: d, reason: from kotlin metadata */
    public final AdFilters adFilters;

    /* renamed from: e, reason: from kotlin metadata */
    public final String adRenderId;

    @ExperimentalFeatures.Ext10OptIn
    public AdData(@NotNull Uri renderUri, @NotNull String metadata, @NotNull Set<Integer> adCounterKeys, @Nullable AdFilters adFilters, @Nullable String str) {
        Intrinsics.checkNotNullParameter(renderUri, "renderUri");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(adCounterKeys, "adCounterKeys");
        this.renderUri = renderUri;
        this.metadata = metadata;
        this.adCounterKeys = adCounterKeys;
        this.adFilters = adFilters;
        this.adRenderId = str;
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.common.AdData convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 10 && adServicesInfo.extServicesVersionS() < 10) {
            if (adServicesInfo.adServicesVersion() < 8 && adServicesInfo.extServicesVersionS() < 9) {
                return AbstractC2008y5.f28843a.convertAdData(this);
            }
            return AbstractC2045z5.f29249a.convertAdData(this);
        }
        return AbstractC1934w5.f28069a.convertAdData(this);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) other;
        if (Intrinsics.areEqual(this.renderUri, adData.renderUri) && Intrinsics.areEqual(this.metadata, adData.metadata) && Intrinsics.areEqual(this.adCounterKeys, adData.adCounterKeys) && Intrinsics.areEqual(this.adFilters, adData.adFilters) && Intrinsics.areEqual(this.adRenderId, adData.adRenderId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Set<Integer> getAdCounterKeys() {
        return this.adCounterKeys;
    }

    @Nullable
    public final AdFilters getAdFilters() {
        return this.adFilters;
    }

    @Nullable
    public final String getAdRenderId() {
        return this.adRenderId;
    }

    @NotNull
    public final String getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final Uri getRenderUri() {
        return this.renderUri;
    }

    public int hashCode() {
        int i;
        int hashCode = (this.adCounterKeys.hashCode() + ye0.m8286f(this.renderUri.hashCode() * 31, 31, this.metadata)) * 31;
        int i2 = 0;
        AdFilters adFilters = this.adFilters;
        if (adFilters != null) {
            i = adFilters.hashCode();
        } else {
            i = 0;
        }
        int i3 = (hashCode + i) * 31;
        String str = this.adRenderId;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i3 + i2;
    }

    @NotNull
    public String toString() {
        return "AdData: renderUri=" + this.renderUri + ", metadata='" + this.metadata + "', adCounterKeys=" + this.adCounterKeys + ", adFilters=" + this.adFilters + ", adRenderId=" + this.adRenderId;
    }

    public /* synthetic */ AdData(Uri uri, String str, Set set, AdFilters adFilters, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? sh2.emptySet() : set, (i & 8) != 0 ? null : adFilters, (i & 16) != 0 ? null : str2);
    }

    public /* synthetic */ AdData(Uri uri, String str, Set set, AdFilters adFilters, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? sh2.emptySet() : set, (i & 8) != 0 ? null : adFilters);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @ExperimentalFeatures.Ext8OptIn
    public AdData(@NotNull Uri renderUri, @NotNull String metadata, @NotNull Set<Integer> adCounterKeys, @Nullable AdFilters adFilters) {
        this(renderUri, metadata, adCounterKeys, adFilters, null);
        Intrinsics.checkNotNullParameter(renderUri, "renderUri");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(adCounterKeys, "adCounterKeys");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdData(@NotNull Uri renderUri, @NotNull String metadata) {
        this(renderUri, metadata, sh2.emptySet(), null);
        Intrinsics.checkNotNullParameter(renderUri, "renderUri");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
    }
}
