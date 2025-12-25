package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

/* loaded from: classes.dex */
public final class SingleSampleMediaSource extends BaseMediaSource {

    /* renamed from: h */
    public final DataSpec f11073h;

    /* renamed from: i */
    public final DataSource.Factory f11074i;

    /* renamed from: j */
    public final Format f11075j;

    /* renamed from: k */
    public final long f11076k;

    /* renamed from: l */
    public final LoadErrorHandlingPolicy f11077l;

    /* renamed from: m */
    public final boolean f11078m;

    /* renamed from: n */
    public final SinglePeriodTimeline f11079n;

    /* renamed from: o */
    public final MediaItem f11080o;

    /* renamed from: p */
    public TransferListener f11081p;

    /* loaded from: classes.dex */
    public static final class Factory {

        /* renamed from: a */
        public final DataSource.Factory f11082a;

        /* renamed from: b */
        public LoadErrorHandlingPolicy f11083b = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: c */
        public boolean f11084c = true;

        /* renamed from: d */
        public Object f11085d;

        /* renamed from: e */
        public String f11086e;

        public Factory(DataSource.Factory factory) {
            this.f11082a = (DataSource.Factory) Assertions.checkNotNull(factory);
        }

        public SingleSampleMediaSource createMediaSource(MediaItem.SubtitleConfiguration subtitleConfiguration, long j) {
            return new SingleSampleMediaSource(this.f11086e, subtitleConfiguration, this.f11082a, j, this.f11083b, this.f11084c, this.f11085d);
        }

        public Factory setLoadErrorHandlingPolicy(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.f11083b = loadErrorHandlingPolicy;
            return this;
        }

        public Factory setTag(@Nullable Object obj) {
            this.f11085d = obj;
            return this;
        }

        @Deprecated
        public Factory setTrackId(@Nullable String str) {
            this.f11086e = str;
            return this;
        }

        public Factory setTreatLoadErrorsAsEndOfStream(boolean z) {
            this.f11084c = z;
            return this;
        }
    }

    public SingleSampleMediaSource(String str, MediaItem.SubtitleConfiguration subtitleConfiguration, DataSource.Factory factory, long j, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z, Object obj) {
        this.f11074i = factory;
        this.f11076k = j;
        this.f11077l = loadErrorHandlingPolicy;
        this.f11078m = z;
        MediaItem build = new MediaItem.Builder().setUri(Uri.EMPTY).setMediaId(subtitleConfiguration.uri.toString()).setSubtitleConfigurations(ImmutableList.m3903of(subtitleConfiguration)).setTag(obj).build();
        this.f11080o = build;
        Format.Builder label = new Format.Builder().setSampleMimeType((String) MoreObjects.firstNonNull(subtitleConfiguration.mimeType, MimeTypes.TEXT_UNKNOWN)).setLanguage(subtitleConfiguration.language).setSelectionFlags(subtitleConfiguration.selectionFlags).setRoleFlags(subtitleConfiguration.roleFlags).setLabel(subtitleConfiguration.label);
        String str2 = subtitleConfiguration.f9425id;
        this.f11075j = label.setId(str2 == null ? str : str2).build();
        this.f11073h = new DataSpec.Builder().setUri(subtitleConfiguration.uri).setFlags(1).build();
        this.f11079n = new SinglePeriodTimeline(j, true, false, false, (Object) null, build);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        TransferListener transferListener = this.f11081p;
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        return new C0710p(this.f11073h, this.f11074i, transferListener, this.f11075j, this.f11076k, this.f11077l, createEventDispatcher, this.f11078m);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f11080o;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f11081p = transferListener;
        refreshSourceInfo(this.f11079n);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((C0710p) mediaPeriod).f11626i.release();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }
}
