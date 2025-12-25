package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000.AbstractC1726qj;
import p000.C1138dy;
import p000.da0;
import p000.ye0;

/* renamed from: com.google.android.exoplayer2.source.dash.a */
/* loaded from: classes.dex */
public final class C0694a implements MediaPeriod, SequenceableLoader.Callback, ChunkSampleStream.ReleaseCallback {

    /* renamed from: y */
    public static final Pattern f11290y = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: z */
    public static final Pattern f11291z = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* renamed from: a */
    public final int f11292a;

    /* renamed from: b */
    public final DashChunkSource.Factory f11293b;

    /* renamed from: c */
    public final TransferListener f11294c;

    /* renamed from: d */
    public final DrmSessionManager f11295d;

    /* renamed from: e */
    public final LoadErrorHandlingPolicy f11296e;

    /* renamed from: f */
    public final BaseUrlExclusionList f11297f;

    /* renamed from: g */
    public final long f11298g;

    /* renamed from: h */
    public final LoaderErrorThrower f11299h;

    /* renamed from: i */
    public final Allocator f11300i;

    /* renamed from: j */
    public final TrackGroupArray f11301j;

    /* renamed from: k */
    public final C1138dy[] f11302k;

    /* renamed from: l */
    public final CompositeSequenceableLoaderFactory f11303l;

    /* renamed from: m */
    public final PlayerEmsgHandler f11304m;

    /* renamed from: o */
    public final MediaSourceEventListener.EventDispatcher f11306o;

    /* renamed from: p */
    public final DrmSessionEventListener.EventDispatcher f11307p;

    /* renamed from: q */
    public final PlayerId f11308q;

    /* renamed from: r */
    public MediaPeriod.Callback f11309r;

    /* renamed from: u */
    public SequenceableLoader f11312u;

    /* renamed from: v */
    public DashManifest f11313v;

    /* renamed from: w */
    public int f11314w;

    /* renamed from: x */
    public List f11315x;

    /* renamed from: s */
    public ChunkSampleStream[] f11310s = new ChunkSampleStream[0];

    /* renamed from: t */
    public da0[] f11311t = new da0[0];

    /* renamed from: n */
    public final IdentityHashMap f11305n = new IdentityHashMap();

