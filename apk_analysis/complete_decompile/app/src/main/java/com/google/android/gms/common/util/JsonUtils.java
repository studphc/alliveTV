package com.google.android.gms.common.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000.xa3;

@KeepForSdk
/* loaded from: classes.dex */
public final class JsonUtils {

    /* renamed from: a */
    public static final Pattern f13652a = Pattern.compile("\\\\.");

    /* renamed from: b */
    public static final Pattern f13653b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    @KeepForSdk
    public static boolean areJsonValuesEquivalent(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject2.has(next)) {
                    try {
                        Preconditions.checkNotNull(next);
                        if (!areJsonValuesEquivalent(jSONObject.get(next), jSONObject2.get(next))) {
                        }
                    } catch (JSONException unused) {
                    }
                }
                return false;
            }
            return true;
        }
        if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
            JSONArray jSONArray = (JSONArray) obj;
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (jSONArray.length() != jSONArray2.length()) {
                return false;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!areJsonValuesEquivalent(jSONArray.get(i), jSONArray2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return obj.equals(obj2);
    }

    @Nullable
    @KeepForSdk
    public static String escapeString(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = f13653b.matcher(str);
            StringBuffer stringBuffer = null;
            while (matcher.find()) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                char charAt = matcher.group().charAt(0);
                if (charAt != '\f') {
                    if (charAt != '\r') {
                        if (charAt != '\"') {
                            if (charAt != '/') {
                                if (charAt != '\\') {
                                    switch (charAt) {
                                        case '\b':
                                            matcher.appendReplacement(stringBuffer, "\\\\b");
                                            break;
                                        case '\t':
                                            matcher.appendReplacement(stringBuffer, "\\\\t");
                                            break;
                                        case '\n':
                                            matcher.appendReplacement(stringBuffer, "\\\\n");
                                            break;
                                    }
                                } else {
                                    matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                                }
                            } else {
                                matcher.appendReplacement(stringBuffer, "\\\\/");
                            }
                        } else {
                            matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                        }
                    } else {
                        matcher.appendReplacement(stringBuffer, "\\\\r");
                    }
                } else {
                    matcher.appendReplacement(stringBuffer, "\\\\f");
                }
            }
            if (stringBuffer != null) {
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            }
            return str;
        }
        return str;
    }

    @NonNull
    @KeepForSdk
    public static String unescapeString(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            Pattern pattern = xa3.f28491a;
            StringBuffer stringBuffer = null;
            if (!TextUtils.isEmpty(str)) {
                Matcher matcher = xa3.f28491a.matcher(str);
                int i = 0;
                StringBuilder sb = null;
                while (matcher.find()) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    int start = matcher.start();
                    int i2 = start;
                    while (i2 >= 0 && str.charAt(i2) == '\\') {
                        i2--;
                    }
                    if ((start - i2) % 2 != 0) {
                        int parseInt = Integer.parseInt(matcher.group().substring(2), 16);
                        sb.append((CharSequence) str, i, matcher.start());
                        if (parseInt == 92) {
                            sb.append("\\\\");
                        } else {
                            sb.append(Character.toChars(parseInt));
                        }
                        i = matcher.end();
                    }
                }
                if (sb != null) {
                    if (i < matcher.regionEnd()) {
                        sb.append((CharSequence) str, i, matcher.regionEnd());
                    }
                    str = sb.toString();
                }
            }
            Matcher matcher2 = f13652a.matcher(str);
            while (matcher2.find()) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                char charAt = matcher2.group().charAt(1);
                if (charAt != '\"') {
                    if (charAt != '/') {
                        if (charAt != '\\') {
                            if (charAt != 'b') {
                                if (charAt != 'f') {
                                    if (charAt != 'n') {
                                        if (charAt != 'r') {
                                            if (charAt == 't') {
                                                matcher2.appendReplacement(stringBuffer, "\t");
                                            } else {
                                                throw new IllegalStateException("Found an escaped character that should never be.");
                                            }
                                        } else {
                                            matcher2.appendReplacement(stringBuffer, "\r");
                                        }
                                    } else {
                                        matcher2.appendReplacement(stringBuffer, "\n");
                                    }
                                } else {
                                    matcher2.appendReplacement(stringBuffer, "\f");
                                }
                            } else {
                                matcher2.appendReplacement(stringBuffer, "\b");
                            }
                        } else {
                            matcher2.appendReplacement(stringBuffer, "\\\\");
                        }
                    } else {
                        matcher2.appendReplacement(stringBuffer, "/");
                    }
                } else {
                    matcher2.appendReplacement(stringBuffer, "\"");
                }
            }
            if (stringBuffer == null) {
                return str;
            }
            matcher2.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
        return str;
    }
}
