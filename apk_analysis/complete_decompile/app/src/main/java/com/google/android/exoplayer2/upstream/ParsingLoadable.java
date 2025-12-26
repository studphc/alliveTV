package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ParsingLoadable<T> implements Loader.Loadable {

    /* renamed from: a */
    public final StatsDataSource f12516a;

    /* renamed from: b */
    public final Parser f12517b;

    /* renamed from: c */
    public volatile Object f12518c;
    public final DataSpec dataSpec;
    public final long loadTaskId;
    public final int type;

    /* loaded from: classes.dex */
    public interface Parser<T> {
        T parse(Uri uri, InputStream inputStream);
    }

    public ParsingLoadable(DataSource dataSource, Uri uri, int i, Parser<? extends T> parser) {
        this(dataSource, new DataSpec.Builder().setUri(uri).setFlags(1).build(), i, parser);
    }

    public static <T> T load(DataSource dataSource, Parser<? extends T> parser, Uri uri, int i) {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, uri, i, parser);
        parsingLoadable.load();
        return (T) Assertions.checkNotNull(parsingLoadable.getResult());
    }

    public long bytesLoaded() {
        return this.f12516a.getBytesRead();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.f12516a.getLastResponseHeaders();
    }

    @Nullable
    public final T getResult() {
        return (T) this.f12518c;
    }

    public Uri getUri() {
        return this.f12516a.getLastOpenedUri();
    }

    public ParsingLoadable(DataSource dataSource, DataSpec dataSpec, int i, Parser<? extends T> parser) {
        this.f12516a = new StatsDataSource(dataSource);
        this.dataSpec = dataSpec;
        this.type = i;
        this.f12517b = parser;
        this.loadTaskId = LoadEventInfo.getNewId();
    }

    public static <T> T load(DataSource dataSource, Parser<? extends T> parser, DataSpec dataSpec, int i) {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, dataSpec, i, parser);
        parsingLoadable.load();
        return (T) Assertions.checkNotNull(parsingLoadable.getResult());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() {
        this.f12516a.resetBytesRead();
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f12516a, this.dataSpec);
        try {
            dataSourceInputStream.open();
            this.f12518c = this.f12517b.parse((Uri) Assertions.checkNotNull(this.f12516a.getUri()), dataSourceInputStream);
        } finally {
            Util.closeQuietly(dataSourceInputStream);
        }
    }
}
