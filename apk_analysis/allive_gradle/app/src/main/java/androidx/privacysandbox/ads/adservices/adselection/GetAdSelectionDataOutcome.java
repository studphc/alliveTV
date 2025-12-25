package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFeatures.Ext10OptIn
@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0011\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataOutcome;", "", "", "adSelectionId", "", "adSelectionData", "<init>", "(J[B)V", "Landroid/adservices/adselection/GetAdSelectionDataOutcome;", "response", "(Landroid/adservices/adselection/GetAdSelectionDataOutcome;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "J", "getAdSelectionId", "()J", "b", "[B", "getAdSelectionData", "()[B", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class GetAdSelectionDataOutcome {

    /* renamed from: a, reason: from kotlin metadata */
    public final long adSelectionId;

    /* renamed from: b, reason: from kotlin metadata */
    public final byte[] adSelectionData;

    @JvmOverloads
    public GetAdSelectionDataOutcome(long j) {
        this(j, null, 2, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetAdSelectionDataOutcome)) {
            return false;
        }
        GetAdSelectionDataOutcome getAdSelectionDataOutcome = (GetAdSelectionDataOutcome) other;
        if (this.adSelectionId == getAdSelectionDataOutcome.adSelectionId && Arrays.equals(this.adSelectionData, getAdSelectionDataOutcome.adSelectionData)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final byte[] getAdSelectionData() {
        return this.adSelectionData;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        int i;
        long j = this.adSelectionId;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        byte[] bArr = this.adSelectionData;
        if (bArr != null) {
            i = bArr.hashCode();
        } else {
            i = 0;
        }
        return i2 + i;
    }

    @NotNull
    public String toString() {
        return "GetAdSelectionDataOutcome: adSelectionId=" + this.adSelectionId + ", adSelectionData=" + this.adSelectionData;
    }

    @JvmOverloads
    public GetAdSelectionDataOutcome(long j, @Nullable byte[] bArr) {
        this.adSelectionId = j;
        this.adSelectionData = bArr;
    }

    public /* synthetic */ GetAdSelectionDataOutcome(long j, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : bArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public GetAdSelectionDataOutcome(@NotNull android.adservices.adselection.GetAdSelectionDataOutcome response) {
        this(response.getAdSelectionId(), response.getAdSelectionData());
        Intrinsics.checkNotNullParameter(response, "response");
    }
}
