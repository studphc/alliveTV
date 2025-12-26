package p000;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class i32 {
    @DoNotInline
    /* renamed from: a */
    public static <T> T[] m5148a(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        return (T[]) parcel.readArray(classLoader, cls);
    }

    @DoNotInline
    /* renamed from: b */
    public static <T> ArrayList<T> m5149b(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
        return parcel.readArrayList(classLoader, cls);
    }

    @DoNotInline
    /* renamed from: c */
    public static <V, K> HashMap<K, V> m5150c(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
        return parcel.readHashMap(classLoader, cls, cls2);
    }

    @DoNotInline
    /* renamed from: d */
    public static <T> void m5151d(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        parcel.readList(list, classLoader, cls);
    }

    @DoNotInline
    /* renamed from: e */
    public static <K, V> void m5152e(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
        parcel.readMap(map, classLoader, cls, cls2);
    }

    @DoNotInline
    /* renamed from: f */
    public static <T extends Parcelable> T m5153f(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return (T) parcel.readParcelable(classLoader, cls);
    }

    @DoNotInline
    /* renamed from: g */
    public static <T> T[] m5154g(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return (T[]) parcel.readParcelableArray(classLoader, cls);
    }

    @DoNotInline
    /* renamed from: h */
    public static <T> Parcelable.Creator<T> m5155h(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        return parcel.readParcelableCreator(classLoader, cls);
    }

    @DoNotInline
    /* renamed from: i */
    public static <T> List<T> m5156i(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return parcel.readParcelableList(list, classLoader, cls);
    }

    @DoNotInline
    /* renamed from: j */
    public static <T extends Serializable> T m5157j(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        return (T) parcel.readSerializable(classLoader, cls);
    }

    @DoNotInline
    /* renamed from: k */
    public static <T> SparseArray<T> m5158k(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
        return parcel.readSparseArray(classLoader, cls);
    }
}
