package p000;

import android.media.MediaDescription;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.activity.result.ActivityResult;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.util.Assertions;
import com.hisona.allive.CategoryData;
import com.hisona.allive.ChannelData;
import com.hisona.allive.EPGData;

/* renamed from: r5 */
/* loaded from: classes.dex */
public final class C1749r5 implements Parcelable.Creator {

    /* renamed from: a */
    public final /* synthetic */ int f25870a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f25870a) {
            case 0:
                return new ActivityResult(parcel);
            case 1:
                return new ApicFrame(parcel);
            case 2:
                return new AppInfoTable(parcel.readInt(), (String) Assertions.checkNotNull(parcel.readString()));
            case 3:
                return new BinaryFrame(parcel);
            case 4:
                return new CategoryData(parcel);
            case 5:
                return new ChannelData(parcel);
            case 6:
                return new ChapterFrame(parcel);
            case 7:
                return new ChapterTocFrame(parcel);
            case 8:
                return new CommentFrame(parcel);
            case 9:
                return new DownloadRequest(parcel);
            case 10:
                return new DrmInitData(parcel);
            case 11:
                return new EPGData(parcel);
            case 12:
                return new EventMessage(parcel);
            case 13:
                return new GeobFrame(parcel);
            case 14:
                return new HlsTrackMetadataEntry(parcel);
            case 15:
                return new IcyHeaders(parcel);
            case 16:
                return new IcyInfo(parcel);
            case 17:
                return new InternalFrame(parcel);
            case 18:
                return new MdtaMetadataEntry(parcel);
            case 19:
                return MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(parcel));
            case 20:
                return new MediaMetadataCompat(parcel);
            case 21:
                return new Metadata(parcel);
            case 22:
                return new MlltFrame(parcel);
            case 23:
                return new MotionPhotoMetadata(parcel);
            case 24:
                return new ParcelImpl(parcel);
            case 25:
                return new ParcelableVolumeInfo(parcel);
            case 26:
                return new PictureFrame(parcel);
            case 27:
                return new PlaybackStateCompat(parcel);
            case 28:
                return new PrivFrame(parcel);
            default:
                return new PrivateCommand(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f25870a) {
            case 0:
                return new ActivityResult[i];
            case 1:
                return new ApicFrame[i];
            case 2:
                return new AppInfoTable[i];
            case 3:
                return new BinaryFrame[i];
            case 4:
                return new CategoryData[i];
            case 5:
                return new ChannelData[i];
            case 6:
                return new ChapterFrame[i];
            case 7:
                return new ChapterTocFrame[i];
            case 8:
                return new CommentFrame[i];
            case 9:
                return new DownloadRequest[i];
            case 10:
                return new DrmInitData[i];
            case 11:
                return new EPGData[i];
            case 12:
                return new EventMessage[i];
            case 13:
                return new GeobFrame[i];
            case 14:
                return new HlsTrackMetadataEntry[i];
            case 15:
                return new IcyHeaders[i];
            case 16:
                return new IcyInfo[i];
            case 17:
                return new InternalFrame[i];
            case 18:
                return new MdtaMetadataEntry[i];
            case 19:
                return new MediaDescriptionCompat[i];
            case 20:
                return new MediaMetadataCompat[i];
            case 21:
                return new Metadata[i];
            case 22:
                return new MlltFrame[i];
            case 23:
                return new MotionPhotoMetadata[i];
            case 24:
                return new ParcelImpl[i];
            case 25:
                return new ParcelableVolumeInfo[i];
            case 26:
                return new PictureFrame[i];
            case 27:
                return new PlaybackStateCompat[i];
            case 28:
                return new PrivFrame[i];
            default:
                return new PrivateCommand[i];
        }
    }
}
