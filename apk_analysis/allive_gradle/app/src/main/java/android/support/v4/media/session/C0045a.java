package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.text.TextUtils;
import java.util.List;

/* renamed from: android.support.v4.media.session.a */
/* loaded from: classes.dex */
public final class C0045a implements IMediaControllerCallback {

    /* renamed from: b */
    public static IMediaControllerCallback f415b;

    /* renamed from: a */
    public IBinder f416a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f416a;
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onCaptioningEnabledChanged(boolean z) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            obtain.writeInt(z ? 1 : 0);
            if (!this.f416a.transact(11, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onCaptioningEnabledChanged(z);
            }
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onEvent(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f416a.transact(1, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onEvent(str, bundle);
                obtain.recycle();
            } else {
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onExtrasChanged(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f416a.transact(7, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onExtrasChanged(bundle);
                obtain.recycle();
            } else {
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (mediaMetadataCompat != null) {
                obtain.writeInt(1);
                mediaMetadataCompat.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f416a.transact(4, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onMetadataChanged(mediaMetadataCompat);
                obtain.recycle();
            } else {
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (playbackStateCompat != null) {
                obtain.writeInt(1);
                playbackStateCompat.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f416a.transact(3, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onPlaybackStateChanged(playbackStateCompat);
                obtain.recycle();
            } else {
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onQueueChanged(List list) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            obtain.writeTypedList(list);
            if (!this.f416a.transact(5, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onQueueChanged(list);
            }
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onQueueTitleChanged(CharSequence charSequence) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (charSequence != null) {
                obtain.writeInt(1);
                TextUtils.writeToParcel(charSequence, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f416a.transact(6, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onQueueTitleChanged(charSequence);
                obtain.recycle();
            } else {
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onRepeatModeChanged(int i) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            obtain.writeInt(i);
            if (!this.f416a.transact(9, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onRepeatModeChanged(i);
            }
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onSessionDestroyed() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (!this.f416a.transact(2, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onSessionDestroyed();
            }
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onSessionReady() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (!this.f416a.transact(13, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onSessionReady();
            }
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onShuffleModeChanged(int i) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            obtain.writeInt(i);
            if (!this.f416a.transact(12, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onShuffleModeChanged(i);
            }
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onShuffleModeChangedRemoved(boolean z) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            obtain.writeInt(z ? 1 : 0);
            if (!this.f416a.transact(10, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onShuffleModeChangedRemoved(z);
            }
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaControllerCallback
    public final void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (parcelableVolumeInfo != null) {
                obtain.writeInt(1);
                parcelableVolumeInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f416a.transact(8, obtain, null, 1) && IMediaControllerCallback.Stub.getDefaultImpl() != null) {
                IMediaControllerCallback.Stub.getDefaultImpl().onVolumeInfoChanged(parcelableVolumeInfo);
                obtain.recycle();
            } else {
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }
}
