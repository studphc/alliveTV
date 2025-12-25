package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import p000.dv2;
import p000.g62;

/* loaded from: classes.dex */
public final class PlayerEmsgHandler implements Handler.Callback {

    /* renamed from: a */
    public final Allocator f11276a;

    /* renamed from: b */
    public final PlayerEmsgCallback f11277b;

    /* renamed from: f */
    public DashManifest f11281f;

    /* renamed from: g */
    public boolean f11282g;

    /* renamed from: h */
    public boolean f11283h;

    /* renamed from: i */
    public boolean f11284i;

    /* renamed from: e */
    public final TreeMap f11280e = new TreeMap();

    /* renamed from: d */
    public final Handler f11279d = Util.createHandlerForCurrentLooper(this);

    /* renamed from: c */
    public final EventMessageDecoder f11278c = new EventMessageDecoder();

    /* loaded from: classes.dex */
    public interface PlayerEmsgCallback {
        void onDashManifestPublishTimeExpired(long j);

        void onDashManifestRefreshRequested();
    }

    /* loaded from: classes.dex */
    public final class PlayerTrackEmsgHandler implements TrackOutput {

        /* renamed from: a */
        public final SampleQueue f11285a;

        /* renamed from: b */
        public final FormatHolder f11286b = new FormatHolder();

        /* renamed from: c */
        public final MetadataInputBuffer f11287c = new MetadataInputBuffer();

        /* renamed from: d */
        public long f11288d = C0643C.TIME_UNSET;

        public PlayerTrackEmsgHandler(Allocator allocator) {
            this.f11285a = SampleQueue.createWithoutDrm(allocator);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format) {
            this.f11285a.format(format);
        }

        public boolean maybeRefreshManifestBeforeLoadingNextChunk(long j) {
            boolean z;
            PlayerEmsgHandler playerEmsgHandler = PlayerEmsgHandler.this;
            DashManifest dashManifest = playerEmsgHandler.f11281f;
            if (!dashManifest.dynamic) {
                return false;
            }
            if (playerEmsgHandler.f11283h) {
                return true;
            }
            Map.Entry ceilingEntry = playerEmsgHandler.f11280e.ceilingEntry(Long.valueOf(dashManifest.publishTimeMs));
            PlayerEmsgCallback playerEmsgCallback = playerEmsgHandler.f11277b;
            if (ceilingEntry != null && ((Long) ceilingEntry.getValue()).longValue() < j) {
                playerEmsgCallback.onDashManifestPublishTimeExpired(((Long) ceilingEntry.getKey()).longValue());
                z = true;
            } else {
                z = false;
            }
            if (z && playerEmsgHandler.f11282g) {
                playerEmsgHandler.f11283h = true;
                playerEmsgHandler.f11282g = false;
                playerEmsgCallback.onDashManifestRefreshRequested();
            }
            return z;
        }

        public void onChunkLoadCompleted(Chunk chunk) {
            long j = this.f11288d;
            if (j == C0643C.TIME_UNSET || chunk.endTimeUs > j) {
                this.f11288d = chunk.endTimeUs;
            }
            PlayerEmsgHandler.this.f11282g = true;
        }

        public boolean onChunkLoadError(Chunk chunk) {
            boolean z;
            long j = this.f11288d;
            if (j != C0643C.TIME_UNSET && j < chunk.startTimeUs) {
                z = true;
            } else {
                z = false;
            }
            PlayerEmsgHandler playerEmsgHandler = PlayerEmsgHandler.this;
            if (!playerEmsgHandler.f11281f.dynamic) {
                return false;
            }
            if (!playerEmsgHandler.f11283h) {
                if (!z) {
                    return false;
                }
                if (playerEmsgHandler.f11282g) {
                    playerEmsgHandler.f11283h = true;
                    playerEmsgHandler.f11282g = false;
                    playerEmsgHandler.f11277b.onDashManifestRefreshRequested();
                }
            }
            return true;
        }

