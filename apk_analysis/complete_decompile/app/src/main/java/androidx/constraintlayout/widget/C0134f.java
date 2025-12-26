package androidx.constraintlayout.widget;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import java.io.Writer;
import java.util.HashMap;
import p000.AbstractC1726qj;

/* renamed from: androidx.constraintlayout.widget.f */
/* loaded from: classes.dex */
public final class C0134f {

    /* renamed from: a */
    public Writer f3245a;

    /* renamed from: b */
    public Context f3246b;

    /* renamed from: c */
    public int f3247c;

    /* renamed from: d */
    public HashMap f3248d;

    /* renamed from: a */
    public final String m670a(int i) {
        String sb;
        HashMap hashMap = this.f3248d;
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return AbstractC1726qj.m7061q(new StringBuilder("'"), (String) hashMap.get(Integer.valueOf(i)), "'");
        }
        if (i == 0) {
            return "'parent'";
        }
        try {
            if (i != -1) {
                sb = this.f3246b.getResources().getResourceEntryName(i);
            } else {
                StringBuilder sb2 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
                int i2 = this.f3247c + 1;
                this.f3247c = i2;
                sb2.append(i2);
                sb = sb2.toString();
            }
        } catch (Exception unused) {
            StringBuilder sb3 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
            int i3 = this.f3247c + 1;
            this.f3247c = i3;
            sb3.append(i3);
            sb = sb3.toString();
        }
        hashMap.put(Integer.valueOf(i), sb);
        return "'" + sb + "'";
    }

    /* renamed from: b */
    public final void m671b(int i, String str, String str2, int i2) {
        if (i == -1) {
            return;
        }
        String concat = "       ".concat(str);
        Writer writer = this.f3245a;
        writer.write(concat);
        writer.write(":[");
        writer.write(m670a(i));
        writer.write(" , ");
        writer.write(str2);
        if (i2 != 0) {
            writer.write(" , " + i2);
        }
        writer.write("],\n");
    }

    /* renamed from: c */
    public final void m672c(String str, int i, int i2, float f, int i3, int i4) {
        Writer writer = this.f3245a;
        if (i == 0) {
            if (i4 == -1 && i3 == -1) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        writer.write("       " + str + ": '" + f + "%',\n");
                        return;
                    }
                    return;
                }
                writer.write("       " + str + ": '???????????',\n");
                return;
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        writer.write("       " + str + ": {'" + f + "'% ," + i3 + ", " + i4 + "}\n");
                        return;
                    }
                    return;
                }
                writer.write("       " + str + ": {'wrap' ," + i3 + ", " + i4 + "}\n");
                return;
            }
            writer.write("       " + str + ": {'spread' ," + i3 + ", " + i4 + "}\n");
            return;
        }
        if (i == -2) {
            writer.write("       " + str + ": 'wrap'\n");
            return;
        }
        if (i == -1) {
            writer.write("       " + str + ": 'parent'\n");
            return;
        }
        writer.write("       " + str + ": " + i + ",\n");
    }

    /* renamed from: d */
    public final void m673d(int i, String str) {
        if (i != 0 && i != -1) {
            String concat = "       ".concat(str);
            Writer writer = this.f3245a;
            writer.write(concat);
            writer.write(":");
            writer.write(", " + i);
            writer.write("\n");
        }
    }

    /* renamed from: e */
    public final void m674e(String str, float f) {
        if (f == -1.0f) {
            return;
        }
        String concat = "       ".concat(str);
        Writer writer = this.f3245a;
        writer.write(concat);
        writer.write(": " + f);
        writer.write(",\n");
    }

    /* renamed from: f */
    public final void m675f(String str, String str2) {
        if (str2 == null) {
            return;
        }
        String concat = "       ".concat(str);
        Writer writer = this.f3245a;
        writer.write(concat);
        writer.write(":");
        writer.write(", ".concat(str2));
        writer.write("\n");
    }

    /* renamed from: g */
    public final void m676g(String str, float f) {
        if (f == 0.5f) {
            return;
        }
        String concat = "       ".concat(str);
        Writer writer = this.f3245a;
        writer.write(concat);
        writer.write(": " + f);
        writer.write(",\n");
    }
}
