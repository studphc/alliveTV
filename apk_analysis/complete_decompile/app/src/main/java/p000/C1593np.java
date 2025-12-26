package p000;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import com.google.common.reflect.ClassPath;
import java.util.Map;

/* renamed from: np */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1593np implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ int f23443a;

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        switch (this.f23443a) {
            case 0:
                return ((ClassPath.ClassInfo) obj).isTopLevel();
            case 1:
                if (((String) obj) != null) {
                    return true;
                }
                return false;
            case 2:
                if (((Map.Entry) obj).getKey() != null) {
                    return true;
                }
                return false;
            case 3:
                String str = (String) obj;
                if (str == null) {
                    return false;
                }
                String lowerCase = Ascii.toLowerCase(str);
                if (TextUtils.isEmpty(lowerCase)) {
                    return false;
                }
                if ((lowerCase.contains(MimeTypes.BASE_TYPE_TEXT) && !lowerCase.contains(MimeTypes.TEXT_VTT)) || lowerCase.contains("html") || lowerCase.contains("xml")) {
                    return false;
                }
                return true;
            default:
                return ((Class) obj).isInterface();
        }
    }
}