    public C0694a(int i, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, DashChunkSource.Factory factory, TransferListener transferListener, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, long j, LoaderErrorThrower loaderErrorThrower, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, C0695b c0695b, PlayerId playerId) {
        String m8291k;
        int i3;
        int i4;
        List<AdaptationSet> list;
        int i5;
        boolean[] zArr;
        int i6;
        Format[] formatArr;
        Format[] m2785c;
        Descriptor m2784a;
        DrmSessionManager drmSessionManager2 = drmSessionManager;
        int i7 = 0;
        this.f11292a = i;
        this.f11313v = dashManifest;
        this.f11297f = baseUrlExclusionList;
        this.f11314w = i2;
        this.f11293b = factory;
        this.f11294c = transferListener;
        this.f11295d = drmSessionManager2;
        this.f11307p = eventDispatcher;
        this.f11296e = loadErrorHandlingPolicy;
        this.f11306o = eventDispatcher2;
        this.f11298g = j;
        this.f11299h = loaderErrorThrower;
        this.f11300i = allocator;
        this.f11303l = compositeSequenceableLoaderFactory;
        this.f11308q = playerId;
        this.f11304m = new PlayerEmsgHandler(dashManifest, c0695b, allocator);
        this.f11312u = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.f11310s);
        Period period = dashManifest.getPeriod(i2);
        List<EventStream> list2 = period.eventStreams;
        this.f11315x = list2;
        List<AdaptationSet> list3 = period.adaptationSets;
        int size = list3.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i8 = 0; i8 < size; i8++) {
            sparseIntArray.put(list3.get(i8).f11317id, i8);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i8));
            arrayList.add(arrayList2);
            sparseArray.put(i8, arrayList2);
        }
        int i9 = 0;
        while (i9 < size) {
            AdaptationSet adaptationSet = list3.get(i9);
            Descriptor m2784a2 = m2784a("http://dashif.org/guidelines/trickmode", adaptationSet.essentialProperties);
            m2784a2 = m2784a2 == null ? m2784a("http://dashif.org/guidelines/trickmode", adaptationSet.supplementalProperties) : m2784a2;
            int i10 = (m2784a2 == null || (i10 = sparseIntArray.get(Integer.parseInt(m2784a2.value), -1)) == -1) ? i9 : i10;
            if (i10 == i9 && (m2784a = m2784a("urn:mpeg:dash:adaptation-set-switching:2016", adaptationSet.supplementalProperties)) != null) {
                String[] split = Util.split(m2784a.value, ",");
                int length = split.length;
                for (int i11 = i7; i11 < length; i11++) {
                    int i12 = sparseIntArray.get(Integer.parseInt(split[i11]), -1);
                    if (i12 != -1) {
                        i10 = Math.min(i10, i12);
                    }
                }
            }
            if (i10 != i9) {
                List list4 = (List) sparseArray.get(i9);
                List list5 = (List) sparseArray.get(i10);
                list5.addAll(list4);
                sparseArray.put(i9, list5);
                arrayList.remove(list4);
            }
            i9++;
            i7 = 0;
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2];
        for (int i13 = 0; i13 < size2; i13++) {
            int[] array = Ints.toArray((Collection) arrayList.get(i13));
            iArr[i13] = array;
            Arrays.sort(array);
        }
        boolean[] zArr2 = new boolean[size2];
        Format[][] formatArr2 = new Format[size2];
        int i14 = 0;
        int i15 = 0;
        while (i14 < size2) {
            int[] iArr2 = iArr[i14];
            int length2 = iArr2.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length2) {
                    break;
                }
                List<Representation> list6 = list3.get(iArr2[i16]).representations;
                for (int i17 = 0; i17 < list6.size(); i17++) {
                    if (!list6.get(i17).inbandEventStreams.isEmpty()) {
                        zArr2[i14] = true;
                        i15++;
                        break;
                    }
                }
                i16++;
            }
            int[] iArr3 = iArr[i14];
            int length3 = iArr3.length;
            int i18 = 0;
            while (i18 < length3) {
                int i19 = iArr3[i18];
                AdaptationSet adaptationSet2 = list3.get(i19);
                List<Descriptor> list7 = list3.get(i19).accessibilityDescriptors;
                int[] iArr4 = iArr3;
                int i20 = 0;
                while (i20 < list7.size()) {
                    Descriptor descriptor = list7.get(i20);
                    int i21 = length3;
                    List<Descriptor> list8 = list7;
                    if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri)) {
                        m2785c = m2785c(descriptor, f11290y, new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA608).setId(adaptationSet2.f11317id + ":cea608").build());
                    } else if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri)) {
                        m2785c = m2785c(descriptor, f11291z, new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA708).setId(adaptationSet2.f11317id + ":cea708").build());
                    } else {
                        i20++;
                        length3 = i21;
                        list7 = list8;
                    }
                    formatArr = m2785c;
                    i6 = 1;
                }
                i18++;
                iArr3 = iArr4;
            }
            i6 = 1;
            formatArr = new Format[0];
            formatArr2[i14] = formatArr;
            if (formatArr.length != 0) {
                i15 += i6;
            }
            i14 += i6;
        }
        int size3 = list2.size() + i15 + size2;
        TrackGroup[] trackGroupArr = new TrackGroup[size3];
        C1138dy[] c1138dyArr = new C1138dy[size3];
        int i22 = 0;
        int i23 = 0;
        while (i23 < size2) {
            int[] iArr5 = iArr[i23];
            ArrayList arrayList3 = new ArrayList();
            int length4 = iArr5.length;
            int i24 = size2;
            int i25 = 0;
            while (i25 < length4) {
                arrayList3.addAll(list3.get(iArr5[i25]).representations);
                i25++;
                iArr = iArr;
            }
            int[][] iArr6 = iArr;
            int size4 = arrayList3.size();
            Format[] formatArr3 = new Format[size4];
            int i26 = 0;
            while (i26 < size4) {
                int i27 = size4;
                Format format = ((Representation) arrayList3.get(i26)).format;
                formatArr3[i26] = format.copyWithCryptoType(drmSessionManager2.getCryptoType(format));
                i26++;
                size4 = i27;
                arrayList3 = arrayList3;
            }
            AdaptationSet adaptationSet3 = list3.get(iArr5[0]);
            int i28 = adaptationSet3.f11317id;
            if (i28 != -1) {
                m8291k = Integer.toString(i28);
            } else {
                m8291k = ye0.m8291k(i23, "unset:");
            }
            int i29 = i22 + 1;
            if (zArr2[i23]) {
                i3 = i22 + 2;
                i4 = i29;
            } else {
                i3 = i29;
                i4 = -1;
            }
            if (formatArr2[i23].length != 0) {
                i5 = i3;
                i3++;
                list = list3;
            } else {
                list = list3;
                i5 = -1;
            }
            trackGroupArr[i22] = new TrackGroup(m8291k, formatArr3);
            c1138dyArr[i22] = new C1138dy(adaptationSet3.type, 0, iArr5, i22, i4, i5, -1);
            int i30 = i4;
            int i31 = -1;
            if (i30 != -1) {
                String m7057m = AbstractC1726qj.m7057m(m8291k, ":emsg");
                zArr = zArr2;
                trackGroupArr[i30] = new TrackGroup(m7057m, new Format.Builder().setId(m7057m).setSampleMimeType(MimeTypes.APPLICATION_EMSG).build());
                c1138dyArr[i30] = new C1138dy(5, 1, iArr5, i22, -1, -1, -1);
                i31 = -1;
            } else {
                zArr = zArr2;
            }
            if (i5 != i31) {
                trackGroupArr[i5] = new TrackGroup(AbstractC1726qj.m7057m(m8291k, ":cc"), formatArr2[i23]);
                c1138dyArr[i5] = new C1138dy(3, 1, iArr5, i22, -1, -1, -1);
            }
            i23++;
            size2 = i24;
            iArr = iArr6;
            drmSessionManager2 = drmSessionManager;
            i22 = i3;
            list3 = list;
            zArr2 = zArr;
        }
        int i32 = 0;
        while (i32 < list2.size()) {
            EventStream eventStream = list2.get(i32);
            trackGroupArr[i22] = new TrackGroup(eventStream.m2788id() + ":" + i32, new Format.Builder().setId(eventStream.m2788id()).setSampleMimeType(MimeTypes.APPLICATION_EMSG).build());
            c1138dyArr[i22] = new C1138dy(5, 2, new int[0], -1, -1, -1, i32);
            i32++;
            i22++;
        }
        Pair create = Pair.create(new TrackGroupArray(trackGroupArr), c1138dyArr);
        this.f11301j = (TrackGroupArray) create.first;
        this.f11302k = (C1138dy[]) create.second;
    }

    /* renamed from: a */
    public static Descriptor m2784a(String str, List list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = (Descriptor) list.get(i);
            if (str.equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static Format[] m2785c(Descriptor descriptor, Pattern pattern, Format format) {
        String str = descriptor.value;
        if (str == null) {
            return new Format[]{format};
        }
        String[] split = Util.split(str, ";");
        Format[] formatArr = new Format[split.length];
        for (int i = 0; i < split.length; i++) {
            Matcher matcher = pattern.matcher(split[i]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            formatArr[i] = format.buildUpon().setId(format.f9354id + ":" + parseInt).setAccessibilityChannel(parseInt).setLanguage(matcher.group(2)).build();
        }
        return formatArr;
    }

    /* renamed from: b */
    public final int m2786b(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        C1138dy[] c1138dyArr = this.f11302k;
        int i3 = c1138dyArr[i2].f16606e;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && c1138dyArr[i5].f16604c == 0) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j) {
        return this.f11312u.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void discardBuffer(long j, boolean z) {
        for (ChunkSampleStream chunkSampleStream : this.f11310s) {
            chunkSampleStream.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        for (ChunkSampleStream chunkSampleStream : this.f11310s) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j, seekParameters);
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        return this.f11312u.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        return this.f11312u.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final List getStreamKeys(List list) {
        List<AdaptationSet> list2 = this.f11313v.getPeriod(this.f11314w).adaptationSets;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ExoTrackSelection exoTrackSelection = (ExoTrackSelection) it.next();
            C1138dy c1138dy = this.f11302k[this.f11301j.indexOf(exoTrackSelection.getTrackGroup())];
            if (c1138dy.f16604c == 0) {
                int length = exoTrackSelection.length();
                int[] iArr = new int[length];
                for (int i = 0; i < exoTrackSelection.length(); i++) {
                    iArr[i] = exoTrackSelection.getIndexInTrackGroup(i);
                }
                Arrays.sort(iArr);
                int[] iArr2 = c1138dy.f16602a;
                int size = list2.get(iArr2[0]).representations.size();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr[i4];
                    while (true) {
                        int i6 = i3 + size;
                        if (i5 >= i6) {
                            i2++;
                            size = list2.get(iArr2[i2]).representations.size();
                            i3 = i6;
                        }
                    }
                    arrayList.add(new StreamKey(this.f11314w, iArr2[i2], i5 - i3));
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return this.f11301j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final boolean isLoading() {
        return this.f11312u.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void maybeThrowPrepareError() {
        this.f11299h.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public final void onContinueLoadingRequested(SequenceableLoader sequenceableLoader) {
        this.f11309r.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback
    public final synchronized void onSampleStreamReleased(ChunkSampleStream chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = (PlayerEmsgHandler.PlayerTrackEmsgHandler) this.f11305n.remove(chunkSampleStream);
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        this.f11309r = callback;
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long readDiscontinuity() {
        return C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        this.f11312u.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long seekToUs(long j) {
        long j2;
        for (ChunkSampleStream chunkSampleStream : this.f11310s) {
            chunkSampleStream.seekToUs(j);
        }
        for (da0 da0Var : this.f11311t) {
            int binarySearchCeil = Util.binarySearchCeil(da0Var.f16306c, j, true, false);
            da0Var.f16310g = binarySearchCeil;
            if (da0Var.f16307d && binarySearchCeil == da0Var.f16306c.length) {
                j2 = j;
            } else {
                j2 = C0643C.TIME_UNSET;
            }
            da0Var.f16311h = j2;
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int i;
        boolean z;
        int[] iArr;
        int i2;
        int i3;
        int[] iArr2;
        SampleStream[] sampleStreamArr2;
        boolean z2;
        int i4;
        TrackGroup trackGroup;
        int i5;
        TrackGroup trackGroup2;
        int i6;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
        boolean z3;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr3 = sampleStreamArr;
        int[] iArr3 = new int[exoTrackSelectionArr2.length];
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i = -1;
            if (i8 >= exoTrackSelectionArr2.length) {
                break;
            }
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i8];
            if (exoTrackSelection != null) {
                iArr3[i8] = this.f11301j.indexOf(exoTrackSelection.getTrackGroup());
            } else {
                iArr3[i8] = -1;
            }
            i8++;
        }
        for (int i9 = 0; i9 < exoTrackSelectionArr2.length; i9++) {
            if (exoTrackSelectionArr2[i9] == null || !zArr[i9]) {
                SampleStream sampleStream = sampleStreamArr3[i9];
                if (sampleStream instanceof ChunkSampleStream) {
                    ((ChunkSampleStream) sampleStream).release(this);
                } else if (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) sampleStream).release();
                }
                sampleStreamArr3[i9] = null;
            }
        }
        int i10 = 0;
        while (true) {
            z = true;
            boolean z4 = true;
            if (i10 >= exoTrackSelectionArr2.length) {
                break;
            }
            SampleStream sampleStream2 = sampleStreamArr3[i10];
            if ((sampleStream2 instanceof EmptySampleStream) || (sampleStream2 instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int m2786b = m2786b(i10, iArr3);
                if (m2786b == -1) {
                    z3 = sampleStreamArr3[i10] instanceof EmptySampleStream;
                } else {
                    SampleStream sampleStream3 = sampleStreamArr3[i10];
                    if (!(sampleStream3 instanceof ChunkSampleStream.EmbeddedSampleStream) || ((ChunkSampleStream.EmbeddedSampleStream) sampleStream3).parent != sampleStreamArr3[m2786b]) {
                        z4 = false;
                    }
                    z3 = z4;
                }
                if (!z3) {
                    SampleStream sampleStream4 = sampleStreamArr3[i10];
                    if (sampleStream4 instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        ((ChunkSampleStream.EmbeddedSampleStream) sampleStream4).release();
                    }
                    sampleStreamArr3[i10] = null;
                }
            }
            i10++;
        }
        int i11 = 0;
        while (i11 < exoTrackSelectionArr2.length) {
            ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr2[i11];
            if (exoTrackSelection2 == null) {
                i2 = i11;
                i3 = i7;
                iArr2 = iArr3;
                sampleStreamArr2 = sampleStreamArr3;
            } else {
                SampleStream sampleStream5 = sampleStreamArr3[i11];
                if (sampleStream5 == null) {
                    zArr2[i11] = z;
                    C1138dy c1138dy = this.f11302k[iArr3[i11]];
                    int i12 = c1138dy.f16604c;
                    if (i12 == 0) {
                        int i13 = c1138dy.f16607f;
                        if (i13 != i) {
                            z2 = z ? 1 : 0;
                        } else {
                            z2 = i7;
                        }
                        if (z2 != 0) {
                            trackGroup = this.f11301j.get(i13);
                            i4 = z ? 1 : 0;
                        } else {
                            i4 = i7;
                            trackGroup = null;
                        }
                        int i14 = c1138dy.f16608g;
                        if (i14 != i) {
                            i5 = z ? 1 : 0;
                        } else {
                            i5 = i7;
                        }
                        if (i5 != 0) {
                            trackGroup2 = this.f11301j.get(i14);
                            i4 += trackGroup2.length;
                        } else {
                            trackGroup2 = null;
                        }
                        Format[] formatArr = new Format[i4];
                        int[] iArr4 = new int[i4];
                        if (z2 != 0) {
                            formatArr[i7] = trackGroup.getFormat(i7);
                            iArr4[i7] = 5;
                            i6 = z ? 1 : 0;
                        } else {
                            i6 = i7;
                        }
                        ArrayList arrayList = new ArrayList();
                        if (i5 != 0) {
                            for (int i15 = 0; i15 < trackGroup2.length; i15++) {
                                Format format = trackGroup2.getFormat(i15);
                                formatArr[i6] = format;
                                iArr4[i6] = 3;
                                arrayList.add(format);
                                i6++;
                            }
                        }
                        if (this.f11313v.dynamic && z2 != 0) {
                            playerTrackEmsgHandler = this.f11304m.newPlayerTrackEmsgHandler();
                        } else {
                            playerTrackEmsgHandler = null;
                        }
                        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
                        i2 = i11;
                        iArr2 = iArr3;
                        ChunkSampleStream chunkSampleStream = new ChunkSampleStream(c1138dy.f16603b, iArr4, formatArr, this.f11293b.createDashChunkSource(this.f11299h, this.f11313v, this.f11297f, this.f11314w, c1138dy.f16602a, exoTrackSelection2, c1138dy.f16603b, this.f11298g, z2, arrayList, playerTrackEmsgHandler, this.f11294c, this.f11308q), this, this.f11300i, j, this.f11295d, this.f11307p, this.f11296e, this.f11306o);
                        synchronized (this) {
                            this.f11305n.put(chunkSampleStream, playerTrackEmsgHandler2);
                        }
                        sampleStreamArr2 = sampleStreamArr;
                        sampleStreamArr2[i2] = chunkSampleStream;
                    } else {
                        i2 = i11;
                        iArr2 = iArr3;
                        sampleStreamArr2 = sampleStreamArr3;
                        if (i12 == 2) {
                            i3 = 0;
                            sampleStreamArr2[i2] = new da0((EventStream) this.f11315x.get(c1138dy.f16605d), exoTrackSelection2.getTrackGroup().getFormat(0), this.f11313v.dynamic);
                        }
                    }
                    i3 = 0;
                } else {
                    i2 = i11;
                    i3 = i7;
                    iArr2 = iArr3;
                    sampleStreamArr2 = sampleStreamArr3;
                    if (sampleStream5 instanceof ChunkSampleStream) {
                        ((DashChunkSource) ((ChunkSampleStream) sampleStream5).getChunkSource()).updateTrackSelection(exoTrackSelection2);
                    }
                }
            }
            i11 = i2 + 1;
            exoTrackSelectionArr2 = exoTrackSelectionArr;
            sampleStreamArr3 = sampleStreamArr2;
            i7 = i3;
            iArr3 = iArr2;
            i = -1;
            z = true;
        }
        int i16 = i7;
        int[] iArr5 = iArr3;
        SampleStream[] sampleStreamArr4 = sampleStreamArr3;
        while (i7 < exoTrackSelectionArr.length) {
            if (sampleStreamArr4[i7] == null && exoTrackSelectionArr[i7] != null) {
                iArr = iArr5;
                C1138dy c1138dy2 = this.f11302k[iArr[i7]];
                if (c1138dy2.f16604c == 1) {
                    int m2786b2 = m2786b(i7, iArr);
                    if (m2786b2 == -1) {
                        sampleStreamArr4[i7] = new EmptySampleStream();
                    } else {
                        sampleStreamArr4[i7] = ((ChunkSampleStream) sampleStreamArr4[m2786b2]).selectEmbeddedTrack(j, c1138dy2.f16603b);
                    }
                    i7++;
                    iArr5 = iArr;
                }
            } else {
                iArr = iArr5;
            }
            i7++;
            iArr5 = iArr;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int length = sampleStreamArr4.length;
        for (int i17 = i16; i17 < length; i17++) {
            SampleStream sampleStream6 = sampleStreamArr4[i17];
            if (sampleStream6 instanceof ChunkSampleStream) {
                arrayList2.add((ChunkSampleStream) sampleStream6);
            } else if (sampleStream6 instanceof da0) {
                arrayList3.add((da0) sampleStream6);
            }
        }
        ChunkSampleStream[] chunkSampleStreamArr = new ChunkSampleStream[arrayList2.size()];
        this.f11310s = chunkSampleStreamArr;
        arrayList2.toArray(chunkSampleStreamArr);
        da0[] da0VarArr = new da0[arrayList3.size()];
        this.f11311t = da0VarArr;
        arrayList3.toArray(da0VarArr);
        this.f11312u = this.f11303l.createCompositeSequenceableLoader(this.f11310s);
        return j;
    }
}
