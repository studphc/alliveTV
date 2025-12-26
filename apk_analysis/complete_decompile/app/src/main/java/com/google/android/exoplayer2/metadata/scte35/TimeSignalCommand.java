package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.util.ParsableByteArray;
import p000.u82;

/* loaded from: classes.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new u82(9);
    public final long playbackPositionUs;
    public final long ptsTime;

    public TimeSignalCommand(long j, long j2) {
        this.ptsTime = j;
        this.playbackPositionUs = j2;
    }

    /* renamed from: a */
    public static long m2693a(long j, ParsableByteArray parsableByteArray) {
        long readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((128 & readUnsignedByte) != 0) {
            return 8589934591L & ((((readUnsignedByte & 1) << 32) | parsableByteArray.readUnsignedInt()) + j);
        }
        return C0643C.TIME_UNSET;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.ptsTime);
        parcel.writeLong(this.playbackPositionUs);
    }
}
