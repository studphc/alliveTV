package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: classes.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final int f8624a;

    public HttpException(int i) {
        this("Http request failed", i);
    }

    public int getStatusCode() {
        return this.f8624a;
    }

    @Deprecated
    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i) {
        this(str, i, null);
    }

    public HttpException(String str, int i, @Nullable Throwable th) {
        super(str + ", status code: " + i, th);
        this.f8624a = i;
    }
}
