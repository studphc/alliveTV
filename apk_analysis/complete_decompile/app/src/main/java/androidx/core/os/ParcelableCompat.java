package androidx.core.os;

import android.os.Parcelable;
import p000.j32;

@Deprecated
/* loaded from: classes.dex */
public final class ParcelableCompat {
    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new j32(parcelableCompatCreatorCallbacks);
    }
}
