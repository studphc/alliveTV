package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

/* renamed from: android.support.v4.media.session.b */
/* loaded from: classes.dex */
public final class C0046b implements IMediaSession {

    /* renamed from: b */
    public static IMediaSession f417b;

    /* renamed from: a */
    public IBinder f418a;

    @Override // android.support.v4.media.session.IMediaSession
    public final void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (mediaDescriptionCompat != null) {
                obtain.writeInt(1);
                mediaDescriptionCompat.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(41, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().addQueueItem(mediaDescriptionCompat);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (mediaDescriptionCompat != null) {
                obtain.writeInt(1);
                mediaDescriptionCompat.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            if (!this.f418a.transact(42, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().addQueueItemAt(mediaDescriptionCompat, i);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void adjustVolume(int i, int i2, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeString(str);
            if (!this.f418a.transact(11, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().adjustVolume(i, i2, str);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f418a;
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void fastForward() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(22, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().fastForward();
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final Bundle getExtras() {
        Bundle bundle;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(31, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getExtras();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
            } else {
                bundle = null;
            }
            return bundle;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final long getFlags() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(9, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getFlags();
            }
            obtain2.readException();
            return obtain2.readLong();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final PendingIntent getLaunchPendingIntent() {
        PendingIntent pendingIntent;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(8, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getLaunchPendingIntent();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(obtain2);
            } else {
                pendingIntent = null;
            }
            return pendingIntent;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final MediaMetadataCompat getMetadata() {
        MediaMetadataCompat mediaMetadataCompat;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(27, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getMetadata();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                mediaMetadataCompat = MediaMetadataCompat.CREATOR.createFromParcel(obtain2);
            } else {
                mediaMetadataCompat = null;
            }
            return mediaMetadataCompat;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final String getPackageName() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(6, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getPackageName();
            }
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final PlaybackStateCompat getPlaybackState() {
        PlaybackStateCompat playbackStateCompat;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(28, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getPlaybackState();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                playbackStateCompat = PlaybackStateCompat.CREATOR.createFromParcel(obtain2);
            } else {
                playbackStateCompat = null;
            }
            return playbackStateCompat;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final List getQueue() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(29, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getQueue();
            }
            obtain2.readException();
            return obtain2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final CharSequence getQueueTitle() {
        CharSequence charSequence;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(30, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getQueueTitle();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain2);
            } else {
                charSequence = null;
            }
            return charSequence;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final int getRatingType() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(32, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getRatingType();
            }
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final int getRepeatMode() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(37, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getRepeatMode();
            }
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final Bundle getSessionInfo() {
        Bundle bundle;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(50, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getSessionInfo();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
            } else {
                bundle = null;
            }
            return bundle;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final int getShuffleMode() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(47, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getShuffleMode();
            }
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final String getTag() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(7, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getTag();
            }
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final ParcelableVolumeInfo getVolumeAttributes() {
        ParcelableVolumeInfo parcelableVolumeInfo;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(10, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().getVolumeAttributes();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                parcelableVolumeInfo = ParcelableVolumeInfo.CREATOR.createFromParcel(obtain2);
            } else {
                parcelableVolumeInfo = null;
            }
            return parcelableVolumeInfo;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final boolean isCaptioningEnabled() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            boolean z = false;
            if (!this.f418a.transact(45, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().isCaptioningEnabled();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final boolean isShuffleModeEnabledRemoved() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            boolean z = false;
            if (!this.f418a.transact(38, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().isShuffleModeEnabledRemoved();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final boolean isTransportControlEnabled() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            boolean z = false;
            if (!this.f418a.transact(5, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                return IMediaSession.Stub.getDefaultImpl().isTransportControlEnabled();
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void next() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(20, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().next();
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void pause() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(18, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().pause();
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void play() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(13, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().play();
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void playFromMediaId(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(14, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().playFromMediaId(str, bundle);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void playFromSearch(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(15, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().playFromSearch(str, bundle);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void playFromUri(Uri uri, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(16, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().playFromUri(uri, bundle);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void prepare() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(33, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().prepare();
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void prepareFromMediaId(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(34, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().prepareFromMediaId(str, bundle);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void prepareFromSearch(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(35, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().prepareFromSearch(str, bundle);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void prepareFromUri(Uri uri, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(36, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().prepareFromUri(uri, bundle);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void previous() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(21, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().previous();
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void rate(RatingCompat ratingCompat) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (ratingCompat != null) {
                obtain.writeInt(1);
                ratingCompat.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(25, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().rate(ratingCompat);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (ratingCompat != null) {
                obtain.writeInt(1);
                ratingCompat.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(51, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().rateWithExtras(ratingCompat, bundle);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        IBinder iBinder;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (iMediaControllerCallback != null) {
                iBinder = iMediaControllerCallback.asBinder();
            } else {
                iBinder = null;
            }
            obtain.writeStrongBinder(iBinder);
            if (!this.f418a.transact(3, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().registerCallbackListener(iMediaControllerCallback);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (mediaDescriptionCompat != null) {
                obtain.writeInt(1);
                mediaDescriptionCompat.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(43, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().removeQueueItem(mediaDescriptionCompat);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void removeQueueItemAt(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeInt(i);
            if (!this.f418a.transact(44, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().removeQueueItemAt(i);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void rewind() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(23, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().rewind();
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void seekTo(long j) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeLong(j);
            if (!this.f418a.transact(24, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().seekTo(j);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void sendCommand(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (resultReceiverWrapper != null) {
                obtain.writeInt(1);
                resultReceiverWrapper.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(1, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().sendCommand(str, bundle, resultReceiverWrapper);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void sendCustomAction(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(26, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().sendCustomAction(str, bundle);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final boolean sendMediaButton(KeyEvent keyEvent) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            boolean z = true;
            if (keyEvent != null) {
                obtain.writeInt(1);
                keyEvent.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f418a.transact(2, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                boolean sendMediaButton = IMediaSession.Stub.getDefaultImpl().sendMediaButton(keyEvent);
                obtain2.recycle();
                obtain.recycle();
                return sendMediaButton;
            }
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setCaptioningEnabled(boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeInt(z ? 1 : 0);
            if (!this.f418a.transact(46, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().setCaptioningEnabled(z);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setPlaybackSpeed(float f) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeFloat(f);
            if (!this.f418a.transact(49, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().setPlaybackSpeed(f);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setRepeatMode(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeInt(i);
            if (!this.f418a.transact(39, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().setRepeatMode(i);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setShuffleMode(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeInt(i);
            if (!this.f418a.transact(48, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().setShuffleMode(i);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setShuffleModeEnabledRemoved(boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeInt(z ? 1 : 0);
            if (!this.f418a.transact(40, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().setShuffleModeEnabledRemoved(z);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void setVolumeTo(int i, int i2, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeString(str);
            if (!this.f418a.transact(12, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().setVolumeTo(i, i2, str);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void skipToQueueItem(long j) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeLong(j);
            if (!this.f418a.transact(17, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().skipToQueueItem(j);
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void stop() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f418a.transact(19, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().stop();
            } else {
                obtain2.readException();
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.v4.media.session.IMediaSession
    public final void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        IBinder iBinder;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (iMediaControllerCallback != null) {
                iBinder = iMediaControllerCallback.asBinder();
            } else {
                iBinder = null;
            }
            obtain.writeStrongBinder(iBinder);
            if (!this.f418a.transact(4, obtain, obtain2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
                IMediaSession.Stub.getDefaultImpl().unregisterCallbackListener(iMediaControllerCallback);
                obtain2.recycle();
                obtain.recycle();
            } else {
                obtain2.readException();
                obtain2.recycle();
                obtain.recycle();
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }
}
