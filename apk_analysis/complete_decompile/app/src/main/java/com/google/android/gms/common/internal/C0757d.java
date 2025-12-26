package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* renamed from: com.google.android.gms.common.internal.d */
/* loaded from: classes.dex */
public final class C0757d implements PendingResultUtil.ResultConverter {

    /* renamed from: a */
    public final /* synthetic */ Response f13481a;

    public C0757d(Response response) {
        this.f13481a = response;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* bridge */ /* synthetic */ Object convert(Result result) {
        Response response = this.f13481a;
        response.setResult(result);
        return response;
    }
}
