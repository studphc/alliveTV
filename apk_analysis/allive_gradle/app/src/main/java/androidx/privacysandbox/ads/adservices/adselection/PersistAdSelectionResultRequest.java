package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFeatures.Ext10OptIn
@Metadata(m5568d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/PersistAdSelectionResultRequest;", "", "", "adSelectionId", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "seller", "", "adSelectionResult", "<init>", "(JLandroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;[B)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/adselection/PersistAdSelectionResultRequest;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/adselection/PersistAdSelectionResultRequest;", "convertToAdServices", "a", "J", "getAdSelectionId", "()J", "b", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "c", "[B", "getAdSelectionResult", "()[B", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class PersistAdSelectionResultRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final long adSelectionId;

    /* renamed from: b, reason: from kotlin metadata */
    public final AdTechIdentifier seller;

    /* renamed from: c, reason: from kotlin metadata */
    public final byte[] adSelectionResult;

    @JvmOverloads
    public PersistAdSelectionResultRequest(long j) {
        this(j, null, null, 6, null);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.adselection.PersistAdSelectionResultRequest convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdTechIdentifier adTechIdentifier;
        PersistAdSelectionResultRequest.Builder adSelectionId = new PersistAdSelectionResultRequest.Builder().setAdSelectionId(this.adSelectionId);
        AdTechIdentifier adTechIdentifier2 = this.seller;
        if (adTechIdentifier2 != null) {
            adTechIdentifier = adTechIdentifier2.convertToAdServices$ads_adservices_release();
        } else {
            adTechIdentifier = null;
        }
        android.adservices.adselection.PersistAdSelectionResultRequest build = adSelectionId.setSeller(adTechIdentifier).setAdSelectionResult(this.adSelectionResult).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ult)\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersistAdSelectionResultRequest)) {
            return false;
        }
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = (PersistAdSelectionResultRequest) other;
        if (this.adSelectionId == persistAdSelectionResultRequest.adSelectionId && Intrinsics.areEqual(this.seller, persistAdSelectionResultRequest.seller) && Arrays.equals(this.adSelectionResult, persistAdSelectionResultRequest.adSelectionResult)) {
            return true;
        }
        return false;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    @Nullable
    public final byte[] getAdSelectionResult() {
        return this.adSelectionResult;
    }

    @Nullable
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int i;
        long j = this.adSelectionId;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        int i3 = 0;
        AdTechIdentifier adTechIdentifier = this.seller;
        if (adTechIdentifier != null) {
            i = adTechIdentifier.hashCode();
        } else {
            i = 0;
        }
        int i4 = (i2 + i) * 31;
        byte[] bArr = this.adSelectionResult;
        if (bArr != null) {
            i3 = bArr.hashCode();
        }
        return i4 + i3;
    }

    @NotNull
    public String toString() {
        return "PersistAdSelectionResultRequest: adSelectionId=" + this.adSelectionId + ", seller=" + this.seller + ", adSelectionResult=" + this.adSelectionResult;
    }

    @JvmOverloads
    public PersistAdSelectionResultRequest(long j, @Nullable AdTechIdentifier adTechIdentifier) {
        this(j, adTechIdentifier, null, 4, null);
    }

    @JvmOverloads
    public PersistAdSelectionResultRequest(long j, @Nullable AdTechIdentifier adTechIdentifier, @Nullable byte[] bArr) {
        this.adSelectionId = j;
        this.seller = adTechIdentifier;
        this.adSelectionResult = bArr;
    }

    public /* synthetic */ PersistAdSelectionResultRequest(long j, AdTechIdentifier adTechIdentifier, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : adTechIdentifier, (i & 4) != 0 ? null : bArr);
    }
}
