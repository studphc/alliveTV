package p000;

import android.content.Intent;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class r41 {
    @DoNotInline
    /* renamed from: a */
    public static String m7217a(Intent intent) {
        return intent.getIdentifier();
    }

    @DoNotInline
    /* renamed from: b */
    public static Intent m7218b(Intent intent, String str) {
        return intent.setIdentifier(str);
    }
}
