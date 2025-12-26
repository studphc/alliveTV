package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.WebSourceRegistrationRequest;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.RequiresExtension;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.mk1;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001.BM\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b)\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010#R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b,\u0010!\u001a\u0004\b-\u0010#¨\u0006/"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "", "", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams;", "webSourceParams", "Landroid/net/Uri;", "topOriginUri", "Landroid/view/InputEvent;", "inputEvent", "appDestination", "webDestination", "verifiedDestination", "<init>", "(Ljava/util/List;Landroid/net/Uri;Landroid/view/InputEvent;Landroid/net/Uri;Landroid/net/Uri;Landroid/net/Uri;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/measurement/WebSourceRegistrationRequest;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/measurement/WebSourceRegistrationRequest;", "convertToAdServices", "a", "Ljava/util/List;", "getWebSourceParams", "()Ljava/util/List;", "b", "Landroid/net/Uri;", "getTopOriginUri", "()Landroid/net/Uri;", "c", "Landroid/view/InputEvent;", "getInputEvent", "()Landroid/view/InputEvent;", "d", "getAppDestination", "e", "getWebDestination", "f", "getVerifiedDestination", "Builder", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class WebSourceRegistrationRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final List webSourceParams;

    /* renamed from: b, reason: from kotlin metadata */
    public final Uri topOriginUri;

    /* renamed from: c, reason: from kotlin metadata */
    public final InputEvent inputEvent;

    /* renamed from: d, reason: from kotlin metadata */
    public final Uri appDestination;

    /* renamed from: e, reason: from kotlin metadata */
    public final Uri webDestination;

    /* renamed from: f, reason: from kotlin metadata */
    public final Uri verifiedDestination;

    @Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u000fJ\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest$Builder;", "", "", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams;", "webSourceParams", "Landroid/net/Uri;", "topOriginUri", "<init>", "(Ljava/util/List;Landroid/net/Uri;)V", "Landroid/view/InputEvent;", "inputEvent", "setInputEvent", "(Landroid/view/InputEvent;)Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest$Builder;", "appDestination", "setAppDestination", "(Landroid/net/Uri;)Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest$Builder;", "webDestination", "setWebDestination", "verifiedDestination", "setVerifiedDestination", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "build", "()Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nWebSourceRegistrationRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSourceRegistrationRequest.kt\nandroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,181:1\n1#2:182\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final List f6865a;

        /* renamed from: b */
        public final Uri f6866b;

        /* renamed from: c */
        public InputEvent f6867c;

        /* renamed from: d */
        public Uri f6868d;

        /* renamed from: e */
        public Uri f6869e;

        /* renamed from: f */
        public Uri f6870f;

        public Builder(@NotNull List<WebSourceParams> webSourceParams, @NotNull Uri topOriginUri) {
            Intrinsics.checkNotNullParameter(webSourceParams, "webSourceParams");
            Intrinsics.checkNotNullParameter(topOriginUri, "topOriginUri");
            this.f6865a = webSourceParams;
            this.f6866b = topOriginUri;
        }

        @NotNull
        public final WebSourceRegistrationRequest build() {
            return new WebSourceRegistrationRequest(this.f6865a, this.f6866b, this.f6867c, this.f6868d, this.f6869e, this.f6870f);
        }

        @NotNull
        public final Builder setAppDestination(@Nullable Uri appDestination) {
            this.f6868d = appDestination;
            return this;
        }

        @NotNull
        public final Builder setInputEvent(@NotNull InputEvent inputEvent) {
            Intrinsics.checkNotNullParameter(inputEvent, "inputEvent");
            this.f6867c = inputEvent;
            return this;
        }

        @NotNull
        public final Builder setVerifiedDestination(@Nullable Uri verifiedDestination) {
            this.f6870f = verifiedDestination;
            return this;
        }

        @NotNull
        public final Builder setWebDestination(@Nullable Uri webDestination) {
            this.f6869e = webDestination;
            return this;
        }
    }

    public WebSourceRegistrationRequest(@NotNull List<WebSourceParams> webSourceParams, @NotNull Uri topOriginUri, @Nullable InputEvent inputEvent, @Nullable Uri uri, @Nullable Uri uri2, @Nullable Uri uri3) {
        Intrinsics.checkNotNullParameter(webSourceParams, "webSourceParams");
        Intrinsics.checkNotNullParameter(topOriginUri, "topOriginUri");
        this.webSourceParams = webSourceParams;
        this.topOriginUri = topOriginUri;
        this.inputEvent = inputEvent;
        this.appDestination = uri;
        this.webDestination = uri2;
        this.verifiedDestination = uri3;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    @NotNull
    public final android.adservices.measurement.WebSourceRegistrationRequest convertToAdServices$ads_adservices_release() {
        WebSourceRegistrationRequest.Builder webDestination;
        WebSourceRegistrationRequest.Builder appDestination;
        WebSourceRegistrationRequest.Builder inputEvent;
        WebSourceRegistrationRequest.Builder verifiedDestination;
        android.adservices.measurement.WebSourceRegistrationRequest build;
        mk1.m6150B();
        webDestination = mk1.m6159g(WebSourceParams.INSTANCE.convertWebSourceParams$ads_adservices_release(this.webSourceParams), this.topOriginUri).setWebDestination(this.webDestination);
        appDestination = webDestination.setAppDestination(this.appDestination);
        inputEvent = appDestination.setInputEvent(this.inputEvent);
        verifiedDestination = inputEvent.setVerifiedDestination(this.verifiedDestination);
        build = verifiedDestination.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(\n               …ion)\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSourceRegistrationRequest)) {
            return false;
        }
        WebSourceRegistrationRequest webSourceRegistrationRequest = (WebSourceRegistrationRequest) other;
        if (Intrinsics.areEqual(this.webSourceParams, webSourceRegistrationRequest.webSourceParams) && Intrinsics.areEqual(this.webDestination, webSourceRegistrationRequest.webDestination) && Intrinsics.areEqual(this.appDestination, webSourceRegistrationRequest.appDestination) && Intrinsics.areEqual(this.topOriginUri, webSourceRegistrationRequest.topOriginUri) && Intrinsics.areEqual(this.inputEvent, webSourceRegistrationRequest.inputEvent) && Intrinsics.areEqual(this.verifiedDestination, webSourceRegistrationRequest.verifiedDestination)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Uri getAppDestination() {
        return this.appDestination;
    }

    @Nullable
    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    @NotNull
    public final Uri getTopOriginUri() {
        return this.topOriginUri;
    }

    @Nullable
    public final Uri getVerifiedDestination() {
        return this.verifiedDestination;
    }

    @Nullable
    public final Uri getWebDestination() {
        return this.webDestination;
    }

    @NotNull
    public final List<WebSourceParams> getWebSourceParams() {
        return this.webSourceParams;
    }

    public int hashCode() {
        int hashCode = this.webSourceParams.hashCode() * 31;
        Uri uri = this.topOriginUri;
        int hashCode2 = uri.hashCode() + hashCode;
        InputEvent inputEvent = this.inputEvent;
        if (inputEvent != null) {
            hashCode2 = (hashCode2 * 31) + inputEvent.hashCode();
        }
        Uri uri2 = this.appDestination;
        if (uri2 != null) {
            hashCode2 = (hashCode2 * 31) + uri2.hashCode();
        }
        Uri uri3 = this.webDestination;
        if (uri3 != null) {
            hashCode2 = (hashCode2 * 31) + uri3.hashCode();
        }
        int hashCode3 = uri.hashCode() + (hashCode2 * 31);
        if (inputEvent != null) {
            hashCode3 = (hashCode3 * 31) + inputEvent.hashCode();
        }
        Uri uri4 = this.verifiedDestination;
        if (uri4 != null) {
            return (hashCode3 * 31) + uri4.hashCode();
        }
        return hashCode3;
    }

    @NotNull
    public String toString() {
        return ye0.m8296p("WebSourceRegistrationRequest { ", "WebSourceParams=[" + this.webSourceParams + "], TopOriginUri=" + this.topOriginUri + ", InputEvent=" + this.inputEvent + ", AppDestination=" + this.appDestination + ", WebDestination=" + this.webDestination + ", VerifiedDestination=" + this.verifiedDestination, " }");
    }

    public /* synthetic */ WebSourceRegistrationRequest(List list, Uri uri, InputEvent inputEvent, Uri uri2, Uri uri3, Uri uri4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, uri, (i & 4) != 0 ? null : inputEvent, (i & 8) != 0 ? null : uri2, (i & 16) != 0 ? null : uri3, (i & 32) != 0 ? null : uri4);
    }
}
