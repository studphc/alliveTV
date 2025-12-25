package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p000.ai2;

/* loaded from: classes.dex */
public abstract class Representation {
    public static final long REVISION_ID_DEFAULT = -1;

    /* renamed from: a */
    public final RangedUri f11328a;
    public final ImmutableList<BaseUrl> baseUrls;
    public final List<Descriptor> essentialProperties;
    public final Format format;
    public final List<Descriptor> inbandEventStreams;
    public final long presentationTimeOffsetUs;
    public final long revisionId;
    public final List<Descriptor> supplementalProperties;

    /* loaded from: classes.dex */
    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {

        /* renamed from: b */
        public final SegmentBase.MultiSegmentBase f11329b;

        public MultiSegmentRepresentation(long j, Format format, List<BaseUrl> list, SegmentBase.MultiSegmentBase multiSegmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
            super(j, format, list, multiSegmentBase, list2, list3, list4);
            this.f11329b = multiSegmentBase;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getAvailableSegmentCount(long j, long j2) {
            return this.f11329b.getAvailableSegmentCount(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getDurationUs(long j, long j2) {
            return this.f11329b.getSegmentDurationUs(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getFirstAvailableSegmentNum(long j, long j2) {
            return this.f11329b.getFirstAvailableSegmentNum(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getFirstSegmentNum() {
            return this.f11329b.getFirstSegmentNum();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public DashSegmentIndex getIndex() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public RangedUri getIndexUri() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getNextSegmentAvailableTimeUs(long j, long j2) {
            return this.f11329b.getNextSegmentAvailableTimeUs(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getSegmentCount(long j) {
            return this.f11329b.getSegmentCount(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getSegmentNum(long j, long j2) {
            return this.f11329b.getSegmentNum(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public RangedUri getSegmentUrl(long j) {
            return this.f11329b.getSegmentUrl(this, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getTimeUs(long j) {
            return this.f11329b.getSegmentTimeUs(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public boolean isExplicit() {
            return this.f11329b.isExplicit();
        }
    }

    /* loaded from: classes.dex */
    public static class SingleSegmentRepresentation extends Representation {

        /* renamed from: b */
        public final String f11330b;

        /* renamed from: c */
        public final RangedUri f11331c;
        public final long contentLength;

        /* renamed from: d */
        public final ai2 f11332d;
        public final Uri uri;

        public SingleSegmentRepresentation(long j, Format format, List<BaseUrl> list, SegmentBase.SingleSegmentBase singleSegmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, @Nullable String str, long j2) {
            super(j, format, list, singleSegmentBase, list2, list3, list4);
            ai2 ai2Var;
            this.uri = Uri.parse(list.get(0).url);
            RangedUri index = singleSegmentBase.getIndex();
            this.f11331c = index;
            this.f11330b = str;
            this.contentLength = j2;
            if (index != null) {
                ai2Var = null;
            } else {
                ai2Var = new ai2(1, new RangedUri(null, 0L, j2));
            }
            this.f11332d = ai2Var;
        }

        public static SingleSegmentRepresentation newInstance(long j, Format format, String str, long j2, long j3, long j4, long j5, List<Descriptor> list, @Nullable String str2, long j6) {
            return new SingleSegmentRepresentation(j, format, ImmutableList.m3903of(new BaseUrl(str)), new SegmentBase.SingleSegmentBase(new RangedUri(null, j2, (j3 - j2) + 1), 1L, 0L, j4, (j5 - j4) + 1), list, ImmutableList.m3902of(), ImmutableList.m3902of(), str2, j6);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public String getCacheKey() {
            return this.f11330b;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public DashSegmentIndex getIndex() {
            return this.f11332d;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public RangedUri getIndexUri() {
            return this.f11331c;
        }
    }

    public Representation(long j, Format format, List list, SegmentBase segmentBase, List list2, List list3, List list4) {
        List<Descriptor> unmodifiableList;
        Assertions.checkArgument(!list.isEmpty());
        this.revisionId = j;
        this.format = format;
        this.baseUrls = ImmutableList.copyOf((Collection) list);
        if (list2 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list2);
        }
        this.inbandEventStreams = unmodifiableList;
        this.essentialProperties = list3;
        this.supplementalProperties = list4;
        this.f11328a = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = segmentBase.getPresentationTimeOffsetUs();
    }

    public static Representation newInstance(long j, Format format, List<BaseUrl> list, SegmentBase segmentBase) {
        return newInstance(j, format, list, segmentBase, null, ImmutableList.m3902of(), ImmutableList.m3902of(), null);
    }

    @Nullable
    public abstract String getCacheKey();

    @Nullable
    public abstract DashSegmentIndex getIndex();

    @Nullable
    public abstract RangedUri getIndexUri();

    @Nullable
    public RangedUri getInitializationUri() {
        return this.f11328a;
    }

    public static Representation newInstance(long j, Format format, List<BaseUrl> list, SegmentBase segmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, @Nullable String str) {
        if (segmentBase instanceof SegmentBase.SingleSegmentBase) {
            return new SingleSegmentRepresentation(j, format, list, (SegmentBase.SingleSegmentBase) segmentBase, list2, list3, list4, str, -1L);
        }
        if (segmentBase instanceof SegmentBase.MultiSegmentBase) {
            return new MultiSegmentRepresentation(j, format, list, (SegmentBase.MultiSegmentBase) segmentBase, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }
}
