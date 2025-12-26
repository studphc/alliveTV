package p000;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class y43 {

    /* renamed from: c */
    public static final Pattern f28839c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d */
    public static final Pattern f28840d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a */
    public final ParsableByteArray f28841a = new ParsableByteArray();

    /* renamed from: b */
    public final StringBuilder f28842b = new StringBuilder();

    /* renamed from: a */
    public static String m8217a(ParsableByteArray parsableByteArray, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit && !z) {
            char c = (char) parsableByteArray.getData()[position];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && ((c < '0' || c > '9') && c != '#' && c != '-' && c != '.' && c != '_'))) {
                z = true;
            } else {
                position++;
                sb.append(c);
            }
        }
        parsableByteArray.skipBytes(position - parsableByteArray.getPosition());
        return sb.toString();
    }

    /* renamed from: b */
    public static String m8218b(ParsableByteArray parsableByteArray, StringBuilder sb) {
        m8219c(parsableByteArray);
        if (parsableByteArray.bytesLeft() == 0) {
            return null;
        }
        String m8217a = m8217a(parsableByteArray, sb);
        if (!"".equals(m8217a)) {
            return m8217a;
        }
        return "" + ((char) parsableByteArray.readUnsignedByte());
    }

    /* renamed from: c */
    public static void m8219c(ParsableByteArray parsableByteArray) {
        while (true) {
            for (boolean z = true; parsableByteArray.bytesLeft() > 0 && z; z = false) {
                char c = (char) parsableByteArray.getData()[parsableByteArray.getPosition()];
                if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                    int position = parsableByteArray.getPosition();
                    int limit = parsableByteArray.limit();
                    byte[] data = parsableByteArray.getData();
                    int i = position + 2;
                    if (i <= limit) {
                        int i2 = position + 1;
                        if (data[position] == 47 && data[i2] == 42) {
                            while (true) {
                                int i3 = i + 1;
                                if (i3 >= limit) {
                                    break;
                                }
                                if (((char) data[i]) == '*' && ((char) data[i3]) == '/') {
                                    i += 2;
                                    limit = i;
                                } else {
                                    i = i3;
                                }
                            }
                            parsableByteArray.skipBytes(limit - parsableByteArray.getPosition());
                        }
                    }
                } else {
                    parsableByteArray.skipBytes(1);
                }
            }
            return;
        }
    }
}
