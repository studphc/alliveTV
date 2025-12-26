package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.FrequencyCapFilters;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002#\"BI\b\u0007\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001b¨\u0006$"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters;", "", "", "Landroidx/privacysandbox/ads/adservices/common/KeyedFrequencyCap;", "keyedFrequencyCapsForWinEvents", "keyedFrequencyCapsForImpressionEvents", "keyedFrequencyCapsForViewEvents", "keyedFrequencyCapsForClickEvents", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/adservices/common/FrequencyCapFilters;", "convertToAdServices$ads_adservices_release", "()Landroid/adservices/common/FrequencyCapFilters;", "convertToAdServices", "a", "Ljava/util/List;", "getKeyedFrequencyCapsForWinEvents", "()Ljava/util/List;", "b", "getKeyedFrequencyCapsForImpressionEvents", "c", "getKeyedFrequencyCapsForViewEvents", "d", "getKeyedFrequencyCapsForClickEvents", "Companion", "AdEventType", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes.dex */
public final class FrequencyCapFilters {
    public static final int AD_EVENT_TYPE_CLICK = 3;
    public static final int AD_EVENT_TYPE_IMPRESSION = 1;
    public static final int AD_EVENT_TYPE_VIEW = 2;
    public static final int AD_EVENT_TYPE_WIN = 0;

    /* renamed from: a, reason: from kotlin metadata */
    public final List keyedFrequencyCapsForWinEvents;

    /* renamed from: b, reason: from kotlin metadata */
    public final List keyedFrequencyCapsForImpressionEvents;

    /* renamed from: c, reason: from kotlin metadata */
    public final List keyedFrequencyCapsForViewEvents;

    /* renamed from: d, reason: from kotlin metadata */
    public final List keyedFrequencyCapsForClickEvents;

    @Metadata(m5568d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters$AdEventType;", "", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface AdEventType {
    }

    @JvmOverloads
    public FrequencyCapFilters() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a */
    public static ArrayList m1582a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((KeyedFrequencyCap) it.next()).convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.common.FrequencyCapFilters convertToAdServices$ads_adservices_release() {
        android.adservices.common.FrequencyCapFilters build = new FrequencyCapFilters.Builder().setKeyedFrequencyCapsForWinEvents(m1582a(this.keyedFrequencyCapsForWinEvents)).setKeyedFrequencyCapsForImpressionEvents(m1582a(this.keyedFrequencyCapsForImpressionEvents)).setKeyedFrequencyCapsForViewEvents(m1582a(this.keyedFrequencyCapsForViewEvents)).setKeyedFrequencyCapsForClickEvents(m1582a(this.keyedFrequencyCapsForClickEvents)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…   )\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrequencyCapFilters)) {
            return false;
        }
        FrequencyCapFilters frequencyCapFilters = (FrequencyCapFilters) other;
        if (Intrinsics.areEqual(this.keyedFrequencyCapsForWinEvents, frequencyCapFilters.keyedFrequencyCapsForWinEvents) && Intrinsics.areEqual(this.keyedFrequencyCapsForImpressionEvents, frequencyCapFilters.keyedFrequencyCapsForImpressionEvents) && Intrinsics.areEqual(this.keyedFrequencyCapsForViewEvents, frequencyCapFilters.keyedFrequencyCapsForViewEvents) && Intrinsics.areEqual(this.keyedFrequencyCapsForClickEvents, frequencyCapFilters.keyedFrequencyCapsForClickEvents)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForClickEvents() {
        return this.keyedFrequencyCapsForClickEvents;
    }

    @NotNull
    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForImpressionEvents() {
        return this.keyedFrequencyCapsForImpressionEvents;
    }

    @NotNull
    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForViewEvents() {
        return this.keyedFrequencyCapsForViewEvents;
    }

    @NotNull
    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForWinEvents() {
        return this.keyedFrequencyCapsForWinEvents;
    }

    public int hashCode() {
        return this.keyedFrequencyCapsForClickEvents.hashCode() + ((this.keyedFrequencyCapsForViewEvents.hashCode() + ((this.keyedFrequencyCapsForImpressionEvents.hashCode() + (this.keyedFrequencyCapsForWinEvents.hashCode() * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "FrequencyCapFilters: keyedFrequencyCapsForWinEvents=" + this.keyedFrequencyCapsForWinEvents + ", keyedFrequencyCapsForImpressionEvents=" + this.keyedFrequencyCapsForImpressionEvents + ", keyedFrequencyCapsForViewEvents=" + this.keyedFrequencyCapsForViewEvents + ", keyedFrequencyCapsForClickEvents=" + this.keyedFrequencyCapsForClickEvents;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrequencyCapFilters(@NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForWinEvents) {
        this(keyedFrequencyCapsForWinEvents, null, null, null, 14, null);
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForWinEvents, "keyedFrequencyCapsForWinEvents");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrequencyCapFilters(@NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForWinEvents, @NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForImpressionEvents) {
        this(keyedFrequencyCapsForWinEvents, keyedFrequencyCapsForImpressionEvents, null, null, 12, null);
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForWinEvents, "keyedFrequencyCapsForWinEvents");
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForImpressionEvents, "keyedFrequencyCapsForImpressionEvents");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrequencyCapFilters(@NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForWinEvents, @NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForImpressionEvents, @NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForViewEvents) {
        this(keyedFrequencyCapsForWinEvents, keyedFrequencyCapsForImpressionEvents, keyedFrequencyCapsForViewEvents, null, 8, null);
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForWinEvents, "keyedFrequencyCapsForWinEvents");
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForImpressionEvents, "keyedFrequencyCapsForImpressionEvents");
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForViewEvents, "keyedFrequencyCapsForViewEvents");
    }

    @JvmOverloads
    public FrequencyCapFilters(@NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForWinEvents, @NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForImpressionEvents, @NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForViewEvents, @NotNull List<KeyedFrequencyCap> keyedFrequencyCapsForClickEvents) {
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForWinEvents, "keyedFrequencyCapsForWinEvents");
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForImpressionEvents, "keyedFrequencyCapsForImpressionEvents");
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForViewEvents, "keyedFrequencyCapsForViewEvents");
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForClickEvents, "keyedFrequencyCapsForClickEvents");
        this.keyedFrequencyCapsForWinEvents = keyedFrequencyCapsForWinEvents;
        this.keyedFrequencyCapsForImpressionEvents = keyedFrequencyCapsForImpressionEvents;
        this.keyedFrequencyCapsForViewEvents = keyedFrequencyCapsForViewEvents;
        this.keyedFrequencyCapsForClickEvents = keyedFrequencyCapsForClickEvents;
    }

    public /* synthetic */ FrequencyCapFilters(List list, List list2, List list3, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3, (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list4);
    }
}
