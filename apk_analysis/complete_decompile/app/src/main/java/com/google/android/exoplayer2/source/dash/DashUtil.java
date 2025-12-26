package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;

/* loaded from: classes.dex */
public final class DashUtil {
    /* renamed from: a */
    public static Representation m2778a(Period period, int i) {
        int adaptationSetIndex = period.getAdaptationSetIndex(i);
        if (adaptationSetIndex == -1) {
            return null;
        }
        List<Representation> list = period.adaptationSets.get(adaptationSetIndex).representations;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /* renamed from: b */
    public static void m2779b(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, int i, boolean z) {
        RangedUri rangedUri = (RangedUri) Assertions.checkNotNull(representation.getInitializationUri());
        if (z) {
            RangedUri indexUri = representation.getIndexUri();
            if (indexUri == null) {
                return;
            }
            RangedUri attemptMerge = rangedUri.attemptMerge(indexUri, representation.baseUrls.get(i).url);
            if (attemptMerge == null) {
                new InitializationChunk(dataSource, buildDataSpec(representation, representation.baseUrls.get(i).url, rangedUri, 0), representation.format, 0, null, chunkExtractor).load();
                rangedUri = indexUri;
            } else {
                rangedUri = attemptMerge;
            }
        }
        new InitializationChunk(dataSource, buildDataSpec(representation, representation.baseUrls.get(i).url, rangedUri, 0), representation.format, 0, null, chunkExtractor).load();
    }

    public static DataSpec buildDataSpec(Representation representation, String str, RangedUri rangedUri, int i) {
        return new DataSpec.Builder().setUri(rangedUri.resolveUri(str)).setPosition(rangedUri.start).setLength(rangedUri.length).setKey(resolveCacheKey(representation, rangedUri)).setFlags(i).build();
    }

    /* renamed from: c */
    public static BundledChunkExtractor m2780c(int i, Format format) {
        Extractor fragmentedMp4Extractor;
        String str = format.containerMimeType;
        if (str != null && (str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM))) {
            fragmentedMp4Extractor = new MatroskaExtractor();
        } else {
            fragmentedMp4Extractor = new FragmentedMp4Extractor();
        }
        return new BundledChunkExtractor(fragmentedMp4Extractor, i, format);
    }

    @Nullable
    public static ChunkIndex loadChunkIndex(DataSource dataSource, int i, Representation representation, int i2) {
        if (representation.getInitializationUri() == null) {
            return null;
        }
        BundledChunkExtractor m2780c = m2780c(i, representation.format);
        try {
            m2779b(m2780c, dataSource, representation, i2, true);
            m2780c.release();
            return m2780c.getChunkIndex();
        } catch (Throwable th) {
            m2780c.release();
            throw th;
        }
    }

    @Nullable
    public static Format loadFormatWithDrmInitData(DataSource dataSource, Period period) {
        int i = 2;
        Representation m2778a = m2778a(period, 2);
        if (m2778a == null) {
            i = 1;
            m2778a = m2778a(period, 1);
            if (m2778a == null) {
                return null;
            }
        }
        Format format = m2778a.format;
        Format loadSampleFormat = loadSampleFormat(dataSource, i, m2778a);
        if (loadSampleFormat != null) {
            return loadSampleFormat.withManifestFormatInfo(format);
        }
        return format;
    }

    public static void loadInitializationData(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, boolean z) {
        m2779b(chunkExtractor, dataSource, representation, 0, z);
    }

    public static DashManifest loadManifest(DataSource dataSource, Uri uri) {
        return (DashManifest) ParsingLoadable.load(dataSource, new DashManifestParser(), uri, 4);
    }

    @Nullable
    public static Format loadSampleFormat(DataSource dataSource, int i, Representation representation, int i2) {
        if (representation.getInitializationUri() == null) {
            return null;
        }
        BundledChunkExtractor m2780c = m2780c(i, representation.format);
        try {
            m2779b(m2780c, dataSource, representation, i2, false);
            m2780c.release();
            return ((Format[]) Assertions.checkStateNotNull(m2780c.getSampleFormats()))[0];
        } catch (Throwable th) {
            m2780c.release();
            throw th;
        }
    }

    public static String resolveCacheKey(Representation representation, RangedUri rangedUri) {
        String cacheKey = representation.getCacheKey();
        if (cacheKey == null) {
            return rangedUri.resolveUri(representation.baseUrls.get(0).url).toString();
        }
        return cacheKey;
    }

    public static DataSpec buildDataSpec(Representation representation, RangedUri rangedUri, int i) {
        return buildDataSpec(representation, representation.baseUrls.get(0).url, rangedUri, i);
    }

    @Nullable
    public static ChunkIndex loadChunkIndex(DataSource dataSource, int i, Representation representation) {
        return loadChunkIndex(dataSource, i, representation, 0);
    }

    @Nullable
    public static Format loadSampleFormat(DataSource dataSource, int i, Representation representation) {
        return loadSampleFormat(dataSource, i, representation, 0);
    }
}
