package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.sw0;
import p000.tw0;

@ExperimentalFeatures.Ext10OptIn
@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u0002 !B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;", "", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "seller", "Landroid/net/Uri;", "coordinatorOriginUri", "<init>", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Landroid/net/Uri;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/adselection/GetAdSelectionDataRequest;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/adselection/GetAdSelectionDataRequest;", "convertToAdServices", "a", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "b", "Landroid/net/Uri;", "getCoordinatorOriginUri", "()Landroid/net/Uri;", "getCoordinatorOriginUri$annotations", "()V", "sw0", "tw0", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class GetAdSelectionDataRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final AdTechIdentifier seller;

    /* renamed from: b, reason: from kotlin metadata */
    public final Uri coordinatorOriginUri;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public GetAdSelectionDataRequest(@NotNull AdTechIdentifier seller) {
        this(seller, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(seller, "seller");
    }

    @ExperimentalFeatures.Ext12OptIn
    public static /* synthetic */ void getCoordinatorOriginUri$annotations() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @SuppressLint({"NewApi"})
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.GetAdSelectionDataRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 12 && adServicesInfo.extServicesVersionS() < 12) {
            return sw0.f26593a.convertGetAdSelectionDataRequest(this);
        }
        return tw0.f27003a.convertGetAdSelectionDataRequest(this);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetAdSelectionDataRequest)) {
            return false;
        }
        GetAdSelectionDataRequest getAdSelectionDataRequest = (GetAdSelectionDataRequest) other;
        if (Intrinsics.areEqual(this.seller, getAdSelectionDataRequest.seller) && Intrinsics.areEqual(this.coordinatorOriginUri, getAdSelectionDataRequest.coordinatorOriginUri)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Uri getCoordinatorOriginUri() {
        return this.coordinatorOriginUri;
    }

    @NotNull
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int i;
        int hashCode = this.seller.hashCode() * 31;
        Uri uri = this.coordinatorOriginUri;
        if (uri != null) {
            i = uri.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "GetAdSelectionDataRequest: seller=" + this.seller + ", coordinatorOriginUri=" + this.coordinatorOriginUri;
    }

    @JvmOverloads
    public GetAdSelectionDataRequest(@NotNull AdTechIdentifier seller, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(seller, "seller");
        this.seller = seller;
        this.coordinatorOriginUri = uri;
    }

    public /* synthetic */ GetAdSelectionDataRequest(AdTechIdentifier adTechIdentifier, Uri uri, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adTechIdentifier, (i & 2) != 0 ? null : uri);
    }
}
