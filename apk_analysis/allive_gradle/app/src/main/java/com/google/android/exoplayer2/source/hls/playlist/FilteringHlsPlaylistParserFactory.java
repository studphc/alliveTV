package com.google.android.exoplayer2.source.hls.playlist;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.util.List;

/* loaded from: classes.dex */
public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory {

    /* renamed from: a */
    public final HlsPlaylistParserFactory f11464a;

    /* renamed from: b */
    public final List f11465b;

    public FilteringHlsPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory, List<StreamKey> list) {
        this.f11464a = hlsPlaylistParserFactory;
        this.f11465b = list;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser() {
        return new FilteringManifestParser(this.f11464a.createPlaylistParser(), this.f11465b);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public ParsingLoadable.Parser<HlsPlaylist> createPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        return new FilteringManifestParser(this.f11464a.createPlaylistParser(hlsMultivariantPlaylist, hlsMediaPlaylist), this.f11465b);
    }
}
