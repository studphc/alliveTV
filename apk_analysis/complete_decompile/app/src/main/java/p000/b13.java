package p000;

import com.google.android.exoplayer2.C0643C;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class b13 {

    /* renamed from: a */
    public static final Charset f7854a = Charset.forName(C0643C.ASCII_NAME);

    /* renamed from: b */
    public static final Charset f7855b = Charset.forName("UTF-8");

    /* renamed from: a */
    public static void m2004a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m2004a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}
