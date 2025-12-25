package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1248gx;

@Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\u0006¨\u0006\n"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequestHelper;", "", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "request", "Landroid/adservices/topics/GetTopicsRequest;", "convertRequestWithRecordObservation$ads_adservices_release", "(Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;)Landroid/adservices/topics/GetTopicsRequest;", "convertRequestWithRecordObservation", "convertRequestWithoutRecordObservation$ads_adservices_release", "convertRequestWithoutRecordObservation", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class GetTopicsRequestHelper {

    @NotNull
    public static final GetTopicsRequestHelper INSTANCE = new Object();

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
    @NotNull
    public final android.adservices.topics.GetTopicsRequest convertRequestWithRecordObservation$ads_adservices_release(@NotNull GetTopicsRequest request) {
        GetTopicsRequest.Builder adsSdkName;
        GetTopicsRequest.Builder shouldRecordObservation;
        android.adservices.topics.GetTopicsRequest build;
        Intrinsics.checkNotNullParameter(request, "request");
        adsSdkName = AbstractC1248gx.m5010n().setAdsSdkName(request.getAdsSdkName());
        shouldRecordObservation = adsSdkName.setShouldRecordObservation(request.getShouldRecordObservation());
        build = shouldRecordObservation.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ion)\n            .build()");
        return build;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @NotNull
    public final android.adservices.topics.GetTopicsRequest convertRequestWithoutRecordObservation$ads_adservices_release(@NotNull GetTopicsRequest request) {
        GetTopicsRequest.Builder adsSdkName;
        android.adservices.topics.GetTopicsRequest build;
        Intrinsics.checkNotNullParameter(request, "request");
        adsSdkName = AbstractC1248gx.m5010n().setAdsSdkName(request.getAdsSdkName());
        build = adsSdkName.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ame)\n            .build()");
        return build;
    }
}
