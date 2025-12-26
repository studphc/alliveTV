package p000;

import android.os.Environment;
import androidx.annotation.DoNotInline;
import java.io.File;

/* loaded from: classes.dex */
public abstract class u90 {
    @DoNotInline
    /* renamed from: a */
    public static String m7682a(File file) {
        return Environment.getExternalStorageState(file);
    }
}
