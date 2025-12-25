package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* renamed from: android.support.v4.media.session.q */
/* loaded from: classes.dex */
public final class C0061q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new MediaSessionCompat.QueueItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new MediaSessionCompat.QueueItem[i];
    }
}
