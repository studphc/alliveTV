package p000;

import android.content.pm.ShortcutInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class di2 {
    /* renamed from: a */
    public static String m4586a(List list) {
        Iterator it = list.iterator();
        int i = -1;
        String str = null;
        while (it.hasNext()) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) it.next();
            if (shortcutInfo.getRank() > i) {
                str = shortcutInfo.getId();
                i = shortcutInfo.getRank();
            }
        }
        return str;
    }
}
