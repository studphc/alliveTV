package androidx.privacysandbox.ads.adservices.signals;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/signals/UpdateSignalsRequest;", "", "Landroid/net/Uri;", "updateUri", "<init>", "(Landroid/net/Uri;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Landroid/net/Uri;", "getUpdateUri", "()Landroid/net/Uri;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalFeatures.Ext12OptIn
/* loaded from: classes.dex */
public final class UpdateSignalsRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final Uri updateUri;

    public UpdateSignalsRequest(@NotNull Uri updateUri) {
        Intrinsics.checkNotNullParameter(updateUri, "updateUri");
        this.updateUri = updateUri;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateSignalsRequest)) {
            return false;
        }
        return Intrinsics.areEqual(this.updateUri, ((UpdateSignalsRequest) other).updateUri);
    }

    @NotNull
    public final Uri getUpdateUri() {
        return this.updateUri;
    }

    public int hashCode() {
        return this.updateUri.hashCode();
    }

    @NotNull
    public String toString() {
        return "UpdateSignalsRequest: updateUri=" + this.updateUri;
    }
}
