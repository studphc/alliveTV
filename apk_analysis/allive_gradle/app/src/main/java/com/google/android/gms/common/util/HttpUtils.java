package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.exoplayer2.C0643C;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzaa;
import com.google.android.gms.internal.common.zzr;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.Typography;

@KeepForSdk
/* loaded from: classes.dex */
public class HttpUtils {
    static {
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.HashMap] */
    @NonNull
    @KeepForSdk
    public static Map<String, String> parse(@NonNull URI uri, @NonNull String str) {
        String str2;
        String str3;
        ?? emptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            emptyMap = new HashMap();
            zzaa zzc = zzaa.zzc(zzr.zzb('='));
            Iterator it = zzaa.zzc(zzr.zzb(Typography.amp)).zzb().zzd(rawQuery).iterator();
            while (it.hasNext()) {
                List zzf = zzc.zzf((String) it.next());
                if (!zzf.isEmpty() && zzf.size() <= 2) {
                    String str4 = (String) zzf.get(0);
                    String str5 = C0643C.ISO88591_NAME;
                    if (str == null) {
                        str2 = C0643C.ISO88591_NAME;
                    } else {
                        str2 = str;
                    }
                    try {
                        String decode = URLDecoder.decode(str4, str2);
                        if (zzf.size() == 2) {
                            String str6 = (String) zzf.get(1);
                            if (str != null) {
                                str5 = str;
                            }
                            try {
                                str3 = URLDecoder.decode(str6, str5);
                            } catch (UnsupportedEncodingException e) {
                                throw new IllegalArgumentException(e);
                            }
                        } else {
                            str3 = null;
                        }
                        emptyMap.put(decode, str3);
                    } catch (UnsupportedEncodingException e2) {
                        throw new IllegalArgumentException(e2);
                    }
                } else {
                    throw new IllegalArgumentException("bad parameter");
                }
            }
        }
        return emptyMap;
    }
}
