package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* renamed from: android.support.v4.media.session.t */
/* loaded from: classes.dex */
public final class C0064t implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new MediaSessionCompat.Token(parcel.readParcelable(null), null, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new MediaSessionCompat.Token[i];
    }
}
