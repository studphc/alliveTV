package p000;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.common.base.Charsets;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: hy */
/* loaded from: classes.dex */
public final class C1286hy implements ParsingLoadable.Parser {

    /* renamed from: a */
    public static final Pattern f18215a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public final Object parse(Uri uri, InputStream inputStream) {
        long j;
        long parseLong;
        String readLine = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8)).readLine();
        try {
            Matcher matcher = f18215a.matcher(readLine);
            if (matcher.matches()) {
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    if ("+".equals(matcher.group(4))) {
                        j = 1;
                    } else {
                        j = -1;
                    }
                    long parseLong2 = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    if (TextUtils.isEmpty(group2)) {
                        parseLong = 0;
                    } else {
                        parseLong = Long.parseLong(group2);
                    }
                    time -= (((parseLong2 * 60) + parseLong) * 60000) * j;
                }
                return Long.valueOf(time);
            }
            throw ParserException.createForMalformedManifest("Couldn't parse timestamp: " + readLine, null);
        } catch (ParseException e) {
            throw ParserException.createForMalformedManifest(null, e);
        }
    }
}
