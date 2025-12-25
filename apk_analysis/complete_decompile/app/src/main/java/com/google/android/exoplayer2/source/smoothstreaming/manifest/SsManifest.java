package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class SsManifest implements FilterableManifest<SsManifest> {
    public static final int UNSET_LOOKAHEAD = -1;
    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;

    @Nullable
    public final ProtectionElement protectionElement;
    public final StreamElement[] streamElements;

    /* loaded from: classes.dex */
    public static class ProtectionElement {
        public final byte[] data;
        public final TrackEncryptionBox[] trackEncryptionBoxes;
        public final UUID uuid;

        public ProtectionElement(UUID uuid, byte[] bArr, TrackEncryptionBox[] trackEncryptionBoxArr) {
            this.uuid = uuid;
            this.data = bArr;
            this.trackEncryptionBoxes = trackEncryptionBoxArr;
        }
    }

    public SsManifest(int i, int i2, long j, long j2, long j3, int i3, boolean z, @Nullable ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this(i, i2, j2 == 0 ? -9223372036854775807L : Util.scaleLargeTimestamp(j2, 1000000L, j), j3 != 0 ? Util.scaleLargeTimestamp(j3, 1000000L, j) : C0643C.TIME_UNSET, i3, z, protectionElement, streamElementArr);
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public /* bridge */ /* synthetic */ SsManifest copy(List list) {
        return copy((List<StreamKey>) list);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final SsManifest copy(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        StreamElement streamElement = null;
        int i = 0;
        while (i < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i);
            StreamElement streamElement2 = this.streamElements[streamKey.groupIndex];
            if (streamElement2 != streamElement && streamElement != null) {
                arrayList2.add(streamElement.copy((Format[]) arrayList3.toArray(new Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(streamElement2.formats[streamKey.streamIndex]);
            i++;
            streamElement = streamElement2;
        }
        if (streamElement != null) {
            arrayList2.add(streamElement.copy((Format[]) arrayList3.toArray(new Format[0])));
        }
        return new SsManifest(this.majorVersion, this.minorVersion, this.durationUs, this.dvrWindowLengthUs, this.lookAheadCount, this.isLive, this.protectionElement, (StreamElement[]) arrayList2.toArray(new StreamElement[0]));
    }

    /* loaded from: classes.dex */
    public static class StreamElement {

        /* renamed from: a */
        public final String f11682a;

        /* renamed from: b */
        public final String f11683b;

        /* renamed from: c */
        public final List f11684c;
        public final int chunkCount;

        /* renamed from: d */
        public final long[] f11685d;
        public final int displayHeight;
        public final int displayWidth;

        /* renamed from: e */
        public final long f11686e;
        public final Format[] formats;

        @Nullable
        public final String language;
        public final int maxHeight;
        public final int maxWidth;
        public final String name;
        public final String subType;
        public final long timescale;
        public final int type;

        public StreamElement(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, @Nullable String str5, Format[] formatArr, List<Long> list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, formatArr, list, Util.scaleLargeTimestamps(list, 1000000L, j), Util.scaleLargeTimestamp(j2, 1000000L, j));
        }

        public Uri buildRequestUri(int i, int i2) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (this.formats != null) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            List list = this.f11684c;
            if (list != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkState(z2);
            if (i2 < list.size()) {
                z3 = true;
            }
            Assertions.checkState(z3);
            String num = Integer.toString(this.formats[i].bitrate);
            String l = ((Long) list.get(i2)).toString();
            return UriUtil.resolveToUri(this.f11682a, this.f11683b.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
        }

        public StreamElement copy(Format[] formatArr) {
            return new StreamElement(this.f11682a, this.f11683b, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.f11684c, this.f11685d, this.f11686e);
        }

        public long getChunkDurationUs(int i) {
            if (i == this.chunkCount - 1) {
                return this.f11686e;
            }
            long[] jArr = this.f11685d;
            return jArr[i + 1] - jArr[i];
        }

        public int getChunkIndex(long j) {
            return Util.binarySearchFloor(this.f11685d, j, true, true);
        }

        public long getStartTimeUs(int i) {
            return this.f11685d[i];
        }

        public StreamElement(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List list, long[] jArr, long j2) {
            this.f11682a = str;
            this.f11683b = str2;
            this.type = i;
            this.subType = str3;
            this.timescale = j;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.displayWidth = i4;
            this.displayHeight = i5;
            this.language = str5;
            this.formats = formatArr;
            this.f11684c = list;
            this.f11685d = jArr;
            this.f11686e = j2;
            this.chunkCount = list.size();
        }
    }

    public SsManifest(int i, int i2, long j, long j2, int i3, boolean z, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this.majorVersion = i;
        this.minorVersion = i2;
        this.durationUs = j;
        this.dvrWindowLengthUs = j2;
        this.lookAheadCount = i3;
        this.isLive = z;
        this.protectionElement = protectionElement;
        this.streamElements = streamElementArr;
    }
}
