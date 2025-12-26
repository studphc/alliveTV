package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Map;

/* loaded from: classes.dex */
public interface Headers {

    @Deprecated
    public static final Headers NONE = new Object();
    public static final Headers DEFAULT = new LazyHeaders.Builder().build();

    Map<String, String> getHeaders();
}
