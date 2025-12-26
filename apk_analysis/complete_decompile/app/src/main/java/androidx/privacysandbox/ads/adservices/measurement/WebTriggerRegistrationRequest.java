package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.mk1;

@Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;", "", "", "Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerParams;", "webTriggerParams", "Landroid/net/Uri;", FirebaseAnalytics.Param.DESTINATION, "<init>", "(Ljava/util/List;Landroid/net/Uri;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/measurement/WebTriggerRegistrationRequest;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/measurement/WebTriggerRegistrationRequest;", "convertToAdServices", "a", "Ljava/util/List;", "getWebTriggerParams", "()Ljava/util/List;", "b", "Landroid/net/Uri;", "getDestination", "()Landroid/net/Uri;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class WebTriggerRegistrationRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final List webTriggerParams;

    /* renamed from: b, reason: from kotlin metadata */
    public final Uri destination;

    public WebTriggerRegistrationRequest(@NotNull List<WebTriggerParams> webTriggerParams, @NotNull Uri destination) {
        Intrinsics.checkNotNullParameter(webTriggerParams, "webTriggerParams");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.webTriggerParams = webTriggerParams;
        this.destination = destination;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    @NotNull
    public final android.adservices.measurement.WebTriggerRegistrationRequest convertToAdServices$ads_adservices_release() {
        android.adservices.measurement.WebTriggerRegistrationRequest build;
        mk1.m6152D();
        build = mk1.m6164l(WebTriggerParams.INSTANCE.convertWebTriggerParams$ads_adservices_release(this.webTriggerParams), this.destination).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(\n               …   )\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebTriggerRegistrationRequest)) {
            return false;
        }
        WebTriggerRegistrationRequest webTriggerRegistrationRequest = (WebTriggerRegistrationRequest) other;
        if (Intrinsics.areEqual(this.webTriggerParams, webTriggerRegistrationRequest.webTriggerParams) && Intrinsics.areEqual(this.destination, webTriggerRegistrationRequest.destination)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Uri getDestination() {
        return this.destination;
    }

    @NotNull
    public final List<WebTriggerParams> getWebTriggerParams() {
        return this.webTriggerParams;
    }

    public int hashCode() {
        return this.destination.hashCode() + (this.webTriggerParams.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "WebTriggerRegistrationRequest { WebTriggerParams=" + this.webTriggerParams + ", Destination=" + this.destination;
    }
}
