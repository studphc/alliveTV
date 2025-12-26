package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes.dex */
public interface IMediaControllerCallback extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IMediaControllerCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onCaptioningEnabledChanged(boolean z) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onEvent(String str, Bundle bundle) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onExtrasChanged(Bundle bundle) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onRepeatModeChanged(int i) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onSessionDestroyed() {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onSessionReady() {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onShuffleModeChanged(int i) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onShuffleModeChangedRemoved(boolean z) {
        }

        @Override // android.support.v4.media.session.IMediaControllerCallback
        public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMediaControllerCallback {
        public Stub() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.support.v4.media.session.a, android.support.v4.media.session.IMediaControllerCallback, java.lang.Object] */
        public static IMediaControllerCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaControllerCallback)) {
                return (IMediaControllerCallback) queryLocalInterface;
            }
            ?? obj = new Object();
            obj.f416a = iBinder;
            return obj;
        }

        public static IMediaControllerCallback getDefaultImpl() {
            return C0045a.f415b;
        }

        public static boolean setDefaultImpl(IMediaControllerCallback iMediaControllerCallback) {
            if (C0045a.f415b == null) {
                if (iMediaControllerCallback != null) {
                    C0045a.f415b = iMediaControllerCallback;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                boolean z = false;
                Bundle bundle = null;
                ParcelableVolumeInfo parcelableVolumeInfo = null;
                Bundle bundle2 = null;
                CharSequence charSequence = null;
                MediaMetadataCompat mediaMetadataCompat = null;
                PlaybackStateCompat playbackStateCompat = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onEvent(readString, bundle);
                        return true;
                    case 2:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        onSessionDestroyed();
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            playbackStateCompat = PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                        }
                        onPlaybackStateChanged(playbackStateCompat);
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            mediaMetadataCompat = MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                        }
                        onMetadataChanged(mediaMetadataCompat);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        onQueueChanged(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                        }
                        onQueueTitleChanged(charSequence);
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onExtrasChanged(bundle2);
                        return true;
                    case 8:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            parcelableVolumeInfo = ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                        }
                        onVolumeInfoChanged(parcelableVolumeInfo);
                        return true;
                    case 9:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        onRepeatModeChanged(parcel.readInt());
                        return true;
                    case 10:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onShuffleModeChangedRemoved(z);
                        return true;
                    case 11:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onCaptioningEnabledChanged(z);
                        return true;
                    case 12:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        onShuffleModeChanged(parcel.readInt());
                        return true;
                    case 13:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        onSessionReady();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
    }

    void onCaptioningEnabledChanged(boolean z);

    void onEvent(String str, Bundle bundle);

    void onExtrasChanged(Bundle bundle);

    void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat);

    void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat);

    void onQueueChanged(List<MediaSessionCompat.QueueItem> list);

    void onQueueTitleChanged(CharSequence charSequence);

    void onRepeatModeChanged(int i);

    void onSessionDestroyed();

    void onSessionReady();

    void onShuffleModeChanged(int i);

    void onShuffleModeChangedRemoved(boolean z);

    void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo);
}
