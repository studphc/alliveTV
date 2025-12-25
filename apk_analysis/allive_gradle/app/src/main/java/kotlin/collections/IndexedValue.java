package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, m5569d2 = {"Lkotlin/collections/IndexedValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "", FirebaseAnalytics.Param.INDEX, "value", "<init>", "(ILjava/lang/Object;)V", "component1", "()I", "component2", "()Ljava/lang/Object;", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getIndex", "b", "Ljava/lang/Object;", "getValue", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class IndexedValue<T> {

    /* renamed from: a, reason: from kotlin metadata */
    public final int index;

    /* renamed from: b, reason: from kotlin metadata */
    public final Object value;

    public IndexedValue(int i, T t) {
        this.index = i;
        this.value = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexedValue copy$default(IndexedValue indexedValue, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = indexedValue.index;
        }
        if ((i2 & 2) != 0) {
            obj = indexedValue.value;
        }
        return indexedValue.copy(i, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public final T component2() {
        return (T) this.value;
    }

    @NotNull
    public final IndexedValue<T> copy(int index, T value) {
        return new IndexedValue<>(index, value);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) other;
        return this.index == indexedValue.index && Intrinsics.areEqual(this.value, indexedValue.value);
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return (T) this.value;
    }

    public int hashCode() {
        int i = this.index * 31;
        Object obj = this.value;
        return i + (obj == null ? 0 : obj.hashCode());
    }

    @NotNull
    public String toString() {
        return "IndexedValue(index=" + this.index + ", value=" + this.value + ')';
    }
}
