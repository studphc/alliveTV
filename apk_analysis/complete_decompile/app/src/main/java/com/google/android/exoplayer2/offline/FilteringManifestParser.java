package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
public final class FilteringManifestParser<T extends FilterableManifest<T>> implements ParsingLoadable.Parser<T> {

    /* renamed from: a */
    public final ParsingLoadable.Parser f10830a;

    /* renamed from: b */
    public final List f10831b;

    public FilteringManifestParser(ParsingLoadable.Parser<? extends T> parser, @Nullable List<StreamKey> list) {
        this.f10830a = parser;
        this.f10831b = list;
    }

    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public T parse(Uri uri, InputStream inputStream) {
        T t = (T) this.f10830a.parse(uri, inputStream);
        List<StreamKey> list = this.f10831b;
        return (list == null || list.isEmpty()) ? t : (T) t.copy(list);
    }
}
