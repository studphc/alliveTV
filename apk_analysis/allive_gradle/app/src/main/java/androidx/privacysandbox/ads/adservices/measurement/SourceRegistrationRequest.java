package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest;", "", "", "Landroid/net/Uri;", "registrationUris", "Landroid/view/InputEvent;", "inputEvent", "<init>", "(Ljava/util/List;Landroid/view/InputEvent;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Ljava/util/List;", "getRegistrationUris", "()Ljava/util/List;", "b", "Landroid/view/InputEvent;", "getInputEvent", "()Landroid/view/InputEvent;", "Builder", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalFeatures.RegisterSourceOptIn
/* loaded from: classes.dex */
public final class SourceRegistrationRequest {

    /* renamed from: a, reason: from kotlin metadata */
    public final List registrationUris;

    /* renamed from: b, reason: from kotlin metadata */
    public final InputEvent inputEvent;

    @Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest$Builder;", "", "", "Landroid/net/Uri;", "registrationUris", "<init>", "(Ljava/util/List;)V", "Landroid/view/InputEvent;", "inputEvent", "setInputEvent", "(Landroid/view/InputEvent;)Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest$Builder;", "Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest;", "build", "()Landroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nSourceRegistrationRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SourceRegistrationRequest.kt\nandroidx/privacysandbox/ads/adservices/measurement/SourceRegistrationRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,77:1\n1#2:78\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final List f6855a;

        /* renamed from: b */
        public InputEvent f6856b;

        public Builder(@NotNull List<? extends Uri> registrationUris) {
            Intrinsics.checkNotNullParameter(registrationUris, "registrationUris");
            this.f6855a = registrationUris;
        }

        @NotNull
        public final SourceRegistrationRequest build() {
            return new SourceRegistrationRequest(this.f6855a, this.f6856b);
        }

        @NotNull
        public final Builder setInputEvent(@NotNull InputEvent inputEvent) {
            Intrinsics.checkNotNullParameter(inputEvent, "inputEvent");
            this.f6856b = inputEvent;
            return this;
        }
    }

    public SourceRegistrationRequest(@NotNull List<? extends Uri> registrationUris, @Nullable InputEvent inputEvent) {
        Intrinsics.checkNotNullParameter(registrationUris, "registrationUris");
        this.registrationUris = registrationUris;
        this.inputEvent = inputEvent;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SourceRegistrationRequest)) {
            return false;
        }
        SourceRegistrationRequest sourceRegistrationRequest = (SourceRegistrationRequest) other;
        if (Intrinsics.areEqual(this.registrationUris, sourceRegistrationRequest.registrationUris) && Intrinsics.areEqual(this.inputEvent, sourceRegistrationRequest.inputEvent)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    @NotNull
    public final List<Uri> getRegistrationUris() {
        return this.registrationUris;
    }

    public int hashCode() {
        int hashCode = this.registrationUris.hashCode();
        InputEvent inputEvent = this.inputEvent;
        if (inputEvent != null) {
            return (hashCode * 31) + inputEvent.hashCode();
        }
        return hashCode;
    }

    @NotNull
    public String toString() {
        return ye0.m8296p("AppSourcesRegistrationRequest { ", "RegistrationUris=[" + this.registrationUris + "], InputEvent=" + this.inputEvent, " }");
    }

    public /* synthetic */ SourceRegistrationRequest(List list, InputEvent inputEvent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : inputEvent);
    }
}
