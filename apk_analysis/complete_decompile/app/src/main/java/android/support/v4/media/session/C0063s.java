package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompat;

/* renamed from: android.support.v4.media.session.s */
/* loaded from: classes.dex */
public final class C0063s implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? obj = new Object();
        obj.f378a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new MediaSessionCompat.ResultReceiverWrapper[i];
    }
}
