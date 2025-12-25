package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import p000.C1255h3;

/* loaded from: classes.dex */
public interface ExtractorsFactory {
    public static final ExtractorsFactory EMPTY = new C1255h3(27);

    Extractor[] createExtractors();

    Extractor[] createExtractors(Uri uri, Map<String, List<String>> map);
}
