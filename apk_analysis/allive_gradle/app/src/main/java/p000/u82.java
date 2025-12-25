package p000;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.RatingCompat;
import android.support.v4.os.ResultReceiver;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.gms.common.internal.BinderWrapper;

/* loaded from: classes.dex */
public final class u82 implements Parcelable.Creator {

    /* renamed from: a */
    public final /* synthetic */ int f27149a;

    public /* synthetic */ u82(int i) {
        this.f27149a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f27149a) {
            case 0:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 1:
                return new Requirements(parcel.readInt());
            case 2:
                return new ResultReceiver(parcel);
            case 3:
                return new SmtaMetadataEntry(parcel);
            case 4:
                return new SpliceInsertCommand(parcel);
            case 5:
                return new SpliceNullCommand();
            case 6:
                return new SpliceScheduleCommand(parcel);
            case 7:
                return new StreamKey(parcel);
            case 8:
                return new TextInformationFrame(parcel);
            case 9:
                return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
            case 10:
                return new UrlLinkFrame(parcel);
            case 11:
                return new VorbisComment(parcel);
            case 12:
                return new VorbisComment(parcel);
            default:
                return new BinderWrapper(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f27149a) {
            case 0:
                return new RatingCompat[i];
            case 1:
                return new Requirements[i];
            case 2:
                return new ResultReceiver[i];
            case 3:
                return new SmtaMetadataEntry[i];
            case 4:
                return new SpliceInsertCommand[i];
            case 5:
                return new SpliceNullCommand[i];
            case 6:
                return new SpliceScheduleCommand[i];
            case 7:
                return new StreamKey[i];
            case 8:
                return new TextInformationFrame[i];
            case 9:
                return new TimeSignalCommand[i];
            case 10:
                return new UrlLinkFrame[i];
            case 11:
                return new com.google.android.exoplayer2.metadata.vorbis.VorbisComment[i];
            case 12:
                return new VorbisComment[i];
            default:
                return new BinderWrapper[i];
        }
    }
}
