package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.o */
/* loaded from: classes.dex */
public final class C0040o implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new MediaBrowserCompat.MediaItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new MediaBrowserCompat.MediaItem[i];
    }
}
