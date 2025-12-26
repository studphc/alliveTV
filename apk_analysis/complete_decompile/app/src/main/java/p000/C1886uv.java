package p000;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: uv */
/* loaded from: classes.dex */
public final class C1886uv implements InterfaceC1849tv, InterfaceC1923vv {

    /* renamed from: a */
    public final /* synthetic */ int f27459a = 0;

    /* renamed from: b */
    public ClipData f27460b;

    /* renamed from: c */
    public int f27461c;

    /* renamed from: d */
    public int f27462d;

    /* renamed from: e */
    public Uri f27463e;

    /* renamed from: f */
    public Bundle f27464f;

    public /* synthetic */ C1886uv() {
    }

    @Override // p000.InterfaceC1923vv
    /* renamed from: a */
    public Uri mo1984a() {
        return this.f27463e;
    }

    @Override // p000.InterfaceC1923vv
    /* renamed from: b */
    public ClipData mo1985b() {
        return this.f27460b;
    }

    @Override // p000.InterfaceC1849tv
    public ContentInfoCompat build() {
        return new ContentInfoCompat(new C1886uv(this));
    }

    @Override // p000.InterfaceC1849tv
    /* renamed from: c */
    public void mo1986c(int i) {
        this.f27461c = i;
    }

    @Override // p000.InterfaceC1849tv
    /* renamed from: e */
    public void mo1988e(Uri uri) {
        this.f27463e = uri;
    }

    @Override // p000.InterfaceC1849tv
    /* renamed from: f */
    public void mo1989f(ClipData clipData) {
        this.f27460b = clipData;
    }

    @Override // p000.InterfaceC1923vv
    public Bundle getExtras() {
        return this.f27464f;
    }

    @Override // p000.InterfaceC1923vv
    public int getFlags() {
        return this.f27462d;
    }

    @Override // p000.InterfaceC1923vv
    /* renamed from: j */
    public ContentInfo mo1993j() {
        return null;
    }

    @Override // p000.InterfaceC1923vv
    /* renamed from: l */
    public int mo1995l() {
        return this.f27461c;
    }

    @Override // p000.InterfaceC1849tv
    public void setExtras(Bundle bundle) {
        this.f27464f = bundle;
    }

    @Override // p000.InterfaceC1849tv
    public void setFlags(int i) {
        this.f27462d = i;
    }

    public String toString() {
        String str;
        String valueOf;
        String str2;
        switch (this.f27459a) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.f27460b.getDescription());
                sb.append(", source=");
                int i = this.f27461c;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    if (i != 5) {
                                        str = String.valueOf(i);
                                    } else {
                                        str = "SOURCE_PROCESS_TEXT";
                                    }
                                } else {
                                    str = "SOURCE_AUTOFILL";
                                }
                            } else {
                                str = "SOURCE_DRAG_AND_DROP";
                            }
                        } else {
                            str = "SOURCE_INPUT_METHOD";
                        }
                    } else {
                        str = "SOURCE_CLIPBOARD";
                    }
                } else {
                    str = "SOURCE_APP";
                }
                sb.append(str);
                sb.append(", flags=");
                int i2 = this.f27462d;
                if ((i2 & 1) != 0) {
                    valueOf = "FLAG_CONVERT_TO_PLAIN_TEXT";
                } else {
                    valueOf = String.valueOf(i2);
                }
                sb.append(valueOf);
                String str3 = "";
                Uri uri = this.f27463e;
                if (uri == null) {
                    str2 = "";
                } else {
                    str2 = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str2);
                if (this.f27464f != null) {
                    str3 = ", hasExtras";
                }
                return AbstractC1726qj.m7061q(sb, str3, "}");
            default:
                return super.toString();
        }
    }

    public C1886uv(C1886uv c1886uv) {
        this.f27460b = (ClipData) Preconditions.checkNotNull(c1886uv.f27460b);
        this.f27461c = Preconditions.checkArgumentInRange(c1886uv.f27461c, 0, 5, FirebaseAnalytics.Param.SOURCE);
        this.f27462d = Preconditions.checkFlagsArgument(c1886uv.f27462d, 1);
        this.f27463e = c1886uv.f27463e;
        this.f27464f = c1886uv.f27464f;
    }
}
