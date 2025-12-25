package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.BufferedOutputStream;

/* renamed from: com.hisona.allive.d */
/* loaded from: classes2.dex */
public final class C1070d extends HttpRequest.CloseOperation {

    /* renamed from: c */
    public final /* synthetic */ BufferedOutputStream f15981c;

    /* renamed from: d */
    public final /* synthetic */ HttpRequest f15982d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1070d(HttpRequest httpRequest, BufferedOutputStream bufferedOutputStream, boolean z, BufferedOutputStream bufferedOutputStream2) {
        super(bufferedOutputStream, z);
        this.f15982d = httpRequest;
        this.f15981c = bufferedOutputStream2;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        return this.f15982d.receive(this.f15981c);
    }
}
