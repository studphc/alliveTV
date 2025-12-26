package androidx.privacysandbox.ads.adservices.topics;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0016B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0005\u0010\u0015¨\u0006\u0017"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "", "", "adsSdkName", "", "shouldRecordObservation", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "a", "Ljava/lang/String;", "getAdsSdkName", "b", "Z", "()Z", "Builder", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class GetTopicsRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final String adsSdkName;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean shouldRecordObservation;

    @Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest$Builder;", "", "<init>", "()V", "", "adsSdkName", "setAdsSdkName", "(Ljava/lang/String;)Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest$Builder;", "", "shouldRecordObservation", "setShouldRecordObservation", "(Z)Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest$Builder;", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "build", "()Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nGetTopicsRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetTopicsRequest.kt\nandroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public String f6883a = "";

        /* renamed from: b */
        public boolean f6884b = true;

        @NotNull
        public final GetTopicsRequest build() {
            return new GetTopicsRequest(this.f6883a, this.f6884b);
        }

        @NotNull
        public final Builder setAdsSdkName(@NotNull String adsSdkName) {
            Intrinsics.checkNotNullParameter(adsSdkName, "adsSdkName");
            if (adsSdkName.length() > 0) {
                this.f6883a = adsSdkName;
                return this;
            }
            throw new IllegalStateException("adsSdkName must be set");
        }

        @NotNull
        public final Builder setShouldRecordObservation(boolean shouldRecordObservation) {
            this.f6884b = shouldRecordObservation;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetTopicsRequest() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetTopicsRequest)) {
            return false;
        }
        GetTopicsRequest getTopicsRequest = (GetTopicsRequest) other;
        if (Intrinsics.areEqual(this.adsSdkName, getTopicsRequest.adsSdkName) && this.shouldRecordObservation == getTopicsRequest.shouldRecordObservation) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAdsSdkName() {
        return this.adsSdkName;
    }

    public int hashCode() {
        int i;
        int hashCode = this.adsSdkName.hashCode() * 31;
        if (this.shouldRecordObservation) {
            i = 1231;
        } else {
            i = 1237;
        }
        return hashCode + i;
    }

    @JvmName(name = "shouldRecordObservation")
    /* renamed from: shouldRecordObservation, reason: from getter */
    public final boolean getShouldRecordObservation() {
        return this.shouldRecordObservation;
    }

    @NotNull
    public String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.adsSdkName + ", shouldRecordObservation=" + this.shouldRecordObservation;
    }

    public GetTopicsRequest(@NotNull String adsSdkName, boolean z) {
        Intrinsics.checkNotNullParameter(adsSdkName, "adsSdkName");
        this.adsSdkName = adsSdkName;
        this.shouldRecordObservation = z;
    }

    public /* synthetic */ GetTopicsRequest(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
    }
}
