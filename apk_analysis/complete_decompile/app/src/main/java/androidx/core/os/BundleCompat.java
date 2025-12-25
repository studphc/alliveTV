package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import p000.AbstractC1984xi;

/* loaded from: classes.dex */
public final class BundleCompat {
    @Nullable
    @Deprecated
    public static IBinder getBinder(@NonNull Bundle bundle, @Nullable String str) {
        return bundle.getBinder(str);
    }

    @Nullable
    public static <T> T getParcelable(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (T) AbstractC1984xi.m8164a(bundle, str, cls);
        }
        T t = (T) bundle.getParcelable(str);
        if (!cls.isInstance(t)) {
            return null;
        }
        return t;
    }

    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static Parcelable[] getParcelableArray(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends Parcelable> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[]) AbstractC1984xi.m8165b(bundle, str, cls);
        }
        return bundle.getParcelableArray(str);
    }

    @Nullable
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> getParcelableArrayList(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return AbstractC1984xi.m8166c(bundle, str, cls);
        }
        return bundle.getParcelableArrayList(str);
    }

    @Nullable
    public static <T extends Serializable> T getSerializable(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (T) AbstractC1984xi.m8167d(bundle, str, cls);
        }
        T t = (T) bundle.getSerializable(str);
        if (!cls.isInstance(t)) {
            return null;
        }
        return t;
    }

    @Nullable
    public static <T> SparseArray<T> getSparseParcelableArray(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return AbstractC1984xi.m8168e(bundle, str, cls);
        }
        return bundle.getSparseParcelableArray(str);
    }

    @Deprecated
    public static void putBinder(@NonNull Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
