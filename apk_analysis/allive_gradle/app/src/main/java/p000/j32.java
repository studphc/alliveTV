package p000;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.ParcelableCompatCreatorCallbacks;

/* loaded from: classes.dex */
public final class j32 implements Parcelable.ClassLoaderCreator {

    /* renamed from: a */
    public final ParcelableCompatCreatorCallbacks f20362a;

    public j32(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        this.f20362a = parcelableCompatCreatorCallbacks;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return this.f20362a.createFromParcel(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return this.f20362a.newArray(i);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f20362a.createFromParcel(parcel, classLoader);
    }
}
