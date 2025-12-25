package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.KeyedFrequencyCap;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/common/KeyedFrequencyCap;", "", "", "adCounterKey", "maxCount", "Ljava/time/Duration;", "interval", "<init>", "(IILjava/time/Duration;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/common/KeyedFrequencyCap;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/common/KeyedFrequencyCap;", "convertToAdServices", "a", "I", "getAdCounterKey", "b", "getMaxCount", "c", "Ljava/time/Duration;", "getInterval", "()Ljava/time/Duration;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes.dex */
public final class KeyedFrequencyCap {

    /* renamed from: a, reason: from kotlin metadata */
    public final int adCounterKey;

    /* renamed from: b, reason: from kotlin metadata */
    public final int maxCount;

    /* renamed from: c, reason: from kotlin metadata */
    public final Duration interval;

    public KeyedFrequencyCap(int i, int i2, @NotNull Duration interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        this.adCounterKey = i;
        this.maxCount = i2;
        this.interval = interval;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.common.KeyedFrequencyCap convertToAdServices$ads_adservices_release() {
        android.adservices.common.KeyedFrequencyCap build = new KeyedFrequencyCap.Builder(this.adCounterKey, this.maxCount, this.interval).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(adCounterKey, ma…val)\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyedFrequencyCap)) {
            return false;
        }
        KeyedFrequencyCap keyedFrequencyCap = (KeyedFrequencyCap) other;
        if (this.adCounterKey == keyedFrequencyCap.adCounterKey && this.maxCount == keyedFrequencyCap.maxCount && Intrinsics.areEqual(this.interval, keyedFrequencyCap.interval)) {
            return true;
        }
        return false;
    }

    public final int getAdCounterKey() {
        return this.adCounterKey;
    }

    @NotNull
    public final Duration getInterval() {
        return this.interval;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public int hashCode() {
        int hashCode;
        int i = ((this.adCounterKey * 31) + this.maxCount) * 31;
        hashCode = this.interval.hashCode();
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "KeyedFrequencyCap: adCounterKey=" + this.adCounterKey + ", maxCount=" + this.maxCount + ", interval=" + this.interval;
    }
}
