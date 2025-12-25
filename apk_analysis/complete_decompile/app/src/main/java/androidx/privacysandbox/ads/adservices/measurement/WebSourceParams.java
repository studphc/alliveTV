package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.WebSourceParams;
import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.mk1;

@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams;", "", "Landroid/net/Uri;", "registrationUri", "", "debugKeyAllowed", "<init>", "(Landroid/net/Uri;Z)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Landroid/net/Uri;", "getRegistrationUri", "()Landroid/net/Uri;", "b", "Z", "getDebugKeyAllowed", "()Z", "Companion", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class WebSourceParams {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final Uri registrationUri;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean debugKeyAllowed;

    @Metadata(m5568d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001J#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams$Companion;", "", "", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams;", "request", "Landroid/adservices/measurement/WebSourceParams;", "convertWebSourceParams$ads_adservices_release", "(Ljava/util/List;)Ljava/util/List;", "convertWebSourceParams", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        @NotNull
        public final List<android.adservices.measurement.WebSourceParams> convertWebSourceParams$ads_adservices_release(@NotNull List<WebSourceParams> request) {
            WebSourceParams.Builder debugKeyAllowed;
            android.adservices.measurement.WebSourceParams build;
            Intrinsics.checkNotNullParameter(request, "request");
            ArrayList arrayList = new ArrayList();
            for (WebSourceParams webSourceParams : request) {
                mk1.m6177y();
                debugKeyAllowed = mk1.m6155c(webSourceParams.getRegistrationUri()).setDebugKeyAllowed(webSourceParams.getDebugKeyAllowed());
                build = debugKeyAllowed.build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder(param.registrati…                 .build()");
                arrayList.add(build);
            }
            return arrayList;
        }
    }

    public WebSourceParams(@NotNull Uri registrationUri, boolean z) {
        Intrinsics.checkNotNullParameter(registrationUri, "registrationUri");
        this.registrationUri = registrationUri;
        this.debugKeyAllowed = z;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSourceParams)) {
            return false;
        }
        WebSourceParams webSourceParams = (WebSourceParams) other;
        if (Intrinsics.areEqual(this.registrationUri, webSourceParams.registrationUri) && this.debugKeyAllowed == webSourceParams.debugKeyAllowed) {
            return true;
        }
        return false;
    }

    public final boolean getDebugKeyAllowed() {
        return this.debugKeyAllowed;
    }

    @NotNull
    public final Uri getRegistrationUri() {
        return this.registrationUri;
    }

    public int hashCode() {
        int i;
        int hashCode = this.registrationUri.hashCode() * 31;
        if (this.debugKeyAllowed) {
            i = 1231;
        } else {
            i = 1237;
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "WebSourceParams { RegistrationUri=" + this.registrationUri + ", DebugKeyAllowed=" + this.debugKeyAllowed + " }";
    }
}
