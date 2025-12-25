package p000;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class j41 implements k41 {

    /* renamed from: a */
    public final InputContentInfo f20369a;

    public j41(Object obj) {
        this.f20369a = (InputContentInfo) obj;
    }

    @Override // p000.k41
    /* renamed from: a */
    public final Uri mo5386a() {
        return this.f20369a.getLinkUri();
    }

    @Override // p000.k41
    /* renamed from: b */
    public final Uri mo5387b() {
        return this.f20369a.getContentUri();
    }

    @Override // p000.k41
    /* renamed from: c */
    public final void mo5388c() {
        this.f20369a.requestPermission();
    }

    @Override // p000.k41
    /* renamed from: d */
    public final ClipDescription mo5389d() {
        return this.f20369a.getDescription();
    }

    @Override // p000.k41
    /* renamed from: e */
    public final Object mo5390e() {
        return this.f20369a;
    }

    @Override // p000.k41
    /* renamed from: f */
    public final void mo5391f() {
        this.f20369a.releasePermission();
    }

    public j41(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f20369a = new InputContentInfo(uri, clipDescription, uri2);
    }
}
