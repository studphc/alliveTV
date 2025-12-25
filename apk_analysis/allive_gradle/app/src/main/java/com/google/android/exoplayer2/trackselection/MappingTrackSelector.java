package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import p000.qa2;

/* loaded from: classes.dex */
public abstract class MappingTrackSelector extends TrackSelector {

    /* renamed from: c */
    public MappedTrackInfo f11916c;

    @Nullable
    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.f11916c;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(@Nullable Object obj) {
        this.f11916c = (MappedTrackInfo) obj;
    }

    public abstract Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline);

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
        int[] iArr;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        boolean z = true;
        int[] iArr2 = new int[rendererCapabilitiesArr.length + 1];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length];
        int[][][] iArr3 = new int[rendererCapabilitiesArr.length + 1][];
        for (int i = 0; i < length; i++) {
            int i2 = trackGroupArray2.length;
            trackGroupArr[i] = new TrackGroup[i2];
            iArr3[i] = new int[i2];
        }
        int length2 = rendererCapabilitiesArr.length;
        int[] iArr4 = new int[length2];
        for (int i3 = 0; i3 < length2; i3++) {
            iArr4[i3] = rendererCapabilitiesArr[i3].supportsMixedMimeTypeAdaptation();
        }
        int i4 = 0;
        while (i4 < trackGroupArray2.length) {
            TrackGroup trackGroup = trackGroupArray2.get(i4);
            boolean z2 = trackGroup.type == 5 ? z : false;
            int length3 = rendererCapabilitiesArr.length;
            boolean z3 = z;
            int i5 = 0;
            for (int i6 = 0; i6 < rendererCapabilitiesArr.length; i6++) {
                RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i6];
                int i7 = 0;
                for (int i8 = 0; i8 < trackGroup.length; i8++) {
                    i7 = Math.max(i7, qa2.m7016f(rendererCapabilities.supportsFormat(trackGroup.getFormat(i8))));
                }
                boolean z4 = iArr2[i6] == 0;
                if (i7 > i5 || (i7 == i5 && z2 && !z3 && z4)) {
                    z3 = z4;
                    i5 = i7;
                    length3 = i6;
                }
            }
            if (length3 == rendererCapabilitiesArr.length) {
                iArr = new int[trackGroup.length];
            } else {
                RendererCapabilities rendererCapabilities2 = rendererCapabilitiesArr[length3];
                int[] iArr5 = new int[trackGroup.length];
                for (int i9 = 0; i9 < trackGroup.length; i9++) {
                    iArr5[i9] = rendererCapabilities2.supportsFormat(trackGroup.getFormat(i9));
                }
                iArr = iArr5;
            }
            int i10 = iArr2[length3];
            trackGroupArr[length3][i10] = trackGroup;
            iArr3[length3][i10] = iArr;
            iArr2[length3] = i10 + 1;
            i4++;
            z = true;
            trackGroupArray2 = trackGroupArray;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        String[] strArr = new String[rendererCapabilitiesArr.length];
        int[] iArr6 = new int[rendererCapabilitiesArr.length];
        for (int i11 = 0; i11 < rendererCapabilitiesArr.length; i11++) {
            int i12 = iArr2[i11];
            trackGroupArrayArr[i11] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i11], i12));
            iArr3[i11] = (int[][]) Util.nullSafeArrayCopy(iArr3[i11], i12);
            strArr[i11] = rendererCapabilitiesArr[i11].getName();
            iArr6[i11] = rendererCapabilitiesArr[i11].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr6, trackGroupArrayArr, iArr4, iArr3, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr.length], iArr2[rendererCapabilitiesArr.length])));
        Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks = selectTracks(mappedTrackInfo, iArr3, iArr4, mediaPeriodId, timeline);
        return new TrackSelectorResult((RendererConfiguration[]) selectTracks.first, (ExoTrackSelection[]) selectTracks.second, TrackSelectionUtil.buildTracks(mappedTrackInfo, (TrackSelection[]) selectTracks.second), mappedTrackInfo);
    }

    /* loaded from: classes.dex */
    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;

        /* renamed from: a */
        public final int f11917a;

        /* renamed from: b */
        public final String[] f11918b;

        /* renamed from: c */
        public final int[] f11919c;

        /* renamed from: d */
        public final TrackGroupArray[] f11920d;

        /* renamed from: e */
        public final int[] f11921e;

        /* renamed from: f */
        public final int[][][] f11922f;

        /* renamed from: g */
        public final TrackGroupArray f11923g;

        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface RendererSupport {
        }

        public MappedTrackInfo(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f11918b = strArr;
            this.f11919c = iArr;
            this.f11920d = trackGroupArrayArr;
            this.f11922f = iArr3;
            this.f11921e = iArr2;
            this.f11923g = trackGroupArray;
            this.f11917a = iArr.length;
        }

        public int getAdaptiveSupport(int i, int i2, boolean z) {
            int i3 = this.f11920d[i].get(i2).length;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int trackSupport = getTrackSupport(i, i2, i5);
                if (trackSupport == 4 || (z && trackSupport == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return getAdaptiveSupport(i, i2, Arrays.copyOf(iArr, i4));
        }

        public int getCapabilities(int i, int i2, int i3) {
            return this.f11922f[i][i2][i3];
        }

        public int getRendererCount() {
            return this.f11917a;
        }

        public String getRendererName(int i) {
            return this.f11918b[i];
        }

        public int getRendererSupport(int i) {
            int i2 = 0;
            for (int[] iArr : this.f11922f[i]) {
                for (int i3 : iArr) {
                    int m7016f = qa2.m7016f(i3);
                    int i4 = 1;
                    if (m7016f != 0 && m7016f != 1 && m7016f != 2) {
                        if (m7016f != 3) {
                            if (m7016f == 4) {
                                return 3;
                            }
                            throw new IllegalStateException();
                        }
                        i4 = 2;
                    }
                    i2 = Math.max(i2, i4);
                }
            }
            return i2;
        }

        public int getRendererType(int i) {
            return this.f11919c[i];
        }

        public TrackGroupArray getTrackGroups(int i) {
            return this.f11920d[i];
        }

        public int getTrackSupport(int i, int i2, int i3) {
            return qa2.m7016f(getCapabilities(i, i2, i3));
        }

        public int getTypeSupport(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f11917a; i3++) {
                if (this.f11919c[i3] == i) {
                    i2 = Math.max(i2, getRendererSupport(i3));
                }
            }
            return i2;
        }

        public TrackGroupArray getUnmappedTrackGroups() {
            return this.f11923g;
        }

        public int getAdaptiveSupport(int i, int i2, int[] iArr) {
            int i3 = 0;
            int i4 = 16;
            String str = null;
            boolean z = false;
            int i5 = 0;
            while (i3 < iArr.length) {
                String str2 = this.f11920d[i].get(i2).getFormat(iArr[i3]).sampleMimeType;
                int i6 = i5 + 1;
                if (i5 == 0) {
                    str = str2;
                } else {
                    z |= !Util.areEqual(str, str2);
                }
                i4 = Math.min(i4, qa2.m7014d(this.f11922f[i][i2][i3]));
                i3++;
                i5 = i6;
            }
            return z ? Math.min(i4, this.f11921e[i]) : i4;
        }
    }
}
