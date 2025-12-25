package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public class Response<T extends Result> {

    /* renamed from: a */
    public Result f13068a;

    public Response() {
    }

    @NonNull
    public T getResult() {
        return (T) this.f13068a;
    }

    public void setResult(@NonNull T t) {
        this.f13068a = t;
    }

    public Response(@NonNull T t) {
        this.f13068a = t;
    }
}
