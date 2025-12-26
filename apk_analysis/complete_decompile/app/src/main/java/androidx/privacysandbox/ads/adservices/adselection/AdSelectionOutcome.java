package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0011\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionOutcome;", "", "", "adSelectionId", "Landroid/net/Uri;", "renderUri", "<init>", "(JLandroid/net/Uri;)V", "Landroid/adservices/adselection/AdSelectionOutcome;", "response", "(Landroid/adservices/adselection/AdSelectionOutcome;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "hasOutcome", "()Z", "a", "J", "getAdSelectionId", "()J", "b", "Landroid/net/Uri;", "getRenderUri", "()Landroid/net/Uri;", "Companion", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class AdSelectionOutcome {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final AdSelectionOutcome NO_OUTCOME;

    /* renamed from: a, reason: from kotlin metadata */
    public final long adSelectionId;

    /* renamed from: b, reason: from kotlin metadata */
    public final Uri renderUri;

    @ExperimentalFeatures.Ext10OptIn
    @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionOutcome$Companion;", "", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionOutcome;", "NO_OUTCOME", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionOutcome;", "getNO_OUTCOME$annotations", "()V", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @ExperimentalFeatures.Ext10OptIn
        public static /* synthetic */ void getNO_OUTCOME$annotations() {
        }
    }

    static {
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        NO_OUTCOME = new AdSelectionOutcome(0L, EMPTY);
    }

    public AdSelectionOutcome(long j, @NotNull Uri renderUri) {
        Intrinsics.checkNotNullParameter(renderUri, "renderUri");
        this.adSelectionId = j;
        this.renderUri = renderUri;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdSelectionOutcome)) {
            return false;
        }
        AdSelectionOutcome adSelectionOutcome = (AdSelectionOutcome) other;
        if (this.adSelectionId == adSelectionOutcome.adSelectionId && Intrinsics.areEqual(this.renderUri, adSelectionOutcome.renderUri)) {
            return true;
        }
        return false;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    @NotNull
    public final Uri getRenderUri() {
        return this.renderUri;
    }

    @ExperimentalFeatures.Ext10OptIn
    public final boolean hasOutcome() {
        return !Intrinsics.areEqual(this, NO_OUTCOME);
    }

    public int hashCode() {
        long j = this.adSelectionId;
        return this.renderUri.hashCode() + (((int) (j ^ (j >>> 32))) * 31);
    }

    @NotNull
    public String toString() {
        return "AdSelectionOutcome: adSelectionId=" + this.adSelectionId + ", renderUri=" + this.renderUri;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdSelectionOutcome(@NotNull android.adservices.adselection.AdSelectionOutcome response) {
        this(r0, r4);
        long adSelectionId;
        Uri renderUri;
        Intrinsics.checkNotNullParameter(response, "response");
        adSelectionId = response.getAdSelectionId();
        renderUri = response.getRenderUri();
        Intrinsics.checkNotNullExpressionValue(renderUri, "response.renderUri");
    }
}
