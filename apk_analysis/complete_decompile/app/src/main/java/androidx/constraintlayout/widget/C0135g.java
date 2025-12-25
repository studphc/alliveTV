package androidx.constraintlayout.widget;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import java.io.Writer;
import java.util.HashMap;
import p000.AbstractC1726qj;

/* renamed from: androidx.constraintlayout.widget.g */
/* loaded from: classes.dex */
public final class C0135g {

    /* renamed from: a */
    public Writer f3249a;

    /* renamed from: b */
    public Context f3250b;

    /* renamed from: c */
    public int f3251c;

    /* renamed from: d */
    public HashMap f3252d;

    /* renamed from: a */
    public final String m677a(int i) {
        String sb;
        HashMap hashMap = this.f3252d;
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return AbstractC1726qj.m7061q(new StringBuilder("@+id/"), (String) hashMap.get(Integer.valueOf(i)), "");
        }
        if (i == 0) {
            return "parent";
        }
        try {
            if (i != -1) {
                sb = this.f3250b.getResources().getResourceEntryName(i);
            } else {
                StringBuilder sb2 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
                int i2 = this.f3251c + 1;
                this.f3251c = i2;
                sb2.append(i2);
                sb = sb2.toString();
            }
        } catch (Exception unused) {
            StringBuilder sb3 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
            int i3 = this.f3251c + 1;
            this.f3251c = i3;
            sb3.append(i3);
            sb = sb3.toString();
        }
        hashMap.put(Integer.valueOf(i), sb);
        return "@+id/" + sb + "";
    }

    /* renamed from: b */
    public final void m678b(int i, String str) {
        if (i != -5) {
            Writer writer = this.f3249a;
            if (i == -2) {
                writer.write("\n       " + str + "=\"wrap_content\"");
                return;
            }
            if (i == -1) {
                writer.write("\n       " + str + "=\"match_parent\"");
                return;
            }
            writer.write("\n       " + str + "=\"" + i + "dp\"");
        }
    }

    /* renamed from: c */
    public final void m679c(String str, boolean z, boolean z2) {
        if (z != z2) {
            this.f3249a.write("\n       " + str + "=\"" + z + "dp\"");
        }
    }

    /* renamed from: d */
    public final void m680d(int i, int i2, String str) {
        if (i != i2) {
            this.f3249a.write("\n       " + str + "=\"" + i + "dp\"");
        }
    }

    /* renamed from: e */
    public final void m681e(String str, int i, String[] strArr, int i2) {
        if (i != i2) {
            this.f3249a.write(AbstractC1726qj.m7061q(AbstractC1726qj.m7065u("\n       ", str, "=\""), strArr[i], "\""));
        }
    }

    /* renamed from: f */
    public final void m682f(int i, String str) {
        if (i != 0 && i != -1) {
            this.f3249a.write("\n       " + str + "=\"" + i + "\"\n");
        }
    }

    /* renamed from: g */
    public final void m683g(String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        String concat = "\n       ".concat(str);
        Writer writer = this.f3249a;
        writer.write(concat);
        writer.write("=\"" + f + "\"");
    }

    /* renamed from: h */
    public final void m684h(String str, String str2) {
        if (str2 != null && !str2.equals(null)) {
            String concat = "\n       ".concat(str);
            Writer writer = this.f3249a;
            writer.write(concat);
            writer.write("=\"" + str2 + "\"");
        }
    }

    /* renamed from: i */
    public final void m685i(int i, String str) {
        if (i == -1) {
            return;
        }
        String concat = "\n       ".concat(str);
        Writer writer = this.f3249a;
        writer.write(concat);
        writer.write("=\"" + m677a(i) + "\"");
    }
}
