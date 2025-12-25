package p000;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes.dex */
public abstract class g32 {
    @DoNotInline
    /* renamed from: a */
    public static <T extends Parcelable> List<T> m4912a(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader) {
        return parcel.readParcelableList(list, classLoader);
    }
}
