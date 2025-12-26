package p000;

import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class qc0 {

    /* renamed from: a */
    public final String f25512a;

    /* renamed from: b */
    public final HashMap f25513b = new HashMap();

    public qc0(String str) {
        this.f25512a = str;
    }

    /* renamed from: a */
    public static boolean m7024a(String str, String str2) {
        String m800a = FileProvider.m800a(str);
        String m800a2 = FileProvider.m800a(str2);
        if (!m800a.equals(m800a2)) {
            if (!m800a.startsWith(m800a2 + '/')) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public final File m7025b(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int indexOf = encodedPath.indexOf(47, 1);
        String decode = Uri.decode(encodedPath.substring(1, indexOf));
        String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
        File file = (File) this.f25513b.get(decode);
        if (file != null) {
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (m7024a(canonicalFile.getPath(), file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
        throw new IllegalArgumentException("Unable to find configured root for " + uri);
    }
}
