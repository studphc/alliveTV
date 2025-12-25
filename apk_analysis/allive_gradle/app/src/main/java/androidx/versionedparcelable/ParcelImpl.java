package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import p000.C1749r5;
import p000.t13;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new C1749r5(24);

    /* renamed from: a */
    public final VersionedParcelable f7568a;

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.f7568a = versionedParcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return (T) this.f7568a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        new t13(parcel).writeVersionedParcelable(this.f7568a);
    }

    public ParcelImpl(Parcel parcel) {
        this.f7568a = new t13(parcel).readVersionedParcelable();
    }
}
