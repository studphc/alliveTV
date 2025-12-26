package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "", "Landroid/net/Uri;", "trustedBiddingUri", "", "", "trustedBiddingKeys", "<init>", "(Landroid/net/Uri;Ljava/util/List;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "a", "Landroid/net/Uri;", "getTrustedBiddingUri", "()Landroid/net/Uri;", "b", "Ljava/util/List;", "getTrustedBiddingKeys", "()Ljava/util/List;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class TrustedBiddingData {

    /* renamed from: a, reason: from kotlin metadata */
    public final Uri trustedBiddingUri;

    /* renamed from: b, reason: from kotlin metadata */
    public final List trustedBiddingKeys;

    public TrustedBiddingData(@NotNull Uri trustedBiddingUri, @NotNull List<String> trustedBiddingKeys) {
        Intrinsics.checkNotNullParameter(trustedBiddingUri, "trustedBiddingUri");
        Intrinsics.checkNotNullParameter(trustedBiddingKeys, "trustedBiddingKeys");
        this.trustedBiddingUri = trustedBiddingUri;
        this.trustedBiddingKeys = trustedBiddingKeys;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrustedBiddingData)) {
            return false;
        }
        TrustedBiddingData trustedBiddingData = (TrustedBiddingData) other;
        if (Intrinsics.areEqual(this.trustedBiddingUri, trustedBiddingData.trustedBiddingUri) && Intrinsics.areEqual(this.trustedBiddingKeys, trustedBiddingData.trustedBiddingKeys)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> getTrustedBiddingKeys() {
        return this.trustedBiddingKeys;
    }

    @NotNull
    public final Uri getTrustedBiddingUri() {
        return this.trustedBiddingUri;
    }

    public int hashCode() {
        return this.trustedBiddingKeys.hashCode() + (this.trustedBiddingUri.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "TrustedBiddingData: trustedBiddingUri=" + this.trustedBiddingUri + " trustedBiddingKeys=" + this.trustedBiddingKeys;
    }
}
