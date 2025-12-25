package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class MailTo {
    public static final String MAILTO_SCHEME = "mailto:";

    /* renamed from: a */
    public HashMap f3703a;

    public static boolean isMailTo(@Nullable String str) {
        return str != null && str.startsWith(MAILTO_SCHEME);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, androidx.core.net.MailTo] */
    @NonNull
    public static MailTo parse(@NonNull String str) {
        String decode;
        String substring;
        Preconditions.checkNotNull(str);
        if (isMailTo(str)) {
            int indexOf = str.indexOf(35);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf(63);
            if (indexOf2 == -1) {
                decode = Uri.decode(str.substring(7));
                substring = null;
            } else {
                decode = Uri.decode(str.substring(7, indexOf2));
                substring = str.substring(indexOf2 + 1);
            }
            ?? obj = new Object();
            obj.f3703a = new HashMap();
            if (substring != null) {
                for (String str2 : substring.split("&")) {
                    String[] split = str2.split("=", 2);
                    if (split.length != 0) {
                        obj.f3703a.put(Uri.decode(split[0]).toLowerCase(Locale.ROOT), split.length > 1 ? Uri.decode(split[1]) : null);
                    }
                }
            }
            String to = obj.getTo();
            if (to != null) {
                decode = AbstractC1726qj.m7058n(decode, ", ", to);
            }
            obj.f3703a.put(TypedValues.TransitionType.S_TO, decode);
            return obj;
        }
        throw new ParseException();
    }

    @Nullable
    public String getBcc() {
        return (String) this.f3703a.get("bcc");
    }

    @Nullable
    public String getBody() {
        return (String) this.f3703a.get("body");
    }

    @Nullable
    public String getCc() {
        return (String) this.f3703a.get("cc");
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.f3703a;
    }

    @Nullable
    public String getSubject() {
        return (String) this.f3703a.get("subject");
    }

    @Nullable
    public String getTo() {
        return (String) this.f3703a.get(TypedValues.TransitionType.S_TO);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("mailto:?");
        for (Map.Entry entry : this.f3703a.entrySet()) {
            sb.append(Uri.encode((String) entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode((String) entry.getValue()));
            sb.append(Typography.amp);
        }
        return sb.toString();
    }

    public static boolean isMailTo(@Nullable Uri uri) {
        return uri != null && "mailto".equals(uri.getScheme());
    }

    @NonNull
    public static MailTo parse(@NonNull Uri uri) {
        return parse(uri.toString());
    }
}
