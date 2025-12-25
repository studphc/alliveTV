package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.view.InputEvent;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.fb2;
import p000.gb2;
import p000.ye0;

@Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 +2\u00020\u0001:\u0004+,-.B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0012R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006/"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/ReportEventRequest;", "", "", "adSelectionId", "", "eventKey", "eventData", "", "reportingDestinations", "Landroid/view/InputEvent;", "inputEvent", "<init>", "(JLjava/lang/String;Ljava/lang/String;ILandroid/view/InputEvent;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Landroid/adservices/adselection/ReportEventRequest;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/adselection/ReportEventRequest;", "convertToAdServices", "a", "J", "getAdSelectionId", "()J", "b", "Ljava/lang/String;", "getEventKey", "c", "getEventData", "d", "I", "getReportingDestinations", "e", "Landroid/view/InputEvent;", "getInputEvent", "()Landroid/view/InputEvent;", "getInputEvent$annotations", "()V", "Companion", "fb2", "gb2", "ReportingDestination", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes.dex */
public final class ReportEventRequest {
    public static final int FLAG_REPORTING_DESTINATION_BUYER = 2;
    public static final int FLAG_REPORTING_DESTINATION_SELLER = 1;

    /* renamed from: a, reason: from kotlin metadata */
    public final long adSelectionId;

    /* renamed from: b, reason: from kotlin metadata */
    public final String eventKey;

    /* renamed from: c, reason: from kotlin metadata */
    public final String eventData;

    /* renamed from: d, reason: from kotlin metadata */
    public final int reportingDestinations;

    /* renamed from: e, reason: from kotlin metadata */
    public final InputEvent inputEvent;

    @Metadata(m5568d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/ReportEventRequest$ReportingDestination;", "", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ReportingDestination {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReportEventRequest(long j, @NotNull String eventKey, @NotNull String eventData, int i) {
        this(j, eventKey, eventData, i, null, 16, null);
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
    }

    @ExperimentalFeatures.Ext10OptIn
    public static /* synthetic */ void getInputEvent$annotations() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"NewApi"})
    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.ReportEventRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 10 && adServicesInfo.extServicesVersionS() < 10) {
            return gb2.f17632a.convertReportEventRequest(this);
        }
        return fb2.f17201a.convertReportEventRequest(this);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportEventRequest)) {
            return false;
        }
        ReportEventRequest reportEventRequest = (ReportEventRequest) other;
        if (this.adSelectionId == reportEventRequest.adSelectionId && Intrinsics.areEqual(this.eventKey, reportEventRequest.eventKey) && Intrinsics.areEqual(this.eventData, reportEventRequest.eventData) && this.reportingDestinations == reportEventRequest.reportingDestinations && Intrinsics.areEqual(this.inputEvent, reportEventRequest.inputEvent)) {
            return true;
        }
        return false;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    @NotNull
    public final String getEventData() {
        return this.eventData;
    }

    @NotNull
    public final String getEventKey() {
        return this.eventKey;
    }

    @Nullable
    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final int getReportingDestinations() {
        return this.reportingDestinations;
    }

    public int hashCode() {
        int i;
        long j = this.adSelectionId;
        int m8286f = (ye0.m8286f(ye0.m8286f(((int) (j ^ (j >>> 32))) * 31, 31, this.eventKey), 31, this.eventData) + this.reportingDestinations) * 31;
        InputEvent inputEvent = this.inputEvent;
        if (inputEvent != null) {
            i = inputEvent.hashCode();
        } else {
            i = 0;
        }
        return m8286f + i;
    }

    @NotNull
    public String toString() {
        return "ReportEventRequest: adSelectionId=" + this.adSelectionId + ", eventKey=" + this.eventKey + ", eventData=" + this.eventData + ", reportingDestinations=" + this.reportingDestinations + "inputEvent=" + this.inputEvent;
    }

    @JvmOverloads
    public ReportEventRequest(long j, @NotNull String eventKey, @NotNull String eventData, int i, @Nullable InputEvent inputEvent) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.adSelectionId = j;
        this.eventKey = eventKey;
        this.eventData = eventData;
        this.reportingDestinations = i;
        this.inputEvent = inputEvent;
        if (i <= 0 || i > 3) {
            throw new IllegalArgumentException("Invalid reporting destinations bitfield.");
        }
    }

    public /* synthetic */ ReportEventRequest(long j, String str, String str2, int i, InputEvent inputEvent, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, i, (i2 & 16) != 0 ? null : inputEvent);
    }
}
