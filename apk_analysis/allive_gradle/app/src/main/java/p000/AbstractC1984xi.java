package p000;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: xi */
/* loaded from: classes.dex */
public abstract class AbstractC1984xi {
    @DoNotInline
    /* renamed from: a */
    public static <T> T m8164a(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        return (T) bundle.getParcelable(str, cls);
    }

    @DoNotInline
    /* renamed from: b */
    public static <T> T[] m8165b(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        return (T[]) bundle.getParcelableArray(str, cls);
    }

    @DoNotInline
    /* renamed from: c */
    public static <T> ArrayList<T> m8166c(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
        return bundle.getParcelableArrayList(str, cls);
    }

    @DoNotInline
    /* renamed from: d */
    public static <T extends Serializable> T m8167d(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        return (T) bundle.getSerializable(str, cls);
    }

    @DoNotInline
    /* renamed from: e */
    public static <T> SparseArray<T> m8168e(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
        return bundle.getSparseParcelableArray(str, cls);
    }
}
