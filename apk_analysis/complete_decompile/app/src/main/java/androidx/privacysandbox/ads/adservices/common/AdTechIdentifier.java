package androidx.privacysandbox.ads.adservices.common;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1861u6;

@Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u0016"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "", "", "identifier", "<init>", "(Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Landroid/adservices/common/AdTechIdentifier;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/common/AdTechIdentifier;", "convertToAdServices", "a", "Ljava/lang/String;", "getIdentifier", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class AdTechIdentifier {

    /* renamed from: a, reason: from kotlin metadata */
    public final String identifier;

    public AdTechIdentifier(@NotNull String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.common.AdTechIdentifier convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdTechIdentifier m7579e = AbstractC1861u6.m7579e(this.identifier);
        Intrinsics.checkNotNullExpressionValue(m7579e, "fromString(identifier)");
        return m7579e;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdTechIdentifier)) {
            return false;
        }
        return Intrinsics.areEqual(this.identifier, ((AdTechIdentifier) other).identifier);
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.identifier);
    }
}
