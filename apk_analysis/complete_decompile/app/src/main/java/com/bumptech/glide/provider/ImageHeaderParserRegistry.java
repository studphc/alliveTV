package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ImageHeaderParserRegistry {

    /* renamed from: a */
    public final ArrayList f8999a = new ArrayList();

    public synchronized void add(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f8999a.add(imageHeaderParser);
    }

    @NonNull
    public synchronized List<ImageHeaderParser> getParsers() {
        return this.f8999a;
    }
}
