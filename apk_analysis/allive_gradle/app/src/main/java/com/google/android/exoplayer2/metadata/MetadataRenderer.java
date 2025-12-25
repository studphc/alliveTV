package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import p000.qa2;

/* loaded from: classes.dex */
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {

    /* renamed from: n */
    public final MetadataDecoderFactory f10736n;

    /* renamed from: o */
    public final MetadataOutput f10737o;

    /* renamed from: p */
    public final Handler f10738p;

    /* renamed from: q */
    public final MetadataInputBuffer f10739q;

    /* renamed from: r */
    public MetadataDecoder f10740r;

    /* renamed from: s */
    public boolean f10741s;

    /* renamed from: t */
    public boolean f10742t;

    /* renamed from: u */
    public long f10743u;

    /* renamed from: v */
    public long f10744v;

    /* renamed from: w */
    public Metadata f10745w;

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.DEFAULT);
    }

    /* renamed from: a */
    public final void m2671a(Metadata metadata, ArrayList arrayList) {
        for (int i = 0; i < metadata.length(); i++) {
            Format wrappedMetadataFormat = metadata.get(i).getWrappedMetadataFormat();
            if (wrappedMetadataFormat != null) {
                MetadataDecoderFactory metadataDecoderFactory = this.f10736n;
                if (metadataDecoderFactory.supportsFormat(wrappedMetadataFormat)) {
                    MetadataDecoder createDecoder = metadataDecoderFactory.createDecoder(wrappedMetadataFormat);
                    byte[] bArr = (byte[]) Assertions.checkNotNull(metadata.get(i).getWrappedMetadataBytes());
                    MetadataInputBuffer metadataInputBuffer = this.f10739q;
                    metadataInputBuffer.clear();
                    metadataInputBuffer.ensureSpaceForWrite(bArr.length);
                    ((ByteBuffer) Util.castNonNull(metadataInputBuffer.data)).put(bArr);
                    metadataInputBuffer.flip();
                    Metadata decode = createDecoder.decode(metadataInputBuffer);
                    if (decode != null) {
                        m2671a(decode, arrayList);
                    }
                }
            }
            arrayList.add(metadata.get(i));
        }
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.f10737o.onMetadata((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.f10742t;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.f10745w = null;
        this.f10744v = C0643C.TIME_UNSET;
        this.f10740r = null;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.f10745w = null;
        this.f10744v = C0643C.TIME_UNSET;
        this.f10741s = false;
        this.f10742t = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.f10740r = this.f10736n.createDecoder(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        boolean z = true;
        while (z) {
            if (!this.f10741s && this.f10745w == null) {
                MetadataInputBuffer metadataInputBuffer = this.f10739q;
                metadataInputBuffer.clear();
                FormatHolder formatHolder = getFormatHolder();
                int readSource = readSource(formatHolder, metadataInputBuffer, 0);
                if (readSource == -4) {
                    if (metadataInputBuffer.isEndOfStream()) {
                        this.f10741s = true;
                    } else {
                        metadataInputBuffer.subsampleOffsetUs = this.f10743u;
                        metadataInputBuffer.flip();
                        Metadata decode = ((MetadataDecoder) Util.castNonNull(this.f10740r)).decode(metadataInputBuffer);
                        if (decode != null) {
                            ArrayList arrayList = new ArrayList(decode.length());
                            m2671a(decode, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.f10745w = new Metadata(arrayList);
                                this.f10744v = metadataInputBuffer.timeUs;
                            }
                        }
                    }
                } else if (readSource == -5) {
                    this.f10743u = ((Format) Assertions.checkNotNull(formatHolder.format)).subsampleOffsetUs;
                }
            }
            Metadata metadata = this.f10745w;
            if (metadata != null && this.f10744v <= j) {
                Handler handler = this.f10738p;
                if (handler != null) {
                    handler.obtainMessage(0, metadata).sendToTarget();
                } else {
                    this.f10737o.onMetadata(metadata);
                }
                this.f10745w = null;
                this.f10744v = C0643C.TIME_UNSET;
                z = true;
            } else {
                z = false;
            }
            if (this.f10741s && this.f10745w == null) {
                this.f10742t = true;
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        int i;
        if (this.f10736n.supportsFormat(format)) {
            if (format.cryptoType == 0) {
                i = 4;
            } else {
                i = 2;
            }
            return qa2.m7011a(i);
        }
        return qa2.m7011a(0);
    }

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        super(5);
        this.f10737o = (MetadataOutput) Assertions.checkNotNull(metadataOutput);
        this.f10738p = looper == null ? null : Util.createHandler(looper, this);
        this.f10736n = (MetadataDecoderFactory) Assertions.checkNotNull(metadataDecoderFactory);
        this.f10739q = new MetadataInputBuffer();
        this.f10744v = C0643C.TIME_UNSET;
    }
}
