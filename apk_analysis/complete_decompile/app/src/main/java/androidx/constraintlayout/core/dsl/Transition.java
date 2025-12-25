package androidx.constraintlayout.core.dsl;

import androidx.recyclerview.widget.RecyclerView;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public class Transition {

    /* renamed from: b */
    public String f2038b;

    /* renamed from: c */
    public String f2039c;

    /* renamed from: d */
    public String f2040d;

    /* renamed from: a */
    public OnSwipe f2037a = null;

    /* renamed from: e */
    public int f2041e = HttpStatusCodesKt.HTTP_BAD_REQUEST;

    /* renamed from: f */
    public float f2042f = RecyclerView.f7068F0;

    /* renamed from: g */
    public final KeyFrames f2043g = new KeyFrames();

    public Transition(String str, String str2) {
        this.f2038b = null;
        this.f2039c = null;
        this.f2040d = null;
        this.f2038b = "default";
        this.f2040d = str;
        this.f2039c = str2;
    }

    public String getId() {
        return this.f2038b;
    }

    public void setDuration(int i) {
        this.f2041e = i;
    }

    public void setFrom(String str) {
        this.f2040d = str;
    }

    public void setId(String str) {
        this.f2038b = str;
    }

    public void setKeyFrames(Keys keys) {
        this.f2043g.add(keys);
    }

    public void setOnSwipe(OnSwipe onSwipe) {
        this.f2037a = onSwipe;
    }

    public void setStagger(float f) {
        this.f2042f = f;
    }

    public void setTo(String str) {
        this.f2039c = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2038b);
        sb.append(":{\nfrom:'");
        sb.append(this.f2040d);
        sb.append("',\nto:'");
        String m7061q = AbstractC1726qj.m7061q(sb, this.f2039c, "',\n");
        if (this.f2041e != 400) {
            m7061q = ye0.m8298r(ye0.m8303w(m7061q, "duration:"), ",\n", this.f2041e);
        }
        if (this.f2042f != RecyclerView.f7068F0) {
            StringBuilder m8303w = ye0.m8303w(m7061q, "stagger:");
            m8303w.append(this.f2042f);
            m8303w.append(",\n");
            m7061q = m8303w.toString();
        }
        if (this.f2037a != null) {
            StringBuilder m7064t = AbstractC1726qj.m7064t(m7061q);
            m7064t.append(this.f2037a.toString());
            m7061q = m7064t.toString();
        }
        StringBuilder m7064t2 = AbstractC1726qj.m7064t(m7061q);
        m7064t2.append(this.f2043g.toString());
        return AbstractC1726qj.m7057m(m7064t2.toString(), "},\n");
    }

    public Transition(String str, String str2, String str3) {
        this.f2038b = null;
        this.f2039c = null;
        this.f2040d = null;
        this.f2038b = str;
        this.f2040d = str2;
        this.f2039c = str3;
    }
}