        public void release() {
            this.f11285a.release();
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public final /* synthetic */ int sampleData(DataReader dataReader, int i, boolean z) {
            return dv2.m4620a(this, dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, @Nullable TrackOutput.CryptoData cryptoData) {
            long j2;
            this.f11285a.sampleMetadata(j, i, i2, i3, cryptoData);
            while (true) {
                SampleQueue sampleQueue = this.f11285a;
                if (sampleQueue.isReady(false)) {
                    MetadataInputBuffer metadataInputBuffer = this.f11287c;
                    metadataInputBuffer.clear();
                    if (sampleQueue.read(this.f11286b, metadataInputBuffer, 0, false) == -4) {
                        metadataInputBuffer.flip();
                    } else {
                        metadataInputBuffer = null;
                    }
                    if (metadataInputBuffer != null) {
                        long j3 = metadataInputBuffer.timeUs;
                        PlayerEmsgHandler playerEmsgHandler = PlayerEmsgHandler.this;
                        Metadata decode = playerEmsgHandler.f11278c.decode(metadataInputBuffer);
                        if (decode != null) {
                            EventMessage eventMessage = (EventMessage) decode.get(0);
                            String str = eventMessage.schemeIdUri;
                            String str2 = eventMessage.value;
                            if ("urn:mpeg:dash:event:2012".equals(str) && (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(str2) || ExifInterface.GPS_MEASUREMENT_2D.equals(str2) || ExifInterface.GPS_MEASUREMENT_3D.equals(str2))) {
                                try {
                                    j2 = Util.parseXsDateTime(Util.fromUtf8Bytes(eventMessage.messageData));
                                } catch (ParserException unused) {
                                    j2 = -9223372036854775807L;
                                }
                                if (j2 != C0643C.TIME_UNSET) {
                                    g62 g62Var = new g62(j3, j2);
                                    Handler handler = playerEmsgHandler.f11279d;
                                    handler.sendMessage(handler.obtainMessage(1, g62Var));
                                }
                            }
                        }
                    }
                } else {
                    sampleQueue.discardToRead();
                    return;
                }
            }
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public final /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i) {
            dv2.m4621b(this, parsableByteArray, i);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(DataReader dataReader, int i, boolean z, int i2) {
            SampleQueue sampleQueue = this.f11285a;
            sampleQueue.getClass();
            return dv2.m4620a(sampleQueue, dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
            SampleQueue sampleQueue = this.f11285a;
            sampleQueue.getClass();
            dv2.m4621b(sampleQueue, parsableByteArray, i);
        }
    }

    public PlayerEmsgHandler(DashManifest dashManifest, PlayerEmsgCallback playerEmsgCallback, Allocator allocator) {
        this.f11281f = dashManifest;
        this.f11277b = playerEmsgCallback;
        this.f11276a = allocator;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f11284i) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        g62 g62Var = (g62) message.obj;
        long j = g62Var.f17560a;
        TreeMap treeMap = this.f11280e;
        long j2 = g62Var.f17561b;
        Long l = (Long) treeMap.get(Long.valueOf(j2));
        if (l == null) {
            treeMap.put(Long.valueOf(j2), Long.valueOf(j));
        } else if (l.longValue() > j) {
            treeMap.put(Long.valueOf(j2), Long.valueOf(j));
        }
        return true;
    }

    public PlayerTrackEmsgHandler newPlayerTrackEmsgHandler() {
        return new PlayerTrackEmsgHandler(this.f11276a);
    }

    public void release() {
        this.f11284i = true;
        this.f11279d.removeCallbacksAndMessages(null);
    }

    public void updateManifest(DashManifest dashManifest) {
        this.f11283h = false;
        this.f11281f = dashManifest;
        Iterator it = this.f11280e.entrySet().iterator();
        while (it.hasNext()) {
            if (((Long) ((Map.Entry) it.next()).getKey()).longValue() < this.f11281f.publishTimeMs) {
                it.remove();
            }
        }
    }
}
